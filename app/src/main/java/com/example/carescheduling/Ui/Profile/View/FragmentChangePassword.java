package com.example.carescheduling.Ui.Profile.View;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.Common.Common;
import com.example.carescheduling.Ui.Common.CommonBean;
import com.example.carescheduling.Ui.Dashboard.beans.ProfileBean;
import com.example.carescheduling.Ui.Dashboard.beans.ProfileResultBean;
import com.example.carescheduling.Ui.Profile.ViewModel.FragmentChangePasswordViewModel;
import com.example.carescheduling.Ui.Profile.bean.FragmentChangePasswordBean;
import com.example.carescheduling.Ui.Profile.bean.UserViewModel;
import com.example.carescheduling.Ui.Profile.presenter.EditEmailClick;
import com.example.carescheduling.Ui.Profile.presenter.FragmentChangePasswordClick;
import com.example.carescheduling.Utils.ConnectivityReceiver;
import com.example.carescheduling.Utils.Constants;
import com.example.carescheduling.data.Local.SessionManager;
import com.example.carescheduling.databinding.FragmentChangePasswordBinding;

import java.io.Serializable;

public class FragmentChangePassword extends BaseFragment implements Common, FragmentChangePasswordClick {
    private FragmentChangePasswordBinding fragmentChangePasswordBinding;
    private ProfileBean profileResultBean;
    private FragmentChangePasswordViewModel fragmentChangePasswordViewModel;
    private SessionManager sessionManager;
    private UserViewModel userModel;

