package com.example.carescheduling.data.Local.DatabaseTable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "person_language")
public class PersonLanguage {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "language_id")
    @NonNull
    private int languageID;
    @ColumnInfo(name = "language_name")
    @NonNull
    private String languageName;

    public int getLanguageID() {
        return languageID;
    }

    public void setLanguageID(int languageID) {
        this.languageID = languageID;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }
}
