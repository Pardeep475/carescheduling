package com.example.carescheduling.data.Local.DatabaseTable;

import android.graphics.Bitmap;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ProfileMainData")
public class ProfileMainData {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "userName")
    private String userName;
    @ColumnInfo(name = "address")
    private String address;
    @ColumnInfo(name = "telephone")
    private String telephone;
    @ColumnInfo(name = "email")
    private String email;
    @ColumnInfo(name = "mobile")
    private String mobile;
    @ColumnInfo(name = "defaultImageString")
    private String defaultImageString;

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
