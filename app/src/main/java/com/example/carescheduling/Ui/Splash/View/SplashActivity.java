package com.example.carescheduling.Ui.Splash.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseActivity;
import com.example.carescheduling.Ui.LoginActivity.View.LoginActivity;

public class SplashActivity extends BaseActivity {
    private Handler myHandler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initialSetUp();
    }

    private void initialSetUp(){
       myHandler.postDelayed(runnable,3000);
    }


    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myHandler.removeCallbacks(runnable);
    }
}
