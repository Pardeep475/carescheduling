package com.example.carescheduling.Ui.Dashboard.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


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


    public class Branch {

        @SerializedName("BranchAddress")
        @Expose
        private Object branchAddress;
        @SerializedName("BranchApplicationLicense")
        @Expose
        private Object branchApplicationLicense;
        @SerializedName("BranchClient")
        @Expose
        private Object branchClient;
        @SerializedName("BranchCompany")
        @Expose
        private Object branchCompany;
        @SerializedName("BranchDevice")
        @Expose
        private Object branchDevice;
        @SerializedName("BranchEmail")
        @Expose
        private Object branchEmail;
        @SerializedName("BranchEmployee")
        @Expose
        private Object branchEmployee;
        @SerializedName("BranchId")
        @Expose
        private String branchId;
        @SerializedName("BranchName")
        @Expose
        private String branchName;
        @SerializedName("BranchParentId")
        @Expose
        private String branchParentId;
        @SerializedName("BranchPerson")
        @Expose
        private Object branchPerson;
        @SerializedName("BranchPhone")
        @Expose
        private Object branchPhone;
        @SerializedName("BranchSupplier")
        @Expose
        private Object branchSupplier;
        @SerializedName("BranchUser")
        @Expose
        private Object branchUser;
        @SerializedName("CreatedDate")
        @Expose
        private String createdDate;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("ModifiedDate")
        @Expose
        private String modifiedDate;

        public Object getBranchAddress() {
            return branchAddress;
        }

        public void setBranchAddress(Object branchAddress) {
            this.branchAddress = branchAddress;
        }

        public Object getBranchApplicationLicense() {
            return branchApplicationLicense;
        }

        public void setBranchApplicationLicense(Object branchApplicationLicense) {
            this.branchApplicationLicense = branchApplicationLicense;
        }

        public Object getBranchClient() {
            return branchClient;
        }

        public void setBranchClient(Object branchClient) {
            this.branchClient = branchClient;
        }

        public Object getBranchCompany() {
            return branchCompany;
        }

        public void setBranchCompany(Object branchCompany) {
            this.branchCompany = branchCompany;
        }

        public Object getBranchDevice() {
            return branchDevice;
        }

        public void setBranchDevice(Object branchDevice) {
            this.branchDevice = branchDevice;
        }

        public Object getBranchEmail() {
            return branchEmail;
        }

        public void setBranchEmail(Object branchEmail) {
            this.branchEmail = branchEmail;
        }

        public Object getBranchEmployee() {
            return branchEmployee;
        }

        public void setBranchEmployee(Object branchEmployee) {
            this.branchEmployee = branchEmployee;
        }

        public String getBranchId() {
            return branchId;
        }

        public void setBranchId(String branchId) {
            this.branchId = branchId;
        }

        public String getBranchName() {
            return branchName;
        }

        public void setBranchName(String branchName) {
            this.branchName = branchName;
        }

        public String getBranchParentId() {
            return branchParentId;
        }

        public void setBranchParentId(String branchParentId) {
            this.branchParentId = branchParentId;
        }

        public Object getBranchPerson() {
            return branchPerson;
        }

        public void setBranchPerson(Object branchPerson) {
            this.branchPerson = branchPerson;
        }

        public Object getBranchPhone() {
            return branchPhone;
        }

        public void setBranchPhone(Object branchPhone) {
            this.branchPhone = branchPhone;
        }

        public Object getBranchSupplier() {
            return branchSupplier;
        }

        public void setBranchSupplier(Object branchSupplier) {
            this.branchSupplier = branchSupplier;
        }

        public Object getBranchUser() {
            return branchUser;
        }

        public void setBranchUser(Object branchUser) {
            this.branchUser = branchUser;
        }

        public String getCreatedDate() {
            return createdDate;
        }

        public void setCreatedDate(String createdDate) {
            this.createdDate = createdDate;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getModifiedDate() {
            return modifiedDate;
        }

        public void setModifiedDate(String modifiedDate) {
            this.modifiedDate = modifiedDate;
        }

    }

    public class Customer {

        @SerializedName("Branch")
        @Expose
        private List<Branch> branch = null;
        @SerializedName("CreatedDate")
        @Expose
        private String createdDate;
        @SerializedName("CustomerAccountingSystem")
        @Expose
        private List<CustomerAccountingSystem> customerAccountingSystem = null;
        @SerializedName("CustomerActionStatusType")
        @Expose
        private List<CustomerActionStatusType> customerActionStatusType = null;
        @SerializedName("CustomerActionType")
        @Expose
        private List<CustomerActionType> customerActionType = null;
        @SerializedName("CustomerAddress")
        @Expose
        private List<Object> customerAddress = null;
        @SerializedName("CustomerAddressType")
        @Expose
        private List<CustomerAddressType> customerAddressType = null;
        @SerializedName("CustomerAllergyType")
        @Expose
        private List<CustomerAllergyType> customerAllergyType = null;
        @SerializedName("CustomerAllowanceGroup")
        @Expose
        private List<Object> customerAllowanceGroup = null;
        @SerializedName("CustomerAllowanceType")
        @Expose
        private List<Object> customerAllowanceType = null;
        @SerializedName("CustomerApplicationLicense")
        @Expose
        private List<Object> customerApplicationLicense = null;
        @SerializedName("CustomerApplicationProcess")
        @Expose
        private List<Object> customerApplicationProcess = null;
        @SerializedName("CustomerApplicationProcessGroup")
        @Expose
        private List<Object> customerApplicationProcessGroup = null;
        @SerializedName("CustomerApplicationProcessStep")
        @Expose
        private List<CustomerApplicationProcessStep> customerApplicationProcessStep = null;
        @SerializedName("CustomerAssessmentGroup")
        @Expose
        private List<Object> customerAssessmentGroup = null;
        @SerializedName("CustomerAssessmentGroupAssessmentType")
        @Expose
        private List<Object> customerAssessmentGroupAssessmentType = null;
        @SerializedName("CustomerAssessmentHeadlineType")
        @Expose
        private List<Object> customerAssessmentHeadlineType = null;
        @SerializedName("CustomerAssessmentMultiChoiceType")
        @Expose
        private List<Object> customerAssessmentMultiChoiceType = null;
        @SerializedName("CustomerAssessmentTextType")
        @Expose
        private List<Object> customerAssessmentTextType = null;
        @SerializedName("CustomerAssessmentType")
        @Expose
        private List<Object> customerAssessmentType = null;
        @SerializedName("CustomerAssetsType")
        @Expose
        private List<CustomerAssetsType> customerAssetsType = null;
        @SerializedName("CustomerBookingConfirmationType")
        @Expose
        private List<CustomerBookingConfirmationType> customerBookingConfirmationType = null;
        @SerializedName("CustomerBookingStatusType")
        @Expose
        private List<CustomerBookingStatusType> customerBookingStatusType = null;
        @SerializedName("CustomerClearanceType")
        @Expose
        private List<CustomerClearanceType> customerClearanceType = null;
        @SerializedName("CustomerClientActivityLevelType")
        @Expose
        private List<CustomerClientActivityLevelType> customerClientActivityLevelType = null;
        @SerializedName("CustomerClientType")
        @Expose
        private List<CustomerClientType> customerClientType = null;
        @SerializedName("CustomerCommunicationSkillGroupCommunicationSkill")
        @Expose
        private List<Object> customerCommunicationSkillGroupCommunicationSkill = null;
        @SerializedName("CustomerConsequence")
        @Expose
        private List<CustomerConsequence> customerConsequence = null;
        @SerializedName("CustomerContactPersons")
        @Expose
        private List<Object> customerContactPersons = null;
        @SerializedName("CustomerContactRoleType")
        @Expose
        private List<CustomerContactRoleType> customerContactRoleType = null;
        @SerializedName("CustomerContactType")
        @Expose
        private List<CustomerContactType> customerContactType = null;
        @SerializedName("CustomerContract")
        @Expose
        private List<Object> customerContract = null;
        @SerializedName("CustomerContractCategory")
        @Expose
        private List<CustomerContractCategory> customerContractCategory = null;
        @SerializedName("CustomerContractCategoryContractType")
        @Expose
        private List<CustomerContractCategoryContractType> customerContractCategoryContractType = null;
        @SerializedName("CustomerContractType")
        @Expose
        private List<CustomerContractType> customerContractType = null;
        @SerializedName("CustomerCountry")
        @Expose
        private List<CustomerCountry> customerCountry = null;
        @SerializedName("CustomerCriminalRecordType")
        @Expose
        private List<CustomerCriminalRecordType> customerCriminalRecordType = null;
        @SerializedName("CustomerDateOfMonth")
        @Expose
        private List<CustomerDateOfMonth> customerDateOfMonth = null;
        @SerializedName("CustomerDisabilityType")
        @Expose
        private List<CustomerDisabilityType> customerDisabilityType = null;
        @SerializedName("CustomerDisabillityGroupType")
        @Expose
        private List<Object> customerDisabillityGroupType = null;
        @SerializedName("CustomerDocumentCategory")
        @Expose
        private List<CustomerDocumentCategory> customerDocumentCategory = null;
        @SerializedName("CustomerDocumentFileType")
        @Expose
        private List<CustomerDocumentFileType> customerDocumentFileType = null;
        @SerializedName("CustomerEmail")
        @Expose
        private List<Object> customerEmail = null;
        @SerializedName("CustomerEmailType")
        @Expose
        private List<CustomerEmailType> customerEmailType = null;
        @SerializedName("CustomerEmployeeEmployeeRole")
        @Expose
        private List<CustomerEmployeeEmployeeRole> customerEmployeeEmployeeRole = null;
        @SerializedName("CustomerEmployeeGroup")
        @Expose
        private List<CustomerEmployeeGroup> customerEmployeeGroup = null;
        @SerializedName("CustomerEmployeeStatusType")
        @Expose
        private List<CustomerEmployeeStatusType> customerEmployeeStatusType = null;
        @SerializedName("CustomerEmployeeType")
        @Expose
        private List<CustomerEmployeeType> customerEmployeeType = null;
        @SerializedName("CustomerEmploymentApplicationType")
        @Expose
        private List<CustomerEmploymentApplicationType> customerEmploymentApplicationType = null;
        @SerializedName("CustomerEthnicityGroup")
        @Expose
        private List<CustomerEthnicityGroup> customerEthnicityGroup = null;
        @SerializedName("CustomerEthnicityType")
        @Expose
        private List<CustomerEthnicityType> customerEthnicityType = null;
        @SerializedName("CustomerExpenseGroup")
        @Expose
        private List<Object> customerExpenseGroup = null;
        @SerializedName("CustomerExpenseType")
        @Expose
        private List<Object> customerExpenseType = null;
        @SerializedName("CustomerFluidChartType")
        @Expose
        private List<CustomerFluidChartType> customerFluidChartType = null;
        @SerializedName("CustomerFluidIO")
        @Expose
        private List<CustomerFluidIO> customerFluidIO = null;
        @SerializedName("CustomerFluidThickenedType")
        @Expose
        private List<CustomerFluidThickenedType> customerFluidThickenedType = null;
        @SerializedName("CustomerFluidType")
        @Expose
        private List<CustomerFluidType> customerFluidType = null;
        @SerializedName("CustomerFood")
        @Expose
        private List<CustomerFood> customerFood = null;
        @SerializedName("CustomerFoodChartType")
        @Expose
        private List<CustomerFoodChartType> customerFoodChartType = null;
        @SerializedName("CustomerFoodType")
        @Expose
        private List<CustomerFoodType> customerFoodType = null;
        @SerializedName("CustomerGender")
        @Expose
        private List<CustomerGender> customerGender = null;
        @SerializedName("CustomerHealthDeclarationType")
        @Expose
        private List<CustomerHealthDeclarationType> customerHealthDeclarationType = null;
        @SerializedName("CustomerHomeClientType")
        @Expose
        private List<CustomerHomeClientType> customerHomeClientType = null;
        @SerializedName("CustomerHomeType")
        @Expose
        private List<CustomerHomeType> customerHomeType = null;
        @SerializedName("CustomerHourOfDay")
        @Expose
        private List<CustomerHourOfDay> customerHourOfDay = null;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("CustomerIdentificationType")
        @Expose
        private List<CustomerIdentificationType> customerIdentificationType = null;
        @SerializedName("CustomerImmunisationType")
        @Expose
        private List<CustomerImmunisationType> customerImmunisationType = null;
        @SerializedName("CustomerIncompatibillityType")
        @Expose
        private List<CustomerIncompatibillityType> customerIncompatibillityType = null;
        @SerializedName("CustomerInterestGroup")
        @Expose
        private List<CustomerInterestGroup> customerInterestGroup = null;
        @SerializedName("CustomerInterestType")
        @Expose
        private List<CustomerInterestType> customerInterestType = null;
        @SerializedName("CustomerLanguage")
        @Expose
        private List<CustomerLanguage> customerLanguage = null;
        @SerializedName("CustomerLanguageCountry")
        @Expose
        private List<CustomerLanguageCountry> customerLanguageCountry = null;
        @SerializedName("CustomerLeaveType")
        @Expose
        private List<CustomerLeaveType> customerLeaveType = null;
        @SerializedName("CustomerLoanInstalmentType")
        @Expose
        private List<CustomerLoanInstalmentType> customerLoanInstalmentType = null;
        @SerializedName("CustomerLoanType")
        @Expose
        private List<CustomerLoanType> customerLoanType = null;
        @SerializedName("CustomerMARSheetType")
        @Expose
        private List<CustomerMARSheetType> customerMARSheetType = null;
        @SerializedName("CustomerMaritalStatusType")
        @Expose
        private List<CustomerMaritalStatusType> customerMaritalStatusType = null;
        @SerializedName("CustomerMatchingLevelGroup")
        @Expose
        private List<CustomerMatchingLevelGroup> customerMatchingLevelGroup = null;
        @SerializedName("CustomerMatchingLevelIndex")
        @Expose
        private List<CustomerMatchingLevelIndex> customerMatchingLevelIndex = null;
        @SerializedName("CustomerMatchingType")
        @Expose
        private List<Object> customerMatchingType = null;
        @SerializedName("CustomerMealType")
        @Expose
        private List<CustomerMealType> customerMealType = null;
        @SerializedName("CustomerMedicationDeviationType")
        @Expose
        private List<CustomerMedicationDeviationType> customerMedicationDeviationType = null;
        @SerializedName("CustomerMessage")
        @Expose
        private List<Object> customerMessage = null;
        @SerializedName("CustomerMessageReceiverGroup")
        @Expose
        private List<CustomerMessageReceiverGroup> customerMessageReceiverGroup = null;
        @SerializedName("CustomerMessageSentToType")
        @Expose
        private List<CustomerMessageSentToType> customerMessageSentToType = null;
        @SerializedName("CustomerMessageTemplateType")
        @Expose
        private List<CustomerMessageTemplateType> customerMessageTemplateType = null;
        @SerializedName("CustomerMessageType")
        @Expose
        private List<CustomerMessageType> customerMessageType = null;
        @SerializedName("CustomerMinuteOfDay")
        @Expose
        private List<CustomerMinuteOfDay> customerMinuteOfDay = null;
        @SerializedName("CustomerMonitoringType")
        @Expose
        private List<CustomerMonitoringType> customerMonitoringType = null;
        @SerializedName("CustomerMonthOfTheYear")
        @Expose
        private List<CustomerMonthOfTheYear> customerMonthOfTheYear = null;
        @SerializedName("CustomerName")
        @Expose
        private String customerName;
        @SerializedName("CustomerNoteCategory")
        @Expose
        private List<Object> customerNoteCategory = null;
        @SerializedName("CustomerNoteType")
        @Expose
        private List<CustomerNoteType> customerNoteType = null;
        @SerializedName("CustomerNoticePeriod")
        @Expose
        private List<CustomerNoticePeriod> customerNoticePeriod = null;
        @SerializedName("CustomerParentId")
        @Expose
        private Object customerParentId;
        @SerializedName("CustomerPaymentFrequencyType")
        @Expose
        private List<CustomerPaymentFrequencyType> customerPaymentFrequencyType = null;
        @SerializedName("CustomerPeriodOfDayType")
        @Expose
        private List<CustomerPeriodOfDayType> customerPeriodOfDayType = null;
        @SerializedName("CustomerPersonGroup")
        @Expose
        private List<Object> customerPersonGroup = null;
        @SerializedName("CustomerPhone")
        @Expose
        private List<Object> customerPhone = null;
        @SerializedName("CustomerPhoneType")
        @Expose
        private List<CustomerPhoneType> customerPhoneType = null;
        @SerializedName("CustomerPrefix")
        @Expose
        private List<CustomerPrefix> customerPrefix = null;
        @SerializedName("CustomerProductGroup")
        @Expose
        private List<Object> customerProductGroup = null;
        @SerializedName("CustomerProductType")
        @Expose
        private List<Object> customerProductType = null;
        @SerializedName("CustomerProtocolObjectType")
        @Expose
        private List<Object> customerProtocolObjectType = null;
        @SerializedName("CustomerQualificationGroup")
        @Expose
        private List<CustomerQualificationGroup> customerQualificationGroup = null;
        @SerializedName("CustomerQualificationType")
        @Expose
        private List<CustomerQualificationType> customerQualificationType = null;
        @SerializedName("CustomerReligionType")
        @Expose
        private List<CustomerReligionType> customerReligionType = null;
        @SerializedName("CustomerRenewalPeriod")
        @Expose
        private List<CustomerRenewalPeriod> customerRenewalPeriod = null;
        @SerializedName("CustomerReviewType")
        @Expose
        private List<CustomerReviewType> customerReviewType = null;
        @SerializedName("CustomerSchedule")
        @Expose
        private List<CustomerSchedule> customerSchedule = null;
        @SerializedName("CustomerSeason")
        @Expose
        private List<CustomerSeason> customerSeason = null;
        @SerializedName("CustomerSexualityType")
        @Expose
        private List<CustomerSexualityType> customerSexualityType = null;
        @SerializedName("CustomerShiftBreak")
        @Expose
        private List<Object> customerShiftBreak = null;
        @SerializedName("CustomerShiftBreakWeekday")
        @Expose
        private List<Object> customerShiftBreakWeekday = null;
        @SerializedName("CustomerShiftPlan")
        @Expose
        private List<CustomerShiftPlan> customerShiftPlan = null;
        @SerializedName("CustomerSkillGroup")
        @Expose
        private List<CustomerSkillGroup> customerSkillGroup = null;
        @SerializedName("CustomerSkillLevel")
        @Expose
        private List<CustomerSkillLevel> customerSkillLevel = null;
        @SerializedName("CustomerSkillType")
        @Expose
        private List<CustomerSkillType> customerSkillType = null;
        @SerializedName("CustomerTaskDeviationType")
        @Expose
        private List<Object> customerTaskDeviationType = null;
        @SerializedName("CustomerTaskPriority")
        @Expose
        private List<CustomerTaskPriority> customerTaskPriority = null;
        @SerializedName("CustomerTaskType")
        @Expose
        private List<CustomerTaskType> customerTaskType = null;
        @SerializedName("CustomerTeamType")
        @Expose
        private List<CustomerTeamType> customerTeamType = null;
        @SerializedName("CustomerTelephoneCountryPrefix")
        @Expose
        private List<CustomerTelephoneCountryPrefix> customerTelephoneCountryPrefix = null;
        @SerializedName("CustomerTrainingCourseGroup")
        @Expose
        private List<CustomerTrainingCourseGroup> customerTrainingCourseGroup = null;
        @SerializedName("CustomerTrainingType")
        @Expose
        private List<CustomerTrainingType> customerTrainingType = null;
        @SerializedName("CustomerTrainingTypeGroup")
        @Expose
        private List<CustomerTrainingTypeGroup> customerTrainingTypeGroup = null;
        @SerializedName("CustomerTransportType")
        @Expose
        private List<CustomerTransportType> customerTransportType = null;
        @SerializedName("CustomerUserRole")
        @Expose
        private List<CustomerUserRole> customerUserRole = null;
        @SerializedName("CustomerWeekNumber")
        @Expose
        private List<CustomerWeekNumber> customerWeekNumber = null;
        @SerializedName("CustomerWeekNumberType")
        @Expose
        private List<CustomerWeekNumberType> customerWeekNumberType = null;
        @SerializedName("CustomerWeekRotationType")
        @Expose
        private List<CustomerWeekRotationType> customerWeekRotationType = null;
        @SerializedName("CustomerWeekday")
        @Expose
        private List<CustomerWeekday> customerWeekday = null;
        @SerializedName("CustomerYear")
        @Expose
        private List<CustomerYear> customerYear = null;
        @SerializedName("ModifiedDate")
        @Expose
        private String modifiedDate;
        @SerializedName("Status")
        @Expose
        private Integer status;

        public List<Branch> getBranch() {
            return branch;
        }

        public void setBranch(List<Branch> branch) {
            this.branch = branch;
        }

        public String getCreatedDate() {
            return createdDate;
        }

        public void setCreatedDate(String createdDate) {
            this.createdDate = createdDate;
        }

        public List<CustomerAccountingSystem> getCustomerAccountingSystem() {
            return customerAccountingSystem;
        }

        public void setCustomerAccountingSystem(List<CustomerAccountingSystem> customerAccountingSystem) {
            this.customerAccountingSystem = customerAccountingSystem;
        }

        public List<CustomerActionStatusType> getCustomerActionStatusType() {
            return customerActionStatusType;
        }

        public void setCustomerActionStatusType(List<CustomerActionStatusType> customerActionStatusType) {
            this.customerActionStatusType = customerActionStatusType;
        }

        public List<CustomerActionType> getCustomerActionType() {
            return customerActionType;
        }

        public void setCustomerActionType(List<CustomerActionType> customerActionType) {
            this.customerActionType = customerActionType;
        }

        public List<Object> getCustomerAddress() {
            return customerAddress;
        }

        public void setCustomerAddress(List<Object> customerAddress) {
            this.customerAddress = customerAddress;
        }

        public List<CustomerAddressType> getCustomerAddressType() {
            return customerAddressType;
        }

        public void setCustomerAddressType(List<CustomerAddressType> customerAddressType) {
            this.customerAddressType = customerAddressType;
        }

        public List<CustomerAllergyType> getCustomerAllergyType() {
            return customerAllergyType;
        }

        public void setCustomerAllergyType(List<CustomerAllergyType> customerAllergyType) {
            this.customerAllergyType = customerAllergyType;
        }

        public List<Object> getCustomerAllowanceGroup() {
            return customerAllowanceGroup;
        }

        public void setCustomerAllowanceGroup(List<Object> customerAllowanceGroup) {
            this.customerAllowanceGroup = customerAllowanceGroup;
        }

        public List<Object> getCustomerAllowanceType() {
            return customerAllowanceType;
        }

        public void setCustomerAllowanceType(List<Object> customerAllowanceType) {
            this.customerAllowanceType = customerAllowanceType;
        }

        public List<Object> getCustomerApplicationLicense() {
            return customerApplicationLicense;
        }

        public void setCustomerApplicationLicense(List<Object> customerApplicationLicense) {
            this.customerApplicationLicense = customerApplicationLicense;
        }

        public List<Object> getCustomerApplicationProcess() {
            return customerApplicationProcess;
        }

        public void setCustomerApplicationProcess(List<Object> customerApplicationProcess) {
            this.customerApplicationProcess = customerApplicationProcess;
        }

        public List<Object> getCustomerApplicationProcessGroup() {
            return customerApplicationProcessGroup;
        }

        public void setCustomerApplicationProcessGroup(List<Object> customerApplicationProcessGroup) {
            this.customerApplicationProcessGroup = customerApplicationProcessGroup;
        }

        public List<CustomerApplicationProcessStep> getCustomerApplicationProcessStep() {
            return customerApplicationProcessStep;
        }

        public void setCustomerApplicationProcessStep(List<CustomerApplicationProcessStep> customerApplicationProcessStep) {
            this.customerApplicationProcessStep = customerApplicationProcessStep;
        }

        public List<Object> getCustomerAssessmentGroup() {
            return customerAssessmentGroup;
        }

        public void setCustomerAssessmentGroup(List<Object> customerAssessmentGroup) {
            this.customerAssessmentGroup = customerAssessmentGroup;
        }

        public List<Object> getCustomerAssessmentGroupAssessmentType() {
            return customerAssessmentGroupAssessmentType;
        }

        public void setCustomerAssessmentGroupAssessmentType(List<Object> customerAssessmentGroupAssessmentType) {
            this.customerAssessmentGroupAssessmentType = customerAssessmentGroupAssessmentType;
        }

        public List<Object> getCustomerAssessmentHeadlineType() {
            return customerAssessmentHeadlineType;
        }

        public void setCustomerAssessmentHeadlineType(List<Object> customerAssessmentHeadlineType) {
            this.customerAssessmentHeadlineType = customerAssessmentHeadlineType;
        }

        public List<Object> getCustomerAssessmentMultiChoiceType() {
            return customerAssessmentMultiChoiceType;
        }

        public void setCustomerAssessmentMultiChoiceType(List<Object> customerAssessmentMultiChoiceType) {
            this.customerAssessmentMultiChoiceType = customerAssessmentMultiChoiceType;
        }

        public List<Object> getCustomerAssessmentTextType() {
            return customerAssessmentTextType;
        }

        public void setCustomerAssessmentTextType(List<Object> customerAssessmentTextType) {
            this.customerAssessmentTextType = customerAssessmentTextType;
        }

        public List<Object> getCustomerAssessmentType() {
            return customerAssessmentType;
        }

        public void setCustomerAssessmentType(List<Object> customerAssessmentType) {
            this.customerAssessmentType = customerAssessmentType;
        }

        public List<CustomerAssetsType> getCustomerAssetsType() {
            return customerAssetsType;
        }

        public void setCustomerAssetsType(List<CustomerAssetsType> customerAssetsType) {
            this.customerAssetsType = customerAssetsType;
        }

        public List<CustomerBookingConfirmationType> getCustomerBookingConfirmationType() {
            return customerBookingConfirmationType;
        }

        public void setCustomerBookingConfirmationType(List<CustomerBookingConfirmationType> customerBookingConfirmationType) {
            this.customerBookingConfirmationType = customerBookingConfirmationType;
        }

        public List<CustomerBookingStatusType> getCustomerBookingStatusType() {
            return customerBookingStatusType;
        }

        public void setCustomerBookingStatusType(List<CustomerBookingStatusType> customerBookingStatusType) {
            this.customerBookingStatusType = customerBookingStatusType;
        }

        public List<CustomerClearanceType> getCustomerClearanceType() {
            return customerClearanceType;
        }

        public void setCustomerClearanceType(List<CustomerClearanceType> customerClearanceType) {
            this.customerClearanceType = customerClearanceType;
        }

        public List<CustomerClientActivityLevelType> getCustomerClientActivityLevelType() {
            return customerClientActivityLevelType;
        }

        public void setCustomerClientActivityLevelType(List<CustomerClientActivityLevelType> customerClientActivityLevelType) {
            this.customerClientActivityLevelType = customerClientActivityLevelType;
        }

        public List<CustomerClientType> getCustomerClientType() {
            return customerClientType;
        }

        public void setCustomerClientType(List<CustomerClientType> customerClientType) {
            this.customerClientType = customerClientType;
        }

        public List<Object> getCustomerCommunicationSkillGroupCommunicationSkill() {
            return customerCommunicationSkillGroupCommunicationSkill;
        }

        public void setCustomerCommunicationSkillGroupCommunicationSkill(List<Object> customerCommunicationSkillGroupCommunicationSkill) {
            this.customerCommunicationSkillGroupCommunicationSkill = customerCommunicationSkillGroupCommunicationSkill;
        }

        public List<CustomerConsequence> getCustomerConsequence() {
            return customerConsequence;
        }

        public void setCustomerConsequence(List<CustomerConsequence> customerConsequence) {
            this.customerConsequence = customerConsequence;
        }

        public List<Object> getCustomerContactPersons() {
            return customerContactPersons;
        }

        public void setCustomerContactPersons(List<Object> customerContactPersons) {
            this.customerContactPersons = customerContactPersons;
        }

        public List<CustomerContactRoleType> getCustomerContactRoleType() {
            return customerContactRoleType;
        }

        public void setCustomerContactRoleType(List<CustomerContactRoleType> customerContactRoleType) {
            this.customerContactRoleType = customerContactRoleType;
        }

        public List<CustomerContactType> getCustomerContactType() {
            return customerContactType;
        }

        public void setCustomerContactType(List<CustomerContactType> customerContactType) {
            this.customerContactType = customerContactType;
        }

        public List<Object> getCustomerContract() {
            return customerContract;
        }

        public void setCustomerContract(List<Object> customerContract) {
            this.customerContract = customerContract;
        }

        public List<CustomerContractCategory> getCustomerContractCategory() {
            return customerContractCategory;
        }

        public void setCustomerContractCategory(List<CustomerContractCategory> customerContractCategory) {
            this.customerContractCategory = customerContractCategory;
        }

        public List<CustomerContractCategoryContractType> getCustomerContractCategoryContractType() {
            return customerContractCategoryContractType;
        }

        public void setCustomerContractCategoryContractType(List<CustomerContractCategoryContractType> customerContractCategoryContractType) {
            this.customerContractCategoryContractType = customerContractCategoryContractType;
        }

        public List<CustomerContractType> getCustomerContractType() {
            return customerContractType;
        }

        public void setCustomerContractType(List<CustomerContractType> customerContractType) {
            this.customerContractType = customerContractType;
        }

        public List<CustomerCountry> getCustomerCountry() {
            return customerCountry;
        }

        public void setCustomerCountry(List<CustomerCountry> customerCountry) {
            this.customerCountry = customerCountry;
        }

        public List<CustomerCriminalRecordType> getCustomerCriminalRecordType() {
            return customerCriminalRecordType;
        }

        public void setCustomerCriminalRecordType(List<CustomerCriminalRecordType> customerCriminalRecordType) {
            this.customerCriminalRecordType = customerCriminalRecordType;
        }

        public List<CustomerDateOfMonth> getCustomerDateOfMonth() {
            return customerDateOfMonth;
        }

        public void setCustomerDateOfMonth(List<CustomerDateOfMonth> customerDateOfMonth) {
            this.customerDateOfMonth = customerDateOfMonth;
        }

        public List<CustomerDisabilityType> getCustomerDisabilityType() {
            return customerDisabilityType;
        }

        public void setCustomerDisabilityType(List<CustomerDisabilityType> customerDisabilityType) {
            this.customerDisabilityType = customerDisabilityType;
        }

        public List<Object> getCustomerDisabillityGroupType() {
            return customerDisabillityGroupType;
        }

        public void setCustomerDisabillityGroupType(List<Object> customerDisabillityGroupType) {
            this.customerDisabillityGroupType = customerDisabillityGroupType;
        }

        public List<CustomerDocumentCategory> getCustomerDocumentCategory() {
            return customerDocumentCategory;
        }

        public void setCustomerDocumentCategory(List<CustomerDocumentCategory> customerDocumentCategory) {
            this.customerDocumentCategory = customerDocumentCategory;
        }

        public List<CustomerDocumentFileType> getCustomerDocumentFileType() {
            return customerDocumentFileType;
        }

        public void setCustomerDocumentFileType(List<CustomerDocumentFileType> customerDocumentFileType) {
            this.customerDocumentFileType = customerDocumentFileType;
        }

        public List<Object> getCustomerEmail() {
            return customerEmail;
        }

        public void setCustomerEmail(List<Object> customerEmail) {
            this.customerEmail = customerEmail;
        }

        public List<CustomerEmailType> getCustomerEmailType() {
            return customerEmailType;
        }

        public void setCustomerEmailType(List<CustomerEmailType> customerEmailType) {
            this.customerEmailType = customerEmailType;
        }

        public List<CustomerEmployeeEmployeeRole> getCustomerEmployeeEmployeeRole() {
            return customerEmployeeEmployeeRole;
        }

        public void setCustomerEmployeeEmployeeRole(List<CustomerEmployeeEmployeeRole> customerEmployeeEmployeeRole) {
            this.customerEmployeeEmployeeRole = customerEmployeeEmployeeRole;
        }

        public List<CustomerEmployeeGroup> getCustomerEmployeeGroup() {
            return customerEmployeeGroup;
        }

        public void setCustomerEmployeeGroup(List<CustomerEmployeeGroup> customerEmployeeGroup) {
            this.customerEmployeeGroup = customerEmployeeGroup;
        }

        public List<CustomerEmployeeStatusType> getCustomerEmployeeStatusType() {
            return customerEmployeeStatusType;
        }

        public void setCustomerEmployeeStatusType(List<CustomerEmployeeStatusType> customerEmployeeStatusType) {
            this.customerEmployeeStatusType = customerEmployeeStatusType;
        }

        public List<CustomerEmployeeType> getCustomerEmployeeType() {
            return customerEmployeeType;
        }

        public void setCustomerEmployeeType(List<CustomerEmployeeType> customerEmployeeType) {
            this.customerEmployeeType = customerEmployeeType;
        }

        public List<CustomerEmploymentApplicationType> getCustomerEmploymentApplicationType() {
            return customerEmploymentApplicationType;
        }

        public void setCustomerEmploymentApplicationType(List<CustomerEmploymentApplicationType> customerEmploymentApplicationType) {
            this.customerEmploymentApplicationType = customerEmploymentApplicationType;
        }

        public List<CustomerEthnicityGroup> getCustomerEthnicityGroup() {
            return customerEthnicityGroup;
        }

        public void setCustomerEthnicityGroup(List<CustomerEthnicityGroup> customerEthnicityGroup) {
            this.customerEthnicityGroup = customerEthnicityGroup;
        }

        public List<CustomerEthnicityType> getCustomerEthnicityType() {
            return customerEthnicityType;
        }

        public void setCustomerEthnicityType(List<CustomerEthnicityType> customerEthnicityType) {
            this.customerEthnicityType = customerEthnicityType;
        }

        public List<Object> getCustomerExpenseGroup() {
            return customerExpenseGroup;
        }

        public void setCustomerExpenseGroup(List<Object> customerExpenseGroup) {
            this.customerExpenseGroup = customerExpenseGroup;
        }

        public List<Object> getCustomerExpenseType() {
            return customerExpenseType;
        }

        public void setCustomerExpenseType(List<Object> customerExpenseType) {
            this.customerExpenseType = customerExpenseType;
        }

        public List<CustomerFluidChartType> getCustomerFluidChartType() {
            return customerFluidChartType;
        }

        public void setCustomerFluidChartType(List<CustomerFluidChartType> customerFluidChartType) {
            this.customerFluidChartType = customerFluidChartType;
        }

        public List<CustomerFluidIO> getCustomerFluidIO() {
            return customerFluidIO;
        }

        public void setCustomerFluidIO(List<CustomerFluidIO> customerFluidIO) {
            this.customerFluidIO = customerFluidIO;
        }

        public List<CustomerFluidThickenedType> getCustomerFluidThickenedType() {
            return customerFluidThickenedType;
        }

        public void setCustomerFluidThickenedType(List<CustomerFluidThickenedType> customerFluidThickenedType) {
            this.customerFluidThickenedType = customerFluidThickenedType;
        }

        public List<CustomerFluidType> getCustomerFluidType() {
            return customerFluidType;
        }

        public void setCustomerFluidType(List<CustomerFluidType> customerFluidType) {
            this.customerFluidType = customerFluidType;
        }

        public List<CustomerFood> getCustomerFood() {
            return customerFood;
        }

        public void setCustomerFood(List<CustomerFood> customerFood) {
            this.customerFood = customerFood;
        }

        public List<CustomerFoodChartType> getCustomerFoodChartType() {
            return customerFoodChartType;
        }

        public void setCustomerFoodChartType(List<CustomerFoodChartType> customerFoodChartType) {
            this.customerFoodChartType = customerFoodChartType;
        }

        public List<CustomerFoodType> getCustomerFoodType() {
            return customerFoodType;
        }

        public void setCustomerFoodType(List<CustomerFoodType> customerFoodType) {
            this.customerFoodType = customerFoodType;
        }

        public List<CustomerGender> getCustomerGender() {
            return customerGender;
        }

        public void setCustomerGender(List<CustomerGender> customerGender) {
            this.customerGender = customerGender;
        }

        public List<CustomerHealthDeclarationType> getCustomerHealthDeclarationType() {
            return customerHealthDeclarationType;
        }

        public void setCustomerHealthDeclarationType(List<CustomerHealthDeclarationType> customerHealthDeclarationType) {
            this.customerHealthDeclarationType = customerHealthDeclarationType;
        }

        public List<CustomerHomeClientType> getCustomerHomeClientType() {
            return customerHomeClientType;
        }

        public void setCustomerHomeClientType(List<CustomerHomeClientType> customerHomeClientType) {
            this.customerHomeClientType = customerHomeClientType;
        }

        public List<CustomerHomeType> getCustomerHomeType() {
            return customerHomeType;
        }

        public void setCustomerHomeType(List<CustomerHomeType> customerHomeType) {
            this.customerHomeType = customerHomeType;
        }

        public List<CustomerHourOfDay> getCustomerHourOfDay() {
            return customerHourOfDay;
        }

        public void setCustomerHourOfDay(List<CustomerHourOfDay> customerHourOfDay) {
            this.customerHourOfDay = customerHourOfDay;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public List<CustomerIdentificationType> getCustomerIdentificationType() {
            return customerIdentificationType;
        }

        public void setCustomerIdentificationType(List<CustomerIdentificationType> customerIdentificationType) {
            this.customerIdentificationType = customerIdentificationType;
        }

        public List<CustomerImmunisationType> getCustomerImmunisationType() {
            return customerImmunisationType;
        }

        public void setCustomerImmunisationType(List<CustomerImmunisationType> customerImmunisationType) {
            this.customerImmunisationType = customerImmunisationType;
        }

        public List<CustomerIncompatibillityType> getCustomerIncompatibillityType() {
            return customerIncompatibillityType;
        }

        public void setCustomerIncompatibillityType(List<CustomerIncompatibillityType> customerIncompatibillityType) {
            this.customerIncompatibillityType = customerIncompatibillityType;
        }

        public List<CustomerInterestGroup> getCustomerInterestGroup() {
            return customerInterestGroup;
        }

        public void setCustomerInterestGroup(List<CustomerInterestGroup> customerInterestGroup) {
            this.customerInterestGroup = customerInterestGroup;
        }

        public List<CustomerInterestType> getCustomerInterestType() {
            return customerInterestType;
        }

        public void setCustomerInterestType(List<CustomerInterestType> customerInterestType) {
            this.customerInterestType = customerInterestType;
        }

        public List<CustomerLanguage> getCustomerLanguage() {
            return customerLanguage;
        }

        public void setCustomerLanguage(List<CustomerLanguage> customerLanguage) {
            this.customerLanguage = customerLanguage;
        }

        public List<CustomerLanguageCountry> getCustomerLanguageCountry() {
            return customerLanguageCountry;
        }

        public void setCustomerLanguageCountry(List<CustomerLanguageCountry> customerLanguageCountry) {
            this.customerLanguageCountry = customerLanguageCountry;
        }

        public List<CustomerLeaveType> getCustomerLeaveType() {
            return customerLeaveType;
        }

        public void setCustomerLeaveType(List<CustomerLeaveType> customerLeaveType) {
            this.customerLeaveType = customerLeaveType;
        }

        public List<CustomerLoanInstalmentType> getCustomerLoanInstalmentType() {
            return customerLoanInstalmentType;
        }

        public void setCustomerLoanInstalmentType(List<CustomerLoanInstalmentType> customerLoanInstalmentType) {
            this.customerLoanInstalmentType = customerLoanInstalmentType;
        }

        public List<CustomerLoanType> getCustomerLoanType() {
            return customerLoanType;
        }

        public void setCustomerLoanType(List<CustomerLoanType> customerLoanType) {
            this.customerLoanType = customerLoanType;
        }

        public List<CustomerMARSheetType> getCustomerMARSheetType() {
            return customerMARSheetType;
        }

        public void setCustomerMARSheetType(List<CustomerMARSheetType> customerMARSheetType) {
            this.customerMARSheetType = customerMARSheetType;
        }

        public List<CustomerMaritalStatusType> getCustomerMaritalStatusType() {
            return customerMaritalStatusType;
        }

        public void setCustomerMaritalStatusType(List<CustomerMaritalStatusType> customerMaritalStatusType) {
            this.customerMaritalStatusType = customerMaritalStatusType;
        }

        public List<CustomerMatchingLevelGroup> getCustomerMatchingLevelGroup() {
            return customerMatchingLevelGroup;
        }

        public void setCustomerMatchingLevelGroup(List<CustomerMatchingLevelGroup> customerMatchingLevelGroup) {
            this.customerMatchingLevelGroup = customerMatchingLevelGroup;
        }

        public List<CustomerMatchingLevelIndex> getCustomerMatchingLevelIndex() {
            return customerMatchingLevelIndex;
        }

        public void setCustomerMatchingLevelIndex(List<CustomerMatchingLevelIndex> customerMatchingLevelIndex) {
            this.customerMatchingLevelIndex = customerMatchingLevelIndex;
        }

        public List<Object> getCustomerMatchingType() {
            return customerMatchingType;
        }

        public void setCustomerMatchingType(List<Object> customerMatchingType) {
            this.customerMatchingType = customerMatchingType;
        }

        public List<CustomerMealType> getCustomerMealType() {
            return customerMealType;
        }

        public void setCustomerMealType(List<CustomerMealType> customerMealType) {
            this.customerMealType = customerMealType;
        }

        public List<CustomerMedicationDeviationType> getCustomerMedicationDeviationType() {
            return customerMedicationDeviationType;
        }

        public void setCustomerMedicationDeviationType(List<CustomerMedicationDeviationType> customerMedicationDeviationType) {
            this.customerMedicationDeviationType = customerMedicationDeviationType;
        }

        public List<Object> getCustomerMessage() {
            return customerMessage;
        }

        public void setCustomerMessage(List<Object> customerMessage) {
            this.customerMessage = customerMessage;
        }

        public List<CustomerMessageReceiverGroup> getCustomerMessageReceiverGroup() {
            return customerMessageReceiverGroup;
        }

        public void setCustomerMessageReceiverGroup(List<CustomerMessageReceiverGroup> customerMessageReceiverGroup) {
            this.customerMessageReceiverGroup = customerMessageReceiverGroup;
        }

        public List<CustomerMessageSentToType> getCustomerMessageSentToType() {
            return customerMessageSentToType;
        }

        public void setCustomerMessageSentToType(List<CustomerMessageSentToType> customerMessageSentToType) {
            this.customerMessageSentToType = customerMessageSentToType;
        }

        public List<CustomerMessageTemplateType> getCustomerMessageTemplateType() {
            return customerMessageTemplateType;
        }

        public void setCustomerMessageTemplateType(List<CustomerMessageTemplateType> customerMessageTemplateType) {
            this.customerMessageTemplateType = customerMessageTemplateType;
        }

        public List<CustomerMessageType> getCustomerMessageType() {
            return customerMessageType;
        }

        public void setCustomerMessageType(List<CustomerMessageType> customerMessageType) {
            this.customerMessageType = customerMessageType;
        }

        public List<CustomerMinuteOfDay> getCustomerMinuteOfDay() {
            return customerMinuteOfDay;
        }

        public void setCustomerMinuteOfDay(List<CustomerMinuteOfDay> customerMinuteOfDay) {
            this.customerMinuteOfDay = customerMinuteOfDay;
        }

        public List<CustomerMonitoringType> getCustomerMonitoringType() {
            return customerMonitoringType;
        }

        public void setCustomerMonitoringType(List<CustomerMonitoringType> customerMonitoringType) {
            this.customerMonitoringType = customerMonitoringType;
        }

        public List<CustomerMonthOfTheYear> getCustomerMonthOfTheYear() {
            return customerMonthOfTheYear;
        }

        public void setCustomerMonthOfTheYear(List<CustomerMonthOfTheYear> customerMonthOfTheYear) {
            this.customerMonthOfTheYear = customerMonthOfTheYear;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public List<Object> getCustomerNoteCategory() {
            return customerNoteCategory;
        }

        public void setCustomerNoteCategory(List<Object> customerNoteCategory) {
            this.customerNoteCategory = customerNoteCategory;
        }

        public List<CustomerNoteType> getCustomerNoteType() {
            return customerNoteType;
        }

        public void setCustomerNoteType(List<CustomerNoteType> customerNoteType) {
            this.customerNoteType = customerNoteType;
        }

        public List<CustomerNoticePeriod> getCustomerNoticePeriod() {
            return customerNoticePeriod;
        }

        public void setCustomerNoticePeriod(List<CustomerNoticePeriod> customerNoticePeriod) {
            this.customerNoticePeriod = customerNoticePeriod;
        }

        public Object getCustomerParentId() {
            return customerParentId;
        }

        public void setCustomerParentId(Object customerParentId) {
            this.customerParentId = customerParentId;
        }

        public List<CustomerPaymentFrequencyType> getCustomerPaymentFrequencyType() {
            return customerPaymentFrequencyType;
        }

        public void setCustomerPaymentFrequencyType(List<CustomerPaymentFrequencyType> customerPaymentFrequencyType) {
            this.customerPaymentFrequencyType = customerPaymentFrequencyType;
        }

        public List<CustomerPeriodOfDayType> getCustomerPeriodOfDayType() {
            return customerPeriodOfDayType;
        }

        public void setCustomerPeriodOfDayType(List<CustomerPeriodOfDayType> customerPeriodOfDayType) {
            this.customerPeriodOfDayType = customerPeriodOfDayType;
        }

        public List<Object> getCustomerPersonGroup() {
            return customerPersonGroup;
        }

        public void setCustomerPersonGroup(List<Object> customerPersonGroup) {
            this.customerPersonGroup = customerPersonGroup;
        }

        public List<Object> getCustomerPhone() {
            return customerPhone;
        }

        public void setCustomerPhone(List<Object> customerPhone) {
            this.customerPhone = customerPhone;
        }

        public List<CustomerPhoneType> getCustomerPhoneType() {
            return customerPhoneType;
        }

        public void setCustomerPhoneType(List<CustomerPhoneType> customerPhoneType) {
            this.customerPhoneType = customerPhoneType;
        }

        public List<CustomerPrefix> getCustomerPrefix() {
            return customerPrefix;
        }

        public void setCustomerPrefix(List<CustomerPrefix> customerPrefix) {
            this.customerPrefix = customerPrefix;
        }

        public List<Object> getCustomerProductGroup() {
            return customerProductGroup;
        }

        public void setCustomerProductGroup(List<Object> customerProductGroup) {
            this.customerProductGroup = customerProductGroup;
        }

        public List<Object> getCustomerProductType() {
            return customerProductType;
        }

        public void setCustomerProductType(List<Object> customerProductType) {
            this.customerProductType = customerProductType;
        }

        public List<Object> getCustomerProtocolObjectType() {
            return customerProtocolObjectType;
        }

        public void setCustomerProtocolObjectType(List<Object> customerProtocolObjectType) {
            this.customerProtocolObjectType = customerProtocolObjectType;
        }

        public List<CustomerQualificationGroup> getCustomerQualificationGroup() {
            return customerQualificationGroup;
        }

        public void setCustomerQualificationGroup(List<CustomerQualificationGroup> customerQualificationGroup) {
            this.customerQualificationGroup = customerQualificationGroup;
        }

        public List<CustomerQualificationType> getCustomerQualificationType() {
            return customerQualificationType;
        }

        public void setCustomerQualificationType(List<CustomerQualificationType> customerQualificationType) {
            this.customerQualificationType = customerQualificationType;
        }

        public List<CustomerReligionType> getCustomerReligionType() {
            return customerReligionType;
        }

        public void setCustomerReligionType(List<CustomerReligionType> customerReligionType) {
            this.customerReligionType = customerReligionType;
        }

        public List<CustomerRenewalPeriod> getCustomerRenewalPeriod() {
            return customerRenewalPeriod;
        }

        public void setCustomerRenewalPeriod(List<CustomerRenewalPeriod> customerRenewalPeriod) {
            this.customerRenewalPeriod = customerRenewalPeriod;
        }

        public List<CustomerReviewType> getCustomerReviewType() {
            return customerReviewType;
        }

        public void setCustomerReviewType(List<CustomerReviewType> customerReviewType) {
            this.customerReviewType = customerReviewType;
        }

        public List<CustomerSchedule> getCustomerSchedule() {
            return customerSchedule;
        }

        public void setCustomerSchedule(List<CustomerSchedule> customerSchedule) {
            this.customerSchedule = customerSchedule;
        }

        public List<CustomerSeason> getCustomerSeason() {
            return customerSeason;
        }

        public void setCustomerSeason(List<CustomerSeason> customerSeason) {
            this.customerSeason = customerSeason;
        }

        public List<CustomerSexualityType> getCustomerSexualityType() {
            return customerSexualityType;
        }

        public void setCustomerSexualityType(List<CustomerSexualityType> customerSexualityType) {
            this.customerSexualityType = customerSexualityType;
        }

        public List<Object> getCustomerShiftBreak() {
            return customerShiftBreak;
        }

        public void setCustomerShiftBreak(List<Object> customerShiftBreak) {
            this.customerShiftBreak = customerShiftBreak;
        }

        public List<Object> getCustomerShiftBreakWeekday() {
            return customerShiftBreakWeekday;
        }

        public void setCustomerShiftBreakWeekday(List<Object> customerShiftBreakWeekday) {
            this.customerShiftBreakWeekday = customerShiftBreakWeekday;
        }

        public List<CustomerShiftPlan> getCustomerShiftPlan() {
            return customerShiftPlan;
        }

        public void setCustomerShiftPlan(List<CustomerShiftPlan> customerShiftPlan) {
            this.customerShiftPlan = customerShiftPlan;
        }

        public List<CustomerSkillGroup> getCustomerSkillGroup() {
            return customerSkillGroup;
        }

        public void setCustomerSkillGroup(List<CustomerSkillGroup> customerSkillGroup) {
            this.customerSkillGroup = customerSkillGroup;
        }

        public List<CustomerSkillLevel> getCustomerSkillLevel() {
            return customerSkillLevel;
        }

        public void setCustomerSkillLevel(List<CustomerSkillLevel> customerSkillLevel) {
            this.customerSkillLevel = customerSkillLevel;
        }

        public List<CustomerSkillType> getCustomerSkillType() {
            return customerSkillType;
        }

        public void setCustomerSkillType(List<CustomerSkillType> customerSkillType) {
            this.customerSkillType = customerSkillType;
        }

        public List<Object> getCustomerTaskDeviationType() {
            return customerTaskDeviationType;
        }

        public void setCustomerTaskDeviationType(List<Object> customerTaskDeviationType) {
            this.customerTaskDeviationType = customerTaskDeviationType;
        }

        public List<CustomerTaskPriority> getCustomerTaskPriority() {
            return customerTaskPriority;
        }

        public void setCustomerTaskPriority(List<CustomerTaskPriority> customerTaskPriority) {
            this.customerTaskPriority = customerTaskPriority;
        }

        public List<CustomerTaskType> getCustomerTaskType() {
            return customerTaskType;
        }

        public void setCustomerTaskType(List<CustomerTaskType> customerTaskType) {
            this.customerTaskType = customerTaskType;
        }

        public List<CustomerTeamType> getCustomerTeamType() {
            return customerTeamType;
        }

        public void setCustomerTeamType(List<CustomerTeamType> customerTeamType) {
            this.customerTeamType = customerTeamType;
        }

        public List<CustomerTelephoneCountryPrefix> getCustomerTelephoneCountryPrefix() {
            return customerTelephoneCountryPrefix;
        }

        public void setCustomerTelephoneCountryPrefix(List<CustomerTelephoneCountryPrefix> customerTelephoneCountryPrefix) {
            this.customerTelephoneCountryPrefix = customerTelephoneCountryPrefix;
        }

        public List<CustomerTrainingCourseGroup> getCustomerTrainingCourseGroup() {
            return customerTrainingCourseGroup;
        }

        public void setCustomerTrainingCourseGroup(List<CustomerTrainingCourseGroup> customerTrainingCourseGroup) {
            this.customerTrainingCourseGroup = customerTrainingCourseGroup;
        }

        public List<CustomerTrainingType> getCustomerTrainingType() {
            return customerTrainingType;
        }

        public void setCustomerTrainingType(List<CustomerTrainingType> customerTrainingType) {
            this.customerTrainingType = customerTrainingType;
        }

        public List<CustomerTrainingTypeGroup> getCustomerTrainingTypeGroup() {
            return customerTrainingTypeGroup;
        }

        public void setCustomerTrainingTypeGroup(List<CustomerTrainingTypeGroup> customerTrainingTypeGroup) {
            this.customerTrainingTypeGroup = customerTrainingTypeGroup;
        }

        public List<CustomerTransportType> getCustomerTransportType() {
            return customerTransportType;
        }

        public void setCustomerTransportType(List<CustomerTransportType> customerTransportType) {
            this.customerTransportType = customerTransportType;
        }

        public List<CustomerUserRole> getCustomerUserRole() {
            return customerUserRole;
        }

        public void setCustomerUserRole(List<CustomerUserRole> customerUserRole) {
            this.customerUserRole = customerUserRole;
        }

        public List<CustomerWeekNumber> getCustomerWeekNumber() {
            return customerWeekNumber;
        }

        public void setCustomerWeekNumber(List<CustomerWeekNumber> customerWeekNumber) {
            this.customerWeekNumber = customerWeekNumber;
        }

        public List<CustomerWeekNumberType> getCustomerWeekNumberType() {
            return customerWeekNumberType;
        }

        public void setCustomerWeekNumberType(List<CustomerWeekNumberType> customerWeekNumberType) {
            this.customerWeekNumberType = customerWeekNumberType;
        }

        public List<CustomerWeekRotationType> getCustomerWeekRotationType() {
            return customerWeekRotationType;
        }

        public void setCustomerWeekRotationType(List<CustomerWeekRotationType> customerWeekRotationType) {
            this.customerWeekRotationType = customerWeekRotationType;
        }

        public List<CustomerWeekday> getCustomerWeekday() {
            return customerWeekday;
        }

        public void setCustomerWeekday(List<CustomerWeekday> customerWeekday) {
            this.customerWeekday = customerWeekday;
        }

        public List<CustomerYear> getCustomerYear() {
            return customerYear;
        }

        public void setCustomerYear(List<CustomerYear> customerYear) {
            this.customerYear = customerYear;
        }

        public String getModifiedDate() {
            return modifiedDate;
        }

        public void setModifiedDate(String modifiedDate) {
            this.modifiedDate = modifiedDate;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

    }

    public class CustomerAccountingSystem {

        @SerializedName("AccountingSystemName")
        @Expose
        private String accountingSystemName;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;

        public String getAccountingSystemName() {
            return accountingSystemName;
        }

        public void setAccountingSystemName(String accountingSystemName) {
            this.accountingSystemName = accountingSystemName;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

    }

    public class CustomerActionStatusType {

        @SerializedName("ActionStatusTypeName")
        @Expose
        private String actionStatusTypeName;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;

        public String getActionStatusTypeName() {
            return actionStatusTypeName;
        }

        public void setActionStatusTypeName(String actionStatusTypeName) {
            this.actionStatusTypeName = actionStatusTypeName;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

    }

    public class CustomerActionType {

        @SerializedName("ActionTypeName")
        @Expose
        private String actionTypeName;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;

        public String getActionTypeName() {
            return actionTypeName;
        }

        public void setActionTypeName(String actionTypeName) {
            this.actionTypeName = actionTypeName;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
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

    public class CustomerAllergyType {

        @SerializedName("AllergyTypeName")
        @Expose
        private String allergyTypeName;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;

        public String getAllergyTypeName() {
            return allergyTypeName;
        }

        public void setAllergyTypeName(String allergyTypeName) {
            this.allergyTypeName = allergyTypeName;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

    }

    public class CustomerApplicationProcessStep {

        @SerializedName("ApplicantProcessStepName")
        @Expose
        private Integer applicantProcessStepName;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;

        public Integer getApplicantProcessStepName() {
            return applicantProcessStepName;
        }

        public void setApplicantProcessStepName(Integer applicantProcessStepName) {
            this.applicantProcessStepName = applicantProcessStepName;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

    }

    public class CustomerAssetsType {

        @SerializedName("AssetsTypeName")
        @Expose
        private String assetsTypeName;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;

        public String getAssetsTypeName() {
            return assetsTypeName;
        }

        public void setAssetsTypeName(String assetsTypeName) {
            this.assetsTypeName = assetsTypeName;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

    }

    public class CustomerBookingConfirmationType {

        @SerializedName("BookingConfirmationTypeName")
        @Expose
        private String bookingConfirmationTypeName;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;

        public String getBookingConfirmationTypeName() {
            return bookingConfirmationTypeName;
        }

        public void setBookingConfirmationTypeName(String bookingConfirmationTypeName) {
            this.bookingConfirmationTypeName = bookingConfirmationTypeName;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

    }

    public class CustomerBookingStatusType {

        @SerializedName("BookingStatusTypeName")
        @Expose
        private String bookingStatusTypeName;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;

        public String getBookingStatusTypeName() {
            return bookingStatusTypeName;
        }

        public void setBookingStatusTypeName(String bookingStatusTypeName) {
            this.bookingStatusTypeName = bookingStatusTypeName;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

    }

    public class CustomerClearanceType {

        @SerializedName("ClearanceTypeName")
        @Expose
        private String clearanceTypeName;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;

        public String getClearanceTypeName() {
            return clearanceTypeName;
        }

        public void setClearanceTypeName(String clearanceTypeName) {
            this.clearanceTypeName = clearanceTypeName;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

    }

    public class CustomerClientActivityLevelType {

        @SerializedName("ClientActivityLevelTypeName")
        @Expose
        private String clientActivityLevelTypeName;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;

        public String getClientActivityLevelTypeName() {
            return clientActivityLevelTypeName;
        }

        public void setClientActivityLevelTypeName(String clientActivityLevelTypeName) {
            this.clientActivityLevelTypeName = clientActivityLevelTypeName;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

    }

    public class CustomerClientType {

        @SerializedName("ClientTypeName")
        @Expose
        private String clientTypeName;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;

        public String getClientTypeName() {
            return clientTypeName;
        }

        public void setClientTypeName(String clientTypeName) {
            this.clientTypeName = clientTypeName;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

    }

    public class CustomerConsequence {

        @SerializedName("ConsequenceName")
        @Expose
        private String consequenceName;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;

        public String getConsequenceName() {
            return consequenceName;
        }

        public void setConsequenceName(String consequenceName) {
            this.consequenceName = consequenceName;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

    }

    public class CustomerContactRoleType {

        @SerializedName("ContactRoleTypeName")
        @Expose
        private String contactRoleTypeName;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;

        public String getContactRoleTypeName() {
            return contactRoleTypeName;
        }

        public void setContactRoleTypeName(String contactRoleTypeName) {
            this.contactRoleTypeName = contactRoleTypeName;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

    }

    public class CustomerContactType {

        @SerializedName("ContactTypeName")
        @Expose
        private String contactTypeName;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;

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

    }

    public class CustomerContractCategory {

        @SerializedName("ContractCategoryName")
        @Expose
        private String contractCategoryName;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;

        public String getContractCategoryName() {
            return contractCategoryName;
        }

        public void setContractCategoryName(String contractCategoryName) {
            this.contractCategoryName = contractCategoryName;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

    }

    public class CustomerContractCategoryContractType {

        @SerializedName("ContractCategoryName")
        @Expose
        private String contractCategoryName;
        @SerializedName("ContractTypeName")
        @Expose
        private String contractTypeName;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;

        public String getContractCategoryName() {
            return contractCategoryName;
        }

        public void setContractCategoryName(String contractCategoryName) {
            this.contractCategoryName = contractCategoryName;
        }

        public String getContractTypeName() {
            return contractTypeName;
        }

        public void setContractTypeName(String contractTypeName) {
            this.contractTypeName = contractTypeName;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

    }

    public class CustomerContractType {

        @SerializedName("ContractTypeName")
        @Expose
        private String contractTypeName;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;

        public String getContractTypeName() {
            return contractTypeName;
        }

        public void setContractTypeName(String contractTypeName) {
            this.contractTypeName = contractTypeName;
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

    public class CustomerCriminalRecordType {

        @SerializedName("CriminalRecordTypeName")
        @Expose
        private String criminalRecordTypeName;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;

        public String getCriminalRecordTypeName() {
            return criminalRecordTypeName;
        }

        public void setCriminalRecordTypeName(String criminalRecordTypeName) {
            this.criminalRecordTypeName = criminalRecordTypeName;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

    }

    public class CustomerDateOfMonth {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("Date")
        @Expose
        private String date;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
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

    public class CustomerDocumentCategory {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("DocumentCategoryName")
        @Expose
        private String documentCategoryName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getDocumentCategoryName() {
            return documentCategoryName;
        }

        public void setDocumentCategoryName(String documentCategoryName) {
            this.documentCategoryName = documentCategoryName;
        }

    }

    public class CustomerDocumentFileType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("DocumentTypeName")
        @Expose
        private String documentTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getDocumentTypeName() {
            return documentTypeName;
        }

        public void setDocumentTypeName(String documentTypeName) {
            this.documentTypeName = documentTypeName;
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

    public class CustomerEmployeeEmployeeRole {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("EmployeeEmployeeRoleName")
        @Expose
        private String employeeEmployeeRoleName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getEmployeeEmployeeRoleName() {
            return employeeEmployeeRoleName;
        }

        public void setEmployeeEmployeeRoleName(String employeeEmployeeRoleName) {
            this.employeeEmployeeRoleName = employeeEmployeeRoleName;
        }

    }

    public class CustomerEmployeeGroup {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("EmployeeGroupName")
        @Expose
        private String employeeGroupName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getEmployeeGroupName() {
            return employeeGroupName;
        }

        public void setEmployeeGroupName(String employeeGroupName) {
            this.employeeGroupName = employeeGroupName;
        }

    }

    public class CustomerEmployeeStatusType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("EmployeeStatusTypeName")
        @Expose
        private String employeeStatusTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getEmployeeStatusTypeName() {
            return employeeStatusTypeName;
        }

        public void setEmployeeStatusTypeName(String employeeStatusTypeName) {
            this.employeeStatusTypeName = employeeStatusTypeName;
        }

    }

    public class CustomerEmployeeType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("EmployeeTypeName")
        @Expose
        private String employeeTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getEmployeeTypeName() {
            return employeeTypeName;
        }

        public void setEmployeeTypeName(String employeeTypeName) {
            this.employeeTypeName = employeeTypeName;
        }

    }

    public class CustomerEmploymentApplicationType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("EmploymentApplicationTypeName")
        @Expose
        private String employmentApplicationTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getEmploymentApplicationTypeName() {
            return employmentApplicationTypeName;
        }

        public void setEmploymentApplicationTypeName(String employmentApplicationTypeName) {
            this.employmentApplicationTypeName = employmentApplicationTypeName;
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


    public class CustomerFluidChartType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("FluidChartTypeName")
        @Expose
        private String fluidChartTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getFluidChartTypeName() {
            return fluidChartTypeName;
        }

        public void setFluidChartTypeName(String fluidChartTypeName) {
            this.fluidChartTypeName = fluidChartTypeName;
        }

    }

    public class CustomerFluidIO {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("FluidIOName")
        @Expose
        private String fluidIOName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getFluidIOName() {
            return fluidIOName;
        }

        public void setFluidIOName(String fluidIOName) {
            this.fluidIOName = fluidIOName;
        }

    }


    public class CustomerFluidThickenedType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("FluidThickenedTypeName")
        @Expose
        private String fluidThickenedTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getFluidThickenedTypeName() {
            return fluidThickenedTypeName;
        }

        public void setFluidThickenedTypeName(String fluidThickenedTypeName) {
            this.fluidThickenedTypeName = fluidThickenedTypeName;
        }

    }

    public class CustomerFluidType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("FluidTypeName")
        @Expose
        private String fluidTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getFluidTypeName() {
            return fluidTypeName;
        }

        public void setFluidTypeName(String fluidTypeName) {
            this.fluidTypeName = fluidTypeName;
        }

    }

    public class CustomerFood {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("FoodName")
        @Expose
        private String foodName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getFoodName() {
            return foodName;
        }

        public void setFoodName(String foodName) {
            this.foodName = foodName;
        }

    }

    public class CustomerFoodChartType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("FoodChartTypeName")
        @Expose
        private String foodChartTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getFoodChartTypeName() {
            return foodChartTypeName;
        }

        public void setFoodChartTypeName(String foodChartTypeName) {
            this.foodChartTypeName = foodChartTypeName;
        }

    }

    public class CustomerFoodType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("FoodTypeName")
        @Expose
        private String foodTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getFoodTypeName() {
            return foodTypeName;
        }

        public void setFoodTypeName(String foodTypeName) {
            this.foodTypeName = foodTypeName;
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

    public class CustomerHealthDeclarationType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("HealthDeclarationTypeName")
        @Expose
        private String healthDeclarationTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getHealthDeclarationTypeName() {
            return healthDeclarationTypeName;
        }

        public void setHealthDeclarationTypeName(String healthDeclarationTypeName) {
            this.healthDeclarationTypeName = healthDeclarationTypeName;
        }

    }

    public class CustomerHomeClientType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("HomeClientTypeName")
        @Expose
        private String homeClientTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getHomeClientTypeName() {
            return homeClientTypeName;
        }

        public void setHomeClientTypeName(String homeClientTypeName) {
            this.homeClientTypeName = homeClientTypeName;
        }

    }

    public class CustomerHomeType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("HomeTypeName")
        @Expose
        private String homeTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getHomeTypeName() {
            return homeTypeName;
        }

        public void setHomeTypeName(String homeTypeName) {
            this.homeTypeName = homeTypeName;
        }

    }

    public class CustomerHourOfDay {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("Hour")
        @Expose
        private String hour;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getHour() {
            return hour;
        }

        public void setHour(String hour) {
            this.hour = hour;
        }

    }

    public class CustomerIdentificationType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("IdentificationTypeName")
        @Expose
        private String identificationTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getIdentificationTypeName() {
            return identificationTypeName;
        }

        public void setIdentificationTypeName(String identificationTypeName) {
            this.identificationTypeName = identificationTypeName;
        }

    }

    public class CustomerImmunisationType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("ImmunisationTypeName")
        @Expose
        private String immunisationTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getImmunisationTypeName() {
            return immunisationTypeName;
        }

        public void setImmunisationTypeName(String immunisationTypeName) {
            this.immunisationTypeName = immunisationTypeName;
        }

    }

    public class CustomerIncompatibillityType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("IncompatibillityTypeName")
        @Expose
        private String incompatibillityTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getIncompatibillityTypeName() {
            return incompatibillityTypeName;
        }

        public void setIncompatibillityTypeName(String incompatibillityTypeName) {
            this.incompatibillityTypeName = incompatibillityTypeName;
        }

    }

    public class CustomerInterestGroup {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("InterestGroupName")
        @Expose
        private String interestGroupName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getInterestGroupName() {
            return interestGroupName;
        }

        public void setInterestGroupName(String interestGroupName) {
            this.interestGroupName = interestGroupName;
        }

    }

    public class CustomerInterestType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("InterestTypeName")
        @Expose
        private String interestTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getInterestTypeName() {
            return interestTypeName;
        }

        public void setInterestTypeName(String interestTypeName) {
            this.interestTypeName = interestTypeName;
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

    public class CustomerLanguageCountry {

        @SerializedName("CountryName")
        @Expose
        private String countryName;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("LanguageCodeName")
        @Expose
        private String languageCodeName;

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

        public String getLanguageCodeName() {
            return languageCodeName;
        }

        public void setLanguageCodeName(String languageCodeName) {
            this.languageCodeName = languageCodeName;
        }

    }

    public class CustomerLeaveType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("LeaveTypeName")
        @Expose
        private String leaveTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getLeaveTypeName() {
            return leaveTypeName;
        }

        public void setLeaveTypeName(String leaveTypeName) {
            this.leaveTypeName = leaveTypeName;
        }

    }

    public class CustomerLoanInstalmentType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("LoanInstalmentTypeName")
        @Expose
        private String loanInstalmentTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getLoanInstalmentTypeName() {
            return loanInstalmentTypeName;
        }

        public void setLoanInstalmentTypeName(String loanInstalmentTypeName) {
            this.loanInstalmentTypeName = loanInstalmentTypeName;
        }

    }

    public class CustomerLoanType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("LoanTypeName")
        @Expose
        private String loanTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getLoanTypeName() {
            return loanTypeName;
        }

        public void setLoanTypeName(String loanTypeName) {
            this.loanTypeName = loanTypeName;
        }

    }

    public class CustomerMARSheetType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("MARSheetTypeName")
        @Expose
        private String mARSheetTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getMARSheetTypeName() {
            return mARSheetTypeName;
        }

        public void setMARSheetTypeName(String mARSheetTypeName) {
            this.mARSheetTypeName = mARSheetTypeName;
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

    public class CustomerMatchingLevelGroup {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("MatchingLevelGroupName")
        @Expose
        private String matchingLevelGroupName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getMatchingLevelGroupName() {
            return matchingLevelGroupName;
        }

        public void setMatchingLevelGroupName(String matchingLevelGroupName) {
            this.matchingLevelGroupName = matchingLevelGroupName;
        }

    }

    public class CustomerMatchingLevelIndex {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("MatchingLevelIndexValue")
        @Expose
        private Integer matchingLevelIndexValue;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public Integer getMatchingLevelIndexValue() {
            return matchingLevelIndexValue;
        }

        public void setMatchingLevelIndexValue(Integer matchingLevelIndexValue) {
            this.matchingLevelIndexValue = matchingLevelIndexValue;
        }

    }

    public class CustomerMealType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("MealTypeName")
        @Expose
        private String mealTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getMealTypeName() {
            return mealTypeName;
        }

        public void setMealTypeName(String mealTypeName) {
            this.mealTypeName = mealTypeName;
        }

    }

    public class CustomerMedicationDeviationType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("MedicationDeviationTypeName")
        @Expose
        private String medicationDeviationTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getMedicationDeviationTypeName() {
            return medicationDeviationTypeName;
        }

        public void setMedicationDeviationTypeName(String medicationDeviationTypeName) {
            this.medicationDeviationTypeName = medicationDeviationTypeName;
        }

    }

    public class CustomerMessageReceiverGroup {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("MessageReceiverGroupName")
        @Expose
        private String messageReceiverGroupName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getMessageReceiverGroupName() {
            return messageReceiverGroupName;
        }

        public void setMessageReceiverGroupName(String messageReceiverGroupName) {
            this.messageReceiverGroupName = messageReceiverGroupName;
        }

    }

    public class CustomerMessageSentToType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("MessageSentToTypeName")
        @Expose
        private String messageSentToTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getMessageSentToTypeName() {
            return messageSentToTypeName;
        }

        public void setMessageSentToTypeName(String messageSentToTypeName) {
            this.messageSentToTypeName = messageSentToTypeName;
        }

    }

    public class CustomerMessageTemplateType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("MessageTemplateTypeName")
        @Expose
        private String messageTemplateTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getMessageTemplateTypeName() {
            return messageTemplateTypeName;
        }

        public void setMessageTemplateTypeName(String messageTemplateTypeName) {
            this.messageTemplateTypeName = messageTemplateTypeName;
        }

    }

    public class CustomerMessageType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("MessageTypeName")
        @Expose
        private String messageTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getMessageTypeName() {
            return messageTypeName;
        }

        public void setMessageTypeName(String messageTypeName) {
            this.messageTypeName = messageTypeName;
        }

    }

    public class CustomerMinuteOfDay {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("Minute")
        @Expose
        private String minute;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getMinute() {
            return minute;
        }

        public void setMinute(String minute) {
            this.minute = minute;
        }

    }

    public class CustomerMonitoringType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("MonitoringTypeName")
        @Expose
        private String monitoringTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getMonitoringTypeName() {
            return monitoringTypeName;
        }

        public void setMonitoringTypeName(String monitoringTypeName) {
            this.monitoringTypeName = monitoringTypeName;
        }

    }

    public class CustomerMonthOfTheYear {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("MonthName")
        @Expose
        private String monthName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getMonthName() {
            return monthName;
        }

        public void setMonthName(String monthName) {
            this.monthName = monthName;
        }

    }

    public class CustomerNoteType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("NoteTypeName")
        @Expose
        private String noteTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getNoteTypeName() {
            return noteTypeName;
        }

        public void setNoteTypeName(String noteTypeName) {
            this.noteTypeName = noteTypeName;
        }

    }

    public class CustomerNoticePeriod {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("NoticePeriodTypeName")
        @Expose
        private String noticePeriodTypeName;
        @SerializedName("NoticePeriodValueName")
        @Expose
        private Integer noticePeriodValueName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getNoticePeriodTypeName() {
            return noticePeriodTypeName;
        }

        public void setNoticePeriodTypeName(String noticePeriodTypeName) {
            this.noticePeriodTypeName = noticePeriodTypeName;
        }

        public Integer getNoticePeriodValueName() {
            return noticePeriodValueName;
        }

        public void setNoticePeriodValueName(Integer noticePeriodValueName) {
            this.noticePeriodValueName = noticePeriodValueName;
        }

    }

    public class CustomerPaymentFrequencyType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("PaymentFrequencyTypeName")
        @Expose
        private String paymentFrequencyTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getPaymentFrequencyTypeName() {
            return paymentFrequencyTypeName;
        }

        public void setPaymentFrequencyTypeName(String paymentFrequencyTypeName) {
            this.paymentFrequencyTypeName = paymentFrequencyTypeName;
        }

    }

    public class CustomerPeriodOfDayType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("Period")
        @Expose
        private String period;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getPeriod() {
            return period;
        }

        public void setPeriod(String period) {
            this.period = period;
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

    public class CustomerQualificationGroup {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("QualificationGroupName")
        @Expose
        private String qualificationGroupName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getQualificationGroupName() {
            return qualificationGroupName;
        }

        public void setQualificationGroupName(String qualificationGroupName) {
            this.qualificationGroupName = qualificationGroupName;
        }

    }

    public class CustomerQualificationType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("IsMandatory")
        @Expose
        private Boolean isMandatory;
        @SerializedName("QualificationTypeName")
        @Expose
        private String qualificationTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public Boolean getIsMandatory() {
            return isMandatory;
        }

        public void setIsMandatory(Boolean isMandatory) {
            this.isMandatory = isMandatory;
        }

        public String getQualificationTypeName() {
            return qualificationTypeName;
        }

        public void setQualificationTypeName(String qualificationTypeName) {
            this.qualificationTypeName = qualificationTypeName;
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

    public class CustomerRenewalPeriod {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("RenewalPeriodName")
        @Expose
        private String renewalPeriodName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getRenewalPeriodName() {
            return renewalPeriodName;
        }

        public void setRenewalPeriodName(String renewalPeriodName) {
            this.renewalPeriodName = renewalPeriodName;
        }

    }

    public class CustomerReviewType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("ReviewTypeName")
        @Expose
        private String reviewTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getReviewTypeName() {
            return reviewTypeName;
        }

        public void setReviewTypeName(String reviewTypeName) {
            this.reviewTypeName = reviewTypeName;
        }

    }

    public class CustomerSchedule {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("CustomerScheduleBreak")
        @Expose
        private List<Object> customerScheduleBreak = null;
        @SerializedName("IsExtended")
        @Expose
        private Boolean isExtended;
        @SerializedName("SchedulePlanAdded")
        @Expose
        private String schedulePlanAdded;
        @SerializedName("TimeTableCreatedDate")
        @Expose
        private String timeTableCreatedDate;
        @SerializedName("TimeTableName")
        @Expose
        private String timeTableName;
        @SerializedName("WeekRotationTypeName")
        @Expose
        private String weekRotationTypeName;
        @SerializedName("WeekdayName")
        @Expose
        private String weekdayName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public List<Object> getCustomerScheduleBreak() {
            return customerScheduleBreak;
        }

        public void setCustomerScheduleBreak(List<Object> customerScheduleBreak) {
            this.customerScheduleBreak = customerScheduleBreak;
        }

        public Boolean getIsExtended() {
            return isExtended;
        }

        public void setIsExtended(Boolean isExtended) {
            this.isExtended = isExtended;
        }

        public String getSchedulePlanAdded() {
            return schedulePlanAdded;
        }

        public void setSchedulePlanAdded(String schedulePlanAdded) {
            this.schedulePlanAdded = schedulePlanAdded;
        }

        public String getTimeTableCreatedDate() {
            return timeTableCreatedDate;
        }

        public void setTimeTableCreatedDate(String timeTableCreatedDate) {
            this.timeTableCreatedDate = timeTableCreatedDate;
        }

        public String getTimeTableName() {
            return timeTableName;
        }

        public void setTimeTableName(String timeTableName) {
            this.timeTableName = timeTableName;
        }

        public String getWeekRotationTypeName() {
            return weekRotationTypeName;
        }

        public void setWeekRotationTypeName(String weekRotationTypeName) {
            this.weekRotationTypeName = weekRotationTypeName;
        }

        public String getWeekdayName() {
            return weekdayName;
        }

        public void setWeekdayName(String weekdayName) {
            this.weekdayName = weekdayName;
        }

    }

    public class CustomerSchedule_ {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("CustomerScheduleBreak")
        @Expose
        private List<Object> customerScheduleBreak = null;
        @SerializedName("IsExtended")
        @Expose
        private Boolean isExtended;
        @SerializedName("SchedulePlanAdded")
        @Expose
        private String schedulePlanAdded;
        @SerializedName("TimeTableCreatedDate")
        @Expose
        private String timeTableCreatedDate;
        @SerializedName("TimeTableName")
        @Expose
        private String timeTableName;
        @SerializedName("WeekRotationTypeName")
        @Expose
        private String weekRotationTypeName;
        @SerializedName("WeekdayName")
        @Expose
        private String weekdayName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public List<Object> getCustomerScheduleBreak() {
            return customerScheduleBreak;
        }

        public void setCustomerScheduleBreak(List<Object> customerScheduleBreak) {
            this.customerScheduleBreak = customerScheduleBreak;
        }

        public Boolean getIsExtended() {
            return isExtended;
        }

        public void setIsExtended(Boolean isExtended) {
            this.isExtended = isExtended;
        }

        public String getSchedulePlanAdded() {
            return schedulePlanAdded;
        }

        public void setSchedulePlanAdded(String schedulePlanAdded) {
            this.schedulePlanAdded = schedulePlanAdded;
        }

        public String getTimeTableCreatedDate() {
            return timeTableCreatedDate;
        }

        public void setTimeTableCreatedDate(String timeTableCreatedDate) {
            this.timeTableCreatedDate = timeTableCreatedDate;
        }

        public String getTimeTableName() {
            return timeTableName;
        }

        public void setTimeTableName(String timeTableName) {
            this.timeTableName = timeTableName;
        }

        public String getWeekRotationTypeName() {
            return weekRotationTypeName;
        }

        public void setWeekRotationTypeName(String weekRotationTypeName) {
            this.weekRotationTypeName = weekRotationTypeName;
        }

        public String getWeekdayName() {
            return weekdayName;
        }

        public void setWeekdayName(String weekdayName) {
            this.weekdayName = weekdayName;
        }

    }

    public class CustomerSeason {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("SeasonName")
        @Expose
        private String seasonName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getSeasonName() {
            return seasonName;
        }

        public void setSeasonName(String seasonName) {
            this.seasonName = seasonName;
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

    public class CustomerShiftPlan {

        @SerializedName("CustomEndHour")
        @Expose
        private String customEndHour;
        @SerializedName("CustomEndMinute")
        @Expose
        private String customEndMinute;
        @SerializedName("CustomStartHour")
        @Expose
        private String customStartHour;
        @SerializedName("CustomStartMinute")
        @Expose
        private String customStartMinute;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("CustomerShiftBreak")
        @Expose
        private List<Object> customerShiftBreak = null;
        @SerializedName("CustomerShiftWeekday")
        @Expose
        private List<Object> customerShiftWeekday = null;
        @SerializedName("IsOverRidingTimeTable")
        @Expose
        private Boolean isOverRidingTimeTable;
        @SerializedName("ShiftPlanAdded")
        @Expose
        private String shiftPlanAdded;
        @SerializedName("ShiftPlanName")
        @Expose
        private String shiftPlanName;
        @SerializedName("TimeTableCreatedDate")
        @Expose
        private String timeTableCreatedDate;
        @SerializedName("TimeTableName")
        @Expose
        private String timeTableName;

        public String getCustomEndHour() {
            return customEndHour;
        }

        public void setCustomEndHour(String customEndHour) {
            this.customEndHour = customEndHour;
        }

        public String getCustomEndMinute() {
            return customEndMinute;
        }

        public void setCustomEndMinute(String customEndMinute) {
            this.customEndMinute = customEndMinute;
        }

        public String getCustomStartHour() {
            return customStartHour;
        }

        public void setCustomStartHour(String customStartHour) {
            this.customStartHour = customStartHour;
        }

        public String getCustomStartMinute() {
            return customStartMinute;
        }

        public void setCustomStartMinute(String customStartMinute) {
            this.customStartMinute = customStartMinute;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public List<Object> getCustomerShiftBreak() {
            return customerShiftBreak;
        }

        public void setCustomerShiftBreak(List<Object> customerShiftBreak) {
            this.customerShiftBreak = customerShiftBreak;
        }

        public List<Object> getCustomerShiftWeekday() {
            return customerShiftWeekday;
        }

        public void setCustomerShiftWeekday(List<Object> customerShiftWeekday) {
            this.customerShiftWeekday = customerShiftWeekday;
        }

        public Boolean getIsOverRidingTimeTable() {
            return isOverRidingTimeTable;
        }

        public void setIsOverRidingTimeTable(Boolean isOverRidingTimeTable) {
            this.isOverRidingTimeTable = isOverRidingTimeTable;
        }

        public String getShiftPlanAdded() {
            return shiftPlanAdded;
        }

        public void setShiftPlanAdded(String shiftPlanAdded) {
            this.shiftPlanAdded = shiftPlanAdded;
        }

        public String getShiftPlanName() {
            return shiftPlanName;
        }

        public void setShiftPlanName(String shiftPlanName) {
            this.shiftPlanName = shiftPlanName;
        }

        public String getTimeTableCreatedDate() {
            return timeTableCreatedDate;
        }

        public void setTimeTableCreatedDate(String timeTableCreatedDate) {
            this.timeTableCreatedDate = timeTableCreatedDate;
        }

        public String getTimeTableName() {
            return timeTableName;
        }

        public void setTimeTableName(String timeTableName) {
            this.timeTableName = timeTableName;
        }

    }

    public class CustomerSkillGroup {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("SkillGroupName")
        @Expose
        private String skillGroupName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getSkillGroupName() {
            return skillGroupName;
        }

        public void setSkillGroupName(String skillGroupName) {
            this.skillGroupName = skillGroupName;
        }

    }

    public class CustomerSkillLevel {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("SkillLevelName")
        @Expose
        private String skillLevelName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getSkillLevelName() {
            return skillLevelName;
        }

        public void setSkillLevelName(String skillLevelName) {
            this.skillLevelName = skillLevelName;
        }

    }

    public class CustomerSkillType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("IsMandatory")
        @Expose
        private Boolean isMandatory;
        @SerializedName("SkillTypeName")
        @Expose
        private String skillTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public Boolean getIsMandatory() {
            return isMandatory;
        }

        public void setIsMandatory(Boolean isMandatory) {
            this.isMandatory = isMandatory;
        }

        public String getSkillTypeName() {
            return skillTypeName;
        }

        public void setSkillTypeName(String skillTypeName) {
            this.skillTypeName = skillTypeName;
        }

    }

    public class CustomerTaskPriority {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("TaskPriorityName")
        @Expose
        private String taskPriorityName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getTaskPriorityName() {
            return taskPriorityName;
        }

        public void setTaskPriorityName(String taskPriorityName) {
            this.taskPriorityName = taskPriorityName;
        }

    }

    public class CustomerTaskType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("TaskTypeName")
        @Expose
        private String taskTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getTaskTypeName() {
            return taskTypeName;
        }

        public void setTaskTypeName(String taskTypeName) {
            this.taskTypeName = taskTypeName;
        }

    }

    public class CustomerTeamType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("TeamTypeName")
        @Expose
        private String teamTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getTeamTypeName() {
            return teamTypeName;
        }

        public void setTeamTypeName(String teamTypeName) {
            this.teamTypeName = teamTypeName;
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

    public class CustomerTrainingCourseGroup {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("TrainingCourseGroupName")
        @Expose
        private String trainingCourseGroupName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getTrainingCourseGroupName() {
            return trainingCourseGroupName;
        }

        public void setTrainingCourseGroupName(String trainingCourseGroupName) {
            this.trainingCourseGroupName = trainingCourseGroupName;
        }

    }

    public class CustomerTrainingType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("IsMandatory")
        @Expose
        private Boolean isMandatory;
        @SerializedName("TrainingTypeName")
        @Expose
        private String trainingTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public Boolean getIsMandatory() {
            return isMandatory;
        }

        public void setIsMandatory(Boolean isMandatory) {
            this.isMandatory = isMandatory;
        }

        public String getTrainingTypeName() {
            return trainingTypeName;
        }

        public void setTrainingTypeName(String trainingTypeName) {
            this.trainingTypeName = trainingTypeName;
        }

    }

    public class CustomerTrainingTypeGroup {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("TrainingTypeGroupName")
        @Expose
        private String trainingTypeGroupName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getTrainingTypeGroupName() {
            return trainingTypeGroupName;
        }

        public void setTrainingTypeGroupName(String trainingTypeGroupName) {
            this.trainingTypeGroupName = trainingTypeGroupName;
        }

    }

    public class CustomerTransportType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("TransportTypeName")
        @Expose
        private String transportTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getTransportTypeName() {
            return transportTypeName;
        }

        public void setTransportTypeName(String transportTypeName) {
            this.transportTypeName = transportTypeName;
        }

    }

    public class CustomerUserRole {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("WeatherConditionTypeName")
        @Expose
        private String weatherConditionTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getWeatherConditionTypeName() {
            return weatherConditionTypeName;
        }

        public void setWeatherConditionTypeName(String weatherConditionTypeName) {
            this.weatherConditionTypeName = weatherConditionTypeName;
        }

    }

    public class CustomerWeekNumber {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("WeekNumberName")
        @Expose
        private String weekNumberName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getWeekNumberName() {
            return weekNumberName;
        }

        public void setWeekNumberName(String weekNumberName) {
            this.weekNumberName = weekNumberName;
        }

    }

    public class CustomerWeekNumberType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("WeekNumberTypeName")
        @Expose
        private String weekNumberTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getWeekNumberTypeName() {
            return weekNumberTypeName;
        }

        public void setWeekNumberTypeName(String weekNumberTypeName) {
            this.weekNumberTypeName = weekNumberTypeName;
        }

    }

    public class CustomerWeekRotationType {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("CustomerSchedule")
        @Expose
        private List<CustomerSchedule_> customerSchedule = null;
        @SerializedName("WeekRotationTypeName")
        @Expose
        private String weekRotationTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public List<CustomerSchedule_> getCustomerSchedule() {
            return customerSchedule;
        }

        public void setCustomerSchedule(List<CustomerSchedule_> customerSchedule) {
            this.customerSchedule = customerSchedule;
        }

        public String getWeekRotationTypeName() {
            return weekRotationTypeName;
        }

        public void setWeekRotationTypeName(String weekRotationTypeName) {
            this.weekRotationTypeName = weekRotationTypeName;
        }

    }

    public class CustomerWeekday {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("IsFirstDayOfWeek")
        @Expose
        private Boolean isFirstDayOfWeek;
        @SerializedName("IsWeekEndDay")
        @Expose
        private Boolean isWeekEndDay;
        @SerializedName("WeekdayName")
        @Expose
        private String weekdayName;
        @SerializedName("WeekdayNumber")
        @Expose
        private String weekdayNumber;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public Boolean getIsFirstDayOfWeek() {
            return isFirstDayOfWeek;
        }

        public void setIsFirstDayOfWeek(Boolean isFirstDayOfWeek) {
            this.isFirstDayOfWeek = isFirstDayOfWeek;
        }

        public Boolean getIsWeekEndDay() {
            return isWeekEndDay;
        }

        public void setIsWeekEndDay(Boolean isWeekEndDay) {
            this.isWeekEndDay = isWeekEndDay;
        }

        public String getWeekdayName() {
            return weekdayName;
        }

        public void setWeekdayName(String weekdayName) {
            this.weekdayName = weekdayName;
        }

        public String getWeekdayNumber() {
            return weekdayNumber;
        }

        public void setWeekdayNumber(String weekdayNumber) {
            this.weekdayNumber = weekdayNumber;
        }

    }

    public class CustomerYear {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("YearNumber")
        @Expose
        private String yearNumber;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getYearNumber() {
            return yearNumber;
        }

        public void setYearNumber(String yearNumber) {
            this.yearNumber = yearNumber;
        }

    }

    public class Data {

        @SerializedName("AdminUsers")
        @Expose
        private List<Object> adminUsers = null;
        @SerializedName("ApplicationLicenses")
        @Expose
        private List<Object> applicationLicenses = null;
        @SerializedName("Applications")
        @Expose
        private List<Object> applications = null;
        @SerializedName("Branches")
        @Expose
        private List<Object> branches = null;
        @SerializedName("ContactPersons")
        @Expose
        private List<Object> contactPersons = null;
        @SerializedName("Customer")
        @Expose
        private Customer customer;
        @SerializedName("CustomerAddresses")
        @Expose
        private List<Object> customerAddresses = null;
        @SerializedName("CustomerEmployeeGroupEmployeeType")
        @Expose
        private Object customerEmployeeGroupEmployeeType;
        @SerializedName("CustomerEmployeeGroups")
        @Expose
        private Object customerEmployeeGroups;
        @SerializedName("CustomerEmployeeRoles")
        @Expose
        private Object customerEmployeeRoles;
        @SerializedName("CustomerEmployeeTypes")
        @Expose
        private Object customerEmployeeTypes;
        @SerializedName("Customers")
        @Expose
        private Object customers;
        @SerializedName("MainBranch")
        @Expose
        private Object mainBranch;

        public List<Object> getAdminUsers() {
            return adminUsers;
        }

        public void setAdminUsers(List<Object> adminUsers) {
            this.adminUsers = adminUsers;
        }

        public List<Object> getApplicationLicenses() {
            return applicationLicenses;
        }

        public void setApplicationLicenses(List<Object> applicationLicenses) {
            this.applicationLicenses = applicationLicenses;
        }

        public List<Object> getApplications() {
            return applications;
        }

        public void setApplications(List<Object> applications) {
            this.applications = applications;
        }

        public List<Object> getBranches() {
            return branches;
        }

        public void setBranches(List<Object> branches) {
            this.branches = branches;
        }

        public List<Object> getContactPersons() {
            return contactPersons;
        }

        public void setContactPersons(List<Object> contactPersons) {
            this.contactPersons = contactPersons;
        }

        public Customer getCustomer() {
            return customer;
        }

        public void setCustomer(Customer customer) {
            this.customer = customer;
        }

        public List<Object> getCustomerAddresses() {
            return customerAddresses;
        }

        public void setCustomerAddresses(List<Object> customerAddresses) {
            this.customerAddresses = customerAddresses;
        }

        public Object getCustomerEmployeeGroupEmployeeType() {
            return customerEmployeeGroupEmployeeType;
        }

        public void setCustomerEmployeeGroupEmployeeType(Object customerEmployeeGroupEmployeeType) {
            this.customerEmployeeGroupEmployeeType = customerEmployeeGroupEmployeeType;
        }

        public Object getCustomerEmployeeGroups() {
            return customerEmployeeGroups;
        }

        public void setCustomerEmployeeGroups(Object customerEmployeeGroups) {
            this.customerEmployeeGroups = customerEmployeeGroups;
        }

        public Object getCustomerEmployeeRoles() {
            return customerEmployeeRoles;
        }

        public void setCustomerEmployeeRoles(Object customerEmployeeRoles) {
            this.customerEmployeeRoles = customerEmployeeRoles;
        }

        public Object getCustomerEmployeeTypes() {
            return customerEmployeeTypes;
        }

        public void setCustomerEmployeeTypes(Object customerEmployeeTypes) {
            this.customerEmployeeTypes = customerEmployeeTypes;
        }

        public Object getCustomers() {
            return customers;
        }

        public void setCustomers(Object customers) {
            this.customers = customers;
        }

        public Object getMainBranch() {
            return mainBranch;
        }

        public void setMainBranch(Object mainBranch) {
            this.mainBranch = mainBranch;
        }

    }
}