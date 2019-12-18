package com.example.carescheduling.data.Local.DatabaseTable;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "gender")
public class Gender {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "gender_id")
    @NonNull
    private int genderID;
    @ColumnInfo(name = "gender_name")
    @NonNull
    private String genderName;

    public int getGenderID() {
        return genderID;
    }

    public void setGenderID(int genderID) {
        this.genderID = genderID;
    }

    @NonNull
    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(@NonNull String genderName) {
        this.genderName = genderName;
    }
}
