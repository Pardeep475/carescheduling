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

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.HomeScreen.ViewModel.VisitArchiveViewModel;
import com.example.carescheduling.Ui.HomeScreen.presenter.VisitArchiveClick;
import com.example.carescheduling.databinding.VisitArchiveFragmentBinding;

import java.util.Calendar;

public class VisitArchiveFragment extends BaseFragment implements VisitArchiveClick {

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
        mViewModel = ViewModelProviders.of(this).get(VisitArchiveViewModel.class);
        visitArchiveFragmentBinding.setVisitArchiveClick(this);
    }


    @Override
    public void onBackPress() {
        if (getActivity() != null)
            getActivity().onBackPressed();
    }

    @Override
    public void DoneClick() {

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
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2 + 1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        Toast.makeText(getActivity(), year + " " + month + " " + day, Toast.LENGTH_SHORT).show();
        mViewModel.datePicker(year + "/" + month + "/" + day).observe(getActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                visitArchiveFragmentBinding.setDate(s);
            }
        });
//        dateView.setText(new StringBuilder().append(day).append("/")
//                .append(month).append("/").append(year));
    }

}
