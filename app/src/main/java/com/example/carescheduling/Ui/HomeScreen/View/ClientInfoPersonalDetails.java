package com.example.carescheduling.Ui.HomeScreen.View;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
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
import com.example.carescheduling.Ui.Common.Common;
import com.example.carescheduling.Ui.Common.CommonBean;
import com.example.carescheduling.Ui.HomeScreen.ViewModel.ClientInfoPersonalDetailsViewModel;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientBookingScreenModel;
import com.example.carescheduling.Ui.HomeScreen.presenter.BackPressedClick;
import com.example.carescheduling.Ui.Profile.bean.EditProfileInfoBean;
import com.example.carescheduling.Utils.ConnectivityReceiver;
import com.example.carescheduling.databinding.ClientInfoPersonalDetailsFragmentBinding;

public class ClientInfoPersonalDetails extends BaseFragment implements Common {

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
        setCommonData();
        mViewModel = ViewModelProviders.of(this).get(ClientInfoPersonalDetailsViewModel.class);
        clientInfoPersonalDetailsFragmentBinding.slDemo.startShimmerAnimation();
        try {
            if (ConnectivityReceiver.isNetworkAvailable(getActivity())) {
                setClientPersonalDetails();
            } else {
//                setNoDataFound();
//                Toast.makeText(getActivity(), "please check your internet connection", Toast.LENGTH_SHORT).show();
                getDataFromRoom();
            }
        } catch (Exception e) {
//            setNoDataFound();
            getDataFromRoom();
            Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
        }

    }

    private void getDataFromRoom() {
      /*  mViewModel.getDataFromLocal(getActivity(), getSessionManager().getBookingId()).observe(this, new Observer<ClientBookingScreenModel>() {
            @Override
            public void onChanged(ClientBookingScreenModel clientBookingScreenModel) {
                if (clientBookingScreenModel != null) {
                    clientBookingModel = clientBookingScreenModel;
                    getSessionManager().setBookingId(clientBookingModel.getBookingId());
                    blankFragmentBinding.setClientBookingScreenModel(clientBookingScreenModel);
                    setDataOriginal();
                } else {
                    Toast.makeText(getActivity(), "please check your internet connection", Toast.LENGTH_SHORT).show();
                    setNoDataFound();
                }
            }
        });*/
    }


    private void setCommonData() {
        CommonBean commonBean = new CommonBean();
        commonBean.setLeftImageDrawable(R.drawable.ic_left_back);
        commonBean.setLeftImageVisible(true);
        commonBean.setRightImageDrawable(R.drawable.ic_logout);
        commonBean.setRightImageVisible(false);
        commonBean.setRightTextVisible(false);
        commonBean.setTitle("Personal Details");
        clientInfoPersonalDetailsFragmentBinding.setCommonData(commonBean);
        clientInfoPersonalDetailsFragmentBinding.setCommonClick(this);
    }

    private void setClientPersonalDetails() {
        mViewModel.getProfileDetails(getSessionManager().getCustomerId(),
                getSessionManager().getBranchId(),
                getSessionManager().getClientId()).observe(this, new Observer<EditProfileInfoBean>() {
            @Override
            public void onChanged(EditProfileInfoBean editProfileInfoBean) {
                if (editProfileInfoBean != null) {
                    clientInfoPersonalDetailsFragmentBinding.setEditProfileInfoBean(editProfileInfoBean);
                    setDataOriginal();
                } else {
//                    setNoDataFound();
                    getDataFromRoom();
                }
                clientInfoPersonalDetailsFragmentBinding.slDemo.stopShimmerAnimation();
            }
        });
    }

    private void setNoDataFound() {
        clientInfoPersonalDetailsFragmentBinding.slDemo.stopShimmerAnimation();
        clientInfoPersonalDetailsFragmentBinding.slDemo.setVisibility(View.GONE);
        clientInfoPersonalDetailsFragmentBinding.llMainLayout.setVisibility(View.GONE);
        clientInfoPersonalDetailsFragmentBinding.rlNoDataFound.setVisibility(View.VISIBLE);
    }

    private void setDataOriginal() {
        clientInfoPersonalDetailsFragmentBinding.slDemo.stopShimmerAnimation();
        clientInfoPersonalDetailsFragmentBinding.slDemo.setVisibility(View.GONE);
        clientInfoPersonalDetailsFragmentBinding.llMainLayout.setVisibility(View.VISIBLE);
        clientInfoPersonalDetailsFragmentBinding.rlNoDataFound.setVisibility(View.GONE);
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
