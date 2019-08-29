package com.example.carescheduling.Ui.HomeScreen.View;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.Common.Common;
import com.example.carescheduling.Ui.Common.CommonBean;
import com.example.carescheduling.Ui.HomeScreen.ViewModel.ArrivalAndDepartureViewModel;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientVisitTaskList;
import com.example.carescheduling.Ui.HomeScreen.beans.EmployeeClientVisitForArrivalRetro;
import com.example.carescheduling.Ui.HomeScreen.beans.EmployeeClientVisitForDepartureRetro;
import com.example.carescheduling.Ui.HomeScreen.beans.ScanBean;
import com.example.carescheduling.Ui.HomeScreen.beans.Tasks;
import com.example.carescheduling.Ui.HomeScreen.presenter.IArrivalAndDepartureClick;
import com.example.carescheduling.Utils.ConnectivityReceiver;
import com.example.carescheduling.databinding.ArrivalAndDepartureFragmentBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ArrivalAndDepartureFragment extends BaseFragment implements Common, IArrivalAndDepartureClick {
    private ArrivalAndDepartureFragmentBinding arrivalAndDepartureFragmentBinding;
    private ArrivalAndDepartureViewModel mViewModel;
    private ScanBean scanBean;
    private String scanType;
    private String barcodeId;
    private Gson gson = new Gson();

    public static ArrivalAndDepartureFragment newInstance(ScanBean scanBean, String scanType) {
        ArrivalAndDepartureFragment arrivalAndDepartureFragment = new ArrivalAndDepartureFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("SCAN_BEAN", scanBean);
        bundle.putSerializable("SCAN_TYPE", scanType);
        arrivalAndDepartureFragment.setArguments(bundle);
        return arrivalAndDepartureFragment;
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
        arrivalAndDepartureFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.arrival_and_departure_fragment, container, false);
        return arrivalAndDepartureFragmentBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ArrivalAndDepartureViewModel.class);
        // TODO: Use the ViewModel

        setCommonData();
        setData();
        arrivalAndDepartureFragmentBinding.setIArrivalAndDepartureClick(this);
    }


    private void setCommonData() {
        CommonBean commonBean = new CommonBean();
        commonBean.setLeftImageDrawable(R.drawable.ic_left_back);
        commonBean.setLeftImageVisible(true);
        commonBean.setRightImageDrawable(R.drawable.ic_logout);
        commonBean.setRightImageVisible(false);
        commonBean.setRightTextVisible(false);
        commonBean.setTitle("Barcode Scanner");
        arrivalAndDepartureFragmentBinding.setCommonData(commonBean);
        arrivalAndDepartureFragmentBinding.setCommonClick(this);
    }


    private void setData() {
        if (scanBean != null) {
            if (scanBean.getData() != null) {
                if (scanBean.getData().getClientName() != null)
                    arrivalAndDepartureFragmentBinding.txtClientName.setText(scanBean.getData().getClientName());
                if (scanBean.getData().getClientVisitId() != null)
                    arrivalAndDepartureFragmentBinding.txtClientNumber.setText(scanBean.getData().getClientVisitId());
//                android:text="Monday 14 of July 2016 02:34"
//                if (scanBean.getData().get)
                arrivalAndDepartureFragmentBinding.txtTime.setText(getFullDateWithTime());
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
    public void arrivalClick() {
        setArrivalWithBarCode();
    }

    @Override
    public void departureClick() {
        if (sessionManager.getClientVisitId() == null) {
            showAToast("You have to register arrival time first");
            return;
        }
        if (getActivity() != null && ConnectivityReceiver.isNetworkAvailable(getActivity())) {
            showDialog();
            mViewModel.getEmployeeClientVisitForDeparture(getEmployeeClientVisitForDepartureRetro()).observe(this, new Observer<Boolean>() {
                @Override
                public void onChanged(Boolean s) {
                    hideDialog();
                    if (s != null) {
                        if (s) {
                            getSessionManager().setClientVisitId(null);
                            getSessionManager().setClientTasks(null);
                            if (getActivity() != null) {
                                getActivity().onBackPressed();
                            }
                        }
                    }

                }
            });
        } else {
            Toast.makeText(getActivity(), "please check your internet connection", Toast.LENGTH_SHORT).show();
        }
    }


    private void setArrivalWithBarCode() {
        if (getActivity() != null && ConnectivityReceiver.isNetworkAvailable(getActivity())) {
            showDialog();
            mViewModel.getMatchingClientBarcodeArrival(getArrivalData()).observe(this, new Observer<String>() {
                @Override
                public void onChanged(String s) {
                    hideDialog();
                    if (s != null) {
                        getSessionManager().setClientVisitId(s);

                    }

                }
            });
        } else {
            Toast.makeText(getActivity(), "please check your internet connection", Toast.LENGTH_SHORT).show();
        }

    }

    private ArrayList<EmployeeClientVisitForArrivalRetro> getArrivalData() {
        ArrayList<EmployeeClientVisitForArrivalRetro> employeeClientVisitForArrivalRetros = new ArrayList<>();
        EmployeeClientVisitForArrivalRetro employeeClientVisitForArrivalRetro = new EmployeeClientVisitForArrivalRetro();
        employeeClientVisitForArrivalRetro.setArrivalRegistrationType(scanType);
        employeeClientVisitForArrivalRetro.setBarcodeId(barcodeId);
        employeeClientVisitForArrivalRetro.setBookingId(getSessionManager().getBookingId());
        employeeClientVisitForArrivalRetro.setBranchId(getSessionManager().getBranchId());
        employeeClientVisitForArrivalRetro.setClientId(getSessionManager().getClientId());
        employeeClientVisitForArrivalRetro.setClientName(arrivalAndDepartureFragmentBinding.txtClientName.getText().toString());
        employeeClientVisitForArrivalRetro.setVisitArrivalRegisterredBy(getSessionManager().getPersonId());
        employeeClientVisitForArrivalRetro.setVisitDepartureRegisteredBy(null);
        employeeClientVisitForArrivalRetro.setCustomerId(getSessionManager().getCustomerId());
        employeeClientVisitForArrivalRetro.setDepartureRegistrationType(scanType);
        employeeClientVisitForArrivalRetro.setEmployeeId(getSessionManager().getPersonId());
        employeeClientVisitForArrivalRetro.setLastLogOutOfEmployee(null);
        employeeClientVisitForArrivalRetro.setSuggestedLogInTime(getTime());
        employeeClientVisitForArrivalRetro.setVisitDate(getDate());
        employeeClientVisitForArrivalRetro.setVisitIdentificationTypeName(null);

        employeeClientVisitForArrivalRetros.add(employeeClientVisitForArrivalRetro);
        return employeeClientVisitForArrivalRetros;
    }

    private EmployeeClientVisitForDepartureRetro getEmployeeClientVisitForDepartureRetro() {
        EmployeeClientVisitForDepartureRetro employeeClientVisitForDepartureRetro = new EmployeeClientVisitForDepartureRetro();
        employeeClientVisitForDepartureRetro.setClientVisitId(getSessionManager().getClientVisitId());
        employeeClientVisitForDepartureRetro.setCustomerId(getSessionManager().getCustomerId());
        employeeClientVisitForDepartureRetro.setDepartureRegistrationTypeName("Manual");
        employeeClientVisitForDepartureRetro.setVisitDepartureRegisteredBy(getSessionManager().getPersonId());
        employeeClientVisitForDepartureRetro.setVisitRegisteredDeparture(getFullDate());
        if (getSessionManager().getClientTasks() != null)
            employeeClientVisitForDepartureRetro.setClientVisitTaskList(getTaskList());


        return employeeClientVisitForDepartureRetro;
    }

    private ArrayList<ClientVisitTaskList> getTaskList() {
        ArrayList<ClientVisitTaskList> list = new ArrayList<>();
        ArrayList<Tasks> tasksArrayList = getItemArrayList();
        if (getItemArrayList() != null) {
            for (int i = 0; i < getItemArrayList().size(); i++) {
                ClientVisitTaskList clientVisitTaskList = new ClientVisitTaskList();
                clientVisitTaskList.setNoteText(tasksArrayList.get(i).getInstruction());
                clientVisitTaskList.setNoteTypeName(tasksArrayList.get(i).getTaskName());
                clientVisitTaskList.setTaskId(tasksArrayList.get(i).getTaskId());
                clientVisitTaskList.setTaskIsCompleted(tasksArrayList.get(i).isCompleted());
                list.add(clientVisitTaskList);
            }
        }
        return list;
    }

    private ArrayList<Tasks> getItemArrayList() {
        Type type = new TypeToken<ArrayList<Tasks>>() {
        }.getType();

        return gson.fromJson(getSessionManager().getClientTasks(), type);
    }

    private String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        Log.e("Current_Date", formatter.format(date));
        System.out.println(formatter.format(date));
        return formatter.format(date);
    }

    private String getTime() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.format(d);
    }

    private String getFullDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date();
        Log.e("Current_Date", formatter.format(date));
        System.out.println(formatter.format(date));
        return formatter.format(date);
    }

    //                android:text="Monday 14 of July 2016 02:34"
    private String getFullDateWithTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, dd 'of' MMMM yyyy HH:mm");
        Date date = new Date();
        Log.e("Current_Date", formatter.format(date));
        System.out.println(formatter.format(date));
        return formatter.format(date);
    }
}
