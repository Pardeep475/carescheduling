package com.example.carescheduling.Ui.HomeScreen.View;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.Common.Common;
import com.example.carescheduling.Ui.Common.CommonBean;
import com.example.carescheduling.Ui.HomeScreen.ViewModel.VisitArchiveViewModel;
import com.example.carescheduling.Ui.HomeScreen.adapter.ClientInfoMedicationAdapter;
import com.example.carescheduling.Ui.HomeScreen.adapter.VisitArchiveAdapter;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientInfoCarePlanRetro;
import com.example.carescheduling.Ui.HomeScreen.beans.VisitArchiveAdapterBean;
import com.example.carescheduling.Ui.HomeScreen.beans.VisitArchiveRetroBean;
import com.example.carescheduling.Ui.HomeScreen.presenter.VisitArchiveClick;
import com.example.carescheduling.Utils.ConnectivityReceiver;
import com.example.carescheduling.databinding.VisitArchiveFragmentBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class VisitArchiveFragment extends BaseFragment implements Common, VisitArchiveClick {

    private VisitArchiveViewModel mViewModel;
    private VisitArchiveFragmentBinding visitArchiveFragmentBinding;
    private DatePicker datePicker;
    private Calendar calendar;
    private int year, month, day;
    private boolean isVisitArchive;

    public static VisitArchiveFragment newInstance(Boolean isVisitArchive) {
        VisitArchiveFragment visitArchiveFragment = new VisitArchiveFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("IS_VISIT_ARCHIVE", isVisitArchive);
        visitArchiveFragment.setArguments(bundle);
        return visitArchiveFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            isVisitArchive = getArguments().getBoolean("IS_VISIT_ARCHIVE");
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        visitArchiveFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.visit_archive_fragment, container, false);
        View view = visitArchiveFragmentBinding.getRoot();
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {
        setCommonData(true);
        mViewModel = ViewModelProviders.of(this).get(VisitArchiveViewModel.class);
        visitArchiveFragmentBinding.setVisitArchiveClick(this);
        if (isVisitArchive) {
            visitArchiveFragmentBinding.cvDateLayout.setVisibility(View.VISIBLE);
            visitArchiveFragmentBinding.rcvVisitArchive.setVisibility(View.GONE);
            visitArchiveFragmentBinding.rlNoDataFound.setVisibility(View.GONE);
        } else {
            visitArchiveFragmentBinding.cvDateLayout.setVisibility(View.GONE);
            visitArchiveFragmentBinding.rcvVisitArchive.setVisibility(View.VISIBLE);
            visitArchiveFragmentBinding.rlNoDataFound.setVisibility(View.GONE);
            getVisitArchiveData();
        }
    }


    private void getVisitArchiveData() {
        String formatedDate = null;
        if (isVisitArchive)
            formatedDate = visitArchiveFragmentBinding.txtDateOfBirth.getText().toString();
        else {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date date = new Date();
            formatedDate = formatter.format(date);
        }
        if (getActivity() != null) {
            if (ConnectivityReceiver.isNetworkAvailable(getActivity())) {
                mViewModel.getVisitArchiveClient(getSessionManager().getPersonId(),
                        formatedDate,
                        getSessionManager().getBranchId(),
                        getSessionManager().getCustomerId()).observe(this, new Observer<ArrayList<VisitArchiveAdapterBean>>() {
                    @Override
                    public void onChanged(ArrayList<VisitArchiveAdapterBean> visitArchiveAdapterBeans) {
                        if (getActivity() != null && visitArchiveAdapterBeans != null && visitArchiveAdapterBeans.size() > 0) {
                            visitArchiveFragmentBinding.rcvVisitArchive.setLayoutManager(new LinearLayoutManager(getActivity()));
                            VisitArchiveAdapter clientInfoMedicationAdapter = new VisitArchiveAdapter(getActivity(), visitArchiveAdapterBeans);
                            visitArchiveFragmentBinding.rcvVisitArchive.setAdapter(clientInfoMedicationAdapter);
                            visitArchiveFragmentBinding.rcvVisitArchive.hideShimmerAdapter();
                        } else {
                            setNoDataFound();
                        }
                    }
                });
            }else{
                showAToast("please check your internet connection");
                setNoDataFound();
            }
        }
    }


    private void setNoDataFound() {
        visitArchiveFragmentBinding.rcvVisitArchive.hideShimmerAdapter();
        visitArchiveFragmentBinding.rcvVisitArchive.setVisibility(View.GONE);
        visitArchiveFragmentBinding.rlDate.setVisibility(View.GONE);
        visitArchiveFragmentBinding.rlNoDataFound.setVisibility(View.VISIBLE);
    }

    private void setDataOriginal() {
        visitArchiveFragmentBinding.rcvVisitArchive.showShimmerAdapter();
        visitArchiveFragmentBinding.rcvVisitArchive.setVisibility(View.VISIBLE);
        visitArchiveFragmentBinding.rlDate.setVisibility(View.GONE);
        visitArchiveFragmentBinding.rlNoDataFound.setVisibility(View.GONE);
    }


    private void setCommonData(boolean isVisible) {
        CommonBean commonBean = new CommonBean();
        commonBean.setLeftImageDrawable(R.drawable.ic_left_back);
        commonBean.setLeftImageVisible(true);
        commonBean.setRightImageDrawable(R.drawable.ic_tick);
        commonBean.setRightImageVisible(false);
        if (isVisitArchive)
        commonBean.setRightTextVisible(isVisible);
        else
        commonBean.setRightTextVisible(false);
        if (isVisitArchive)
        commonBean.setTitle("Visits Archive");
        else
            commonBean.setTitle("Today's Visits");
        visitArchiveFragmentBinding.setCommonData(commonBean);
        visitArchiveFragmentBinding.setCommonClick(this);
    }

    @Override
    public void calenderOnClick() {
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        onCreateDialog(999).show();
    }

    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(getActivity(),
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    showDate(arg1, arg2 + 1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        String finalDay = String.valueOf(day);
        String finalMonth= String.valueOf(month);
        if (finalDay.length()==1)
            finalDay = "0"+finalDay;
        if (finalMonth.length()==1)
            finalMonth = "0"+finalMonth;
        Toast.makeText(getActivity(), year + " " + month + " " + day, Toast.LENGTH_SHORT).show();
        mViewModel.datePicker(finalDay+ "-" + finalMonth + "-" + year).observe(getActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                visitArchiveFragmentBinding.setDate(s);
            }
        });
//        dateView.setText(new StringBuilder().append(day).append("/")
//                .append(month).append("/").append(year));
    }

    @Override
    public void leftClick() {
        if (getActivity() != null) {
            if (isVisitArchive) {
                if (visitArchiveFragmentBinding.rlNoDataFound.getVisibility() == View.VISIBLE
                        || visitArchiveFragmentBinding.rcvVisitArchive.getVisibility() == View.VISIBLE) {
                    setCommonData(true);
                    setBackData();
                }else
                    getActivity().onBackPressed();
            } else {
                getActivity().onBackPressed();
            }
        }

    }

    private void setBackData() {
        visitArchiveFragmentBinding.rcvVisitArchive.hideShimmerAdapter();
        visitArchiveFragmentBinding.rcvVisitArchive.setVisibility(View.GONE);
        visitArchiveFragmentBinding.cvDateLayout.setVisibility(View.VISIBLE);
        visitArchiveFragmentBinding.rlDate.setVisibility(View.VISIBLE);
        visitArchiveFragmentBinding.rlNoDataFound.setVisibility(View.GONE);
    }

    @Override
    public void rightClick() {
        if (isVisitArchive) {
            if (!visitArchiveFragmentBinding.txtDateOfBirth.getText().toString().equalsIgnoreCase("")) {
                setDataOriginal();
                getVisitArchiveData();
                setCommonData(false);
            } else {
                Toast.makeText(getActivity(), "Please select date", Toast.LENGTH_SHORT).show();
            }
        }
    }


}
