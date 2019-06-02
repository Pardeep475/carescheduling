package com.example.carescheduling.Ui.HomeScreen.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.HomeScreen.ViewModel.ClientDisabilitiesViewModel;
import com.example.carescheduling.Ui.HomeScreen.adapter.ClientDisabilitiesAdapter;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientDisabilityBean;
import com.example.carescheduling.Ui.HomeScreen.presenter.BackPressedClick;
import com.example.carescheduling.databinding.ClientInfoDisabilitiesFragmentBinding;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

public class ClientDisabilitiesFragment extends BaseFragment implements BackPressedClick {
    private ClientInfoDisabilitiesFragmentBinding clientInfoDisabilitiesFragmentBinding;
    private ClientDisabilitiesViewModel clientDisabilitiesViewModel;

    public static ClientDisabilitiesFragment newInstance() {
        return new ClientDisabilitiesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        clientInfoDisabilitiesFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.client_info_disabilities_fragment, container, false);
        View view = clientInfoDisabilitiesFragmentBinding.getRoot();
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {
        clientDisabilitiesViewModel = ViewModelProviders.of(this).get(ClientDisabilitiesViewModel.class);

        clientInfoDisabilitiesFragmentBinding.slDemo.startShimmerAnimation();
        try {
            setUpRecyclerView(view);
        } catch (Exception e) {
            setNoDataFound();
            Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
        }

        clientInfoDisabilitiesFragmentBinding.setBackPressedClick(this);
    }

    private void setUpRecyclerView(View view) {
        clientDisabilitiesViewModel.getDisabilities("5F98AF4F-25DC-4AC8-B867-C5072C100000",
                "5F98AF4F-25DC-4AC8-B867-C5072C101011",
                "978E55D2-B7B9-49E0-A654-14B70EB1A344").observe(this
                , new Observer<ArrayList<ClientDisabilityBean.Datum>>() {
                    @Override
                    public void onChanged(ArrayList<ClientDisabilityBean.Datum> data) {
                        if (data != null) {
                            clientInfoDisabilitiesFragmentBinding.disabilitiesRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
                            ClientDisabilitiesAdapter clientDisabilitiesAdapter = new ClientDisabilitiesAdapter(getActivity(), data);
                            clientInfoDisabilitiesFragmentBinding.disabilitiesRecyclerview.setAdapter(clientDisabilitiesAdapter);
                            setDataOriginal();
                        } else {
                            setNoDataFound();
                        }
                    }
                });

    }

    private void setNoDataFound() {
        clientInfoDisabilitiesFragmentBinding.slDemo.stopShimmerAnimation();
        clientInfoDisabilitiesFragmentBinding.slDemo.setVisibility(View.GONE);
        clientInfoDisabilitiesFragmentBinding.disabilitiesRecyclerview.setVisibility(View.GONE);
        clientInfoDisabilitiesFragmentBinding.rlNoDataFound.setVisibility(View.VISIBLE);
    }

    private void setDataOriginal() {
        clientInfoDisabilitiesFragmentBinding.slDemo.stopShimmerAnimation();
        clientInfoDisabilitiesFragmentBinding.slDemo.setVisibility(View.GONE);
        clientInfoDisabilitiesFragmentBinding.disabilitiesRecyclerview.setVisibility(View.VISIBLE);
        clientInfoDisabilitiesFragmentBinding.rlNoDataFound.setVisibility(View.GONE);
    }


    @Override
    public void onBackPress() {
        if (getActivity() != null)
            getActivity().onBackPressed();
    }
}