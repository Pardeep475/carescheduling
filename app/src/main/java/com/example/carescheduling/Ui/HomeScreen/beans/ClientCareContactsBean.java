package com.example.carescheduling.Ui.HomeScreen.beans;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientCareContactsBean {

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

        @SerializedName("ContactTypeName")
        @Expose
        private String contactTypeName;
        @SerializedName("EmailAddress")
        @Expose
        private String emailAddress;
        @SerializedName("PersonAddress")
        @Expose
        private String personAddress;
        @SerializedName("PersonId")
        @Expose
        private String personId;
        @SerializedName("PersonName")
        @Expose
        private String personName;
        @SerializedName("PersonPhone")
        @Expose
        private String personPhone;

        public String getContactTypeName() {
            return contactTypeName;
        }

        public void setContactTypeName(String contactTypeName) {
            this.contactTypeName = contactTypeName;
        }

        public String getEmailAddress() {
            return emailAddress;
        }

        public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
        }

        public String getPersonAddress() {
            return personAddress;
        }

        public void setPersonAddress(String personAddress) {
            this.personAddress = personAddress;
        }

        public String getPersonId() {
            return personId;
        }

        public void setPersonId(String personId) {
            this.personId = personId;
        }

        public String getPersonName() {
            return personName;
        }

        public void setPersonName(String personName) {
            this.personName = personName;
        }

        public String getPersonPhone() {
            return personPhone;
        }

        public void setPersonPhone(String personPhone) {
            this.personPhone = personPhone;
        }

    }
}
