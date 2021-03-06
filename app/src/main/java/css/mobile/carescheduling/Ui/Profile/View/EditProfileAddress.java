package css.mobile.carescheduling.Ui.Profile.View;

import android.content.Intent;
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

import css.mobile.carescheduling.R;
import css.mobile.carescheduling.Ui.Base.BaseFragment;
import css.mobile.carescheduling.Ui.Common.Common;
import css.mobile.carescheduling.Ui.Common.CommonBean;
import css.mobile.carescheduling.Ui.Dashboard.view.Dashboard;
import css.mobile.carescheduling.Ui.Profile.ViewModel.EditProfileAddressViewModel;
import css.mobile.carescheduling.Ui.Profile.bean.EditAllAddressData;
import css.mobile.carescheduling.Ui.Profile.bean.PersonAddressList;
import css.mobile.carescheduling.Ui.Profile.bean.PersonEmailList;
import css.mobile.carescheduling.Ui.Profile.bean.PersonPhoneList;
import css.mobile.carescheduling.Ui.Profile.presenter.EditProfileAddressClick;
import css.mobile.carescheduling.Utils.ConnectivityReceiver;
import css.mobile.carescheduling.data.Local.AppDataBase;
import css.mobile.carescheduling.data.Local.DatabaseInitializer;
import css.mobile.carescheduling.data.Local.DatabaseTable.PersonAllAddressEntity;
import css.mobile.carescheduling.databinding.FragmentEditProfileAddressBinding;

import java.util.ArrayList;
import java.util.List;

public class EditProfileAddress extends BaseFragment implements Common, EditProfileAddressClick {

    private FragmentEditProfileAddressBinding editProfileAddressBinding;
    private EditAllAddressData profileResultBean;
    private EditProfileAddressViewModel editProfileAddressViewModel;
    private boolean isPhone, isAddress, isEmail;
    private ArrayList<PersonAddressList> addressLists ;
    private ArrayList<PersonEmailList> emailLists ;
    private ArrayList<PersonPhoneList> phoneLists;

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
        editProfileAddressBinding.setEditAddressClick(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        setProfileInfoBeanData();
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
        addressLists = new ArrayList<>();
        phoneLists = new ArrayList<>();
        emailLists = new ArrayList<>();
        if (getActivity() != null) {
            if (ConnectivityReceiver.isNetworkAvailable(getActivity())) {
                showDialog();
                try {
                    editProfileAddressViewModel.GetMyAddressEdit(getSessionManager().getPersonId(), getSessionManager().getCustomerId(), getSessionManager().getBranchId())
                            .observe(this, new Observer<EditAllAddressData>() {
                                @Override
                                public void onChanged(EditAllAddressData editProfileInfoBean) {
                                    hideDialog();
                                    if (editProfileInfoBean != null) {
                                        profileResultBean = editProfileInfoBean;
                                        setDataToRoom();
                                        setDataInflate();
                                    }
                                }
                            });

                } catch (Exception e) {
                    hideDialog();
                    Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();

                }
            } else {
                setDataLocalY();
            }
        }
    }

    private void setDataToRoom() {
        if (profileResultBean.getPersonEmailList() != null && profileResultBean.getPersonEmailList().size() > 0) {
            // person email list
            DatabaseInitializer.populateAsyncPersonEmailList(AppDataBase.getAppDatabase(getActivity()), profileResultBean.getPersonEmailList());
        }
        if (profileResultBean.getPersonPhoneList() != null && profileResultBean.getPersonPhoneList().size() > 0) {
            // person email list
            DatabaseInitializer.populateAsyncPersonPhoneList(AppDataBase.getAppDatabase(getActivity()), profileResultBean.getPersonPhoneList());
        }


        if (profileResultBean.getPersonAddressList() != null && profileResultBean.getPersonAddressList().size() > 0) {
            // person email list
//            DatabaseInitializer.populateAsyncImageDataBean(AppDataBase.getAppDatabase(getApplication()), profileResultBean.getPersonImageList());
            List<PersonAllAddressEntity> list = new ArrayList<>();
            for (int i = 0; i < profileResultBean.getPersonAddressList().size(); i++) {
                PersonAllAddressEntity personAllAddressEntity = new PersonAllAddressEntity();
                personAllAddressEntity.setPostCode(profileResultBean.getPersonAddressList().get(i).getPostCode());
                personAllAddressEntity.setCountryCode(profileResultBean.getPersonAddressList().get(i).getCountryCode());
                personAllAddressEntity.setDefaultAddress(profileResultBean.getPersonAddressList().get(i).getDefaultAddress());
                personAllAddressEntity.setAddressTypeName(profileResultBean.getPersonAddressList().get(i).getAddressTypeName());
                personAllAddressEntity.setAddressId(profileResultBean.getPersonAddressList().get(i).getAddressId());
                list.add(personAllAddressEntity);
            }

            DatabaseInitializer.populateAsyncPersonAllAddressEntity(AppDataBase.getAppDatabase(getActivity()), list);
        }
    }


