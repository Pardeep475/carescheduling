package com.example.carescheduling.Ui.Profile.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class ImageDataBean {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "address_id")
    @NonNull
    private int addressID;
    @SerializedName("CustomerId")
    @Expose
    private String customerId;
    @SerializedName("ImageHexString")
    @Expose
    private String imageHexString;
    @SerializedName("ImageId")
    @Expose
    private String imageId;
    @SerializedName("IsDefault")
    @Expose
    private Boolean isDefault;
    @SerializedName("PersonId")
    @Expose
    private String personId;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getImageHexString() {
        return imageHexString;
    }

    public void setImageHexString(String imageHexString) {
        this.imageHexString = imageHexString;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }
}
