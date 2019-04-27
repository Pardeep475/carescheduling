package com.example.carescheduling.Ui.Profile.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.Profile.presenter.EditEmailClick;
import com.example.carescheduling.databinding.ChangePasswordBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

public class ChangePassword extends BaseFragment implements EditEmailClick {
    private ChangePasswordBinding changePasswordBinding;

    public static ChangePassword newInstance() {
        return new ChangePassword();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        changePasswordBinding = DataBindingUtil.inflate(inflater, R.layout.change_password, container, false);
        View view = changePasswordBinding.getRoot();
        setUpView(view);
        return view;

    }

    private void setUpView(View view) {
        changePasswordBinding.setEditEmailClick(this);
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
