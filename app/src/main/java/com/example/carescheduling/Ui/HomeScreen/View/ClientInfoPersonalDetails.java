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
import com.example.carescheduling.Ui.HomeScreen.ViewModel.ClientInfoPersonalDetailsViewModel;
import com.example.carescheduling.Ui.HomeScreen.presenter.BackPressedClick;
import com.example.carescheduling.databinding.ClientInfoPersonalDetailsFragmentBinding;

public class ClientInfoPersonalDetails extends BaseFragment implements BackPressedClick {

    private ClientInfoPersonalDetailsViewModel mViewModel;
    private ClientInfoPersonalDetailsFragmentBinding clientInfoPersonalDetailsFragmentBinding;

    public static ClientInfoPersonalDetails newInstance() {
        return new ClientInfoPersonalDetails();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        clientInfoPersonalDetailsFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.client_info_personal_details_fragment, container, false);
        View view = clientInfoPersonalDetailsFragmentBinding.getRoot();
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {
        clientInfoPersonalDetailsFragmentBinding.setBackPressedClick(this);

        mViewModel = ViewModelProviders.of(this).get(ClientInfoPersonalDetailsViewModel.class);
    }
    
    @Override
    public void onBackPress() {
        if (getActivity() != null)
            getActivity().onBackPressed();
    }
}
