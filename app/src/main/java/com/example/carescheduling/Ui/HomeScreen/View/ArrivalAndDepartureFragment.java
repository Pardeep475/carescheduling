package com.example.carescheduling.Ui.HomeScreen.View;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.HomeScreen.ViewModel.ArrivalAndDepartureViewModel;

public class ArrivalAndDepartureFragment extends Fragment {

    private ArrivalAndDepartureViewModel mViewModel;

    public static ArrivalAndDepartureFragment newInstance() {
        return new ArrivalAndDepartureFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.arrival_and_departure_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ArrivalAndDepartureViewModel.class);
        // TODO: Use the ViewModel
    }

}
