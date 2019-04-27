package com.example.carescheduling.Ui.Profile.View;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.Profile.presenter.EditEmailClick;
import com.example.carescheduling.Ui.Profile.presenter.FragmentChangePasswordClick;
import com.example.carescheduling.databinding.FragmentChangePasswordBinding;

public class FragmentChangePassword extends BaseFragment implements EditEmailClick, FragmentChangePasswordClick {
    private FragmentChangePasswordBinding fragmentChangePasswordBinding;

    public static FragmentChangePassword newInstance() {
        return new FragmentChangePassword();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentChangePasswordBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_change_password, container, false);
        View view = fragmentChangePasswordBinding.getRoot();
        // Inflate the layout for this fragment
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {
        fragmentChangePasswordBinding.setEditEmailClick(this);
        fragmentChangePasswordBinding.setChangePasswordClick(this);
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
    public void ChangePasswordClick() {
        setFragment(ChangePassword.newInstance());
    }

    private void setFragment(Fragment fragment) {
        if (getActivity() != null)
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fm_edit_container, fragment).addToBackStack(null).commitAllowingStateLoss();
    }
}
