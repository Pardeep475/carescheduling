package com.example.carescheduling.Ui.HomeScreen.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.HomeScreen.ViewModel.ClientDisabilitiesViewModel;
import com.example.carescheduling.Ui.HomeScreen.presenter.BackPressedClick;
import com.example.carescheduling.databinding.ClientInfoDisabilitiesFragmentBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
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

        setUpRecyclerView(view);

        clientDisabilitiesViewModel = ViewModelProviders.of(this).get(ClientDisabilitiesViewModel.class);
        clientInfoDisabilitiesFragmentBinding.setBackPressedClick(this);
    }

    private void setUpRecyclerView(View view) {
        if (getActivity() != null) {
            clientInfoDisabilitiesFragmentBinding.disabilitiesRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
//            CarePlanAdapter carePlanAdapter= new CarePlanAdapter(getActivity());
//            clientInfoDisabilitiesFragmentBinding.carePlanRecyclerview.setAdapter(carePlanAdapter);
        }
    }


    @Override
    public void onBackPress() {
        if (getActivity()!= null)
            getActivity().onBackPressed();
    }
}