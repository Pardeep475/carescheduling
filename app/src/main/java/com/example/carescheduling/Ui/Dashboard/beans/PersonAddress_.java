package com.example.carescheduling.Ui.Dashboard.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PersonAddress_ implements Serializable {

    @SerializedName("Address")
    @Expose
    private Address address;
    @SerializedName("AddressTypeName")
    @Expose
    private String addressTypeName;
    @SerializedName("CountryPostCode")
    @Expose
    private CountryPostCode countryPostCode;
    @SerializedName("IsDefaultAddress")
    @Expose
    private Boolean isDefaultAddress;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getAddressTypeName() {
        return addressTypeName;
    }

    public void setAddressTypeName(String addressTypeName) {
        this.addressTypeName = addressTypeName;
    }

    public CountryPostCode getCountryPostCode() {
        return countryPostCode;
    }

    public void setCountryPostCode(CountryPostCode countryPostCode) {
        this.countryPostCode = countryPostCode;
    }

    public Boolean getIsDefaultAddress() {
        return isDefaultAddress;
    }

    public void setIsDefaultAddress(Boolean isDefaultAddress) {
        this.isDefaultAddress = isDefaultAddress;
    }

}