package com.example.carescheduling.Ui.HomeScreen.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.Common.Common;
import com.example.carescheduling.Ui.Common.CommonBean;
import com.example.carescheduling.Ui.HomeScreen.ViewModel.CarePlanViewModal;
import com.example.carescheduling.Ui.HomeScreen.adapter.CarePlanAdapter;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientCarePlan;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientInfoCarePlanRetro;
import com.example.carescheduling.Ui.HomeScreen.beans.ScheduleClientList;
import com.example.carescheduling.Ui.HomeScreen.presenter.BackPressedClick;
import com.example.carescheduling.Ui.HomeScreen.presenter.CarePlanAdapterClick;
import com.example.carescheduling.Utils.ConnectivityReceiver;
import com.example.carescheduling.databinding.ClientInfoCarePlanFragmentBinding;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

public class CarePlanFragment extends BaseFragment implements Common, CarePlanAdapterClick {
    private ClientInfoCarePlanFragmentBinding clientInfoCarePlanFragmentBinding;
    private CarePlanViewModal carePlanViewModal;

    public static CarePlanFragment newInstance() {
        return new CarePlanFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        clientInfoCarePlanFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.client_info_care_plan_fragment, container, false);
        View view = clientInfoCarePlanFragmentBinding.getRoot();
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {
        setCommonData();
        carePlanViewModal = ViewModelProviders.of(this).get(CarePlanViewModal.class);

        clientInfoCarePlanFragmentBinding.slDemo.startShimmerAnimation();
        try {
            if (ConnectivityReceiver.isNetworkAvailable(getActivity())) {
                setUpRecyclerView(view);
            } else {
                hideDialog();
                setNoDataFound();
                Toast.makeText(getActivity(), "please check your internet connection", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            hideDialog();
            setNoDataFound();
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
        commonBean.setTitle("Care Plan");
        clientInfoCarePlanFragmentBinding.setCommonData(commonBean);
        clientInfoCarePlanFragmentBinding.setCommonClick(this);
    }

    private void setUpRecyclerView(View view) {
        if (getActivity() != null) {

            carePlanViewModal.getCarePlan("5F98AF4F-25DC-4AC8-B867-C5072C100000",
                    "5F98AF4F-25DC-4AC8-B867-C5072C101011",
                    "978E55D2-B7B9-49E0-A654-14B70EB1A344").observe(this,
                    new Observer<ArrayList<ScheduleClientList>>() {
                @Override
                public void onChanged(ArrayList<ScheduleClientList> data) {
                    if (data != null && data.size() > 0) {
                        setLayoutDynamic(clientInfoCarePlanFragmentBinding.llCarePlan, data);
                        setDataOriginal();
                    } else {
                        setNoDataFound();
                    }
                }
            });
        }
    }


    private void setNoDataFound() {
        clientInfoCarePlanFragmentBinding.slDemo.stopShimmerAnimation();
        clientInfoCarePlanFragmentBinding.slDemo.setVisibility(View.GONE);
        clientInfoCarePlanFragmentBinding.svCarePlan.setVisibility(View.GONE);
        clientInfoCarePlanFragmentBinding.rlNoDataFound.setVisibility(View.VISIBLE);
    }

    private void setDataOriginal() {
        clientInfoCarePlanFragmentBinding.slDemo.stopShimmerAnimation();
        clientInfoCarePlanFragmentBinding.slDemo.setVisibility(View.GONE);
        clientInfoCarePlanFragmentBinding.svCarePlan.setVisibility(View.VISIBLE);
        clientInfoCarePlanFragmentBinding.rlNoDataFound.setVisibility(View.GONE);
    }


    @Override
    public void mondayClick(int pos) {

    }

    @Override
    public void tuesdayClick(int pos) {

    }

    @Override
    public void wednesdayClick(int pos) {

    }

    @Override
    public void thursdayClick(int pos) {

    }

    @Override
    public void fridayClick(int pos) {

    }

    @Override
    public void saturdayClick(int pos) {

    }

    @Override
    public void sundayClick(int pos) {

    }

    @Override
    public void leftClick() {
        if (getActivity() != null)
            getActivity().onBackPressed();
    }

    @Override
    public void rightClick() {

    }

    private void setLayoutDynamic(LinearLayout linearLayout, ArrayList<ScheduleClientList> dataLists) {
        String weekday = "";
        LinearLayout ll_nested = null;
        linearLayout.removeAllViews();
        for (int i = 0; i < dataLists.size(); i++) {
            if (!weekday.equalsIgnoreCase(dataLists.get(i).getWeekRotationTypeName())) {
                weekday = dataLists.get(i).getWeekRotationTypeName();
                View v = LayoutInflater.from(getActivity()).inflate(R.layout.item_linet_are_plan, null);
                TextView txt_title = v.findViewById(R.id.txt_title);
                ll_nested = v.findViewById(R.id.ll_nested);
                linearLayout.addView(v);
                txt_title.setText("Week " + dataLists.get(i).getWeekRotationTypeName());
                setLayoutNested(ll_nested, dataLists.get(i));


            } else {
                if (ll_nested != null)
                    setLayoutNested(ll_nested, dataLists.get(i));
            }
        }
    }

    private void setLayoutNested(LinearLayout linearLayout, ScheduleClientList dataList) {
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.item_nested_client_care_plan, null);
        linearLayout.addView(v);
        TextView txt_document = v.findViewById(R.id.txt_document);
        TextView txt_date = v.findViewById(R.id.txt_date);
        txt_document.setText(dataList.getWeekdayName());
        txt_date.setText(dataList.getTimeTableName());
    }
}