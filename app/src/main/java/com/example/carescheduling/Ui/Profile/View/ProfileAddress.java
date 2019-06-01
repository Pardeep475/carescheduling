package com.example.carescheduling.Ui.Profile.View;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.Dashboard.beans.Address;
import com.example.carescheduling.Ui.Dashboard.beans.CountryPostCode;
import com.example.carescheduling.Ui.Dashboard.beans.PersonAddress;
import com.example.carescheduling.Ui.Dashboard.beans.PersonAddress_;
import com.example.carescheduling.Ui.Dashboard.beans.ProfileBean;
import com.example.carescheduling.Ui.Profile.Adapter.CustomAdapter;
import com.example.carescheduling.Ui.Profile.ViewModel.ProfileAddressViewModel;
import com.example.carescheduling.Ui.Profile.bean.AddressByPostCode;
import com.example.carescheduling.Ui.Profile.bean.AddressData;
import com.example.carescheduling.Ui.Profile.bean.ProfileAddressBean;
import com.example.carescheduling.Ui.Profile.bean.UserViewModel;
import com.example.carescheduling.Ui.Profile.presenter.EditEmailClick;
import com.example.carescheduling.Ui.Profile.presenter.ProfileAddressClick;
import com.example.carescheduling.Utils.Constants;
import com.example.carescheduling.data.Local.DatabaseTable.AddressType;
import com.example.carescheduling.data.Local.DatabaseTable.Nationality;
import com.example.carescheduling.databinding.ProfileAddressBinding;

import java.util.ArrayList;
import java.util.List;
//import com.example.carescheduling.databinding.FragmentProfileBinding;

public class ProfileAddress extends BaseFragment implements EditEmailClick, ProfileAddressClick {
    private ProfileAddressBinding profileAddressBinding;
    private ProfileAddressViewModel profileAddressViewModel;
    private String stringValue;
    private ProfileBean profileBean;
    private List<AddressData> addressTypesList = new ArrayList<>();

    // TODO: Rename and change types and number of parameters
    public static ProfileAddress newInstance(String value, ProfileBean profileBean) {
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
            profileBean = (ProfileBean) getArguments().getSerializable(Constants.PROFILE_DATA);
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
        profileAddressViewModel = ViewModelProviders.of(this).get(ProfileAddressViewModel.class);
        sessionManager = getSessionManager();
        setProfileAddressData();
        setAddressTypeData();
        setNationalityData();
        profileAddressBinding.setEditEmailClick(this);
        profileAddressBinding.setProfileAddressClick(this);
    }


    private void setAddressTypeData() {
        profileAddressViewModel.getAddressType().observe(this, new Observer<List<AddressType>>() {
            @Override
            public void onChanged(List<AddressType> addressTypes) {
                ArrayList<String> arrayList = new ArrayList<>();
                if (addressTypes != null && addressTypes.size() > 0) {
                    for (int i = 0; i < addressTypes.size(); i++) {
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
                        arrayList.add(nationalities.get(i).getNationalityName());
                    }
                    CustomAdapter adapter = new CustomAdapter(getActivity(),
                            R.layout.item_spinner_sf, R.id.title, arrayList);
                    profileAddressBinding.spinnerNationality.setAdapter(adapter);


                    if (profileBean != null && profileBean.getData() != null && profileBean.getData().getPerson() != null) {
                        if (profileBean.getData().getPersonAddresses().size() > 0) {
                            for (int i = 0; i < profileBean.getData().getPersonAddresses().size(); i++) {
                                if (profileBean.getData().getPersonAddresses().get(i).getAddressTypeName().equalsIgnoreCase(stringValue)) {
                                    String str = profileBean.getData().getPersonAddresses().get(0).getAddress().getCountryName();
                                    String cap = str.substring(0, 1).toUpperCase() + str.substring(1);
                                    int pos = adapter.getPosition(cap);
                                    profileAddressBinding.spinnerNationality.setSelection(pos);
                                }
                            }

                        }
                    }

                }
            }
        });
    }

    private void setProfileAddressData() {
        profileAddressViewModel.getProfileAddressBean(stringValue, profileBean).observe(this, new Observer<ProfileAddressBean>() {
            @Override
            public void onChanged(ProfileAddressBean profileAddressBean) {
                profileAddressBinding.setProfileAddressBean(profileAddressBean);
            }
        });
    }

    @Override
    public void BackButtonClick() {
        if (getActivity() != null)
            getActivity().onBackPressed();
    }

    @Override
    public void fetchAddressFromPostalCode() {
        showDialog();

        profileAddressViewModel.getAddressByPostCode(stringValue, profileBean, profileAddressBinding.edtPostCode.getText().toString()).observe(this, new Observer<AddressByPostCode>() {
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

    @Override
    public void DoneClick() {

        try {
            setDataRemote();
        } catch (Exception e) {
            hideDialog();
            Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
        }

    }


    private void setDataRemote() {
        showDialog();
        setAddressData();

    }

    private void setAddressData() {

        if (profileBean.getData() != null && profileBean.getData().getPerson() != null && profileBean.getData().getPerson().getPersonAddress() != null && stringValue != null) {
            profileBean = updateAddress();
        } else {
            profileBean = addNewAddress();
        }

        profileAddressViewModel.getEditProfilePost(profileBean.getData()).observe(this, new Observer<ProfileBean>() {
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

    private ProfileBean updateAddress() {
        int addressCounter = 0;

            for (int i = 0; i < profileBean.getData().getPerson().getPersonAddress().size(); i++) {
                if (profileBean.getData().getPerson().getPersonAddress().get(i).getAddressTypeName().equalsIgnoreCase((String) profileAddressBinding.spinnerAddressType.getSelectedItem())) {
                    profileBean.getData().getPerson().getPersonAddress().get(i).setAddressTypeName((String) profileAddressBinding.spinnerAddressType.getSelectedItem());
                    profileBean.getData().getPerson().getPersonAddress().get(i).setIsDefaultAddress(true);
                    profileBean.getData().getPerson().getPersonAddress().get(i).setPersonId(getSessionManager().getPersonId());
                    profileBean.getData().getPerson().getPersonAddress().get(i).setCustomerId(getSessionManager().getCustomerId());
                    if (addressTypesList.size()>0)
                    profileBean.getData().getPerson().getPersonAddress().get(i).setAddressId(addressTypesList.get(profileAddressBinding.spinnerAddress.getSelectedItemPosition()).getAddressId());
                    else
                        profileBean.getData().getPerson().getPersonAddress().get(i).setAddressId(profileBean.getData().getPerson().getPersonAddress().get(i).getAddressId());
                    addressCounter++;
                    break;
                }
            }


        if (addressCounter == 0) {
            profileBean = addNewAddress();
        }

        return profileBean;
    }

    private ProfileBean addNewAddress() {
        if (profileBean.getData().getPerson().getPersonAddress().size() > 0) {
            PersonAddress personAddress = new PersonAddress();
            personAddress.setAddressTypeName((String) profileAddressBinding.spinnerAddressType.getSelectedItem());
            personAddress.setIsDefaultAddress(true);
            personAddress.setPersonId(getSessionManager().getPersonId());
            personAddress.setCustomerId(getSessionManager().getCustomerId());
            personAddress.setAddressId(addressTypesList.get(profileAddressBinding.spinnerAddress.getSelectedItemPosition()).getAddressId());
            profileBean.getData().getPerson().getPersonAddress().add(personAddress);
        }
        return profileBean;
    }
}
