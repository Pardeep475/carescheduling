package com.example.carescheduling.Ui.Dashboard.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Person implements Serializable {

    @SerializedName("BirthDate")
    @Expose
    private String birthDate;
    @SerializedName("CustomerId")
    @Expose
    private String customerId;
    @SerializedName("FirstName")
    @Expose
    private String firstName;
    @SerializedName("GenderTypeName")
    @Expose
    private String genderTypeName;
    @SerializedName("MaidenName")
    @Expose
    private String maidenName;
    @SerializedName("MiddleName")
    @Expose
    private String middleName;
    @SerializedName("PersonAddedDate")
    @Expose
    private String personAddedDate;
    @SerializedName("PersonAddress")
    @Expose
    private List<ProfileBean.PersonAddress> personAddress = null;
    @SerializedName("PersonBlacklistedDate")
    @Expose
    private Object personBlacklistedDate;
    @SerializedName("PersonDisability")
    @Expose
    private List<ProfileBean.PersonDisability> personDisability = null;
    @SerializedName("PersonDynamicProperty")
    @Expose
    private List<ProfileBean.PersonDynamicProperty> personDynamicProperty = null;
    @SerializedName("PersonEmail")
    @Expose
    private List<ProfileBean.PersonEmail> personEmail = null;
    @SerializedName("PersonEthnicity")
    @Expose
    private List<ProfileBean.PersonEthnicity> personEthnicity = null;
    @SerializedName("PersonId")
    @Expose
    private String personId;
    @SerializedName("PersonImage")
    @Expose
    private List<ProfileBean.PersonImage_> personImage = null;
    @SerializedName("PersonIsBlacklisted")
    @Expose
    private Boolean personIsBlacklisted;
    @SerializedName("PersonLanguage")
    @Expose
    private List<ProfileBean.PersonLanguage> personLanguage = null;
    @SerializedName("PersonLanguageCode")
    @Expose
    private List<ProfileBean.PersonLanguageCode> personLanguageCode = null;
    @SerializedName("PersonMaritalStatus")
    @Expose
    private List<ProfileBean.PersonMaritalstatus> personMaritalStatus = null;
    @SerializedName("PersonMessage")
    @Expose
    private Object personMessage;
    @SerializedName("PersonNationality")
    @Expose
    private List<ProfileBean.PersonNationality> personNationality = null;
    @SerializedName("PersonPhone")
    @Expose
    private List<PersonPhone> personPhone = null;
    @SerializedName("PersonReligion")
    @Expose
    private List<ProfileBean.PersonReligion> personReligion = null;
    @SerializedName("PersonSexuality")
    @Expose
    private List<ProfileBean.PersonSexuality> personSexuality = null;
    @SerializedName("PreferredName")
    @Expose
    private Object preferredName;
    @SerializedName("PrefixTypeName")
    @Expose
    private String prefixTypeName;
    @SerializedName("SurName")
    @Expose
    private String surName;

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGenderTypeName() {
        return genderTypeName;
    }

    public void setGenderTypeName(String genderTypeName) {
        this.genderTypeName = genderTypeName;
    }

    public String getMaidenName() {
        return maidenName;
    }

    public void setMaidenName(String maidenName) {
        this.maidenName = maidenName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPersonAddedDate() {
        return personAddedDate;
    }

    public void setPersonAddedDate(String personAddedDate) {
        this.personAddedDate = personAddedDate;
    }

    public List<ProfileBean.PersonAddress> getPersonAddress() {
        return personAddress;
    }

    public void setPersonAddress(List<ProfileBean.PersonAddress> personAddress) {
        this.personAddress = personAddress;
    }

    public Object getPersonBlacklistedDate() {
        return personBlacklistedDate;
    }

    public void setPersonBlacklistedDate(Object personBlacklistedDate) {
        this.personBlacklistedDate = personBlacklistedDate;
    }

    public List<ProfileBean.PersonDisability> getPersonDisability() {
        return personDisability;
    }

    public void setPersonDisability(List<ProfileBean.PersonDisability> personDisability) {
        this.personDisability = personDisability;
    }

    public List<ProfileBean.PersonDynamicProperty> getPersonDynamicProperty() {
        return personDynamicProperty;
    }

    public void setPersonDynamicProperty(List<ProfileBean.PersonDynamicProperty> personDynamicProperty) {
        this.personDynamicProperty = personDynamicProperty;
    }

    public List<ProfileBean.PersonEmail> getPersonEmail() {
        return personEmail;
    }

    public void setPersonEmail(List<ProfileBean.PersonEmail> personEmail) {
        this.personEmail = personEmail;
    }

    public List<ProfileBean.PersonEthnicity> getPersonEthnicity() {
        return personEthnicity;
    }

    public void setPersonEthnicity(List<ProfileBean.PersonEthnicity> personEthnicity) {
        this.personEthnicity = personEthnicity;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public List<ProfileBean.PersonImage_> getPersonImage() {
        return personImage;
    }

    public void setPersonImage(List<ProfileBean.PersonImage_> personImage) {
        this.personImage = personImage;
    }

    public Boolean getPersonIsBlacklisted() {
        return personIsBlacklisted;
    }

    public void setPersonIsBlacklisted(Boolean personIsBlacklisted) {
        this.personIsBlacklisted = personIsBlacklisted;
    }

    public List<ProfileBean.PersonLanguage> getPersonLanguage() {
        return personLanguage;
    }

    public void setPersonLanguage(List<ProfileBean.PersonLanguage> personLanguage) {
        this.personLanguage = personLanguage;
    }

    public List<ProfileBean.PersonLanguageCode> getPersonLanguageCode() {
        return personLanguageCode;
    }

    public void setPersonLanguageCode(List<ProfileBean.PersonLanguageCode> personLanguageCode) {
        this.personLanguageCode = personLanguageCode;
    }

    public List<ProfileBean.PersonMaritalstatus> getPersonMaritalStatus() {
        return personMaritalStatus;
    }

    public void setPersonMaritalStatus(List<ProfileBean.PersonMaritalstatus> personMaritalStatus) {
        this.personMaritalStatus = personMaritalStatus;
    }

    public Object getPersonMessage() {
        return personMessage;
    }

    public void setPersonMessage(Object personMessage) {
        this.personMessage = personMessage;
    }

    public List<ProfileBean.PersonNationality> getPersonNationality() {
        return personNationality;
    }

    public void setPersonNationality(List<ProfileBean.PersonNationality> personNationality) {
        this.personNationality = personNationality;
    }

    public List<PersonPhone> getPersonPhone() {
        return personPhone;
    }

    public void setPersonPhone(List<PersonPhone> personPhone) {
        this.personPhone = personPhone;
    }

    public List<ProfileBean.PersonReligion> getPersonReligion() {
        return personReligion;
    }

    public void setPersonReligion(List<ProfileBean.PersonReligion> personReligion) {
        this.personReligion = personReligion;
    }

    public List<ProfileBean.PersonSexuality> getPersonSexuality() {
        return personSexuality;
    }

    public void setPersonSexuality(List<ProfileBean.PersonSexuality> personSexuality) {
        this.personSexuality = personSexuality;
    }

    public Object getPreferredName() {
        return preferredName;
    }

    public void setPreferredName(Object preferredName) {
        this.preferredName = preferredName;
    }

    public String getPrefixTypeName() {
        return prefixTypeName;
    }

    public void setPrefixTypeName(String prefixTypeName) {
        this.prefixTypeName = prefixTypeName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

}
