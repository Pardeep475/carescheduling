package com.example.carescheduling.data.Local.DatabaseTable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Nationality")
public class Nationality {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "nationality_id")
    @NonNull
    private int nationalityID;
    @ColumnInfo(name = "nationality_name")
    @NonNull
    private String nationalityName;

    @NonNull
    public int getNationalityID() {
        return nationalityID;
    }

    public void setNationalityID(@NonNull int nationalityID) {
        this.nationalityID = nationalityID;
    }

    @NonNull
    public String getNationalityName() {
        return nationalityName;
    }

    public void setNationalityName(@NonNull String nationalityName) {
        this.nationalityName = nationalityName;
    }
}
