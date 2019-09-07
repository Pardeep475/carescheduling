package com.example.carescheduling.Ui.Common;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class ScheduleClients{
  @SerializedName("CustomStartHour")
  @Expose
  private Integer CustomStartHour;
  @SerializedName("WeekdayName")
  @Expose
  private String WeekdayName;
  @SerializedName("ScheduledBy")
  @Expose
  private String ScheduledBy;
  @SerializedName("CustomEndMinute")
  @Expose
  private Integer CustomEndMinute;
  @SerializedName("IsOverRidingTimeTableStartTime")
  @Expose
  private Boolean IsOverRidingTimeTableStartTime;
  @SerializedName("ScheduleStartDate")
  @Expose
  private String ScheduleStartDate;
  @SerializedName("CustomerId")
  @Expose
  private String CustomerId;
  @SerializedName("ScheduleEndDate")
  @Expose
  private Object ScheduleEndDate;
  @SerializedName("WeekRotationTypeName")
  @Expose
  private Integer WeekRotationTypeName;
  @SerializedName("TimeTableName")
  @Expose
  private String TimeTableName;
  @SerializedName("ClientName")
  @Expose
  private Object ClientName;
  @SerializedName("CustomStartMinute")
  @Expose
  private Integer CustomStartMinute;
  @SerializedName("ScheduledDurationMinutes")
  @Expose
  private Integer ScheduledDurationMinutes;
  @SerializedName("ClientId")
  @Expose
  private String ClientId;
  @SerializedName("ScheduleEnteredDate")
  @Expose
  private String ScheduleEnteredDate;
  @SerializedName("CustomEndHour")
  @Expose
  private Integer CustomEndHour;
  public void setCustomStartHour(Integer CustomStartHour){
   this.CustomStartHour=CustomStartHour;
  }
  public Integer getCustomStartHour(){
   return CustomStartHour;
  }
  public void setWeekdayName(String WeekdayName){
   this.WeekdayName=WeekdayName;
  }
  public String getWeekdayName(){
   return WeekdayName;
  }
  public void setScheduledBy(String ScheduledBy){
   this.ScheduledBy=ScheduledBy;
  }
  public String getScheduledBy(){
   return ScheduledBy;
  }
  public void setCustomEndMinute(Integer CustomEndMinute){
   this.CustomEndMinute=CustomEndMinute;
  }
  public Integer getCustomEndMinute(){
   return CustomEndMinute;
  }
  public void setIsOverRidingTimeTableStartTime(Boolean IsOverRidingTimeTableStartTime){
   this.IsOverRidingTimeTableStartTime=IsOverRidingTimeTableStartTime;
  }
  public Boolean getIsOverRidingTimeTableStartTime(){
   return IsOverRidingTimeTableStartTime;
  }
  public void setScheduleStartDate(String ScheduleStartDate){
   this.ScheduleStartDate=ScheduleStartDate;
  }
  public String getScheduleStartDate(){
   return ScheduleStartDate;
  }
  public void setCustomerId(String CustomerId){
   this.CustomerId=CustomerId;
  }
  public String getCustomerId(){
   return CustomerId;
  }
  public void setScheduleEndDate(Object ScheduleEndDate){
   this.ScheduleEndDate=ScheduleEndDate;
  }
  public Object getScheduleEndDate(){
   return ScheduleEndDate;
  }
  public void setWeekRotationTypeName(Integer WeekRotationTypeName){
   this.WeekRotationTypeName=WeekRotationTypeName;
  }
  public Integer getWeekRotationTypeName(){
   return WeekRotationTypeName;
  }
  public void setTimeTableName(String TimeTableName){
   this.TimeTableName=TimeTableName;
  }
  public String getTimeTableName(){
   return TimeTableName;
  }
  public void setClientName(Object ClientName){
   this.ClientName=ClientName;
  }
  public Object getClientName(){
   return ClientName;
  }
  public void setCustomStartMinute(Integer CustomStartMinute){
   this.CustomStartMinute=CustomStartMinute;
  }
  public Integer getCustomStartMinute(){
   return CustomStartMinute;
  }
  public void setScheduledDurationMinutes(Integer ScheduledDurationMinutes){
   this.ScheduledDurationMinutes=ScheduledDurationMinutes;
  }
  public Integer getScheduledDurationMinutes(){
   return ScheduledDurationMinutes;
  }
  public void setClientId(String ClientId){
   this.ClientId=ClientId;
  }
  public String getClientId(){
   return ClientId;
  }
  public void setScheduleEnteredDate(String ScheduleEnteredDate){
   this.ScheduleEnteredDate=ScheduleEnteredDate;
  }
  public String getScheduleEnteredDate(){
   return ScheduleEnteredDate;
  }
  public void setCustomEndHour(Integer CustomEndHour){
   this.CustomEndHour=CustomEndHour;
  }
  public Integer getCustomEndHour(){
   return CustomEndHour;
  }
}