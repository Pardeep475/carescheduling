package com.example.carescheduling.data.Local.DatabaseTable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ProfileMainData")
public class ProfileMainData {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @NonNull
    private int id;
    @ColumnInfo(name = "userName_main")
    private String userName;
    @ColumnInfo(name = "address_main")
    private String address;
    @ColumnInfo(name = "telephone_main")
    private String telephone;
    @ColumnInfo(name = "email_main")
    private String email;
    @ColumnInfo(name = "mobile_main")
    private String mobile;
    @ColumnInfo(name = "defaultImageString_main")
    private String defaultImageString;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getDefaultImageString() {
        return defaultImageString;
    }

    public void setDefaultImageString(String defaultImageString) {
        this.defaultImageString = defaultImageString;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
