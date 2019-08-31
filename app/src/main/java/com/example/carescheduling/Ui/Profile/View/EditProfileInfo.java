package com.example.carescheduling.Ui.Profile.View;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.Common.Common;
import com.example.carescheduling.Ui.Common.CommonBean;
import com.example.carescheduling.Ui.Profile.Adapter.CustomAdapter;
import com.example.carescheduling.Ui.Profile.ViewModel.EditProfileInfoViewModel;
import com.example.carescheduling.Ui.Profile.bean.EditProfileInfoBean;
import com.example.carescheduling.Ui.Profile.bean.EditProfileInfoBeanRetro;
import com.example.carescheduling.Ui.Profile.presenter.EditEmailClick;
import com.example.carescheduling.Ui.Profile.presenter.EditProfileInfoClick;
import com.example.carescheduling.Utils.ConnectivityReceiver;
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

public class EditProfileInfo extends BaseFragment implements Common, EditProfileInfoClick {

    private FragmentEditProfileInfoBinding fragmentEditProfileInfoBinding;
    private EditProfileInfoViewModel editProfileInfoViewModel;
    private DatePicker datePicker;
    private Calendar calendar;
    private int year, month, day;
    private SessionManager sessionManager;
    private EditProfileInfoBean editProfileBean;

    public static EditProfileInfo newInstance() {
        return new EditProfileInfo();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
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
        setCommonData();
        editProfileInfoViewModel = ViewModelProviders.of(this).get(EditProfileInfoViewModel.class);
        sessionManager = getSessionManager();
        setProfileInfoBeanData();
        fragmentEditProfileInfoBinding.setEditProfileInfoClick(this);

    }


    private void setCommonData() {
        CommonBean commonBean = new CommonBean();
        commonBean.setLeftImageDrawable(R.drawable.ic_left_back);
        commonBean.setLeftImageVisible(true);
        commonBean.setRightImageDrawable(R.drawable.ic_tick);
        commonBean.setRightImageVisible(false);
        commonBean.setRightTextVisible(true);
        commonBean.setTitle("User Info");
        fragmentEditProfileInfoBinding.setCommonData(commonBean);
        fragmentEditProfileInfoBinding.setCommonClick(this);
    }

