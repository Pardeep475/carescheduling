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

    public class ClientMedicationModel {

        @SerializedName("AddedByEmployeePersonId")
        @Expose
        private String addedByEmployeePersonId;
        @SerializedName("CarePlanMedicationIsSuspended")
        @Expose
        private Boolean carePlanMedicationIsSuspended;
        @SerializedName("ChangedByEmployeePersonId")
        @Expose
        private String changedByEmployeePersonId;
        @SerializedName("ClientCareplanModel")
        @Expose
        private Object clientCareplanModel;
        @SerializedName("ClientMedicationDocumentModel")
        @Expose
        private List<Object> clientMedicationDocumentModel = null;
        @SerializedName("ClientMedicationFrequencyModel")
        @Expose
        private List<Object> clientMedicationFrequencyModel = null;
        @SerializedName("ClientMedicationNoteModel")
        @Expose
        private List<Object> clientMedicationNoteModel = null;
        @SerializedName("ClientMedicationRecordModel")
        @Expose
        private List<Object> clientMedicationRecordModel = null;
        @SerializedName("ClientPersonId")
        @Expose
        private String clientPersonId;
        @SerializedName("GPPersonId")
        @Expose
        private Object gPPersonId;
        @SerializedName("HasEndDate")
        @Expose
        private Boolean hasEndDate;
        @SerializedName("MedicationAddedDate")
        @Expose
        private String medicationAddedDate;
        @SerializedName("MedicationEndDate")
        @Expose
        private Object medicationEndDate;
        @SerializedName("MedicationId")
        @Expose
        private String medicationId;
        @SerializedName("MedicationLastChangedDate")
        @Expose
        private String medicationLastChangedDate;
        @SerializedName("MedicationStartDate")
        @Expose
        private String medicationStartDate;
        @SerializedName("MedicationStrenghtUnitName")
        @Expose
        private Object medicationStrenghtUnitName;
        @SerializedName("MedicationStrenghtValue")
        @Expose
        private Object medicationStrenghtValue;
        @SerializedName("MedicationSuspendedDate")
        @Expose
        private Object medicationSuspendedDate;
        @SerializedName("SuspendedByEmployeePersonId")
        @Expose
        private Object suspendedByEmployeePersonId;

        public String getAddedByEmployeePersonId() {
            return addedByEmployeePersonId;
        }

        public void setAddedByEmployeePersonId(String addedByEmployeePersonId) {
            this.addedByEmployeePersonId = addedByEmployeePersonId;
        }

        public Boolean getCarePlanMedicationIsSuspended() {
            return carePlanMedicationIsSuspended;
        }

        public void setCarePlanMedicationIsSuspended(Boolean carePlanMedicationIsSuspended) {
            this.carePlanMedicationIsSuspended = carePlanMedicationIsSuspended;
        }

        public String getChangedByEmployeePersonId() {
            return changedByEmployeePersonId;
        }

        public void setChangedByEmployeePersonId(String changedByEmployeePersonId) {
            this.changedByEmployeePersonId = changedByEmployeePersonId;
        }

        public Object getClientCareplanModel() {
            return clientCareplanModel;
        }

        public void setClientCareplanModel(Object clientCareplanModel) {
            this.clientCareplanModel = clientCareplanModel;
        }

        public List<Object> getClientMedicationDocumentModel() {
            return clientMedicationDocumentModel;
        }

        public void setClientMedicationDocumentModel(List<Object> clientMedicationDocumentModel) {
            this.clientMedicationDocumentModel = clientMedicationDocumentModel;
        }

        public List<Object> getClientMedicationFrequencyModel() {
            return clientMedicationFrequencyModel;
        }

        public void setClientMedicationFrequencyModel(List<Object> clientMedicationFrequencyModel) {
            this.clientMedicationFrequencyModel = clientMedicationFrequencyModel;
        }

        public List<Object> getClientMedicationNoteModel() {
            return clientMedicationNoteModel;
        }

        public void setClientMedicationNoteModel(List<Object> clientMedicationNoteModel) {
            this.clientMedicationNoteModel = clientMedicationNoteModel;
        }

        public List<Object> getClientMedicationRecordModel() {
            return clientMedicationRecordModel;
        }

        public void setClientMedicationRecordModel(List<Object> clientMedicationRecordModel) {
            this.clientMedicationRecordModel = clientMedicationRecordModel;
        }

        public String getClientPersonId() {
            return clientPersonId;
        }

        public void setClientPersonId(String clientPersonId) {
            this.clientPersonId = clientPersonId;
        }

        public Object getGPPersonId() {
            return gPPersonId;
        }

        public void setGPPersonId(Object gPPersonId) {
            this.gPPersonId = gPPersonId;
        }

        public Boolean getHasEndDate() {
            return hasEndDate;
        }

        public void setHasEndDate(Boolean hasEndDate) {
            this.hasEndDate = hasEndDate;
        }

        public String getMedicationAddedDate() {
            return medicationAddedDate;
        }

        public void setMedicationAddedDate(String medicationAddedDate) {
            this.medicationAddedDate = medicationAddedDate;
        }

        public Object getMedicationEndDate() {
            return medicationEndDate;
        }

        public void setMedicationEndDate(Object medicationEndDate) {
            this.medicationEndDate = medicationEndDate;
        }

        public String getMedicationId() {
            return medicationId;
        }

        public void setMedicationId(String medicationId) {
            this.medicationId = medicationId;
        }

        public String getMedicationLastChangedDate() {
            return medicationLastChangedDate;
        }

        public void setMedicationLastChangedDate(String medicationLastChangedDate) {
            this.medicationLastChangedDate = medicationLastChangedDate;
        }

        public String getMedicationStartDate() {
            return medicationStartDate;
        }

        public void setMedicationStartDate(String medicationStartDate) {
            this.medicationStartDate = medicationStartDate;
        }

        public Object getMedicationStrenghtUnitName() {
            return medicationStrenghtUnitName;
        }

        public void setMedicationStrenghtUnitName(Object medicationStrenghtUnitName) {
            this.medicationStrenghtUnitName = medicationStrenghtUnitName;
        }

        public Object getMedicationStrenghtValue() {
            return medicationStrenghtValue;
        }

        public void setMedicationStrenghtValue(Object medicationStrenghtValue) {
            this.medicationStrenghtValue = medicationStrenghtValue;
        }

        public Object getMedicationSuspendedDate() {
            return medicationSuspendedDate;
        }

        public void setMedicationSuspendedDate(Object medicationSuspendedDate) {
            this.medicationSuspendedDate = medicationSuspendedDate;
        }

        public Object getSuspendedByEmployeePersonId() {
            return suspendedByEmployeePersonId;
        }

        public void setSuspendedByEmployeePersonId(Object suspendedByEmployeePersonId) {
            this.suspendedByEmployeePersonId = suspendedByEmployeePersonId;
        }

    }

    public class DataList {

        @SerializedName("ClientMedicationModel")
        @Expose
        private ClientMedicationModel clientMedicationModel;
        @SerializedName("ClientMedicationModelList")
        @Expose
        private Object clientMedicationModelList;
        @SerializedName("CustomerId")
        @Expose
        private Object customerId;
        @SerializedName("MedicalModel")
        @Expose
        private MedicalModel medicalModel;

        public ClientMedicationModel getClientMedicationModel() {
            return clientMedicationModel;
        }

        public void setClientMedicationModel(ClientMedicationModel clientMedicationModel) {
            this.clientMedicationModel = clientMedicationModel;
        }

        public Object getClientMedicationModelList() {
            return clientMedicationModelList;
        }

        public void setClientMedicationModelList(Object clientMedicationModelList) {
            this.clientMedicationModelList = clientMedicationModelList;
        }

        public Object getCustomerId() {
            return customerId;
        }

        public void setCustomerId(Object customerId) {
            this.customerId = customerId;
        }

        public MedicalModel getMedicalModel() {
            return medicalModel;
        }

        public void setMedicalModel(MedicalModel medicalModel) {
            this.medicalModel = medicalModel;
        }

    }

    public class MedicalModel {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("MedicationGroupName")
        @Expose
        private String medicationGroupName;
        @SerializedName("MedicationId")
        @Expose
        private String medicationId;
        @SerializedName("MedicationLink")
        @Expose
        private String medicationLink;
        @SerializedName("MedicationManufacturarName")
        @Expose
        private String medicationManufacturarName;
        @SerializedName("MedicationName")
        @Expose
        private String medicationName;
        @SerializedName("MedicationVariationModel")
        @Expose
        private Object medicationVariationModel;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getMedicationGroupName() {
            return medicationGroupName;
        }

        public void setMedicationGroupName(String medicationGroupName) {
            this.medicationGroupName = medicationGroupName;
        }

        public String getMedicationId() {
            return medicationId;
        }

        public void setMedicationId(String medicationId) {
            this.medicationId = medicationId;
        }

        public String getMedicationLink() {
            return medicationLink;
        }

        public void setMedicationLink(String medicationLink) {
            this.medicationLink = medicationLink;
        }

        public String getMedicationManufacturarName() {
            return medicationManufacturarName;
        }

        public void setMedicationManufacturarName(String medicationManufacturarName) {
            this.medicationManufacturarName = medicationManufacturarName;
        }

        public String getMedicationName() {
            return medicationName;
        }

        public void setMedicationName(String medicationName) {
            this.medicationName = medicationName;
        }

        public Object getMedicationVariationModel() {
            return medicationVariationModel;
        }

        public void setMedicationVariationModel(Object medicationVariationModel) {
            this.medicationVariationModel = medicationVariationModel;
        }

    }

}