    public static FragmentChangePassword newInstance(ProfileBean profileResultBean) {
        FragmentChangePassword fragmentChangePassword = new FragmentChangePassword();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constants.PROFILE_DATA, (Serializable) profileResultBean);
        fragmentChangePassword.setArguments(bundle);
        return fragmentChangePassword;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            profileResultBean = (ProfileBean) getArguments().getSerializable(Constants.PROFILE_DATA);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentChangePasswordBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_change_password, container, false);
        View view = fragmentChangePasswordBinding.getRoot();
        // Inflate the layout for this fragment
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {
        setCommonData();
        sessionManager = getSessionManager();
        fragmentChangePasswordViewModel = ViewModelProviders.of(this).get(FragmentChangePasswordViewModel.class);
        fragmentChangePasswordBinding.slDemo.startShimmerAnimation();
        GetUserInfoValid();

        fragmentChangePasswordBinding.setChangePasswordClick(this);
    }

    private void setCommonData() {
        CommonBean commonBean = new CommonBean();
        commonBean.setLeftImageDrawable(R.drawable.ic_left_back);
        commonBean.setLeftImageVisible(true);
        commonBean.setRightImageDrawable(R.drawable.ic_tick);
        commonBean.setRightImageVisible(false);
        commonBean.setRightTextVisible(true);
        commonBean.setTitle("Change Password");
        fragmentChangePasswordBinding.setCommonData(commonBean);
        fragmentChangePasswordBinding.setCommonClick(this);
    }

    private void GetUserInfoValid() {
        if (getActivity() != null) {
            try {
                if (ConnectivityReceiver.isNetworkAvailable(getActivity())) {
                        GetUserInfo();
                } else {
                    Toast.makeText(getActivity(), "please check your internet connection", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                setNoDataFound();
            }
        }
    }

    @Override
    public void CheckUserName() {
        if (getActivity() != null) {
            try {
                if (ConnectivityReceiver.isNetworkAvailable(getActivity())) {
                    checkIfUserNameValid();
                } else {
                    Toast.makeText(getActivity(), "please check your internet connection", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
                hideDialog();
            }
        }
    }

    private void checkIfUserNameValid() {
        if (checkValidation()) {
            showDialog();
            fragmentChangePasswordViewModel.checkUserName(fragmentChangePasswordBinding.edtUserName.getText().toString(),
                    sessionManager.getCustomerId(), sessionManager.getPersonId(), sessionManager.getBranchId()).observe(this
                    , new Observer<Boolean>() {
                        @Override
                        public void onChanged(Boolean aBoolean) {
                            hideDialog();
                            if (aBoolean) {
                                Toast.makeText(getActivity(), "User name saved successfully", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getActivity(), "This user name is already exist", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

    private boolean checkValidation() {
        try {
            if (TextUtils.isEmpty(fragmentChangePasswordBinding.edtUserName.getText())) {
                Toast.makeText(getActivity(), "Please provide user name", Toast.LENGTH_SHORT).show();
                return false;
            } else if (userModel.getData() == null) {
                Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_SHORT).show();
                return false;
            } else if (userModel.getData().getUserPersons().get(0).getUser().getUserName().equalsIgnoreCase(fragmentChangePasswordBinding.edtUserName.getText().toString())) {
                Toast.makeText(getActivity(), "This user name is already exist", Toast.LENGTH_SHORT).show();
                return false;
            }
        } catch (Exception e) {
            Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void GetUserInfo() {
        fragmentChangePasswordViewModel.getUserInfo(sessionManager.getPersonId(), sessionManager.getBranchId()).observe(this
                , new Observer<UserViewModel>() {
                    @Override
                    public void onChanged(UserViewModel userViewModel) {
                        userModel = userViewModel;
                        if (userViewModel.getData() != null && userViewModel.getData().getUserPersons() != null && userViewModel.getData().getUserPersons().size() > 0) {
                            FragmentChangePasswordBean fragmentChangePasswordBean = new FragmentChangePasswordBean();
                            String userName = userViewModel.getData().getUserPersons().get(0).getUser().getUserName();
                            String passwordAns = (String) userViewModel.getData().getUserPersons().get(0).getUser().getPasswordQuestionAnswer();
                            String passwordQus = (String) userViewModel.getData().getUserPersons().get(0).getUser().getPasswordQuestion();
                            fragmentChangePasswordBean.setPasswordAns(passwordAns != null ? passwordAns : "");
                            fragmentChangePasswordBean.setUserName(userName != null ? userName : "");
                            fragmentChangePasswordBean.setPasswordQuestion(passwordQus != null ? passwordQus : "");

                            fragmentChangePasswordBinding.setFragmentChangePasswordBean(fragmentChangePasswordBean);
                            setDataOriginal();
                        } else {
                            setNoDataFound();
                        }
                    }
                });
    }


    private void setNoDataFound() {
        fragmentChangePasswordBinding.slDemo.stopShimmerAnimation();
        fragmentChangePasswordBinding.slDemo.setVisibility(View.GONE);
        fragmentChangePasswordBinding.llMainLayout.setVisibility(View.GONE);
        fragmentChangePasswordBinding.rlNoDataFound.setVisibility(View.VISIBLE);
    }

    private void setDataOriginal() {
        fragmentChangePasswordBinding.slDemo.stopShimmerAnimation();
        fragmentChangePasswordBinding.slDemo.setVisibility(View.GONE);
        fragmentChangePasswordBinding.llMainLayout.setVisibility(View.VISIBLE);
        fragmentChangePasswordBinding.rlNoDataFound.setVisibility(View.GONE);
    }




    private boolean checkValidationDone() {
        int counter = 0;
        if (!userModel.getData().getUserPersons().get(0).getUser().getUserName().equalsIgnoreCase(fragmentChangePasswordBinding.edtUserName.getText().toString())) {
            counter++;
        }
        if (userModel.getData().getUserPersons().get(0).getUser().getPasswordQuestion() != null
                && !userModel.getData().getUserPersons().get(0).getUser().getPasswordQuestion().equalsIgnoreCase(fragmentChangePasswordBinding.edtUserName.getText().toString())) {
            counter++;
        }

        if (userModel.getData().getUserPersons().get(0).getUser().getPasswordQuestionAnswer() != null
                && !userModel.getData().getUserPersons().get(0).getUser().getPasswordQuestionAnswer().equalsIgnoreCase(fragmentChangePasswordBinding.edtUserName.getText().toString())) {
            counter++;
        }
        if (TextUtils.isEmpty(fragmentChangePasswordBinding.txtQuestion.getText().toString())) {
            Toast.makeText(getActivity(), "Enter your password question?", Toast.LENGTH_SHORT).show();
            return false;
        } else if (TextUtils.isEmpty(fragmentChangePasswordBinding.edtAns.getText().toString())) {
            Toast.makeText(getActivity(), "Enter your password ans?", Toast.LENGTH_SHORT).show();
            return false;
        }
        return counter != 0 ? true : false;
    }

    private void setDataRemotely() {

        if (userModel != null && userModel.getData() != null && userModel.getData().getUserPersons().size() > 0
                && userModel.getData().getUserPersons().get(0).getUser() != null) {
            showDialog();
            userModel.getData().getUserPersons().get(0).getUser().setUserName(fragmentChangePasswordBinding.edtUserName.getText().toString());
            userModel.getData().getUserPersons().get(0).getUser().setPasswordQuestion(fragmentChangePasswordBinding.txtQuestion.getText().toString());
            userModel.getData().getUserPersons().get(0).getUser().setPasswordQuestionAnswer(fragmentChangePasswordBinding.edtAns.getText().toString());
            fragmentChangePasswordViewModel.EditUserInfo(userModel.getData()).observe(this, new Observer<String>() {
                @Override
                public void onChanged(String s) {
                    hideDialog();
                    Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public void ChangePasswordClick() {
        setFragment(ChangePassword.newInstance(userModel));
    }

    private void setFragment(Fragment fragment) {
        if (getActivity() != null)
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fm_edit_container, fragment).addToBackStack(null).commitAllowingStateLoss();
    }

    @Override
    public void leftClick() {
        if (getActivity() != null)
            getActivity().onBackPressed();
    }

    @Override
    public void rightClick() {
        if (userModel != null && userModel.getData() != null && userModel.getData().getUserPersons().size() > 0
                && userModel.getData().getUserPersons().get(0).getUser() != null) {
            if (getActivity() != null && ConnectivityReceiver.isNetworkAvailable(getActivity())) {
                try {
                    //            if (checkValidationDone()) {
                    setDataRemotely();
//            }
                } catch (Exception e) {
                    Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getActivity(), "please check your internet connection", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_SHORT).show();
        }

    }
}
