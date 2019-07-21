package com.example.carescheduling.Ui.Profile.View;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.Common.Common;
import com.example.carescheduling.Ui.Common.CommonBean;
import com.example.carescheduling.Ui.Dashboard.beans.PersonPhone;
import com.example.carescheduling.Ui.Dashboard.beans.ProfileBean;
import com.example.carescheduling.Ui.Dashboard.view.Dashboard;
import com.example.carescheduling.Ui.Profile.Adapter.CustomAdapter;
import com.example.carescheduling.Ui.Profile.bean.EditPhoneNumberBean;
import com.example.carescheduling.Utils.ConnectivityReceiver;
import com.example.carescheduling.Utils.Constants;
import com.example.carescheduling.data.Local.DatabaseTable.CountryCode;
import com.example.carescheduling.data.Local.DatabaseTable.PhoneType;
import com.example.carescheduling.data.Local.SessionManager;

import java.util.ArrayList;
import java.util.List;

import com.example.carescheduling.Ui.Profile.ViewModel.AddPhoneNumberViewModel;
import com.example.carescheduling.databinding.AddPhoneNumberFragmentBinding;

public class AddPhoneNumber extends BaseFragment implements Common {
    private AddPhoneNumberFragmentBinding editPhoneNumberBinding;
    private String stringValue, type;
    private ProfileBean profileBean;
    private AddPhoneNumberViewModel editPhoneNumberViewModel;
    private SessionManager sessionManager;

    public static AddPhoneNumber newInstance(String value, String type, ProfileBean profileBean) {
        AddPhoneNumber editPhoneNumber = new AddPhoneNumber();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.STRING_VALUE, value);
        bundle.putString(Constants.TYPE, type);
        bundle.putSerializable(Constants.PROFILE_DATA, profileBean);
        editPhoneNumber.setArguments(bundle);
        return editPhoneNumber;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            stringValue = getArguments().getString(Constants.STRING_VALUE);
            type = getArguments().getString(Constants.TYPE);
            profileBean = (ProfileBean) getArguments().getSerializable(Constants.PROFILE_DATA);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        editPhoneNumberBinding = DataBindingUtil.inflate(inflater, R.layout.add_phone_number_fragment, container, false);
        View view = editPhoneNumberBinding.getRoot();
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {
        setCommonData();
        sessionManager = getSessionManager();
        editPhoneNumberViewModel = ViewModelProviders.of(this).get(AddPhoneNumberViewModel.class);
        if (type.equalsIgnoreCase("Update")) {
            editPhoneNumberBinding.spinnerPhoneType.setEnabled(false);
            editPhoneNumberBinding.spinnerPhoneType.setClickable(false);
        } else {
            editPhoneNumberBinding.spinnerPhoneType.setEnabled(true);
            editPhoneNumberBinding.spinnerPhoneType.setClickable(true);
        }
        setCodePrefix();
        setPhoneType();
//        setEditPhoneNumber();

    }

    private void setCommonData() {
        CommonBean commonBean = new CommonBean();
        commonBean.setLeftImageDrawable(R.drawable.ic_left_back);
        commonBean.setLeftImageVisible(true);
        commonBean.setRightImageDrawable(R.drawable.ic_tick);
        commonBean.setRightImageVisible(false);
        commonBean.setRightTextVisible(true);
        commonBean.setTitle("Add Phone Number");
        editPhoneNumberBinding.setCommonData(commonBean);
        editPhoneNumberBinding.setCommonClick(this);
    }

    private void setCodePrefix() {
        editPhoneNumberViewModel.getCountryCode().observe(this, new Observer<List<CountryCode>>() {
            @Override
            public void onChanged(List<CountryCode> countryCodes) {
                ArrayList<String> arrayList = new ArrayList<>();
                if (countryCodes != null && countryCodes.size() > 0) {
                    for (int i = 0; i < countryCodes.size(); i++) {
                        if (i == 0)
                            arrayList.add("Select Country");
                        arrayList.add(countryCodes.get(i).getCountryName());
                    }
                    CustomAdapter adapter = new CustomAdapter(getActivity(),
                            R.layout.item_spinner_sf, R.id.title, arrayList);
                    editPhoneNumberBinding.spinnerCountryCode.setAdapter(adapter);
                }
            }
        });
    }

