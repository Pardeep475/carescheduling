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
import com.example.carescheduling.Ui.HomeScreen.ViewModel.ClientInfoDocumentsViewModel;
import com.example.carescheduling.Ui.HomeScreen.adapter.ClientInfoDocumentsAdapter;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientNoteAdapterBean;
import com.example.carescheduling.Ui.HomeScreen.presenter.BackPressedClick;
import com.example.carescheduling.databinding.ClientInfoDocumentsFragmentBinding;

import java.util.ArrayList;

public class ClientInfoDocuments extends BaseFragment implements BackPressedClick {

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
        mViewModel = ViewModelProviders.of(this).get(ClientInfoDocumentsViewModel.class);

        clientInfoDocumentsFragmentBinding.slDemo.startShimmerAnimation();
        try {
            setUpRecyclerView(view);
        } catch (Exception e) {
            setNoDataFound();
            Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
        }

        clientInfoDocumentsFragmentBinding.setBackPressedClick(this);
    }

    private void setUpRecyclerView(View view) {
        mViewModel.getClientDocument("5F98AF4F-25DC-4AC8-B867-C5072C100000",
                "C38D6479-7CAC-4F77-8AAA-05B0E0F7C88F",
                "5F98AF4F-25DC-4AC8-B867-C5072C101011").observe(this, new Observer<ArrayList<ClientNoteAdapterBean>>() {
            @Override
            public void onChanged(ArrayList<ClientNoteAdapterBean> clientNoteAdapterBeans) {
                if (clientNoteAdapterBeans != null && clientNoteAdapterBeans.size()>0) {
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
    public void onBackPress() {
        if (getActivity() != null)
            getActivity().onBackPressed();
    }
}
