package com.example.carescheduling.Ui.Dashboard.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class CountryPostCode implements Serializable {

    @SerializedName("Address")
    @Expose
    private List<Address_> address = null;
    @SerializedName("Country")
    @Expose
    private Country country;
    @SerializedName("CountryName")
    @Expose
    private String countryName;
    @SerializedName("CountyAdministrativeName")
    @Expose
    private String countyAdministrativeName;
    @SerializedName("DistrictName")
    @Expose
    private String districtName;
    @SerializedName("IsInUse")
    @Expose
    private Boolean isInUse;
    @SerializedName("Latitude")
    @Expose
    private Double latitude;
    @SerializedName("Longitude")
    @Expose
    private Double longitude;
    @SerializedName("PQI")
    @Expose
    private String pQI;
    @SerializedName("PostCodeName")
    @Expose
    private String postCodeName;
    @SerializedName("PostTownName")
    @Expose
    private String postTownName;
    @SerializedName("RegionName")
    @Expose
    private String regionName;
    @SerializedName("WardName")
    @Expose
    private String wardName;
    @SerializedName("XCord")
    @Expose
    private String xCord;
    @SerializedName("YCord")
    @Expose
    private String yCord;

    public List<Address_> getAddress() {
        return address;
    }

    public void setAddress(List<Address_> address) {
        this.address = address;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountyAdministrativeName() {
        return countyAdministrativeName;
    }

    public void setCountyAdministrativeName(String countyAdministrativeName) {
        this.countyAdministrativeName = countyAdministrativeName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Boolean getIsInUse() {
        return isInUse;
    }

    public void setIsInUse(Boolean isInUse) {
        this.isInUse = isInUse;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getPQI() {
        return pQI;
    }

    public void setPQI(String pQI) {
        this.pQI = pQI;
    }

    public String getPostCodeName() {
        return postCodeName;
    }

    public void setPostCodeName(String postCodeName) {
        this.postCodeName = postCodeName;
    }

    public String getPostTownName() {
        return postTownName;
    }

    public void setPostTownName(String postTownName) {
        this.postTownName = postTownName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName;
    }

    public String getXCord() {
        return xCord;
    }

    public void setXCord(String xCord) {
        this.xCord = xCord;
    }

    public String getYCord() {
        return yCord;
    }

    public void setYCord(String yCord) {
        this.yCord = yCord;
    }

}