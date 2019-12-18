package com.example.carescheduling.Ui.Dashboard.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class EditMyProfile {

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

        @SerializedName("CustomerAddressType")
        @Expose
        private ArrayList<CustomerAddressType> customerAddressType = null;
        @SerializedName("CustomerCountry")
        @Expose
        private ArrayList<CustomerCountry> customerCountry = null;
        @SerializedName("CustomerDisabilityType")
        @Expose
        private ArrayList<CustomerDisabilityType> customerDisabilityType = null;
        @SerializedName("CustomerEmailType")
        @Expose
        private ArrayList<CustomerEmailType> customerEmailType = null;
        @SerializedName("CustomerEthnicityGroup")
        @Expose
        private ArrayList<CustomerEthnicityGroup> customerEthnicityGroup = null;
        @SerializedName("CustomerEthnicityType")
        @Expose
        private ArrayList<CustomerEthnicityType> customerEthnicityType = null;
        @SerializedName("CustomerGender")
        @Expose
        private ArrayList<CustomerGender> customerGender = null;
        @SerializedName("CustomerLanguage")
        @Expose
        private ArrayList<CustomerLanguage> customerLanguage = null;
        @SerializedName("CustomerMaritalStatusType")
        @Expose
        private ArrayList<CustomerMaritalStatusType> customerMaritalStatusType = null;
        @SerializedName("CustomerPhoneType")
        @Expose
        private ArrayList<CustomerPhoneType> customerPhoneType = null;
        @SerializedName("CustomerPrefix")
        @Expose
        private ArrayList<CustomerPrefix> customerPrefix = null;
        @SerializedName("CustomerReligionType")
        @Expose
        private ArrayList<CustomerReligionType> customerReligionType = null;
        @SerializedName("CustomerSexualityType")
        @Expose
        private ArrayList<CustomerSexualityType> customerSexualityType = null;
        @SerializedName("CustomerTelephoneCountryPrefix")
        @Expose
        private ArrayList<CustomerTelephoneCountryPrefix> customerTelephoneCountryPrefix = null;
        @SerializedName("CustomerVisitIdentificationType")
        @Expose
        private ArrayList<CustomerVisitIdentificationType> customerVisitIdentificationType = null;
        @SerializedName("CustomerVisitRegistrationMethodType")
        @Expose
        private ArrayList<CustomerVisitRegistrationMethodType> customerVisitRegistrationMethodType = null;

        public ArrayList<CustomerAddressType> getCustomerAddressType() {
            return customerAddressType;
        }

        public void setCustomerAddressType(ArrayList<CustomerAddressType> customerAddressType) {
            this.customerAddressType = customerAddressType;
        }

        public ArrayList<CustomerCountry> getCustomerCountry() {
            return customerCountry;
        }

        public void setCustomerCountry(ArrayList<CustomerCountry> customerCountry) {
            this.customerCountry = customerCountry;
        }

        public ArrayList<CustomerDisabilityType> getCustomerDisabilityType() {
            return customerDisabilityType;
        }

        public void setCustomerDisabilityType(ArrayList<CustomerDisabilityType> customerDisabilityType) {
            this.customerDisabilityType = customerDisabilityType;
        }

        public ArrayList<CustomerEmailType> getCustomerEmailType() {
            return customerEmailType;
        }

        public void setCustomerEmailType(ArrayList<CustomerEmailType> customerEmailType) {
            this.customerEmailType = customerEmailType;
        }

        public ArrayList<CustomerEthnicityGroup> getCustomerEthnicityGroup() {
            return customerEthnicityGroup;
        }

        public void setCustomerEthnicityGroup(ArrayList<CustomerEthnicityGroup> customerEthnicityGroup) {
            this.customerEthnicityGroup = customerEthnicityGroup;
        }

        public ArrayList<CustomerEthnicityType> getCustomerEthnicityType() {
            return customerEthnicityType;
        }

        public void setCustomerEthnicityType(ArrayList<CustomerEthnicityType> customerEthnicityType) {
            this.customerEthnicityType = customerEthnicityType;
        }

        public ArrayList<CustomerGender> getCustomerGender() {
            return customerGender;
        }

        public void setCustomerGender(ArrayList<CustomerGender> customerGender) {
            this.customerGender = customerGender;
        }

        public ArrayList<CustomerLanguage> getCustomerLanguage() {
            return customerLanguage;
        }

        public void setCustomerLanguage(ArrayList<CustomerLanguage> customerLanguage) {
            this.customerLanguage = customerLanguage;
        }

        public ArrayList<CustomerMaritalStatusType> getCustomerMaritalStatusType() {
            return customerMaritalStatusType;
        }

        public void setCustomerMaritalStatusType(ArrayList<CustomerMaritalStatusType> customerMaritalStatusType) {
            this.customerMaritalStatusType = customerMaritalStatusType;
        }

        public ArrayList<CustomerPhoneType> getCustomerPhoneType() {
            return customerPhoneType;
        }

        public void setCustomerPhoneType(ArrayList<CustomerPhoneType> customerPhoneType) {
            this.customerPhoneType = customerPhoneType;
        }

        public ArrayList<CustomerPrefix> getCustomerPrefix() {
            return customerPrefix;
        }

        public void setCustomerPrefix(ArrayList<CustomerPrefix> customerPrefix) {
            this.customerPrefix = customerPrefix;
        }

        public ArrayList<CustomerReligionType> getCustomerReligionType() {
            return customerReligionType;
        }

        public void setCustomerReligionType(ArrayList<CustomerReligionType> customerReligionType) {
            this.customerReligionType = customerReligionType;
        }

        public ArrayList<CustomerSexualityType> getCustomerSexualityType() {
            return customerSexualityType;
        }

        public void setCustomerSexualityType(ArrayList<CustomerSexualityType> customerSexualityType) {
            this.customerSexualityType = customerSexualityType;
        }

        public ArrayList<CustomerTelephoneCountryPrefix> getCustomerTelephoneCountryPrefix() {
            return customerTelephoneCountryPrefix;
        }

        public void setCustomerTelephoneCountryPrefix(ArrayList<CustomerTelephoneCountryPrefix> customerTelephoneCountryPrefix) {
            this.customerTelephoneCountryPrefix = customerTelephoneCountryPrefix;
        }

        public ArrayList<CustomerVisitIdentificationType> getCustomerVisitIdentificationType() {
            return customerVisitIdentificationType;
        }

        public void setCustomerVisitIdentificationType(ArrayList<CustomerVisitIdentificationType> customerVisitIdentificationType) {
            this.customerVisitIdentificationType = customerVisitIdentificationType;
        }

        public ArrayList<CustomerVisitRegistrationMethodType> getCustomerVisitRegistrationMethodType() {
            return customerVisitRegistrationMethodType;
        }

        public void setCustomerVisitRegistrationMethodType(ArrayList<CustomerVisitRegistrationMethodType> customerVisitRegistrationMethodType) {
            this.customerVisitRegistrationMethodType = customerVisitRegistrationMethodType;
        }

    }
    public class CustomerAddressType {

        @SerializedName("AddressTypeName")
        @Expose
        private String addressTypeName;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;

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

    }
    public class CustomerCountry {

        @SerializedName("CountryName")
        @Expose
        private String countryName;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("IsDefault")
        @Expose
        private Boolean isDefault;

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

        public Boolean getIsDefault() {
            return isDefault;
        }

        public void setIsDefault(Boolean isDefault) {
            this.isDefault = isDefault;
        }

    }
    public class CustomerDisabilityType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("DisabilityTypeName")
        @Expose
        private String disabilityTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getDisabilityTypeName() {
            return disabilityTypeName;
        }

        public void setDisabilityTypeName(String disabilityTypeName) {
            this.disabilityTypeName = disabilityTypeName;
        }

    }
    public class CustomerEmailType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("EmailTypeName")
        @Expose
        private String emailTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getEmailTypeName() {
            return emailTypeName;
        }

        public void setEmailTypeName(String emailTypeName) {
            this.emailTypeName = emailTypeName;
        }

    }

    public class CustomerEthnicityGroup {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("EthnicityGroupName")
        @Expose
        private String ethnicityGroupName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getEthnicityGroupName() {
            return ethnicityGroupName;
        }

        public void setEthnicityGroupName(String ethnicityGroupName) {
            this.ethnicityGroupName = ethnicityGroupName;
        }

    }

    public class CustomerEthnicityType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("EthnicityTypeName")
        @Expose
        private String ethnicityTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getEthnicityTypeName() {
            return ethnicityTypeName;
        }

        public void setEthnicityTypeName(String ethnicityTypeName) {
            this.ethnicityTypeName = ethnicityTypeName;
        }

    }

    public class CustomerGender {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("GenderTypeName")
        @Expose
        private String genderTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getGenderTypeName() {
            return genderTypeName;
        }

        public void setGenderTypeName(String genderTypeName) {
            this.genderTypeName = genderTypeName;
        }

    }

    public class CustomerLanguage {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("LanguageName")
        @Expose
        private String languageName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getLanguageName() {
            return languageName;
        }

        public void setLanguageName(String languageName) {
            this.languageName = languageName;
        }

    }

    public class CustomerMaritalStatusType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("MaritalStatusTypeName")
        @Expose
        private String maritalStatusTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getMaritalStatusTypeName() {
            return maritalStatusTypeName;
        }

        public void setMaritalStatusTypeName(String maritalStatusTypeName) {
            this.maritalStatusTypeName = maritalStatusTypeName;
        }

    }

    public class CustomerPhoneType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("PhoneTypeName")
        @Expose
        private String phoneTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getPhoneTypeName() {
            return phoneTypeName;
        }

        public void setPhoneTypeName(String phoneTypeName) {
            this.phoneTypeName = phoneTypeName;
        }

    }
    public class CustomerPrefix {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("PrefixTypeName")
        @Expose
        private String prefixTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getPrefixTypeName() {
            return prefixTypeName;
        }

        public void setPrefixTypeName(String prefixTypeName) {
            this.prefixTypeName = prefixTypeName;
        }

    }

    public class CustomerReligionType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("ReligionTypeName")
        @Expose
        private String religionTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getReligionTypeName() {
            return religionTypeName;
        }

        public void setReligionTypeName(String religionTypeName) {
            this.religionTypeName = religionTypeName;
        }

    }

    public class CustomerSexualityType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("SexualityTypeName")
        @Expose
        private String sexualityTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getSexualityTypeName() {
            return sexualityTypeName;
        }

        public void setSexualityTypeName(String sexualityTypeName) {
            this.sexualityTypeName = sexualityTypeName;
        }

    }

    public class CustomerTelephoneCountryPrefix {

        @SerializedName("CountryTelephonePrefix")
        @Expose
        private String countryTelephonePrefix;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;

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

    }

    public class CustomerVisitIdentificationType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("VisitIdentificationTypeName")
        @Expose
        private String visitIdentificationTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getVisitIdentificationTypeName() {
            return visitIdentificationTypeName;
        }

        public void setVisitIdentificationTypeName(String visitIdentificationTypeName) {
            this.visitIdentificationTypeName = visitIdentificationTypeName;
        }

    }

    public class CustomerVisitRegistrationMethodType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("VisitRegistrationMethodTypeName")
        @Expose
        private String visitRegistrationMethodTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getVisitRegistrationMethodTypeName() {
            return visitRegistrationMethodTypeName;
        }

        public void setVisitRegistrationMethodTypeName(String visitRegistrationMethodTypeName) {
            this.visitRegistrationMethodTypeName = visitRegistrationMethodTypeName;
        }

    }


}