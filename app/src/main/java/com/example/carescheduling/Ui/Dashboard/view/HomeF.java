package com.example.carescheduling.Ui.Dashboard.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.Dashboard.Adapter.HomeScreenAdapter;
import com.example.carescheduling.Ui.Dashboard.ViewModel.HomeFViewModel;
import com.example.carescheduling.Ui.Dashboard.beans.ClientBookingListModel;
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
    private HomeFViewModel homeFViewModel;

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

        homeFViewModel = ViewModelProviders.of(this).get(HomeFViewModel.class);
//        getClientBookingList();

        sessionManager = getSessionManager();
        String[] some_array = getResources().getStringArray(R.array.home_array);
        HomeScreenAdapter homeScreenAdapter = new HomeScreenAdapter(getActivity(), this, some_array);
        fragmentHomeBinding.rcvHome.setLayoutManager(new LinearLayoutManager(getActivity()));
        fragmentHomeBinding.rcvHome.setAdapter(homeScreenAdapter);

        fragmentHomeBinding.setClickhandler(this);
    }

    private void getClientBookingList() {
        try {
            showDialog();
            homeFViewModel.getClientBookingList("15C7E260-5818-41AB-A3E7-F6C90F648A1D",
                    "5F98AF4F-25DC-4AC8-B867-C5072C101011",
                    "5F98AF4F-25DC-4AC8-B867-C5072C100000").observe(this, new Observer<ClientBookingListModel>() {
                @Override
                public void onChanged(ClientBookingListModel clientBookingListModel) {
                    hideDialog();
                    if (clientBookingListModel != null && clientBookingListModel.getSuccess() && clientBookingListModel.getData() != null && clientBookingListModel.getData().getBookingClientInformation() != null) {
                        getSessionManager().setClientId(clientBookingListModel.getData().getBookingClientInformation().getClientd());
                    }
                    if (clientBookingListModel != null)
                        Toast.makeText(getActivity(), clientBookingListModel.getResponseMessage().toString(), Toast.LENGTH_SHORT).show();
                }
            });
        } catch (Exception e) {
            hideDialog();
            Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
        }
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
        intent.putExtra("pos", pos);
        startActivity(intent);
    }

    private void setFragment(Fragment fragment) {
        if (getActivity() != null)
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fm_edit_container, fragment).addToBackStack(null).commitAllowingStateLoss();
    }
}
