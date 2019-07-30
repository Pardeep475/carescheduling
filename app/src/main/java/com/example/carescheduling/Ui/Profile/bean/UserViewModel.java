package com.example.carescheduling.Ui.Profile.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserViewModel implements Serializable {

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
    public class Data  implements Serializable{

        @SerializedName("BranchId")
        @Expose
        private String branchId;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("PasswordQuestion")
        @Expose
        private String passwordQuestion;
        @SerializedName("PasswordQuestionAnswer")
        @Expose
        private String passwordQuestionAnswer;
        @SerializedName("PersonId")
        @Expose
        private String personId;
        @SerializedName("UserName")
        @Expose
        private String userName;

        public String getBranchId() {
            return branchId;
        }

        public void setBranchId(String branchId) {
            this.branchId = branchId;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getPasswordQuestion() {
            return passwordQuestion;
        }

        public void setPasswordQuestion(String passwordQuestion) {
            this.passwordQuestion = passwordQuestion;
        }

        public String getPasswordQuestionAnswer() {
            return passwordQuestionAnswer;
        }

        public void setPasswordQuestionAnswer(String passwordQuestionAnswer) {
            this.passwordQuestionAnswer = passwordQuestionAnswer;
        }

        public String getPersonId() {
            return personId;
        }

        public void setPersonId(String personId) {
            this.personId = personId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

    }
}