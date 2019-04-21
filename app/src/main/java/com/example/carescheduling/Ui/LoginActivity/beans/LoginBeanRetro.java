package com.example.carescheduling.Ui.LoginActivity.beans;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class LoginBeanRetro implements Serializable {


    @SerializedName("Data")
    private Data data;
    @SerializedName("ResponseMessage")
    private String message;
    @SerializedName("Success")
    private boolean success;

    public void setData(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public class Data implements Serializable {
        @SerializedName("BranchId")
        private String branchId;
        @SerializedName("BranchList")
        private ArrayList<BranchList> branchList;
        @SerializedName("UserPersons")
        private ArrayList<UserPersons> userPersons;

        public String getBranchId() {
            return branchId;
        }

        public void setBranchId(String branchId) {
            this.branchId = branchId;
        }

        public ArrayList<BranchList> getBranchList() {
            return branchList;
        }

        public void setBranchList(ArrayList<BranchList> branchList) {
            this.branchList = branchList;
        }

        public ArrayList<UserPersons> getUserPersons() {
            return userPersons;
        }

        public void setUserPersons(ArrayList<UserPersons> userPersons) {
            this.userPersons = userPersons;
        }
    }

    public class BranchList implements Serializable {
        @SerializedName("BranchName")
        private String branchName;
        @SerializedName("BranchId")
        private String branchId;
        @SerializedName("CustomerId")
        private String customerId;

        public String getBranchName() {
            return branchName;
        }

        public void setBranchName(String branchName) {
            this.branchName = branchName;
        }

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
    }

    public class UserPersons implements Serializable {
        @SerializedName("User")
        private User user;

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }
    }

    public class User implements Serializable {
        @SerializedName("PersonId")
        private String personId;

        public String getPersonId() {
            return personId;
        }

        public void setPersonId(String personId) {
            this.personId = personId;
        }
    }
}
