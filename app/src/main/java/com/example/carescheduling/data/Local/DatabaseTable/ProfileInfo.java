package com.example.carescheduling.data.Local.DatabaseTable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ProfileInfo")
public class ProfileInfo {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "firstName")
    private String firstName;
    @ColumnInfo(name = "middleName")
    private String middleName;
    @ColumnInfo(name = "surName")
    private String surName;
    @ColumnInfo(name = "maidenName")
    private String maidenName;
    @ColumnInfo(name = "dateOfBirth")
    private String  dateOfBirth;
    @ColumnInfo(name = "gender")
    private String gender;
    @ColumnInfo(name = "prefix")
    private String prefix;
    @ColumnInfo(name = "language")
    private String language;
    @ColumnInfo(name = "maritalStatus")
    private String maritalStatus;
    @ColumnInfo(name = "ethnicity")
    private String ethnicity;
    @ColumnInfo(name = "religion")
    private String religion;
    @ColumnInfo(name = "sexuality")
    private String sexuality;
    @ColumnInfo(name = "nationality")
    private String nationality;
    @ColumnInfo(name = "disabaility")
    private String disabaility;
    @ColumnInfo(name = "disability")
    private boolean disability;


    public String getDisabaility() {
        return disabaility;
    }

    public void setDisabaility(String disabaility) {
        this.disabaility = disabaility;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getMaidenName() {
        return maidenName;
    }

    public void setMaidenName(String maidenName) {
        this.maidenName = maidenName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getSexuality() {
        return sexuality;
    }

    public void setSexuality(String sexuality) {
        this.sexuality = sexuality;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean isDisability() {
        return disability;
    }

    public void setDisability(boolean disability) {
        this.disability = disability;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
