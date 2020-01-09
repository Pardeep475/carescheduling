package css.mobile.carescheduling.Splash.View;

import androidx.annotation.Nullable;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.arover.moment.Moment;

import css.mobile.carescheduling.R;
import css.mobile.carescheduling.Ui.Base.BaseActivity;
import css.mobile.carescheduling.Ui.Dashboard.view.Dashboard;
import css.mobile.carescheduling.Ui.LoginActivity.View.LoginActivity;
import css.mobile.carescheduling.Utils.FullScreenDialog;
import css.mobile.carescheduling.data.Local.SessionManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplashActivity extends BaseActivity {
    private Handler myHandler = new Handler();
    private SessionManager sessionManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        formatDate();
        initialSetUp();
//
//        FullScreenDialog fullScreenDialog = new FullScreenDialog();
//        fullScreenDialog.show(getSupportFragmentManager(), "FullScreenDialog");
    }

    private void initialSetUp() {
        sessionManager = getSessionManager();
        myHandler.postDelayed(runnable, 3000);
    }


    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (sessionManager.IsUserLogin()) {
                Intent intent = new Intent(SplashActivity.this, Dashboard.class);
                startActivity(intent);
                finish();
            } else {
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myHandler.removeCallbacks(runnable);
    }

    public void formatDate() {
//        /Date(1560663000000+0530)/
//        valueFromParanThics();
//        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
//        try {
//            Date d = sdf.parse("20130526160000");
//            Log.e("DateValue", ""+d);
//        } catch (ParseException ex) {
//            Log.e("DateValue", ex.getLocalizedMessage());
//        }

        String example = "/Date(1560663000000+0530)/";
        try {
            Moment moment = new Moment(example, "MM/dd/yyyy");
            moment.display();
        } catch (ParseException ex) {
            Log.e("DateValue", ex.getLocalizedMessage());
        }
    }

    public void valueFromParanThics() {
        String example = "/Date(1560663000000+0530)/";
        Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(example);
        while (m.find()) {
            String dateValue = m.group(1);
            String splitted[] = dateValue.split("\\+", 2); // will be matched 1 times.
            long firstValue = Long.valueOf(splitted[0]);
            long secondValue = Integer.valueOf(splitted[1]);
            Log.e("DateValue", firstValue + "    " + secondValue);
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
            try {
                long finalValue = firstValue + secondValue;
                Date d = sdf.parse(String.valueOf(finalValue));
                Log.e("DateValue", "" + d);
            } catch (ParseException ex) {
                Log.e("DateValue", ex.getLocalizedMessage());
            }


            System.out.println(m.group(1));
        }
    }
}
