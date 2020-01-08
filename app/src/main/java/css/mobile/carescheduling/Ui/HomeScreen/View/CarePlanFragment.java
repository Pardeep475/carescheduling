package css.mobile.carescheduling.Ui.HomeScreen.View;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import css.mobile.carescheduling.R;
import css.mobile.carescheduling.Ui.Base.BaseFragment;
import css.mobile.carescheduling.Ui.Common.Common;
import css.mobile.carescheduling.Ui.Common.CommonBean;
import css.mobile.carescheduling.Ui.Common.ScrollViewExt;
import css.mobile.carescheduling.Ui.Common.ScrollViewListener;
import css.mobile.carescheduling.Ui.HomeScreen.ViewModel.CarePlanViewModal;
import css.mobile.carescheduling.Ui.HomeScreen.beans.ScheduleClients;
import css.mobile.carescheduling.Ui.HomeScreen.presenter.CarePlanAdapterClick;
import css.mobile.carescheduling.Utils.ConnectivityReceiver;
import css.mobile.carescheduling.databinding.ClientInfoCarePlanFragmentBinding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class CarePlanFragment extends BaseFragment implements Common, CarePlanAdapterClick, ScrollViewListener {
    private ClientInfoCarePlanFragmentBinding clientInfoCarePlanFragmentBinding;
    private CarePlanViewModal carePlanViewModal;
    private ArrayList<ScheduleClients> dataListArrayList;
    private int startPosition = 0;
    private int endPosition = 25;

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
        clientInfoCarePlanFragmentBinding.svCarePlan.setScrollViewListener(this);
        clientInfoCarePlanFragmentBinding.slDemo.startShimmerAnimation();
        dataListArrayList = new ArrayList<>();
        try {
            if (ConnectivityReceiver.isNetworkAvailable(getActivity())) {
                setUpRecyclerView(view);
            } else {
                hideDialog();
                getDataFromRoom();
//                setNoDataFound();
//                Toast.makeText(getActivity(), "please check your internet connection", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            hideDialog();
            getDataFromRoom();
//            setNoDataFound();
//            Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
        }

    }

    private void getDataFromRoom() {
        carePlanViewModal.getDataFromLocal(getActivity(), getSessionManager().getBookingId()).observe(this,
                new Observer<ArrayList<ScheduleClients>>() {
                    @Override
                    public void onChanged(ArrayList<ScheduleClients> data) {
                        if (data != null && data.size() > 0) {
                            dataListArrayList = data;
                            clientInfoCarePlanFragmentBinding.llCarePlan.removeAllViews();
                            if (data.size() > 25)
                                endPosition = 25;
                            else
                                endPosition = data.size();
                            setLayoutDynamic(clientInfoCarePlanFragmentBinding.llCarePlan, data);
                            setDataOriginal();
                        } else {
                            setNoDataFound();
                        }
                    }
                });
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

            carePlanViewModal.getCarePlan(getSessionManager().getCustomerId(),
                    getSessionManager().getBranchId(),
                    getSessionManager().getClientId()
            ).observe(this,
                    new Observer<ArrayList<ScheduleClients>>() {
                        @Override
                        public void onChanged(ArrayList<ScheduleClients> data) {
                            if (data != null && data.size() > 0) {
                                dataListArrayList = data;
                                Collections.sort(dataListArrayList);
                                clientInfoCarePlanFragmentBinding.llCarePlan.removeAllViews();
                                if (data.size() > 25)
                                    endPosition = 25;
                                else
                                    endPosition = data.size();

                                setLayoutDynamic(clientInfoCarePlanFragmentBinding.llCarePlan, dataListArrayList);
                                setDataOriginal();
                            } else {
//                                setNoDataFound();
                                getDataFromRoom();
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

    private void setLayoutDynamic(LinearLayout linearLayout, ArrayList<ScheduleClients> dataLists) {
        String weekday = "";
        LinearLayout ll_nested = null;

        for (int i = 0; i < dataListArrayList.size(); i++) {
            Log.e("Shorting_list", dataListArrayList.get(i).getWeekRotationTypeName());
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

    private void setLayoutNested(LinearLayout linearLayout, ScheduleClients dataList) {
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.item_nested_client_care_plan, null);
        linearLayout.addView(v);
        TextView txt_document = v.findViewById(R.id.txt_document);
        TextView txt_date = v.findViewById(R.id.txt_date);
        txt_document.setText(dataList.getWeekdayName());
        txt_date.setText(dataList.getTimeTableName());
    }

    @Override
    public void onScrollChanged(ScrollViewExt scrollView, int x, int y, int oldx, int oldy) {
        // We take the last son in the scrollview
//        View view = (View) scrollView.getChildAt(scrollView.getChildCount() - 1);
//        int diff = (view.getBottom() - (scrollView.getHeight() + scrollView.getScrollY()));

        // if diff is zero, then the bottom has been reached
//        if (diff == 0) {
//            if (dataListArrayList.size() > (endPosition + 25)) {
//                startPosition = endPosition;
//                endPosition = endPosition + 25;
//                setLayoutDynamic(clientInfoCarePlanFragmentBinding.llCarePlan, dataListArrayList);
//            } else {
//                startPosition = endPosition;
//                endPosition = dataListArrayList.size();
//                setLayoutDynamic(clientInfoCarePlanFragmentBinding.llCarePlan, dataListArrayList);
//            }
            // do stuff
//        }
    }
}