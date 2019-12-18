package com.example.carescheduling.data.Local.DatabaseTable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Religion")
public class Religion {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "religion_id")
    @NonNull
    private int religionID;
    @ColumnInfo(name = "religion_name")
    @NonNull
    private String religionName;

    public int getReligionID() {
        return religionID;
    }

    public void setReligionID(int religionID) {
        this.religionID = religionID;
    }

    @NonNull
    public String getReligionName() {
        return religionName;
    }

    public void setReligionName(@NonNull String religionName) {
        this.religionName = religionName;
    }
}
