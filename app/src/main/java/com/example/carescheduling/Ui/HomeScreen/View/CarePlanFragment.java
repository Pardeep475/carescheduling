package com.example.carescheduling.Ui.HomeScreen.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.HomeScreen.ViewModel.CarePlanViewModal;
import com.example.carescheduling.Ui.HomeScreen.adapter.CarePlanAdapter;
import com.example.carescheduling.Ui.HomeScreen.presenter.BackPressedClick;
import com.example.carescheduling.databinding.ClientInfoCarePlanFragmentBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

public class CarePlanFragment extends BaseFragment implements BackPressedClick {
    private ClientInfoCarePlanFragmentBinding clientInfoCarePlanFragmentBinding;
    private CarePlanViewModal carePlanViewModal;

    public static CarePlanFragment newInstance() {
        return new CarePlanFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        clientInfoCarePlanFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.client_info_care_plan_fragment, container, false);
        View view = clientInfoCarePlanFragmentBinding.getRoot();
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {

        setUpRecyclerView(view);

        carePlanViewModal = ViewModelProviders.of(this).get(CarePlanViewModal.class);

    }

    private void setUpRecyclerView(View view) {
        if (getActivity() != null) {
            clientInfoCarePlanFragmentBinding.carePlanRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
            CarePlanAdapter carePlanAdapter= new CarePlanAdapter(getActivity());
            clientInfoCarePlanFragmentBinding.carePlanRecyclerview.setAdapter(carePlanAdapter);
        }
    }
    
    
    @Override
    public void onBackPress() {
    if (getActivity()!= null)
        getActivity().onBackPressed();
    }
}