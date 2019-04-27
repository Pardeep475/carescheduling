package com.example.carescheduling.Ui.Dashboard.view;

import android.os.Bundle;

import androidx.annotation.NonNull;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseActivity;
import com.example.carescheduling.Ui.Dashboard.ViewModel.DashboardViewModel;
import com.example.carescheduling.Ui.Dashboard.beans.EditMyProfile;
import com.example.carescheduling.data.Local.SessionManager;
import com.example.carescheduling.databinding.ActivityDashboardBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.MenuItem;

public class Dashboard extends BaseActivity {

    private ActivityDashboardBinding activityDashboardBinding;
    private DashboardViewModel dashboardViewModel;
    private SessionManager sessionManager;

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
                    setFragment(ProfileResult.newInstance());
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDashboardBinding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard);
        sessionManager = getSessionManager();
        dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel.class);
        activityDashboardBinding.navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        setFragment(SettingF.newInstance());
        LiveData<EditMyProfile> editMyProfileLiveData = dashboardViewModel.getEditMyProfileData(sessionManager.getCustomerId());
        editMyProfileLiveData.observe(this, new Observer<EditMyProfile>() {
            @Override
            public void onChanged(EditMyProfile editMyProfile) {
           EditMyProfile myProfile = editMyProfile;
            }
        });
    }

    private void setFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_dashboard_main_container, fragment).commitAllowingStateLoss();
    }

}
