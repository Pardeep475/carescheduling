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
import css.mobile.carescheduling.Ui.Profile.bean.AddPhoneNumberBeanRetro;
import css.mobile.carescheduling.Ui.Profile.bean.PersonPhoneList;
import css.mobile.carescheduling.Utils.ConnectivityReceiver;
import css.mobile.carescheduling.data.Local.DatabaseTable.CountryCode;
import css.mobile.carescheduling.data.Local.DatabaseTable.PhoneType;

import java.util.ArrayList;
import java.util.List;

import css.mobile.carescheduling.Ui.Profile.ViewModel.AddPhoneNumberViewModel;
import css.mobile.carescheduling.databinding.AddPhoneNumberFragmentBinding;

public class AddPhoneNumber extends BaseFragment implements Common {
    private AddPhoneNumberFragmentBinding editPhoneNumberBinding;
    private AddPhoneNumberViewModel editPhoneNumberViewModel;
    private ArrayList<PersonPhoneList> personPhoneList;

    public static AddPhoneNumber newInstance(ArrayList<PersonPhoneList> personPhoneList) {
        AddPhoneNumber editPhoneNumber = new AddPhoneNumber();
        Bundle bundle = new Bundle();
        bundle.putSerializable("PersonPhoneList", personPhoneList);
        editPhoneNumber.setArguments(bundle);
        return editPhoneNumber;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            personPhoneList = (ArrayList<PersonPhoneList>) getArguments().getSerializable("PersonPhoneList");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        editPhoneNumberBinding = DataBindingUtil.inflate(inflater, R.layout.add_phone_number_fragment, container, false);
        View view = editPhoneNumberBinding.getRoot();
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {
        setCommonData();
        editPhoneNumberViewModel = ViewModelProviders.of(this).get(AddPhoneNumberViewModel.class);
        setCodePrefix();
        setPhoneType();
//        setEditPhoneNumber();

    }

    private void setCommonData() {
        CommonBean commonBean = new CommonBean();
        commonBean.setLeftImageDrawable(R.drawable.ic_left_back);
        commonBean.setLeftImageVisible(true);
        commonBean.setRightImageDrawable(R.drawable.ic_tick);
        commonBean.setRightImageVisible(false);
        commonBean.setRightTextVisible(true);
        commonBean.setTitle("Add Phone Number");
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
                            arrayList.add("Select Country");
                        arrayList.add(countryCodes.get(i).getCountryName());
                    }
                    CustomAdapter adapter = new CustomAdapter(getActivity(),
                            R.layout.item_spinner_sf, R.id.title, arrayList);
                    editPhoneNumberBinding.spinnerCountryCode.setAdapter(adapter);
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
                    showAToast("Phone type name already taken please select other one");
                    return;
                }
                showDialog();
                editPhoneNumberViewModel.AddPhone(AddNumber()).observe(this, new Observer<Boolean>() {
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
                Toast.makeText(getActivity(), "Please select image", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getActivity(), "please check your internet connection", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean TypeNameAlreadyExist() {
        if (personPhoneList == null)
            return false;
        for (int i = 0; i < personPhoneList.size(); i++) {
            if (personPhoneList.get(i).getPhoneTypeName().equalsIgnoreCase((String) editPhoneNumberBinding.spinnerPhoneType.getSelectedItem())) {
                return true;
            }
        }
        return false;
    }

    private AddPhoneNumberBeanRetro AddNumber() {
        AddPhoneNumberBeanRetro addPhoneNumberBeanRetro = new AddPhoneNumberBeanRetro();
        addPhoneNumberBeanRetro.setCustomerId(getSessionManager().getCustomerId());
        addPhoneNumberBeanRetro.setPersonId(getSessionManager().getPersonId());
        addPhoneNumberBeanRetro.setCountryTelephonePrefix((String) editPhoneNumberBinding.spinnerCountryCode.getSelectedItem());
        addPhoneNumberBeanRetro.setPhoneNumber(editPhoneNumberBinding.edtNumber.getText().toString());
        addPhoneNumberBeanRetro.setPhoneTypeName((String) editPhoneNumberBinding.spinnerPhoneType.getSelectedItem());
        addPhoneNumberBeanRetro.setDefaultPhone(editPhoneNumberBinding.rbDefaultNumber.isChecked());
        addPhoneNumberBeanRetro.setCanNotCall(editPhoneNumberBinding.rbDoNotCall.isChecked());
        return addPhoneNumberBeanRetro;
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

}

