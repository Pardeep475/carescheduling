package com.example.carescheduling.data.Local.DatabaseTable;

import com.example.carescheduling.Ui.Profile.bean.PersonAddressList;
import com.example.carescheduling.Ui.Profile.bean.PersonEmailList;
import com.example.carescheduling.Ui.Profile.bean.PersonPhoneList;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class AddressAllData {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @NonNull
    private int id;

    @SerializedName("BranchId")
    @Expose
    private String branchId;
    @SerializedName("CustomerId")
    @Expose
    private String customerId;
    @SerializedName("PersonAddressList")
    @Expose
    private ArrayList<PersonAddressList> personAddressList = null;
    @SerializedName("PersonEmailList")
    @Expose
    private ArrayList<PersonEmailList> personEmailList = null;
    @SerializedName("PersonId")
    @Expose
    private String personId;
    @SerializedName("PersonPhoneList")
    @Expose
    private ArrayList<PersonPhoneList> personPhoneList = null;

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public ArrayList<PersonAddressList> getPersonAddressList() {
        return personAddressList;
    }

    public void setPersonAddressList(ArrayList<PersonAddressList> personAddressList) {
        this.personAddressList = personAddressList;
    }

    public ArrayList<PersonEmailList> getPersonEmailList() {
        return personEmailList;
    }

    public void setPersonEmailList(ArrayList<PersonEmailList> personEmailList) {
        this.personEmailList = personEmailList;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public ArrayList<PersonPhoneList> getPersonPhoneList() {
        return personPhoneList;
    }

    public void setPersonPhoneList(ArrayList<PersonPhoneList> personPhoneList) {
        this.personPhoneList = personPhoneList;
    }

}
