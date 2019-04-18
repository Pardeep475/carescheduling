package com.example.carescheduling.Ui.LoginActivity.beans;

public class LoginBeanSF {
    private String branchName,branchId;
    private boolean branchSelected;

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

    public boolean isBranchSelected() {
        return branchSelected;
    }

    public void setBranchSelected(boolean branchSelected) {
        this.branchSelected = branchSelected;
    }
}
