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
import com.example.carescheduling.Ui.HomeScreen.ViewModel.ClientInfoNotesViewModel;
import com.example.carescheduling.Ui.HomeScreen.presenter.BackPressedClick;
import com.example.carescheduling.databinding.ClientInfoNotesFragmentBinding;

public class ClientInfoNotesFragment extends BaseFragment implements BackPressedClick {

    private ClientInfoNotesViewModel mViewModel;
    private ClientInfoNotesFragmentBinding clientInfoNotesFragmentBinding;

    public static ClientInfoNotesFragment newInstance() {
        return new ClientInfoNotesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        clientInfoNotesFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.client_info_notes_fragment
                , container, false);
        View view = clientInfoNotesFragmentBinding.getRoot();
        setUpView(view);
        return view;

    }

    private void setUpView(View view) {
        mViewModel = ViewModelProviders.of(this).get(ClientInfoNotesViewModel.class);

        clientInfoNotesFragmentBinding.setBackPressedClick(this);
    }

    @Override
    public void onBackPress() {
        if (getActivity() != null)
            getActivity().onBackPressed();
    }

}
