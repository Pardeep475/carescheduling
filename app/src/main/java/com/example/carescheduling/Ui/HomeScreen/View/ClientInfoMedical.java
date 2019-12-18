package com.example.carescheduling.Ui.HomeScreen.View;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.Common.Common;
import com.example.carescheduling.Ui.Common.CommonBean;
import com.example.carescheduling.Ui.HomeScreen.ViewModel.ClientInfoMedicalViewModel;
import com.example.carescheduling.Ui.HomeScreen.adapter.ClientInfoMedicationAdapter;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientBookingScreenModel;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientMedicalBeanAdapter;
import com.example.carescheduling.Ui.HomeScreen.presenter.BackPressedClick;
import com.example.carescheduling.Utils.ConnectivityReceiver;
import com.example.carescheduling.databinding.ClientInfoMedicalFragmentBinding;

import java.util.ArrayList;

public class ClientInfoMedical extends BaseFragment implements Common {

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
        setCommonData();
        mViewModel = ViewModelProviders.of(this).get(ClientInfoMedicalViewModel.class);
//        setUpRecyclerView(view);
        setDataOriginal();
        try {
            if (ConnectivityReceiver.isNetworkAvailable(getActivity())) {
                getClientTabletsInfo();
            } else {
                getDataFromRoom();
            }
        } catch (Exception e) {
            getDataFromRoom();
            hideDialog();
            Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
        }

    }

    private void getDataFromRoom() {
        mViewModel.getDataFromLocal(getActivity(), getSessionManager().getBookingId()).observe(this,new Observer<ArrayList<ClientMedicalBeanAdapter>>() {
            @Override
            public void onChanged(ArrayList<ClientMedicalBeanAdapter> clientMedicalBeanAdapters) {
                if (getActivity() != null && clientMedicalBeanAdapters != null && clientMedicalBeanAdapters.size() > 0) {
                    clientInfoDocumentsFragmentBinding.rcvClientInfoMedication.setLayoutManager(new LinearLayoutManager(getActivity()));
                    ClientInfoMedicationAdapter clientInfoMedicationAdapter = new ClientInfoMedicationAdapter(getActivity(), clientMedicalBeanAdapters);
                    clientInfoDocumentsFragmentBinding.rcvClientInfoMedication.setAdapter(clientInfoMedicationAdapter);
                    clientInfoDocumentsFragmentBinding.rcvClientInfoMedication.hideShimmerAdapter();
                } else {
                    setNoDataFound();
                }

            }
        });
    }


    private void setCommonData() {
        CommonBean commonBean = new CommonBean();
        commonBean.setLeftImageDrawable(R.drawable.ic_left_back);
        commonBean.setLeftImageVisible(true);
        commonBean.setRightImageDrawable(R.drawable.ic_logout);
        commonBean.setRightImageVisible(false);
        commonBean.setRightTextVisible(false);
        commonBean.setTitle(getString(R.string.medication));
        clientInfoDocumentsFragmentBinding.setCommonData(commonBean);
        clientInfoDocumentsFragmentBinding.setCommonClick(this);
    }

//    private void setUpRecyclerView(View view) {
//        if (getActivity() != null) {
//            clientInfoDocumentsFragmentBinding.rcvClientInfoMedication.setLayoutManager(new LinearLayoutManager(getActivity()));
//            ClientInfoMedicationAdapter clientInfoMedicationAdapter = new ClientInfoMedicationAdapter(getActivity());
//            clientInfoDocumentsFragmentBinding.rcvClientInfoMedication.setAdapter(clientInfoMedicationAdapter);
//        }
//    }


    @Override
    public void leftClick() {
        if (getActivity() != null)
            getActivity().onBackPressed();
    }

    @Override
    public void rightClick() {

    }

    private void getClientTabletsInfo() {
//        http://mobile.rota.services/CssMobileRestfulService.svc/GetClientMadicals///
        mViewModel.getClientMedical(getSessionManager().getCustomerId(),
                getSessionManager().getBranchId(),
                getSessionManager().getClientId()).observe(this, new Observer<ArrayList<ClientMedicalBeanAdapter>>() {
            @Override
            public void onChanged(ArrayList<ClientMedicalBeanAdapter> clientMedicalBeanAdapters) {
                if (getActivity() != null && clientMedicalBeanAdapters != null && clientMedicalBeanAdapters.size() > 0) {
                    clientInfoDocumentsFragmentBinding.rcvClientInfoMedication.setLayoutManager(new LinearLayoutManager(getActivity()));
                    ClientInfoMedicationAdapter clientInfoMedicationAdapter = new ClientInfoMedicationAdapter(getActivity(), clientMedicalBeanAdapters);
                    clientInfoDocumentsFragmentBinding.rcvClientInfoMedication.setAdapter(clientInfoMedicationAdapter);
                    clientInfoDocumentsFragmentBinding.rcvClientInfoMedication.hideShimmerAdapter();
                } else {
                    getDataFromRoom();
                }

            }
        });
    }

    private void setNoDataFound() {
        clientInfoDocumentsFragmentBinding.rcvClientInfoMedication.hideShimmerAdapter();
        clientInfoDocumentsFragmentBinding.rcvClientInfoMedication.setVisibility(View.GONE);
        clientInfoDocumentsFragmentBinding.rlNoDataFound.setVisibility(View.VISIBLE);
    }

    private void setDataOriginal() {
        clientInfoDocumentsFragmentBinding.rcvClientInfoMedication.showShimmerAdapter();
        clientInfoDocumentsFragmentBinding.rcvClientInfoMedication.setVisibility(View.VISIBLE);
        clientInfoDocumentsFragmentBinding.rlNoDataFound.setVisibility(View.GONE);
    }
}
