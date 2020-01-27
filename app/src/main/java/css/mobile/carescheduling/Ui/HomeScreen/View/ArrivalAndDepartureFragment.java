package css.mobile.carescheduling.Ui.HomeScreen.View;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import css.mobile.carescheduling.R;
import css.mobile.carescheduling.Ui.Base.BaseFragment;
import css.mobile.carescheduling.Ui.Common.Common;
import css.mobile.carescheduling.Ui.Common.CommonBean;
import css.mobile.carescheduling.Ui.HomeScreen.ViewModel.ArrivalAndDepartureViewModel;
import css.mobile.carescheduling.Ui.HomeScreen.beans.ClientVisitTaskList;
import css.mobile.carescheduling.Ui.HomeScreen.beans.EmployeeClientVisitForArrivalRetro;
import css.mobile.carescheduling.Ui.HomeScreen.beans.EmployeeClientVisitForDepartureRetro;
import css.mobile.carescheduling.Ui.HomeScreen.beans.ScanBean;
import css.mobile.carescheduling.Ui.HomeScreen.beans.Tasks;
import css.mobile.carescheduling.Ui.HomeScreen.presenter.IArrivalAndDepartureClick;
import css.mobile.carescheduling.Ui.Profile.View.EditProfile;
import css.mobile.carescheduling.Utils.ConnectivityReceiver;
import css.mobile.carescheduling.databinding.ArrivalAndDepartureFragmentBinding;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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
    private String type;
    private String customerVisitId;
    private String noteText;
    private Gson gson = new Gson();

    public static ArrivalAndDepartureFragment newInstance(ScanBean scanBean, String scanType, String type, String customerVisitId, String noteText) {
        ArrivalAndDepartureFragment arrivalAndDepartureFragment = new ArrivalAndDepartureFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("SCAN_BEAN", scanBean);
        bundle.putSerializable("SCAN_TYPE", scanType);
        bundle.putSerializable("TYPE", type);
        bundle.putSerializable("CUSTOMER_VISIT_ID", customerVisitId);
        bundle.putSerializable("NOTE_TEXT", noteText);
        arrivalAndDepartureFragment.setArguments(bundle);
        return arrivalAndDepartureFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            scanBean = (ScanBean) getArguments().getSerializable("SCAN_BEAN");
            scanType = getArguments().getString("SCAN_TYPE");
            type = getArguments().getString("TYPE");
            customerVisitId = getArguments().getString("CUSTOMER_VISIT_ID");
            noteText = getArguments().getString("NOTE_TEXT");
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
        if (type.equalsIgnoreCase("Arrival")) {
            arrivalAndDepartureFragmentBinding.btnDeparture.setVisibility(View.GONE);
            arrivalAndDepartureFragmentBinding.btnArrival.setVisibility(View.VISIBLE);
        } else {
            arrivalAndDepartureFragmentBinding.btnDeparture.setVisibility(View.VISIBLE);
            arrivalAndDepartureFragmentBinding.btnArrival.setVisibility(View.GONE);
        }
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
//        getEmployeeClientVisitForDepartureRetro();


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
                                getActivity().finish();
                                Intent intent = new Intent(getActivity(), EditProfile.class);
                                intent.putExtra("pos", 0);
                                startActivity(intent);
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
                        if (getActivity() != null) {
                            int fragments = getActivity().getSupportFragmentManager().getBackStackEntryCount();
                            Log.e("FragmentCount", "" + fragments);
                            if (type.equalsIgnoreCase("Arrival")) {
                                /*for (int i = 0; i < fragments - 2; i++) {
                                    Log.e("FragmentCount", i + " " + fragments);
                                    getActivity().getSupportFragmentManager().popBackStack();
                                }*/
                                getActivity().onBackPressed();
                            } else {
                                getActivity().finish();
                                Intent intent = new Intent(getActivity(), EditProfile.class);
                                intent.putExtra("pos", 0);
                                startActivity(intent);
                            }
                        }

//
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
//        employeeClientVisitForArrivalRetro.setClientName(arrivalAndDepartureFragmentBinding.txtClientName.getText().toString());
        employeeClientVisitForArrivalRetro.setVisitArrivalRegisterredBy(getSessionManager().getPersonId());
//        employeeClientVisitForArrivalRetro.setVisitDepartureRegisteredBy(null);
        employeeClientVisitForArrivalRetro.setCustomerId(getSessionManager().getCustomerId());
        employeeClientVisitForArrivalRetro.setDepartureRegistrationType(scanType);
        employeeClientVisitForArrivalRetro.setEmployeeId(getSessionManager().getPersonId());
//        employeeClientVisitForArrivalRetro.setLastLogOutOfEmployee(null);
        employeeClientVisitForArrivalRetro.setSuggestedLogInTime(getTime());
        employeeClientVisitForArrivalRetro.setClientBookingId(getSessionManager().getBookingId());
        employeeClientVisitForArrivalRetro.setVisitDate(getDate());
        employeeClientVisitForArrivalRetro.setVisitIdentificationTypeName(null);
        employeeClientVisitForArrivalRetros.add(employeeClientVisitForArrivalRetro);
        return employeeClientVisitForArrivalRetros;
    }

    private EmployeeClientVisitForDepartureRetro getEmployeeClientVisitForDepartureRetro() {
        EmployeeClientVisitForDepartureRetro employeeClientVisitForDepartureRetro = new EmployeeClientVisitForDepartureRetro();
        employeeClientVisitForDepartureRetro.setClientVisitId(customerVisitId);
        employeeClientVisitForDepartureRetro.setCustomerId(getSessionManager().getCustomerId());
        employeeClientVisitForDepartureRetro.setClientBookingId(getSessionManager().getBookingId());
        employeeClientVisitForDepartureRetro.setDepartureRegistrationTypeName(scanType);
        employeeClientVisitForDepartureRetro.setVisitDepartureRegisteredBy(getSessionManager().getPersonId());
        employeeClientVisitForDepartureRetro.setVisitRegisteredDeparture(getFullDate());
        employeeClientVisitForDepartureRetro.setVisitNoteText(noteText);
        if (getSessionManager().getClientTasks() != null)
            employeeClientVisitForDepartureRetro.setClientVisitTaskList(getTaskList());
        else
            employeeClientVisitForDepartureRetro.setClientVisitTaskList(null);

        return employeeClientVisitForDepartureRetro;
    }

    private ArrayList<ClientVisitTaskList> getTaskList() {
        ArrayList<ClientVisitTaskList> list = new ArrayList<>();
        ArrayList<Tasks> tasksArrayList = getItemArrayList();
        if (getItemArrayList() != null) {
            for (int i = 0; i < getItemArrayList().size(); i++) {
                ClientVisitTaskList clientVisitTaskList = new ClientVisitTaskList();
                clientVisitTaskList.setNoteText(tasksArrayList.get(i).getNote());
                clientVisitTaskList.setNoteTypeName(tasksArrayList.get(i).getTaskName());
                clientVisitTaskList.setTaskId(tasksArrayList.get(i).getTaskId());
                clientVisitTaskList.setTaskIsCompleted(tasksArrayList.get(i).isCompleted());

                Log.e("TASK_LIST", "  " + clientVisitTaskList.getNoteText());
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
