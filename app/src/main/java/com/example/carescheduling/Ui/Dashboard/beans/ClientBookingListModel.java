package com.example.carescheduling.Ui.Dashboard.beans;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientBookingListModel {

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
    public class BookingClientInformation {

        @SerializedName("BookingDateTime")
        @Expose
        private String bookingDateTime;
        @SerializedName("BookingStatusTypeName")
        @Expose
        private String bookingStatusTypeName;
        @SerializedName("ClientBookingEmployeeModel")
        @Expose
        private List<ClientBookingEmployeeModel> clientBookingEmployeeModel = null;
        @SerializedName("ClientBookingId")
        @Expose
        private String clientBookingId;
        @SerializedName("ClientBookingTaskModel")
        @Expose
        private List<Object> clientBookingTaskModel = null;
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

        public List<ClientBookingEmployeeModel> getClientBookingEmployeeModel() {
            return clientBookingEmployeeModel;
        }

        public void setClientBookingEmployeeModel(List<ClientBookingEmployeeModel> clientBookingEmployeeModel) {
            this.clientBookingEmployeeModel = clientBookingEmployeeModel;
        }

        public String getClientBookingId() {
            return clientBookingId;
        }

        public void setClientBookingId(String clientBookingId) {
            this.clientBookingId = clientBookingId;
        }

        public List<Object> getClientBookingTaskModel() {
            return clientBookingTaskModel;
        }

        public void setClientBookingTaskModel(List<Object> clientBookingTaskModel) {
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

        public class ClientBookingEmployeeModel {

            @SerializedName("BookingConfirmationTypeName")
            @Expose
            private String bookingConfirmationTypeName;
            @SerializedName("ClientBookingId")
            @Expose
            private String clientBookingId;
            @SerializedName("CustomerId")
            @Expose
            private String customerId;
            @SerializedName("EmployeePersonId")
            @Expose
            private String employeePersonId;

            public String getBookingConfirmationTypeName() {
                return bookingConfirmationTypeName;
            }

            public void setBookingConfirmationTypeName(String bookingConfirmationTypeName) {
                this.bookingConfirmationTypeName = bookingConfirmationTypeName;
            }

            public String getClientBookingId() {
                return clientBookingId;
            }

            public void setClientBookingId(String clientBookingId) {
                this.clientBookingId = clientBookingId;
            }

            public String getCustomerId() {
                return customerId;
            }

            public void setCustomerId(String customerId) {
                this.customerId = customerId;
            }

            public String getEmployeePersonId() {
                return employeePersonId;
            }

            public void setEmployeePersonId(String employeePersonId) {
                this.employeePersonId = employeePersonId;
            }

        }
    }
    public class Data {

        @SerializedName("BookingClient")
        @Expose
        private Object bookingClient;
        @SerializedName("BookingClientInformation")
        @Expose
        private BookingClientInformation bookingClientInformation;
        @SerializedName("BookingClientModel")
        @Expose
        private Object bookingClientModel;
        @SerializedName("BookingClients")
        @Expose
        private Object bookingClients;
        @SerializedName("BookingHealthcare")
        @Expose
        private Object bookingHealthcare;
        @SerializedName("BookingHealthcares")
        @Expose
        private Object bookingHealthcares;
        @SerializedName("ScheduleClientModel")
        @Expose
        private ScheduleClientModel scheduleClientModel;
        @SerializedName("ScheduleClients")
        @Expose
        private Object scheduleClients;

        public Object getBookingClient() {
            return bookingClient;
        }

        public void setBookingClient(Object bookingClient) {
            this.bookingClient = bookingClient;
        }

        public BookingClientInformation getBookingClientInformation() {
            return bookingClientInformation;
        }

        public void setBookingClientInformation(BookingClientInformation bookingClientInformation) {
            this.bookingClientInformation = bookingClientInformation;
        }

        public Object getBookingClientModel() {
            return bookingClientModel;
        }

        public void setBookingClientModel(Object bookingClientModel) {
            this.bookingClientModel = bookingClientModel;
        }

        public Object getBookingClients() {
            return bookingClients;
        }

        public void setBookingClients(Object bookingClients) {
            this.bookingClients = bookingClients;
        }

        public Object getBookingHealthcare() {
            return bookingHealthcare;
        }

        public void setBookingHealthcare(Object bookingHealthcare) {
            this.bookingHealthcare = bookingHealthcare;
        }

        public Object getBookingHealthcares() {
            return bookingHealthcares;
        }

        public void setBookingHealthcares(Object bookingHealthcares) {
            this.bookingHealthcares = bookingHealthcares;
        }

        public ScheduleClientModel getScheduleClientModel() {
            return scheduleClientModel;
        }

        public void setScheduleClientModel(ScheduleClientModel scheduleClientModel) {
            this.scheduleClientModel = scheduleClientModel;
        }

        public Object getScheduleClients() {
            return scheduleClients;
        }

        public void setScheduleClients(Object scheduleClients) {
            this.scheduleClients = scheduleClients;
        }

    }
    public class ScheduleClientModel {

        @SerializedName("ClientId")
        @Expose
        private String clientId;
        @SerializedName("CustomEndHour")
        @Expose
        private String customEndHour;
        @SerializedName("CustomEndMinute")
        @Expose
        private String customEndMinute;
        @SerializedName("CustomStartHour")
        @Expose
        private String customStartHour;
        @SerializedName("CustomStartMinute")
        @Expose
        private String customStartMinute;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("IsOverRidingTimeTableStartTime")
        @Expose
        private Boolean isOverRidingTimeTableStartTime;
        @SerializedName("ScheduleEndDate")
        @Expose
        private Object scheduleEndDate;
        @SerializedName("ScheduleEnteredDate")
        @Expose
        private String scheduleEnteredDate;
        @SerializedName("ScheduleStartDate")
        @Expose
        private String scheduleStartDate;
        @SerializedName("ScheduledBy")
        @Expose
        private String scheduledBy;
        @SerializedName("ScheduledDurationMinutes")
        @Expose
        private Integer scheduledDurationMinutes;
        @SerializedName("TimeTableName")
        @Expose
        private String timeTableName;
        @SerializedName("WeekRotationTypeName")
        @Expose
        private String weekRotationTypeName;
        @SerializedName("WeekdayName")
        @Expose
        private String weekdayName;

        public String getClientId() {
            return clientId;
        }

        public void setClientId(String clientId) {
            this.clientId = clientId;
        }

        public String getCustomEndHour() {
            return customEndHour;
        }

        public void setCustomEndHour(String customEndHour) {
            this.customEndHour = customEndHour;
        }

        public String getCustomEndMinute() {
            return customEndMinute;
        }

        public void setCustomEndMinute(String customEndMinute) {
            this.customEndMinute = customEndMinute;
        }

        public String getCustomStartHour() {
            return customStartHour;
        }

        public void setCustomStartHour(String customStartHour) {
            this.customStartHour = customStartHour;
        }

        public String getCustomStartMinute() {
            return customStartMinute;
        }

        public void setCustomStartMinute(String customStartMinute) {
            this.customStartMinute = customStartMinute;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public Boolean getIsOverRidingTimeTableStartTime() {
            return isOverRidingTimeTableStartTime;
        }

        public void setIsOverRidingTimeTableStartTime(Boolean isOverRidingTimeTableStartTime) {
            this.isOverRidingTimeTableStartTime = isOverRidingTimeTableStartTime;
        }

        public Object getScheduleEndDate() {
            return scheduleEndDate;
        }

        public void setScheduleEndDate(Object scheduleEndDate) {
            this.scheduleEndDate = scheduleEndDate;
        }

        public String getScheduleEnteredDate() {
            return scheduleEnteredDate;
        }

        public void setScheduleEnteredDate(String scheduleEnteredDate) {
            this.scheduleEnteredDate = scheduleEnteredDate;
        }

        public String getScheduleStartDate() {
            return scheduleStartDate;
        }

        public void setScheduleStartDate(String scheduleStartDate) {
            this.scheduleStartDate = scheduleStartDate;
        }

        public String getScheduledBy() {
            return scheduledBy;
        }

        public void setScheduledBy(String scheduledBy) {
            this.scheduledBy = scheduledBy;
        }

        public Integer getScheduledDurationMinutes() {
            return scheduledDurationMinutes;
        }

        public void setScheduledDurationMinutes(Integer scheduledDurationMinutes) {
            this.scheduledDurationMinutes = scheduledDurationMinutes;
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
}

