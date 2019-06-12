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
import com.example.carescheduling.Ui.Common.Common;
import com.example.carescheduling.Ui.Common.CommonBean;
import com.example.carescheduling.Ui.HomeScreen.ViewModel.ClientTasksViewModel;
import com.example.carescheduling.Ui.HomeScreen.adapter.ClientTasksAdapter;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientBookingScreenModel;
import com.example.carescheduling.Ui.HomeScreen.beans.Tasks;
import com.example.carescheduling.databinding.ClientTasksFragmentBinding;

import java.util.ArrayList;

public class ClientTasksFragment extends BaseFragment implements Common {

    private ClientTasksViewModel mViewModel;
    private ArrayList<Tasks> tasksArrayList;
    private ClientTasksFragmentBinding clientTasksFragmentBinding;

    public static ClientTasksFragment newInstance(ArrayList<Tasks> tasksArrayList) {
        ClientTasksFragment clientTasksFragment = new ClientTasksFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("DATA", tasksArrayList);
        clientTasksFragment.setArguments(bundle);
        return clientTasksFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            tasksArrayList = (ArrayList<Tasks>) getArguments().getSerializable("DATA");
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        clientTasksFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.client_tasks_fragment, container, false);
        View view = clientTasksFragmentBinding.getRoot();
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {
        setCommonData();
        setReylerViewData();
        mViewModel = ViewModelProviders.of(this).get(ClientTasksViewModel.class);

    }

    private void setReylerViewData() {
        clientTasksFragmentBinding.rcvClientInfoDocuments.setLayoutManager(new LinearLayoutManager(getActivity()));
        ClientTasksAdapter clientInfoDocumentsAdapter = new ClientTasksAdapter(getActivity(), tasksArrayList);
        clientTasksFragmentBinding.rcvClientInfoDocuments.setAdapter(clientInfoDocumentsAdapter);
    }

    private void setCommonData() {
        CommonBean commonBean = new CommonBean();
        commonBean.setLeftImageDrawable(R.drawable.ic_left_back);
        commonBean.setLeftImageVisible(true);
        commonBean.setRightImageDrawable(R.drawable.ic_logout);
        commonBean.setRightImageVisible(false);
        commonBean.setTitle("Client Tasks");
        clientTasksFragmentBinding.setCommonData(commonBean);
        clientTasksFragmentBinding.setCommonClick(this);
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
