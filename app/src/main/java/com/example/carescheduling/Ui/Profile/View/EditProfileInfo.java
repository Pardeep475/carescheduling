package com.example.carescheduling.Ui.Profile.View;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.Profile.ViewModel.EditProfileInfoViewModel;
import com.example.carescheduling.Ui.Profile.presenter.EditEmailClick;
import com.example.carescheduling.Ui.Profile.presenter.EditProfileInfoClick;
import com.example.carescheduling.databinding.FragmentEditProfileInfoBinding;

import java.util.Calendar;

public class EditProfileInfo extends BaseFragment implements EditEmailClick, EditProfileInfoClick {

    private FragmentEditProfileInfoBinding fragmentEditProfileInfoBinding;
    private EditProfileInfoViewModel editProfileInfoViewModel;
    private DatePicker datePicker;
    private Calendar calendar;
    private int year, month, day;
    public static EditProfileInfo newInstance() {
        return new EditProfileInfo();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentEditProfileInfoBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_profile_info, container, false);
        View view = fragmentEditProfileInfoBinding.getRoot();
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {
        editProfileInfoViewModel = ViewModelProviders.of(this).get(EditProfileInfoViewModel.class);
        fragmentEditProfileInfoBinding.setEditEmailClick(this);
        fragmentEditProfileInfoBinding.setEditProfileInfoClick(this);

    }

    @Override
    public void BackButtonClick() {
        if (getActivity() != null)
            getActivity().onBackPressed();
    }

    @Override
    public void DoneClick() {

    }

    @Override
    public void DatePicker() {
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        onCreateDialog(999).show();
    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {

        Toast.makeText(getActivity(), "ca",
                Toast.LENGTH_SHORT)
                .show();
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
                    showDate(arg1, arg2+1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        Toast.makeText(getActivity(), year+" "+month+" "+day, Toast.LENGTH_SHORT).show();
        editProfileInfoViewModel.datePicker(year+"/"+month+"/"+day).observe(getActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                fragmentEditProfileInfoBinding.setDate(s);
            }
        });
//        dateView.setText(new StringBuilder().append(day).append("/")
//                .append(month).append("/").append(year));
    }

}
