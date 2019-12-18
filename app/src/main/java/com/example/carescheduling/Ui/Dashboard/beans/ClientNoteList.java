package com.example.carescheduling.Ui.Dashboard.beans;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Awesome Pojo Generator
 * */
@Entity
public class ClientNoteList{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @NonNull
    private int id;
  @SerializedName("WrittenBy")
  @Expose
  private String WrittenBy;
  @SerializedName("Title")
  @Expose
  private String Title;
  @SerializedName("FullNote")
  @Expose
  private String FullNote;
  @SerializedName("Date")
  @Expose
  private String Date;
  public void setWrittenBy(String WrittenBy){
   this.WrittenBy=WrittenBy;
  }
  public String getWrittenBy(){
   return WrittenBy;
  }
  public void setTitle(String Title){
   this.Title=Title;
  }
  public String getTitle(){
   return Title;
  }
  public void setFullNote(String FullNote){
   this.FullNote=FullNote;
  }
  public String getFullNote(){
   return FullNote;
  }
  public void setDate(String Date){
   this.Date=Date;
  }
  public String getDate(){
   return Date;
  }
    private String BookingId;

    public String getBookingId() {
        return BookingId;
    }

    public void setBookingId(String bookingId) {
        BookingId = bookingId;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}