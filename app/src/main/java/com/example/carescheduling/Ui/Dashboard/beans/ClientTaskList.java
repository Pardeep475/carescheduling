package com.example.carescheduling.Ui.Dashboard.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Awesome Pojo Generator
 */
@Entity
public class ClientTaskList {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @NonNull
    private int id;
    @SerializedName("TaskId")
    @Expose
    private String TaskId;
    @SerializedName("VisitTiming")
    @Expose
    private String VisitTiming;
    @SerializedName("TaskName")
    @Expose
    private String TaskName;
    @SerializedName("Instructions")
    @Expose
    private String Instructions;
    @SerializedName("VisitShiftName")
    @Expose
    private String VisitShiftName;
    private String BookingId;

    public String getBookingId() {
        return BookingId;
    }

    public void setBookingId(String bookingId) {
        BookingId = bookingId;
    }
    public void setTaskId(String TaskId) {
        this.TaskId = TaskId;
    }

    public String getTaskId() {
        return TaskId;
    }

    public void setVisitTiming(String VisitTiming) {
        this.VisitTiming = VisitTiming;
    }

    public String getVisitTiming() {
        return VisitTiming;
    }

    public void setTaskName(String TaskName) {
        this.TaskName = TaskName;
    }

    public String getTaskName() {
        return TaskName;
    }

    public void setInstructions(String Instructions) {
        this.Instructions = Instructions;
    }

    public String getInstructions() {
        return Instructions;
    }

    public void setVisitShiftName(String VisitShiftName) {
        this.VisitShiftName = VisitShiftName;
    }

    public String getVisitShiftName() {
        return VisitShiftName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}