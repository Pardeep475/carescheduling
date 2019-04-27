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
import com.example.carescheduling.databinding.FragmentEditProfileInfoBinding;

public class EditProfileInfo extends BaseFragment {

    private FragmentEditProfileInfoBinding fragmentEditProfileInfoBinding;

    public static EditProfileInfo newInstance(){
        return new EditProfileInfo();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentEditProfileInfoBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_profile_info, container, false);
        View view = fragmentEditProfileInfoBinding.getRoot();
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {
    }

}
