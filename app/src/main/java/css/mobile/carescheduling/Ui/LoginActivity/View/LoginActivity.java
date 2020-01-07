package css.mobile.carescheduling.Ui.LoginActivity.View;

import android.os.Bundle;

import css.mobile.carescheduling.R;
import css.mobile.carescheduling.Ui.Base.BaseActivity;


public class LoginActivity extends BaseActivity/* implements LoginPresenter*/ {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportFragmentManager().beginTransaction().replace(R.id.rl_main_login, LoginF.newInstance()).commitAllowingStateLoss();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

}
