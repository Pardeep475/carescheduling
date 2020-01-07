package css.mobile.carescheduling.Ui.HomeScreen.beans;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArrivalBean {

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
    private String responseMessage;
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
    public class ClientVisitLogModel {

        @SerializedName("BarcodeId")
        @Expose
        private String barcodeId;
        @SerializedName("ClientPersonId")
        @Expose
        private String clientPersonId;
        @SerializedName("ClientVisitId")
        @Expose
        private String clientVisitId;
        @SerializedName("ClientVisitLogId")
        @Expose
        private String clientVisitLogId;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("DeviceId")
        @Expose
        private Object deviceId;
        @SerializedName("LogCreatedDateTime")
        @Expose
        private String logCreatedDateTime;
        @SerializedName("NfcSerialNumber")
        @Expose
        private Object nfcSerialNumber;
        @SerializedName("TCMNumberId")
        @Expose
        private Object tCMNumberId;
        @SerializedName("VisitIdentificationTypeName")
        @Expose
        private Object visitIdentificationTypeName;

        public String getBarcodeId() {
            return barcodeId;
        }

        public void setBarcodeId(String barcodeId) {
            this.barcodeId = barcodeId;
        }

        public String getClientPersonId() {
            return clientPersonId;
        }

        public void setClientPersonId(String clientPersonId) {
            this.clientPersonId = clientPersonId;
        }

        public String getClientVisitId() {
            return clientVisitId;
        }

        public void setClientVisitId(String clientVisitId) {
            this.clientVisitId = clientVisitId;
        }

        public String getClientVisitLogId() {
            return clientVisitLogId;
        }

        public void setClientVisitLogId(String clientVisitLogId) {
            this.clientVisitLogId = clientVisitLogId;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public Object getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(Object deviceId) {
            this.deviceId = deviceId;
        }

        public String getLogCreatedDateTime() {
            return logCreatedDateTime;
        }

        public void setLogCreatedDateTime(String logCreatedDateTime) {
            this.logCreatedDateTime = logCreatedDateTime;
        }

        public Object getNfcSerialNumber() {
            return nfcSerialNumber;
        }

        public void setNfcSerialNumber(Object nfcSerialNumber) {
            this.nfcSerialNumber = nfcSerialNumber;
        }

        public Object getTCMNumberId() {
            return tCMNumberId;
        }

        public void setTCMNumberId(Object tCMNumberId) {
            this.tCMNumberId = tCMNumberId;
        }

        public Object getVisitIdentificationTypeName() {
            return visitIdentificationTypeName;
        }

        public void setVisitIdentificationTypeName(Object visitIdentificationTypeName) {
            this.visitIdentificationTypeName = visitIdentificationTypeName;
        }

    }

    public class DataList {

        @SerializedName("ArrivalRegistrationTypeName")
        @Expose
        private String arrivalRegistrationTypeName;
        @SerializedName("ClientBookingId")
        @Expose
        private String clientBookingId;
        @SerializedName("ClientVisitId")
        @Expose
        private String clientVisitId;
        @SerializedName("ClientVisitLogModel")
        @Expose
        private List<ClientVisitLogModel> clientVisitLogModel = null;
        @SerializedName("ClientVisitTaskModel")
        @Expose
        private Object clientVisitTaskModel;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("DepartureRegistrationTypeName")
        @Expose
        private Object departureRegistrationTypeName;
        @SerializedName("EmployeePersonId")
        @Expose
        private String employeePersonId;
        @SerializedName("NoteId")
        @Expose
        private Object noteId;
        @SerializedName("VisitArrivalRegisterredBy")
        @Expose
        private String visitArrivalRegisterredBy;
        @SerializedName("VisitDepartureRegisteredBy")
        @Expose
        private Object visitDepartureRegisteredBy;
        @SerializedName("VisitRegisteredArrival")
        @Expose
        private String visitRegisteredArrival;
        @SerializedName("VisitRegisteredDeparture")
        @Expose
        private Object visitRegisteredDeparture;

        public String getArrivalRegistrationTypeName() {
            return arrivalRegistrationTypeName;
        }

        public void setArrivalRegistrationTypeName(String arrivalRegistrationTypeName) {
            this.arrivalRegistrationTypeName = arrivalRegistrationTypeName;
        }

        public String getClientBookingId() {
            return clientBookingId;
        }

        public void setClientBookingId(String clientBookingId) {
            this.clientBookingId = clientBookingId;
        }

        public String getClientVisitId() {
            return clientVisitId;
        }

        public void setClientVisitId(String clientVisitId) {
            this.clientVisitId = clientVisitId;
        }

        public List<ClientVisitLogModel> getClientVisitLogModel() {
            return clientVisitLogModel;
        }

        public void setClientVisitLogModel(List<ClientVisitLogModel> clientVisitLogModel) {
            this.clientVisitLogModel = clientVisitLogModel;
        }

        public Object getClientVisitTaskModel() {
            return clientVisitTaskModel;
        }

        public void setClientVisitTaskModel(Object clientVisitTaskModel) {
            this.clientVisitTaskModel = clientVisitTaskModel;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public Object getDepartureRegistrationTypeName() {
            return departureRegistrationTypeName;
        }

        public void setDepartureRegistrationTypeName(Object departureRegistrationTypeName) {
            this.departureRegistrationTypeName = departureRegistrationTypeName;
        }

        public String getEmployeePersonId() {
            return employeePersonId;
        }

        public void setEmployeePersonId(String employeePersonId) {
            this.employeePersonId = employeePersonId;
        }

        public Object getNoteId() {
            return noteId;
        }

        public void setNoteId(Object noteId) {
            this.noteId = noteId;
        }

        public String getVisitArrivalRegisterredBy() {
            return visitArrivalRegisterredBy;
        }

        public void setVisitArrivalRegisterredBy(String visitArrivalRegisterredBy) {
            this.visitArrivalRegisterredBy = visitArrivalRegisterredBy;
        }

        public Object getVisitDepartureRegisteredBy() {
            return visitDepartureRegisteredBy;
        }

        public void setVisitDepartureRegisteredBy(Object visitDepartureRegisteredBy) {
            this.visitDepartureRegisteredBy = visitDepartureRegisteredBy;
        }

        public String getVisitRegisteredArrival() {
            return visitRegisteredArrival;
        }

        public void setVisitRegisteredArrival(String visitRegisteredArrival) {
            this.visitRegisteredArrival = visitRegisteredArrival;
        }

        public Object getVisitRegisteredDeparture() {
            return visitRegisteredDeparture;
        }

        public void setVisitRegisteredDeparture(Object visitRegisteredDeparture) {
            this.visitRegisteredDeparture = visitRegisteredDeparture;
        }

    }
}
