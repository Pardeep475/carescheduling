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
    public class Data {

        @SerializedName("BookingDate")
        @Expose
        private String bookingDate;
        @SerializedName("BookingEndTime")
        @Expose
        private String bookingEndTime;
        @SerializedName("BookingStartTime")
        @Expose
        private String bookingStartTime;
        @SerializedName("ClientAddress")
        @Expose
        private ClientAddress clientAddress;
        @SerializedName("ClientBookingId")
        @Expose
        private String clientBookingId;
        @SerializedName("ClientName")
        @Expose
        private String clientName;
        @SerializedName("ClientPersonId")
        @Expose
        private String clientPersonId;
        @SerializedName("ClientPhoneNumber")
        @Expose
        private String clientPhoneNumber;
        @SerializedName("ImageHexString")
        @Expose
        private String imageHexString;
        @SerializedName("Person")
        @Expose
        private Object person;
        @SerializedName("TaskList")
        @Expose
        private List<TaskList> taskList = null;
        @SerializedName("Weekdayname")
        @Expose
        private String weekdayname;

        public String getBookingDate() {
            return bookingDate;
        }

        public void setBookingDate(String bookingDate) {
            this.bookingDate = bookingDate;
        }

        public String getBookingEndTime() {
            return bookingEndTime;
        }

        public void setBookingEndTime(String bookingEndTime) {
            this.bookingEndTime = bookingEndTime;
        }

        public String getBookingStartTime() {
            return bookingStartTime;
        }

        public void setBookingStartTime(String bookingStartTime) {
            this.bookingStartTime = bookingStartTime;
        }

        public ClientAddress getClientAddress() {
            return clientAddress;
        }

        public void setClientAddress(ClientAddress clientAddress) {
            this.clientAddress = clientAddress;
        }

        public String getClientBookingId() {
            return clientBookingId;
        }

        public void setClientBookingId(String clientBookingId) {
            this.clientBookingId = clientBookingId;
        }

        public String getClientName() {
            return clientName;
        }

        public void setClientName(String clientName) {
            this.clientName = clientName;
        }

        public String getClientPersonId() {
            return clientPersonId;
        }

        public void setClientPersonId(String clientPersonId) {
            this.clientPersonId = clientPersonId;
        }

        public String getClientPhoneNumber() {
            return clientPhoneNumber;
        }

        public void setClientPhoneNumber(String clientPhoneNumber) {
            this.clientPhoneNumber = clientPhoneNumber;
        }

        public String getImageHexString() {
            return imageHexString;
        }

        public void setImageHexString(String imageHexString) {
            this.imageHexString = imageHexString;
        }

        public Object getPerson() {
            return person;
        }

        public void setPerson(Object person) {
            this.person = person;
        }

        public List<TaskList> getTaskList() {
            return taskList;
        }

        public void setTaskList(List<TaskList> taskList) {
            this.taskList = taskList;
        }

        public String getWeekdayname() {
            return weekdayname;
        }

        public void setWeekdayname(String weekdayname) {
            this.weekdayname = weekdayname;
        }

    }

    public class TaskList {

        @SerializedName("ActionModel")
        @Expose
        private ActionModel actionModel;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("TaskAdded")
        @Expose
        private String taskAdded;
        @SerializedName("TaskAddedByEmployeePersonId")
        @Expose
        private String taskAddedByEmployeePersonId;
        @SerializedName("TaskId")
        @Expose
        private String taskId;
        @SerializedName("TaskIsRemoved")
        @Expose
        private Object taskIsRemoved;
        @SerializedName("TaskName")
        @Expose
        private String taskName;
        @SerializedName("TaskRemoved")
        @Expose
        private Object taskRemoved;
        @SerializedName("TaskRemovedByEmployeePersonId")
        @Expose
        private Object taskRemovedByEmployeePersonId;
        @SerializedName("TaskTypeName")
        @Expose
        private String taskTypeName;
        @SerializedName("TaskUpdatedByEmployeePersonId")
        @Expose
        private String taskUpdatedByEmployeePersonId;
        @SerializedName("TaskUpdatedDate")
        @Expose
        private String taskUpdatedDate;

        public ActionModel getActionModel() {
            return actionModel;
        }

        public void setActionModel(ActionModel actionModel) {
            this.actionModel = actionModel;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getTaskAdded() {
            return taskAdded;
        }

        public void setTaskAdded(String taskAdded) {
            this.taskAdded = taskAdded;
        }

        public String getTaskAddedByEmployeePersonId() {
            return taskAddedByEmployeePersonId;
        }

        public void setTaskAddedByEmployeePersonId(String taskAddedByEmployeePersonId) {
            this.taskAddedByEmployeePersonId = taskAddedByEmployeePersonId;
        }

        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }

        public Object getTaskIsRemoved() {
            return taskIsRemoved;
        }

        public void setTaskIsRemoved(Object taskIsRemoved) {
            this.taskIsRemoved = taskIsRemoved;
        }

        public String getTaskName() {
            return taskName;
        }

        public void setTaskName(String taskName) {
            this.taskName = taskName;
        }

        public Object getTaskRemoved() {
            return taskRemoved;
        }

        public void setTaskRemoved(Object taskRemoved) {
            this.taskRemoved = taskRemoved;
        }

        public Object getTaskRemovedByEmployeePersonId() {
            return taskRemovedByEmployeePersonId;
        }

        public void setTaskRemovedByEmployeePersonId(Object taskRemovedByEmployeePersonId) {
            this.taskRemovedByEmployeePersonId = taskRemovedByEmployeePersonId;
        }

        public String getTaskTypeName() {
            return taskTypeName;
        }

        public void setTaskTypeName(String taskTypeName) {
            this.taskTypeName = taskTypeName;
        }

        public String getTaskUpdatedByEmployeePersonId() {
            return taskUpdatedByEmployeePersonId;
        }

        public void setTaskUpdatedByEmployeePersonId(String taskUpdatedByEmployeePersonId) {
            this.taskUpdatedByEmployeePersonId = taskUpdatedByEmployeePersonId;
        }

        public String getTaskUpdatedDate() {
            return taskUpdatedDate;
        }

        public void setTaskUpdatedDate(String taskUpdatedDate) {
            this.taskUpdatedDate = taskUpdatedDate;
        }

    }

    public class ActionModel {

        @SerializedName("ActionAlarmDate")
        @Expose
        private String actionAlarmDate;
        @SerializedName("ActionDocumentModel")
        @Expose
        private List<Object> actionDocumentModel = null;
        @SerializedName("ActionDueDate")
        @Expose
        private String actionDueDate;
        @SerializedName("ActionMessageModel")
        @Expose
        private List<Object> actionMessageModel = null;
        @SerializedName("ActionNoteModel")
        @Expose
        private List<Object> actionNoteModel = null;
        @SerializedName("ActionStatusTypeName")
        @Expose
        private String actionStatusTypeName;
        @SerializedName("ActionSubject")
        @Expose
        private String actionSubject;
        @SerializedName("ActionTypeName")
        @Expose
        private String actionTypeName;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("TaskId")
        @Expose
        private String taskId;

        public String getActionAlarmDate() {
            return actionAlarmDate;
        }

        public void setActionAlarmDate(String actionAlarmDate) {
            this.actionAlarmDate = actionAlarmDate;
        }

        public List<Object> getActionDocumentModel() {
            return actionDocumentModel;
        }

        public void setActionDocumentModel(List<Object> actionDocumentModel) {
            this.actionDocumentModel = actionDocumentModel;
        }

        public String getActionDueDate() {
            return actionDueDate;
        }

        public void setActionDueDate(String actionDueDate) {
            this.actionDueDate = actionDueDate;
        }

        public List<Object> getActionMessageModel() {
            return actionMessageModel;
        }

        public void setActionMessageModel(List<Object> actionMessageModel) {
            this.actionMessageModel = actionMessageModel;
        }

        public List<Object> getActionNoteModel() {
            return actionNoteModel;
        }

        public void setActionNoteModel(List<Object> actionNoteModel) {
            this.actionNoteModel = actionNoteModel;
        }

        public String getActionStatusTypeName() {
            return actionStatusTypeName;
        }

        public void setActionStatusTypeName(String actionStatusTypeName) {
            this.actionStatusTypeName = actionStatusTypeName;
        }

        public String getActionSubject() {
            return actionSubject;
        }

        public void setActionSubject(String actionSubject) {
            this.actionSubject = actionSubject;
        }

        public String getActionTypeName() {
            return actionTypeName;
        }

        public void setActionTypeName(String actionTypeName) {
            this.actionTypeName = actionTypeName;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }

    }

    public class ClientAddress {

        @SerializedName("AddressId")
        @Expose
        private Integer addressId;
        @SerializedName("BuildingName")
        @Expose
        private String buildingName;
        @SerializedName("BuildingNumber")
        @Expose
        private String buildingNumber;
        @SerializedName("CountryName")
        @Expose
        private String countryName;
        @SerializedName("DeliveryPointSuffix")
        @Expose
        private String deliveryPointSuffix;
        @SerializedName("DepartmentName")
        @Expose
        private String departmentName;
        @SerializedName("DependentLocality")
        @Expose
        private String dependentLocality;
        @SerializedName("DoubleDependentLocality")
        @Expose
        private String doubleDependentLocality;
        @SerializedName("IsActive")
        @Expose
        private Boolean isActive;
        @SerializedName("IsCustom")
        @Expose
        private Boolean isCustom;
        @SerializedName("OrganisationName")
        @Expose
        private String organisationName;
        @SerializedName("POBox")
        @Expose
        private String pOBox;
        @SerializedName("PostCodeName")
        @Expose
        private String postCodeName;
        @SerializedName("SUOrganisationFlag")
        @Expose
        private String sUOrganisationFlag;
        @SerializedName("StreetName")
        @Expose
        private String streetName;
        @SerializedName("SubBuildingName")
        @Expose
        private String subBuildingName;
        @SerializedName("Thoroughfare")
        @Expose
        private String thoroughfare;
        @SerializedName("UDPRN")
        @Expose
        private Integer uDPRN;

        public Integer getAddressId() {
            return addressId;
        }

        public void setAddressId(Integer addressId) {
            this.addressId = addressId;
        }

        public String getBuildingName() {
            return buildingName;
        }

        public void setBuildingName(String buildingName) {
            this.buildingName = buildingName;
        }

        public String getBuildingNumber() {
            return buildingNumber;
        }

        public void setBuildingNumber(String buildingNumber) {
            this.buildingNumber = buildingNumber;
        }

        public String getCountryName() {
            return countryName;
        }

        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }

        public String getDeliveryPointSuffix() {
            return deliveryPointSuffix;
        }

        public void setDeliveryPointSuffix(String deliveryPointSuffix) {
            this.deliveryPointSuffix = deliveryPointSuffix;
        }

        public String getDepartmentName() {
            return departmentName;
        }

        public void setDepartmentName(String departmentName) {
            this.departmentName = departmentName;
        }

        public String getDependentLocality() {
            return dependentLocality;
        }

        public void setDependentLocality(String dependentLocality) {
            this.dependentLocality = dependentLocality;
        }

        public String getDoubleDependentLocality() {
            return doubleDependentLocality;
        }

        public void setDoubleDependentLocality(String doubleDependentLocality) {
            this.doubleDependentLocality = doubleDependentLocality;
        }

        public Boolean getIsActive() {
            return isActive;
        }

        public void setIsActive(Boolean isActive) {
            this.isActive = isActive;
        }

        public Boolean getIsCustom() {
            return isCustom;
        }

        public void setIsCustom(Boolean isCustom) {
            this.isCustom = isCustom;
        }

        public String getOrganisationName() {
            return organisationName;
        }

        public void setOrganisationName(String organisationName) {
            this.organisationName = organisationName;
        }

        public String getPOBox() {
            return pOBox;
        }

        public void setPOBox(String pOBox) {
            this.pOBox = pOBox;
        }

        public String getPostCodeName() {
            return postCodeName;
        }

        public void setPostCodeName(String postCodeName) {
            this.postCodeName = postCodeName;
        }

        public String getSUOrganisationFlag() {
            return sUOrganisationFlag;
        }

        public void setSUOrganisationFlag(String sUOrganisationFlag) {
            this.sUOrganisationFlag = sUOrganisationFlag;
        }

        public String getStreetName() {
            return streetName;
        }

        public void setStreetName(String streetName) {
            this.streetName = streetName;
        }

        public String getSubBuildingName() {
            return subBuildingName;
        }

        public void setSubBuildingName(String subBuildingName) {
            this.subBuildingName = subBuildingName;
        }

        public String getThoroughfare() {
            return thoroughfare;
        }

        public void setThoroughfare(String thoroughfare) {
            this.thoroughfare = thoroughfare;
        }

        public Integer getUDPRN() {
            return uDPRN;
        }

        public void setUDPRN(Integer uDPRN) {
            this.uDPRN = uDPRN;
        }

    }
}
