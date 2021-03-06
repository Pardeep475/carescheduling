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
import css.mobile.carescheduling.Ui.Profile.ViewModel.EditPhoneNumberViewModel;
import css.mobile.carescheduling.Ui.Profile.bean.EditNumberBeanRetro;
import css.mobile.carescheduling.Ui.Profile.bean.PersonPhoneList;
import css.mobile.carescheduling.Utils.ConnectivityReceiver;
import css.mobile.carescheduling.Utils.Constants;
import css.mobile.carescheduling.data.Local.AppDataBase;
import css.mobile.carescheduling.data.Local.DatabaseInitializer;
import css.mobile.carescheduling.data.Local.DatabaseTable.CountryCode;
import css.mobile.carescheduling.data.Local.DatabaseTable.PhoneType;
import css.mobile.carescheduling.databinding.FragmentEditPhoneNumberBinding;

import java.util.ArrayList;
import java.util.List;

public class EditPhoneNumber extends BaseFragment implements Common {
    private FragmentEditPhoneNumberBinding editPhoneNumberBinding;
    private String stringValue;
    private PersonPhoneList profileBean;
    private EditPhoneNumberViewModel editPhoneNumberViewModel;
    private ArrayList<PersonPhoneList> personPhoneList;
    private int position;
    public static EditPhoneNumber newInstance(String value, PersonPhoneList profileBean, ArrayList<PersonPhoneList> personPhoneList) {
        EditPhoneNumber editPhoneNumber = new EditPhoneNumber();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.STRING_VALUE, value);
        bundle.putSerializable(Constants.PROFILE_DATA, profileBean);
        bundle.putSerializable("PersonPhoneList", personPhoneList);
        editPhoneNumber.setArguments(bundle);
        return editPhoneNumber;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            stringValue = getArguments().getString(Constants.STRING_VALUE);
            profileBean = (PersonPhoneList) getArguments().getSerializable(Constants.PROFILE_DATA);
            personPhoneList = (ArrayList<PersonPhoneList>) getArguments().getSerializable("PersonPhoneList");
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
        getPosition();
        setCommonData();
        sessionManager = getSessionManager();
        editPhoneNumberViewModel = ViewModelProviders.of(this).get(EditPhoneNumberViewModel.class);

