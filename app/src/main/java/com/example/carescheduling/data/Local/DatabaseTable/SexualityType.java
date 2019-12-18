package com.example.carescheduling.data.Local.DatabaseTable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "SexualityType")
public class SexualityType {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "sexuality_id")
    @NonNull
    private int sexualityID;
    @ColumnInfo(name = "sexuality_name")
    @NonNull
    private String sexualityName;

    public int getSexualityID() {
        return sexualityID;
    }

    public void setSexualityID(int sexualityID) {
        this.sexualityID = sexualityID;
    }

    @NonNull
    public String getSexualityName() {
        return sexualityName;
    }

    public void setSexualityName(@NonNull String sexualityName) {
        this.sexualityName = sexualityName;
    }
}
