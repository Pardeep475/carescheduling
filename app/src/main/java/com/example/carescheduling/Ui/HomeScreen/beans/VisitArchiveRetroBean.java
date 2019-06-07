package com.example.carescheduling.Ui.HomeScreen.beans;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VisitArchiveRetroBean {

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
    public class BookingClientModel {

        @SerializedName("BookingDateTime")
        @Expose
        private String bookingDateTime;
        @SerializedName("BookingStatusTypeName")
        @Expose
        private String bookingStatusTypeName;
        @SerializedName("ClientBookingEmployeeModel")
        @Expose
        private Object clientBookingEmployeeModel;
        @SerializedName("ClientBookingId")
        @Expose
        private String clientBookingId;
        @SerializedName("ClientBookingTaskModel")
        @Expose
        private Object clientBookingTaskModel;
        @SerializedName("Clientd")
        @Expose
        private String clientd;
        @SerializedName("CreatedDateTime")
        @Expose
        private String createdDateTime;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("ScheduleStartDate")
        @Expose
        private String scheduleStartDate;
        @SerializedName("TimeTableName")
        @Expose
        private String timeTableName;
        @SerializedName("WeekRotationTypeName")
        @Expose
        private String weekRotationTypeName;
        @SerializedName("WeekdayName")
        @Expose
        private String weekdayName;

        public String getBookingDateTime() {
            return bookingDateTime;
        }

        public void setBookingDateTime(String bookingDateTime) {
            this.bookingDateTime = bookingDateTime;
        }

        public String getBookingStatusTypeName() {
            return bookingStatusTypeName;
        }

        public void setBookingStatusTypeName(String bookingStatusTypeName) {
            this.bookingStatusTypeName = bookingStatusTypeName;
        }

        public Object getClientBookingEmployeeModel() {
            return clientBookingEmployeeModel;
        }

        public void setClientBookingEmployeeModel(Object clientBookingEmployeeModel) {
            this.clientBookingEmployeeModel = clientBookingEmployeeModel;
        }

        public String getClientBookingId() {
            return clientBookingId;
        }

        public void setClientBookingId(String clientBookingId) {
            this.clientBookingId = clientBookingId;
        }

        public Object getClientBookingTaskModel() {
            return clientBookingTaskModel;
        }

        public void setClientBookingTaskModel(Object clientBookingTaskModel) {
            this.clientBookingTaskModel = clientBookingTaskModel;
        }

        public String getClientd() {
            return clientd;
        }

        public void setClientd(String clientd) {
            this.clientd = clientd;
        }

        public String getCreatedDateTime() {
            return createdDateTime;
        }

        public void setCreatedDateTime(String createdDateTime) {
            this.createdDateTime = createdDateTime;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getScheduleStartDate() {
            return scheduleStartDate;
        }

        public void setScheduleStartDate(String scheduleStartDate) {
            this.scheduleStartDate = scheduleStartDate;
        }

        public String getTimeTableName() {
            return timeTableName;
        }

        public void setTimeTableName(String timeTableName) {
            this.timeTableName = timeTableName;
        }

        public String getWeekRotationTypeName() {
            return weekRotationTypeName;
        }

        public void setWeekRotationTypeName(String weekRotationTypeName) {
            this.weekRotationTypeName = weekRotationTypeName;
        }

        public String getWeekdayName() {
            return weekdayName;
        }

        public void setWeekdayName(String weekdayName) {
            this.weekdayName = weekdayName;
        }

    }

    public class DataList {

        @SerializedName("BookingClientModel")
        @Expose
        private BookingClientModel bookingClientModel;
        @SerializedName("ClientName")
        @Expose
        private Object clientName;
        @SerializedName("ClientVisitModel")
        @Expose
        private Object clientVisitModel;
        @SerializedName("visitEndTime")
        @Expose
        private String visitEndTime;
        @SerializedName("visitStartTime")
        @Expose
        private String visitStartTime;

        public BookingClientModel getBookingClientModel() {
            return bookingClientModel;
        }

        public void setBookingClientModel(BookingClientModel bookingClientModel) {
            this.bookingClientModel = bookingClientModel;
        }

        public Object getClientName() {
            return clientName;
        }

        public void setClientName(Object clientName) {
            this.clientName = clientName;
        }

        public Object getClientVisitModel() {
            return clientVisitModel;
        }

        public void setClientVisitModel(Object clientVisitModel) {
            this.clientVisitModel = clientVisitModel;
        }

        public String getVisitEndTime() {
            return visitEndTime;
        }

        public void setVisitEndTime(String visitEndTime) {
            this.visitEndTime = visitEndTime;
        }

        public String getVisitStartTime() {
            return visitStartTime;
        }

        public void setVisitStartTime(String visitStartTime) {
            this.visitStartTime = visitStartTime;
        }

    }

}
