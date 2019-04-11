package com.example.carescheduling.Application;

import android.app.Application;
import android.app.Dialog;


public class MyApplication extends Application {
      private Dialog progressDialog;
    private static volatile MyApplication myApplication;

    @Override
    public void onCreate() {
        super.onCreate();

        myApplication = null;
        if (myApplication == null)
            myApplication = this;
    }

    public static MyApplication getMyApplication() {
        if (myApplication == null)
            synchronized (MyApplication.class) {
                if (myApplication == null)
                    myApplication = new MyApplication();
            }
        return myApplication;
    }




//    public void makeSnackBar(View view, String text) {
//        Snackbar snackbar = null;
//        if (snackbar == null)
//            snackbar.make(view, text, Snackbar.LENGTH_LONG).show();
//    }

}
