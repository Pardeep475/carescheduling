package com.example.carescheduling.Ui.Base;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.carescheduling.Utils.Utils;
import com.example.carescheduling.data.Local.SessionManager;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public abstract class BaseFragment extends Fragment {
    protected SessionManager sessionManager;
    //    protected ApiInterface apiInterface;
    protected Dialog dialog;
    private Toast toast;

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialog = Utils.initProgressDialog(getActivity());
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
    public void showAToast(String st) { //"Toast toast" is declared in the class
        try {
            toast.getView().isShown();     // true if visible
            toast.setText(st);
        } catch (Exception e) {         // invisible if exception
            toast = Toast.makeText(getActivity(), st, Toast.LENGTH_SHORT);
        }
        toast.show();  //finally display it
    }

}

