package com.example.carescheduling.Ui.Profile.View;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.Dashboard.beans.ProfileBean;
import com.example.carescheduling.Ui.Profile.ViewModel.EditPhoneNumberViewModel;
import com.example.carescheduling.Ui.Profile.bean.EditPhoneNumberBean;
import com.example.carescheduling.Ui.Profile.presenter.EditEmailClick;
import com.example.carescheduling.Utils.Constants;
import com.example.carescheduling.databinding.FragmentEditPhoneNumberBinding;

public class EditPhoneNumber extends BaseFragment implements EditEmailClick {
    private FragmentEditPhoneNumberBinding editPhoneNumberBinding;
    private String stringValue;
    private ProfileBean profileBean;
    private EditPhoneNumberViewModel editPhoneNumberViewModel;

    public static EditPhoneNumber newInstance(String value, ProfileBean profileBean) {
        EditPhoneNumber editPhoneNumber = new EditPhoneNumber();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.STRING_VALUE, value);
        bundle.putSerializable(Constants.PROFILE_DATA, profileBean);
        editPhoneNumber.setArguments(bundle);
        return editPhoneNumber;
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
        editPhoneNumberBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_phone_number, container, false);
        View view = editPhoneNumberBinding.getRoot();
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {
        editPhoneNumberViewModel = ViewModelProviders.of(this).get(EditPhoneNumberViewModel.class);
        setEditPhoneNumber();
        editPhoneNumberBinding.setEditEmailClick(this);
    }

    private void setEditPhoneNumber() {
        editPhoneNumberViewModel.getEditPhoneNumberBean(stringValue, profileBean).observe(this, new Observer<EditPhoneNumberBean>() {
            @Override
            public void onChanged(EditPhoneNumberBean editPhoneNumberBean) {
                editPhoneNumberBinding.setEditPhoneNumberBean(editPhoneNumberBean);
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
