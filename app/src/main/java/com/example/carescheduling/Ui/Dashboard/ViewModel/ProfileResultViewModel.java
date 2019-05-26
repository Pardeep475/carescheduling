package com.example.carescheduling.Ui.Dashboard.ViewModel;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Dashboard.beans.PersonAddress_;
import com.example.carescheduling.Ui.Dashboard.beans.PersonImage;
import com.example.carescheduling.Ui.Dashboard.beans.ProfileBean;
import com.example.carescheduling.Ui.Dashboard.beans.ProfileResultBean;
import com.example.carescheduling.data.Network.ApiClient;
import com.example.carescheduling.data.Network.ApiService;
import com.google.gson.JsonElement;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class ProfileResultViewModel extends AndroidViewModel {
    private ApiService apiService;
    private CompositeDisposable compositeDisposable;
    private Context context;

    public ProfileResultViewModel(@NonNull Application application) {
        super(application);
        this.context = application;
        apiService = ApiClient.getClient(application)
                .create(ApiService.class);
        compositeDisposable = new CompositeDisposable();
    }

    public LiveData<ProfileResultBean> getProfileData(ProfileBean profileBean) {
        MutableLiveData<ProfileResultBean> profileResultBeanMutableLiveData = new MutableLiveData<>();
        ProfileResultBean profileResultBean = new ProfileResultBean();
        String personEmail = null;
        String personTelephone = null;
        String personMobile = null;
        String personUserName = null;
        String personAddress = null;
        Bitmap imgBitMap = null;

        if (profileBean.getData().getPerson() != null) {

            //            get Address
            String imgId = null;
            if (profileBean.getData().getPerson().getPersonImage().size() == 1) {
                imgId = profileBean.getData().getPerson().getPersonImage().get(0).getImageId();
            } else if (profileBean.getData().getPerson().getPersonImage().size() > 1) {
                for (int i = 0; i < profileBean.getData().getPerson().getPersonImage().size(); i++) {
                    if (profileBean.getData().getPerson().getPersonImage().get(i).isDefault()) {
                        imgId = profileBean.getData().getPerson().getPersonImage().get(i).getImageId();
                    }
                }
            } else if (profileBean.getData().getPerson().getPersonImage().size() > 0) {
                imgId = profileBean.getData().getPerson().getPersonImage().get(0).getImageId();
            }

            if (imgId != null) {
                String img = PersonImage(profileBean.getData().getPersonImage(), imgId);
                if (img != null) {
                    imgBitMap = ImageFromBase64(img);
                }
            }

//      get person email
            if (profileBean.getData().getPerson().getPersonEmail().size() == 1) {
                personEmail = checkIsNotNull(profileBean.getData().getPerson().getPersonEmail().get(0).getEmailAddress());
            } else if (profileBean.getData().getPerson().getPersonEmail().size() > 1) {
                for (int i = 0; i < profileBean.getData().getPerson().getPersonEmail().size(); i++) {
                    if (profileBean.getData().getPerson().getPersonEmail().get(i).getIsDefaultEmail())
                        personEmail = checkIsNotNull(profileBean.getData().getPerson().getPersonEmail().get(i).getEmailAddress());
                }
            } else if (profileBean.getData().getPerson().getPersonEmail().size() > 0) {
                personEmail = checkIsNotNull(profileBean.getData().getPerson().getPersonEmail().get(0).getEmailAddress());
            }


//      get person number
            if (profileBean.getData().getPerson().getPersonPhone().size() == 1) {

                personMobile = "+" + profileBean.getData().getPerson().getPersonPhone().get(0).getCountryTelephonePrefix() + " " +
                        profileBean.getData().getPerson().getPersonPhone().get(0).getPhoneNumber();
                personTelephone = profileBean.getData().getPerson().getPersonPhone().get(0).getPhoneTypeName() + ":";
            } else if (profileBean.getData().getPerson().getPersonPhone().size() > 1) {
                for (int i = 0; i < profileBean.getData().getPerson().getPersonPhone().size(); i++) {
                    if (profileBean.getData().getPerson().getPersonPhone().get(i).getIsDefaultPhone()) {
                        personMobile = "+" + profileBean.getData().getPerson().getPersonPhone().get(0).getCountryTelephonePrefix() + " " +
                                profileBean.getData().getPerson().getPersonPhone().get(0).getPhoneNumber();
                        personTelephone = profileBean.getData().getPerson().getPersonPhone().get(0).getPhoneTypeName() + ":";
                    }
                }
            } else if (profileBean.getData().getPerson().getPersonPhone().size() > 0) {
                personMobile = "+" + profileBean.getData().getPerson().getPersonPhone().get(0).getCountryTelephonePrefix() + " " +
                        profileBean.getData().getPerson().getPersonPhone().get(0).getPhoneNumber();
                personTelephone = profileBean.getData().getPerson().getPersonPhone().get(0).getPhoneTypeName() + ":";
            }

//           get user name
            personUserName = checkIsNotNull(profileBean.getData().getPerson().getFirstName())
                    + " " + checkIsNotNull(profileBean.getData().getPerson().getMaidenName())
                    + " " + checkIsNotNull(profileBean.getData().getPerson().getSurName());

//            get Address
            int addressId = -1;
            if (profileBean.getData().getPerson().getPersonAddress().size() == 1) {
                addressId = profileBean.getData().getPerson().getPersonAddress().get(0).getAddressId();
            } else if (profileBean.getData().getPerson().getPersonAddress().size() > 1) {
                for (int i = 0; i < profileBean.getData().getPerson().getPersonAddress().size(); i++) {
                    if (profileBean.getData().getPerson().getPersonAddress().get(i).getIsDefaultAddress()) {
                        addressId = profileBean.getData().getPerson().getPersonAddress().get(i).getAddressId();
                    }
                }
            } else if (profileBean.getData().getPerson().getPersonAddress().size() > 0) {
                addressId = profileBean.getData().getPerson().getPersonAddress().get(0).getAddressId();
            }
            if (addressId != -1) {
                personAddress = PersonAddress(profileBean.getData().getPersonAddresses(), addressId);
            }


            profileResultBean.setEmail(personEmail != null ? personEmail : context.getString(R.string.no_data_available));
            profileResultBean.setTelephone(personTelephone != null ? personTelephone : context.getString(R.string.no_data_available));
            profileResultBean.setMobile(personMobile != null ? personMobile : context.getString(R.string.no_data_available));
            profileResultBean.setUserName(personUserName != null &&
                    !personUserName.equalsIgnoreCase("null")
                    && !personUserName.equalsIgnoreCase("") ? personUserName : context.getString(R.string.no_data_available));
            profileResultBean.setAddress(personAddress != null &&
                    !personAddress.equalsIgnoreCase("null")
                    && !personAddress.equalsIgnoreCase("") ? personAddress : context.getString(R.string.no_data_available));
            profileResultBean.setImgUrl(imgBitMap);
            profileResultBeanMutableLiveData.setValue(profileResultBean);

        }
//        Organisation Name
//        Building Number
//        Building Name
//        Sub Building Name
//        Street Address
//        Town
//                County
//        Postal code
//        Country

        return profileResultBeanMutableLiveData;
    }

    private String PersonImage(List<PersonImage> personImage, String imgId) {
        String personImageBase = null;
        for (int i = 0; i < personImage.size(); i++) {
            if (personImage.get(i).getImageId().equalsIgnoreCase(imgId)) {
                personImageBase = personImage.get(i).getImageHexString();

            }
        }
        return personImageBase;
    }


    private String PersonAddress(List<PersonAddress_> personAddresses, int addressId) {
        String personAddress = "";
        if (personAddresses != null) {
            for (int i = 0; i < personAddresses.size(); i++) {
                PersonAddress_ profileAddressData = personAddresses.get(i);
                if (profileAddressData.getAddress().getAddressId() == addressId) {
                    personAddress = checkIsNotNull(profileAddressData.getAddress().getOrganisationName()) + " " +
                            checkIsNotNull(profileAddressData.getAddress().getBuildingNumber()) + " " +
                            checkIsNotNull(profileAddressData.getAddress().getBuildingName()) + " " +
                            checkIsNotNull(profileAddressData.getAddress().getSubBuildingName()) + " " +
                            checkIsNotNull(profileAddressData.getAddress().getStreetName()) + " " +
                            checkIsNotNull(profileAddressData.getAddress().getPostCodeName()) + " " +
                            checkIsNotNull(profileAddressData.getAddress().getCountryName());
                }

            }
        }
        return personAddress;
    }

    private Bitmap ImageFromBase64(String img) {
        byte[] decodedString = Base64.decode(img, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
    }

    public LiveData<ProfileBean> getClientData(String personId, String customerId, String branchId) {
        final MutableLiveData<ProfileBean> data = new MutableLiveData<>();

        Disposable disposable = apiService.getProfile(personId, customerId, branchId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Response<ProfileBean>>() {
                    @Override
                    public void accept(Response<ProfileBean> loginBeanRetroResponse) throws Exception {
                        Log.e("LoginSuccess", "success");
                        if (loginBeanRetroResponse.isSuccessful()) {
                            data.setValue(loginBeanRetroResponse.body());
                        } else {
                            data.setValue(null);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e("LoginSuccess", "error" + throwable.toString());
                        data.setValue(null);
                    }
                });
        compositeDisposable.add(disposable);
        return data;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }

    private String checkIsNotNull(String value) {
        return value != null ? value : "";
    }
}
