package com.example.carescheduling.Ui.LoginActivity.View;

import android.os.Bundle;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.LoginActivity.ViewModal.LoginViewModel;
import com.example.carescheduling.Ui.LoginActivity.beans.LoginBeanData;
import com.example.carescheduling.Ui.LoginActivity.beans.LoginBeanRetro;
import com.example.carescheduling.Ui.LoginActivity.presenter.LoginPresenter;
import com.example.carescheduling.databinding.FragmentLoginBinding;

import java.util.ArrayList;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;


public class LoginF extends BaseFragment implements LoginPresenter {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // TODO: data binding
    private FragmentLoginBinding fragmentLoginBinding;

    private LoginViewModel loginViewModel;


    public LoginF() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static LoginF newInstance() {

        return new LoginF();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//         Inflate the layout for this fragment
        fragmentLoginBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login,container,false);
        View view = fragmentLoginBinding.getRoot();
        setUpLayout(view);
        return view;
//        return inflater.inflate( R.layout.fragment_login,container,false);
    }


    private void setUpLayout(View view) {
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        LoginBeanData loginBeanData = new LoginBeanData("Tommy@bhc.co.uk", "Tommy");
        fragmentLoginBinding.setLoginBeanData(loginBeanData);
        fragmentLoginBinding.setLoginPresenter(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    public void getUserData() {
        final String userEmail = fragmentLoginBinding.edtEmail.getText().toString();
        final String userPassword = fragmentLoginBinding.edtPassword.getText().toString();
        showDialog();
        LiveData<LoginBeanRetro> beanRetroLiveData = loginViewModel.getUserData(userEmail, userPassword);
        beanRetroLiveData.observe(this, new Observer<LoginBeanRetro>() {
            @Override
            public void onChanged(LoginBeanRetro loginBeanRetro) {
                hideDialog();
                Log.e("LoginSuccess", "liveData");
                goToLoginFSecond(userEmail,userPassword,loginBeanRetro.getData());
            }
        });
    }


    private void goToLoginFSecond(String email,String userPassword, LoginBeanRetro.Data data){
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.rl_main_login,LoginFSecond.newInstance(email,userPassword,data)).commitAllowingStateLoss();
    }
}
