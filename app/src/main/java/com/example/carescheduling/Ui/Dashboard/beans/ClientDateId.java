package com.example.carescheduling.Ui.Dashboard.beans;

public class ClientDateId {
    private String dateTime;
    private String clientPersonId;

    public ClientDateId(String dateTime, String clientPersonId, String clientBookingId, String clientBookingStartDate, String clientBookingEndDate) {
        this.dateTime = dateTime;
        this.clientPersonId = clientPersonId;
        this.clientBookingId = clientBookingId;
        this.clientBookingStartDate = clientBookingStartDate;
        this.clientBookingEndDate = clientBookingEndDate;
    }

    private String clientBookingId;
    private String clientBookingStartDate;
    private String clientBookingEndDate;

    public String getClientBookingId() {
        return clientBookingId;
    }

    public void setClientBookingId(String clientBookingId) {
        this.clientBookingId = clientBookingId;
    }

    public String getClientBookingStartDate() {
        return clientBookingStartDate;
    }

    public void setClientBookingStartDate(String clientBookingStartDate) {
        this.clientBookingStartDate = clientBookingStartDate;
    }

    public String getClientBookingEndDate() {
        return clientBookingEndDate;
    }

    public void setClientBookingEndDate(String clientBookingEndDate) {
        this.clientBookingEndDate = clientBookingEndDate;
    }




    public ClientDateId(String dateTime, String clientPersonId) {
        this.dateTime = dateTime;
        this.clientPersonId = clientPersonId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getClientPersonId() {
        return clientPersonId;
    }

    public void setClientPersonId(String clientPersonId) {
        this.clientPersonId = clientPersonId;
    }




}
