package com.example.carescheduling.Ui.HomeScreen.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ClientInfoCarePlanRetro {

    @SerializedName("Data")
    @Expose
    private Object data;
    @SerializedName("DataList")
    @Expose
    private ArrayList<DataList> dataList = null;
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

    public ArrayList<DataList> getDataList() {
        return dataList;
    }

    public void setDataList(ArrayList<DataList> dataList) {
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

    public class DataList {

        @SerializedName("Client")
        @Expose
        private Object client;
        @SerializedName("ClientAllergies")
        @Expose
        private Object clientAllergies;
        @SerializedName("ClientContactList")
        @Expose
        private Object clientContactList;
        @SerializedName("ClientDisabilities")
        @Expose
        private Object clientDisabilities;
        @SerializedName("ClientDocuments")
        @Expose
        private Object clientDocuments;
        @SerializedName("ClientVM")
        @Expose
        private Object clientVM;
        @SerializedName("ContactsInformation")
        @Expose
        private Object contactsInformation;
        @SerializedName("MedicalData")
        @Expose
        private Object medicalData;
        @SerializedName("MedicalMVM")
        @Expose
        private Object medicalMVM;
        @SerializedName("Person")
        @Expose
        private Object person;
        @SerializedName("ScheduleClientList")
        @Expose
        private ArrayList<ScheduleClientList> scheduleClientList = null;
        @SerializedName("TaskMVM")
        @Expose
        private Object taskMVM;
        @SerializedName("clientNotes")
        @Expose
        private Object clientNotes;

        public Object getClient() {
            return client;
        }

        public void setClient(Object client) {
            this.client = client;
        }

        public Object getClientAllergies() {
            return clientAllergies;
        }

        public void setClientAllergies(Object clientAllergies) {
            this.clientAllergies = clientAllergies;
        }

        public Object getClientContactList() {
            return clientContactList;
        }

        public void setClientContactList(Object clientContactList) {
            this.clientContactList = clientContactList;
        }

        public Object getClientDisabilities() {
            return clientDisabilities;
        }

        public void setClientDisabilities(Object clientDisabilities) {
            this.clientDisabilities = clientDisabilities;
        }

        public Object getClientDocuments() {
            return clientDocuments;
        }

        public void setClientDocuments(Object clientDocuments) {
            this.clientDocuments = clientDocuments;
        }

        public Object getClientVM() {
            return clientVM;
        }

        public void setClientVM(Object clientVM) {
            this.clientVM = clientVM;
        }

        public Object getContactsInformation() {
            return contactsInformation;
        }

        public void setContactsInformation(Object contactsInformation) {
            this.contactsInformation = contactsInformation;
        }

        public Object getMedicalData() {
            return medicalData;
        }

        public void setMedicalData(Object medicalData) {
            this.medicalData = medicalData;
        }

        public Object getMedicalMVM() {
            return medicalMVM;
        }

        public void setMedicalMVM(Object medicalMVM) {
            this.medicalMVM = medicalMVM;
        }

        public Object getPerson() {
            return person;
        }

        public void setPerson(Object person) {
            this.person = person;
        }

        public ArrayList<ScheduleClientList> getScheduleClientList() {
            return scheduleClientList;
        }

        public void setScheduleClientList(ArrayList<ScheduleClientList> scheduleClientList) {
            this.scheduleClientList = scheduleClientList;
        }

        public Object getTaskMVM() {
            return taskMVM;
        }

        public void setTaskMVM(Object taskMVM) {
            this.taskMVM = taskMVM;
        }

        public Object getClientNotes() {
            return clientNotes;
        }

        public void setClientNotes(Object clientNotes) {
            this.clientNotes = clientNotes;
        }

    }


}