    private void setProfileInfoBeanData() {
        setSpinnerData();
        if (getActivity() != null) {
            if (ConnectivityReceiver.isNetworkAvailable(getActivity())) {
                showDialog();
                try {
                    editProfileInfoViewModel.GetMyProfileEdit(sessionManager.getPersonId(), sessionManager.getCustomerId(), sessionManager.getBranchId())
                            .observe(this, new Observer<EditProfileInfoBean>() {
                                @Override
                                public void onChanged(EditProfileInfoBean editProfileInfoBean) {
                                    hideDialog();
                                    editProfileBean = editProfileInfoBean;
                                    if (editProfileInfoBean != null) {
                                        fragmentEditProfileInfoBinding.setDate(editProfileInfoBean.getDateOfBirth());
                                        fragmentEditProfileInfoBinding.setProfileInfoBean(editProfileInfoBean);
                                    }

                                }
                            });

                } catch (Exception e) {
                    hideDialog();
                    Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
//                    setSpinnerData();
                }
            } else {

//                setSpinnerData();
                editProfileInfoViewModel.getDataFromLocal(getActivity()).observe(this, new Observer<EditProfileInfoBean>() {
                    @Override
                    public void onChanged(EditProfileInfoBean editProfileInfoBean) {
                        editProfileBean = editProfileInfoBean;
                        if (editProfileInfoBean != null) {
                            fragmentEditProfileInfoBinding.setDate(editProfileInfoBean.getDateOfBirth());
                            fragmentEditProfileInfoBinding.setProfileInfoBean(editProfileInfoBean);
                        } else {
                            Toast.makeText(getActivity(), "please check your internet connection", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }
    }

    private void setSpinnerData() {
        setLanguageData();
        setEthnicityData();
        setGenderData();
        setPrefixData();
        setMaritalData();
        setDisabilityType();
        setReligion();
        setSexualityType();
        setNationalityData();
    }

    private void setNationalityData() {
        editProfileInfoViewModel.getNationality().observe(this, new Observer<List<Nationality>>() {
            @Override
            public void onChanged(List<Nationality> nationalities) {
                ArrayList<String> arrayList = new ArrayList<>();
                if (nationalities != null && nationalities.size() > 0) {
                    for (int i = 0; i < nationalities.size(); i++) {
                        if (i == 0)
                            arrayList.add("Select Nationalities");
                        arrayList.add(nationalities.get(i).getNationalityName());
                    }
                    CustomAdapter adapter = new CustomAdapter(getActivity(),
                            R.layout.item_spinner_sf, R.id.title, arrayList);
                    fragmentEditProfileInfoBinding.spinnerNationality.setAdapter(adapter);
                    if (editProfileBean != null) {
                        if (editProfileBean.getNationality() != null) {
                            int pos = adapter.getPosition(editProfileBean.getNationality());
                            fragmentEditProfileInfoBinding.spinnerNationality.setSelection(pos);
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
                        if (i == 0)
                            arrayList.add("Select Sexuality");
                        arrayList.add(sexualityTypes.get(i).getSexualityName());
                    }
                    CustomAdapter adapter = new CustomAdapter(getActivity(),
                            R.layout.item_spinner_sf, R.id.title, arrayList);
                    fragmentEditProfileInfoBinding.spinnerSexuality.setAdapter(adapter);
                    if (editProfileBean != null) {
                        if (editProfileBean.getSexuality() != null) {
                            int pos = adapter.getPosition(editProfileBean.getSexuality());
                            fragmentEditProfileInfoBinding.spinnerSexuality.setSelection(pos);
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
                        if (i == 0)
                            arrayList.add("Select Religion");
                        arrayList.add(religions.get(i).getReligionName());
                    }
                    CustomAdapter adapter = new CustomAdapter(getActivity(),
                            R.layout.item_spinner_sf, R.id.title, arrayList);
                    fragmentEditProfileInfoBinding.spinnerReligion.setAdapter(adapter);
                    if (editProfileBean != null) {
                        if (editProfileBean.getReligion() != null) {
                            int pos = adapter.getPosition(editProfileBean.getReligion());
                            fragmentEditProfileInfoBinding.spinnerReligion.setSelection(pos);
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
                        if (i == 0)
                            arrayList.add("Select Disability");
                        arrayList.add(disabilityTypes.get(i).getDisabilityName());
                    }
                    CustomAdapter adapter = new CustomAdapter(getActivity(),
                            R.layout.item_spinner_sf, R.id.title, arrayList);
                    fragmentEditProfileInfoBinding.spinnerDisability.setAdapter(adapter);
                    if (editProfileBean != null) {
                        if (editProfileBean.getDisabaility() != null) {
                            int pos = adapter.getPosition(editProfileBean.getDisabaility());
                            fragmentEditProfileInfoBinding.spinnerDisability.setSelection(pos);
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
                        if (i == 0)
                            arrayList.add("Select Language");

                        arrayList.add(list.get(i).getLanguageName());
                    }
                    CustomAdapter adapter = new CustomAdapter(getActivity(),
                            R.layout.item_spinner_sf, R.id.title, arrayList);
                    fragmentEditProfileInfoBinding.spinnerLanguage.setAdapter(adapter);
                    if (editProfileBean != null) {
                        if (editProfileBean.getLanguage() != null) {
                            int pos = adapter.getPosition(editProfileBean.getLanguage());
                            fragmentEditProfileInfoBinding.spinnerLanguage.setSelection(pos);
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
                        if (i == 0)
                            arrayList.add("Select Prefix");
                        arrayList.add(prefixes.get(i).getPrefixName());
                    }
                    CustomAdapter adapter = new CustomAdapter(getActivity(),
                            R.layout.item_spinner_sf, R.id.title, arrayList);
                    fragmentEditProfileInfoBinding.spinnerPrefix.setAdapter(adapter);
                    if (editProfileBean != null) {
                        if (editProfileBean.getPrefix() != null) {
                            int pos = adapter.getPosition(editProfileBean.getPrefix());
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
                        if (i == 0)
                            arrayList.add("Select Ethnicity");
                        arrayList.add(ethnicities.get(i).getEthnicityName());
                    }
                    CustomAdapter adapter = new CustomAdapter(getActivity(),
                            R.layout.item_spinner_sf, R.id.title, arrayList);
                    fragmentEditProfileInfoBinding.spinnerEthnicity.setAdapter(adapter);
                    if (editProfileBean != null) {
                        if (editProfileBean.getEthnicity() != null) {
                            int pos = adapter.getPosition(editProfileBean.getEthnicity());
                            fragmentEditProfileInfoBinding.spinnerEthnicity.setSelection(pos);
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
                        if (i == 0)
                            arrayList.add("Select Marital Status");
                        arrayList.add(maritialStatuses.get(i).getMaritialStatusName());
                    }
                    CustomAdapter adapter = new CustomAdapter(getActivity(),
                            R.layout.item_spinner_sf, R.id.title, arrayList);
                    fragmentEditProfileInfoBinding.spinnerMaritalStatus.setAdapter(adapter);
                    if (editProfileBean != null) {
                        if (editProfileBean.getMaritalStatus() != null) {
                            int pos = adapter.getPosition(editProfileBean.getMaritalStatus());
                            fragmentEditProfileInfoBinding.spinnerMaritalStatus.setSelection(pos);
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
                        if (i == 0)
                            arrayList.add("Select Gender");
                        arrayList.add(genders.get(i).getGenderName());
                    }
                    CustomAdapter adapter = new CustomAdapter(getActivity(),
                            R.layout.item_spinner_sf, R.id.title, arrayList);
                    fragmentEditProfileInfoBinding.spinnerGender.setAdapter(adapter);
                    if (editProfileBean != null) {
                        if (editProfileBean.getMaritalStatus() != null) {
                            int pos = adapter.getPosition(editProfileBean.getGender());
                            fragmentEditProfileInfoBinding.spinnerGender.setSelection(pos);
                        }
                    }

                }
            }
        });


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
        // DD-MM-YYYY
        String day1, month1;
        day1 = String.valueOf(day);
        month1 = String.valueOf(month);
        if (day1.length() == 1)
            day1 = "0" + day1;
        if (month1.length() == 1)
            month1 = "0" + month1;
        Toast.makeText(getActivity(), day1 + "-" + month1 + "-" + year, Toast.LENGTH_SHORT).show();
        editProfileInfoViewModel.datePicker(day1 + "-" + month1 + "-" + year).observe(getActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                fragmentEditProfileInfoBinding.setDate(s);
            }
        });
    }

    @Override
    public void leftClick() {
        if (getActivity() != null)
            getActivity().onBackPressed();
    }

    @Override
    public void rightClick() {
        if (getActivity() != null) {
            try {
                if (ConnectivityReceiver.isNetworkAvailable(getActivity())) {
                    setDataRemote();
                } else {
                    Toast.makeText(getActivity(), "please check your internet connection", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                hideDialog();
                Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void setDataRemote() {
        if (validation()) {
            EditProfileInfoBeanRetro editProfileInfoBeanRetro = new EditProfileInfoBeanRetro(
                    getSessionManager().getPersonId(), getSessionManager().getBranchId(), getSessionManager().getCustomerId(),
                    fragmentEditProfileInfoBinding.edtFirstName.getText().toString(), fragmentEditProfileInfoBinding.edtMiddleName.getText().toString(),
                    fragmentEditProfileInfoBinding.edtSurname.getText().toString(), fragmentEditProfileInfoBinding.edtMaidenName.getText().toString(),
                    (String) fragmentEditProfileInfoBinding.spinnerGender.getSelectedItem(), fragmentEditProfileInfoBinding.txtDateOfBirth.getText().toString(),
                    (String) fragmentEditProfileInfoBinding.spinnerPrefix.getSelectedItem(), (String) fragmentEditProfileInfoBinding.spinnerLanguage.getSelectedItem(),
                    (String) fragmentEditProfileInfoBinding.spinnerMaritalStatus.getSelectedItem(), (String) fragmentEditProfileInfoBinding.spinnerEthnicity.getSelectedItem(),
                    (String) fragmentEditProfileInfoBinding.spinnerDisability.getSelectedItem(), (String) fragmentEditProfileInfoBinding.spinnerReligion.getSelectedItem(),
                    (String) fragmentEditProfileInfoBinding.spinnerSexuality.getSelectedItem(), (String) fragmentEditProfileInfoBinding.spinnerNationality.getSelectedItem(),
                    editProfileBean.isDisability()
            );
            showDialog();
            editProfileInfoViewModel.UpdateProfile(editProfileInfoBeanRetro).observe(this, new Observer<Boolean>() {
                @Override
                public void onChanged(Boolean aBoolean) {
                    hideDialog();
                    if (aBoolean != null) {
                        if (aBoolean) {
                            // on back press
                            if (getActivity() != null)
                                getActivity().onBackPressed();
                        }
                    }
                }
            });
        }
    }

    private boolean validation() {
        if (TextUtils.isEmpty(fragmentEditProfileInfoBinding.edtFirstName.getText().toString())) {
            showAToast("please select first name");
            return false;
        } else if (TextUtils.isEmpty(fragmentEditProfileInfoBinding.edtMiddleName.getText().toString())) {
            showAToast("please select middle name");
            return false;
        } else if (TextUtils.isEmpty(fragmentEditProfileInfoBinding.edtSurname.getText().toString())) {
            showAToast("please select surname name");
            return false;
        } else if (TextUtils.isEmpty(fragmentEditProfileInfoBinding.edtMaidenName.getText().toString())) {
            showAToast("please select maiden name");
            return false;
        } else if (TextUtils.isEmpty(fragmentEditProfileInfoBinding.txtDateOfBirth.getText().toString())) {
            showAToast("please select date of birth");
            return false;
        } else if ((fragmentEditProfileInfoBinding.spinnerGender.getSelectedItemPosition() - 1) < 0) {
            showAToast("please select gender type");
            return false;
        } else if ((fragmentEditProfileInfoBinding.spinnerGender.getSelectedItemPosition() - 1) < 0) {
            showAToast("please select gender type");
            return false;
        } else if ((fragmentEditProfileInfoBinding.spinnerPrefix.getSelectedItemPosition() - 1) < 0) {
            showAToast("please select prefix type");
            return false;
        } else if ((fragmentEditProfileInfoBinding.spinnerLanguage.getSelectedItemPosition() - 1) < 0) {
            showAToast("please select Language");
            return false;
        } else if ((fragmentEditProfileInfoBinding.spinnerMaritalStatus.getSelectedItemPosition() - 1) < 0) {
            showAToast("please select marital status");
            return false;
        } else if ((fragmentEditProfileInfoBinding.spinnerEthnicity.getSelectedItemPosition() - 1) < 0) {
            showAToast("please select ethnicity");
            return false;
        } else if ((fragmentEditProfileInfoBinding.spinnerDisability.getSelectedItemPosition() - 1) < 0) {
            showAToast("please select disability");
            return false;
        } else if ((fragmentEditProfileInfoBinding.spinnerReligion.getSelectedItemPosition() - 1) < 0) {
            showAToast("please select religion");
            return false;
        } else if ((fragmentEditProfileInfoBinding.spinnerSexuality.getSelectedItemPosition() - 1) < 0) {
            showAToast("please select sexuality");
            return false;
        } else if ((fragmentEditProfileInfoBinding.spinnerNationality.getSelectedItemPosition() - 1) < 0) {
            showAToast("please select nationality");
            return false;
        }
        return true;
    }

}
