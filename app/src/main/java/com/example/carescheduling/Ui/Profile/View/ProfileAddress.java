package com.example.carescheduling.Ui.Profile.View;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.Common.Common;
import com.example.carescheduling.Ui.Common.CommonBean;
import com.example.carescheduling.Ui.Dashboard.beans.Address;
import com.example.carescheduling.Ui.Dashboard.beans.CountryPostCode;
import com.example.carescheduling.Ui.Dashboard.beans.PersonAddress;
import com.example.carescheduling.Ui.Dashboard.beans.PersonAddress_;
import com.example.carescheduling.Ui.Dashboard.beans.ProfileBean;
import com.example.carescheduling.Ui.Dashboard.view.Dashboard;
import com.example.carescheduling.Ui.Profile.Adapter.CustomAdapter;
import com.example.carescheduling.Ui.Profile.ViewModel.ProfileAddressViewModel;
import com.example.carescheduling.Ui.Profile.bean.AddressByPostCode;
import com.example.carescheduling.Ui.Profile.bean.AddressData;
import com.example.carescheduling.Ui.Profile.bean.EditAdressBeanRetro;
import com.example.carescheduling.Ui.Profile.bean.PersonAddressList;
import com.example.carescheduling.Ui.Profile.bean.ProfileAddressBean;
import com.example.carescheduling.Ui.Profile.bean.UserViewModel;
import com.example.carescheduling.Ui.Profile.presenter.EditEmailClick;
import com.example.carescheduling.Ui.Profile.presenter.ProfileAddressClick;
import com.example.carescheduling.Utils.ConnectivityReceiver;
import com.example.carescheduling.Utils.Constants;
import com.example.carescheduling.data.Local.DatabaseTable.AddressType;
import com.example.carescheduling.data.Local.DatabaseTable.Nationality;
import com.example.carescheduling.databinding.ProfileAddressBinding;

import java.util.ArrayList;
import java.util.List;
//import com.example.carescheduling.databinding.FragmentProfileBinding;

public class ProfileAddress extends BaseFragment implements Common, ProfileAddressClick {
    private ProfileAddressBinding profileAddressBinding;
    private ProfileAddressViewModel profileAddressViewModel;
    private String stringValue;
    private PersonAddressList profileBean;
    private List<AddressData> addressTypesList = new ArrayList<>();

