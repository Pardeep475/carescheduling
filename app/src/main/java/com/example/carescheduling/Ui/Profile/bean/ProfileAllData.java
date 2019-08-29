package com.example.carescheduling.Ui.Profile.bean;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ProfileAllData {

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
        @SerializedName("GenderTypeName")
        @Expose
        private String genderTypeName;
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
        @SerializedName("PasswordQuestion")
        @Expose
        private String passwordQuestion;
        @SerializedName("PasswordQuestionAnswer")
        @Expose
        private String passwordQuestionAnswer;
        @SerializedName("PersonDefaultAddress")
        @Expose
        private String personDefaultAddress;
        @SerializedName("PersonDefaultEmailAddress")
        @Expose
        private String personDefaultEmailAddress;
        @SerializedName("PersonDefaultImage")
        @Expose
        private String personDefaultImage;
        @SerializedName("PersonDefaultPhoneNumber")
        @Expose
        private String personDefaultPhoneNumber;
        @SerializedName("PersonEmailList")
        @Expose
        private ArrayList<PersonEmailList> personEmailList = null;
        @SerializedName("PersonId")
        @Expose
        private String personId;
        @SerializedName("PersonImageList")
        @Expose
        private ArrayList<Object> personImageList = null;
        @SerializedName("PersonName")
        @Expose
        private String personName;
        @SerializedName("PersonPhoneList")
        @Expose
        private ArrayList<PersonPhoneList> personPhoneList = null;
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
        @SerializedName("UserName")
        @Expose
        private String userName;
        @SerializedName("personAddressList")
        @Expose
        private ArrayList<PersonAddressList> personAddressList = null;

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

        public String getGenderTypeName() {
            return genderTypeName;
        }

        public void setGenderTypeName(String genderTypeName) {
            this.genderTypeName = genderTypeName;
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

        public String getPasswordQuestion() {
            return passwordQuestion;
        }

        public void setPasswordQuestion(String passwordQuestion) {
            this.passwordQuestion = passwordQuestion;
        }

        public String getPasswordQuestionAnswer() {
            return passwordQuestionAnswer;
        }

        public void setPasswordQuestionAnswer(String passwordQuestionAnswer) {
            this.passwordQuestionAnswer = passwordQuestionAnswer;
        }

        public String getPersonDefaultAddress() {
            return personDefaultAddress;
        }

        public void setPersonDefaultAddress(String personDefaultAddress) {
            this.personDefaultAddress = personDefaultAddress;
        }

        public String getPersonDefaultEmailAddress() {
            return personDefaultEmailAddress;
        }

        public void setPersonDefaultEmailAddress(String personDefaultEmailAddress) {
            this.personDefaultEmailAddress = personDefaultEmailAddress;
        }

        public String getPersonDefaultImage() {
            return personDefaultImage;
        }

        public void setPersonDefaultImage(String personDefaultImage) {
            this.personDefaultImage = personDefaultImage;
        }

        public String getPersonDefaultPhoneNumber() {
            return personDefaultPhoneNumber;
        }

        public void setPersonDefaultPhoneNumber(String personDefaultPhoneNumber) {
            this.personDefaultPhoneNumber = personDefaultPhoneNumber;
        }

        public ArrayList<PersonEmailList> getPersonEmailList() {
            return personEmailList;
        }

        public void setPersonEmailList(ArrayList<PersonEmailList> personEmailList) {
            this.personEmailList = personEmailList;
        }

        public String getPersonId() {
            return personId;
        }

        public void setPersonId(String personId) {
            this.personId = personId;
        }

        public ArrayList<Object> getPersonImageList() {
            return personImageList;
        }

        public void setPersonImageList(ArrayList<Object> personImageList) {
            this.personImageList = personImageList;
        }

        public String getPersonName() {
            return personName;
        }

        public void setPersonName(String personName) {
            this.personName = personName;
        }

        public ArrayList<PersonPhoneList> getPersonPhoneList() {
            return personPhoneList;
        }

        public void setPersonPhoneList(ArrayList<PersonPhoneList> personPhoneList) {
            this.personPhoneList = personPhoneList;
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

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public ArrayList<PersonAddressList> getPersonAddressList() {
            return personAddressList;
        }

        public void setPersonAddressList(ArrayList<PersonAddressList> personAddressList) {
            this.personAddressList = personAddressList;
        }

    }

}