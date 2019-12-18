package com.example.carescheduling.Ui.Dashboard.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PersonEthnicity implements Serializable {

    @SerializedName("CustomerId")
    @Expose
    private String customerId;
    @SerializedName("EthnicityTypeName")
    @Expose
    private String ethnicityTypeName;
    @SerializedName("PersonId")
    @Expose
    private String personId;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getEthnicityTypeName() {
        return ethnicityTypeName;
    }

    public void setEthnicityTypeName(String ethnicityTypeName) {
        this.ethnicityTypeName = ethnicityTypeName;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

}