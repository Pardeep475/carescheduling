package com.example.carescheduling.Ui.Profile.View;

import android.content.Context;
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
import com.example.carescheduling.Ui.Dashboard.beans.PersonPhone;
import com.example.carescheduling.Ui.Dashboard.beans.ProfileBean;
import com.example.carescheduling.Ui.Profile.Adapter.CustomAdapter;
import com.example.carescheduling.Ui.Profile.ViewModel.EditPhoneNumberViewModel;
import com.example.carescheduling.Ui.Profile.bean.EditPhoneNumberBean;
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

public class EditPhoneNumber extends BaseFragment implements EditEmailClick {
    private FragmentEditPhoneNumberBinding editPhoneNumberBinding;
    private String stringValue;
    private ProfileBean profileBean;
    private EditPhoneNumberViewModel editPhoneNumberViewModel;
    private SessionManager sessionManager;

    public static EditPhoneNumber newInstance(String value, ProfileBean profileBean) {
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
            profileBean = (ProfileBean) getArguments().getSerializable(Constants.PROFILE_DATA);
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
        sessionManager = getSessionManager();
        editPhoneNumberViewModel = ViewModelProviders.of(this).get(EditPhoneNumberViewModel.class);
        setCodePrefix();
        setPhoneType();
        setEditPhoneNumber();
        editPhoneNumberBinding.setEditEmailClick(this);
    }

    private void setCodePrefix() {
        editPhoneNumberViewModel.getCountryCode().observe(this, new Observer<List<CountryCode>>() {
            @Override
            public void onChanged(List<CountryCode> countryCodes) {
                ArrayList<String> arrayList = new ArrayList<>();
                if (countryCodes != null && countryCodes.size() > 0) {
                    for (int i = 0; i < countryCodes.size(); i++) {
                        arrayList.add(countryCodes.get(i).getCountryName());
                    }
                    CustomAdapter adapter = new CustomAdapter(getActivity(),
                            R.layout.item_spinner_sf, R.id.title, arrayList);
                    editPhoneNumberBinding.spinnerCountryCode.setAdapter(adapter);
                    if (profileBean != null && profileBean.getData() != null && profileBean.getData().getPerson() != null) {
                        if (profileBean.getData().getPerson().getPersonPhone() != null) {
                            if (profileBean.getData().getPerson().getPersonPhone().size() > 0) {
                                int pos = adapter.getPosition(profileBean.getData().getPerson().getPersonPhone().get(0).getCountryTelephonePrefix());
                                editPhoneNumberBinding.spinnerPhoneType.setSelection(pos);
                            }
                        }
                    }
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
                        arrayList.add(phoneTypes.get(i).getPhoneName());
                    }
                    CustomAdapter adapter = new CustomAdapter(getActivity(),
                            R.layout.item_spinner_sf, R.id.title, arrayList);
                    editPhoneNumberBinding.spinnerPhoneType.setAdapter(adapter);
                    if (profileBean != null && profileBean.getData() != null && profileBean.getData().getPerson() != null) {
                        if (profileBean.getData().getPerson().getPersonPhone() != null) {
                            if (profileBean.getData().getPerson().getPersonPhone().size() > 0) {
                                int pos = adapter.getPosition(profileBean.getData().getPerson().getPersonPhone().get(0).getPhoneTypeName());
                                editPhoneNumberBinding.spinnerPhoneType.setSelection(pos);
                            }
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
        showDialog();
        setPhoneData();

    }

    private void setPhoneData() {

        if (profileBean.getData() != null && profileBean.getData().getPerson() != null && profileBean.getData().getPerson().getPersonPhone() != null && stringValue != null) {
            profileBean = updateNumber();
        } else {
            profileBean = addNewNumber();
        }

        editPhoneNumberViewModel.getEditProfilePost(profileBean.getData()).observe(this, new Observer<ProfileBean>() {
            @Override
            public void onChanged(ProfileBean profileBean) {
                hideDialog();
                if (profileBean != null) {
                    if (profileBean.getSuccess()) {
                        Toast.makeText(getActivity(), (String) profileBean.getResponseMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getActivity(), (String) profileBean.getResponseMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_SHORT).show();
                }

            }
        });

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
}
