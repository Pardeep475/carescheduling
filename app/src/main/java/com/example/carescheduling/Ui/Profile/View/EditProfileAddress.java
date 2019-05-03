package com.example.carescheduling.Ui.Profile.View;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.Dashboard.beans.ProfileBean;
import com.example.carescheduling.Ui.Dashboard.beans.ProfileResultBean;
import com.example.carescheduling.Ui.Profile.presenter.EditProfileAddressClick;
import com.example.carescheduling.Utils.Constants;
import com.example.carescheduling.databinding.FragmentEditProfileAddressBinding;

import java.io.Serializable;

public class EditProfileAddress extends BaseFragment implements EditProfileAddressClick {

    private FragmentEditProfileAddressBinding editProfileAddressBinding;
    private ProfileBean profileResultBean;

    public static EditProfileAddress newInstance(ProfileBean profileResultBean) {
        EditProfileAddress editProfileAddress = new EditProfileAddress();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constants.PROFILE_DATA, (Serializable) profileResultBean);
        editProfileAddress.setArguments(bundle);
        return editProfileAddress;
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
        // Inflate the layout for this fragment
        editProfileAddressBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_profile_address, container, false);
        View view = editProfileAddressBinding.getRoot();
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {
        editProfileAddressBinding.setEditAddressClick(this);
    }

    @Override
    public void BackButtonClick() {
        if (getActivity() != null)
            getActivity().onBackPressed();
    }

    @Override
    public void EditAddressClick() {
        setFragment(ProfileAddress.newInstance());
    }

    @Override
    public void EditPhoneNumberClick() {
        setFragment(EditPhoneNumber.newInstance());
    }

    @Override
    public void EditEmailClick() {
        setFragment(EditEmail.newInstance());
    }

    private void setFragment(Fragment fragment) {
        if (getActivity() != null)
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fm_edit_container, fragment).addToBackStack(null).commitAllowingStateLoss();
    }
}
