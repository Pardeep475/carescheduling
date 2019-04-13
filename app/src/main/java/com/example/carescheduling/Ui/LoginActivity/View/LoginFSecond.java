package com.example.carescheduling.Ui.LoginActivity.View;

import android.content.Context;
import android.content.Intent;
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
import com.example.carescheduling.Ui.Dashboard.view.Dashboard;
import com.example.carescheduling.Ui.LoginActivity.ViewModal.LoginViewModalSF;
import com.example.carescheduling.Ui.LoginActivity.beans.LoginBeanRetro;
import com.example.carescheduling.Ui.LoginActivity.presenter.LoginFSecondPresenter;
import com.example.carescheduling.databinding.FragmentLoginFsecondBinding;
import com.google.gson.JsonElement;

import java.io.Serializable;
import java.util.ArrayList;

public class LoginFSecond extends BaseFragment implements LoginFSecondPresenter {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String USER_EMAIL = "USER_EMAIL";
    private static final String USER_PASSWORD = "USER_PASSWORD";
    private static final String BRANCH_LIST = "BRANCH_LIST";

    // TODO: Rename and change types of parameters
    private String userEmail, userPassword;
    private ArrayList<LoginBeanRetro.BranchList> branchList;

    // TODO: data binding
    private FragmentLoginFsecondBinding loginFSecondBinding;
    // TODO: view modal
    private LoginViewModalSF loginViewModalSF;

    public LoginFSecond() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static LoginFSecond newInstance(String param1, String userPassword, ArrayList<LoginBeanRetro.BranchList> branchList) {
        LoginFSecond fragment = new LoginFSecond();
        Bundle args = new Bundle();
        args.putString(USER_EMAIL, param1);
        args.putString(USER_PASSWORD, userPassword);
        args.putSerializable(BRANCH_LIST, branchList);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            userEmail = getArguments().getString(USER_EMAIL);
            userPassword = getArguments().getString(USER_PASSWORD);
            branchList = (ArrayList<LoginBeanRetro.BranchList>) getArguments().getSerializable(BRANCH_LIST);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        loginFSecondBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login_fsecond, container, false);
        View view = loginFSecondBinding.getRoot();
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {
        loginFSecondBinding.setLoginFSecondPresenter(this);
        loginFSecondBinding.setUserEmail(userEmail);
        loginViewModalSF = ViewModelProviders.of(this).get(LoginViewModalSF.class);
    }


    @Override
    public void getClientData() {
        showDialog();
        loginViewModalSF.getClientData(userEmail, userPassword, branchList.get(0).getBranchId())
                .observe(this, new Observer<JsonElement>() {
            @Override
            public void onChanged(JsonElement jsonElement) {
                hideDialog();
                goToDashboard();
            }
        });

    }

    private void goToDashboard() {
        Intent intent = new Intent(getActivity(), Dashboard.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
