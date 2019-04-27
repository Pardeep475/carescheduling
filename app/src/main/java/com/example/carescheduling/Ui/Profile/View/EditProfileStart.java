package com.example.carescheduling.Ui.Profile.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.Profile.presenter.EditProfileStartClick;
import com.example.carescheduling.databinding.EditProfileStartBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

public class EditProfileStart extends BaseFragment implements EditProfileStartClick {
    private EditProfileStartBinding editProfileStartBinding;


    public static EditProfileStart newInstance() {
        return new EditProfileStart();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        editProfileStartBinding = DataBindingUtil.inflate(inflater, R.layout.edit_profile_start, container, false);
        View view = editProfileStartBinding.getRoot();
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {
        editProfileStartBinding.setEditProfileStartClick(this);
    }

    @Override
    public void backButton() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    @Override
    public void EditMyProfileInfo() {
        setFragment(EditProfileInfo.newInstance());
    }

    @Override
    public void EditMyAddress() {
        setFragment(EditProfileAddress.newInstance());
    }

    @Override
    public void EditMyPicture() {
        setFragment(ProfileImageList.newInstance());
    }

    @Override
    public void EditChangePassword() {
setFragment(FragmentChangePassword.newInstance());
    }

    private void setFragment(Fragment fragment) {
        if (getActivity() != null)
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fm_edit_container, fragment).addToBackStack(null).commitAllowingStateLoss();
    }

}
