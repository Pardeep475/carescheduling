package css.mobile.carescheduling.Ui.HomeScreen.beans;
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
public class ScheduleClients{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @NonNull
    private int id;
  @SerializedName("CustomStartHour")
  @Expose
  private String CustomStartHour;
  @SerializedName("WeekdayName")
  @Expose
  private String WeekdayName;
  @SerializedName("ScheduledBy")
  @Expose
  private String ScheduledBy;
  @SerializedName("CustomEndMinute")
  @Expose
  private String CustomEndMinute;
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
  private String ScheduleEndDate;
  @SerializedName("WeekRotationTypeName")
  @Expose
  private String WeekRotationTypeName;
  @SerializedName("TimeTableName")
  @Expose
  private String TimeTableName;
  @SerializedName("ClientName")
  @Expose
  private String ClientName;
  @SerializedName("CustomStartMinute")
  @Expose
  private String CustomStartMinute;
  @SerializedName("ScheduledDurationMinutes")
  @Expose
  private String ScheduledDurationMinutes;
  @SerializedName("ClientId")
  @Expose
  private String ClientId;
  @SerializedName("ScheduleEnteredDate")
  @Expose
  private String ScheduleEnteredDate;
  @SerializedName("CustomEndHour")
  @Expose
  private String CustomEndHour;
    private String BookingId;

    public String getBookingId() {
        return BookingId;
    }

    public void setBookingId(String bookingId) {
        BookingId = bookingId;
    }

    public void setCustomStartHour(String CustomStartHour){
   this.CustomStartHour=CustomStartHour;
  }
  public String getCustomStartHour(){
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
  public void setCustomEndMinute(String CustomEndMinute){
   this.CustomEndMinute=CustomEndMinute;
  }
  public String getCustomEndMinute(){
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
  public void setScheduleEndDate(String ScheduleEndDate){
   this.ScheduleEndDate=ScheduleEndDate;
  }
  public String getScheduleEndDate(){
   return ScheduleEndDate;
  }
  public void setWeekRotationTypeName(String WeekRotationTypeName){
   this.WeekRotationTypeName=WeekRotationTypeName;
  }
  public String getWeekRotationTypeName(){
   return WeekRotationTypeName;
  }
  public void setTimeTableName(String TimeTableName){
   this.TimeTableName=TimeTableName;
  }
  public String getTimeTableName(){
   return TimeTableName;
  }
  public void setClientName(String ClientName){
   this.ClientName=ClientName;
  }
  public String getClientName(){
   return ClientName;
  }
  public void setCustomStartMinute(String CustomStartMinute){
   this.CustomStartMinute=CustomStartMinute;
  }
  public String getCustomStartMinute(){
   return CustomStartMinute;
  }
  public void setScheduledDurationMinutes(String ScheduledDurationMinutes){
   this.ScheduledDurationMinutes=ScheduledDurationMinutes;
  }
  public String getScheduledDurationMinutes(){
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
  public void setCustomEndHour(String CustomEndHour){
   this.CustomEndHour=CustomEndHour;
  }
  public String getCustomEndHour(){
   return CustomEndHour;
  }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}