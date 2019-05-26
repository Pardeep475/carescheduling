package com.example.carescheduling.Ui.Dashboard.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PersonDisability implements Serializable {

    @SerializedName("CustomerId")
    @Expose
    private String customerId;
    @SerializedName("DisabilityTypeName")
    @Expose
    private String disabilityTypeName;
    @SerializedName("PersonId")
    @Expose
    private String personId;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getDisabilityTypeName() {
        return disabilityTypeName;
    }

    public void setDisabilityTypeName(String disabilityTypeName) {
        this.disabilityTypeName = disabilityTypeName;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

}