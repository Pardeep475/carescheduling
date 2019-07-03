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
import com.example.carescheduling.Ui.HomeScreen.presenter.VisitArchiveClick;
import com.example.carescheduling.databinding.VisitArchiveFragmentBinding;

import java.util.ArrayList;
import java.util.Calendar;

public class VisitArchiveFragment extends BaseFragment implements Common, VisitArchiveClick {

    private VisitArchiveViewModel mViewModel;
    private VisitArchiveFragmentBinding visitArchiveFragmentBinding;
    private DatePicker datePicker;
    private Calendar calendar;
    private int year, month, day;

    public static VisitArchiveFragment newInstance() {
        return new VisitArchiveFragment();
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
        setCommonData();
        mViewModel = ViewModelProviders.of(this).get(VisitArchiveViewModel.class);
        visitArchiveFragmentBinding.setVisitArchiveClick(this);
    }


    private void getVisitArchiveData() {
// "5633D002-F453-402E-AD63-AAECA11452B5", "2019-05-24",
//                "5F98AF4F-25DC-4AC8-B867-C5072C101011", "5f98af4f-25dc-4ac8-b867-c5072c100000"
//        getSessionManager().getClientId(),
//                visitArchiveFragmentBinding.txtDateOfBirth.getText().toString(),
//                getSessionManager().getBranchId(),
//                getSessionManager().getCustomerId()
        mViewModel.getVisitArchiveClient(getSessionManager().getPersonId(),
                visitArchiveFragmentBinding.txtDateOfBirth.getText().toString(),
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


    private void setCommonData() {
        CommonBean commonBean = new CommonBean();
        commonBean.setLeftImageDrawable(R.drawable.ic_left_back);
        commonBean.setLeftImageVisible(true);
        commonBean.setRightImageDrawable(R.drawable.ic_tick);
        commonBean.setRightImageVisible(false);
        commonBean.setRightTextVisible(true);
        commonBean.setTitle("Visits");
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
        Toast.makeText(getActivity(), year + " " + month + " " + day, Toast.LENGTH_SHORT).show();
        mViewModel.datePicker(year + "-" + month + "-" + day).observe(getActivity(), new Observer<String>() {
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
            if (visitArchiveFragmentBinding.rlNoDataFound.getVisibility() == View.VISIBLE)
                setBackData();
            else
                getActivity().onBackPressed();

        }

    }

    private void setBackData() {
        visitArchiveFragmentBinding.rcvVisitArchive.hideShimmerAdapter();
        visitArchiveFragmentBinding.rcvVisitArchive.setVisibility(View.GONE);
        visitArchiveFragmentBinding.rlDate.setVisibility(View.VISIBLE);
        visitArchiveFragmentBinding.rlNoDataFound.setVisibility(View.GONE);
    }

    @Override
    public void rightClick() {
        if (!visitArchiveFragmentBinding.txtDateOfBirth.getText().toString().equalsIgnoreCase("")) {
            setDataOriginal();
            getVisitArchiveData();
        } else {
            Toast.makeText(getActivity(), "Please select date", Toast.LENGTH_SHORT).show();
        }
    }


}
