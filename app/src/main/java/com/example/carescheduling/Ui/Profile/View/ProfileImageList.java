package com.example.carescheduling.Ui.Profile.View;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.Profile.Adapter.ProfileImageListAdapter;
import com.example.carescheduling.Ui.Profile.presenter.EditEmailClick;
import com.example.carescheduling.Ui.Profile.presenter.ProfileImageListClick;
import com.example.carescheduling.databinding.FragmentProfileImageListBinding;

import java.util.ArrayList;


public class ProfileImageList extends BaseFragment implements EditEmailClick, ProfileImageListClick {
    private FragmentProfileImageListBinding profileImageListBinding;

    public static ProfileImageList newInstance() {
        return new ProfileImageList();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        profileImageListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile_image_list, container, false);
        View view = profileImageListBinding.getRoot();
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {
        profileImageListBinding.rcvImages.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        ArrayList<String> strings = new ArrayList<>();
        ProfileImageListAdapter profileImageListAdapter = new ProfileImageListAdapter(strings, getActivity());
        profileImageListBinding.rcvImages.setAdapter(profileImageListAdapter);
        profileImageListBinding.setEditEmailClick(this);
        profileImageListBinding.setProfileImageList(this);
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
    public void ProfileClick() {
        setFragment(EditProfileImage.newInstance());
    }

    private void setFragment(Fragment fragment) {
        if (getActivity() != null)
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fm_edit_container, fragment).addToBackStack(null).commitAllowingStateLoss();
    }
}
