package com.example.carescheduling.Ui.HomeScreen.beans;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ClientCarePlan {
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


    public class ClientAllergyModel {

        @SerializedName("AllergyGroupName")
        @Expose
        private String allergyGroupName;
        @SerializedName("AllergyTypeName")
        @Expose
        private String allergyTypeName;
        @SerializedName("ClientAllergyAdded")
        @Expose
        private String clientAllergyAdded;
        @SerializedName("ClientPersonId")
        @Expose
        private String clientPersonId;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;

        public String getAllergyGroupName() {
            return allergyGroupName;
        }

        public void setAllergyGroupName(String allergyGroupName) {
            this.allergyGroupName = allergyGroupName;
        }

        public String getAllergyTypeName() {
            return allergyTypeName;
        }

        public void setAllergyTypeName(String allergyTypeName) {
            this.allergyTypeName = allergyTypeName;
        }

        public String getClientAllergyAdded() {
            return clientAllergyAdded;
        }

        public void setClientAllergyAdded(String clientAllergyAdded) {
            this.clientAllergyAdded = clientAllergyAdded;
        }

        public String getClientPersonId() {
            return clientPersonId;
        }

        public void setClientPersonId(String clientPersonId) {
            this.clientPersonId = clientPersonId;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

    }

    public class ClientContactModel {

        @SerializedName("ClientContactAdded")
        @Expose
        private String clientContactAdded;
        @SerializedName("ClientPersonId")
        @Expose
        private String clientPersonId;
        @SerializedName("CompanyId")
        @Expose
        private Object companyId;
        @SerializedName("ContactPersonId")
        @Expose
        private String contactPersonId;
        @SerializedName("ContactTypeName")
        @Expose
        private String contactTypeName;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("IsDefaultGp")
        @Expose
        private Boolean isDefaultGp;
        @SerializedName("IsNextOfKin")
        @Expose
        private Boolean isNextOfKin;

        public String getClientContactAdded() {
            return clientContactAdded;
        }

        public void setClientContactAdded(String clientContactAdded) {
            this.clientContactAdded = clientContactAdded;
        }

        public String getClientPersonId() {
            return clientPersonId;
        }

        public void setClientPersonId(String clientPersonId) {
            this.clientPersonId = clientPersonId;
        }

        public Object getCompanyId() {
            return companyId;
        }

        public void setCompanyId(Object companyId) {
            this.companyId = companyId;
        }

        public String getContactPersonId() {
            return contactPersonId;
        }

        public void setContactPersonId(String contactPersonId) {
            this.contactPersonId = contactPersonId;
        }

        public String getContactTypeName() {
            return contactTypeName;
        }

        public void setContactTypeName(String contactTypeName) {
            this.contactTypeName = contactTypeName;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public Boolean getIsDefaultGp() {
            return isDefaultGp;
        }

        public void setIsDefaultGp(Boolean isDefaultGp) {
            this.isDefaultGp = isDefaultGp;
        }

        public Boolean getIsNextOfKin() {
            return isNextOfKin;
        }

        public void setIsNextOfKin(Boolean isNextOfKin) {
            this.isNextOfKin = isNextOfKin;
        }

    }

    public class ClientContactModelList {

        @SerializedName("ClientContactAdded")
        @Expose
        private String clientContactAdded;
        @SerializedName("ClientPersonId")
        @Expose
        private String clientPersonId;
        @SerializedName("CompanyId")
        @Expose
        private Object companyId;
        @SerializedName("ContactPersonId")
        @Expose
        private String contactPersonId;
        @SerializedName("ContactTypeName")
        @Expose
        private String contactTypeName;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("IsDefaultGp")
        @Expose
        private Boolean isDefaultGp;
        @SerializedName("IsNextOfKin")
        @Expose
        private Boolean isNextOfKin;

        public String getClientContactAdded() {
            return clientContactAdded;
        }

        public void setClientContactAdded(String clientContactAdded) {
            this.clientContactAdded = clientContactAdded;
        }

        public String getClientPersonId() {
            return clientPersonId;
        }

        public void setClientPersonId(String clientPersonId) {
            this.clientPersonId = clientPersonId;
        }

        public Object getCompanyId() {
            return companyId;
        }

        public void setCompanyId(Object companyId) {
            this.companyId = companyId;
        }

        public String getContactPersonId() {
            return contactPersonId;
        }

        public void setContactPersonId(String contactPersonId) {
            this.contactPersonId = contactPersonId;
        }

        public String getContactTypeName() {
            return contactTypeName;
        }

        public void setContactTypeName(String contactTypeName) {
            this.contactTypeName = contactTypeName;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public Boolean getIsDefaultGp() {
            return isDefaultGp;
        }

        public void setIsDefaultGp(Boolean isDefaultGp) {
            this.isDefaultGp = isDefaultGp;
        }

        public Boolean getIsNextOfKin() {
            return isNextOfKin;
        }

        public void setIsNextOfKin(Boolean isNextOfKin) {
            this.isNextOfKin = isNextOfKin;
        }

    }

    public class ClientContactsPerson {

        @SerializedName("BirthDate")
        @Expose
        private Object birthDate;
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
        private List<PersonAddress_> personAddress = null;
        @SerializedName("PersonBlacklistedDate")
        @Expose
        private Object personBlacklistedDate;
        @SerializedName("PersonDisability")
        @Expose
        private List<Object> personDisability = null;
        @SerializedName("PersonDynamicProperty")
        @Expose
        private List<PersonDynamicProperty_> personDynamicProperty = null;
        @SerializedName("PersonEmail")
        @Expose
        private List<Object> personEmail = null;
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
        private Object personLanguage;
        @SerializedName("PersonLanguageCode")
        @Expose
        private Object personLanguageCode;
        @SerializedName("PersonMaritalStatus")
        @Expose
        private List<Object> personMaritalStatus = null;
        @SerializedName("PersonMessage")
        @Expose
        private Object personMessage;
        @SerializedName("PersonNationality")
        @Expose
        private List<PersonNationality_> personNationality = null;
        @SerializedName("PersonPhone")
        @Expose
        private List<PersonPhone_> personPhone = null;
        @SerializedName("PersonReligion")
        @Expose
        private List<Object> personReligion = null;
        @SerializedName("PersonSexuality")
        @Expose
        private List<Object> personSexuality = null;
        @SerializedName("PreferredName")
        @Expose
        private Object preferredName;
        @SerializedName("PrefixTypeName")
        @Expose
        private String prefixTypeName;
        @SerializedName("SurName")
        @Expose
        private String surName;

        public Object getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(Object birthDate) {
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

        public List<PersonAddress_> getPersonAddress() {
            return personAddress;
        }

        public void setPersonAddress(List<PersonAddress_> personAddress) {
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

        public List<PersonDynamicProperty_> getPersonDynamicProperty() {
            return personDynamicProperty;
        }

        public void setPersonDynamicProperty(List<PersonDynamicProperty_> personDynamicProperty) {
            this.personDynamicProperty = personDynamicProperty;
        }

        public List<Object> getPersonEmail() {
            return personEmail;
        }

        public void setPersonEmail(List<Object> personEmail) {
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

        public Object getPersonLanguage() {
            return personLanguage;
        }

        public void setPersonLanguage(Object personLanguage) {
            this.personLanguage = personLanguage;
        }

        public Object getPersonLanguageCode() {
            return personLanguageCode;
        }

        public void setPersonLanguageCode(Object personLanguageCode) {
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

        public List<PersonNationality_> getPersonNationality() {
            return personNationality;
        }

        public void setPersonNationality(List<PersonNationality_> personNationality) {
            this.personNationality = personNationality;
        }

        public List<PersonPhone_> getPersonPhone() {
            return personPhone;
        }

        public void setPersonPhone(List<PersonPhone_> personPhone) {
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

    public class ClientContractModel {

        @SerializedName("ClientContractId")
        @Expose
        private String clientContractId;
        @SerializedName("ClientContractLeighWay")
        @Expose
        private Integer clientContractLeighWay;
        @SerializedName("ClientContractTerminationPeriod")
        @Expose
        private Integer clientContractTerminationPeriod;
        @SerializedName("ClientPersonId")
        @Expose
        private String clientPersonId;
        @SerializedName("ContractedHours")
        @Expose
        private Double contractedHours;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("FollowFunderLeighWay")
        @Expose
        private Boolean followFunderLeighWay;
        @SerializedName("IsContractedHours")
        @Expose
        private Boolean isContractedHours;
        @SerializedName("PaymentFrequencyTypeName")
        @Expose
        private String paymentFrequencyTypeName;
        @SerializedName("TargetWeeklyHours")
        @Expose
        private Double targetWeeklyHours;

        public String getClientContractId() {
            return clientContractId;
        }

        public void setClientContractId(String clientContractId) {
            this.clientContractId = clientContractId;
        }

        public Integer getClientContractLeighWay() {
            return clientContractLeighWay;
        }

        public void setClientContractLeighWay(Integer clientContractLeighWay) {
            this.clientContractLeighWay = clientContractLeighWay;
        }

        public Integer getClientContractTerminationPeriod() {
            return clientContractTerminationPeriod;
        }

        public void setClientContractTerminationPeriod(Integer clientContractTerminationPeriod) {
            this.clientContractTerminationPeriod = clientContractTerminationPeriod;
        }

        public String getClientPersonId() {
            return clientPersonId;
        }

        public void setClientPersonId(String clientPersonId) {
            this.clientPersonId = clientPersonId;
        }

        public Double getContractedHours() {
            return contractedHours;
        }

        public void setContractedHours(Double contractedHours) {
            this.contractedHours = contractedHours;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public Boolean getFollowFunderLeighWay() {
            return followFunderLeighWay;
        }

        public void setFollowFunderLeighWay(Boolean followFunderLeighWay) {
            this.followFunderLeighWay = followFunderLeighWay;
        }

        public Boolean getIsContractedHours() {
            return isContractedHours;
        }

        public void setIsContractedHours(Boolean isContractedHours) {
            this.isContractedHours = isContractedHours;
        }

        public String getPaymentFrequencyTypeName() {
            return paymentFrequencyTypeName;
        }

        public void setPaymentFrequencyTypeName(String paymentFrequencyTypeName) {
            this.paymentFrequencyTypeName = paymentFrequencyTypeName;
        }

        public Double getTargetWeeklyHours() {
            return targetWeeklyHours;
        }

        public void setTargetWeeklyHours(Double targetWeeklyHours) {
            this.targetWeeklyHours = targetWeeklyHours;
        }

    }

    public class ClientFunderModel {

        @SerializedName("ClientFunderAdded")
        @Expose
        private String clientFunderAdded;
        @SerializedName("ClientPersonId")
        @Expose
        private String clientPersonId;
        @SerializedName("FunderId")
        @Expose
        private String funderId;
        @SerializedName("IsMainFunder")
        @Expose
        private Boolean isMainFunder;

        public String getClientFunderAdded() {
            return clientFunderAdded;
        }

        public void setClientFunderAdded(String clientFunderAdded) {
            this.clientFunderAdded = clientFunderAdded;
        }

        public String getClientPersonId() {
            return clientPersonId;
        }

        public void setClientPersonId(String clientPersonId) {
            this.clientPersonId = clientPersonId;
        }

        public String getFunderId() {
            return funderId;
        }

        public void setFunderId(String funderId) {
            this.funderId = funderId;
        }

        public Boolean getIsMainFunder() {
            return isMainFunder;
        }

        public void setIsMainFunder(Boolean isMainFunder) {
            this.isMainFunder = isMainFunder;
        }

    }

    public class ClientModel {

        @SerializedName("BriefHistory")
        @Expose
        private String briefHistory;
        @SerializedName("BriefOverview")
        @Expose
        private String briefOverview;
        @SerializedName("ClientAllergyModel")
        @Expose
        private List<ClientAllergyModel> clientAllergyModel = null;
        @SerializedName("ClientAreaModel")
        @Expose
        private List<Object> clientAreaModel = null;
        @SerializedName("ClientBarcodeModel")
        @Expose
        private List<Object> clientBarcodeModel = null;
        @SerializedName("ClientContactModel")
        @Expose
        private List<ClientContactModel> clientContactModel = null;
        @SerializedName("ClientContractModel")
        @Expose
        private List<ClientContractModel> clientContractModel = null;
        @SerializedName("ClientDisabillityModel")
        @Expose
        private List<Object> clientDisabillityModel = null;
        @SerializedName("ClientDocumentModel")
        @Expose
        private List<Object> clientDocumentModel = null;
        @SerializedName("ClientDynamicPropertyModel")
        @Expose
        private List<Object> clientDynamicPropertyModel = null;
        @SerializedName("ClientFunderModel")
        @Expose
        private List<ClientFunderModel> clientFunderModel = null;
        @SerializedName("ClientInterestModel")
        @Expose
        private List<Object> clientInterestModel = null;
        @SerializedName("ClientMessageModel")
        @Expose
        private List<Object> clientMessageModel = null;
        @SerializedName("ClientNFCModel")
        @Expose
        private List<Object> clientNFCModel = null;
        @SerializedName("ClientNoteModel")
        @Expose
        private List<Object> clientNoteModel = null;
        @SerializedName("ClientPersonId")
        @Expose
        private String clientPersonId;
        @SerializedName("ClientQualificationNeededModel")
        @Expose
        private List<Object> clientQualificationNeededModel = null;
        @SerializedName("ClientReviewModel")
        @Expose
        private List<Object> clientReviewModel = null;
        @SerializedName("ClientRunModel")
        @Expose
        private List<ClientRunModel> clientRunModel = null;
        @SerializedName("ClientSkillNeededModel")
        @Expose
        private List<Object> clientSkillNeededModel = null;
        @SerializedName("ClientTaskModel")
        @Expose
        private List<Object> clientTaskModel = null;
        @SerializedName("ClientTrainingNeededModel")
        @Expose
        private List<Object> clientTrainingNeededModel = null;
        @SerializedName("ClientTypeName")
        @Expose
        private String clientTypeName;
        @SerializedName("CustomerClientReference")
        @Expose
        private String customerClientReference;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;

        public String getBriefHistory() {
            return briefHistory;
        }

        public void setBriefHistory(String briefHistory) {
            this.briefHistory = briefHistory;
        }

        public String getBriefOverview() {
            return briefOverview;
        }

        public void setBriefOverview(String briefOverview) {
            this.briefOverview = briefOverview;
        }

        public List<ClientAllergyModel> getClientAllergyModel() {
            return clientAllergyModel;
        }

        public void setClientAllergyModel(List<ClientAllergyModel> clientAllergyModel) {
            this.clientAllergyModel = clientAllergyModel;
        }

        public List<Object> getClientAreaModel() {
            return clientAreaModel;
        }

        public void setClientAreaModel(List<Object> clientAreaModel) {
            this.clientAreaModel = clientAreaModel;
        }

        public List<Object> getClientBarcodeModel() {
            return clientBarcodeModel;
        }

        public void setClientBarcodeModel(List<Object> clientBarcodeModel) {
            this.clientBarcodeModel = clientBarcodeModel;
        }

        public List<ClientContactModel> getClientContactModel() {
            return clientContactModel;
        }

        public void setClientContactModel(List<ClientContactModel> clientContactModel) {
            this.clientContactModel = clientContactModel;
        }

        public List<ClientContractModel> getClientContractModel() {
            return clientContractModel;
        }

        public void setClientContractModel(List<ClientContractModel> clientContractModel) {
            this.clientContractModel = clientContractModel;
        }

        public List<Object> getClientDisabillityModel() {
            return clientDisabillityModel;
        }

        public void setClientDisabillityModel(List<Object> clientDisabillityModel) {
            this.clientDisabillityModel = clientDisabillityModel;
        }

        public List<Object> getClientDocumentModel() {
            return clientDocumentModel;
        }

        public void setClientDocumentModel(List<Object> clientDocumentModel) {
            this.clientDocumentModel = clientDocumentModel;
        }

        public List<Object> getClientDynamicPropertyModel() {
            return clientDynamicPropertyModel;
        }

        public void setClientDynamicPropertyModel(List<Object> clientDynamicPropertyModel) {
            this.clientDynamicPropertyModel = clientDynamicPropertyModel;
        }

        public List<ClientFunderModel> getClientFunderModel() {
            return clientFunderModel;
        }

        public void setClientFunderModel(List<ClientFunderModel> clientFunderModel) {
            this.clientFunderModel = clientFunderModel;
        }

        public List<Object> getClientInterestModel() {
            return clientInterestModel;
        }

        public void setClientInterestModel(List<Object> clientInterestModel) {
            this.clientInterestModel = clientInterestModel;
        }

        public List<Object> getClientMessageModel() {
            return clientMessageModel;
        }

        public void setClientMessageModel(List<Object> clientMessageModel) {
            this.clientMessageModel = clientMessageModel;
        }

        public List<Object> getClientNFCModel() {
            return clientNFCModel;
        }

        public void setClientNFCModel(List<Object> clientNFCModel) {
            this.clientNFCModel = clientNFCModel;
        }

        public List<Object> getClientNoteModel() {
            return clientNoteModel;
        }

        public void setClientNoteModel(List<Object> clientNoteModel) {
            this.clientNoteModel = clientNoteModel;
        }

        public String getClientPersonId() {
            return clientPersonId;
        }

        public void setClientPersonId(String clientPersonId) {
            this.clientPersonId = clientPersonId;
        }

        public List<Object> getClientQualificationNeededModel() {
            return clientQualificationNeededModel;
        }

        public void setClientQualificationNeededModel(List<Object> clientQualificationNeededModel) {
            this.clientQualificationNeededModel = clientQualificationNeededModel;
        }

        public List<Object> getClientReviewModel() {
            return clientReviewModel;
        }

        public void setClientReviewModel(List<Object> clientReviewModel) {
            this.clientReviewModel = clientReviewModel;
        }

        public List<ClientRunModel> getClientRunModel() {
            return clientRunModel;
        }

        public void setClientRunModel(List<ClientRunModel> clientRunModel) {
            this.clientRunModel = clientRunModel;
        }

        public List<Object> getClientSkillNeededModel() {
            return clientSkillNeededModel;
        }

        public void setClientSkillNeededModel(List<Object> clientSkillNeededModel) {
            this.clientSkillNeededModel = clientSkillNeededModel;
        }

        public List<Object> getClientTaskModel() {
            return clientTaskModel;
        }

        public void setClientTaskModel(List<Object> clientTaskModel) {
            this.clientTaskModel = clientTaskModel;
        }

        public List<Object> getClientTrainingNeededModel() {
            return clientTrainingNeededModel;
        }

        public void setClientTrainingNeededModel(List<Object> clientTrainingNeededModel) {
            this.clientTrainingNeededModel = clientTrainingNeededModel;
        }

        public String getClientTypeName() {
            return clientTypeName;
        }

        public void setClientTypeName(String clientTypeName) {
            this.clientTypeName = clientTypeName;
        }

        public String getCustomerClientReference() {
            return customerClientReference;
        }

        public void setCustomerClientReference(String customerClientReference) {
            this.customerClientReference = customerClientReference;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

    }

    public class ClientPerson {

        @SerializedName("AddressList")
        @Expose
        private Object addressList;
        @SerializedName("FunderCompanies")
        @Expose
        private Object funderCompanies;
        @SerializedName("FunderPersons")
        @Expose
        private List<Object> funderPersons = null;
        @SerializedName("Image")
        @Expose
        private Object image;
        @SerializedName("PersonAddresses")
        @Expose
        private List<Object> personAddresses = null;
        @SerializedName("PersonImages")
        @Expose
        private List<Object> personImages = null;
        @SerializedName("Persons")
        @Expose
        private Persons persons;

        public Object getAddressList() {
            return addressList;
        }

        public void setAddressList(Object addressList) {
            this.addressList = addressList;
        }

        public Object getFunderCompanies() {
            return funderCompanies;
        }

        public void setFunderCompanies(Object funderCompanies) {
            this.funderCompanies = funderCompanies;
        }

        public List<Object> getFunderPersons() {
            return funderPersons;
        }

        public void setFunderPersons(List<Object> funderPersons) {
            this.funderPersons = funderPersons;
        }

        public Object getImage() {
            return image;
        }

        public void setImage(Object image) {
            this.image = image;
        }

        public List<Object> getPersonAddresses() {
            return personAddresses;
        }

        public void setPersonAddresses(List<Object> personAddresses) {
            this.personAddresses = personAddresses;
        }

        public List<Object> getPersonImages() {
            return personImages;
        }

        public void setPersonImages(List<Object> personImages) {
            this.personImages = personImages;
        }

        public Persons getPersons() {
            return persons;
        }

        public void setPersons(Persons persons) {
            this.persons = persons;
        }

    }

    public class ClientRunModel {

        @SerializedName("BranchId")
        @Expose
        private String branchId;
        @SerializedName("ClientAddedBy")
        @Expose
        private String clientAddedBy;
        @SerializedName("ClientAddedByName")
        @Expose
        private Object clientAddedByName;
        @SerializedName("ClientAddedDate")
        @Expose
        private String clientAddedDate;
        @SerializedName("ClientName")
        @Expose
        private Object clientName;
        @SerializedName("ClientPersonId")
        @Expose
        private String clientPersonId;
        @SerializedName("RunName")
        @Expose
        private String runName;

        public String getBranchId() {
            return branchId;
        }

        public void setBranchId(String branchId) {
            this.branchId = branchId;
        }

        public String getClientAddedBy() {
            return clientAddedBy;
        }

        public void setClientAddedBy(String clientAddedBy) {
            this.clientAddedBy = clientAddedBy;
        }

        public Object getClientAddedByName() {
            return clientAddedByName;
        }

        public void setClientAddedByName(Object clientAddedByName) {
            this.clientAddedByName = clientAddedByName;
        }

        public String getClientAddedDate() {
            return clientAddedDate;
        }

        public void setClientAddedDate(String clientAddedDate) {
            this.clientAddedDate = clientAddedDate;
        }

        public Object getClientName() {
            return clientName;
        }

        public void setClientName(Object clientName) {
            this.clientName = clientName;
        }

        public String getClientPersonId() {
            return clientPersonId;
        }

        public void setClientPersonId(String clientPersonId) {
            this.clientPersonId = clientPersonId;
        }

        public String getRunName() {
            return runName;
        }

        public void setRunName(String runName) {
            this.runName = runName;
        }

    }

    public class ClientVM {

        @SerializedName("Barcode")
        @Expose
        private Object barcode;
        @SerializedName("Barcodes")
        @Expose
        private Object barcodes;
        @SerializedName("ClientCarePlan")
        @Expose
        private Object clientCarePlan;
        @SerializedName("ClientModel")
        @Expose
        private ClientModel clientModel;
        @SerializedName("ClientModelList")
        @Expose
        private Object clientModelList;
        @SerializedName("ClientNFCModelList")
        @Expose
        private Object clientNFCModelList;
        @SerializedName("ClientPerson")
        @Expose
        private ClientPerson clientPerson;
        @SerializedName("ClientPersons")
        @Expose
        private List<Object> clientPersons = null;
        @SerializedName("Company")
        @Expose
        private Object company;
        @SerializedName("CompanyList")
        @Expose
        private Object companyList;
        @SerializedName("FunderCompanies")
        @Expose
        private Object funderCompanies;
        @SerializedName("FunderPersons")
        @Expose
        private Object funderPersons;
        @SerializedName("HealthcareClientReference")
        @Expose
        private Object healthcareClientReference;
        @SerializedName("NFCVM")
        @Expose
        private Object nFCVM;
        @SerializedName("NFCVMList")
        @Expose
        private Object nFCVMList;

        public Object getBarcode() {
            return barcode;
        }

        public void setBarcode(Object barcode) {
            this.barcode = barcode;
        }

        public Object getBarcodes() {
            return barcodes;
        }

        public void setBarcodes(Object barcodes) {
            this.barcodes = barcodes;
        }

        public Object getClientCarePlan() {
            return clientCarePlan;
        }

        public void setClientCarePlan(Object clientCarePlan) {
            this.clientCarePlan = clientCarePlan;
        }

        public ClientModel getClientModel() {
            return clientModel;
        }

        public void setClientModel(ClientModel clientModel) {
            this.clientModel = clientModel;
        }

        public Object getClientModelList() {
            return clientModelList;
        }

        public void setClientModelList(Object clientModelList) {
            this.clientModelList = clientModelList;
        }

        public Object getClientNFCModelList() {
            return clientNFCModelList;
        }

        public void setClientNFCModelList(Object clientNFCModelList) {
            this.clientNFCModelList = clientNFCModelList;
        }

        public ClientPerson getClientPerson() {
            return clientPerson;
        }

        public void setClientPerson(ClientPerson clientPerson) {
            this.clientPerson = clientPerson;
        }

        public List<Object> getClientPersons() {
            return clientPersons;
        }

        public void setClientPersons(List<Object> clientPersons) {
            this.clientPersons = clientPersons;
        }

        public Object getCompany() {
            return company;
        }

        public void setCompany(Object company) {
            this.company = company;
        }

        public Object getCompanyList() {
            return companyList;
        }

        public void setCompanyList(Object companyList) {
            this.companyList = companyList;
        }

        public Object getFunderCompanies() {
            return funderCompanies;
        }

        public void setFunderCompanies(Object funderCompanies) {
            this.funderCompanies = funderCompanies;
        }

        public Object getFunderPersons() {
            return funderPersons;
        }

        public void setFunderPersons(Object funderPersons) {
            this.funderPersons = funderPersons;
        }

        public Object getHealthcareClientReference() {
            return healthcareClientReference;
        }

        public void setHealthcareClientReference(Object healthcareClientReference) {
            this.healthcareClientReference = healthcareClientReference;
        }

        public Object getNFCVM() {
            return nFCVM;
        }

        public void setNFCVM(Object nFCVM) {
            this.nFCVM = nFCVM;
        }

        public Object getNFCVMList() {
            return nFCVMList;
        }

        public void setNFCVMList(Object nFCVMList) {
            this.nFCVMList = nFCVMList;
        }

    }

    public class Contact {

        @SerializedName("ContactAdded")
        @Expose
        private String contactAdded;
        @SerializedName("ContactPersonId")
        @Expose
        private String contactPersonId;

        public String getContactAdded() {
            return contactAdded;
        }

        public void setContactAdded(String contactAdded) {
            this.contactAdded = contactAdded;
        }

        public String getContactPersonId() {
            return contactPersonId;
        }

        public void setContactPersonId(String contactPersonId) {
            this.contactPersonId = contactPersonId;
        }

    }

    public class ContactsInformation {

        @SerializedName("ClientContactModelList")
        @Expose
        private List<ClientContactModelList> clientContactModelList = null;
        @SerializedName("ClientContactsPersons")
        @Expose
        private List<ClientContactsPerson> clientContactsPersons = null;
        @SerializedName("Contacts")
        @Expose
        private List<Contact> contacts = null;
        @SerializedName("EmployeeContacts")
        @Expose
        private Object employeeContacts;
        @SerializedName("RemoveClientContactModelList")
        @Expose
        private Object removeClientContactModelList;
        @SerializedName("RemoveContacts")
        @Expose
        private Object removeContacts;
        @SerializedName("RemoveEmployeeContacts")
        @Expose
        private Object removeEmployeeContacts;

        public List<ClientContactModelList> getClientContactModelList() {
            return clientContactModelList;
        }

        public void setClientContactModelList(List<ClientContactModelList> clientContactModelList) {
            this.clientContactModelList = clientContactModelList;
        }

        public List<ClientContactsPerson> getClientContactsPersons() {
            return clientContactsPersons;
        }

        public void setClientContactsPersons(List<ClientContactsPerson> clientContactsPersons) {
            this.clientContactsPersons = clientContactsPersons;
        }

        public List<Contact> getContacts() {
            return contacts;
        }

        public void setContacts(List<Contact> contacts) {
            this.contacts = contacts;
        }

        public Object getEmployeeContacts() {
            return employeeContacts;
        }

        public void setEmployeeContacts(Object employeeContacts) {
            this.employeeContacts = employeeContacts;
        }

        public Object getRemoveClientContactModelList() {
            return removeClientContactModelList;
        }

        public void setRemoveClientContactModelList(Object removeClientContactModelList) {
            this.removeClientContactModelList = removeClientContactModelList;
        }

        public Object getRemoveContacts() {
            return removeContacts;
        }

        public void setRemoveContacts(Object removeContacts) {
            this.removeContacts = removeContacts;
        }

        public Object getRemoveEmployeeContacts() {
            return removeEmployeeContacts;
        }

        public void setRemoveEmployeeContacts(Object removeEmployeeContacts) {
            this.removeEmployeeContacts = removeEmployeeContacts;
        }

    }

    public class Data {

        @SerializedName("ClientAllergies")
        @Expose
        private Object clientAllergies;
        @SerializedName("ClientDisabilities")
        @Expose
        private Object clientDisabilities;
        @SerializedName("ClientDocuments")
        @Expose
        private Object clientDocuments;
        @SerializedName("ClientNotes")
        @Expose
        private Object clientNotes;
        @SerializedName("ClientVM")
        @Expose
        private ClientVM clientVM;
        @SerializedName("ContactsInformation")
        @Expose
        private ContactsInformation contactsInformation;
        @SerializedName("MedicalMVM")
        @Expose
        private Object medicalMVM;
        @SerializedName("TaskMVM")
        @Expose
        private Object taskMVM;

        public Object getClientAllergies() {
            return clientAllergies;
        }

        public void setClientAllergies(Object clientAllergies) {
            this.clientAllergies = clientAllergies;
        }

        public Object getClientDisabilities() {
            return clientDisabilities;
        }

        public void setClientDisabilities(Object clientDisabilities) {
            this.clientDisabilities = clientDisabilities;
        }

        public Object getClientDocuments() {
            return clientDocuments;
        }

        public void setClientDocuments(Object clientDocuments) {
            this.clientDocuments = clientDocuments;
        }

        public Object getClientNotes() {
            return clientNotes;
        }

        public void setClientNotes(Object clientNotes) {
            this.clientNotes = clientNotes;
        }

        public ClientVM getClientVM() {
            return clientVM;
        }

        public void setClientVM(ClientVM clientVM) {
            this.clientVM = clientVM;
        }

        public ContactsInformation getContactsInformation() {
            return contactsInformation;
        }

        public void setContactsInformation(ContactsInformation contactsInformation) {
            this.contactsInformation = contactsInformation;
        }

        public Object getMedicalMVM() {
            return medicalMVM;
        }

        public void setMedicalMVM(Object medicalMVM) {
            this.medicalMVM = medicalMVM;
        }

        public Object getTaskMVM() {
            return taskMVM;
        }

        public void setTaskMVM(Object taskMVM) {
            this.taskMVM = taskMVM;
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

    public class PersonAddress_ {

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

    public class PersonDynamicProperty {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("DynamicPropertyName")
        @Expose
        private String dynamicPropertyName;
        @SerializedName("PersonDynamicPropertyValue")
        @Expose
        private String personDynamicPropertyValue;
        @SerializedName("PersonId")
        @Expose
        private String personId;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getDynamicPropertyName() {
            return dynamicPropertyName;
        }

        public void setDynamicPropertyName(String dynamicPropertyName) {
            this.dynamicPropertyName = dynamicPropertyName;
        }

        public String getPersonDynamicPropertyValue() {
            return personDynamicPropertyValue;
        }

        public void setPersonDynamicPropertyValue(String personDynamicPropertyValue) {
            this.personDynamicPropertyValue = personDynamicPropertyValue;
        }

        public String getPersonId() {
            return personId;
        }

        public void setPersonId(String personId) {
            this.personId = personId;
        }

    }

    public class PersonDynamicProperty_ {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("DynamicPropertyName")
        @Expose
        private String dynamicPropertyName;
        @SerializedName("PersonDynamicPropertyValue")
        @Expose
        private String personDynamicPropertyValue;
        @SerializedName("PersonId")
        @Expose
        private String personId;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getDynamicPropertyName() {
            return dynamicPropertyName;
        }

        public void setDynamicPropertyName(String dynamicPropertyName) {
            this.dynamicPropertyName = dynamicPropertyName;
        }

        public String getPersonDynamicPropertyValue() {
            return personDynamicPropertyValue;
        }

        public void setPersonDynamicPropertyValue(String personDynamicPropertyValue) {
            this.personDynamicPropertyValue = personDynamicPropertyValue;
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

    public class PersonNationality_ {

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

    public class PersonPhone_ {

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

    public class Persons {

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
        private List<PersonDynamicProperty> personDynamicProperty = null;
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

        public List<PersonDynamicProperty> getPersonDynamicProperty() {
            return personDynamicProperty;
        }

        public void setPersonDynamicProperty(List<PersonDynamicProperty> personDynamicProperty) {
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




}

