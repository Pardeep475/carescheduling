package com.example.carescheduling.Ui.HomeScreen.beans;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientCareMedicalBean {

    @SerializedName("Data")
    @Expose
    private Object data;
    @SerializedName("DataList")
    @Expose
    private List<DataList> dataList = null;
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

    public List<DataList> getDataList() {
        return dataList;
    }

    public void setDataList(List<DataList> dataList) {
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

        @SerializedName("Date")
        @Expose
        private String date;
        @SerializedName("Description")
        @Expose
        private String description;
        @SerializedName("DoctorName")
        @Expose
        private String doctorName;
        @SerializedName("MedicalName")
        @Expose
        private String medicalName;
        @SerializedName("MedicationQuantity")
        @Expose
        private String medicationQuantity;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDoctorName() {
            return doctorName;
        }

        public void setDoctorName(String doctorName) {
            this.doctorName = doctorName;
        }

        public String getMedicalName() {
            return medicalName;
        }

        public void setMedicalName(String medicalName) {
            this.medicalName = medicalName;
        }

        public String getMedicationQuantity() {
            return medicationQuantity;
        }

        public void setMedicationQuantity(String medicationQuantity) {
            this.medicationQuantity = medicationQuantity;
        }

    }
}
