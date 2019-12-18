package com.example.carescheduling.Ui.Dashboard.beans;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
/**
 * Awesome Pojo Generator
 * */
public class AllHomeData{
  @SerializedName("DataList")
  @Expose
  private List<DataList> DataList;
  @SerializedName("Data")
  @Expose
  private String Data;
  @SerializedName("ResponseMessage")
  @Expose
  private String ResponseMessage;
  @SerializedName("Exception")
  @Expose
  private String Exception;
  @SerializedName("Success")
  @Expose
  private Boolean Success;
  public void setDataList(List<DataList> DataList){
   this.DataList=DataList;
  }
  public List<DataList> getDataList(){
   return DataList;
  }
  public void setData(String Data){
   this.Data=Data;
  }
  public String getData(){
   return Data;
  }
  public void setResponseMessage(String ResponseMessage){
   this.ResponseMessage=ResponseMessage;
  }
  public String getResponseMessage(){
   return ResponseMessage;
  }
  public void setException(String Exception){
   this.Exception=Exception;
  }
  public String getException(){
   return Exception;
  }
  public void setSuccess(Boolean Success){
   this.Success=Success;
  }
  public Boolean getSuccess(){
   return Success;
  }
}