package com.example.carescheduling.Ui.Profile.View;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.Common.Common;
import com.example.carescheduling.Ui.Common.CommonBean;
import com.example.carescheduling.Ui.Profile.presenter.EditEmailClick;
import com.example.carescheduling.databinding.FragmentEditProfileImageBinding;


public class EditProfileImage extends BaseFragment implements Common {
    private FragmentEditProfileImageBinding editProfileImageBinding;

    public static EditProfileImage newInstance() {

        return new EditProfileImage();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        editProfileImageBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_profile_image, container, false);
        View view = editProfileImageBinding.getRoot();
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {
        setCommonData();

    }

    private void setCommonData() {
        CommonBean commonBean = new CommonBean();
        commonBean.setLeftImageDrawable(R.drawable.ic_left_back);
        commonBean.setLeftImageVisible(true);
        commonBean.setRightImageDrawable(R.drawable.ic_tick);
        commonBean.setRightImageVisible(true);
        commonBean.setTitle("Change Image");
        editProfileImageBinding.setCommonData(commonBean);
        editProfileImageBinding.setCommonClick(this);
    }

    @Override
    public void leftClick() {
        if (getActivity() != null)
            getActivity().onBackPressed();
    }

    @Override
    public void rightClick() {

    }
}
