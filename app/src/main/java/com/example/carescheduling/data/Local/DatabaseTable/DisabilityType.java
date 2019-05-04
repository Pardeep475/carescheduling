package com.example.carescheduling.data.Local.DatabaseTable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "DisabilityType")
public class DisabilityType {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "disability_id")
    @NonNull
    private int disabilityID;
    @ColumnInfo(name = "disability_name")
    @NonNull
    private String disabilityName;

    public int getDisabilityID() {
        return disabilityID;
    }

    public void setDisabilityID(int disabilityID) {
        this.disabilityID = disabilityID;
    }

    @NonNull
    public String getDisabilityName() {
        return disabilityName;
    }

    public void setDisabilityName(@NonNull String disabilityName) {
        this.disabilityName = disabilityName;
    }
}
