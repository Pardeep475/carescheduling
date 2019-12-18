package com.example.carescheduling.Ui.Dashboard.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetMyProfileHome {

    @SerializedName("Data")
    @Expose
    private Data data;
    @SerializedName("DataList")
    @Expose
    private String dataList;
    @SerializedName("Exception")
    @Expose
    private String exception;
    @SerializedName("ResponseMessage")
    @Expose
    private String responseMessage;
    @SerializedName("Success")
    @Expose
    private Boolean success;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getDataList() {
        return dataList;
    }

    public void setDataList(String dataList) {
        this.dataList = dataList;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
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
        @SerializedName("PersonAddress")
        @Expose
        private String personAddress;
        @SerializedName("PersonEmailAddress")
        @Expose
        private String personEmailAddress;
        @SerializedName("PersonId")
        @Expose
        private String personId;
        @SerializedName("PersonImage")
        @Expose
        private String personImage;
        @SerializedName("PersonName")
        @Expose
        private String personName;
        @SerializedName("PersonPhoneNumber")
        @Expose
        private String personPhoneNumber;

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

        public String getPersonAddress() {
            return personAddress;
        }

        public void setPersonAddress(String personAddress) {
            this.personAddress = personAddress;
        }

        public String getPersonEmailAddress() {
            return personEmailAddress;
        }

        public void setPersonEmailAddress(String personEmailAddress) {
            this.personEmailAddress = personEmailAddress;
        }

        public String getPersonId() {
            return personId;
        }

        public void setPersonId(String personId) {
            this.personId = personId;
        }

        public String getPersonImage() {
            return personImage;
        }

        public void setPersonImage(String personImage) {
            this.personImage = personImage;
        }

        public String getPersonName() {
            return personName;
        }

        public void setPersonName(String personName) {
            this.personName = personName;
        }

        public String getPersonPhoneNumber() {
            return personPhoneNumber;
        }

        public void setPersonPhoneNumber(String personPhoneNumber) {
            this.personPhoneNumber = personPhoneNumber;
        }

    }
}