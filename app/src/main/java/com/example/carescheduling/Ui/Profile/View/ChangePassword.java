package com.example.carescheduling.Ui.Profile.View;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.Common.Common;
import com.example.carescheduling.Ui.Common.CommonBean;
import com.example.carescheduling.Ui.Profile.ViewModel.ChangePasswordViewModel;
import com.example.carescheduling.Ui.Profile.bean.UserViewModel;
import com.example.carescheduling.Ui.Profile.presenter.EditEmailClick;
import com.example.carescheduling.Utils.ConnectivityReceiver;
import com.example.carescheduling.Utils.Constants;
import com.example.carescheduling.data.Local.SessionManager;
import com.example.carescheduling.databinding.ChangePasswordBinding;

import java.io.Serializable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class ChangePassword extends BaseFragment implements Common {
    private ChangePasswordBinding changePasswordBinding;
    private SessionManager sessionManager;
    private UserViewModel userViewModel;
    private ChangePasswordViewModel changePasswordViewModel;

    public static ChangePassword newInstance(UserViewModel userViewModel) {
        ChangePassword changePassword = new ChangePassword();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constants.USER_VIEW_MODEL, (Serializable) userViewModel);
        changePassword.setArguments(bundle);
        return changePassword;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            userViewModel = (UserViewModel) getArguments().getSerializable(Constants.USER_VIEW_MODEL);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        changePasswordBinding = DataBindingUtil.inflate(inflater, R.layout.change_password, container, false);
        View view = changePasswordBinding.getRoot();
        setUpView(view);
        return view;

    }

    private void setUpView(View view) {
        setCommonData();
        sessionManager = getSessionManager();
        changePasswordViewModel = ViewModelProviders.of(this).get(ChangePasswordViewModel.class);

    }

    private void setCommonData() {
        CommonBean commonBean = new CommonBean();
        commonBean.setLeftImageDrawable(R.drawable.ic_left_back);
        commonBean.setLeftImageVisible(true);
        commonBean.setRightImageDrawable(R.drawable.ic_tick);
        commonBean.setRightImageVisible(false);
        commonBean.setRightTextVisible(true);
        commonBean.setTitle("Change Password");
        changePasswordBinding.setCommonData(commonBean);
        changePasswordBinding.setCommonClick(this);
    }


    private void setDataRemote() {
        showDialog();
        if (userViewModel != null && userViewModel.getData() != null && userViewModel.getData().getUserPersons().size() > 0
                && userViewModel.getData().getUserPersons().get(0).getUser() != null) {
            userViewModel.getData().getUserPersons().get(0).getUser().setUserPassword(changePasswordBinding.edtNewPassword.getText().toString());

            changePasswordViewModel.EditUserInfo(userViewModel.getData()).observe(this, new Observer<String>() {
                @Override
                public void onChanged(String s) {
                    hideDialog();
                    Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private boolean checkValidation() {
        if (TextUtils.isEmpty(changePasswordBinding.edtCurrentPassword.getText().toString())) {
            Toast.makeText(getActivity(), "Enter your Current password", Toast.LENGTH_SHORT).show();
            return false;
        } else if (TextUtils.isEmpty(changePasswordBinding.edtNewPassword.getText().toString())) {
            Toast.makeText(getActivity(), "Enter your new password", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(changePasswordBinding.edtRepeatNewPassword.getText().toString())) {
            Toast.makeText(getActivity(), "Enter your confirm password", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!changePasswordBinding.edtNewPassword.getText().toString().equalsIgnoreCase(changePasswordBinding.edtRepeatNewPassword.getText().toString())) {
            Toast.makeText(getActivity(), "New password and confirm password not match", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!changePasswordBinding.edtCurrentPassword.getText().toString().equalsIgnoreCase(sessionManager.getCurrentPassword())) {
            Toast.makeText(getActivity(), "Current password is not valid", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void leftClick() {
        if (getActivity() != null)
            getActivity().onBackPressed();
    }

    @Override
    public void rightClick() {
        if (getActivity() != null) {
            try {
                if (ConnectivityReceiver.isNetworkAvailable(getActivity())) {
                    if (checkValidation()) {
                        setDataRemote();
                    }
                } else {
                    Toast.makeText(getActivity(), "please check your internet connection", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
                hideDialog();
            }
        }
    }
}
