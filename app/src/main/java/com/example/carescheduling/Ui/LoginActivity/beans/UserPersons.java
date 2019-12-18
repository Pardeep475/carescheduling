package com.example.carescheduling.Ui.LoginActivity.beans;

import com.google.gson.annotations.SerializedName;

public class UserPersons {
    @SerializedName("User")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
