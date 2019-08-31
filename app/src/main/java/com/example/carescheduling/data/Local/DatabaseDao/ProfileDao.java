package com.example.carescheduling.data.Local.DatabaseDao;

import com.example.carescheduling.Ui.Dashboard.beans.ProfileResultBean;
import com.example.carescheduling.Ui.Profile.bean.EditAllAddressData;
import com.example.carescheduling.Ui.Profile.bean.EditProfileInfoBean;
import com.example.carescheduling.Ui.Profile.bean.FragmentChangePasswordBean;
import com.example.carescheduling.data.Local.DatabaseTable.AddressAllData;
import com.example.carescheduling.data.Local.DatabaseTable.AddressType;
import com.example.carescheduling.data.Local.DatabaseTable.CountryCode;
import com.example.carescheduling.data.Local.DatabaseTable.DisabilityType;
import com.example.carescheduling.data.Local.DatabaseTable.EmailType;
import com.example.carescheduling.data.Local.DatabaseTable.Ethnicity;
import com.example.carescheduling.data.Local.DatabaseTable.Gender;
import com.example.carescheduling.data.Local.DatabaseTable.MaritialStatus;
import com.example.carescheduling.data.Local.DatabaseTable.Nationality;
import com.example.carescheduling.data.Local.DatabaseTable.PersonLanguage;
import com.example.carescheduling.data.Local.DatabaseTable.PhoneType;
import com.example.carescheduling.data.Local.DatabaseTable.Prefix;
import com.example.carescheduling.data.Local.DatabaseTable.ProfileInfo;
import com.example.carescheduling.data.Local.DatabaseTable.ProfileMainData;
import com.example.carescheduling.data.Local.DatabaseTable.Religion;
import com.example.carescheduling.data.Local.DatabaseTable.SexualityType;
import com.example.carescheduling.data.Local.DatabaseTable.UserInfo;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface ProfileDao {
    //   Get All  language
    @Query("SELECT * FROM person_language")
    List<PersonLanguage> getAllLanguages();

    //   Get All  RoomDatabaseModel
    @Query("SELECT * FROM Ethnicity")
    List<Ethnicity> getAllEthnicity();

    //   Get All  Gender
    @Query("SELECT * FROM gender")
    List<Gender> getAllGender();

    //   Get All  Maritial Status
    @Query("SELECT * FROM maritial_status")
    List<MaritialStatus> getAllMaritialStatus();

    //   Get All  Nationality
    @Query("SELECT * FROM Nationality")
    List<Nationality> getAllNationality();

    //   Get All  Prefix
    @Query("SELECT * FROM prefix")
    List<Prefix> getAllPrefix();

    //   Get All  Religion
    @Query("SELECT * FROM Religion")
    List<Religion> getAllReligion();

    //   Get All  DisabilityType
    @Query("SELECT * FROM DisabilityType")
    List<DisabilityType> getAllDisabilityType();

    //   Get All  SexualityType
    @Query("SELECT * FROM SexualityType")
    List<SexualityType> getAllSexualityType();

    //   Get All  CountryCode
    @Query("SELECT * FROM CountryCode")
    List<CountryCode> getAllCountryCode();

    //   Get All  phoneType
    @Query("SELECT * FROM PhoneType")
    List<PhoneType> getAllPhoneType();

    //   Get All  address type
    @Query("SELECT * FROM AddressType")
    List<AddressType> getAllAddressType();

    //   Get All  EmailType
    @Query("SELECT * FROM EmailType")
    List<EmailType> getAllEmailType();

    //    //   Get All  ProfileResultBean
    @Query("SELECT * FROM ProfileMainData")
    LiveData<ProfileMainData> getAllProfileMainData();

//    //   Get All  EditProfileInfoBean
    @Query("SELECT * FROM ProfileInfo")
    LiveData<ProfileInfo> getAllProfileInfo();


////    //   Get All  EditAllAddressData
//    @Query("SELECT * FROM AddressAllData")
//    LiveData<AddressAllData> getAllAddressAllData();

//    //   Get All   FragmentChangePasswordBean
    @Query("SELECT * FROM user_info")
    LiveData<UserInfo> getAllUserInfo();

//    @Query("SELECT * FROM user where first_name LIKE  :firstName AND last_name LIKE :lastName")
//    User findByName(String firstName, String lastName);

    //    get languages count
    @Query("SELECT COUNT(*) from person_language")
    int countLanguages();

    //    get RoomDatabaseModel count
    @Query("SELECT COUNT(*) from Ethnicity")
    int countEthnicity();

    //    get Gender count
    @Query("SELECT COUNT(*) from gender")
    int countGender();

    //    get Maritial Status count
    @Query("SELECT COUNT(*) from maritial_status")
    int countMaritialStatus();

    //    get Nationality count
    @Query("SELECT COUNT(*) from Nationality")
    int countNationality();

    //    get Prefix count
    @Query("SELECT COUNT(*) from prefix")
    int countPrefix();

    //    get Religion count
    @Query("SELECT COUNT(*) from Religion")
    int countReligion();

    // get all DisabilityType
    @Query("SELECT COUNT(*) from DisabilityType")
    int countDisabilityType();

    // get all DisabilityType
    @Query("SELECT COUNT(*) from SexualityType")
    int countSexualityType();

    // get all CountryCode
    @Query("SELECT COUNT(*) from CountryCode")
    int countCountryCode();

    // get all phone Type
    @Query("SELECT COUNT(*) from PhoneType")
    int countPhoneType();

    // get all AddressType
    @Query("SELECT COUNT(*) from AddressType")
    int countAddressType();

    // get all EmailType
    @Query("SELECT COUNT(*) from EmailType")
    int countEmailType();

   //   Get All  ProfileResultBean
    @Query("SELECT COUNT(*)  FROM ProfileInfo")
    int countProfileInfo();

//       Get All  EditProfileInfoBean
    @Query("SELECT COUNT(*)  FROM ProfileMainData")
    int countProfileMainData();

    //   Get All  EditAllAddressData
//    @Query("SELECT COUNT(*)  FROM AddressAllData")
//    int countAddressAllData();

//       Get All  FragmentChangePasswordBean
    @Query("SELECT COUNT(*)  FROM user_info")
    int countUserInfo();


    //    insert all Languages
    @Insert
    void insertAllLanguage(PersonLanguage... personLanguages);

    //    insert all RoomDatabaseModel
    @Insert
    void insertAllEthnicity(Ethnicity... personLanguages);

    //    insert all Gender
    @Insert
    void insertAllGender(Gender... personLanguages);

    //    insert all Maritial Status
    @Insert
    void insertAllMaritialStatus(MaritialStatus... personLanguages);

    //    insert all Nationality
    @Insert
    void insertAllNationality(Nationality... personLanguages);

    //    insert all Prefix
    @Insert
    void insertAllPrefix(Prefix... personLanguages);

    //    insert all Religion
    @Insert
    void insertAllReligion(Religion... personLanguages);

    // insert all DisabilityType
    @Insert
    void insertAllDisabilityType(DisabilityType... personLanguages);

    // insert all SexualityType
    @Insert
    void insertAllSexualityType(SexualityType... personLanguages);

    // insert all CountryCode
    @Insert
    void insertAllCountryCode(CountryCode... personLanguages);

    // insert all phone type
    @Insert
    void insertAllPhoneType(PhoneType... personLanguages);

    // insert all AddressType
    @Insert
    void insertAllAddressType(AddressType... personLanguages);

    // insert all EmailType
    @Insert
    void insertAllEmailType(EmailType... personLanguages);

//    insert All  ProfileResultBean
    @Insert
    void insertProfileInfo(ProfileInfo profileResultBean);
    //   insert All  EditProfileInfoBean
    @Insert
    void insertProfileMainData(ProfileMainData editProfileInfoBean);

//    @Insert
//    void insertAddressAllData(AddressAllData editAllAddressData);
    @Insert
    void insertUserInfo(UserInfo editAllAddressData);


    @Delete
    void delete(PersonLanguage user);

    // delete all language
    @Query("DELETE  FROM person_language")
    public void deleteAll();

    // delete all RoomDatabaseModel
    @Query("DELETE  FROM Ethnicity")
    public void deleteAllEthnicity();

    // delete all Gender
    @Query("DELETE  FROM gender")
    public void deleteAllGender();

    // delete all Nationality
    @Query("DELETE  FROM Nationality")
    public void deleteAllNationality();

    // delete all MaritialStatus
    @Query("DELETE  FROM maritial_status")
    public void deleteAllMaritialStatus();

    // delete all Prefix
    @Query("DELETE  FROM prefix")
    public void deleteAllPrefix();

    // delete all Religion
    @Query("DELETE  FROM Religion")
    public void deleteAllReligion();

    // delete all DisabilityType
    @Query("DELETE  FROM DisabilityType")
    public void deleteAllDisabilityType();

    // delete all SexualityType
    @Query("DELETE  FROM SexualityType")
    public void deleteAllSexualityType();

    // delete all CountryCode
    @Query("DELETE  FROM CountryCode")
    public void deleteAllCountryCode();

    // delete all phoneType
    @Query("DELETE  FROM PhoneType")
    public void deleteAllPhoneType();

    // delete all AddressType
    @Query("DELETE  FROM AddressType")
    public void deleteAllAddressType();

    // delete all EmailType
    @Query("DELETE  FROM EmailType")
    public void deleteAllEmailType();

//    //   Get All  ProfileResultBean
    @Query("DELETE  FROM ProfileInfo")
    public void deleteProfileInfo();

    //   Get All  EditProfileInfoBean
    @Query("DELETE  FROM ProfileMainData")
    public void deleteProfileMainData();

    //   Get All  EditAllAddressData
//    @Query("DELETE  FROM AddressAllData")
//    public void deleteAddressAllData();

    //   Get All  FragmentChangePasswordBean
    @Query("DELETE  FROM user_info")
    public void deleteUserInfo();

}
