package com.example.carescheduling.Ui.HomeScreen.beans;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
public class ClientCarePersonalDetailsBean {

    @SerializedName("Data")
    @Expose
    private Data data;
    @SerializedName("DataList")
    @Expose
    private Object dataList;
    @SerializedName("Exception")
    @Expose
    private Object exception;
    @SerializedName("ResponseMessage")
    @Expose
    private Object responseMessage;
    @SerializedName("Success")
    @Expose
    private Boolean success;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Object getDataList() {
        return dataList;
    }

    public void setDataList(Object dataList) {
        this.dataList = dataList;
    }

    public Object getException() {
        return exception;
    }

    public void setException(Object exception) {
        this.exception = exception;
    }

    public Object getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(Object responseMessage) {
        this.responseMessage = responseMessage;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public class Data {

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
        private Object maidenName;
        @SerializedName("MiddleName")
        @Expose
        private Object middleName;
        @SerializedName("PersonAddedDate")
        @Expose
        private String personAddedDate;
        @SerializedName("PersonAddress")
        @Expose
        private List<PersonAddress> personAddress = null;
        @SerializedName("PersonBlacklistedDate")
        @Expose
        private Object personBlacklistedDate;
        @SerializedName("PersonDisability")
        @Expose
        private List<Object> personDisability = null;
        @SerializedName("PersonDynamicProperty")
        @Expose
        private List<Object> personDynamicProperty = null;
        @SerializedName("PersonEmail")
        @Expose
        private List<PersonEmail> personEmail = null;
        @SerializedName("PersonEthnicity")
        @Expose
        private List<Object> personEthnicity = null;
        @SerializedName("PersonId")
        @Expose
        private String personId;
        @SerializedName("PersonImage")
        @Expose
        private List<Object> personImage = null;
        @SerializedName("PersonIsBlacklisted")
        @Expose
        private Boolean personIsBlacklisted;
        @SerializedName("PersonLanguage")
        @Expose
        private List<PersonLanguage> personLanguage = null;
        @SerializedName("PersonLanguageCode")
        @Expose
        private List<PersonLanguageCode> personLanguageCode = null;
        @SerializedName("PersonMaritalStatus")
        @Expose
        private List<Object> personMaritalStatus = null;
        @SerializedName("PersonMessage")
        @Expose
        private Object personMessage;
        @SerializedName("PersonNationality")
        @Expose
        private List<PersonNationality> personNationality = null;
        @SerializedName("PersonPhone")
        @Expose
        private List<PersonPhone> personPhone = null;
        @SerializedName("PersonReligion")
        @Expose
        private List<Object> personReligion = null;
        @SerializedName("PersonSexuality")
        @Expose
        private List<Object> personSexuality = null;
        @SerializedName("PreferredName")
        @Expose
        private String preferredName;
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

        public Object getMaidenName() {
            return maidenName;
        }

        public void setMaidenName(Object maidenName) {
            this.maidenName = maidenName;
        }

        public Object getMiddleName() {
            return middleName;
        }

        public void setMiddleName(Object middleName) {
            this.middleName = middleName;
        }

        public String getPersonAddedDate() {
            return personAddedDate;
        }

        public void setPersonAddedDate(String personAddedDate) {
            this.personAddedDate = personAddedDate;
        }

        public List<PersonAddress> getPersonAddress() {
            return personAddress;
        }

        public void setPersonAddress(List<PersonAddress> personAddress) {
            this.personAddress = personAddress;
        }

        public Object getPersonBlacklistedDate() {
            return personBlacklistedDate;
        }

        public void setPersonBlacklistedDate(Object personBlacklistedDate) {
            this.personBlacklistedDate = personBlacklistedDate;
        }

        public List<Object> getPersonDisability() {
            return personDisability;
        }

        public void setPersonDisability(List<Object> personDisability) {
            this.personDisability = personDisability;
        }

        public List<Object> getPersonDynamicProperty() {
            return personDynamicProperty;
        }

        public void setPersonDynamicProperty(List<Object> personDynamicProperty) {
            this.personDynamicProperty = personDynamicProperty;
        }

        public List<PersonEmail> getPersonEmail() {
            return personEmail;
        }

        public void setPersonEmail(List<PersonEmail> personEmail) {
            this.personEmail = personEmail;
        }

        public List<Object> getPersonEthnicity() {
            return personEthnicity;
        }

        public void setPersonEthnicity(List<Object> personEthnicity) {
            this.personEthnicity = personEthnicity;
        }

        public String getPersonId() {
            return personId;
        }

        public void setPersonId(String personId) {
            this.personId = personId;
        }

        public List<Object> getPersonImage() {
            return personImage;
        }

        public void setPersonImage(List<Object> personImage) {
            this.personImage = personImage;
        }

        public Boolean getPersonIsBlacklisted() {
            return personIsBlacklisted;
        }

        public void setPersonIsBlacklisted(Boolean personIsBlacklisted) {
            this.personIsBlacklisted = personIsBlacklisted;
        }

        public List<PersonLanguage> getPersonLanguage() {
            return personLanguage;
        }

        public void setPersonLanguage(List<PersonLanguage> personLanguage) {
            this.personLanguage = personLanguage;
        }

        public List<PersonLanguageCode> getPersonLanguageCode() {
            return personLanguageCode;
        }

        public void setPersonLanguageCode(List<PersonLanguageCode> personLanguageCode) {
            this.personLanguageCode = personLanguageCode;
        }

        public List<Object> getPersonMaritalStatus() {
            return personMaritalStatus;
        }

        public void setPersonMaritalStatus(List<Object> personMaritalStatus) {
            this.personMaritalStatus = personMaritalStatus;
        }

        public Object getPersonMessage() {
            return personMessage;
        }

        public void setPersonMessage(Object personMessage) {
            this.personMessage = personMessage;
        }

        public List<PersonNationality> getPersonNationality() {
            return personNationality;
        }

        public void setPersonNationality(List<PersonNationality> personNationality) {
            this.personNationality = personNationality;
        }

        public List<PersonPhone> getPersonPhone() {
            return personPhone;
        }

        public void setPersonPhone(List<PersonPhone> personPhone) {
            this.personPhone = personPhone;
        }

        public List<Object> getPersonReligion() {
            return personReligion;
        }

        public void setPersonReligion(List<Object> personReligion) {
            this.personReligion = personReligion;
        }

        public List<Object> getPersonSexuality() {
            return personSexuality;
        }

        public void setPersonSexuality(List<Object> personSexuality) {
            this.personSexuality = personSexuality;
        }

        public String getPreferredName() {
            return preferredName;
        }

        public void setPreferredName(String preferredName) {
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

    public class PersonAddress {

        @SerializedName("AddressId")
        @Expose
        private Integer addressId;
        @SerializedName("AddressTypeName")
        @Expose
        private String addressTypeName;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("IsDefaultAddress")
        @Expose
        private Boolean isDefaultAddress;
        @SerializedName("PersonId")
        @Expose
        private String personId;

        public Integer getAddressId() {
            return addressId;
        }

        public void setAddressId(Integer addressId) {
            this.addressId = addressId;
        }

        public String getAddressTypeName() {
            return addressTypeName;
        }

        public void setAddressTypeName(String addressTypeName) {
            this.addressTypeName = addressTypeName;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public Boolean getIsDefaultAddress() {
            return isDefaultAddress;
        }

        public void setIsDefaultAddress(Boolean isDefaultAddress) {
            this.isDefaultAddress = isDefaultAddress;
        }

        public String getPersonId() {
            return personId;
        }

        public void setPersonId(String personId) {
            this.personId = personId;
        }

    }

    public class PersonEmail {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("EmailAddress")
        @Expose
        private String emailAddress;
        @SerializedName("EmailTypeName")
        @Expose
        private String emailTypeName;
        @SerializedName("IsDefaultEmail")
        @Expose
        private Boolean isDefaultEmail;
        @SerializedName("PersonId")
        @Expose
        private String personId;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getEmailAddress() {
            return emailAddress;
        }

        public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
        }

        public String getEmailTypeName() {
            return emailTypeName;
        }

        public void setEmailTypeName(String emailTypeName) {
            this.emailTypeName = emailTypeName;
        }

        public Boolean getIsDefaultEmail() {
            return isDefaultEmail;
        }

        public void setIsDefaultEmail(Boolean isDefaultEmail) {
            this.isDefaultEmail = isDefaultEmail;
        }

        public String getPersonId() {
            return personId;
        }

        public void setPersonId(String personId) {
            this.personId = personId;
        }

    }

    public class PersonLanguage {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("IsDefaultLanguage")
        @Expose
        private Boolean isDefaultLanguage;
        @SerializedName("LanguageName")
        @Expose
        private String languageName;
        @SerializedName("PersonId")
        @Expose
        private String personId;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public Boolean getIsDefaultLanguage() {
            return isDefaultLanguage;
        }

        public void setIsDefaultLanguage(Boolean isDefaultLanguage) {
            this.isDefaultLanguage = isDefaultLanguage;
        }

        public String getLanguageName() {
            return languageName;
        }

        public void setLanguageName(String languageName) {
            this.languageName = languageName;
        }

        public String getPersonId() {
            return personId;
        }

        public void setPersonId(String personId) {
            this.personId = personId;
        }

    }

    public class PersonLanguageCode {

        @SerializedName("CountryName")
        @Expose
        private String countryName;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("IsDefaultLanguageCode")
        @Expose
        private Boolean isDefaultLanguageCode;
        @SerializedName("LanguageCodeName")
        @Expose
        private String languageCodeName;
        @SerializedName("PersonId")
        @Expose
        private String personId;

        public String getCountryName() {
            return countryName;
        }

        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public Boolean getIsDefaultLanguageCode() {
            return isDefaultLanguageCode;
        }

        public void setIsDefaultLanguageCode(Boolean isDefaultLanguageCode) {
            this.isDefaultLanguageCode = isDefaultLanguageCode;
        }

        public String getLanguageCodeName() {
            return languageCodeName;
        }

        public void setLanguageCodeName(String languageCodeName) {
            this.languageCodeName = languageCodeName;
        }

        public String getPersonId() {
            return personId;
        }

        public void setPersonId(String personId) {
            this.personId = personId;
        }

    }

    public class PersonNationality {

        @SerializedName("CountryName")
        @Expose
        private String countryName;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("PersonId")
        @Expose
        private String personId;

        public String getCountryName() {
            return countryName;
        }

        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getPersonId() {
            return personId;
        }

        public void setPersonId(String personId) {
            this.personId = personId;
        }

    }

    public class PersonPhone {

        @SerializedName("CanNotCall")
        @Expose
        private Object canNotCall;
        @SerializedName("CountryTelephonePrefix")
        @Expose
        private String countryTelephonePrefix;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("IsDefaultPhone")
        @Expose
        private Boolean isDefaultPhone;
        @SerializedName("PersonId")
        @Expose
        private String personId;
        @SerializedName("PhoneNumber")
        @Expose
        private String phoneNumber;
        @SerializedName("PhoneTypeName")
        @Expose
        private String phoneTypeName;

        public Object getCanNotCall() {
            return canNotCall;
        }

        public void setCanNotCall(Object canNotCall) {
            this.canNotCall = canNotCall;
        }

        public String getCountryTelephonePrefix() {
            return countryTelephonePrefix;
        }

        public void setCountryTelephonePrefix(String countryTelephonePrefix) {
            this.countryTelephonePrefix = countryTelephonePrefix;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public Boolean getIsDefaultPhone() {
            return isDefaultPhone;
        }

        public void setIsDefaultPhone(Boolean isDefaultPhone) {
            this.isDefaultPhone = isDefaultPhone;
        }

        public String getPersonId() {
            return personId;
        }

        public void setPersonId(String personId) {
            this.personId = personId;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getPhoneTypeName() {
            return phoneTypeName;
        }

        public void setPhoneTypeName(String phoneTypeName) {
            this.phoneTypeName = phoneTypeName;
        }

    }

}


