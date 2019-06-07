package com.example.carescheduling.Ui.Profile.View;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

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
import com.example.carescheduling.Ui.Profile.ViewModel.EditProfileAddressViewModel;
import com.example.carescheduling.Ui.Profile.bean.EditProfileAddressBean;
import com.example.carescheduling.Ui.Profile.presenter.EditProfileAddressClick;
import com.example.carescheduling.Utils.Constants;
import com.example.carescheduling.databinding.FragmentEditProfileAddressBinding;

import java.io.Serializable;
import java.util.ArrayList;

public class EditProfileAddress extends BaseFragment implements Common, EditProfileAddressClick {

    private FragmentEditProfileAddressBinding editProfileAddressBinding;
    private ProfileBean profileResultBean;
    private EditProfileAddressViewModel editProfileAddressViewModel;

    public static EditProfileAddress newInstance(ProfileBean profileResultBean) {
        EditProfileAddress editProfileAddress = new EditProfileAddress();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constants.PROFILE_DATA, (Serializable) profileResultBean);
        editProfileAddress.setArguments(bundle);
        return editProfileAddress;
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
        editProfileAddressBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_profile_address, container, false);
        View view = editProfileAddressBinding.getRoot();
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {
        setCommonData();
        editProfileAddressViewModel = ViewModelProviders.of(this).get(EditProfileAddressViewModel.class);
        setEditProfileData(view);
        editProfileAddressBinding.setEditAddressClick(this);
    }

    private void setCommonData() {
        CommonBean commonBean = new CommonBean();
        commonBean.setLeftImageDrawable(R.drawable.ic_left_back);
        commonBean.setLeftImageVisible(true);
        commonBean.setRightImageDrawable(R.drawable.ic_tick);
        commonBean.setRightImageVisible(false);
        commonBean.setTitle("Change Address");
        editProfileAddressBinding.setCommonData(commonBean);
        editProfileAddressBinding.setCommonClick(this);
    }

    private void setEditProfileData(final View view) {
        editProfileAddressViewModel.getEditProfileAddressBean(profileResultBean).observe(this, new Observer<EditProfileAddressBean>() {
            @Override
            public void onChanged(EditProfileAddressBean editProfileAddressBean) {
                editProfileAddressBinding.setEditProfileAddressBean(editProfileAddressBean);
                addRadioButtons(view, editProfileAddressBean.getAddressArray(), R.id.rb_address);
                addRadioButtons(view, editProfileAddressBean.getPhoneArray(), R.id.rb_phone);
                addRadioButtons(view, editProfileAddressBean.getEmailArray(), R.id.rb_email);
            }
        });
    }

    public void addRadioButtons(View view, ArrayList<String> arrayList, int id) {
        RadioGroup ll = view.findViewById(id);
        ll.setOrientation(LinearLayout.VERTICAL);

        for (int i = 0; i < arrayList.size(); i++) {
            RadioButton rdbtn = new RadioButton(getActivity());
            rdbtn.setId(View.generateViewId());
            rdbtn.setText(arrayList.get(i));
            ll.addView(rdbtn);
        }
//        ((ViewGroup) view.findViewById(id)).addView(ll);

    }


    @Override
    public void EditAddressClick() {
        String address = getRadioGroupText(editProfileAddressBinding.rbAddress);
        if (!address.isEmpty())
            setFragment(ProfileAddress.newInstance(address, profileResultBean));
        else
            Toast.makeText(getActivity(), "Please select above address type", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void EditPhoneNumberClick() {
        String phone = getRadioGroupText(editProfileAddressBinding.rbPhone);
        if (!phone.isEmpty())
            setFragment(EditPhoneNumber.newInstance(phone, profileResultBean));
        else
            Toast.makeText(getActivity(), "Please select above phone type", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void EditEmailClick() {
        String email = getRadioGroupText(editProfileAddressBinding.rbEmail);
        if (!email.isEmpty())
            setFragment(EditEmail.newInstance(email, profileResultBean));
        else
            Toast.makeText(getActivity(), "Please select above email type", Toast.LENGTH_SHORT).show();
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
}
