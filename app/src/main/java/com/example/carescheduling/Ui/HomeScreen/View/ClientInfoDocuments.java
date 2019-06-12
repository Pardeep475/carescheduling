package com.example.carescheduling.Ui.HomeScreen.View;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.Common.Common;
import com.example.carescheduling.Ui.Common.CommonBean;
import com.example.carescheduling.Ui.HomeScreen.ViewModel.ClientInfoDocumentsViewModel;
import com.example.carescheduling.Ui.HomeScreen.adapter.ClientInfoDocumentsAdapter;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientNoteAdapterBean;
import com.example.carescheduling.Ui.HomeScreen.presenter.BackPressedClick;
import com.example.carescheduling.Utils.ConnectivityReceiver;
import com.example.carescheduling.databinding.ClientInfoDocumentsFragmentBinding;

import java.util.ArrayList;

public class ClientInfoDocuments extends BaseFragment implements Common {

    private ClientInfoDocumentsViewModel mViewModel;
    private ClientInfoDocumentsFragmentBinding clientInfoDocumentsFragmentBinding;

    public static ClientInfoDocuments newInstance() {
        return new ClientInfoDocuments();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        clientInfoDocumentsFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.client_info_documents_fragment, container, false);
        View view = clientInfoDocumentsFragmentBinding.getRoot();
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {
        setCommonData();
        mViewModel = ViewModelProviders.of(this).get(ClientInfoDocumentsViewModel.class);

        clientInfoDocumentsFragmentBinding.slDemo.startShimmerAnimation();
        try {
            if (ConnectivityReceiver.isNetworkAvailable(getActivity())) {
                setUpRecyclerView(view);
            } else {
                setNoDataFound();
                Toast.makeText(getActivity(), "please check your internet connection", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            setNoDataFound();
            Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
        }


    }

    private void setCommonData() {
        CommonBean commonBean = new CommonBean();
        commonBean.setLeftImageDrawable(R.drawable.ic_left_back);
        commonBean.setLeftImageVisible(true);
        commonBean.setRightImageDrawable(R.drawable.ic_logout);
        commonBean.setRightImageVisible(false);
        commonBean.setTitle("Documents");
        clientInfoDocumentsFragmentBinding.setCommonData(commonBean);
        clientInfoDocumentsFragmentBinding.setCommonClick(this);
    }

    private void setUpRecyclerView(View view) {

//        //

        mViewModel.getClientDocument(getSessionManager().getCustomerId(),
                getSessionManager().getBranchId(),
                getSessionManager().getClientId()).observe(this, new Observer<ArrayList<ClientNoteAdapterBean>>() {
            @Override
            public void onChanged(ArrayList<ClientNoteAdapterBean> clientNoteAdapterBeans) {
                if (clientNoteAdapterBeans != null && clientNoteAdapterBeans.size() > 0) {
                    clientInfoDocumentsFragmentBinding.rcvClientInfoDocuments.setLayoutManager(new LinearLayoutManager(getActivity()));
                    ClientInfoDocumentsAdapter clientInfoDocumentsAdapter = new ClientInfoDocumentsAdapter(getActivity(), clientNoteAdapterBeans);
                    clientInfoDocumentsFragmentBinding.rcvClientInfoDocuments.setAdapter(clientInfoDocumentsAdapter);
                    setDataOriginal();
                } else {
                    setNoDataFound();
                }
            }
        });

    }


    private void setNoDataFound() {
        clientInfoDocumentsFragmentBinding.slDemo.stopShimmerAnimation();
        clientInfoDocumentsFragmentBinding.slDemo.setVisibility(View.GONE);
        clientInfoDocumentsFragmentBinding.rcvClientInfoDocuments.setVisibility(View.GONE);
        clientInfoDocumentsFragmentBinding.rlNoDataFound.setVisibility(View.VISIBLE);
    }

    private void setDataOriginal() {
        clientInfoDocumentsFragmentBinding.slDemo.stopShimmerAnimation();
        clientInfoDocumentsFragmentBinding.slDemo.setVisibility(View.GONE);
        clientInfoDocumentsFragmentBinding.rcvClientInfoDocuments.setVisibility(View.VISIBLE);
        clientInfoDocumentsFragmentBinding.rlNoDataFound.setVisibility(View.GONE);
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
