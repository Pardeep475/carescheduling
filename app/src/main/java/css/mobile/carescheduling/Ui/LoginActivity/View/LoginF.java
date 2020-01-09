package css.mobile.carescheduling.Ui.LoginActivity.View;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;


import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import css.mobile.carescheduling.R;
import css.mobile.carescheduling.Ui.Base.BaseFragment;
import css.mobile.carescheduling.Ui.Dashboard.view.Dashboard;
import css.mobile.carescheduling.Ui.LoginActivity.ViewModal.LoginViewModel;
import css.mobile.carescheduling.Ui.LoginActivity.beans.LoginBeanData;
import css.mobile.carescheduling.Ui.LoginActivity.beans.LoginBeanRetro;
import css.mobile.carescheduling.Ui.LoginActivity.presenter.LoginPresenter;
import css.mobile.carescheduling.Ui.Profile.bean.ProfileAllData;
import css.mobile.carescheduling.Utils.ConnectivityReceiver;
import css.mobile.carescheduling.Utils.FullScreenDialog;
import css.mobile.carescheduling.data.Local.SessionManager;
import css.mobile.carescheduling.databinding.FragmentLoginBinding;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;


public class LoginF extends BaseFragment implements LoginPresenter {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String TAG = "LoginF";
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Handler handler;

    private FullScreenDialog fullScreenDialog;


    // TODO: data binding
    private FragmentLoginBinding fragmentLoginBinding;

    public LoginViewModel loginViewModel;
    private SessionManager sessionManager;

    public LoginF() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static LoginF newInstance() {

        return new LoginF();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//         Inflate the layout for this fragment
        fragmentLoginBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);
        View view = fragmentLoginBinding.getRoot();
        setUpLayout(view);
        return view;
//        return inflater.inflate( R.layout.fragment_login,container,false);
    }


    private void setUpLayout(View view) {
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
//        LoginBeanData loginBeanData = new LoginBeanData("testuser@betterhealthcare.co.uk", "test");
        fullScreenDialog = new FullScreenDialog();
        if (getActivity() != null)
            sessionManager = new SessionManager(getActivity());

        if (sessionManager != null && sessionManager.getUserName() != null && sessionManager.getPassword() != null) {

            LoginBeanData loginBeanData = new LoginBeanData(sessionManager.getUserName(), sessionManager.getPassword());
//          LoginBeanData loginBeanData = new LoginBeanData("pardeep@felagi.in", "pardeep");
            fragmentLoginBinding.setLoginBeanData(loginBeanData);
        }
        fragmentLoginBinding.setLoginPresenter(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    public void getUserData() {
        if (getActivity() != null) {
            try {
                if (ConnectivityReceiver.isNetworkAvailable(getActivity())) {
                    checkLogin();
                } else {
                    Toast.makeText(getActivity(), "please check your internet connection", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
                hideDialog();
            }
        }
    }

    private void checkLogin() {
        final String userEmail = fragmentLoginBinding.edtEmail.getText().toString();
        final String userPassword = fragmentLoginBinding.edtPassword.getText().toString();
        if (fragmentLoginBinding.cbRememberMe.isChecked()) {
            sessionManager.setUserName(userEmail);
            sessionManager.setPassword(userPassword);
        } else {
            sessionManager.setUserName(null);
            sessionManager.setPassword(null);
        }
        Log.e("SAVE_USER_DATA", "Login  " + sessionManager.getUserName() + "    " + sessionManager.getPassword());

        showDialog();

        // show it
//        progressDialog.show();
        LiveData<LoginBeanRetro> beanRetroLiveData = loginViewModel.getUserData(userEmail, userPassword);
        beanRetroLiveData.observe(this, new Observer<LoginBeanRetro>() {
            @Override
            public void onChanged(LoginBeanRetro loginBeanRetro) {
                hideDialog();
//                progressDialog.dismiss();

                getSessionManager().setOffline(fragmentLoginBinding.cbRememberMe.isChecked());
                if (loginBeanRetro != null && loginBeanRetro.getSuccess()) {
                    if (loginBeanRetro.getData().getBranchList().size() == 1) {
                        getSessionManager().setBranchId(loginBeanRetro.getData().getBranchList().get(0).getBranchId());
                        getSessionManager().setPersonId(loginBeanRetro.getData().getPersonId());
                        getSessionManager().setCustomerId(loginBeanRetro.getData().getCustomerId());
                        getSessionManager().setUserLogin(fragmentLoginBinding.cbRememberMe.isChecked());
                        setAllProfileData();
                    } else if (loginBeanRetro.getData().getBranchList().size() > 1) {
                        getSessionManager().setCurrentPassword(fragmentLoginBinding.edtPassword.getText().toString());
                        goToLoginFSecond(userEmail, userPassword, loginBeanRetro.getData(), fragmentLoginBinding.cbRememberMe.isChecked());
                    } else {
                        showAToast("Branch not found");
                    }
                } else {
                    if (loginBeanRetro != null)
                        Toast.makeText(getActivity(), loginBeanRetro.getResponseMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    private void setAllProfileData() {
        handler = new Handler();
        if (getActivity() != null)
            fullScreenDialog.show(getActivity().getSupportFragmentManager(), "fullScreenDialog");

        loginViewModel.getPersonAllData(sessionManager.getPersonId(), sessionManager.getCustomerId()
                , sessionManager.getBranchId(), "Small").observe(this, new Observer<ProfileAllData>() {
            @Override
            public void onChanged(final ProfileAllData profileAllData) {
//                hideDialog();
//                handler.removeCallbacksAndMessages(null);
                fullScreenDialog.progressFull();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fullScreenDialog.dismiss();
                        if (profileAllData != null && getActivity() != null) {
                            loginViewModel.setDefaultData(getActivity(), profileAllData);

                        }
                    }
                }, 500);
            }
        });
    }


    private void setDashboard(LoginBeanRetro.Data dashboard) {
//    sessionManager.setBranchId(dashboard.getBranchId());
//    sessionManager.setPersonId(null);
//    sessionManager.setCustomerId(branchList.get(appCompatSpinner.getSelectedItemPosition()).getCustomerId());
        if (fragmentLoginBinding.cbRememberMe.isChecked())
            sessionManager.setUserLogin(true);
        else {
            sessionManager.setUserLogin(false);
        }
        Intent intent = new Intent(getActivity(), Dashboard.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    private void goToLoginFSecond(String email, String userPassword, LoginBeanRetro.Data data, boolean isRemamberMe) {
        if (getActivity() != null) {
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.rl_main_login, LoginFSecond.newInstance(email, userPassword, data, isRemamberMe)).commitAllowingStateLoss();
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        handler.removeCallbacksAndMessages(null);
    }

}
