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
import com.example.carescheduling.Ui.HomeScreen.ViewModel.BlankViewModel;
import com.example.carescheduling.Ui.HomeScreen.presenter.MyNextVisitClick;
import com.example.carescheduling.databinding.BlankFragmentBinding;

public class BlankFragment extends Fragment implements MyNextVisitClick {

    private BlankViewModel mViewModel;
    private BlankFragmentBinding blankFragmentBinding;

    public static BlankFragment newInstance() {
        return new BlankFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        blankFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.blank_fragment, container, false);
        View view = blankFragmentBinding.getRoot();
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {
        mViewModel = ViewModelProviders.of(this).get(BlankViewModel.class);
        blankFragmentBinding.setMyNextVisitClick(this);
    }

    @Override
    public void onBackPress() {
        if (getActivity() != null)
            getActivity().onBackPressed();
    }
}
