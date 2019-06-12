package com.example.carescheduling.Ui.HomeScreen.beans;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientCareMedicalBean {

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
    public class ClientMedicationFrequencyModel {

        @SerializedName("ClientMedicationRecordModel")
        @Expose
        private Object clientMedicationRecordModel;
        @SerializedName("ClientPersonId")
        @Expose
        private String clientPersonId;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("MedicationAddedDate")
        @Expose
        private String medicationAddedDate;
        @SerializedName("MedicationDose")
        @Expose
        private String medicationDose;
        @SerializedName("MedicationFormTypeName")
        @Expose
        private String medicationFormTypeName;
        @SerializedName("MedicationId")
        @Expose
        private String medicationId;
        @SerializedName("MedicationStrenghtUnitName")
        @Expose
        private String medicationStrenghtUnitName;
        @SerializedName("MedicationStrenghtValue")
        @Expose
        private String medicationStrenghtValue;
        @SerializedName("Period")
        @Expose
        private String period;
        @SerializedName("TaskPriorityName")
        @Expose
        private String taskPriorityName;
        @SerializedName("WeekdayName")
        @Expose
        private String weekdayName;

        public Object getClientMedicationRecordModel() {
            return clientMedicationRecordModel;
        }

        public void setClientMedicationRecordModel(Object clientMedicationRecordModel) {
            this.clientMedicationRecordModel = clientMedicationRecordModel;
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

        public String getMedicationAddedDate() {
            return medicationAddedDate;
        }

        public void setMedicationAddedDate(String medicationAddedDate) {
            this.medicationAddedDate = medicationAddedDate;
        }

        public String getMedicationDose() {
            return medicationDose;
        }

        public void setMedicationDose(String medicationDose) {
            this.medicationDose = medicationDose;
        }

        public String getMedicationFormTypeName() {
            return medicationFormTypeName;
        }

        public void setMedicationFormTypeName(String medicationFormTypeName) {
            this.medicationFormTypeName = medicationFormTypeName;
        }

        public String getMedicationId() {
            return medicationId;
        }

        public void setMedicationId(String medicationId) {
            this.medicationId = medicationId;
        }

        public String getMedicationStrenghtUnitName() {
            return medicationStrenghtUnitName;
        }

        public void setMedicationStrenghtUnitName(String medicationStrenghtUnitName) {
            this.medicationStrenghtUnitName = medicationStrenghtUnitName;
        }

        public String getMedicationStrenghtValue() {
            return medicationStrenghtValue;
        }

        public void setMedicationStrenghtValue(String medicationStrenghtValue) {
            this.medicationStrenghtValue = medicationStrenghtValue;
        }

        public String getPeriod() {
            return period;
        }

        public void setPeriod(String period) {
            this.period = period;
        }

        public String getTaskPriorityName() {
            return taskPriorityName;
        }

        public void setTaskPriorityName(String taskPriorityName) {
            this.taskPriorityName = taskPriorityName;
        }

        public String getWeekdayName() {
            return weekdayName;
        }

        public void setWeekdayName(String weekdayName) {
            this.weekdayName = weekdayName;
        }

    }

    public class DataList {

        @SerializedName("ClientMedicationFrequencyModel")
        @Expose
        private ClientMedicationFrequencyModel clientMedicationFrequencyModel;
        @SerializedName("MedicationName")
        @Expose
        private String medicationName;

        public ClientMedicationFrequencyModel getClientMedicationFrequencyModel() {
            return clientMedicationFrequencyModel;
        }

        public void setClientMedicationFrequencyModel(ClientMedicationFrequencyModel clientMedicationFrequencyModel) {
            this.clientMedicationFrequencyModel = clientMedicationFrequencyModel;
        }

        public String getMedicationName() {
            return medicationName;
        }

        public void setMedicationName(String medicationName) {
            this.medicationName = medicationName;
        }

    }
}

