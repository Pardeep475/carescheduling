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

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Dashboard.Adapter.HomeScreenAdapter;
import com.example.carescheduling.Ui.Dashboard.presenter.HomeScreenOnClick;
import com.example.carescheduling.Ui.HomeScreen.ViewModel.DirectionsViewModel;
import com.example.carescheduling.Ui.HomeScreen.ViewModel.TodaysVisitViewModel;
import com.example.carescheduling.Ui.HomeScreen.presenter.TodaysVisitClick;
import com.example.carescheduling.databinding.TodaysVisitFragmentBinding;

public class TodaysVisitFragment extends Fragment implements HomeScreenOnClick , TodaysVisitClick {

    private TodaysVisitViewModel mViewModel;
    private TodaysVisitFragmentBinding todaysVisitFragmentBinding;

    public static TodaysVisitFragment newInstance() {
        return new TodaysVisitFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        todaysVisitFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.todays_visit_fragment
                , container, false);
        View view = todaysVisitFragmentBinding.getRoot();
        setUpView(view);
        return view;
    }


    private void setUpView(View view) {
        mViewModel = ViewModelProviders.of(this).get(TodaysVisitViewModel.class);

        String[] some_array = getResources().getStringArray(R.array.todays_visit_array);
        HomeScreenAdapter homeScreenAdapter = new HomeScreenAdapter(getActivity(), this, some_array);
        todaysVisitFragmentBinding.rcvDirection.setLayoutManager(new LinearLayoutManager(getActivity()));
        todaysVisitFragmentBinding.rcvDirection.setAdapter(homeScreenAdapter);
        todaysVisitFragmentBinding.setTodaysVisitCLick(this);
    }


    @Override
    public void OnClickHomeScreen(int pos) {

    }

    @Override
    public void onBackPress() {
        if (getActivity() != null)
            getActivity().onBackPressed();
    }
}