        setCodePrefix();
        setPhoneType();
        setEditPhoneNumber();
            editPhoneNumberBinding.rbDoNotCall.setChecked((boolean) profileBean.getCanNotCall());
        if (profileBean != null && profileBean.getIsDefaultPhone() != null)
            editPhoneNumberBinding.rbDefaultNumber.setChecked(profileBean.getIsDefaultPhone());

    }

    private void setCommonData() {
        CommonBean commonBean = new CommonBean();
        commonBean.setLeftImageDrawable(R.drawable.ic_left_back);
        commonBean.setLeftImageVisible(true);
        commonBean.setRightImageDrawable(R.drawable.ic_tick);
        commonBean.setRightImageVisible(false);
        commonBean.setRightTextVisible(true);
        commonBean.setTitle("Edit Phone Number");
        editPhoneNumberBinding.setCommonData(commonBean);
        editPhoneNumberBinding.setCommonClick(this);
    }

    private void setCodePrefix() {
        editPhoneNumberViewModel.getCountryCode().observe(this, new Observer<List<CountryCode>>() {
            @Override
            public void onChanged(List<CountryCode> countryCodes) {
                ArrayList<String> arrayList = new ArrayList<>();
                if (countryCodes != null && countryCodes.size() > 0) {
                    for (int i = 0; i < countryCodes.size(); i++) {
                        if (i == 0)
                            arrayList.add("Select Country Code");
                        arrayList.add(countryCodes.get(i).getCountryName().trim());
                    }
                    CustomAdapter adapter = new CustomAdapter(getActivity(),
                            R.layout.item_spinner_sf, R.id.title, arrayList);
                    editPhoneNumberBinding.spinnerCountryCode.setAdapter(adapter);

                    if (profileBean != null && profileBean.getCountryTelephonePrefix() != null) {
                        int pos = adapter.getPosition(profileBean.getCountryTelephonePrefix());
                        editPhoneNumberBinding.spinnerCountryCode.setSelection(pos);
                    }
                }

            }
        });
    }

    private void setPhoneType() {
        editPhoneNumberViewModel.getPhoneType().observe(this, new Observer<List<PhoneType>>() {
            @Override
            public void onChanged(List<PhoneType> phoneTypes) {
                ArrayList<String> arrayList = new ArrayList<>();
                if (phoneTypes != null && phoneTypes.size() > 0) {
                    for (int i = 0; i < phoneTypes.size(); i++) {
                        if (i == 0)
                            arrayList.add("Select Phone Type");
                        arrayList.add(phoneTypes.get(i).getPhoneName());
                    }
                    CustomAdapter adapter = new CustomAdapter(getActivity(),
                            R.layout.item_spinner_sf, R.id.title, arrayList);
                    editPhoneNumberBinding.spinnerPhoneType.setAdapter(adapter);
                    if (stringValue != null) {
                        int pos = adapter.getPosition(stringValue);
                        editPhoneNumberBinding.spinnerPhoneType.setSelection(pos);
                    }
                }
            }
        });
    }


    private void setEditPhoneNumber() {
        editPhoneNumberBinding.setPersonPhoneList(profileBean);
        editPhoneNumberBinding.rbDefaultNumber.setSelected(profileBean.getIsDefaultPhone());
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
                    showAToast("Phone type name already taken please select other one");
                    return;
                }
                showDialog();
                editPhoneNumberViewModel.EditNumber(EditNumber()).observe(this, new Observer<Boolean>() {
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
                Toast.makeText(getActivity(), "Please select image", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getActivity(), "please check your internet connection", Toast.LENGTH_SHORT).show();
        }
    }
    private boolean TypeNameAlreadyExist() {
        if (personPhoneList == null)
            return false;
        if (stringValue.equalsIgnoreCase((String)  editPhoneNumberBinding.spinnerPhoneType.getSelectedItem()) )
            return false;
        for (int i = 0; i < personPhoneList.size(); i++) {
            if (personPhoneList.get(i).getPhoneTypeName().equalsIgnoreCase((String) editPhoneNumberBinding.spinnerPhoneType.getSelectedItem())) {
                return true;
            }
        }
        return false;
    }
    private EditNumberBeanRetro EditNumber() {
        EditNumberBeanRetro editPhoneNumberBean = new EditNumberBeanRetro();
        editPhoneNumberBean.setCustomerId(getSessionManager().getCustomerId());
        editPhoneNumberBean.setPersonId(getSessionManager().getPersonId());
        editPhoneNumberBean.setOldPhoneNumber(profileBean.getPhoneNumber());
        editPhoneNumberBean.setCountryTelephonePrefix((String) editPhoneNumberBinding.spinnerCountryCode.getSelectedItem());
        editPhoneNumberBean.setPhoneNumber(editPhoneNumberBinding.edtNumber.getText().toString());
        editPhoneNumberBean.setPhoneTypeName((String) editPhoneNumberBinding.spinnerPhoneType.getSelectedItem());
        editPhoneNumberBean.setDefaultPhone(editPhoneNumberBinding.rbDefaultNumber.isChecked());
        editPhoneNumberBean.setCanNotCall(editPhoneNumberBinding.rbDoNotCall.isChecked());
        return editPhoneNumberBean;
    }

    private boolean validation() {
        if (editPhoneNumberBinding.spinnerCountryCode.getSelectedItemPosition() <= 0) {
            showAToast("Please select country code");
            return false;
        } else if (editPhoneNumberBinding.spinnerPhoneType.getSelectedItemPosition() <= 0) {
            showAToast("Please select phone type");
            return false;
        }
        if (TextUtils.isEmpty(editPhoneNumberBinding.edtNumber.getText())) {
            showAToast("Please enter number");
            return false;
        }
        return true;
    }

    private void setEmailDataToRoom() {
        PersonPhoneList editPhoneNumberBean = new PersonPhoneList();
        editPhoneNumberBean.setCustomerId(getSessionManager().getCustomerId());
        editPhoneNumberBean.setPersonId(getSessionManager().getPersonId());
        editPhoneNumberBean.setCountryTelephonePrefix((String) editPhoneNumberBinding.spinnerCountryCode.getSelectedItem());
        editPhoneNumberBean.setPhoneNumber(editPhoneNumberBinding.edtNumber.getText().toString());
        editPhoneNumberBean.setPhoneTypeName((String) editPhoneNumberBinding.spinnerPhoneType.getSelectedItem());
        editPhoneNumberBean.setIsDefaultPhone(editPhoneNumberBinding.rbDefaultNumber.isChecked());
        editPhoneNumberBean.setCanNotCall(editPhoneNumberBinding.rbDoNotCall.isChecked());
        personPhoneList.set(position,editPhoneNumberBean);

        DatabaseInitializer.populateAsyncPersonPhoneList(AppDataBase.getAppDatabase(getActivity()), personPhoneList);

        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    private void getPosition() {
        for (int i = 0; i < personPhoneList.size(); i++) {
            if (personPhoneList.get(i).getPhoneTypeName().equalsIgnoreCase(stringValue)) {
                position = i;
            }
        }
    }
}
