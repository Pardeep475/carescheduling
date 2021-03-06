package css.mobile.carescheduling.Ui.Profile.View;

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

import css.mobile.carescheduling.R;
import css.mobile.carescheduling.Ui.Base.BaseFragment;
import css.mobile.carescheduling.Ui.Common.Common;
import css.mobile.carescheduling.Ui.Common.CommonBean;
import css.mobile.carescheduling.Ui.Profile.ViewModel.FragmentChangePasswordViewModel;
import css.mobile.carescheduling.Ui.Profile.bean.EditUserWithUserNameRetro;
import css.mobile.carescheduling.Ui.Profile.bean.EditUserWithoutUserNameRetro;
import css.mobile.carescheduling.Ui.Profile.bean.FragmentChangePasswordBean;
import css.mobile.carescheduling.Ui.Profile.bean.UserViewModel;
import css.mobile.carescheduling.Ui.Profile.presenter.FragmentChangePasswordClick;
import css.mobile.carescheduling.Utils.ConnectivityReceiver;
import css.mobile.carescheduling.data.Local.AppDataBase;
import css.mobile.carescheduling.data.Local.DatabaseInitializer;
import css.mobile.carescheduling.data.Local.DatabaseTable.UserInfo;
import css.mobile.carescheduling.data.Local.SessionManager;
import css.mobile.carescheduling.databinding.FragmentChangePasswordBinding;

public class FragmentChangePassword extends BaseFragment implements Common, FragmentChangePasswordClick {
    private FragmentChangePasswordBinding fragmentChangePasswordBinding;
    private FragmentChangePasswordViewModel fragmentChangePasswordViewModel;
    private SessionManager sessionManager;
    private UserViewModel userModel;
    private boolean isUserNameChanged, isQnsAnsChanged;

    public static FragmentChangePassword newInstance() {
        return new FragmentChangePassword();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
//        commonBean.setTitle("Change Password");
        commonBean.setTitle("Edit My User");
        fragmentChangePasswordBinding.setCommonData(commonBean);
        fragmentChangePasswordBinding.setCommonClick(this);
    }

    private void GetUserInfoValid() {
        if (getActivity() != null) {
            try {
                if (ConnectivityReceiver.isNetworkAvailable(getActivity())) {
                    GetUserInfo();
                } else {
                    setDataFromLocal();
                }
            } catch (Exception e) {
                setNoDataFound();
            }
        }
    }