    // TODO: Rename and change types and number of parameters
    public static ProfileAddress newInstance(String value, PersonAddressList profileBean) {
        ProfileAddress profileAddress = new ProfileAddress();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.STRING_VALUE, value);
        bundle.putSerializable(Constants.PROFILE_DATA, profileBean);
        profileAddress.setArguments(bundle);
        return profileAddress;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            stringValue = getArguments().getString(Constants.STRING_VALUE);
            profileBean = (PersonAddressList) getArguments().getSerializable(Constants.PROFILE_DATA);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        profileAddressBinding = DataBindingUtil.inflate(inflater, R.layout.profile_address
                , container, false);
        View view = profileAddressBinding.getRoot();
        setUpView(view);
        return view;

    }

    private void setUpView(View view) {
        setCommonData();
        profileAddressViewModel = ViewModelProviders.of(this).get(ProfileAddressViewModel.class);
        sessionManager = getSessionManager();

        profileAddressBinding.spinnerAddressType.setEnabled(false);
        profileAddressBinding.spinnerAddressType.setClickable(false);

//        setProfileAddressData();
        fetchAddressFromPostalCode();
        setAddressTypeData();
        setNationalityData();

        profileAddressBinding.setProfileAddressClick(this);
    }

    private void setCommonData() {
        CommonBean commonBean = new CommonBean();
        commonBean.setLeftImageDrawable(R.drawable.ic_left_back);
        commonBean.setLeftImageVisible(true);
        commonBean.setRightImageDrawable(R.drawable.ic_tick);
        commonBean.setRightImageVisible(false);
        commonBean.setTitle("Address");
        commonBean.setRightTextVisible(true);
        profileAddressBinding.setCommonData(commonBean);
        profileAddressBinding.setCommonClick(this);
    }

    private void setAddressTypeData() {
        profileAddressViewModel.getAddressType().observe(this, new Observer<List<AddressType>>() {
            @Override
            public void onChanged(List<AddressType> addressTypes) {
                ArrayList<String> arrayList = new ArrayList<>();
                if (addressTypes != null && addressTypes.size() > 0) {
                    for (int i = 0; i < addressTypes.size(); i++) {
                        if (i == 0)
                            arrayList.add("Select Address Type");
                        arrayList.add(addressTypes.get(i).getAddressName());
                    }
                    CustomAdapter adapter = new CustomAdapter(getActivity(),
                            R.layout.item_spinner_sf, R.id.title, arrayList);
                    profileAddressBinding.spinnerAddressType.setAdapter(adapter);

                    if (stringValue != null) {
                        int pos = adapter.getPosition(stringValue);
                        profileAddressBinding.spinnerAddressType.setSelection(pos);
                    }
                }
            }
        });
    }

    private void setNationalityData() {
        profileAddressViewModel.getNationality().observe(this, new Observer<List<Nationality>>() {
            @Override
            public void onChanged(List<Nationality> nationalities) {
                ArrayList<String> arrayList = new ArrayList<>();

                if (nationalities != null && nationalities.size() > 0) {
                    for (int i = 0; i < nationalities.size(); i++) {
                        if (i == 0)
                            arrayList.add("Select Nationality");
                        arrayList.add(nationalities.get(i).getNationalityName());
                    }
                    CustomAdapter adapter = new CustomAdapter(getActivity(),
                            R.layout.item_spinner_sf, R.id.title, arrayList);
                    profileAddressBinding.spinnerNationality.setAdapter(adapter);


                    if (profileBean != null ) {
                            for (int i = 0; i < arrayList.size(); i++) {
                                if (arrayList.get(i).equalsIgnoreCase(profileBean.getCountryCode())) {
                                    String str = profileBean.getCountryCode();
                                    String cap = str.substring(0, 1).toUpperCase() + str.substring(1);
                                    int pos = adapter.getPosition(cap);
                                    profileAddressBinding.spinnerNationality.setSelection(pos);
                                }
                            }
                    }

                }
            }
        });
    }

    private void setProfileAddressData() {
//        profileAddressViewModel.getProfileAddressBean(stringValue, profileBean).observe(this, new Observer<ProfileAddressBean>() {
//            @Override
//            public void onChanged(ProfileAddressBean profileAddressBean) {
//                profileAddressBinding.setProfileAddressBean(profileAddressBean);
//            }
//        });
    }


    @Override
    public void fetchAddressFromPostalCode() {
        showDialog();
        String nationality, postCode;
        if (profileAddressBinding.spinnerAddressType.getSelectedItemPosition() <= 0) {
//            showAToast("please select nationality");
//            return;
            nationality = "England";
        } else {
            nationality = (String) profileAddressBinding.spinnerAddressType.getSelectedItem();
        }
        if (TextUtils.isEmpty(profileAddressBinding.edtPostCode.getText().toString())) {
            postCode = profileBean.getPostCode();
        } else {
            postCode = profileAddressBinding.edtPostCode.getText().toString();
        }
        profileAddressViewModel.getAddressByPostCode(stringValue, nationality, postCode).observe(this, new Observer<AddressByPostCode>() {
            @Override
            public void onChanged(AddressByPostCode addressByPostCode) {
                hideDialog();

                profileAddressViewModel.FetchAddressSpinnerData(addressByPostCode).observe(ProfileAddress.this, new Observer<ArrayList<AddressData>>() {
                    @Override
                    public void onChanged(ArrayList<AddressData> addressData) {
                        addressTypesList = addressData;
                        ArrayList<String> arrayList1 = new ArrayList<>();
                        for (int i = 0; i < addressData.size(); i++) {
                            arrayList1.add(addressData.get(i).getAddressType());
                        }
                        CustomAdapter adapter = new CustomAdapter(getActivity(),
                                R.layout.item_spinner_sf, R.id.title, arrayList1);
                        profileAddressBinding.spinnerAddress.setAdapter(adapter);

                    }
                });

                profileAddressViewModel.FetchAddressSpinnerContent(addressByPostCode).observe(ProfileAddress.this, new Observer<ArrayList<ProfileAddressBean>>() {
                    @Override
                    public void onChanged(final ArrayList<ProfileAddressBean> profileAddressBeans) {
                        profileAddressBinding.spinnerAddress.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                                // your code here
                                profileAddressBinding.setProfileAddressBean(profileAddressBeans.get(position));
                                if (profileAddressBeans.get(position).getCountry() != null) {
                                    CustomAdapter customAdapter = (CustomAdapter) profileAddressBinding.spinnerNationality.getAdapter();
                                    String str = profileAddressBeans.get(position).getCountry();
                                    String cap = str.substring(0, 1).toUpperCase() + str.substring(1);
                                    int pos = customAdapter.getPosition(cap);
                                    profileAddressBinding.spinnerNationality.setSelection(pos);
                                }

                                profileAddressBinding.llMain.setVisibility(View.VISIBLE);
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parentView) {
                                // your code here
                            }

                        });

                    }
                });

            }
        });
    }


    private void setDataRemote() {
        if (getActivity() != null && ConnectivityReceiver.isNetworkAvailable(getActivity())) {
            if (validation()) {
                showDialog();
                profileAddressViewModel.EditAddress(getAddAddressBean()).observe(this, new Observer<Boolean>() {
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
            }
        } else {
            Toast.makeText(getActivity(), "please check your internet connection", Toast.LENGTH_SHORT).show();
        }

    }


    private EditAdressBeanRetro getAddAddressBean() {
        EditAdressBeanRetro editAdressBeanRetro = new EditAdressBeanRetro();
        editAdressBeanRetro.setAddressTypeName((String) profileAddressBinding.spinnerAddressType.getSelectedItem());
        editAdressBeanRetro.setAddressId(String.valueOf(addressTypesList.get(profileAddressBinding.spinnerAddress.getSelectedItemPosition()).getAddressId()));
        editAdressBeanRetro.setCustomerId(getSessionManager().getCustomerId());
        editAdressBeanRetro.setPersonId(getSessionManager().getPersonId());
        editAdressBeanRetro.setDefaultAddress(profileAddressBinding.rbIsDefault.isChecked());
        editAdressBeanRetro.setOldAddressId(String.valueOf(profileBean.getPersonAddress().getAddressId()));
        editAdressBeanRetro.setOldAddressTypeName(profileBean.getPersonAddress().getAddressTypeName());
        return editAdressBeanRetro;
    }


    private boolean validation() {
        if (profileAddressBinding.spinnerAddressType.getSelectedItemPosition() <= 0) {
            showAToast("please select address type");
            return false;
        } /*else if (profileAddressBinding.spinnerAddress.getSelectedItemPosition() <= 0) {
            showAToast("please select address ");
            return false;
        }*/
        return true;
    }


    @Override
    public void leftClick() {
        if (getActivity() != null)
            getActivity().onBackPressed();
    }

    @Override
    public void rightClick() {
        try {
            setDataRemote();
        } catch (Exception e) {
            hideDialog();
            Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
