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
import com.example.carescheduling.Ui.Dashboard.beans.ProfileBean;
import com.example.carescheduling.Ui.Dashboard.beans.ProfileResultBean;
import com.example.carescheduling.Ui.Profile.ViewModel.FragmentChangePasswordViewModel;
import com.example.carescheduling.Ui.Profile.bean.FragmentChangePasswordBean;
import com.example.carescheduling.Ui.Profile.bean.UserViewModel;
import com.example.carescheduling.Ui.Profile.presenter.EditEmailClick;
import com.example.carescheduling.Ui.Profile.presenter.FragmentChangePasswordClick;
import com.example.carescheduling.Utils.Constants;
import com.example.carescheduling.data.Local.SessionManager;
import com.example.carescheduling.databinding.FragmentChangePasswordBinding;

import java.io.Serializable;

public class FragmentChangePassword extends BaseFragment implements EditEmailClick, FragmentChangePasswordClick {
    private FragmentChangePasswordBinding fragmentChangePasswordBinding;
    private ProfileBean profileResultBean;
    private FragmentChangePasswordViewModel fragmentChangePasswordViewModel;
    private SessionManager sessionManager;
    private UserViewModel userViewModel;

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
        sessionManager = getSessionManager();
        fragmentChangePasswordViewModel = ViewModelProviders.of(this).get(FragmentChangePasswordViewModel.class);
        GetUserInfo();
        CheckUserName();
        fragmentChangePasswordBinding.setEditEmailClick(this);
        fragmentChangePasswordBinding.setChangePasswordClick(this);
    }

    private void CheckUserName() {
        if (checkValidation()) {
            fragmentChangePasswordViewModel.checkUserName(fragmentChangePasswordBinding.edtUserName.getText().toString(),
                    sessionManager.getCustomerId(), sessionManager.getPersonId(), sessionManager.getBranchId()).observe(this
                    , new Observer<Boolean>() {
                        @Override
                        public void onChanged(Boolean aBoolean) {
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
            } else if (userViewModel.getData() == null) {
                Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_SHORT).show();
                return false;
            } else if (userViewModel.getData().getUserPersons().get(0).getUser().getUserName().equalsIgnoreCase(fragmentChangePasswordBinding.edtUserName.getText().toString())) {
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
                        if (userViewModel.getData() != null && userViewModel.getData().getUserPersons() != null && userViewModel.getData().getUserPersons().size() > 0) {
                            FragmentChangePasswordBean fragmentChangePasswordBean = new FragmentChangePasswordBean();
                            String userName = userViewModel.getData().getUserPersons().get(0).getUser().getUserName();
                            String passwordAns = (String) userViewModel.getData().getUserPersons().get(0).getUser().getPasswordQuestionAnswer();
                            String passwordQus = (String) userViewModel.getData().getUserPersons().get(0).getUser().getPasswordQuestion();
                            fragmentChangePasswordBean.setPasswordAns(passwordAns != null ? passwordAns : "");
                            fragmentChangePasswordBean.setUserName(userName != null ? userName : "");
                            fragmentChangePasswordBean.setPasswordQuestion(passwordQus != null ? passwordQus : "");
                        }
                    }
                });
    }

    @Override
    public void BackButtonClick() {
        if (getActivity() != null)
            getActivity().onBackPressed();
    }

    @Override
    public void DoneClick() {

    }

    @Override
    public void ChangePasswordClick() {
        setFragment(ChangePassword.newInstance());
    }

    private void setFragment(Fragment fragment) {
        if (getActivity() != null)
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fm_edit_container, fragment).addToBackStack(null).commitAllowingStateLoss();
    }
}
