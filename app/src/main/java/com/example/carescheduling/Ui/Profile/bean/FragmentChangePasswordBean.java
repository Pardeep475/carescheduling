package com.example.carescheduling.Ui.Profile.bean;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//@Entity(tableName = "FragmentChangePasswordBean")
public class FragmentChangePasswordBean {
//    @PrimaryKey(autoGenerate = true)
//    @ColumnInfo(name = "id")
//    @NonNull
//    private int id;
    private String userName, passwordQuestion, passwordAns;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswordQuestion() {
        return passwordQuestion;
    }

    public void setPasswordQuestion(String passwordQuestion) {
        this.passwordQuestion = passwordQuestion;
    }

    public String getPasswordAns() {
        return passwordAns;
    }

    public void setPasswordAns(String passwordAns) {
        this.passwordAns = passwordAns;
    }
}
