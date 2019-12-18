package com.example.carescheduling.Ui.LoginActivity.beans;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

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