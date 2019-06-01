package com.example.carescheduling.Ui.HomeScreen.View;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.HomeScreen.ViewModel.ClientInfoMatchingHistoryViewModel;
import com.example.carescheduling.Ui.HomeScreen.presenter.BackPressedClick;
import com.example.carescheduling.databinding.ClientInfoMatchingHistoryFragmentBinding;

public class ClientInfoMatchingHistoryFragment extends BaseFragment implements BackPressedClick {

    private ClientInfoMatchingHistoryViewModel mViewModel;
    private ClientInfoMatchingHistoryFragmentBinding clientInfoMatchingHistoryFragmentBinding;

    public static ClientInfoMatchingHistoryFragment newInstance() {
        return new ClientInfoMatchingHistoryFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        clientInfoMatchingHistoryFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.client_info_matching_history_fragment
                , container, false);
        View view = clientInfoMatchingHistoryFragmentBinding.getRoot();
        setUpView(view);
        return view;

    }

    private void setUpView(View view) {
        mViewModel = ViewModelProviders.of(this).get(ClientInfoMatchingHistoryViewModel.class);

        clientInfoMatchingHistoryFragmentBinding.setBackPressedClick(this);
    }

    @Override
    public void onBackPress() {
        if (getActivity() != null)
            getActivity().onBackPressed();
    }
}
