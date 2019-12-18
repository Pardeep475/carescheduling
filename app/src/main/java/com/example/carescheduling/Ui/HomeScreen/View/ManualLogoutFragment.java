package com.example.carescheduling.Ui.HomeScreen.View;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.Common.Common;
import com.example.carescheduling.Ui.Common.CommonBean;
import com.example.carescheduling.Ui.HomeScreen.ViewModel.ManualLogoutViewModel;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientVisitTaskList;
import com.example.carescheduling.Ui.HomeScreen.beans.EmployeeClientVisitForDepartureRetro;
import com.example.carescheduling.Ui.HomeScreen.beans.ScanBean;
import com.example.carescheduling.Ui.HomeScreen.presenter.IManualLogout;
import com.example.carescheduling.Utils.ConnectivityReceiver;
import com.example.carescheduling.Utils.CustomDialogClass;
import com.example.carescheduling.databinding.ManualLogoutBinding;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Calendar;

public class ManualLogoutFragment extends BaseFragment implements Common, IManualLogout {

    private ManualLogoutBinding manualLogoutBinding;
    private ManualLogoutViewModel manualLogoutViewModel;

    private int mHour, mMinute;
    private ScanBean scanBean;
    private String scanType;
    private String barcodeId;
    private String clientName = "";
    private Gson gson = new Gson();

    public static ManualLogoutFragment newInstance(ScanBean scanBean, String scanType) {
        ManualLogoutFragment manualLogoutFragment = new ManualLogoutFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("SCAN_BEAN", scanBean);
        bundle.putSerializable("SCAN_TYPE", scanType);
        manualLogoutFragment.setArguments(bundle);
        return manualLogoutFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            scanBean = (ScanBean) getArguments().getSerializable("SCAN_BEAN");
            scanType = getArguments().getString("SCAN_TYPE");
            barcodeId = scanBean.getData().getBarcodeId();
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        manualLogoutBinding = DataBindingUtil.inflate(inflater, R.layout.manual_logout, container, false);
        View view = manualLogoutBinding.getRoot();
        setUpView(view);
        return view;
    }


    private void setUpView(View view) {
        setCommonData();
        setData();
        manualLogoutViewModel = ViewModelProviders.of(this).get(ManualLogoutViewModel.class);
        manualLogoutBinding.setIManualLogout(this);
    }


    private void setCommonData() {
        CommonBean commonBean = new CommonBean();
        commonBean.setLeftImageDrawable(R.drawable.ic_left_back);
        commonBean.setLeftImageVisible(true);
        commonBean.setRightImageDrawable(R.drawable.ic_logout);
        commonBean.setRightImageVisible(false);
        commonBean.setRightTextVisible(false);
        commonBean.setTitle("Manual Logout");
        manualLogoutBinding.setCommonData(commonBean);
        manualLogoutBinding.setCommonClick(this);
    }

    private void setData() {
        if (scanBean != null) {
            if (scanBean.getData() != null) {
                getSessionManager().setClientVisitId(scanBean.getData().getClientVisitId());
                if (scanBean.getData().getClientName() != null) {
                    manualLogoutBinding.txtClientName.setText(scanBean.getData().getClientName());
                    clientName = scanBean.getData().getClientName();
                }
                if (scanBean.getData().getVisitArrivalDate() != null)
                    manualLogoutBinding.txtDateArrival.setText(scanBean.getData().getVisitArrivalDate());
                if (scanBean.getData().getVisitArrivalTime() != null)
                    manualLogoutBinding.txtTimeArrival.setText(scanBean.getData().getVisitArrivalTime());
                if (scanBean.getData().getVisitDepartureDate() != null)
                    manualLogoutBinding.txtDateDeparture.setText(scanBean.getData().getVisitDepartureDate());
                if (scanBean.getData().getVisitDepartureTime() != null)
                    manualLogoutBinding.txtTimeDeparture.setText(scanBean.getData().getVisitDepartureTime());
//                if (scanBean.getData().getClientVisitId() != null)
//                    manualLogoutBinding.txtClientNumber.setText(scanBean.getData().getClientVisitId());
//                android:text="Monday 14 of July 2016 02:34"
//                if (scanBean.getData().get)
//                manualLogoutBinding.txtTime.setText(getFullDateWithTime());
            }
        }
    }