    private void setEditPhoneNumber() {
        editPhoneNumberViewModel.getEditPhoneNumberBean(stringValue, profileBean).observe(this, new Observer<EditPhoneNumberBean>() {
            @Override
            public void onChanged(EditPhoneNumberBean editPhoneNumberBean) {
                editPhoneNumberBinding.setEditPhoneNumberBean(editPhoneNumberBean);
                editPhoneNumberBinding.rbDefaultNumber.setSelected(editPhoneNumberBean.isDefault());
            }
        });
    }

    private void setPhoneType() {
        editPhoneNumberViewModel.getPhoneType().observe(this, new Observer<List<PhoneType>>() {
            @Override
            public void onChanged(List<PhoneType> phoneTypes) {
                ArrayList<String> arrayList = new ArrayList<>();
                if (phoneTypes != null && phoneTypes.size() > 0) {
                    for (int i = 0; i < phoneTypes.size(); i++) {
                        if (i == 0)
                            arrayList.add("Select Phone Type");
                        arrayList.add(phoneTypes.get(i).getPhoneName());
                    }
                    CustomAdapter adapter = new CustomAdapter(getActivity(),
                            R.layout.item_spinner_sf, R.id.title, arrayList);
                    editPhoneNumberBinding.spinnerPhoneType.setAdapter(adapter);
                }
            }
        });
    }


    private void setDataRemote() {

        setPhoneData();

    }

    private void setPhoneData() {

//        if (profileBean.getData() != null && profileBean.getData().getPerson() != null && profileBean.getData().getPerson().getPersonPhone() != null && stringValue != null) {
//            profileBean = updateNumber();
//        } else {
//            profileBean = addNewNumber();
//        }
        showDialog();
        profileBean = addNewNumber();
        if (profileBean == null) {
            hideDialog();
            return;
        }

        editPhoneNumberViewModel.getEditProfilePost(profileBean.getData()).observe(this, new Observer<ProfileBean>() {
            @Override
            public void onChanged(ProfileBean profileBean) {
                hideDialog();
                if (profileBean != null) {
                    if (profileBean.getSuccess()) {
                        Toast.makeText(getActivity(), (String) profileBean.getResponseMessage(), Toast.LENGTH_SHORT).show();
                        openDashboardActivity();
                    } else {
                        Toast.makeText(getActivity(), (String) profileBean.getResponseMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }


    private void openDashboardActivity() {
        Intent intent = new Intent(getActivity(), Dashboard.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        if (getActivity() != null)
            getActivity().finish();
    }


    private ProfileBean updateNumber() {
        int phoneCounter = 0;
        if (profileBean.getData().getPerson().getPersonPhone().size() > 0) {
            for (int i = 0; i < profileBean.getData().getPerson().getPersonPhone().size(); i++) {
                if (profileBean.getData().getPerson().getPersonPhone().get(i).getPhoneTypeName().equalsIgnoreCase((String) editPhoneNumberBinding.spinnerPhoneType.getSelectedItem())) {
                    profileBean.getData().getPerson().getPersonPhone().get(i).setCountryTelephonePrefix((String) editPhoneNumberBinding.spinnerCountryCode.getSelectedItem());
                    profileBean.getData().getPerson().getPersonPhone().get(i).setPhoneNumber(editPhoneNumberBinding.edtNumber.getText().toString());
                    profileBean.getData().getPerson().getPersonPhone().get(i).setIsDefaultPhone(editPhoneNumberBinding.rbDefaultNumber.isChecked());
                    phoneCounter++;
                    break;
                }
            }
        }

        if (phoneCounter == 0) {
            profileBean = addNewNumber();
        }

        return profileBean;
    }

    private ProfileBean addNewNumber() {

        PersonPhone personPhoneProfileBean = new PersonPhone();
        personPhoneProfileBean.setCanNotCall(editPhoneNumberBinding.rbDoNotCall.isChecked());
        personPhoneProfileBean.setCountryTelephonePrefix((String) editPhoneNumberBinding.spinnerCountryCode.getSelectedItem());
        personPhoneProfileBean.setCustomerId(sessionManager.getCustomerId());
        personPhoneProfileBean.setIsDefaultPhone(editPhoneNumberBinding.rbDefaultNumber.isChecked());
        personPhoneProfileBean.setPersonId(sessionManager.getPersonId());
        personPhoneProfileBean.setPhoneNumber(editPhoneNumberBinding.edtNumber.getText().toString());
        personPhoneProfileBean.setPhoneTypeName((String) editPhoneNumberBinding.spinnerPhoneType.getSelectedItem());
        profileBean.getData().getPerson().getPersonPhone().add(personPhoneProfileBean);

        return profileBean;
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
}

