package com.example.carescheduling.Ui.Profile.View;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.Common.Common;
import com.example.carescheduling.Ui.Common.CommonBean;
import com.example.carescheduling.Ui.Dashboard.beans.ProfileBean;
import com.example.carescheduling.Ui.Dashboard.beans.ProfileResultBean;
import com.example.carescheduling.Ui.Dashboard.view.Dashboard;
import com.example.carescheduling.Ui.Profile.ViewModel.EditProfileAddressViewModel;
import com.example.carescheduling.Ui.Profile.bean.EditAddressAllData;
import com.example.carescheduling.Ui.Profile.bean.EditProfileAddressBean;
import com.example.carescheduling.Ui.Profile.bean.EditProfileInfoBean;
import com.example.carescheduling.Ui.Profile.bean.PersonAddressList;
import com.example.carescheduling.Ui.Profile.bean.PersonEmailList;
import com.example.carescheduling.Ui.Profile.bean.PersonPhoneList;
import com.example.carescheduling.Ui.Profile.presenter.EditProfileAddressClick;
import com.example.carescheduling.Utils.ConnectivityReceiver;
import com.example.carescheduling.Utils.Constants;
import com.example.carescheduling.databinding.FragmentEditProfileAddressBinding;

import java.io.Serializable;
import java.util.ArrayList;

public class EditProfileAddress extends BaseFragment implements Common, EditProfileAddressClick {

    private FragmentEditProfileAddressBinding editProfileAddressBinding;
    private EditAddressAllData.Data profileResultBean;
    private EditProfileAddressViewModel editProfileAddressViewModel;

    public static EditProfileAddress newInstance() {
        return new EditProfileAddress();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        editProfileAddressBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_profile_address, container, false);
        View view = editProfileAddressBinding.getRoot();
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {
        setCommonData();
        editProfileAddressViewModel = ViewModelProviders.of(this).get(EditProfileAddressViewModel.class);
        setProfileInfoBeanData();
        editProfileAddressBinding.setEditAddressClick(this);
    }

    private void setCommonData() {
        CommonBean commonBean = new CommonBean();
        commonBean.setLeftImageDrawable(R.drawable.ic_left_back);
        commonBean.setLeftImageVisible(true);
        commonBean.setRightImageDrawable(R.drawable.ic_tick);
        commonBean.setRightImageVisible(false);
        commonBean.setRightTextVisible(false);
        commonBean.setTitle("Change Address");
        editProfileAddressBinding.setCommonData(commonBean);
        editProfileAddressBinding.setCommonClick(this);
    }


