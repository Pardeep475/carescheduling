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

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
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
    }

    public class BranchList implements Serializable {
        @SerializedName("BranchName")
        private String branchName;
        @SerializedName("BranchId")
        private String branchId;

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
    }
}
