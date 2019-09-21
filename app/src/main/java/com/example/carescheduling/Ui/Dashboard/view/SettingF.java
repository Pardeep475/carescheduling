package com.example.carescheduling.Ui.Dashboard.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.Common.Common;
import com.example.carescheduling.Ui.Common.CommonBean;
import com.example.carescheduling.Ui.Dashboard.presenter.ProfileClickHandler;
import com.example.carescheduling.Ui.LoginActivity.View.LoginActivity;
import com.example.carescheduling.data.Local.AppDataBase;
import com.example.carescheduling.databinding.FragmentSettingBinding;

public class SettingF extends BaseFragment implements Common {

    private FragmentSettingBinding fragmentSettingBinding;

    // TODO: Rename and change types and number of parameters
    public static SettingF newInstance() {

        return new SettingF();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentSettingBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_setting
                , container, false);
        View view = fragmentSettingBinding.getRoot();
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {
        setCommonData();
        sessionManager = getSessionManager();

    }

    private void setCommonData() {
        CommonBean commonBean = new CommonBean();
        commonBean.setLeftImageDrawable(R.drawable.ic_left_back);
        commonBean.setLeftImageVisible(false);
        commonBean.setRightImageDrawable(R.drawable.ic_logout);
        commonBean.setRightImageVisible(true);
        commonBean.setTitle("Settings");
        commonBean.setRightTextVisible(false);
        fragmentSettingBinding.setCommonData(commonBean);
        fragmentSettingBinding.setCommonClick(this);
    }


    @Override
    public void leftClick() {

    }

    @Override
    public void rightClick() {
        if (getActivity() != null) {
            sessionManager.cleanAllData();
            AppDataBase.getAppDatabase(getActivity()).clearAllTables();
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK  );
            startActivity(intent);
            getActivity().finish();
        }
    }
}
