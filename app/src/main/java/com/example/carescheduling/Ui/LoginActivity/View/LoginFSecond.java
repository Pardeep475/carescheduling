package com.example.carescheduling.Ui.LoginActivity.View;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatSpinner;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.Dashboard.view.Dashboard;
import com.example.carescheduling.Ui.LoginActivity.adapter.CustomAdapter;
import com.example.carescheduling.Ui.LoginActivity.ViewModal.LoginViewModalSF;
import com.example.carescheduling.Ui.LoginActivity.beans.LoginBeanRetro;
import com.example.carescheduling.Ui.LoginActivity.presenter.LoginFSecondPresenter;
//import com.example.carescheduling.databinding.FragmentLoginFsecondBinding;
import com.google.gson.JsonElement;

import java.util.ArrayList;

public class LoginFSecond extends BaseFragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String USER_EMAIL = "USER_EMAIL";
    private static final String USER_PASSWORD = "USER_PASSWORD";
    private static final String DATA = "data";

    // TODO: Rename and change types of parameters
    private String userEmail, userPassword;
    private ArrayList<LoginBeanRetro.BranchList> branchList;
    private String personId, branchId;
    // TODO: data binding
//    private FragmentLoginFsecondBinding loginFSecondBinding;
    // TODO: view modal
    private LoginViewModalSF loginViewModalSF;
    private AppCompatSpinner appCompatSpinner;

    public LoginFSecond() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static LoginFSecond newInstance(String param1, String userPassword, LoginBeanRetro.Data data) {
        LoginFSecond fragment = new LoginFSecond();
        Bundle args = new Bundle();
        args.putString(USER_EMAIL, param1);
        args.putString(USER_PASSWORD, userPassword);
        args.putSerializable(DATA, data);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            userEmail = getArguments().getString(USER_EMAIL);
            userPassword = getArguments().getString(USER_PASSWORD);
            LoginBeanRetro.Data data = (LoginBeanRetro.Data) getArguments().getSerializable(DATA);
            branchList = data.getBranchList();
            personId = data.getUserPersons().get(0).getUser().getPersonId();
            branchId = data.getBranchId();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        loginFSecondBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login_fsecond, container, false);
//        View view = loginFSecondBinding.getRoot();
        View view = inflater.inflate(R.layout.fragment_login_fsecond, container, false);
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {
//        loginFSecondBinding.setLoginFSecondPresenter(this);
//        loginFSecondBinding.setUserEmail(userEmail);
//        appCompatSpinner = loginFSecondBinding.spinnerLoginSf;
//        loginFSecondBinding.spinnerLoginSf.setOnItemClickListener((AdapterView.OnItemClickListener) this);
        sessionManager = getSessionManager();
        TextView textView = view.findViewById(R.id.txt_email);
        textView.setText(userEmail);
        loginViewModalSF = ViewModelProviders.of(this).get(LoginViewModalSF.class);
        CustomAdapter adapter = new CustomAdapter(getActivity(),
                R.layout.item_spinner_sf, R.id.title, branchList);
        appCompatSpinner = view.findViewById(R.id.spinner_login_sf);
        appCompatSpinner.setAdapter(adapter);
        view.findViewById(R.id.btn_continue).setOnClickListener(this);
        appCompatSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "" + branchList.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    private void goToDashboard() {
        Intent intent = new Intent(getActivity(), Dashboard.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_continue: {
                try {
                    checkLogin();
                } catch (Exception e) {
                    Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }

    private void checkLogin() {
        showDialog();
        loginViewModalSF.getClientData(userEmail, userPassword, branchList.get(appCompatSpinner.getSelectedItemPosition()).getBranchId())
                .observe(this, new Observer<JsonElement>() {
                    @Override
                    public void onChanged(JsonElement jsonElement) {
                        hideDialog();
                        sessionManager.setBranchId(branchList.get(appCompatSpinner.getSelectedItemPosition()).getBranchId());
                        sessionManager.setPersonId(personId);
                        sessionManager.setCustomerId(branchList.get(appCompatSpinner.getSelectedItemPosition()).getCustomerId());
                        sessionManager.setUserLogin(true);
                        goToDashboard();
                    }
                });

    }
}
