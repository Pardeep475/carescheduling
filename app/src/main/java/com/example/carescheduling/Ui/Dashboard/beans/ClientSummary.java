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
public class ClientSummary{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @NonNull
    private int id;
  @SerializedName("ClientName")
  @Expose
  private String ClientName;
  @SerializedName("ClientImage")
  @Expose
  private String ClientImage;
  @SerializedName("ClientDescription")
  @Expose
  private String ClientDescription;
  @SerializedName("ClientId")
  @Expose
  private String ClientId;
  @SerializedName("ClientAddress")
  @Expose
  private String ClientAddress;
  public void setClientName(String ClientName){
   this.ClientName=ClientName;
  }
  public String getClientName(){
   return ClientName;
  }
  public void setClientImage(String ClientImage){
   this.ClientImage=ClientImage;
  }
  public String getClientImage(){
   return ClientImage;
  }
  public void setClientDescription(String ClientDescription){
   this.ClientDescription=ClientDescription;
  }
  public String getClientDescription(){
   return ClientDescription;
  }
  public void setClientId(String ClientId){
   this.ClientId=ClientId;
  }
  public String getClientId(){
   return ClientId;
  }
  public void setClientAddress(String ClientAddress){
   this.ClientAddress=ClientAddress;
  }
  public String getClientAddress(){
   return ClientAddress;
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