    @Override
    public void leftClick() {
        if (getActivity() != null)
            getActivity().onBackPressed();
    }

    @Override
    public void rightClick() {

    }

    @Override
    public void departureTime() {

        // Get Current Time
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(),
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {

                        manualLogoutBinding.txtTimeDeparture.setText(hourOfDay + ":" + minute);
                    }
                }, mHour, mMinute, false);
        timePickerDialog.show();
    }

    @Override
    public void cancel() {
        leftClick();
    }

    @Override
    public void save() {
        if (getActivity() != null && ConnectivityReceiver.isNetworkAvailable(getActivity())) {
            showDialog();
            manualLogoutViewModel.getEmployeeClientVisitForDeparture(getEmployeeClientVisitForDepartureRetro()).observe(this, new Observer<Boolean>() {
                @Override
                public void onChanged(Boolean s) {
                    hideDialog();
                    if (s != null) {
                        if (s) {
                            getSessionManager().setClientVisitId(null);
                            getSessionManager().setClientTasks(null);
                            CustomDialogClass customDialogClass = new CustomDialogClass(getActivity(), "Success", clientName);
                            customDialogClass.show();
                        }
                    }

                }
            });
        } else {
            Toast.makeText(getActivity(), "please check your internet connection", Toast.LENGTH_SHORT).show();
        }
    }

    private EmployeeClientVisitForDepartureRetro getEmployeeClientVisitForDepartureRetro() {
        EmployeeClientVisitForDepartureRetro employeeClientVisitForDepartureRetro = new EmployeeClientVisitForDepartureRetro();
        employeeClientVisitForDepartureRetro.setClientVisitId(getSessionManager().getClientVisitId());
        employeeClientVisitForDepartureRetro.setCustomerId(getSessionManager().getCustomerId());
        employeeClientVisitForDepartureRetro.setDepartureRegistrationTypeName("Manual");
        employeeClientVisitForDepartureRetro.setVisitDepartureRegisteredBy(getSessionManager().getPersonId());
        employeeClientVisitForDepartureRetro.setVisitRegisteredDeparture(getFullDate());
        employeeClientVisitForDepartureRetro.setVisitNoteText("");
//        if (getSessionManager().getClientTasks() != null)
        employeeClientVisitForDepartureRetro.setClientVisitTaskList(null);


        return employeeClientVisitForDepartureRetro;
    }

    private ArrayList<ClientVisitTaskList> getTaskList() {
        ArrayList<ClientVisitTaskList> arrayList = new ArrayList<ClientVisitTaskList>();
        ClientVisitTaskList clientVisitTaskList = new ClientVisitTaskList();
        clientVisitTaskList.setNoteText("The purpose of lorem ipsum is to create a natural looking block of text (sentence, paragraph, page, etc.) that doesn't distract from the layout.");
        clientVisitTaskList.setNoteTypeName("Medication Note");
        clientVisitTaskList.setTaskId("867CFCC1-1F20-4E79-AB21-4156954EACBE");
        clientVisitTaskList.setTaskIsCompleted(true);


        ClientVisitTaskList clientVisitTaskList1 = new ClientVisitTaskList();
        clientVisitTaskList1.setNoteText("The purpose of lorem ipsum is to create a natural looking block of text (sentence, paragraph, page, etc.) that doesn't distract from the layout.");
        clientVisitTaskList1.setNoteTypeName("Visit Note");
        clientVisitTaskList1.setTaskId("E02C9799-6333-4FDB-BF65-CE8966148966");
        clientVisitTaskList1.setTaskIsCompleted(true);

        arrayList.add(clientVisitTaskList);
        arrayList.add(clientVisitTaskList1);
        return arrayList;
    }

    private String getFullDate() {
        return manualLogoutBinding.txtDateArrival.getText().toString() + " " + manualLogoutBinding.txtTimeDeparture.getText().toString();
    }
}
