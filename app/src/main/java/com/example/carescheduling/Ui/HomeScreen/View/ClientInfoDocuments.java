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
import com.example.carescheduling.Ui.HomeScreen.ViewModel.ClientInfoDocumentsViewModel;
import com.example.carescheduling.Ui.HomeScreen.adapter.ClientInfoDocumentsAdapter;
import com.example.carescheduling.databinding.ClientInfoDocumentsFragmentBinding;

public class ClientInfoDocuments extends BaseFragment {

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

        setUpRecyclerView(view);

        mViewModel = ViewModelProviders.of(this).get(ClientInfoDocumentsViewModel.class);
    }

    private void setUpRecyclerView(View view) {
        if (getActivity() != null) {
            clientInfoDocumentsFragmentBinding.rcvClientInfoDocuments.setLayoutManager(new LinearLayoutManager(getActivity()));
            ClientInfoDocumentsAdapter clientInfoDocumentsAdapter = new ClientInfoDocumentsAdapter(getActivity());
            clientInfoDocumentsFragmentBinding.rcvClientInfoDocuments.setAdapter(clientInfoDocumentsAdapter);
        }
    }


}
