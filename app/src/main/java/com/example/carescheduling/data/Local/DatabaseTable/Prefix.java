package com.example.carescheduling.data.Local.DatabaseTable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "prefix")
public class Prefix {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "prefix_id")
    @NonNull
    private int prefixID;
    @ColumnInfo(name = "prefix_name")
    @NonNull
    private String prefixName;

    public int getPrefixID() {
        return prefixID;
    }

    public void setPrefixID(int prefixID) {
        this.prefixID = prefixID;
    }

    @NonNull
    public String getPrefixName() {
        return prefixName;
    }

    public void setPrefixName(@NonNull String prefixName) {
        this.prefixName = prefixName;
    }
}
