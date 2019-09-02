package com.example.carescheduling.Ui.Profile.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


public class PersonAddressList implements Serializable {
    @SerializedName("PersonAddress")
    @Expose
    private PersonAddress personAddress;
    @SerializedName("CountryName")
    @Expose
    private String  countryCode;
    @SerializedName("PostCodeName")
    @Expose
    private String postCode;
    @SerializedName("IsDefaultAddress")
    @Expose
    private Boolean isDefaultAddress;

    @SerializedName("AddressTypeName")
    @Expose
    private String addressTypeName;
    @SerializedName("AddressId")
    @Expose
    private Integer addressId;
    public PersonAddress getPersonAddress() {
        return personAddress;
    }

    public void setPersonAddress(PersonAddress personAddress) {
        this.personAddress = personAddress;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public Boolean getDefaultAddress() {
        return isDefaultAddress;
    }

    public void setDefaultAddress(Boolean defaultAddress) {
        isDefaultAddress = defaultAddress;
    }

    public String getAddressTypeName() {
        return addressTypeName;
    }

    public void setAddressTypeName(String addressTypeName) {
        this.addressTypeName = addressTypeName;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
}
