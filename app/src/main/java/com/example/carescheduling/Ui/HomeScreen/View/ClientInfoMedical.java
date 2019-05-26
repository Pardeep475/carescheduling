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
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.HomeScreen.ViewModel.ClientInfoMedicalViewModel;
import com.example.carescheduling.Ui.HomeScreen.adapter.ClientInfoMedicationAdapter;
import com.example.carescheduling.databinding.ClientInfoMedicalFragmentBinding;

public class ClientInfoMedical extends BaseFragment {

    private ClientInfoMedicalViewModel mViewModel;
    private ClientInfoMedicalFragmentBinding clientInfoDocumentsFragmentBinding;


    public static ClientInfoMedical newInstance() {
        return new ClientInfoMedical();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        clientInfoDocumentsFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.client_info_medical_fragment, container, false);
        View view = clientInfoDocumentsFragmentBinding.getRoot();
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {

        setUpRecyclerView(view);

        mViewModel = ViewModelProviders.of(this).get(ClientInfoMedicalViewModel.class);
    }

    private void setUpRecyclerView(View view) {
        if (getActivity() != null) {
            clientInfoDocumentsFragmentBinding.rcvClientInfoMedication.setLayoutManager(new LinearLayoutManager(getActivity()));
            ClientInfoMedicationAdapter clientInfoMedicationAdapter = new ClientInfoMedicationAdapter(getActivity());
            clientInfoDocumentsFragmentBinding.rcvClientInfoMedication.setAdapter(clientInfoMedicationAdapter);
        }
    }

}
