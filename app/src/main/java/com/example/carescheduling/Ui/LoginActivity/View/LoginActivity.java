package com.example.carescheduling.Ui.LoginActivity.View;

import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseActivity;
import com.example.carescheduling.databinding.ActivityLoginBinding;

import androidx.databinding.DataBindingUtil;

public class LoginActivity extends BaseActivity {
    private LoginClickHandler loginClickHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding loginDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        loginClickHandler = new LoginClickHandler(this,loginDataBinding.loginContent.edtEmail,loginDataBinding.loginContent.edtPassword);
        loginDataBinding.loginContent.setLoginClickHandler(loginClickHandler);
    }

    public class LoginClickHandler {
        private Context context;
        private EditText edtEmail, edtPassword;

        public LoginClickHandler(Context context, EditText edtEmail, EditText edtPassword) {
            this.context = context;
            this.edtEmail = edtEmail;
            this.edtPassword = edtPassword;
        }
        // click event on log on button
        public void getUsersDetail() {
            String userEmail = edtEmail.getText().toString().trim();
            String userPassword = edtPassword.getText().toString().trim();
            Toast.makeText(context, "Email is : "+userEmail +"Password is : "+ userPassword, Toast.LENGTH_SHORT).show();

        }
        // click event on forgot password button
        public void forgotPasswordClick() {
            Toast.makeText(context, "Forgot password click", Toast.LENGTH_SHORT).show();
        }
    }
}
