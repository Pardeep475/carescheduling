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
import com.example.carescheduling.Ui.HomeScreen.ViewModel.HoursAndExspensesViewModel;
import com.example.carescheduling.Ui.HomeScreen.presenter.HoursAndExpensesCLick;
import com.example.carescheduling.databinding.HoursAndExspensesFragmentBinding;

public class HoursAndExspenses extends Fragment implements HomeScreenOnClick, HoursAndExpensesCLick {

    private HoursAndExspensesViewModel mViewModel;
    private HoursAndExspensesFragmentBinding hoursAndExspensesFragmentBinding;

    public static HoursAndExspenses newInstance() {
        return new HoursAndExspenses();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        hoursAndExspensesFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.hours_and_exspenses_fragment
                , container, false);
        View view = hoursAndExspensesFragmentBinding.getRoot();
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {
        mViewModel = ViewModelProviders.of(this).get(HoursAndExspensesViewModel.class);

        String[] some_array = getResources().getStringArray(R.array.hours_and_exspenses_array);
        HomeScreenAdapter homeScreenAdapter = new HomeScreenAdapter(getActivity(), this, some_array);
        hoursAndExspensesFragmentBinding.rcvDirection.setLayoutManager(new LinearLayoutManager(getActivity()));
        hoursAndExspensesFragmentBinding.rcvDirection.setAdapter(homeScreenAdapter);
        hoursAndExspensesFragmentBinding.setHoursAndExpensesCLick(this);
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
