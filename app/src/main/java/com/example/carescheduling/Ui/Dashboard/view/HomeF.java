package com.example.carescheduling.Ui.Dashboard.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.Dashboard.Adapter.HomeScreenAdapter;
import com.example.carescheduling.Ui.Dashboard.beans.HomeScreenBean;
import com.example.carescheduling.Ui.Dashboard.presenter.HomeScreenOnClick;
import com.example.carescheduling.Ui.Dashboard.presenter.ProfileClickHandler;
import com.example.carescheduling.Ui.HomeScreen.View.BlankFragment;
import com.example.carescheduling.Ui.LoginActivity.View.LoginActivity;
import com.example.carescheduling.Ui.Profile.View.EditProfile;
import com.example.carescheduling.databinding.FragmentHomeBinding;

public class HomeF extends BaseFragment implements ProfileClickHandler, HomeScreenOnClick {
    private FragmentHomeBinding fragmentHomeBinding;
    private HomeScreenBean homeScreenBean;

    // TODO: Rename and change types and number of parameters
    public static HomeF newInstance() {
        return new HomeF();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home
                , container, false);
        View view = fragmentHomeBinding.getRoot();
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {
        homeScreenBean = new HomeScreenBean();
        homeScreenBean.setName("pardeep");
        homeScreenBean.setPassword("12345");
        sessionManager = getSessionManager();
        String[] some_array = getResources().getStringArray(R.array.home_array);
        HomeScreenAdapter homeScreenAdapter = new HomeScreenAdapter(getActivity(), this, some_array);
        fragmentHomeBinding.rcvHome.setLayoutManager(new LinearLayoutManager(getActivity()));
        fragmentHomeBinding.rcvHome.setAdapter(homeScreenAdapter);

        fragmentHomeBinding.setClickhandler(this);
    }

    @Override
    public void logout() {
        sessionManager.cleanAllData();
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        getActivity().finish();
    }

    @Override
    public void OnClickHomeScreen(int pos) {
        homeScreenBean.setName(homeScreenBean.getName() + " " + pos);
        Intent intent = new Intent(getActivity(), EditProfile.class);
        intent.putExtra("pos",pos);
        startActivity(intent);
    }

    private void setFragment(Fragment fragment) {
        if (getActivity() != null)
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fm_edit_container, fragment).addToBackStack(null).commitAllowingStateLoss();
    }
}
