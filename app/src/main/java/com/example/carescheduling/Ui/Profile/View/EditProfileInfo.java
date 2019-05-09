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
import com.example.carescheduling.Ui.Profile.bean.EditProfileInfoBean;
import com.example.carescheduling.Ui.Profile.presenter.EditEmailClick;
import com.example.carescheduling.Ui.Profile.presenter.EditProfileInfoClick;
import com.example.carescheduling.Utils.Constants;
import com.example.carescheduling.data.Local.DatabaseTable.DisabilityType;
import com.example.carescheduling.data.Local.DatabaseTable.Ethnicity;
import com.example.carescheduling.data.Local.DatabaseTable.Gender;
import com.example.carescheduling.data.Local.DatabaseTable.MaritialStatus;
import com.example.carescheduling.data.Local.DatabaseTable.Nationality;
import com.example.carescheduling.data.Local.DatabaseTable.PersonLanguage;
import com.example.carescheduling.data.Local.DatabaseTable.Prefix;
import com.example.carescheduling.data.Local.DatabaseTable.Religion;
import com.example.carescheduling.data.Local.DatabaseTable.SexualityType;
import com.example.carescheduling.data.Local.SessionManager;
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
    private SessionManager sessionManager;

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
        sessionManager = getSessionManager();
        setLanguageData();
        setEthnicityData();
        setGenderData();
        setPrefixData();
        setMaritalData();
        setDisabilityType();
        setReligion();
        setSexualityType();
        setNationalityData();
        setProfileInfoBeanData(profileResultBean);
        fragmentEditProfileInfoBinding.setEditEmailClick(this);
        fragmentEditProfileInfoBinding.setEditProfileInfoClick(this);

    }


    private void setProfileInfoBeanData(final ProfileBean profileResultBean) {
        editProfileInfoViewModel.getProfileEditBean(profileResultBean).observe(this, new Observer<EditProfileInfoBean>() {
            @Override
            public void onChanged(EditProfileInfoBean editProfileInfoBean) {
                fragmentEditProfileInfoBinding.setProfileInfoBean(editProfileInfoBean);

            }
        });
    }


    private void setDataRemote() {
        showDialog();
        ProfileBean profileBean = profileResultBean;
        profileResultBean.getData().getPerson().setFirstName(fragmentEditProfileInfoBinding.edtFirstName.getText().toString());
        profileResultBean.getData().getPerson().setSurName(fragmentEditProfileInfoBinding.edtSurname.getText().toString());
        profileResultBean.getData().getPerson().setMiddleName(fragmentEditProfileInfoBinding.edtMiddleName.getText().toString());
        profileResultBean.getData().getPerson().setMaidenName(fragmentEditProfileInfoBinding.edtMaidenName.getText().toString());
        profileBean.getData().getPerson().getPersonNationality().get(0).setCountryName((String) fragmentEditProfileInfoBinding.spinnerNationality.getSelectedItem());
        profileBean.getData().getPerson().setGenderTypeName((String) fragmentEditProfileInfoBinding.spinnerGender.getSelectedItem());
        profileBean.getData().getPerson().setPrefixTypeName((String) fragmentEditProfileInfoBinding.spinnerPrefix.getSelectedItem());
        profileBean.getData().getPerson().getPersonLanguage().get(0).setLanguageName((String) fragmentEditProfileInfoBinding.spinnerLanguage.getSelectedItem());
        profileBean.getData().getPerson().getPersonMaritalStatus().get(0).setMaritalStatusName((String) fragmentEditProfileInfoBinding.spinnerMaritalStatus.getSelectedItem());
        profileBean.getData().getPerson().getPersonEthnicity().get(0).setEthnicityTypeName((String) fragmentEditProfileInfoBinding.spinnerEthnicity.getSelectedItem());
        profileBean.getData().getPerson().getPersonReligion().get(0).setReligionTypeName((String) fragmentEditProfileInfoBinding.spinnerReligion.getSelectedItem());
        profileBean.getData().getPerson().getPersonSexuality().get(0).setSexualityTypeName((String) fragmentEditProfileInfoBinding.spinnerSexuality.getSelectedItem());
        fragmentEditProfileInfoBinding.spinnerDisability.getSelectedItem();


        editProfileInfoViewModel.getEditProfilePost(sessionManager.getCustomerId(), sessionManager.getPersonId(), profileBean.getData()).observe(this, new Observer<ProfileBean>() {
            @Override
            public void onChanged(ProfileBean profileBean) {
                hideDialog();
                if (profileBean != null)
                    Toast.makeText(getActivity(), "Success", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void setNationalityData() {
        editProfileInfoViewModel.getNationality().observe(this, new Observer<List<Nationality>>() {
            @Override
            public void onChanged(List<Nationality> nationalities) {
                ArrayList<String> arrayList = new ArrayList<>();
                if (nationalities != null && nationalities.size() > 0) {
                    for (int i = 0; i < nationalities.size(); i++) {
                        arrayList.add(nationalities.get(i).getNationalityName());
                    }
                    CustomAdapter adapter = new CustomAdapter(getActivity(),
                            R.layout.item_spinner_sf, R.id.title, arrayList);
                    fragmentEditProfileInfoBinding.spinnerNationality.setAdapter(adapter);
                    if (profileResultBean != null && profileResultBean.getData() != null && profileResultBean.getData().getPerson() != null) {
                        if (profileResultBean.getData().getPerson().getPersonNationality() != null) {
                            if (profileResultBean.getData().getPerson().getPersonNationality().size()>0) {
                                int pos = adapter.getPosition(profileResultBean.getData().getPerson().getPersonNationality().get(0).getCountryName());
                                fragmentEditProfileInfoBinding.spinnerNationality.setSelection(pos);
                            }
                        }
                    }
                }
            }
        });
    }

    private void setSexualityType() {
        editProfileInfoViewModel.getSexualityType().observe(this, new Observer<List<SexualityType>>() {
            @Override
            public void onChanged(List<SexualityType> sexualityTypes) {
                ArrayList<String> arrayList = new ArrayList<>();
                if (sexualityTypes != null && sexualityTypes.size() > 0) {
                    for (int i = 0; i < sexualityTypes.size(); i++) {
                        arrayList.add(sexualityTypes.get(i).getSexualityName());
                    }
                    CustomAdapter adapter = new CustomAdapter(getActivity(),
                            R.layout.item_spinner_sf, R.id.title, arrayList);
                    fragmentEditProfileInfoBinding.spinnerSexuality.setAdapter(adapter);
                    if (profileResultBean != null && profileResultBean.getData() != null && profileResultBean.getData().getPerson() != null) {
                        if (profileResultBean.getData().getPerson().getPersonSexuality() != null) {
                            if (profileResultBean.getData().getPerson().getPersonSexuality().size() > 0) {
                                int pos = adapter.getPosition(profileResultBean.getData().getPerson().getPersonSexuality().get(0).getSexualityTypeName());
                                fragmentEditProfileInfoBinding.spinnerSexuality.setSelection(pos);
                            }
                        }
                    }
                }
            }
        });
    }

    private void setReligion() {
        editProfileInfoViewModel.getReligion().observe(this, new Observer<List<Religion>>() {
            @Override
            public void onChanged(List<Religion> religions) {
                ArrayList<String> arrayList = new ArrayList<>();
                if (religions != null && religions.size() > 0) {
                    for (int i = 0; i < religions.size(); i++) {
                        arrayList.add(religions.get(i).getReligionName());
                    }
                    CustomAdapter adapter = new CustomAdapter(getActivity(),
                            R.layout.item_spinner_sf, R.id.title, arrayList);
                    fragmentEditProfileInfoBinding.spinnerReligion.setAdapter(adapter);
                    if (profileResultBean != null && profileResultBean.getData() != null && profileResultBean.getData().getPerson() != null) {
                        if (profileResultBean.getData().getPerson().getPersonReligion() != null) {
                            if (profileResultBean.getData().getPerson().getPersonReligion().size() > 0) {
                                int pos = adapter.getPosition(profileResultBean.getData().getPerson().getPersonReligion().get(0).getReligionTypeName());
                                fragmentEditProfileInfoBinding.spinnerReligion.setSelection(pos);
                            }
                        }
                    }
                }
            }
        });
    }

    private void setDisabilityType() {
        editProfileInfoViewModel.getDisabilityType().observe(this, new Observer<List<DisabilityType>>() {
            @Override
            public void onChanged(List<DisabilityType> disabilityTypes) {
                ArrayList<String> arrayList = new ArrayList<>();
                if (disabilityTypes != null && disabilityTypes.size() > 0) {
                    for (int i = 0; i < disabilityTypes.size(); i++) {
                        arrayList.add(disabilityTypes.get(i).getDisabilityName());
                    }
                    CustomAdapter adapter = new CustomAdapter(getActivity(),
                            R.layout.item_spinner_sf, R.id.title, arrayList);
                    fragmentEditProfileInfoBinding.spinnerDisability.setAdapter(adapter);
                    if (profileResultBean != null && profileResultBean.getData() != null && profileResultBean.getData().getPerson() != null) {
                        if (profileResultBean.getData().getPerson().getPersonDisability() != null) {
                            if (profileResultBean.getData().getPerson().getPersonDisability().size()>0) {
                                int pos = adapter.getPosition(profileResultBean.getData().getPerson().getPersonDisability().get(0).getDisabilityTypeName());
                                fragmentEditProfileInfoBinding.spinnerDisability.setSelection(pos);
                            }
                        }
                    }
                }
            }
        });
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
                    if (profileResultBean != null && profileResultBean.getData() != null && profileResultBean.getData().getPerson() != null) {
                        if (profileResultBean.getData().getPerson().getPersonLanguage() != null) {
                            if (profileResultBean.getData().getPerson().getPersonLanguage().size() > 0) {
                                int pos = adapter.getPosition(profileResultBean.getData().getPerson().getPersonLanguage().get(0).getLanguageName());
                                fragmentEditProfileInfoBinding.spinnerLanguage.setSelection(pos);
                            }
                        }
                    }
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
                    if (profileResultBean != null && profileResultBean.getData() != null && profileResultBean.getData().getPerson() != null) {
                        if (profileResultBean.getData().getPerson().getPrefixTypeName() != null) {
                            int pos = adapter.getPosition(profileResultBean.getData().getPerson().getPrefixTypeName());
                            fragmentEditProfileInfoBinding.spinnerPrefix.setSelection(pos);
                        }
                    }
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
                    if (profileResultBean != null && profileResultBean.getData() != null && profileResultBean.getData().getPerson() != null) {
                        if (profileResultBean.getData().getPerson().getPersonEthnicity() != null) {
                            if (profileResultBean.getData().getPerson().getPersonEthnicity().size() > 0) {
                                int pos = adapter.getPosition(profileResultBean.getData().getPerson().getPersonEthnicity().get(0).getEthnicityTypeName());
                                fragmentEditProfileInfoBinding.spinnerEthnicity.setSelection(pos);
                            }
                        }
                    }
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
                    if (profileResultBean != null && profileResultBean.getData() != null && profileResultBean.getData().getPerson() != null) {
                        if (profileResultBean.getData().getPerson().getPersonMaritalStatus() != null) {
                            if (profileResultBean.getData().getPerson().getPersonMaritalStatus().size() > 0) {
                                int pos = adapter.getPosition(profileResultBean.getData().getPerson().getPersonMaritalStatus().get(0).getMaritalStatusName());
                                fragmentEditProfileInfoBinding.spinnerMaritalStatus.setSelection(pos);
                            }
                        }
                    }
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
                    if (profileResultBean != null && profileResultBean.getData() != null && profileResultBean.getData().getPerson() != null) {
                        if (profileResultBean.getData().getPerson().getGenderTypeName() != null) {
                            int pos = adapter.getPosition(profileResultBean.getData().getPerson().getGenderTypeName());
                            fragmentEditProfileInfoBinding.spinnerGender.setSelection(pos);
                        }
                    }

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
        setDataRemote();
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
