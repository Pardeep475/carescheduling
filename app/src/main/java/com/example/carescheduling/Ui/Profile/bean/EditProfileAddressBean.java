package com.example.carescheduling.Ui.Profile.bean;

import java.util.ArrayList;

public class EditProfileAddressBean {
    private ArrayList<String> addressArray;
    private ArrayList<String> phoneArray;
    private ArrayList<String> emailArray;

    public ArrayList<String> getAddressArray() {
        return addressArray;
    }

    public void setAddressArray(ArrayList<String> addressArray) {
        this.addressArray = addressArray;
    }

    public ArrayList<String> getPhoneArray() {
        return phoneArray;
    }

    public void setPhoneArray(ArrayList<String> phoneArray) {
        this.phoneArray = phoneArray;
    }

    public ArrayList<String> getEmailArray() {
        return emailArray;
    }

    public void setEmailArray(ArrayList<String> emailArray) {
        this.emailArray = emailArray;
    }
}
