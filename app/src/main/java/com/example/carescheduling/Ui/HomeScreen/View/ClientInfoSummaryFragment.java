package com.example.carescheduling.Ui.HomeScreen.View;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.HomeScreen.ViewModel.ClientInfoSummaryViewModel;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientCareSummaryBean;
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
        clientInfoSummaryFragmentBinding.slDemo.startShimmerAnimation();
        mViewModel = ViewModelProviders.of(this).get(ClientInfoSummaryViewModel.class);
        try {
            setUpData();
        } catch (Exception e) {
            setNoDataFound();
            Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
        }

        clientInfoSummaryFragmentBinding.setBackPressedClick(this);
    }

    private void setUpData() {

        mViewModel.getDisabilities("5F98AF4F-25DC-4AC8-B867-C5072C100000",
                "5F98AF4F-25DC-4AC8-B867-C5072C101011",
                "978E55D2-B7B9-49E0-A654-14B70EB1A344").observe(this, new Observer<ClientCareSummaryBean>() {
            @Override
            public void onChanged(ClientCareSummaryBean clientCareSummaryBean) {
                if (clientCareSummaryBean != null) {
                    if (clientCareSummaryBean.getSuccess() && clientCareSummaryBean.getData() != null) {
                        clientInfoSummaryFragmentBinding.setDescription(clientCareSummaryBean.getData().getBriefOverview());
                        setDataOriginal();
                    } else {
                        Toast.makeText(getActivity(), (String) clientCareSummaryBean.getResponseMessage(), Toast.LENGTH_SHORT).show();
                        setNoDataFound();
                    }
                }
                clientInfoSummaryFragmentBinding.slDemo.stopShimmerAnimation();
            }
        });
    }

    private void setNoDataFound() {
        clientInfoSummaryFragmentBinding.slDemo.stopShimmerAnimation();
        clientInfoSummaryFragmentBinding.slDemo.setVisibility(View.GONE);
        clientInfoSummaryFragmentBinding.svSummary.setVisibility(View.GONE);
        clientInfoSummaryFragmentBinding.rlNoDataFound.setVisibility(View.VISIBLE);
    }

    private void setDataOriginal() {
        clientInfoSummaryFragmentBinding.slDemo.stopShimmerAnimation();
        clientInfoSummaryFragmentBinding.slDemo.setVisibility(View.GONE);
        clientInfoSummaryFragmentBinding.svSummary.setVisibility(View.VISIBLE);
        clientInfoSummaryFragmentBinding.rlNoDataFound.setVisibility(View.GONE);
    }


    @Override
    public void onBackPress() {
        if (getActivity() != null)
            getActivity().onBackPressed();
    }
}
