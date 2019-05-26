package com.example.carescheduling.Ui.Profile.View;

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
import com.example.carescheduling.Ui.Dashboard.beans.PersonEmail;
import com.example.carescheduling.Ui.Dashboard.beans.ProfileBean;
import com.example.carescheduling.Ui.Profile.Adapter.CustomAdapter;
import com.example.carescheduling.Ui.Profile.ViewModel.EditEmailViewModel;
import com.example.carescheduling.Ui.Profile.bean.EditEmailBean;
import com.example.carescheduling.Ui.Profile.presenter.EditEmailClick;
import com.example.carescheduling.Utils.ConnectivityReceiver;
import com.example.carescheduling.Utils.Constants;
import com.example.carescheduling.data.Local.DatabaseTable.EmailType;
import com.example.carescheduling.databinding.FragmentEditEmailBinding;

import java.util.ArrayList;
import java.util.List;

public class EditEmail extends BaseFragment implements EditEmailClick {
    private FragmentEditEmailBinding editEmailBinding;
    private String stringValue;
    private ProfileBean profileBean;
    private EditEmailViewModel editEmailViewModel;

    public static EditEmail newInstance(String value, ProfileBean profileBean) {
        EditEmail editEmail = new EditEmail();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.STRING_VALUE, value);
        bundle.putSerializable(Constants.PROFILE_DATA, profileBean);
        editEmail.setArguments(bundle);
        return editEmail;
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
        editEmailBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_email, container, false);
        View view = editEmailBinding.getRoot();
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {
        editEmailViewModel = ViewModelProviders.of(this).get(EditEmailViewModel.class);
        setEmailType();
        setEditEmailData();
        editEmailBinding.setEditEmailClick(this);
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
                        arrayList.add(addressTypes.get(i).getEmailName());
                    }
                    CustomAdapter adapter = new CustomAdapter(getActivity(),
                            R.layout.item_spinner_sf, R.id.title, arrayList);
                    editEmailBinding.spinnerEmailType.setAdapter(adapter);

                    if (stringValue != null) {
                        int pos = adapter.getPosition(stringValue);
                        editEmailBinding.spinnerEmailType.setSelection(pos);
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
        setEmailData();

    }

    private void setEmailData() {

        if (profileBean.getData() != null && profileBean.getData().getPerson() != null && profileBean.getData().getPerson().getPersonEmail() != null && stringValue != null) {
            profileBean = updateEmail();
        } else {
            profileBean = addNewEmail();
        }

        editEmailViewModel.getEditProfilePost(profileBean.getData()).observe(this, new Observer<ProfileBean>() {
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
        personEmail.setEmailTypeName((String) editEmailBinding.spinnerEmailType.getSelectedItem());
        profileBean.getData().getPerson().getPersonEmail().add(personEmail);

        return profileBean;
    }


}
