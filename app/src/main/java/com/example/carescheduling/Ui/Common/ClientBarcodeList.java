package com.example.carescheduling.Ui.Common;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class ClientBarcodeList{
  @SerializedName("IsDefault")
  @Expose
  private Boolean IsDefault;
  @SerializedName("BarcodeUpdated")
  @Expose
  private String BarcodeUpdated;
  @SerializedName("ClientPersonId")
  @Expose
  private String ClientPersonId;
  @SerializedName("BarcodeInfoString")
  @Expose
  private String BarcodeInfoString;
  @SerializedName("BarcodeId")
  @Expose
  private String BarcodeId;
  @SerializedName("BarcodeAdded")
  @Expose
  private String BarcodeAdded;
  public void setIsDefault(Boolean IsDefault){
   this.IsDefault=IsDefault;
  }
  public Boolean getIsDefault(){
   return IsDefault;
  }
  public void setBarcodeUpdated(String BarcodeUpdated){
   this.BarcodeUpdated=BarcodeUpdated;
  }
  public String getBarcodeUpdated(){
   return BarcodeUpdated;
  }
  public void setClientPersonId(String ClientPersonId){
   this.ClientPersonId=ClientPersonId;
  }
  public String getClientPersonId(){
   return ClientPersonId;
  }
  public void setBarcodeInfoString(String BarcodeInfoString){
   this.BarcodeInfoString=BarcodeInfoString;
  }
  public String getBarcodeInfoString(){
   return BarcodeInfoString;
  }
  public void setBarcodeId(String BarcodeId){
   this.BarcodeId=BarcodeId;
  }
  public String getBarcodeId(){
   return BarcodeId;
  }
  public void setBarcodeAdded(String BarcodeAdded){
   this.BarcodeAdded=BarcodeAdded;
  }
  public String getBarcodeAdded(){
   return BarcodeAdded;
  }
}