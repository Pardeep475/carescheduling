package com.example.carescheduling.Ui.Profile.View;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.text.TextUtils;
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
import com.example.carescheduling.Ui.Profile.ViewModel.EditPhoneNumberViewModel;
import com.example.carescheduling.Ui.Profile.bean.EditNumberBeanRetro;
import com.example.carescheduling.Ui.Profile.bean.EditPhoneNumberBean;
import com.example.carescheduling.Ui.Profile.bean.PersonPhoneList;
import com.example.carescheduling.Ui.Profile.presenter.EditEmailClick;
import com.example.carescheduling.Utils.ConnectivityReceiver;
import com.example.carescheduling.Utils.Constants;
import com.example.carescheduling.data.Local.DatabaseTable.CountryCode;
import com.example.carescheduling.data.Local.DatabaseTable.Nationality;
import com.example.carescheduling.data.Local.DatabaseTable.PhoneType;
import com.example.carescheduling.data.Local.SessionManager;
import com.example.carescheduling.databinding.FragmentEditPhoneNumberBinding;

import java.util.ArrayList;
import java.util.List;

public class EditPhoneNumber extends BaseFragment implements Common {
    private FragmentEditPhoneNumberBinding editPhoneNumberBinding;
    private String stringValue;
    private PersonPhoneList profileBean;
    private EditPhoneNumberViewModel editPhoneNumberViewModel;

    public static EditPhoneNumber newInstance(String value, PersonPhoneList profileBean) {
        EditPhoneNumber editPhoneNumber = new EditPhoneNumber();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.STRING_VALUE, value);
        bundle.putSerializable(Constants.PROFILE_DATA, profileBean);
        editPhoneNumber.setArguments(bundle);
        return editPhoneNumber;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            stringValue = getArguments().getString(Constants.STRING_VALUE);
            profileBean = (PersonPhoneList) getArguments().getSerializable(Constants.PROFILE_DATA);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        editPhoneNumberBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_phone_number, container, false);
        View view = editPhoneNumberBinding.getRoot();
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {
        setCommonData();
        sessionManager = getSessionManager();
        editPhoneNumberViewModel = ViewModelProviders.of(this).get(EditPhoneNumberViewModel.class);
        editPhoneNumberBinding.spinnerPhoneType.setEnabled(false);
        editPhoneNumberBinding.spinnerPhoneType.setClickable(false);
        setCodePrefix();
        setPhoneType();
        setEditPhoneNumber();

    }

    private void setCommonData() {
        CommonBean commonBean = new CommonBean();
        commonBean.setLeftImageDrawable(R.drawable.ic_left_back);
        commonBean.setLeftImageVisible(true);
        commonBean.setRightImageDrawable(R.drawable.ic_tick);
        commonBean.setRightImageVisible(false);
        commonBean.setRightTextVisible(true);
        commonBean.setTitle("Edit Phone Number");
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
                    if (profileBean != null && profileBean.getCountryTelephonePrefix() != null) {
                        int pos = adapter.getPosition(profileBean.getCountryTelephonePrefix());
                        editPhoneNumberBinding.spinnerPhoneType.setSelection(pos);
                    }
                }

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
                    if (stringValue != null) {
                        int pos = adapter.getPosition(stringValue);
                        editPhoneNumberBinding.spinnerPhoneType.setSelection(pos);
                    }
                }
            }
        });
    }


    private void setEditPhoneNumber() {
        editPhoneNumberBinding.setPersonPhoneList(profileBean);
        editPhoneNumberBinding.rbDefaultNumber.setSelected(profileBean.getIsDefaultPhone());
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
        if (getActivity() != null && ConnectivityReceiver.isNetworkAvailable(getActivity())) {
            if (validation()) {
                showDialog();
                editPhoneNumberViewModel.EditNumber(EditNumber()).observe(this, new Observer<Boolean>() {
                    @Override
                    public void onChanged(Boolean s) {
                        hideDialog();
                        if (s != null) {
                            if (s) {
                                if (getActivity() != null) {
                                    getActivity().onBackPressed();
                                }
                            }
                        }

                    }
                });
            } else {

                hideDialog();
                Toast.makeText(getActivity(), "Please select image", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getActivity(), "please check your internet connection", Toast.LENGTH_SHORT).show();
        }
    }

    private EditNumberBeanRetro EditNumber() {
        EditNumberBeanRetro editPhoneNumberBean = new EditNumberBeanRetro();
        editPhoneNumberBean.setCustomerId(getSessionManager().getCustomerId());
        editPhoneNumberBean.setPersonId(getSessionManager().getPersonId());
        editPhoneNumberBean.setOldPhoneNumber(profileBean.getPhoneNumber());
        editPhoneNumberBean.setCountryTelephonePrefix((String) editPhoneNumberBinding.spinnerCountryCode.getSelectedItem());
        editPhoneNumberBean.setPhoneNumber(editPhoneNumberBinding.edtNumber.getText().toString());
        editPhoneNumberBean.setPhoneTypeName((String) editPhoneNumberBinding.spinnerPhoneType.getSelectedItem());
        editPhoneNumberBean.setDefaultPhone(editPhoneNumberBinding.rbDefaultNumber.isChecked());
        return editPhoneNumberBean;
    }

    private boolean validation() {
        if (editPhoneNumberBinding.spinnerCountryCode.getSelectedItemPosition() <= 0) {
            showAToast("Please select country code");
            return false;
        } else if (editPhoneNumberBinding.spinnerPhoneType.getSelectedItemPosition() <= 0) {
            showAToast("Please select phone type");
            return false;
        }
        if (TextUtils.isEmpty(editPhoneNumberBinding.edtNumber.getText())) {
            showAToast("Please enter number");
            return false;
        }
        return true;
    }
}
