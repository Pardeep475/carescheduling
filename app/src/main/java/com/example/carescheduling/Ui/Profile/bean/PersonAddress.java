package com.example.carescheduling.Ui.Profile.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PersonAddress {
    @SerializedName("AddressId")
    @Expose
    private Integer addressId;
    @SerializedName("AddressTypeName")
    @Expose
    private String addressTypeName;
    @SerializedName("CustomerId")
    @Expose
    private String customerId;
    @SerializedName("IsDefaultAddress")
    @Expose
    private Boolean isDefaultAddress;
    @SerializedName("PersonId")
    @Expose
    private String personId;



    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getAddressTypeName() {
        return addressTypeName;
    }

    public void setAddressTypeName(String addressTypeName) {
        this.addressTypeName = addressTypeName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Boolean getIsDefaultAddress() {
        return isDefaultAddress;
    }

    public void setIsDefaultAddress(Boolean isDefaultAddress) {
        this.isDefaultAddress = isDefaultAddress;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

}
