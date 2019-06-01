package com.example.carescheduling.Ui.HomeScreen.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

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

        @SerializedName("BriefHistory")
        @Expose
        private Object briefHistory;
        @SerializedName("BriefOverview")
        @Expose
        private String briefOverview;
        @SerializedName("ClientAllergyModel")
        @Expose
        private List<Object> clientAllergyModel = null;
        @SerializedName("ClientAreaModel")
        @Expose
        private List<Object> clientAreaModel = null;
        @SerializedName("ClientBarcodeModel")
        @Expose
        private List<Object> clientBarcodeModel = null;
        @SerializedName("ClientContactModel")
        @Expose
        private List<Object> clientContactModel = null;
        @SerializedName("ClientContractModel")
        @Expose
        private List<Object> clientContractModel = null;
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
        private List<Object> clientFunderModel = null;
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
        private List<Object> clientRunModel = null;
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

        public Object getBriefHistory() {
            return briefHistory;
        }

        public void setBriefHistory(Object briefHistory) {
            this.briefHistory = briefHistory;
        }

        public String getBriefOverview() {
            return briefOverview;
        }

        public void setBriefOverview(String briefOverview) {
            this.briefOverview = briefOverview;
        }

        public List<Object> getClientAllergyModel() {
            return clientAllergyModel;
        }

        public void setClientAllergyModel(List<Object> clientAllergyModel) {
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

        public List<Object> getClientContactModel() {
            return clientContactModel;
        }

        public void setClientContactModel(List<Object> clientContactModel) {
            this.clientContactModel = clientContactModel;
        }

        public List<Object> getClientContractModel() {
            return clientContractModel;
        }

        public void setClientContractModel(List<Object> clientContractModel) {
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

        public List<Object> getClientFunderModel() {
            return clientFunderModel;
        }

        public void setClientFunderModel(List<Object> clientFunderModel) {
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

        public List<Object> getClientRunModel() {
            return clientRunModel;
        }

        public void setClientRunModel(List<Object> clientRunModel) {
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
}
