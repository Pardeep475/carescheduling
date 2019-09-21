package com.example.carescheduling.Ui.HomeScreen.View;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.Common.Common;
import com.example.carescheduling.Ui.Common.CommonBean;
import com.example.carescheduling.Ui.HomeScreen.ViewModel.ClientInfoSummaryViewModel;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientBookingScreenModel;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientCareSummaryBean;
import com.example.carescheduling.Ui.HomeScreen.presenter.BackPressedClick;
import com.example.carescheduling.Utils.ConnectivityReceiver;
import com.example.carescheduling.databinding.ClientInfoSummaryFragmentBinding;

import java.io.Serializable;

public class ClientInfoSummaryFragment extends BaseFragment implements Common {

    private ClientInfoSummaryViewModel mViewModel;
    private ClientInfoSummaryFragmentBinding clientInfoSummaryFragmentBinding;
    ClientBookingScreenModel clientBookingModel;

    public static ClientInfoSummaryFragment newInstance(ClientBookingScreenModel clientBookingModel) {
        ClientInfoSummaryFragment clientInfoSummaryFragment = new ClientInfoSummaryFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("DATA", clientBookingModel);
        clientInfoSummaryFragment.setArguments(bundle);
        return clientInfoSummaryFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            clientBookingModel = (ClientBookingScreenModel) getArguments().getSerializable("DATA");
        }
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
        setCommonData();
        clientInfoSummaryFragmentBinding.slDemo.startShimmerAnimation();
        mViewModel = ViewModelProviders.of(this).get(ClientInfoSummaryViewModel.class);
        if (getActivity()!= null)
        try {
            if (ConnectivityReceiver.isNetworkAvailable(getActivity())) {
                setUpData();
            } else {
//                setNoDataFound();
                getDataFromRoom();
                //Toast.makeText(getActivity(), "please check your internet connection", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
//            setNoDataFound();
            getDataFromRoom();
            Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
        }


    }

    private void setCommonData() {
        CommonBean commonBean = new CommonBean();
        commonBean.setLeftImageDrawable(R.drawable.ic_left_back);
        commonBean.setLeftImageVisible(true);
        commonBean.setRightImageDrawable(R.drawable.ic_logout);
        commonBean.setRightImageVisible(false);
        commonBean.setRightTextVisible(false);
        commonBean.setTitle("Summary");
        clientInfoSummaryFragmentBinding.setCommonData(commonBean);
        clientInfoSummaryFragmentBinding.setCommonClick(this);
    }

    private void setUpData() {

        mViewModel.getClientSummary(getSessionManager().getCustomerId(),
                getSessionManager().getBranchId(),
                getSessionManager().getClientId()).observe(this, new Observer<ClientBookingScreenModel>() {
            @Override
            public void onChanged(ClientBookingScreenModel clientCareSummaryBean) {
                if (clientCareSummaryBean != null) {
                    clientInfoSummaryFragmentBinding.setClientBookingScreenModel(clientCareSummaryBean);
                    if (clientCareSummaryBean.getImageString() != null && !clientCareSummaryBean.getImageString().equalsIgnoreCase("") && !clientCareSummaryBean.getImageString().equalsIgnoreCase("null"))
                        clientInfoSummaryFragmentBinding.imgUser.setImageBitmap(ImageFromBase64(clientCareSummaryBean.getImageString()));
                    setDataOriginal();
                } else {
//                        Toast.makeText(getActivity(),"Something went wrong", Toast.LENGTH_SHORT).show();
                    getDataFromRoom();
                }

                clientInfoSummaryFragmentBinding.slDemo.stopShimmerAnimation();
            }
        });
    }
    private Bitmap ImageFromBase64(String img) {
        byte[] decodedString = Base64.decode(img, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
    }
    private void getDataFromRoom() {
        mViewModel.getDataFromLocal(getActivity(), getSessionManager().getBookingId()).observe(this, new Observer<ClientBookingScreenModel>() {
            @Override
            public void onChanged(ClientBookingScreenModel clientBookingScreenModel) {
                if (clientBookingScreenModel != null) {
                    clientBookingModel = clientBookingScreenModel;
                    getSessionManager().setBookingId(clientBookingModel.getBookingId());
                    clientInfoSummaryFragmentBinding.setClientBookingScreenModel(clientBookingScreenModel);
                    if (clientBookingScreenModel.getImageString() != null && !clientBookingScreenModel.getImageString().equalsIgnoreCase("") && !clientBookingScreenModel.getImageString().equalsIgnoreCase("null"))
                        clientInfoSummaryFragmentBinding.imgUser.setImageBitmap(ImageFromBase64(clientBookingScreenModel.getImageString()));
                    setDataOriginal();
                } else {
                    Toast.makeText(getActivity(), "please check your internet connection", Toast.LENGTH_SHORT).show();
                    setNoDataFound();
                }
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
    public void leftClick() {
        if (getActivity() != null)
            getActivity().onBackPressed();
    }

    @Override
    public void rightClick() {

    }
}
