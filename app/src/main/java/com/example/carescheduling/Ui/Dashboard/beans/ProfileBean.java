package com.example.carescheduling.Ui.Dashboard.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ProfileBean implements Serializable {

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


    public class Address implements Serializable {

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

    public class Data implements Serializable {

        @SerializedName("BirthDate")
        @Expose
        private String birthDate;
        @SerializedName("BranchClient")
        @Expose
        private Object branchClient;
        @SerializedName("BranchEmployee")
        @Expose
        private Object branchEmployee;
        @SerializedName("BranchId")
        @Expose
        private String branchId;
        @SerializedName("BranchPerson")
        @Expose
        private Object branchPerson;
        @SerializedName("BranchUser")
        @Expose
        private Object branchUser;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("ImageSize")
        @Expose
        private Object imageSize;
        @SerializedName("IsConfirmed")
        @Expose
        private Boolean isConfirmed;
        @SerializedName("IsDelete")
        @Expose
        private Boolean isDelete;
        @SerializedName("Person")
        @Expose
        public Person person;
        @SerializedName("PersonAddresses")
        @Expose
        private List<PersonAddress_> personAddresses = null;
        @SerializedName("PersonBlacklistedDate")
        @Expose
        private Object personBlacklistedDate;
        @SerializedName("PersonContacts")
        @Expose
        private Object personContacts;
        @SerializedName("PersonImage")
        @Expose
        private List<PersonImage> personImage;

        public String getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(String birthDate) {
            this.birthDate = birthDate;
        }

        public Object getBranchClient() {
            return branchClient;
        }

        public void setBranchClient(Object branchClient) {
            this.branchClient = branchClient;
        }

        public Object getBranchEmployee() {
            return branchEmployee;
        }

        public void setBranchEmployee(Object branchEmployee) {
            this.branchEmployee = branchEmployee;
        }

        public String getBranchId() {
            return branchId;
        }

        public void setBranchId(String branchId) {
            this.branchId = branchId;
        }

        public Object getBranchPerson() {
            return branchPerson;
        }

        public void setBranchPerson(Object branchPerson) {
            this.branchPerson = branchPerson;
        }

        public Object getBranchUser() {
            return branchUser;
        }

        public void setBranchUser(Object branchUser) {
            this.branchUser = branchUser;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public Object getImageSize() {
            return imageSize;
        }

        public void setImageSize(Object imageSize) {
            this.imageSize = imageSize;
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

        public Person getPerson() {
            return person;
        }

        public void setPerson(Person person) {
            this.person = person;
        }

        public List<PersonAddress_> getPersonAddresses() {
            return personAddresses;
        }

        public void setPersonAddresses(List<PersonAddress_> personAddresses) {
            this.personAddresses = personAddresses;
        }

        public Object getPersonBlacklistedDate() {
            return personBlacklistedDate;
        }

        public void setPersonBlacklistedDate(Object personBlacklistedDate) {
            this.personBlacklistedDate = personBlacklistedDate;
        }

        public Object getPersonContacts() {
            return personContacts;
        }

        public void setPersonContacts(Object personContacts) {
            this.personContacts = personContacts;
        }

        public List<PersonImage> getPersonImage() {
            return personImage;
        }

        public void setPersonImage(List<PersonImage> personImage) {
            this.personImage = personImage;
        }

    }

    public class PersonImage implements Serializable {
        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("ImageAddedDate")
        @Expose
        private String ImageAddedDate;
        @SerializedName("ImageAltText")
        @Expose
        private String ImageAltText;
        @SerializedName("ImageFile")
        @Expose
        private String ImageFile;
        @SerializedName("ImageFileName")
        @Expose
        private String ImageFileName;
        @SerializedName("ImageFileTypeName")
        @Expose
        private String ImageFileTypeName;
        @SerializedName("ImageFileUrl")
        @Expose
        private String ImageFileUrl;
        @SerializedName("ImageHexString")
        @Expose
        private String ImageHexString;
        @SerializedName("ImageId")
        @Expose
        private String ImageId;
        @SerializedName("ImageLongAltText")
        @Expose
        private String ImageLongAltText;
        @SerializedName("ImageSizeName")
        @Expose
        private String ImageSizeName;
        @SerializedName("ImageSizes")
        @Expose
        private String ImageSizes;
        @SerializedName("ImageUpdatedDate")
        @Expose
        private String ImageUpdatedDate;
        @SerializedName("IsDefault")
        @Expose
        private boolean IsDefault;
        @SerializedName("MaxColourDepth")
        @Expose
        private int MaxColourDepth;
        @SerializedName("XPixel")
        @Expose
        private int XPixel;
        @SerializedName("YPixel")
        @Expose
        private int YPixel;
        @SerializedName("Orientation")
        @Expose
        private String Orientation;


        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getImageAddedDate() {
            return ImageAddedDate;
        }

        public void setImageAddedDate(String imageAddedDate) {
            ImageAddedDate = imageAddedDate;
        }

        public String getImageAltText() {
            return ImageAltText;
        }

        public void setImageAltText(String imageAltText) {
            ImageAltText = imageAltText;
        }

        public String getImageFile() {
            return ImageFile;
        }

        public void setImageFile(String imageFile) {
            ImageFile = imageFile;
        }

        public String getImageFileName() {
            return ImageFileName;
        }

        public void setImageFileName(String imageFileName) {
            ImageFileName = imageFileName;
        }

        public String getImageFileTypeName() {
            return ImageFileTypeName;
        }

        public void setImageFileTypeName(String imageFileTypeName) {
            ImageFileTypeName = imageFileTypeName;
        }

        public String getImageFileUrl() {
            return ImageFileUrl;
        }

        public void setImageFileUrl(String imageFileUrl) {
            ImageFileUrl = imageFileUrl;
        }

        public String getImageHexString() {
            return ImageHexString;
        }

        public void setImageHexString(String imageHexString) {
            ImageHexString = imageHexString;
        }

        public String getImageId() {
            return ImageId;
        }

        public void setImageId(String imageId) {
            ImageId = imageId;
        }

        public String getImageLongAltText() {
            return ImageLongAltText;
        }

        public void setImageLongAltText(String imageLongAltText) {
            ImageLongAltText = imageLongAltText;
        }

        public String getImageSizeName() {
            return ImageSizeName;
        }

        public void setImageSizeName(String imageSizeName) {
            ImageSizeName = imageSizeName;
        }

        public String getImageSizes() {
            return ImageSizes;
        }

        public void setImageSizes(String imageSizes) {
            ImageSizes = imageSizes;
        }

        public String getImageUpdatedDate() {
            return ImageUpdatedDate;
        }

        public void setImageUpdatedDate(String imageUpdatedDate) {
            ImageUpdatedDate = imageUpdatedDate;
        }

        public boolean isDefault() {
            return IsDefault;
        }

        public void setDefault(boolean aDefault) {
            IsDefault = aDefault;
        }

        public int getMaxColourDepth() {
            return MaxColourDepth;
        }

        public void setMaxColourDepth(int maxColourDepth) {
            MaxColourDepth = maxColourDepth;
        }

        public int getXPixel() {
            return XPixel;
        }

        public void setXPixel(int XPixel) {
            this.XPixel = XPixel;
        }

        public int getYPixel() {
            return YPixel;
        }

        public void setYPixel(int YPixel) {
            this.YPixel = YPixel;
        }

        public String getOrientation() {
            return Orientation;
        }

        public void setOrientation(String orientation) {
            Orientation = orientation;
        }
    }



    public class PersonImage_ implements Serializable{
        @SerializedName("ImageId")
        @Expose
        private String ImageId;
        @SerializedName("PersonId")
        @Expose
        private String PersonId;
        @SerializedName("IsDefault")
        @Expose
        private boolean IsDefault;

        public String getImageId() {
            return ImageId;
        }

        public void setImageId(String imageId) {
            ImageId = imageId;
        }

        public String getPersonId() {
            return PersonId;
        }

        public void setPersonId(String personId) {
            PersonId = personId;
        }

        public boolean isDefault() {
            return IsDefault;
        }

        public void setDefault(boolean aDefault) {
            IsDefault = aDefault;
        }
    }

    public class PersonAddress implements Serializable {

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

    public class PersonDynamicProperty implements Serializable {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("DynamicPropertyName")
        @Expose
        private String dynamicPropertyName;
        @SerializedName("PersonDynamicPropertyValue")
        @Expose
        private String personDynamicPropertyValue;
        @SerializedName("PersonId")
        @Expose
        private String personId;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getDynamicPropertyName() {
            return dynamicPropertyName;
        }

        public void setDynamicPropertyName(String dynamicPropertyName) {
            this.dynamicPropertyName = dynamicPropertyName;
        }

        public String getPersonDynamicPropertyValue() {
            return personDynamicPropertyValue;
        }

        public void setPersonDynamicPropertyValue(String personDynamicPropertyValue) {
            this.personDynamicPropertyValue = personDynamicPropertyValue;
        }

        public String getPersonId() {
            return personId;
        }

        public void setPersonId(String personId) {
            this.personId = personId;
        }

    }

    public class PersonEmail implements Serializable {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("EmailAddress")
        @Expose
        private String emailAddress;
        @SerializedName("EmailTypeName")
        @Expose
        private String emailTypeName;
        @SerializedName("IsDefaultEmail")
        @Expose
        private Boolean isDefaultEmail;
        @SerializedName("PersonId")
        @Expose
        private String personId;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getEmailAddress() {
            return emailAddress;
        }

        public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
        }

        public String getEmailTypeName() {
            return emailTypeName;
        }

        public void setEmailTypeName(String emailTypeName) {
            this.emailTypeName = emailTypeName;
        }

        public Boolean getIsDefaultEmail() {
            return isDefaultEmail;
        }

        public void setIsDefaultEmail(Boolean isDefaultEmail) {
            this.isDefaultEmail = isDefaultEmail;
        }

        public String getPersonId() {
            return personId;
        }

        public void setPersonId(String personId) {
            this.personId = personId;
        }

    }

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

    public class PersonMaritalstatus implements Serializable {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("MaritalStatusName")
        @Expose
        private String maritalStatusName;
        @SerializedName("PersonId")
        @Expose
        private String personId;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getMaritalStatusName() {
            return maritalStatusName;
        }

        public void setMaritalStatusName(String maritalStatusName) {
            this.maritalStatusName = maritalStatusName;
        }

        public String getPersonId() {
            return personId;
        }

        public void setPersonId(String personId) {
            this.personId = personId;
        }

    }

    public class PersonNationality implements Serializable {

        @SerializedName("CountryName")
        @Expose
        private String countryName;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;
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

        public String getPersonId() {
            return personId;
        }

        public void setPersonId(String personId) {
            this.personId = personId;
        }

    }

    public class PersonReligion implements Serializable {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("PersonId")
        @Expose
        private String personId;
        @SerializedName("ReligionTypeName")
        @Expose
        private String religionTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getPersonId() {
            return personId;
        }

        public void setPersonId(String personId) {
            this.personId = personId;
        }

        public String getReligionTypeName() {
            return religionTypeName;
        }

        public void setReligionTypeName(String religionTypeName) {
            this.religionTypeName = religionTypeName;
        }

    }

    public class PersonSexuality implements Serializable {

        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("PersonId")
        @Expose
        private String personId;
        @SerializedName("SexualityTypeName")
        @Expose
        private String sexualityTypeName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getPersonId() {
            return personId;
        }

        public void setPersonId(String personId) {
            this.personId = personId;
        }

        public String getSexualityTypeName() {
            return sexualityTypeName;
        }

        public void setSexualityTypeName(String sexualityTypeName) {
            this.sexualityTypeName = sexualityTypeName;
        }

    }
}