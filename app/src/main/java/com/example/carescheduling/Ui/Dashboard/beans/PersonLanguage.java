package com.example.carescheduling.Ui.Dashboard.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PersonLanguage implements Serializable {

    @SerializedName("CustomerId")
    @Expose
    private String customerId;
    @SerializedName("IsDefaultLanguage")
    @Expose
    private Boolean isDefaultLanguage;
    @SerializedName("LanguageName")
    @Expose
    private String languageName;
    @SerializedName("PersonId")
    @Expose
    private String personId;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Boolean getIsDefaultLanguage() {
        return isDefaultLanguage;
    }

    public void setIsDefaultLanguage(Boolean isDefaultLanguage) {
        this.isDefaultLanguage = isDefaultLanguage;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

}

