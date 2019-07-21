package com.example.carescheduling.Ui.Profile.bean;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetMyProfileEdit {

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

        @SerializedName("BranchId")
        @Expose
        private String branchId;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("DateOfBirth")
        @Expose
        private String dateOfBirth;
        @SerializedName("DisabilityTypeName")
        @Expose
        private String disabilityTypeName;
        @SerializedName("EthnicityTypeName")
        @Expose
        private String ethnicityTypeName;
        @SerializedName("FirstName")
        @Expose
        private String firstName;
        @SerializedName("GenderTypeName")
        @Expose
        private String genderTypeName;
        @SerializedName("LanguageName")
        @Expose
        private String languageName;
        @SerializedName("MaidenName")
        @Expose
        private String maidenName;
        @SerializedName("MaritialStatusName")
        @Expose
        private String maritialStatusName;
        @SerializedName("MiddleName")
        @Expose
        private String middleName;
        @SerializedName("Nationality")
        @Expose
        private String nationality;
        @SerializedName("PersonId")
        @Expose
        private String personId;
        @SerializedName("PrefixTypeName")
        @Expose
        private String prefixTypeName;
        @SerializedName("ReligionTypeName")
        @Expose
        private String religionTypeName;
        @SerializedName("SexualityTypeName")
        @Expose
        private String sexualityTypeName;
        @SerializedName("SurName")
        @Expose
        private String surName;
        @SerializedName("isDisability")
        @Expose
        private Boolean isDisability;

        public String getBranchId() {
            return branchId;
        }

        public void setBranchId(String branchId) {
            this.branchId = branchId;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public String getDisabilityTypeName() {
            return disabilityTypeName;
        }

        public void setDisabilityTypeName(String disabilityTypeName) {
            this.disabilityTypeName = disabilityTypeName;
        }

        public String getEthnicityTypeName() {
            return ethnicityTypeName;
        }

        public void setEthnicityTypeName(String ethnicityTypeName) {
            this.ethnicityTypeName = ethnicityTypeName;
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

        public String getLanguageName() {
            return languageName;
        }

        public void setLanguageName(String languageName) {
            this.languageName = languageName;
        }

        public String getMaidenName() {
            return maidenName;
        }

        public void setMaidenName(String maidenName) {
            this.maidenName = maidenName;
        }

        public String getMaritialStatusName() {
            return maritialStatusName;
        }

        public void setMaritialStatusName(String maritialStatusName) {
            this.maritialStatusName = maritialStatusName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }

        public String getNationality() {
            return nationality;
        }

        public void setNationality(String nationality) {
            this.nationality = nationality;
        }

        public String getPersonId() {
            return personId;
        }

        public void setPersonId(String personId) {
            this.personId = personId;
        }

        public String getPrefixTypeName() {
            return prefixTypeName;
        }

        public void setPrefixTypeName(String prefixTypeName) {
            this.prefixTypeName = prefixTypeName;
        }

        public String getReligionTypeName() {
            return religionTypeName;
        }

        public void setReligionTypeName(String religionTypeName) {
            this.religionTypeName = religionTypeName;
        }

        public String getSexualityTypeName() {
            return sexualityTypeName;
        }

        public void setSexualityTypeName(String sexualityTypeName) {
            this.sexualityTypeName = sexualityTypeName;
        }

        public String getSurName() {
            return surName;
        }

        public void setSurName(String surName) {
            this.surName = surName;
        }

        public Boolean getIsDisability() {
            return isDisability;
        }

        public void setIsDisability(Boolean isDisability) {
            this.isDisability = isDisability;
        }

    }
}