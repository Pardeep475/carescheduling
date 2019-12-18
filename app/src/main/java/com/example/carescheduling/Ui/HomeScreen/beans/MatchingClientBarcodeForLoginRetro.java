package com.example.carescheduling.Ui.HomeScreen.beans;

public class MatchingClientBarcodeForLoginRetro {
    private String ClientPersonId, BarcodeInfoString, CustomerId, BranchId, EmployeePersonId, ClientBookingId;
    private boolean IsDeparture;


    public String getClientBookingId() {
        return ClientBookingId;
    }

    public void setClientBookingId(String clientBookingId) {
        ClientBookingId = clientBookingId;
    }

    public boolean getIsDeparture() {
        return IsDeparture;
    }

    public void setIsDeparture(boolean isDeparture) {
        IsDeparture = isDeparture;
    }

    public String getClientPersonId() {
        return ClientPersonId;
    }

    public void setClientPersonId(String clientPersonId) {
        ClientPersonId = clientPersonId;
    }


    public String getBarcodeInfoString() {
        return BarcodeInfoString;
    }

    public void setBarcodeInfoString(String barcodeInfoString) {
        BarcodeInfoString = barcodeInfoString;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }

    public String getBranchId() {
        return BranchId;
    }

    public void setBranchId(String branchId) {
        BranchId = branchId;
    }

    public String getEmployeePersonId() {
        return EmployeePersonId;
    }

    public void setEmployeePersonId(String employeePersonId) {
        EmployeePersonId = employeePersonId;
    }
}