    private void setDataLocalY() {
        editProfileAddressViewModel.getDataFromLocalAddress(getActivity()).observe(this, new Observer<ArrayList<PersonAddressList>>() {
            @Override
            public void onChanged(ArrayList<PersonAddressList> personAddressLists) {
                isAddress = true;
                if (personAddressLists != null && personAddressLists.size() > 0)
                    addressLists.addAll(personAddressLists);

                if (isAddress && isEmail && isPhone) {
                    setLocalDataToModal();
                }
            }
        });
        editProfileAddressViewModel.getDataFromLocalEmail(getActivity()).observe(this, new Observer<ArrayList<PersonEmailList>>() {
            @Override
            public void onChanged(ArrayList<PersonEmailList> personEmailLists) {
                isEmail = true;
                if (personEmailLists != null && personEmailLists.size() > 0)
                    emailLists.addAll(personEmailLists);
                if (isAddress && isEmail && isPhone) {
                    setLocalDataToModal();
                }
            }
        });

        editProfileAddressViewModel.getDataFromLocalPhone(getActivity()).observe(this, new Observer<ArrayList<PersonPhoneList>>() {
            @Override
            public void onChanged(ArrayList<PersonPhoneList> personPhoneLists) {
                isPhone = true;
                if (personPhoneLists != null && personPhoneLists.size() > 0)
                    phoneLists.addAll(personPhoneLists);
                if (isAddress && isEmail && isPhone) {
                    setLocalDataToModal();
                }
            }
        });
    }

    private void setLocalDataToModal() {
        final EditAllAddressData editAllAddressData = new EditAllAddressData();
        editAllAddressData.setPersonPhoneList(phoneLists);
        editAllAddressData.setPersonEmailList(emailLists);
        editAllAddressData.setPersonAddressList(addressLists);

        profileResultBean = editAllAddressData;
        setDataInflate();
    }


    private void setDataInflate() {
//
        if (profileResultBean != null && getView() != null) {
            if (profileResultBean.getPersonAddressList() != null) {
                editProfileAddressBinding.setPersonAddressList(profileResultBean.getPersonAddressList().size());
                addRadioButtonsAddress(getView(), profileResultBean.getPersonAddressList(), R.id.rb_address);
            } else {
                editProfileAddressBinding.setPersonAddressList(0);
                addRadioButtonsAddress(getView(), profileResultBean.getPersonAddressList(), R.id.rb_address);
            }
            if (profileResultBean.getPersonEmailList() != null) {
                editProfileAddressBinding.setPersonEmailList(profileResultBean.getPersonEmailList().size());
                addRadioButtonsPhone(getView(), profileResultBean.getPersonPhoneList(), R.id.rb_phone);
            } else {
                editProfileAddressBinding.setPersonEmailList(0);
                addRadioButtonsPhone(getView(), profileResultBean.getPersonPhoneList(), R.id.rb_phone);
            }
            if (profileResultBean.getPersonPhoneList() != null) {
                editProfileAddressBinding.setPersonPhoneList(profileResultBean.getPersonPhoneList().size());
                addRadioButtonsEmail(getView(), profileResultBean.getPersonEmailList(), R.id.rb_email);
            } else {
                editProfileAddressBinding.setPersonPhoneList(0);
                addRadioButtonsEmail(getView(), profileResultBean.getPersonEmailList(), R.id.rb_email);
            }
        } else {
            editProfileAddressBinding.setPersonAddressList(0);
            editProfileAddressBinding.setPersonEmailList(0);
            editProfileAddressBinding.setPersonPhoneList(0);
        }
    }

    private void removeViewAddress(RadioGroup radioGroup) {
        int count = radioGroup.getChildCount();
        if (count > 0) {
            ((ViewGroup) radioGroup.getChildAt(0).getParent()).removeAllViews();
//            for (int i = count - 1; i >= 0; i--) {
//                View o = radioGroup.getChildAt(i);
//                ((ViewGroup) o.getParent().getParent()).removeView(o);
////                if (o instanceof RadioButton) {
////                    radioGroup.removeViewAt(i);
////                }
//            }
        }
    }

