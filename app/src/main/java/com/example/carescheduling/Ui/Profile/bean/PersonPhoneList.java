package com.example.carescheduling.Ui.Profile.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class PersonPhoneList implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @NonNull
    private int id;
    @SerializedName("CanNotCall")
    @Expose
    private boolean canNotCall;
    @SerializedName("CountryTelephonePrefix")
    @Expose
    private String countryTelephonePrefix;
    @SerializedName("CustomerId")
    @Expose
    private String customerId;
    @SerializedName("IsDefaultPhone")
    @Expose
    private Boolean isDefaultPhone;
    @SerializedName("PersonId")
    @Expose
    private String personId;
    @SerializedName("PhoneNumber")
    @Expose
    private String phoneNumber;
    @SerializedName("PhoneTypeName")
    @Expose
    private String phoneTypeName;

    public boolean getCanNotCall() {
        return canNotCall;
    }

    public void setCanNotCall(boolean canNotCall) {
        this.canNotCall = canNotCall;
    }

    public String getCountryTelephonePrefix() {
        return countryTelephonePrefix;
    }

    public void setCountryTelephonePrefix(String countryTelephonePrefix) {
        this.countryTelephonePrefix = countryTelephonePrefix;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Boolean getIsDefaultPhone() {
        return isDefaultPhone;
    }

    public void setIsDefaultPhone(Boolean isDefaultPhone) {
        this.isDefaultPhone = isDefaultPhone;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneTypeName() {
        return phoneTypeName;
    }

    public void setPhoneTypeName(String phoneTypeName) {
        this.phoneTypeName = phoneTypeName;
    }

    public int getId() {
        return id; }

    public void setId(int id) {
        this.id = id;
    }

}
