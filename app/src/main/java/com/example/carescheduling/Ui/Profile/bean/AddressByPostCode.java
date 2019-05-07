package com.example.carescheduling.Ui.Profile.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AddressByPostCode {

    @SerializedName("Data")
    @Expose
    private Data data;
    @SerializedName("DataList")
    @Expose
    private Object dataList;
    @SerializedName("Exception")
    @Expose
    private Object exception;
    @SerializedName("ResponseMessage")
    @Expose
    private Object responseMessage;
    @SerializedName("Success")
    @Expose
    private Boolean success;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Object getDataList() {
        return dataList;
    }

    public void setDataList(Object dataList) {
        this.dataList = dataList;
    }

    public Object getException() {
        return exception;
    }

    public void setException(Object exception) {
        this.exception = exception;
    }

    public Object getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(Object responseMessage) {
        this.responseMessage = responseMessage;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
    public class Address {

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
    public class Country {

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

    public class CountryPostCode {

        @SerializedName("Address")
        @Expose
        private List<Address> address = null;
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

        public List<Address> getAddress() {
            return address;
        }

        public void setAddress(List<Address> address) {
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

    public class Data {

        @SerializedName("Address")
        @Expose
        private Object address;
        @SerializedName("AddressId")
        @Expose
        private Integer addressId;
        @SerializedName("AddressList")
        @Expose
        private Object addressList;
        @SerializedName("CompanyAdresses")
        @Expose
        private Object companyAdresses;
        @SerializedName("CompanyList")
        @Expose
        private Object companyList;
        @SerializedName("Country")
        @Expose
        private Object country;
        @SerializedName("CountryList")
        @Expose
        private Object countryList;
        @SerializedName("CountryPostCode")
        @Expose
        private CountryPostCode countryPostCode;
        @SerializedName("CountryPostCodeList")
        @Expose
        private Object countryPostCodeList;
        @SerializedName("CustomerId")
        @Expose
        private Object customerId;
        @SerializedName("IsConfirmed")
        @Expose
        private Boolean isConfirmed;
        @SerializedName("IsDelete")
        @Expose
        private Boolean isDelete;
        @SerializedName("NewEmail")
        @Expose
        private Object newEmail;
        @SerializedName("OldEmail")
        @Expose
        private Object oldEmail;
        @SerializedName("PersonAdresses")
        @Expose
        private Object personAdresses;
        @SerializedName("PersonList")
        @Expose
        private Object personList;
        @SerializedName("SupplierAdresses")
        @Expose
        private Object supplierAdresses;
        @SerializedName("SupplierList")
        @Expose
        private Object supplierList;
        @SerializedName("TelephoneCountryPrefix")
        @Expose
        private Object telephoneCountryPrefix;
        @SerializedName("TotalRecords")
        @Expose
        private Integer totalRecords;

        public Object getAddress() {
            return address;
        }

        public void setAddress(Object address) {
            this.address = address;
        }

        public Integer getAddressId() {
            return addressId;
        }

        public void setAddressId(Integer addressId) {
            this.addressId = addressId;
        }

        public Object getAddressList() {
            return addressList;
        }

        public void setAddressList(Object addressList) {
            this.addressList = addressList;
        }

        public Object getCompanyAdresses() {
            return companyAdresses;
        }

        public void setCompanyAdresses(Object companyAdresses) {
            this.companyAdresses = companyAdresses;
        }

        public Object getCompanyList() {
            return companyList;
        }

        public void setCompanyList(Object companyList) {
            this.companyList = companyList;
        }

        public Object getCountry() {
            return country;
        }

        public void setCountry(Object country) {
            this.country = country;
        }

        public Object getCountryList() {
            return countryList;
        }

        public void setCountryList(Object countryList) {
            this.countryList = countryList;
        }

        public CountryPostCode getCountryPostCode() {
            return countryPostCode;
        }

        public void setCountryPostCode(CountryPostCode countryPostCode) {
            this.countryPostCode = countryPostCode;
        }

        public Object getCountryPostCodeList() {
            return countryPostCodeList;
        }

        public void setCountryPostCodeList(Object countryPostCodeList) {
            this.countryPostCodeList = countryPostCodeList;
        }

        public Object getCustomerId() {
            return customerId;
        }

        public void setCustomerId(Object customerId) {
            this.customerId = customerId;
        }

        public Boolean getIsConfirmed() {
            return isConfirmed;
        }

        public void setIsConfirmed(Boolean isConfirmed) {
            this.isConfirmed = isConfirmed;
        }

        public Boolean getIsDelete() {
            return isDelete;
        }

        public void setIsDelete(Boolean isDelete) {
            this.isDelete = isDelete;
        }

        public Object getNewEmail() {
            return newEmail;
        }

        public void setNewEmail(Object newEmail) {
            this.newEmail = newEmail;
        }

        public Object getOldEmail() {
            return oldEmail;
        }

        public void setOldEmail(Object oldEmail) {
            this.oldEmail = oldEmail;
        }

        public Object getPersonAdresses() {
            return personAdresses;
        }

        public void setPersonAdresses(Object personAdresses) {
            this.personAdresses = personAdresses;
        }

        public Object getPersonList() {
            return personList;
        }

        public void setPersonList(Object personList) {
            this.personList = personList;
        }

        public Object getSupplierAdresses() {
            return supplierAdresses;
        }

        public void setSupplierAdresses(Object supplierAdresses) {
            this.supplierAdresses = supplierAdresses;
        }

        public Object getSupplierList() {
            return supplierList;
        }

        public void setSupplierList(Object supplierList) {
            this.supplierList = supplierList;
        }

        public Object getTelephoneCountryPrefix() {
            return telephoneCountryPrefix;
        }

        public void setTelephoneCountryPrefix(Object telephoneCountryPrefix) {
            this.telephoneCountryPrefix = telephoneCountryPrefix;
        }

        public Integer getTotalRecords() {
            return totalRecords;
        }

        public void setTotalRecords(Integer totalRecords) {
            this.totalRecords = totalRecords;
        }

    }
}

