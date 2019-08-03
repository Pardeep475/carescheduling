package com.example.carescheduling.Ui.HomeScreen.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientCareSummaryBean {

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

        @SerializedName("ClientAddress")
        @Expose
        private String clientAddress;
        @SerializedName("ClientDescription")
        @Expose
        private String clientDescription;
        @SerializedName("ClientId")
        @Expose
        private String clientId;
        @SerializedName("ClientImage")
        @Expose
        private String clientImage;
        @SerializedName("ClientName")
        @Expose
        private String clientName;

        public String getClientAddress() {
            return clientAddress;
        }

        public void setClientAddress(String clientAddress) {
            this.clientAddress = clientAddress;
        }

        public String getClientDescription() {
            return clientDescription;
        }

        public void setClientDescription(String clientDescription) {
            this.clientDescription = clientDescription;
        }

        public String getClientId() {
            return clientId;
        }

        public void setClientId(String clientId) {
            this.clientId = clientId;
        }

        public String getClientImage() {
            return clientImage;
        }

        public void setClientImage(String clientImage) {
            this.clientImage = clientImage;
        }

        public String getClientName() {
            return clientName;
        }

        public void setClientName(String clientName) {
            this.clientName = clientName;
        }

    }
}