package com.example.carescheduling.Ui.Profile.View;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.Nullable;
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
import com.example.carescheduling.Ui.Dashboard.beans.ProfileBean;
import com.example.carescheduling.Ui.Dashboard.beans.ProfileResultBean;
import com.example.carescheduling.Ui.Profile.Adapter.CustomAdapter;
import com.example.carescheduling.Ui.Profile.ViewModel.EditProfileInfoViewModel;
import com.example.carescheduling.Ui.Profile.presenter.EditEmailClick;
import com.example.carescheduling.Ui.Profile.presenter.EditProfileInfoClick;
import com.example.carescheduling.Utils.Constants;
import com.example.carescheduling.data.Local.DatabaseTable.Ethnicity;
import com.example.carescheduling.data.Local.DatabaseTable.Gender;
import com.example.carescheduling.data.Local.DatabaseTable.MaritialStatus;
import com.example.carescheduling.data.Local.DatabaseTable.PersonLanguage;
import com.example.carescheduling.data.Local.DatabaseTable.Prefix;
import com.example.carescheduling.databinding.FragmentEditProfileInfoBinding;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class EditProfileInfo extends BaseFragment implements EditEmailClick, EditProfileInfoClick {

    private FragmentEditProfileInfoBinding fragmentEditProfileInfoBinding;
    private EditProfileInfoViewModel editProfileInfoViewModel;
    private DatePicker datePicker;
    private Calendar calendar;
    private int year, month, day;
    private ProfileBean profileResultBean;

    public static EditProfileInfo newInstance(ProfileBean profileResultBean) {
        EditProfileInfo editProfileInfo = new EditProfileInfo();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constants.PROFILE_DATA, (Serializable) profileResultBean);
        editProfileInfo.setArguments(bundle);
        return editProfileInfo;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            profileResultBean = (ProfileBean) getArguments().getSerializable(Constants.PROFILE_DATA);
        }
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
        setLanguageData();
        setEthnicityData();
        setGenderData();
        setPrefixData();
        setMaritalData();

        fragmentEditProfileInfoBinding.setEditEmailClick(this);
        fragmentEditProfileInfoBinding.setEditProfileInfoClick(this);

    }

    private void setLanguageData() {
        editProfileInfoViewModel.getPersonLanguage().observe(this, new Observer<List<PersonLanguage>>() {
            @Override
            public void onChanged(List<PersonLanguage> list) {
                ArrayList<String> arrayList = new ArrayList<>();
                if (list != null && list.size() > 0) {
                    for (int i = 0; i < list.size(); i++) {
                        arrayList.add(list.get(i).getLanguageName());
                    }
                    CustomAdapter adapter = new CustomAdapter(getActivity(),
                            R.layout.item_spinner_sf, R.id.title, arrayList);
                    fragmentEditProfileInfoBinding.spinnerLanguage.setAdapter(adapter);
                }
            }
        });

    }

    private void setPrefixData() {
        editProfileInfoViewModel.getPrefix().observe(this, new Observer<List<Prefix>>() {
            @Override
            public void onChanged(List<Prefix> prefixes) {
                ArrayList<String> arrayList = new ArrayList<>();
                if (prefixes != null && prefixes.size() > 0) {
                    for (int i = 0; i < prefixes.size(); i++) {
                        arrayList.add(prefixes.get(i).getPrefixName());
                    }
                    CustomAdapter adapter = new CustomAdapter(getActivity(),
                            R.layout.item_spinner_sf, R.id.title, arrayList);
                    fragmentEditProfileInfoBinding.spinnerPrefix.setAdapter(adapter);
                }
            }

        });
    }

    private void setEthnicityData() {
        editProfileInfoViewModel.getEthnicity().observe(this, new Observer<List<Ethnicity>>() {
            @Override
            public void onChanged(List<Ethnicity> ethnicities) {
                ArrayList<String> arrayList = new ArrayList<>();
                if (ethnicities != null && ethnicities.size() > 0) {
                    for (int i = 0; i < ethnicities.size(); i++) {
                        arrayList.add(ethnicities.get(i).getEthnicityName());
                    }
                    CustomAdapter adapter = new CustomAdapter(getActivity(),
                            R.layout.item_spinner_sf, R.id.title, arrayList);
                    fragmentEditProfileInfoBinding.spinnerEthnicity.setAdapter(adapter);
                }
            }
        });
    }

    private void setMaritalData() {
        editProfileInfoViewModel.getMaritalStatus().observe(this, new Observer<List<MaritialStatus>>() {
            @Override
            public void onChanged(List<MaritialStatus> maritialStatuses) {
                ArrayList<String> arrayList = new ArrayList<>();
                if (maritialStatuses != null && maritialStatuses.size() > 0) {
                    for (int i = 0; i < maritialStatuses.size(); i++) {
                        arrayList.add(maritialStatuses.get(i).getMaritialStatusName());
                    }
                    CustomAdapter adapter = new CustomAdapter(getActivity(),
                            R.layout.item_spinner_sf, R.id.title, arrayList);
                    fragmentEditProfileInfoBinding.spinnerMaritalStatus.setAdapter(adapter);
                }
            }

        });
    }

    private void setGenderData() {
        editProfileInfoViewModel.getGender().observe(this, new Observer<List<Gender>>() {
            @Override
            public void onChanged(List<Gender> genders) {
                ArrayList<String> arrayList = new ArrayList<>();
                if (genders != null && genders.size() > 0) {
                    for (int i = 0; i < genders.size(); i++) {
                        arrayList.add(genders.get(i).getGenderName());
                    }
                    CustomAdapter adapter = new CustomAdapter(getActivity(),
                            R.layout.item_spinner_sf, R.id.title, arrayList);
                    fragmentEditProfileInfoBinding.spinnerGender.setAdapter(adapter);
                }
            }
        });


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
                    showDate(arg1, arg2 + 1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        Toast.makeText(getActivity(), year + " " + month + " " + day, Toast.LENGTH_SHORT).show();
        editProfileInfoViewModel.datePicker(year + "/" + month + "/" + day).observe(getActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                fragmentEditProfileInfoBinding.setDate(s);
            }
        });
//        dateView.setText(new StringBuilder().append(day).append("/")
//                .append(month).append("/").append(year));
    }


    private static class PopulateStringData extends AsyncTask<Void, Void, ArrayList<String>> {

        private List<String> list;

        PopulateStringData(List<String> list) {

            this.list = list;
        }

        @Override
        protected ArrayList<String> doInBackground(final Void... params) {

            return null;
        }

    }

}
