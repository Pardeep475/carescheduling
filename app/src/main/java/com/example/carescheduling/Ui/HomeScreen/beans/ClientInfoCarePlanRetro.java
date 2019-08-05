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
/*

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
*/


        @SerializedName("ClientId")
        @Expose
        private String clientId;
        @SerializedName("ClientName")
        @Expose
        private String clientName;
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
        private String scheduleEndDate;
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

        public String getClientName() {
            return clientName;
        }

        public void setClientName(String clientName) {
            this.clientName = clientName;
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

        public String getScheduleEndDate() {
            return scheduleEndDate;
        }

        public void setScheduleEndDate(String scheduleEndDate) {
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

