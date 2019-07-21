package com.example.carescheduling.Ui.Profile.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.Common.Common;
import com.example.carescheduling.Ui.Common.CommonBean;
import com.example.carescheduling.Ui.Profile.presenter.EditProfileStartClick;
import com.example.carescheduling.databinding.EditProfileStartBinding;

import java.io.Serializable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

public class EditProfileStart extends BaseFragment implements Common, EditProfileStartClick {
    private EditProfileStartBinding editProfileStartBinding;
  

    public static EditProfileStart newInstance() {
        return new EditProfileStart();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
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
        setCommonData();
        editProfileStartBinding.setEditProfileStartClick(this);
    }

    private void setCommonData() {
        CommonBean commonBean = new CommonBean();
        commonBean.setLeftImageDrawable(R.drawable.ic_left_back);
        commonBean.setLeftImageVisible(true);
        commonBean.setRightImageDrawable(R.drawable.ic_tick);
        commonBean.setRightImageVisible(false);
        commonBean.setTitle("Profile");
        commonBean.setRightTextVisible(false);
        editProfileStartBinding.setCommonData(commonBean);
        editProfileStartBinding.setCommonClick(this);
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

    @Override
    public void leftClick() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    @Override
    public void rightClick() {

    }
}
