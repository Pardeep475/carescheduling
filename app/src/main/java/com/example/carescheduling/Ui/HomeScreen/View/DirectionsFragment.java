package com.example.carescheduling.Ui.HomeScreen.View;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.Common.Common;
import com.example.carescheduling.Ui.Common.CommonBean;
import com.example.carescheduling.Ui.Dashboard.Adapter.HomeScreenAdapter;
import com.example.carescheduling.Ui.Dashboard.presenter.HomeScreenOnClick;
import com.example.carescheduling.Ui.HomeScreen.ViewModel.DirectionsViewModel;
import com.example.carescheduling.Ui.HomeScreen.presenter.DirectionClick;
import com.example.carescheduling.databinding.DirectionsFragmentBinding;

public class DirectionsFragment extends BaseFragment implements Common, HomeScreenOnClick {
    private DirectionsViewModel mViewModel;
    private DirectionsFragmentBinding directionsFragmentBinding;

    public static DirectionsFragment newInstance() {
        return new DirectionsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        directionsFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.directions_fragment
                , container, false);
        View view = directionsFragmentBinding.getRoot();
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {
        setCommonData();
        mViewModel = ViewModelProviders.of(this).get(DirectionsViewModel.class);

        String[] some_array = getResources().getStringArray(R.array.directions_array);
        HomeScreenAdapter homeScreenAdapter = new HomeScreenAdapter(getActivity(), this, some_array);
        directionsFragmentBinding.rcvDirection.setLayoutManager(new LinearLayoutManager(getActivity()));
        directionsFragmentBinding.rcvDirection.setAdapter(homeScreenAdapter);

    }

    private void setCommonData() {
        CommonBean commonBean = new CommonBean();
        commonBean.setLeftImageDrawable(R.drawable.ic_left_back);
        commonBean.setLeftImageVisible(true);
        commonBean.setRightImageDrawable(R.drawable.ic_logout);
        commonBean.setRightImageVisible(false);
        commonBean.setRightTextVisible(false);
        commonBean.setTitle("Directions");
        directionsFragmentBinding.setCommonData(commonBean);
        directionsFragmentBinding.setCommonClick(this);
    }

    @Override
    public void OnClickHomeScreen(int pos) {

    }

    @Override
    public void leftClick() {
        if (getActivity() != null)
            getActivity().onBackPressed();
    }

    @Override
    public void rightClick() {

    }
}
