package com.example.carescheduling.Ui.Dashboard.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PersonLanguageCode implements Serializable {

    @SerializedName("CountryName")
    @Expose
    private String countryName;
    @SerializedName("CustomerId")
    @Expose
    private String customerId;
    @SerializedName("IsDefaultLanguageCode")
    @Expose
    private Boolean isDefaultLanguageCode;
    @SerializedName("LanguageCodeName")
    @Expose
    private String languageCodeName;
    @SerializedName("PersonId")
    @Expose
    private String personId;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Boolean getIsDefaultLanguageCode() {
        return isDefaultLanguageCode;
    }

    public void setIsDefaultLanguageCode(Boolean isDefaultLanguageCode) {
        this.isDefaultLanguageCode = isDefaultLanguageCode;
    }

    public String getLanguageCodeName() {
        return languageCodeName;
    }

    public void setLanguageCodeName(String languageCodeName) {
        this.languageCodeName = languageCodeName;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

}