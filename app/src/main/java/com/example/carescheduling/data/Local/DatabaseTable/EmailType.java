package com.example.carescheduling.data.Local.DatabaseTable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "EmailType")
public class EmailType {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "email_id")
    @NonNull
    private int emailID;
    @ColumnInfo(name = "email_name")
    @NonNull
    private String emailName;

    public int getEmailID() {
        return emailID;
    }

    public void setEmailID(int emailID) {
        this.emailID = emailID;
    }

    @NonNull
    public String getEmailName() {
        return emailName;
    }

    public void setEmailName(@NonNull String emailName) {
        this.emailName = emailName;
    }
}
