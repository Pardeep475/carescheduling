package css.mobile.carescheduling.Ui.Profile.View;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import css.mobile.carescheduling.R;
import css.mobile.carescheduling.Ui.Base.BaseFragment;
import css.mobile.carescheduling.Ui.Common.Common;
import css.mobile.carescheduling.Ui.Common.CommonBean;
import css.mobile.carescheduling.Ui.Profile.Adapter.CustomAdapter;
import css.mobile.carescheduling.Ui.Profile.ViewModel.EditEmailViewModel;
import css.mobile.carescheduling.Ui.Profile.bean.EditEmailRetroBean;
import css.mobile.carescheduling.Ui.Profile.bean.PersonEmailList;
import css.mobile.carescheduling.Utils.ConnectivityReceiver;
import css.mobile.carescheduling.Utils.Constants;
import css.mobile.carescheduling.data.Local.AppDataBase;
import css.mobile.carescheduling.data.Local.DatabaseInitializer;
import css.mobile.carescheduling.data.Local.DatabaseTable.EmailType;
import css.mobile.carescheduling.databinding.FragmentEditEmailBinding;

import java.util.ArrayList;
import java.util.List;

public class EditEmail extends BaseFragment implements Common {
    private FragmentEditEmailBinding editEmailBinding;
    private String stringValue;
    private PersonEmailList profileBean;
    private EditEmailViewModel editEmailViewModel;
    private ArrayList<PersonEmailList> personEmailList;
    private int position;

    public static EditEmail newInstance(String value, PersonEmailList profileBean, ArrayList<PersonEmailList> personEmailList) {
        EditEmail editEmail = new EditEmail();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.STRING_VALUE, value);
        bundle.putSerializable(Constants.PROFILE_DATA, profileBean);
        bundle.putSerializable("PersonEmailList", personEmailList);
        editEmail.setArguments(bundle);
        return editEmail;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            stringValue = getArguments().getString(Constants.STRING_VALUE);
            profileBean = (PersonEmailList) getArguments().getSerializable(Constants.PROFILE_DATA);
            personEmailList = (ArrayList<PersonEmailList>) getArguments().getSerializable("PersonEmailList");
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
        getPosition();
        setCommonData();
        editEmailViewModel = ViewModelProviders.of(this).get(EditEmailViewModel.class);
        setEmailType();
        setEditEmailData();
    }

    private void setCommonData() {
        CommonBean commonBean = new CommonBean();
        commonBean.setLeftImageDrawable(R.drawable.ic_left_back);
        commonBean.setLeftImageVisible(true);
        commonBean.setRightImageDrawable(R.drawable.ic_tick);
        commonBean.setRightImageVisible(false);
        commonBean.setRightTextVisible(true);
        commonBean.setTitle("Edit Email");
        editEmailBinding.setCommonData(commonBean);
        editEmailBinding.setCommonClick(this);
    }

    private void setEditEmailData() {
        if (profileBean != null)
            editEmailBinding.setPersonEmailList(profileBean);

        if (profileBean != null && profileBean.getIsDefaultEmail() != null)
            editEmailBinding.rbDefaultEmail.setChecked(profileBean.getIsDefaultEmail());
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

                    if (stringValue != null) {
                        int pos = adapter.getPosition(stringValue);
                        editEmailBinding.spinnerEmailType.setSelection(pos);
                    }
                }
            }
        });

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

    private void setDataRemote() {
        if (getActivity() != null && ConnectivityReceiver.isNetworkAvailable(getActivity())) {
            if (validation()) {
                if (TypeNameAlreadyExist()) {
                    showAToast("Email type name already taken please select other one");
                    return;
                }
                showDialog();
                editEmailViewModel.EditEmail(EditEmailRetro()).observe(this, new Observer<Boolean>() {
                    @Override
                    public void onChanged(Boolean s) {
                        hideDialog();
                        if (s != null) {
                            if (s) {
                                setEmailDataToRoom();
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

    private boolean TypeNameAlreadyExist() {
        if (personEmailList == null)
            return false;
        if (stringValue.equalsIgnoreCase((String) editEmailBinding.spinnerEmailType.getSelectedItem()))
            return false;
        for (int i = 0; i < personEmailList.size(); i++) {
            if (personEmailList.get(i).getEmailTypeName().equalsIgnoreCase((String) editEmailBinding.spinnerEmailType.getSelectedItem())) {
                return true;
            }
        }
        return false;
    }

    private EditEmailRetroBean EditEmailRetro() {
        EditEmailRetroBean editEmailRetroBean = new EditEmailRetroBean();
        editEmailRetroBean.setCustomerId(getSessionManager().getCustomerId());
        editEmailRetroBean.setPersonId(getSessionManager().getPersonId());
        editEmailRetroBean.setEmailTypeName((String) editEmailBinding.spinnerEmailType.getSelectedItem());
        editEmailRetroBean.setEmailAddress(editEmailBinding.edtEmailAddress.getText().toString());
        editEmailRetroBean.setDefaultEmail(editEmailBinding.rbDefaultEmail.isChecked());
        editEmailRetroBean.setOldEmailTypeName(profileBean.getEmailTypeName());
        return editEmailRetroBean;
    }

    private boolean validation() {
        if (editEmailBinding.spinnerEmailType.getSelectedItemPosition() <= 0) {
            showAToast("Please select email type");
            return false;
        }
        if (TextUtils.isEmpty(editEmailBinding.edtEmailAddress.getText())) {
            showAToast("Please enter email");
            return false;
        }
        return true;
    }

    private void setEmailDataToRoom() {
        PersonEmailList editEmailRetroBean = new PersonEmailList();
        editEmailRetroBean.setCustomerId(getSessionManager().getCustomerId());
        editEmailRetroBean.setPersonId(getSessionManager().getPersonId());
        editEmailRetroBean.setEmailTypeName((String) editEmailBinding.spinnerEmailType.getSelectedItem());
        editEmailRetroBean.setEmailAddress(editEmailBinding.edtEmailAddress.getText().toString());
        editEmailRetroBean.setIsDefaultEmail(editEmailBinding.rbDefaultEmail.isChecked());

        personEmailList.set(position,editEmailRetroBean);

        DatabaseInitializer.populateAsyncPersonEmailList(AppDataBase.getAppDatabase(getActivity()), personEmailList);

        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    private void getPosition() {
        for (int i = 0; i < personEmailList.size(); i++) {
            if (personEmailList.get(i).getEmailTypeName().equalsIgnoreCase(stringValue)) {
                position = i;
            }
        }
    }
}

