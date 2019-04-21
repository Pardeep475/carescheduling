package com.example.carescheduling.Ui.Dashboard.view;

import android.os.Bundle;

import androidx.annotation.NonNull;

import com.example.carescheduling.R;
import com.example.carescheduling.databinding.ActivityDashboardBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.MenuItem;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {

    private ActivityDashboardBinding activityDashboardBinding;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    setFragment(SettingF.newInstance());
                    return true;
                case R.id.navigation_dashboard:
                    setFragment(HomeF.newInstance());
                    return true;
                case R.id.navigation_notifications:
                    setFragment(ProfileF.newInstance());
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDashboardBinding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard);
        activityDashboardBinding.navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        setFragment(SettingF.newInstance());
    }

    private void setFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_dashboard_main_container, fragment).commitAllowingStateLoss();
    }

}
