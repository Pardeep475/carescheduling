package com.example.carescheduling.Ui.Profile.View;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.Common.Common;
import com.example.carescheduling.Ui.Common.CommonBean;
import com.example.carescheduling.Ui.Dashboard.beans.PersonAddress;
import com.example.carescheduling.Ui.Dashboard.beans.ProfileBean;
import com.example.carescheduling.Ui.Dashboard.view.Dashboard;
import com.example.carescheduling.Ui.Profile.Adapter.CustomAdapter;
import com.example.carescheduling.Ui.Profile.ViewModel.AddAddressViewModel;
import com.example.carescheduling.Ui.Profile.bean.AddressByPostCode;
import com.example.carescheduling.Ui.Profile.bean.AddressData;
import com.example.carescheduling.Ui.Profile.bean.ProfileAddressBean;
import com.example.carescheduling.Ui.Profile.presenter.ProfileAddressClick;
import com.example.carescheduling.Utils.Constants;
import com.example.carescheduling.data.Local.DatabaseTable.AddressType;
import com.example.carescheduling.data.Local.DatabaseTable.Nationality;
import com.example.carescheduling.databinding.AddAddressFragmentBinding;

import java.util.ArrayList;
import java.util.List;

public class AddAddress extends BaseFragment implements Common, ProfileAddressClick {
    private AddAddressFragmentBinding profileAddressBinding;
    private AddAddressViewModel profileAddressViewModel;
    private String stringValue, type;
    private ProfileBean profileBean;
    private List<AddressData> addressTypesList = new ArrayList<>();

    // TODO: Rename and change types and number of parameters
    public static AddAddress newInstance(String value, String type, ProfileBean profileBean) {
        AddAddress profileAddress = new AddAddress();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.STRING_VALUE, value);
        bundle.putString(Constants.TYPE, type);
        bundle.putSerializable(Constants.PROFILE_DATA, profileBean);
        profileAddress.setArguments(bundle);
        return profileAddress;
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
        profileAddressBinding = DataBindingUtil.inflate(inflater, R.layout.add_address_fragment
                , container, false);
        View view = profileAddressBinding.getRoot();
        setUpView(view);
        return view;

    }

    private void setUpView(View view) {
        setCommonData();
        profileAddressViewModel = ViewModelProviders.of(this).get(AddAddressViewModel.class);
        sessionManager = getSessionManager();
        if (type.equalsIgnoreCase("Update")) {
            profileAddressBinding.spinnerAddressType.setEnabled(false);
            profileAddressBinding.spinnerAddressType.setClickable(false);
        } else {
            profileAddressBinding.spinnerAddressType.setEnabled(true);
            profileAddressBinding.spinnerAddressType.setClickable(true);
        }
        setAddressTypeData();
        setNationalityData();
//        setProfileAddressData();

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
    public void fetchAddressFromPostalCode() {
        showDialog();
        if (profileAddressBinding.spinnerNationality.getSelectedItemPosition() <= 0){
            hideDialog();
            return;
        }

        profileAddressViewModel.getAddressByPostCode(profileAddressBinding.spinnerNationality.getSelectedItem().toString(), profileBean, profileAddressBinding.edtPostCode.getText().toString()).observe(this, new Observer<AddressByPostCode>() {
            @Override
            public void onChanged(AddressByPostCode addressByPostCode) {
                hideDialog();

                profileAddressViewModel.FetchAddressSpinnerData(addressByPostCode).observe(AddAddress.this, new Observer<ArrayList<AddressData>>() {
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


                        profileAddressBinding.llMain.setVisibility(View.VISIBLE);

                    }
                });

                profileAddressViewModel.FetchAddressSpinnerContent(addressByPostCode).observe(AddAddress.this, new Observer<ArrayList<ProfileAddressBean>>() {
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


    private void setDataRemote() {
        showDialog();
        setAddressData();

    }

    private void setAddressData() {
        profileBean = addNewAddress();
        if (profileBean == null) {
            hideDialog();
            return;
        }
        profileAddressViewModel.getEditProfilePost(profileBean.getData()).observe(this, new Observer<ProfileBean>() {
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

    private ProfileBean updateAddress() {
        int addressCounter = 0;

        for (int i = 0; i < profileBean.getData().getPerson().getPersonAddress().size(); i++) {
            if (profileBean.getData().getPerson().getPersonAddress().get(i).getAddressTypeName().equalsIgnoreCase((String) profileAddressBinding.spinnerAddressType.getSelectedItem())) {
                if ((profileAddressBinding.spinnerAddressType.getSelectedItemPosition() - 1) >= 0)
                    profileBean.getData().getPerson().getPersonAddress().get(i).setAddressTypeName((String) profileAddressBinding.spinnerAddressType.getSelectedItem());
                else {
                    Toast.makeText(getActivity(), "please select address type", Toast.LENGTH_SHORT).show();
                    return null;
                }
                profileBean.getData().getPerson().getPersonAddress().get(i).setIsDefaultAddress(true);
                profileBean.getData().getPerson().getPersonAddress().get(i).setPersonId(getSessionManager().getPersonId());
                profileBean.getData().getPerson().getPersonAddress().get(i).setCustomerId(getSessionManager().getCustomerId());
                if (addressTypesList.size() > 0)
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
            if ((profileAddressBinding.spinnerAddressType.getSelectedItemPosition() - 1) >= 0)
                personAddress.setAddressTypeName((String) profileAddressBinding.spinnerAddressType.getSelectedItem());
            else {
                Toast.makeText(getActivity(), "please select address type", Toast.LENGTH_SHORT).show();
                return null;
            }
            personAddress.setIsDefaultAddress(profileAddressBinding.rbIsDefault.isChecked());
            personAddress.setPersonId(getSessionManager().getPersonId());
            personAddress.setCustomerId(getSessionManager().getCustomerId());
            personAddress.setAddressId(addressTypesList.get(profileAddressBinding.spinnerAddress.getSelectedItemPosition()).getAddressId());
            profileBean.getData().getPerson().getPersonAddress().add(personAddress);
        }
        return profileBean;
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
