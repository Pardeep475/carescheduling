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
import com.example.carescheduling.Ui.HomeScreen.ViewModel.ClientContactsViewModel;
import com.example.carescheduling.Ui.HomeScreen.adapter.ClientContactsAdapter;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientBookingScreenModel;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientContactsBean;
import com.example.carescheduling.Ui.HomeScreen.presenter.BackPressedClick;
import com.example.carescheduling.Utils.ConnectivityReceiver;
import com.example.carescheduling.databinding.ClientContactsFragmentBinding;

import java.util.ArrayList;

public class ClientContactsFragment extends BaseFragment implements Common {

    private ClientContactsViewModel mViewModel;
    private ClientContactsFragmentBinding clientContactsFragmentBinding;

    public static ClientContactsFragment newInstance() {
        return new ClientContactsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        clientContactsFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.client_contacts_fragment, container, false);
        View view = clientContactsFragmentBinding.getRoot();
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {
        setCommonData();
        mViewModel = ViewModelProviders.of(this).get(ClientContactsViewModel.class);

        clientContactsFragmentBinding.slDemo.startShimmerAnimation();
        try {
            if (ConnectivityReceiver.isNetworkAvailable(getActivity())) {
                setUpRecyclerView(view);
            } else {
                getDataFromRoom();
//                setNoDataFound();
//                Toast.makeText(getActivity(), "please check your internet connection", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            getDataFromRoom();
//            setNoDataFound();
//            Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
        }


    }

    private void setCommonData() {
        CommonBean commonBean = new CommonBean();
        commonBean.setLeftImageDrawable(R.drawable.ic_left_back);
        commonBean.setLeftImageVisible(true);
        commonBean.setRightImageDrawable(R.drawable.ic_logout);
        commonBean.setRightImageVisible(false);
        commonBean.setRightTextVisible(false);
        commonBean.setTitle("Contacts");
        clientContactsFragmentBinding.setCommonData(commonBean);
        clientContactsFragmentBinding.setCommonClick(this);
    }


    private void getDataFromRoom() {

        mViewModel.getDataFromLocal(getActivity(), getSessionManager().getBookingId()).observe(this, new Observer<ArrayList<ClientContactsBean>>() {
            @Override
            public void onChanged(ArrayList<ClientContactsBean> clientContactsBeans) {
                if (clientContactsBeans != null && clientContactsBeans.size() > 0) {
                    clientContactsFragmentBinding.rcvClientContacts.setLayoutManager(new LinearLayoutManager(getActivity()));
                    ClientContactsAdapter clientContactsAdapter = new ClientContactsAdapter(getActivity(), clientContactsBeans);
                    clientContactsFragmentBinding.rcvClientContacts.setAdapter(clientContactsAdapter);
                    setDataOriginal();
                } else {
//                    getDataFromRoom();
                    setNoDataFound();
                }
            }
        });
    }


    private void setUpRecyclerView(View view) {
        http:
//mobile.rota.services/CssMobileRestfulService.svc/GetClientContacts///
        mViewModel.getClientContact(getSessionManager().getCustomerId(),
                getSessionManager().getBranchId(),
                getSessionManager().getClientId()).observe(this, new Observer<ArrayList<ClientContactsBean>>() {
            @Override
            public void onChanged(ArrayList<ClientContactsBean> clientContactsBeans) {
                if (clientContactsBeans != null && clientContactsBeans.size() > 0) {
                    clientContactsFragmentBinding.rcvClientContacts.setLayoutManager(new LinearLayoutManager(getActivity()));
                    ClientContactsAdapter clientContactsAdapter = new ClientContactsAdapter(getActivity(), clientContactsBeans);
                    clientContactsFragmentBinding.rcvClientContacts.setAdapter(clientContactsAdapter);
                    setDataOriginal();
                } else {
                    getDataFromRoom();
//                    setNoDataFound();
                }
            }
        });
    }

    private void setNoDataFound() {
        clientContactsFragmentBinding.slDemo.stopShimmerAnimation();
        clientContactsFragmentBinding.slDemo.setVisibility(View.GONE);
        clientContactsFragmentBinding.rcvClientContacts.setVisibility(View.GONE);
        clientContactsFragmentBinding.rlNoDataFound.setVisibility(View.VISIBLE);
    }

    private void setDataOriginal() {
        clientContactsFragmentBinding.slDemo.stopShimmerAnimation();
        clientContactsFragmentBinding.slDemo.setVisibility(View.GONE);
        clientContactsFragmentBinding.rcvClientContacts.setVisibility(View.VISIBLE);
        clientContactsFragmentBinding.rlNoDataFound.setVisibility(View.GONE);
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
