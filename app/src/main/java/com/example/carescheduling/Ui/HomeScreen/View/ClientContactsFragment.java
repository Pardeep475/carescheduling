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
import com.example.carescheduling.Ui.HomeScreen.ViewModel.ClientContactsViewModel;
import com.example.carescheduling.Ui.HomeScreen.adapter.ClientContactsAdapter;
import com.example.carescheduling.databinding.ClientContactsFragmentBinding;

public class ClientContactsFragment extends BaseFragment {

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

        setUpRecyclerView(view);

        mViewModel = ViewModelProviders.of(this).get(ClientContactsViewModel.class);
    }

    private void setUpRecyclerView(View view) {
        if (getActivity() != null) {
            clientContactsFragmentBinding.rcvClientContacts.setLayoutManager(new LinearLayoutManager(getActivity()));
            ClientContactsAdapter clientContactsAdapter = new ClientContactsAdapter(getActivity());
            clientContactsFragmentBinding.rcvClientContacts.setAdapter(clientContactsAdapter);
        }
    }

}
