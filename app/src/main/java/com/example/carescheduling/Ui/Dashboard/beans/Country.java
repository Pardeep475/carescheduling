package com.example.carescheduling.Ui.Dashboard.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Country implements Serializable {

    @SerializedName("ContinentName")
    @Expose
    private String continentName;
    @SerializedName("CountryCodeName")
    @Expose
    private String countryCodeName;
    @SerializedName("CountryInternetDomainName")
    @Expose
    private String countryInternetDomainName;
    @SerializedName("CountryName")
    @Expose
    private String countryName;
    @SerializedName("CountryTelephonePrefix")
    @Expose
    private String countryTelephonePrefix;
    @SerializedName("CurrencyCode")
    @Expose
    private String currencyCode;
    @SerializedName("IsSovereign")
    @Expose
    private Boolean isSovereign;
    @SerializedName("ParentCountryName")
    @Expose
    private String parentCountryName;

    public String getContinentName() {
        return continentName;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }

    public String getCountryCodeName() {
        return countryCodeName;
    }

    public void setCountryCodeName(String countryCodeName) {
        this.countryCodeName = countryCodeName;
    }

    public String getCountryInternetDomainName() {
        return countryInternetDomainName;
    }

    public void setCountryInternetDomainName(String countryInternetDomainName) {
        this.countryInternetDomainName = countryInternetDomainName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryTelephonePrefix() {
        return countryTelephonePrefix;
    }

    public void setCountryTelephonePrefix(String countryTelephonePrefix) {
        this.countryTelephonePrefix = countryTelephonePrefix;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Boolean getIsSovereign() {
        return isSovereign;
    }

    public void setIsSovereign(Boolean isSovereign) {
        this.isSovereign = isSovereign;
    }

    public String getParentCountryName() {
        return parentCountryName;
    }

    public void setParentCountryName(String parentCountryName) {
        this.parentCountryName = parentCountryName;
    }

}