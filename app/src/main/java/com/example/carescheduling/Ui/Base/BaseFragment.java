package com.example.carescheduling.Ui.Base;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carescheduling.Utils.Utils;
import com.example.carescheduling.data.Local.SessionManager;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public abstract class BaseFragment extends Fragment {
    protected SessionManager sessionManager;
    //    protected ApiInterface apiInterface;
    protected Dialog dialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        setUpLayout(view);
        return view;
    }

    protected abstract int getLayout();

    protected abstract boolean isFullScreen(boolean isFullScreen);

    protected abstract void setUpLayout(View view);

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        apiInterface = ApiClient.getClient().create(ApiInterface.class);
    }

    protected void showDialog() {
        if (isAdded())
            if (!dialog.isShowing())
                dialog.show();
    }

    protected void hideDialog() {
        if (isAdded())
            if (dialog.isShowing())
                dialog.dismiss();
    }

    protected SessionManager getSessionManager() {
        if (sessionManager == null) {
            sessionManager = new SessionManager(getActivity());
        }
        return sessionManager;
    }

    protected Dialog getDialog() {
        if (dialog == null) {
            dialog = Utils.initProgressDialog(getActivity());
        }
        return dialog;
    }
//    public void makeSnackBar(View view, String text) {
//        Snackbar snackbar = null;
//        if (snackbar == null)
//            snackbar.make(view, text, Snackbar.LENGTH_LONG).show();
//    }
//
//    public boolean getConnectivity(Context context) {
//        return ConnectivityReceiver.isNetworkAvailable(context);
//    }


}

