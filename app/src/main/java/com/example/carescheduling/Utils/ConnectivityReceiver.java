package com.example.carescheduling.Utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class ConnectivityReceiver {
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();

            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    Log.i("CheckNetworkConnection", "Class=" + info[i].getState().toString());
                    if (info[i].getState() == NetworkInfo.State.CONNECTED || info[i].getState() == NetworkInfo.State.CONNECTING) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
