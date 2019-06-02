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
import com.example.carescheduling.Ui.Common.Common;
import com.example.carescheduling.Ui.Common.CommonBean;
import com.example.carescheduling.Ui.HomeScreen.ViewModel.BlankViewModel;
import com.example.carescheduling.Ui.HomeScreen.presenter.MyNextVisitClick;
import com.example.carescheduling.databinding.BlankFragmentBinding;

public class BlankFragment extends BaseFragment implements Common, MyNextVisitClick {

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
        setCommonData();
        mViewModel = ViewModelProviders.of(this).get(BlankViewModel.class);
        blankFragmentBinding.setMyNextVisitClick(this);
    }

    private void setCommonData() {
        CommonBean commonBean = new CommonBean();
        commonBean.setLeftImageDrawable(R.drawable.ic_left_back);
        commonBean.setLeftImageVisible(true);
        commonBean.setRightImageDrawable(R.drawable.ic_logout);
        commonBean.setRightImageVisible(false);
        commonBean.setTitle("Client Profile");
        blankFragmentBinding.setCommonData(commonBean);
        blankFragmentBinding.setCommonClick(this);
    }


    @Override
    public void moreClientInfoClick() {
        setFragment(ClientInfoHomeFragment.newInstance());
    }

    private void setFragment(Fragment fragment) {
        if (getActivity() != null)
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fm_edit_container, fragment).addToBackStack(null).commitAllowingStateLoss();
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
