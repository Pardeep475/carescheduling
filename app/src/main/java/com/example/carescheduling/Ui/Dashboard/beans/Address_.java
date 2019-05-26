package com.example.carescheduling.Ui.Dashboard.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Address_ implements Serializable {

    @SerializedName("AddressId")
    @Expose
    private Integer addressId;
    @SerializedName("BuildingName")
    @Expose
    private String buildingName;
    @SerializedName("BuildingNumber")
    @Expose
    private String buildingNumber;
    @SerializedName("CountryName")
    @Expose
    private String countryName;
    @SerializedName("DeliveryPointSuffix")
    @Expose
    private String deliveryPointSuffix;
    @SerializedName("DepartmentName")
    @Expose
    private String departmentName;
    @SerializedName("DependentLocality")
    @Expose
    private String dependentLocality;
    @SerializedName("DoubleDependentLocality")
    @Expose
    private String doubleDependentLocality;
    @SerializedName("IsActive")
    @Expose
    private Boolean isActive;
    @SerializedName("IsCustom")
    @Expose
    private Boolean isCustom;
    @SerializedName("OrganisationName")
    @Expose
    private String organisationName;
    @SerializedName("POBox")
    @Expose
    private String pOBox;
    @SerializedName("PostCodeName")
    @Expose
    private String postCodeName;
    @SerializedName("SUOrganisationFlag")
    @Expose
    private String sUOrganisationFlag;
    @SerializedName("StreetName")
    @Expose
    private String streetName;
    @SerializedName("SubBuildingName")
    @Expose
    private String subBuildingName;
    @SerializedName("Thoroughfare")
    @Expose
    private String thoroughfare;
    @SerializedName("UDPRN")
    @Expose
    private Integer uDPRN;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getDeliveryPointSuffix() {
        return deliveryPointSuffix;
    }

    public void setDeliveryPointSuffix(String deliveryPointSuffix) {
        this.deliveryPointSuffix = deliveryPointSuffix;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDependentLocality() {
        return dependentLocality;
    }

    public void setDependentLocality(String dependentLocality) {
        this.dependentLocality = dependentLocality;
    }

    public String getDoubleDependentLocality() {
        return doubleDependentLocality;
    }

    public void setDoubleDependentLocality(String doubleDependentLocality) {
        this.doubleDependentLocality = doubleDependentLocality;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsCustom() {
        return isCustom;
    }

    public void setIsCustom(Boolean isCustom) {
        this.isCustom = isCustom;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    public String getPOBox() {
        return pOBox;
    }

    public void setPOBox(String pOBox) {
        this.pOBox = pOBox;
    }

    public String getPostCodeName() {
        return postCodeName;
    }

    public void setPostCodeName(String postCodeName) {
        this.postCodeName = postCodeName;
    }

    public String getSUOrganisationFlag() {
        return sUOrganisationFlag;
    }

    public void setSUOrganisationFlag(String sUOrganisationFlag) {
        this.sUOrganisationFlag = sUOrganisationFlag;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getSubBuildingName() {
        return subBuildingName;
    }

    public void setSubBuildingName(String subBuildingName) {
        this.subBuildingName = subBuildingName;
    }

    public String getThoroughfare() {
        return thoroughfare;
    }

    public void setThoroughfare(String thoroughfare) {
        this.thoroughfare = thoroughfare;
    }

    public Integer getUDPRN() {
        return uDPRN;
    }

    public void setUDPRN(Integer uDPRN) {
        this.uDPRN = uDPRN;
    }

}