    private void setProfileInfoBeanData() {
        if (getActivity() != null) {
            if (ConnectivityReceiver.isNetworkAvailable(getActivity())) {
                showDialog();
                try {
                    editProfileAddressViewModel.GetMyAddressEdit(getSessionManager().getPersonId(), getSessionManager().getCustomerId(), getSessionManager().getBranchId())
                            .observe(this, new Observer<EditAddressAllData.Data>() {
                                @Override
                                public void onChanged(EditAddressAllData.Data editProfileInfoBean) {
                                    hideDialog();
                                    profileResultBean = editProfileInfoBean;
                                    if (profileResultBean != null && getView() != null) {
                                        editProfileAddressBinding.setPersonAddressList(profileResultBean.getPersonAddressList().size());
                                        editProfileAddressBinding.setPersonEmailList(profileResultBean.getPersonEmailList().size());
                                        editProfileAddressBinding.setPersonPhoneList(profileResultBean.getPersonPhoneList().size());
                                        addRadioButtonsAddress(getView(), profileResultBean.getPersonAddressList(), R.id.rb_address);
                                        addRadioButtonsPhone(getView(), profileResultBean.getPersonPhoneList(), R.id.rb_phone);
                                        addRadioButtonsEmail(getView(), profileResultBean.getPersonEmailList(), R.id.rb_email);
                                    } else {
                                        editProfileAddressBinding.setPersonAddressList(0);
                                        editProfileAddressBinding.setPersonEmailList(0);
                                        editProfileAddressBinding.setPersonPhoneList(0);
                                    }


                                }
                            });

                } catch (Exception e) {
                    hideDialog();
                    Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();

                }
            } else {
                Toast.makeText(getActivity(), "please check your internet connection", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void addRadioButtonsAddress(View view, ArrayList<PersonAddressList> arrayList, int id) {
        RadioGroup ll = view.findViewById(id);
        ll.removeAllViews();
        ll.setOrientation(LinearLayout.VERTICAL);

        for (int i = 0; i < arrayList.size(); i++) {
            RadioButton rdbtn = new RadioButton(getActivity());
            rdbtn.setId(View.generateViewId());
            rdbtn.setText(arrayList.get(i).getAddressTypeName());
            ll.addView(rdbtn);
        }
//        ((ViewGroup) view.findViewById(id)).addView(ll);

    }


    private void addRadioButtonsPhone(View view, ArrayList<PersonPhoneList> arrayList, int id) {
        RadioGroup ll = view.findViewById(id);
        ll.removeAllViews();
        ll.setOrientation(LinearLayout.VERTICAL);

        for (int i = 0; i < arrayList.size(); i++) {
            RadioButton rdbtn = new RadioButton(getActivity());
            rdbtn.setId(View.generateViewId());
            rdbtn.setText(arrayList.get(i).getPhoneTypeName());
            ll.addView(rdbtn);
        }
//        ((ViewGroup) view.findViewById(id)).addView(ll);

    }

    private void addRadioButtonsEmail(View view, ArrayList<PersonEmailList> arrayList, int id) {
        RadioGroup ll = view.findViewById(id);
        ll.removeAllViews();
        ll.setOrientation(LinearLayout.VERTICAL);

        for (int i = 0; i < arrayList.size(); i++) {
            RadioButton rdbtn = new RadioButton(getActivity());
            rdbtn.setId(View.generateViewId());
            rdbtn.setText(arrayList.get(i).getEmailTypeName());
            ll.addView(rdbtn);
        }
//        ((ViewGroup) view.findViewById(id)).addView(ll);

    }


    @Override
    public void EditAddressClick() {
//        setFragment(AddAddress.newInstance("", "Edit", profileResultBean));
    }

    @Override
    public void EditPhoneNumberClick() {
//        setFragment(AddPhoneNumber.newInstance("", "Edit", profileResultBean));
    }

    @Override
    public void EditEmailClick() {
//        setFragment(AddEmail.newInstance("", "Edit", profileResultBean));
    }

    @Override
    public void UpdateAddressClick() {
//        String address = getRadioGroupText(editProfileAddressBinding.rbAddress);
//        if (!address.isEmpty())
//            setFragment(ProfileAddress.newInstance(address, "Update", profileResultBean));
//        else
//            Toast.makeText(getActivity(), "Please select above address type", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void UpdatePhoneNumberClick() {
//        String address = getRadioGroupText(editProfileAddressBinding.rbAddress);
//        if (!address.isEmpty())
//            setFragment(EditPhoneNumber.newInstance(address, "Update", profileResultBean));
//        else
//            Toast.makeText(getActivity(), "Please select above address type", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void UpdateEmailClick() {
//        String address = getRadioGroupText(editProfileAddressBinding.rbAddress);
//        if (!address.isEmpty())
//            setFragment(EditEmail.newInstance(address, "Update", profileResultBean));
//        else
//            Toast.makeText(getActivity(), "Please select above address type", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void DeleteAddressClick() {
        if (getActivity() != null) {
            try {
                if (ConnectivityReceiver.isNetworkAvailable(getActivity())) {
                    String address = getRadioGroupText(editProfileAddressBinding.rbAddress);
                    if (!address.isEmpty())
                        removeAddress(address);
                    else
                        showAToast("Please select above address type");
                } else {
                    Toast.makeText(getActivity(), "please check your internet connection", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                hideDialog();
                Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void removeAddress(String address) {
        if (profileResultBean.getPersonAddressList() != null && profileResultBean.getPersonAddressList().size() > 0) {
            for (int i = 0; i < profileResultBean.getPersonAddressList().size(); i++) {
                if (profileResultBean.getPersonAddressList().get(i).getAddressTypeName().equalsIgnoreCase(address)) {
                    showDialog();
                    editProfileAddressViewModel.DeleteAddress(profileResultBean.getPersonAddressList().get(i)).observe(this, new Observer<Boolean>() {
                        @Override
                        public void onChanged(Boolean aBoolean) {
                            hideDialog();
                            if (aBoolean != null) {
                                if (aBoolean) {
                                    // on back press
                                    setProfileInfoBeanData();
//                                    if (getActivity() != null)
//                                        getActivity().onBackPressed();
                                }
                            }
                        }
                    });

                }
            }
        }
    }

    @Override
    public void DeletePhoneNumberClick() {

        if (getActivity() != null) {
            try {
                if (ConnectivityReceiver.isNetworkAvailable(getActivity())) {
                    String phoneNumber = getRadioGroupText(editProfileAddressBinding.rbPhone);
                    if (!phoneNumber.isEmpty())
                        removePhoneNumber(phoneNumber);
                    else
                        showAToast("Please select above phone type");
                } else {
                    Toast.makeText(getActivity(), "please check your internet connection", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                hideDialog();
                Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void removePhoneNumber(String phoneNumber) {
        if (profileResultBean.getPersonPhoneList() != null && profileResultBean.getPersonPhoneList().size() > 0) {
            for (int i = 0; i < profileResultBean.getPersonPhoneList().size(); i++) {
                if (profileResultBean.getPersonPhoneList().get(i).getPhoneTypeName().equalsIgnoreCase(phoneNumber)) {
                    showDialog();
                    editProfileAddressViewModel.DeletePhone(profileResultBean.getPersonPhoneList().get(i)).observe(this, new Observer<Boolean>() {
                        @Override
                        public void onChanged(Boolean aBoolean) {
                            hideDialog();
                            if (aBoolean != null) {
                                if (aBoolean) {
                                    // on back press
                                    setProfileInfoBeanData();
//                                    if (getActivity() != null)
//                                        getActivity().onBackPressed();
                                }
                            }
                        }
                    });

                }
            }
        }
    }

    @Override
    public void DeleteEmailClick() {
        if (getActivity() != null) {
            try {
                if (ConnectivityReceiver.isNetworkAvailable(getActivity())) {
                    String email = getRadioGroupText(editProfileAddressBinding.rbEmail);
                    if (!email.isEmpty())
                        removeEmail(email);
                    else
                        showAToast("Please select above email type");
                } else {
                    Toast.makeText(getActivity(), "please check your internet connection", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                hideDialog();
                Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
            }
        }

    }

    private void removeEmail(String email) {
        if (profileResultBean.getPersonEmailList() != null && profileResultBean.getPersonEmailList().size() > 0) {
            for (int i = 0; i < profileResultBean.getPersonEmailList().size(); i++) {
                if (profileResultBean.getPersonEmailList().get(i).getEmailTypeName().equalsIgnoreCase(email)) {
                    showDialog();
                    editProfileAddressViewModel.DeleteEmail(profileResultBean.getPersonEmailList().get(i)).observe(this, new Observer<Boolean>() {
                        @Override
                        public void onChanged(Boolean aBoolean) {
                            hideDialog();
                            if (aBoolean != null) {
                                if (aBoolean) {
                                    // on back press
                                    setProfileInfoBeanData();
//                                    if (getActivity() != null)
//                                        getActivity().onBackPressed();
                                }
                            }
                        }
                    });

                }
            }
        }
    }


    private void sendRemoteData(ProfileBean profileBean) {
        showDialog();
        editProfileAddressViewModel.getEditProfilePost(profileBean.getData()).observe(this, new Observer<ProfileBean>() {
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


    private void setFragment(Fragment fragment) {
        if (getActivity() != null)
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fm_edit_container, fragment).addToBackStack(null).commitAllowingStateLoss();
    }


    private String getRadioGroupText(RadioGroup radioGroup) {
        int radioButtonID = radioGroup.getCheckedRadioButtonId();
        View radioButton = radioGroup.findViewById(radioButtonID);
        int idx = radioGroup.indexOfChild(radioButton);
        RadioButton r = (RadioButton) radioGroup.getChildAt(idx);
        String txt = "";
        if (r != null)
            txt = r.getText().toString();

        return txt;
    }

    @Override
    public void leftClick() {
        if (getActivity() != null)
            getActivity().onBackPressed();
    }

    @Override
    public void rightClick() {

    }

    private void openDashboardActivity() {
        Intent intent = new Intent(getActivity(), Dashboard.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        if (getActivity() != null)
            getActivity().finish();
    }
}
