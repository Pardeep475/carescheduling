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

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.Dashboard.beans.ProfileBean;
import com.example.carescheduling.Ui.Profile.Adapter.CustomAdapter;
import com.example.carescheduling.Ui.Profile.ViewModel.EditPhoneNumberViewModel;
import com.example.carescheduling.Ui.Profile.bean.EditPhoneNumberBean;
import com.example.carescheduling.Ui.Profile.presenter.EditEmailClick;
import com.example.carescheduling.Utils.Constants;
import com.example.carescheduling.data.Local.DatabaseTable.CountryCode;
import com.example.carescheduling.data.Local.DatabaseTable.Nationality;
import com.example.carescheduling.databinding.FragmentEditPhoneNumberBinding;

import java.util.ArrayList;
import java.util.List;

public class EditPhoneNumber extends BaseFragment implements EditEmailClick {
    private FragmentEditPhoneNumberBinding editPhoneNumberBinding;
    private String stringValue;
    private ProfileBean profileBean;
    private EditPhoneNumberViewModel editPhoneNumberViewModel;

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
        editPhoneNumberViewModel = ViewModelProviders.of(this).get(EditPhoneNumberViewModel.class);
        setCodePrefix();
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
                }
            }
        });
    }

    private void setEditPhoneNumber() {
        editPhoneNumberViewModel.getEditPhoneNumberBean(stringValue, profileBean).observe(this, new Observer<EditPhoneNumberBean>() {
            @Override
            public void onChanged(EditPhoneNumberBean editPhoneNumberBean) {
                editPhoneNumberBinding.setEditPhoneNumberBean(editPhoneNumberBean);
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
}
