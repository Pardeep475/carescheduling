package com.example.carescheduling.Ui.Base;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.carescheduling.Utils.Utils;
import com.example.carescheduling.data.Local.SessionManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    protected SessionManager sessionManager;
    //    protected ApiInterface apiInterface;
    protected Dialog dialog;
    private boolean isFullScreen;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialog = Utils.initProgressDialog(this);
    }

    protected void showDialog() {
            if (!dialog.isShowing())
                dialog.show();
    }

    protected void hideDialog() {
            if (dialog.isShowing())
                dialog.dismiss();
    }

    protected SessionManager getSessionManager() {
        if (sessionManager == null) {
            sessionManager = new SessionManager(this);
        }
        return sessionManager;
    }

    protected Dialog getDialog() {
        if (dialog == null) {
            dialog = Utils.initProgressDialog(this);
        }
        return dialog;
    }
}
