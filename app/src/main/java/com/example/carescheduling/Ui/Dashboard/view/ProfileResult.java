package com.example.carescheduling.Ui.Dashboard.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.Dashboard.ViewModel.ProfileResultViewModel;
import com.example.carescheduling.Ui.Dashboard.beans.ProfileBean;
import com.example.carescheduling.Ui.Dashboard.beans.ProfileResultBean;
import com.example.carescheduling.Ui.Dashboard.presenter.EditProfileClickHandler;
import com.example.carescheduling.Ui.Dashboard.presenter.ProfileClickHandler;
import com.example.carescheduling.Ui.Profile.View.EditProfile;
import com.example.carescheduling.data.Local.SessionManager;
import com.example.carescheduling.databinding.FragmentProfileResultBinding;

public class ProfileResult extends BaseFragment implements ProfileClickHandler, EditProfileClickHandler {

    private FragmentProfileResultBinding fragmentProfileResultBinding;
    private ProfileResultViewModel profileResultViewModel;
    private View view;
    private SessionManager sessionManager;

    public static ProfileResult newInstance() {
        return new ProfileResult();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentProfileResultBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile_result, container, false);
        view = fragmentProfileResultBinding.getRoot();
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {
        sessionManager = getSessionManager();
        profileResultViewModel = ViewModelProviders.of(this).get(ProfileResultViewModel.class);
        showDialog();
        profileResultViewModel.getClientData(sessionManager.getPersonId(), sessionManager.getCustomerId(), sessionManager.getBranchId())
                .observe(this, new Observer<ProfileBean>() {
                    @Override
                    public void onChanged(ProfileBean profileBean) {
                        hideDialog();
                        setDataProfile(profileBean);
                    }
                });

        fragmentProfileResultBinding.setClickhandler(this);
        fragmentProfileResultBinding.setEditClickHandler(this);
    }

    private void setDataProfile(ProfileBean profileBean) {
        showDialog();
        profileResultViewModel.getProfileData(profileBean).observe(this, new Observer<ProfileResultBean>() {
            @Override
            public void onChanged(ProfileResultBean profileResultBean) {
                hideDialog();
                fragmentProfileResultBinding.setProfileEditBean(profileResultBean);
            }
        });
    }

    @Override
    public void EditBtnClick() {
        startActivity(new Intent(getActivity(), EditProfile.class));
    }

    @Override
    public void logout() {

    }
}
