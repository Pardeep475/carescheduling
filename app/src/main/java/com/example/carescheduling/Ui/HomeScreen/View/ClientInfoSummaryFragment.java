package com.example.carescheduling.Ui.HomeScreen.View;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.HomeScreen.ViewModel.ClientInfoSummaryViewModel;
import com.example.carescheduling.Ui.HomeScreen.presenter.BackPressedClick;
import com.example.carescheduling.databinding.ClientInfoSummaryFragmentBinding;

public class ClientInfoSummaryFragment extends BaseFragment implements BackPressedClick {

    private ClientInfoSummaryViewModel mViewModel;
private ClientInfoSummaryFragmentBinding clientInfoSummaryFragmentBinding;
    public static ClientInfoSummaryFragment newInstance() {
        return new ClientInfoSummaryFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        clientInfoSummaryFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.client_info_summary_fragment, container, false);
        View view = clientInfoSummaryFragmentBinding.getRoot();
        setUpView(view);
       return view;
    }

    private void setUpView(View view) {
        mViewModel = ViewModelProviders.of(this).get(ClientInfoSummaryViewModel.class);

        clientInfoSummaryFragmentBinding.setBackPressedClick(this);
    }



    @Override
    public void onBackPress() {
        if (getActivity() != null)
            getActivity().onBackPressed();
    }
}
