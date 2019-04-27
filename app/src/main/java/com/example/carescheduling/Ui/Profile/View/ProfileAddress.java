package com.example.carescheduling.Ui.Profile.View;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.Dashboard.presenter.ProfileClickHandler;
import com.example.carescheduling.Ui.LoginActivity.View.LoginActivity;
import com.example.carescheduling.Ui.Profile.presenter.EditEmailClick;
import com.example.carescheduling.databinding.ProfileAddressBinding;
//import com.example.carescheduling.databinding.FragmentProfileBinding;

public class ProfileAddress extends BaseFragment implements EditEmailClick {
    private ProfileAddressBinding profileAddressBinding;

    // TODO: Rename and change types and number of parameters
    public static ProfileAddress newInstance() {

        return new ProfileAddress();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        profileAddressBinding = DataBindingUtil.inflate(inflater, R.layout.profile_address
                , container, false);
        View view = profileAddressBinding.getRoot();
        setUpView(view);
        return view;

    }

    private void setUpView(View view) {
        sessionManager = getSessionManager();
        profileAddressBinding.setEditEmailClick(this);
//        fragmentProfileBinding.setClickhandler(this);
    }

    @Override
    public void BackButtonClick() {
        if (getActivity() != null)
            getActivity().onBackPressed();
    }

    @Override
    public void DoneClick() {

    }
}
