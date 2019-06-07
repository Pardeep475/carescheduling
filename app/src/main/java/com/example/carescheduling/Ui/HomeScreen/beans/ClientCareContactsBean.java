package com.example.carescheduling.Ui.HomeScreen.beans;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientCareContactsBean {

    @SerializedName("Data")
    @Expose
    private Object data = null;
    @SerializedName("DataList")
    @Expose
    private ArrayList<Datum> dataList;
    @SerializedName("Exception")
    @Expose
    private Object exception;
    @SerializedName("ResponseMessage")
    @Expose
    private Object responseMessage;
    @SerializedName("Success")
    @Expose
    private Boolean success;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ArrayList<Datum> getDataList() {
        return dataList;
    }

    public void setDataList(ArrayList<Datum> dataList) {
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

    public class Datum {

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
}

