package com.example.carescheduling.data.Local.DatabaseTable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "user_info")
public class UserInfo {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_info_id")
    private int id;
    @ColumnInfo(name = "user_name")
    private String userName;
    @ColumnInfo(name = "password_question")
    private String  passwordQuestion;
    @ColumnInfo(name = "password_ans")
    private String passwordAns;

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