    private void setDataFromLocal() {
        AppDataBase.getAppDatabase(getActivity()).profileDao().getAllUserInfo().observe(this, new Observer<UserInfo>() {
            @Override
            public void onChanged(UserInfo profileInfo) {
                if (profileInfo != null) {

                        FragmentChangePasswordBean fragmentChangePasswordBean = new FragmentChangePasswordBean();
                        String userName = profileInfo.getUserName();
                        String passwordAns = (String) profileInfo.getPasswordAns();
                        String passwordQus = (String) profileInfo.getPasswordQuestion();
                        fragmentChangePasswordBean.setPasswordAns(passwordAns != null ? passwordAns : "");
                        fragmentChangePasswordBean.setUserName(userName != null ? userName : "");
                        fragmentChangePasswordBean.setPasswordQuestion(passwordQus != null ? passwordQus : "");
                        fragmentChangePasswordBinding.setFragmentChangePasswordBean(fragmentChangePasswordBean);
                        setDataOriginal();

                } else {
                    Toast.makeText(getActivity(), "please check your internet connection", Toast.LENGTH_SHORT).show();
                    setNoDataFound();
                }
            }
        });
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
                    , new Observer<String>() {
                        @Override
                        public void onChanged(String aBoolean) {
                            hideDialog();
                            if (aBoolean.equalsIgnoreCase("false")) {
                                Toast.makeText(getActivity(), "User name is available", Toast.LENGTH_SHORT).show();
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
            } else if (userModel.getData().getUserName().equalsIgnoreCase(fragmentChangePasswordBinding.edtUserName.getText().toString())) {
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
        fragmentChangePasswordViewModel.getUserInfo(getSessionManager().getPersonId(), getSessionManager().getBranchId(), getSessionManager().getCustomerId()).observe(this
                , new Observer<UserViewModel>() {
                    @Override
                    public void onChanged(UserViewModel userViewModel) {
                        userModel = userViewModel;
                        if (userViewModel.getData() != null) {
                            FragmentChangePasswordBean fragmentChangePasswordBean = new FragmentChangePasswordBean();
                            String userName = userViewModel.getData().getUserName();
                            String passwordAns = (String) userViewModel.getData().getPasswordQuestionAnswer();
                            String passwordQus = (String) userViewModel.getData().getPasswordQuestion();
                            fragmentChangePasswordBean.setPasswordAns(passwordAns != null ? passwordAns : "");
                            fragmentChangePasswordBean.setUserName(userName != null ? userName : "");
                            fragmentChangePasswordBean.setPasswordQuestion(passwordQus != null ? passwordQus : "");

                            fragmentChangePasswordBinding.setFragmentChangePasswordBean(fragmentChangePasswordBean);
                            setMyUserInfo();
                            setDataOriginal();
                        } else {
                            setNoDataFound();
                        }
                    }
                });
    }

    private void setMyUserInfo(FragmentChangePasswordBean profileAllData) {
        UserInfo fragmentChangePasswordBean = new UserInfo();
        fragmentChangePasswordBean.setPasswordQuestion(profileAllData.getPasswordQuestion());
        fragmentChangePasswordBean.setUserName(profileAllData.getUserName());
        fragmentChangePasswordBean.setPasswordAns(profileAllData.getPasswordAns());
        DatabaseInitializer.populateAsyncUserInfo(AppDataBase.getAppDatabase(getActivity()), fragmentChangePasswordBean);
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
        if (TextUtils.isEmpty(fragmentChangePasswordBinding.edtUserName.getText().toString())) {
            Toast.makeText(getActivity(), "Enter your User name", Toast.LENGTH_SHORT).show();
            return false;
        } else if (TextUtils.isEmpty(fragmentChangePasswordBinding.txtQuestion.getText().toString())) {
            Toast.makeText(getActivity(), "Enter your password question?", Toast.LENGTH_SHORT).show();
            return false;
        } else if (TextUtils.isEmpty(fragmentChangePasswordBinding.edtAns.getText().toString())) {
            Toast.makeText(getActivity(), "Enter your password ans?", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (userModel.getData().getUserName() != null) {
            if (!fragmentChangePasswordBinding.edtUserName.getText().toString().equalsIgnoreCase(userModel.getData().getUserName())) {
                isUserNameChanged = true;
            }
        }
        if (!fragmentChangePasswordBinding.txtQuestion.getText().toString().equalsIgnoreCase(userModel.getData().getPasswordQuestion())
                || !fragmentChangePasswordBinding.edtAns.getText().toString().equalsIgnoreCase(userModel.getData().getPasswordQuestionAnswer())) {
            isQnsAnsChanged = true;
        }

        return true;
    }

    private void setDataRemotely() {


        if (getActivity() != null && ConnectivityReceiver.isNetworkAvailable(getActivity())) {
            if (checkValidationDone()) {
                showDialog();
                if (isUserNameChanged && isQnsAnsChanged) {
                    fragmentChangePasswordViewModel.EditUserWithUserNameRetro(getEditUserWithUserName()).observe(this, new Observer<Boolean>() {
                        @Override
                        public void onChanged(Boolean s) {
                            hideDialog();
                            if (s != null) {
                                if (s) {

                                    GetUserInfoValid();
                                }
                            }

                        }
                    });
                } else if (isUserNameChanged) {
                    fragmentChangePasswordViewModel.EditUserWithUserNameRetro(getEditUserWithUserName()).observe(this, new Observer<Boolean>() {
                        @Override
                        public void onChanged(Boolean s) {
                            hideDialog();
                            if (s != null) {
                                if (s) {

                                    GetUserInfoValid();
                                }
                            }

                        }
                    });
                } else if (isQnsAnsChanged) {
                    fragmentChangePasswordViewModel.EditUserWithoutUserNameRetro(getEditUserWithoutUserName()).observe(this, new Observer<Boolean>() {
                        @Override
                        public void onChanged(Boolean s) {
                            hideDialog();
                            if (s != null) {
                                if (s) {
                                    GetUserInfoValid();
                                }
                            }

                        }
                    });
                } else {
                    hideDialog();
                    showAToast("No data for update");
                }
            } else {
                hideDialog();
            }
        } else {
            Toast.makeText(getActivity(), "please check your internet connection", Toast.LENGTH_SHORT).show();
        }

    }

    private void setMyUserInfo() {
        UserInfo fragmentChangePasswordBean = new UserInfo();
        fragmentChangePasswordBean.setPasswordQuestion(fragmentChangePasswordBinding.txtQuestion.getText().toString());
        fragmentChangePasswordBean.setUserName(fragmentChangePasswordBinding.edtUserName.getText().toString());
        fragmentChangePasswordBean.setPasswordAns(fragmentChangePasswordBinding.edtAns.getText().toString());
        DatabaseInitializer.populateAsyncUserInfo(AppDataBase.getAppDatabase(getActivity()), fragmentChangePasswordBean);
    }



    private EditUserWithUserNameRetro getEditUserWithUserName() {
//        BranchId,CustomerId,PasswordQuestion,PasswordQuestionAnswer,PersonId,UserName
        EditUserWithUserNameRetro editUserWithUserNameRetro = new EditUserWithUserNameRetro();
        editUserWithUserNameRetro.setBranchId(getSessionManager().getBranchId());
        editUserWithUserNameRetro.setCustomerId(getSessionManager().getCustomerId());
        editUserWithUserNameRetro.setPasswordQuestion(fragmentChangePasswordBinding.txtQuestion.getText().toString());
        editUserWithUserNameRetro.setPasswordQuestionAnswer(fragmentChangePasswordBinding.edtAns.getText().toString());
        editUserWithUserNameRetro.setPersonId(getSessionManager().getPersonId());
        editUserWithUserNameRetro.setUserName(fragmentChangePasswordBinding.edtUserName.getText().toString());
        return editUserWithUserNameRetro;
    }

    private EditUserWithoutUserNameRetro getEditUserWithoutUserName() {
        EditUserWithoutUserNameRetro editUserWithoutUserNameRetro = new EditUserWithoutUserNameRetro();
        editUserWithoutUserNameRetro.setBranchId(getSessionManager().getBranchId());
        editUserWithoutUserNameRetro.setCustomerId(getSessionManager().getCustomerId());
        editUserWithoutUserNameRetro.setPasswordQuestion(fragmentChangePasswordBinding.txtQuestion.getText().toString());
        editUserWithoutUserNameRetro.setPasswordQuestionAnswer(fragmentChangePasswordBinding.edtAns.getText().toString());
        editUserWithoutUserNameRetro.setPersonId(getSessionManager().getPersonId());

        return editUserWithoutUserNameRetro;
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
        if (getActivity() != null && ConnectivityReceiver.isNetworkAvailable(getActivity())) {
            try {
                if (checkValidationDone()) {
                    setDataRemotely();
                }
            } catch (Exception e) {
                Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getActivity(), "please check your internet connection", Toast.LENGTH_SHORT).show();
        }

    }



}
