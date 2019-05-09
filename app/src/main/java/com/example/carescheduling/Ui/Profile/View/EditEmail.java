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
import com.example.carescheduling.Ui.Dashboard.beans.ProfileBean;
import com.example.carescheduling.Ui.Profile.ViewModel.EditEmailViewModel;
import com.example.carescheduling.Ui.Profile.bean.EditEmailBean;
import com.example.carescheduling.Ui.Profile.presenter.EditEmailClick;
import com.example.carescheduling.Utils.Constants;
import com.example.carescheduling.databinding.FragmentEditEmailBinding;

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
        setEditEmailData();
        editEmailBinding.setEditEmailClick(this);
    }

    private void setEditEmailData() {
        editEmailViewModel.getEditEmailBean(stringValue, profileBean).observe(this, new Observer<EditEmailBean>() {
            @Override
            public void onChanged(EditEmailBean editEmailBean) {
                editEmailBinding.setEditEmailBean(editEmailBean);
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
        setDataRemote();
    }

    private void setDataRemote() {
        showDialog();
        for (int i = 0; i < profileBean.getData().getPerson().getPersonEmail().size(); i++) {
            if (profileBean.getData().getPerson().getPersonEmail().get(i).getEmailTypeName().equalsIgnoreCase(stringValue)) {
                profileBean.getData().getPerson().getPersonEmail().get(i).setEmailAddress(editEmailBinding.edtEmailAddress.getText().toString());
                profileBean.getData().getPerson().getPersonEmail().get(i).setIsDefaultEmail(editEmailBinding.rbDefaultEmail.isChecked());
            }

        }
        editEmailViewModel.getEditProfilePost(profileBean.getData()).observe(this, new Observer<ProfileBean>() {
            @Override
            public void onChanged(ProfileBean profileBean) {
                hideDialog();
                if (profileBean != null)
                    Toast.makeText(getActivity(), "Success", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
