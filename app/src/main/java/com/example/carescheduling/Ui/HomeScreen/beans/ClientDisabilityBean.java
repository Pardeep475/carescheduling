package com.example.carescheduling.Ui.HomeScreen.beans;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientDisabilityBean {

    @SerializedName("Data")
    @Expose
    public ArrayList<Datum> data = null;
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

    public ArrayList<Datum> getData() {
        return data;
    }

    public void setData(ArrayList<Datum> data) {
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

    public class Datum {

        @SerializedName("ClientDisabilityAdded")
        @Expose
        private String clientDisabilityAdded;
        @SerializedName("ClientPersonId")
        @Expose
        private String clientPersonId;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("DisabilityGroupName")
        @Expose
        private String disabilityGroupName;
        @SerializedName("DisabilityTypeName")
        @Expose
        private String disabilityTypeName;

        public String getClientDisabilityAdded() {
            return clientDisabilityAdded;
        }

        public void setClientDisabilityAdded(String clientDisabilityAdded) {
            this.clientDisabilityAdded = clientDisabilityAdded;
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

        public String getDisabilityGroupName() {
            return disabilityGroupName;
        }

        public void setDisabilityGroupName(String disabilityGroupName) {
            this.disabilityGroupName = disabilityGroupName;
        }

        public String getDisabilityTypeName() {
            return disabilityTypeName;
        }

        public void setDisabilityTypeName(String disabilityTypeName) {
            this.disabilityTypeName = disabilityTypeName;
        }

    }

}
