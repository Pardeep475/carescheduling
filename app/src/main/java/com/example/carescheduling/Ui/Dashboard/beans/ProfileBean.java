package com.example.carescheduling.Ui.Dashboard.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ProfileBean implements Serializable {

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

    public class Data implements Serializable {

        @SerializedName("BirthDate")
        @Expose
        private String birthDate;
        @SerializedName("BranchClient")
        @Expose
        private Object branchClient;
        @SerializedName("BranchEmployee")
        @Expose
        private Object branchEmployee;
        @SerializedName("BranchId")
        @Expose
        private String branchId;
        @SerializedName("BranchPerson")
        @Expose
        private Object branchPerson;
        @SerializedName("BranchUser")
        @Expose
        private Object branchUser;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("ImageSize")
        @Expose
        private Object imageSize;
        @SerializedName("IsConfirmed")
        @Expose
        private Boolean isConfirmed;
        @SerializedName("IsDelete")
        @Expose
        private Boolean isDelete;
        @SerializedName("Person")
        @Expose
        public Person person;
        @SerializedName("PersonAddresses")
        @Expose
        private List<PersonAddress_> personAddresses = null;
        @SerializedName("PersonBlacklistedDate")
        @Expose
        private Object personBlacklistedDate;
        @SerializedName("PersonContacts")
        @Expose
        private Object personContacts;
        @SerializedName("PersonImage")
        @Expose
        private List<PersonImage> personImage;

        public String getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(String birthDate) {
            this.birthDate = birthDate;
        }

        public Object getBranchClient() {
            return branchClient;
        }

        public void setBranchClient(Object branchClient) {
            this.branchClient = branchClient;
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

        public Object getBranchPerson() {
            return branchPerson;
        }

        public void setBranchPerson(Object branchPerson) {
            this.branchPerson = branchPerson;
        }

        public Object getBranchUser() {
            return branchUser;
        }

        public void setBranchUser(Object branchUser) {
            this.branchUser = branchUser;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public Object getImageSize() {
            return imageSize;
        }

        public void setImageSize(Object imageSize) {
            this.imageSize = imageSize;
        }

        public Boolean getIsConfirmed() {
            return isConfirmed;
        }

        public void setIsConfirmed(Boolean isConfirmed) {
            this.isConfirmed = isConfirmed;
        }

        public Boolean getIsDelete() {
            return isDelete;
        }

        public void setIsDelete(Boolean isDelete) {
            this.isDelete = isDelete;
        }

        public Person getPerson() {
            return person;
        }

        public void setPerson(Person person) {
            this.person = person;
        }

        public List<PersonAddress_> getPersonAddresses() {
            return personAddresses;
        }

        public void setPersonAddresses(List<PersonAddress_> personAddresses) {
            this.personAddresses = personAddresses;
        }

        public Object getPersonBlacklistedDate() {
            return personBlacklistedDate;
        }

        public void setPersonBlacklistedDate(Object personBlacklistedDate) {
            this.personBlacklistedDate = personBlacklistedDate;
        }

        public Object getPersonContacts() {
            return personContacts;
        }

        public void setPersonContacts(Object personContacts) {
            this.personContacts = personContacts;
        }

        public List<PersonImage> getPersonImage() {
            return personImage;
        }

        public void setPersonImage(List<PersonImage> personImage) {
            this.personImage = personImage;
        }

    }
}