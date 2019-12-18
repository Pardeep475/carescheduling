package com.example.carescheduling.Ui.Dashboard.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Awesome Pojo Generator
 */
@Entity
public class ClientContactList {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @NonNull
    private int id;
    @SerializedName("PersonName")
    @Expose
    private String PersonName;
    @SerializedName("PersonAddress")
    @Expose
    private String PersonAddress;
    @SerializedName("PersonId")
    @Expose
    private String PersonId;
    @SerializedName("PersonPhone")
    @Expose
    private String PersonPhone;
    @SerializedName("ContactTypeName")
    @Expose
    private String ContactTypeName;
    @SerializedName("EmailAddress")
    @Expose
    private String EmailAddress;
    private String BookingId;

    public String getBookingId() {
        return BookingId;
    }

    public void setBookingId(String bookingId) {
        BookingId = bookingId;
    }

    public void setPersonName(String PersonName) {
        this.PersonName = PersonName;
    }

    public String getPersonName() {
        return PersonName;
    }

    public void setPersonAddress(String PersonAddress) {
        this.PersonAddress = PersonAddress;
    }

    public String getPersonAddress() {
        return PersonAddress;
    }

    public void setPersonId(String PersonId) {
        this.PersonId = PersonId;
    }

    public String getPersonId() {
        return PersonId;
    }

    public void setPersonPhone(String PersonPhone) {
        this.PersonPhone = PersonPhone;
    }

    public String getPersonPhone() {
        return PersonPhone;
    }

    public void setContactTypeName(String ContactTypeName) {
        this.ContactTypeName = ContactTypeName;
    }

    public String getContactTypeName() {
        return ContactTypeName;
    }

    public void setEmailAddress(String EmailAddress) {
        this.EmailAddress = EmailAddress;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}