    private void addRadioButtonsAddress(View view, ArrayList<PersonAddressList> arrayList, int id) {
        RadioGroup ll = view.findViewById(id);
        ll.removeAllViews();
        ll.setOrientation(LinearLayout.VERTICAL);
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                RadioButton rdbtn = new RadioButton(getActivity());
                rdbtn.setId(View.generateViewId());
                rdbtn.setText(arrayList.get(i).getAddressTypeName());
                rdbtn.setChecked(arrayList.get(i).getDefaultAddress());
                ll.addView(rdbtn);
            }
        }


//        ((ViewGroup) view.findViewById(id)).addView(ll);

    }


    private void addRadioButtonsPhone(View view, ArrayList<PersonPhoneList> arrayList, int id) {
        RadioGroup ll = view.findViewById(id);
        ll.removeAllViews();
        ll.setOrientation(LinearLayout.VERTICAL);
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                RadioButton rdbtn = new RadioButton(getActivity());
                rdbtn.setId(View.generateViewId());
                rdbtn.setText(arrayList.get(i).getPhoneTypeName());
                rdbtn.setChecked(arrayList.get(i).getIsDefaultPhone());
                ll.addView(rdbtn);
            }
        }
//        ((ViewGroup) view.findViewById(id)).addView(ll);

    }

    private void addRadioButtonsEmail(View view, ArrayList<PersonEmailList> arrayList, int id) {
        RadioGroup ll = view.findViewById(id);
        ll.removeAllViews();
        ll.setOrientation(LinearLayout.VERTICAL);
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                RadioButton rdbtn = new RadioButton(getActivity());
                rdbtn.setId(View.generateViewId());
                rdbtn.setText(arrayList.get(i).getEmailTypeName());
                rdbtn.setChecked(arrayList.get(i).getIsDefaultEmail());
                ll.addView(rdbtn);
            }
        }
//        ((ViewGroup) view.findViewById(id)).addView(ll);

    }


    @Override
    public void EditAddressClick() {
        setFragment(AddAddress.newInstance(profileResultBean.getPersonAddressList()));
    }

    @Override
    public void EditPhoneNumberClick() {
        setFragment(AddPhoneNumber.newInstance(profileResultBean.getPersonPhoneList()));
    }

    @Override
    public void EditEmailClick() {
        setFragment(AddEmail.newInstance(profileResultBean.getPersonEmailList()));
    }

    @Override
    public void UpdateAddressClick() {
        String address = getRadioGroupText(editProfileAddressBinding.rbAddress);
        if (!address.isEmpty()) {
            for (int i = 0; i < profileResultBean.getPersonAddressList().size(); i++) {
                if (profileResultBean.getPersonAddressList().get(i).getAddressTypeName().equalsIgnoreCase(address)) {
                    setFragment(ProfileAddress.newInstance(address, profileResultBean.getPersonAddressList().get(i), profileResultBean.getPersonAddressList()));
                    return;
                }
            }
        } else
            Toast.makeText(getActivity(), "Please select above address type", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void UpdatePhoneNumberClick() {
        String address = getRadioGroupText(editProfileAddressBinding.rbPhone);
        if (!address.isEmpty()) {
            for (int i = 0; i < profileResultBean.getPersonPhoneList().size(); i++) {
                if (profileResultBean.getPersonPhoneList().get(i).getPhoneTypeName().equalsIgnoreCase(address)) {
                    setFragment(EditPhoneNumber.newInstance(address, profileResultBean.getPersonPhoneList().get(i), profileResultBean.getPersonPhoneList()));
                    return;
                }
            }
        } else
            Toast.makeText(getActivity(), "Please select above phone type", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void UpdateEmailClick() {
        String address = getRadioGroupText(editProfileAddressBinding.rbEmail);
        if (!address.isEmpty()) {
            for (int i = 0; i < profileResultBean.getPersonEmailList().size(); i++) {
                if (profileResultBean.getPersonEmailList().get(i).getEmailTypeName().equalsIgnoreCase(address)) {
                    setFragment(EditEmail.newInstance(address, profileResultBean.getPersonEmailList().get(i), profileResultBean.getPersonEmailList()));
                    return;
                }
            }
        } else
            Toast.makeText(getActivity(), "Please select above email type", Toast.LENGTH_SHORT).show();
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
                if (profileResultBean.getPersonAddressList().get(i).getPersonAddress().getAddressTypeName().equalsIgnoreCase(address)) {
                    showDialog();
                    editProfileAddressViewModel.DeleteAddress(profileResultBean.getPersonAddressList().get(i).getPersonAddress()).observe(this, new Observer<Boolean>() {
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
