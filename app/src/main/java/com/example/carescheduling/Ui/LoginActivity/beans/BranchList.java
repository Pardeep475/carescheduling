package com.example.carescheduling.Ui.LoginActivity.beans;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

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
