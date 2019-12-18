package com.example.carescheduling.Ui.Dashboard.beans;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Awesome Pojo Generator
 * */
@Entity
public class ClientMedicalForMobileList{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @NonNull
    private int id;
    @SerializedName("Date")
    @Expose
    private String date;
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("DoctorName")
    @Expose
    private String doctorName;
    @SerializedName("MedicalName")
    @Expose
    private String medicalName;
    @SerializedName("MedicationQuantity")
    @Expose
    private String medicationQuantity;
    private String BookingId;

    public String getBookingId() {
        return BookingId;
    }

    public void setBookingId(String bookingId) {
        BookingId = bookingId;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getMedicalName() {
        return medicalName;
    }

    public void setMedicalName(String medicalName) {
        this.medicalName = medicalName;
    }

    public String getMedicationQuantity() {
        return medicationQuantity;
    }

    public void setMedicationQuantity(String medicationQuantity) {
        this.medicationQuantity = medicationQuantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}