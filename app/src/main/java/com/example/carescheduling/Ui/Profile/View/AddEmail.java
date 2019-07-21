package com.example.carescheduling.Ui.Profile.View;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
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
import com.example.carescheduling.Ui.Dashboard.beans.PersonEmail;
import com.example.carescheduling.Ui.Dashboard.beans.ProfileBean;
import com.example.carescheduling.Ui.Dashboard.view.Dashboard;
import com.example.carescheduling.Ui.Profile.Adapter.CustomAdapter;
import com.example.carescheduling.Ui.Profile.ViewModel.AddEmailViewModel;
import com.example.carescheduling.Ui.Profile.bean.EditEmailBean;
import com.example.carescheduling.Utils.ConnectivityReceiver;
import com.example.carescheduling.Utils.Constants;
import com.example.carescheduling.data.Local.DatabaseTable.EmailType;
import com.example.carescheduling.databinding.AddEmailFragmentBinding;

import java.util.ArrayList;
import java.util.List;


public class AddEmail extends BaseFragment implements Common {
    private AddEmailFragmentBinding editEmailBinding;
    private String stringValue, type;
    private ProfileBean profileBean;
    private AddEmailViewModel editEmailViewModel;

    public static AddEmail newInstance(String value, String type, ProfileBean profileBean) {
        AddEmail editEmail = new AddEmail();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.STRING_VALUE, value);
        bundle.putString(Constants.TYPE, type);
        bundle.putSerializable(Constants.PROFILE_DATA, profileBean);
        editEmail.setArguments(bundle);
        return editEmail;
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
        editEmailBinding = DataBindingUtil.inflate(inflater, R.layout.add_email_fragment, container, false);
        View view = editEmailBinding.getRoot();
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {
        setCommonData();
        editEmailViewModel = ViewModelProviders.of(this).get(AddEmailViewModel.class);
        if (type.equalsIgnoreCase("Update")) {
            editEmailBinding.spinnerEmailType.setEnabled(false);
            editEmailBinding.spinnerEmailType.setClickable(false);
        } else {
            editEmailBinding.spinnerEmailType.setEnabled(true);
            editEmailBinding.spinnerEmailType.setClickable(true);
        }
        setEmailType();
//        setEditEmailData();
    }

    private void setCommonData() {
        CommonBean commonBean = new CommonBean();
        commonBean.setLeftImageDrawable(R.drawable.ic_left_back);
        commonBean.setLeftImageVisible(true);
        commonBean.setRightImageDrawable(R.drawable.ic_tick);
        commonBean.setRightImageVisible(false);
        commonBean.setRightTextVisible(true);
        commonBean.setTitle("Change Email");
        editEmailBinding.setCommonData(commonBean);
        editEmailBinding.setCommonClick(this);
    }

    private void setEditEmailData() {
        editEmailViewModel.getEditEmailBean(stringValue, profileBean).observe(this, new Observer<EditEmailBean>() {
            @Override
            public void onChanged(EditEmailBean editEmailBean) {
                editEmailBinding.setEditEmailBean(editEmailBean);
                editEmailBinding.rbDefaultEmail.setSelected(editEmailBean.isDefault());
            }
        });
    }


    private void setEmailType() {

        editEmailViewModel.getEmailType().observe(this, new Observer<List<EmailType>>() {
            @Override
            public void onChanged(List<EmailType> addressTypes) {
                ArrayList<String> arrayList = new ArrayList<>();

                if (addressTypes != null && addressTypes.size() > 0) {
                    for (int i = 0; i < addressTypes.size(); i++) {
                        if (i == 0)
                            arrayList.add("Select Email Type");
                        arrayList.add(addressTypes.get(i).getEmailName());
                    }
                    CustomAdapter adapter = new CustomAdapter(getActivity(),
                            R.layout.item_spinner_sf, R.id.title, arrayList);
                    editEmailBinding.spinnerEmailType.setAdapter(adapter);

                }
            }
        });

    }


    private void setDataRemote() {

        setEmailData();

    }

    private void setEmailData() {
        ProfileBean myProfileBean = null;
//        if (profileBean.getData() != null && profileBean.getData().getPerson() != null && profileBean.getData().getPerson().getPersonEmail() != null && stringValue != null) {
//            myProfileBean = updateEmail();
//        } else {
//        }
        showDialog();
        myProfileBean = addNewEmail();
        if (profileBean == null) {
            hideDialog();
            return;
        }

        editEmailViewModel.getEditProfilePost(myProfileBean.getData()).observe(this, new Observer<ProfileBean>() {
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

    private ProfileBean updateEmail() {
        int emailCounter = 0;
        if (profileBean.getData().getPerson().getPersonEmail().size() > 0) {
            for (int i = 0; i < profileBean.getData().getPerson().getPersonEmail().size(); i++) {
                if (profileBean.getData().getPerson().getPersonEmail().get(i).getEmailTypeName().equalsIgnoreCase((String) editEmailBinding.spinnerEmailType.getSelectedItem())) {
                    profileBean.getData().getPerson().getPersonEmail().get(i).setEmailAddress(editEmailBinding.edtEmailAddress.getText().toString());
                    profileBean.getData().getPerson().getPersonEmail().get(i).setIsDefaultEmail(editEmailBinding.rbDefaultEmail.isChecked());
                    emailCounter++;
                    break;
                }
            }
        }

        if (emailCounter == 0) {
            profileBean = addNewEmail();
        }

        return profileBean;
    }

    private ProfileBean addNewEmail() {

        PersonEmail personEmail = new PersonEmail();
        personEmail.setCustomerId(getSessionManager().getCustomerId());
        personEmail.setPersonId(getSessionManager().getPersonId());
        personEmail.setIsDefaultEmail(editEmailBinding.rbDefaultEmail.isChecked());
        personEmail.setEmailAddress(editEmailBinding.edtEmailAddress.getText().toString());
        if (editEmailBinding.spinnerEmailType.getSelectedItemPosition() > 0)
            personEmail.setEmailTypeName((String) editEmailBinding.spinnerEmailType.getSelectedItem());
        else {
            Toast.makeText(getActivity(), "Please select email type", Toast.LENGTH_SHORT).show();
            return null;
        }
        profileBean.getData().getPerson().getPersonEmail().add(personEmail);

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

