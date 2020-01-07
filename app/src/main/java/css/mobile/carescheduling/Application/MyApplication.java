package css.mobile.carescheduling.Application;

import android.app.Application;
import android.app.Dialog;

import androidx.appcompat.app.AppCompatDelegate;


public class MyApplication extends Application {
      private Dialog progressDialog;
    private static volatile MyApplication myApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
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

}
