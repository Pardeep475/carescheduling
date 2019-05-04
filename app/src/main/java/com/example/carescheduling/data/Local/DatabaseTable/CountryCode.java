package com.example.carescheduling.data.Local.DatabaseTable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "CountryCode")
public class CountryCode {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "country_id")
    @NonNull
    private int countryID;
    @ColumnInfo(name = "country_name")
    @NonNull
    private String countryName;

    public int getCountryID() {
        return countryID;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    @NonNull
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(@NonNull String countryName) {
        this.countryName = countryName;
    }
}
