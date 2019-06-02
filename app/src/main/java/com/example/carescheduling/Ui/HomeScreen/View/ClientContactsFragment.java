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
import com.example.carescheduling.Ui.HomeScreen.ViewModel.ClientContactsViewModel;
import com.example.carescheduling.Ui.HomeScreen.adapter.ClientContactsAdapter;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientContactsBean;
import com.example.carescheduling.Ui.HomeScreen.presenter.BackPressedClick;
import com.example.carescheduling.databinding.ClientContactsFragmentBinding;

import java.util.ArrayList;

public class ClientContactsFragment extends BaseFragment implements BackPressedClick {

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
        mViewModel = ViewModelProviders.of(this).get(ClientContactsViewModel.class);

        clientContactsFragmentBinding.slDemo.startShimmerAnimation();
        try {
            setUpRecyclerView(view);
        } catch (Exception e) {
            setNoDataFound();
            Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
        }

        clientContactsFragmentBinding.setBackPressedClick(this);
    }

    private void setUpRecyclerView(View view) {
            mViewModel.getClientContact("5F98AF4F-25DC-4AC8-B867-C5072C100000",
                    "5F98AF4F-25DC-4AC8-B867-C5072C101011",
                    "978E55D2-B7B9-49E0-A654-14B70EB1A344").observe(this, new Observer<ArrayList<ClientContactsBean>>() {
                @Override
                public void onChanged(ArrayList<ClientContactsBean> clientContactsBeans) {
                    if (clientContactsBeans != null) {
                        clientContactsFragmentBinding.rcvClientContacts.setLayoutManager(new LinearLayoutManager(getActivity()));
                        ClientContactsAdapter clientContactsAdapter = new ClientContactsAdapter(getActivity(), clientContactsBeans);
                        clientContactsFragmentBinding.rcvClientContacts.setAdapter(clientContactsAdapter);
                        setDataOriginal();
                    }else{
                        setNoDataFound();
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
    public void onBackPress() {
if (getActivity() != null)
    getActivity().onBackPressed();
    }
}
