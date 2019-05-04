package com.example.carescheduling.Ui.Profile.View;

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
import com.example.carescheduling.Ui.Dashboard.beans.ProfileBean;
import com.example.carescheduling.Ui.Dashboard.presenter.ProfileClickHandler;
import com.example.carescheduling.Ui.LoginActivity.View.LoginActivity;
import com.example.carescheduling.Ui.Profile.ViewModel.ProfileAddressViewModel;
import com.example.carescheduling.Ui.Profile.bean.ProfileAddressBean;
import com.example.carescheduling.Ui.Profile.presenter.EditEmailClick;
import com.example.carescheduling.Utils.Constants;
import com.example.carescheduling.databinding.ProfileAddressBinding;
//import com.example.carescheduling.databinding.FragmentProfileBinding;

public class ProfileAddress extends BaseFragment implements EditEmailClick {
    private ProfileAddressBinding profileAddressBinding;
    private ProfileAddressViewModel profileAddressViewModel;
    private String stringValue;
    private ProfileBean profileBean;

    // TODO: Rename and change types and number of parameters
    public static ProfileAddress newInstance(String value, ProfileBean profileBean) {
        ProfileAddress profileAddress = new ProfileAddress();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.STRING_VALUE, value);
        bundle.putSerializable(Constants.PROFILE_DATA, profileBean);
        profileAddress.setArguments(bundle);
        return profileAddress;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            stringValue = getArguments().getString(Constants.STRING_VALUE);
            profileBean = (ProfileBean) getArguments().getSerializable(Constants.PROFILE_DATA);
        }
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
        profileAddressViewModel = ViewModelProviders.of(this).get(ProfileAddressViewModel.class);
        sessionManager = getSessionManager();
        setProfileAddressData();

        profileAddressBinding.setEditEmailClick(this);
//        fragmentProfileBinding.setClickhandler(this);
    }

    private void setProfileAddressData() {
        profileAddressViewModel.getProfileAddressBean(stringValue, profileBean).observe(this, new Observer<ProfileAddressBean>() {
            @Override
            public void onChanged(ProfileAddressBean profileAddressBean) {
                profileAddressBinding.setProfileAddressBean(profileAddressBean);
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
}
