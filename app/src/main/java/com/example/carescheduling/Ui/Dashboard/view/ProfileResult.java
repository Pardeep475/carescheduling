package com.example.carescheduling.Ui.Dashboard.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.Dashboard.presenter.EditProfileClickHandler;
import com.example.carescheduling.Ui.Dashboard.presenter.ProfileClickHandler;
import com.example.carescheduling.Ui.Profile.View.EditProfile;
import com.example.carescheduling.databinding.FragmentProfileResultBinding;

public class ProfileResult extends BaseFragment implements ProfileClickHandler, EditProfileClickHandler {

    private FragmentProfileResultBinding fragmentProfileResultBinding;
    private View view;

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
        fragmentProfileResultBinding.setClickhandler(this);
        fragmentProfileResultBinding.setEditClickHandler(this);
    }

    @Override
    public void EditBtnClick() {
        startActivity(new Intent(getActivity(), EditProfile.class));
    }

    @Override
    public void logout() {

    }
}
