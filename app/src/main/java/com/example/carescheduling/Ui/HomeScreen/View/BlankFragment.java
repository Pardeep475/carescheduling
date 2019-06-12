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
import com.example.carescheduling.Ui.Common.Common;
import com.example.carescheduling.Ui.Common.CommonBean;
import com.example.carescheduling.Ui.Dashboard.beans.ClientBookingListModel;
import com.example.carescheduling.Ui.HomeScreen.ViewModel.BlankViewModel;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientBookingScreenModel;
import com.example.carescheduling.Ui.HomeScreen.beans.Tasks;
import com.example.carescheduling.Ui.HomeScreen.presenter.MyNextVisitClick;
import com.example.carescheduling.Utils.ConnectivityReceiver;
import com.example.carescheduling.databinding.BlankFragmentBinding;

import java.util.ArrayList;

public class BlankFragment extends BaseFragment implements Common, MyNextVisitClick {

    private BlankViewModel mViewModel;
    private BlankFragmentBinding blankFragmentBinding;
    private ClientBookingScreenModel clientBookingModel;

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
        blankFragmentBinding.slDemo.startShimmerAnimation();
        try {
            getClientBookingList();
        } catch (Exception e) {
            hideDialog();
            Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
        }
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
        if (clientBookingModel != null)
            setFragment(ClientInfoHomeFragment.newInstance(clientBookingModel));
        else
            Toast.makeText(getActivity(), "Client not found", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ClientTask(ArrayList<Tasks> tasksArrayList) {
        if (tasksArrayList.size() > 0)
            setFragment(ClientTasksFragment.newInstance(tasksArrayList));
        else
            Toast.makeText(getActivity(), "Data not found", Toast.LENGTH_SHORT).show();
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

    private void getClientBookingList() {
//        //
        if (getActivity() != null) {
            if (ConnectivityReceiver.isNetworkAvailable(getActivity())) {
                try {
//                    showDialog();  // 5633D002-F453-402E-AD63-AAECA11452B5    15C7E260-5818-41AB-A3E7-F6C90F648A1D
                    mViewModel.getClientBookingList(getSessionManager().getPersonId(),
                            getSessionManager().getBranchId(),
                            getSessionManager().getCustomerId()).observe(this, new Observer<ClientBookingScreenModel>() {
                        @Override
                        public void onChanged(ClientBookingScreenModel clientBookingListModel) {
//                            hideDialog();
                            if (clientBookingListModel != null) {
                                clientBookingModel = clientBookingListModel;
                                blankFragmentBinding.setClientBookingScreenModel(clientBookingListModel);
                                setDataOriginal();
                            } else {
                                setNoDataFound();
                            }

                        }
                    });
                } catch (Exception e) {
                    hideDialog();
                    Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getActivity(), "please check your internet connection", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private void setNoDataFound() {
        blankFragmentBinding.slDemo.stopShimmerAnimation();
        blankFragmentBinding.slDemo.setVisibility(View.GONE);
        blankFragmentBinding.sBlank.setVisibility(View.GONE);
        blankFragmentBinding.rlNoDataFound.setVisibility(View.VISIBLE);
    }

    private void setDataOriginal() {
        blankFragmentBinding.slDemo.stopShimmerAnimation();
        blankFragmentBinding.slDemo.setVisibility(View.GONE);
        blankFragmentBinding.sBlank.setVisibility(View.VISIBLE);
        blankFragmentBinding.rlNoDataFound.setVisibility(View.GONE);
    }

}
