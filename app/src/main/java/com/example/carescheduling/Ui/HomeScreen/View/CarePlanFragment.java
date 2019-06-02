package com.example.carescheduling.Ui.HomeScreen.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.HomeScreen.ViewModel.CarePlanViewModal;
import com.example.carescheduling.Ui.HomeScreen.adapter.CarePlanAdapter;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientCarePlan;
import com.example.carescheduling.Ui.HomeScreen.presenter.BackPressedClick;
import com.example.carescheduling.Ui.HomeScreen.presenter.CarePlanAdapterClick;
import com.example.carescheduling.databinding.ClientInfoCarePlanFragmentBinding;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

public class CarePlanFragment extends BaseFragment implements BackPressedClick, CarePlanAdapterClick {
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
        carePlanViewModal = ViewModelProviders.of(this).get(CarePlanViewModal.class);
        
        clientInfoCarePlanFragmentBinding.slDemo.startShimmerAnimation();
        try {
            setUpRecyclerView(view);
        } catch (Exception e) {
            setNoDataFound();
            Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
        }
        clientInfoCarePlanFragmentBinding.setBackPressedClick(this);
    }

    private void setUpRecyclerView(View view) {
        if (getActivity() != null) {

            carePlanViewModal.getCarePlan("5F98AF4F-25DC-4AC8-B867-C5072C100000",
                    "5F98AF4F-25DC-4AC8-B867-C5072C101011",
                    "978E55D2-B7B9-49E0-A654-14B70EB1A344").observe(this, new Observer<ArrayList<ClientCarePlan.Datum>>() {
                @Override
                public void onChanged(ArrayList<ClientCarePlan.Datum> data) {
                    if (data !=null) {
                        clientInfoCarePlanFragmentBinding.carePlanRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
                        CarePlanAdapter carePlanAdapter = new CarePlanAdapter(getActivity(), CarePlanFragment.this, data);
                        clientInfoCarePlanFragmentBinding.carePlanRecyclerview.setAdapter(carePlanAdapter);
                        setDataOriginal();
                    }else{
                        setNoDataFound();
                    }
                }
            });
        }
    }




    private void setNoDataFound() {
        clientInfoCarePlanFragmentBinding.slDemo.stopShimmerAnimation();
        clientInfoCarePlanFragmentBinding.slDemo.setVisibility(View.GONE);
        clientInfoCarePlanFragmentBinding.carePlanRecyclerview.setVisibility(View.GONE);
        clientInfoCarePlanFragmentBinding.rlNoDataFound.setVisibility(View.VISIBLE);
    }

    private void setDataOriginal() {
        clientInfoCarePlanFragmentBinding.slDemo.stopShimmerAnimation();
        clientInfoCarePlanFragmentBinding.slDemo.setVisibility(View.GONE);
        clientInfoCarePlanFragmentBinding.carePlanRecyclerview.setVisibility(View.VISIBLE);
        clientInfoCarePlanFragmentBinding.rlNoDataFound.setVisibility(View.GONE);
    }
    
    
    @Override
    public void onBackPress() {
    if (getActivity()!= null)
        getActivity().onBackPressed();
    }

    @Override
    public void mondayClick(int pos) {

    }

    @Override
    public void tuesdayClick(int pos) {

    }

    @Override
    public void wednesdayClick(int pos) {

    }

    @Override
    public void thursdayClick(int pos) {

    }

    @Override
    public void fridayClick(int pos) {

    }

    @Override
    public void saturdayClick(int pos) {

    }

    @Override
    public void sundayClick(int pos) {

    }
}