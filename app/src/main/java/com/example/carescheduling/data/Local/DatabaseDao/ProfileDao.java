package com.example.carescheduling.data.Local.DatabaseDao;

import com.example.carescheduling.data.Local.DatabaseTable.CountryCode;
import com.example.carescheduling.data.Local.DatabaseTable.DisabilityType;
import com.example.carescheduling.data.Local.DatabaseTable.Ethnicity;
import com.example.carescheduling.data.Local.DatabaseTable.Gender;
import com.example.carescheduling.data.Local.DatabaseTable.MaritialStatus;
import com.example.carescheduling.data.Local.DatabaseTable.Nationality;
import com.example.carescheduling.data.Local.DatabaseTable.PersonLanguage;
import com.example.carescheduling.data.Local.DatabaseTable.PhoneType;
import com.example.carescheduling.data.Local.DatabaseTable.Prefix;
import com.example.carescheduling.data.Local.DatabaseTable.Religion;
import com.example.carescheduling.data.Local.DatabaseTable.SexualityType;

import java.util.List;

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
}
