package com.example.carescheduling.Ui.Dashboard.beans;

import android.graphics.Bitmap;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//@Entity(tableName = "ProfileResultBean")
public class ProfileResultBean {
//    @PrimaryKey(autoGenerate = true)
//    @ColumnInfo(name = "id")
//    @NonNull
//    private int id;
    private String userName, address, telephone, email, mobile, defaultImageString;
    private Bitmap imgUrl;

    public Bitmap getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(Bitmap imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDefaultImageString() {
        return defaultImageString;
    }

    public void setDefaultImageString(String defaultImageString) {
        this.defaultImageString = defaultImageString;
    }
}
