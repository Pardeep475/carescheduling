package com.example.carescheduling.Ui.HomeScreen.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EmployeeClientVisitForArrivalRetro {
    @SerializedName("ArrivalRegistrationType")
    @Expose
    private String arrivalRegistrationType;
    @SerializedName("BarcodeId")
    @Expose
    private String barcodeId;
    @SerializedName("BookingId")
    @Expose
    private String bookingId;
    @SerializedName("clientBookingId")
    @Expose
    private String clientBookingId;
    @SerializedName("BranchId")
    @Expose
    private String branchId;
    @SerializedName("ClientId")
    @Expose
    private String clientId;
    @SerializedName("VisitArrivalRegisterredBy")
    @Expose
    private String visitArrivalRegisterredBy;
    @SerializedName("CustomerId")
    @Expose
    private String customerId;
    @SerializedName("DepartureRegistrationType")
    @Expose
    private String departureRegistrationType;
    @SerializedName("EmployeeId")
    @Expose
    private String employeeId;
    @SerializedName("SuggestedLogInTime")
    @Expose
    private String suggestedLogInTime;
    @SerializedName("VisitDate")
    @Expose
    private String visitDate;
    @SerializedName("VisitIdentificationTypeName")
    @Expose
    private Object visitIdentificationTypeName;

    public String getArrivalRegistrationType() {
        return arrivalRegistrationType;
    }

    public void setArrivalRegistrationType(String arrivalRegistrationType) {
        this.arrivalRegistrationType = arrivalRegistrationType;
    }

    public String getBarcodeId() {
        return barcodeId;
    }

    public void setBarcodeId(String barcodeId) {
        this.barcodeId = barcodeId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getClientBookingId() {
        return clientBookingId;
    }

    public void setClientBookingId(String clientBookingId) {
        this.clientBookingId = clientBookingId;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getVisitArrivalRegisterredBy() {
        return visitArrivalRegisterredBy;
    }

    public void setVisitArrivalRegisterredBy(String visitArrivalRegisterredBy) {
        this.visitArrivalRegisterredBy = visitArrivalRegisterredBy;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getDepartureRegistrationType() {
        return departureRegistrationType;
    }

    public void setDepartureRegistrationType(String departureRegistrationType) {
        this.departureRegistrationType = departureRegistrationType;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getSuggestedLogInTime() {
        return suggestedLogInTime;
    }

    public void setSuggestedLogInTime(String suggestedLogInTime) {
        this.suggestedLogInTime = suggestedLogInTime;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public Object getVisitIdentificationTypeName() {
        return visitIdentificationTypeName;
    }

    public void setVisitIdentificationTypeName(Object visitIdentificationTypeName) {
        this.visitIdentificationTypeName = visitIdentificationTypeName;
    }

}
