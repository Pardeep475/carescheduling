package com.example.carescheduling.Ui.HomeScreen.beans;

import com.example.carescheduling.Ui.Dashboard.beans.PersonDetail;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientCarePersonalDetailsBean {

    @SerializedName("Data")
    @Expose
    private PersonDetail data;
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

    public PersonDetail getData() {
        return data;
    }

    public void setData(PersonDetail data) {
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

        @SerializedName("DateOfBirth")
        @Expose
        private String dateOfBirth;
        @SerializedName("Disability")
        @Expose
        private String disability;
        @SerializedName("Ethnicity")
        @Expose
        private String ethnicity;
        @SerializedName("FirstName")
        @Expose
        private String firstName;
        @SerializedName("IsDisability")
        @Expose
        private Boolean isDisability;
        @SerializedName("LanguageName")
        @Expose
        private String languageName;
        @SerializedName("MaidenName")
        @Expose
        private String maidenName;
        @SerializedName("MaritialStatus")
        @Expose
        private String maritialStatus;
        @SerializedName("MiddleName")
        @Expose
        private String middleName;
        @SerializedName("Nationality")
        @Expose
        private String nationality;
        @SerializedName("PrefixTypeName")
        @Expose
        private String prefixTypeName;
        @SerializedName("Religion")
        @Expose
        private String religion;
        @SerializedName("Sexuality")
        @Expose
        private String sexuality;
        @SerializedName("Surname")
        @Expose
        private String surname;
        @SerializedName("GenderTypeName")
        @Expose
        private String genderTypeName;

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public String getDisability() {
            return disability;
        }

        public void setDisability(String disability) {
            this.disability = disability;
        }

        public String getEthnicity() {
            return ethnicity;
        }

        public void setEthnicity(String ethnicity) {
            this.ethnicity = ethnicity;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public Boolean getIsDisability() {
            return isDisability;
        }

        public void setIsDisability(Boolean isDisability) {
            this.isDisability = isDisability;
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

        public String getMaritialStatus() {
            return maritialStatus;
        }

        public void setMaritialStatus(String maritialStatus) {
            this.maritialStatus = maritialStatus;
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

        public String getPrefixTypeName() {
            return prefixTypeName;
        }

        public void setPrefixTypeName(String prefixTypeName) {
            this.prefixTypeName = prefixTypeName;
        }

        public String getReligion() {
            return religion;
        }

        public void setReligion(String religion) {
            this.religion = religion;
        }

        public String getSexuality() {
            return sexuality;
        }

        public void setSexuality(String sexuality) {
            this.sexuality = sexuality;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }


        public String getGenderTypeName() {
            return genderTypeName;
        }

        public void setGenderTypeName(String genderTypeName) {
            this.genderTypeName = genderTypeName;
        }
    }
}