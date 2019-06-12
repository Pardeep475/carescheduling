package com.example.carescheduling.Ui.HomeScreen.beans;

import android.graphics.Bitmap;

import java.io.Serializable;
import java.util.ArrayList;

public class ClientBookingScreenModel implements Serializable {
    private String name, date, time, address, telephone;
    private Bitmap image;
    private ArrayList<Tasks> tasksArrayList;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public ArrayList<Tasks> getTasksArrayList() {
        return tasksArrayList;
    }

    public void setTasksArrayList(ArrayList<Tasks> tasksArrayList) {
        this.tasksArrayList = tasksArrayList;
    }
}
