package css.mobile.carescheduling.Ui.HomeScreen.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ScheduleClientList {

    @SerializedName("ClientId")
    @Expose
    private String clientId;
    @SerializedName("ClientName")
    @Expose
    private String clientName;
    @SerializedName("CustomEndHour")
    @Expose
    private String customEndHour;
    @SerializedName("CustomEndMinute")
    @Expose
    private String customEndMinute;
    @SerializedName("CustomStartHour")
    @Expose
    private String customStartHour;
    @SerializedName("CustomStartMinute")
    @Expose
    private String customStartMinute;
    @SerializedName("CustomerId")
    @Expose
    private String customerId;
    @SerializedName("IsOverRidingTimeTableStartTime")
    @Expose
    private Boolean isOverRidingTimeTableStartTime;
    @SerializedName("ScheduleEndDate")
    @Expose
    private String scheduleEndDate;
    @SerializedName("ScheduleEnteredDate")
    @Expose
    private String scheduleEnteredDate;
    @SerializedName("ScheduleStartDate")
    @Expose
    private String scheduleStartDate;
    @SerializedName("ScheduledBy")
    @Expose
    private String scheduledBy;
    @SerializedName("ScheduledDurationMinutes")
    @Expose
    private Integer scheduledDurationMinutes;
    @SerializedName("TimeTableName")
    @Expose
    private String timeTableName;
    @SerializedName("WeekRotationTypeName")
    @Expose
    private String weekRotationTypeName;
    @SerializedName("WeekdayName")
    @Expose
    private String weekdayName;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getCustomEndHour() {
        return customEndHour;
    }

    public void setCustomEndHour(String customEndHour) {
        this.customEndHour = customEndHour;
    }

    public String getCustomEndMinute() {
        return customEndMinute;
    }

    public void setCustomEndMinute(String customEndMinute) {
        this.customEndMinute = customEndMinute;
    }

    public String getCustomStartHour() {
        return customStartHour;
    }

    public void setCustomStartHour(String customStartHour) {
        this.customStartHour = customStartHour;
    }

    public String getCustomStartMinute() {
        return customStartMinute;
    }

    public void setCustomStartMinute(String customStartMinute) {
        this.customStartMinute = customStartMinute;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Boolean getIsOverRidingTimeTableStartTime() {
        return isOverRidingTimeTableStartTime;
    }

    public void setIsOverRidingTimeTableStartTime(Boolean isOverRidingTimeTableStartTime) {
        this.isOverRidingTimeTableStartTime = isOverRidingTimeTableStartTime;
    }

    public String getScheduleEndDate() {
        return scheduleEndDate;
    }

    public void setScheduleEndDate(String scheduleEndDate) {
        this.scheduleEndDate = scheduleEndDate;
    }

    public String getScheduleEnteredDate() {
        return scheduleEnteredDate;
    }

    public void setScheduleEnteredDate(String scheduleEnteredDate) {
        this.scheduleEnteredDate = scheduleEnteredDate;
    }

    public String getScheduleStartDate() {
        return scheduleStartDate;
    }

    public void setScheduleStartDate(String scheduleStartDate) {
        this.scheduleStartDate = scheduleStartDate;
    }

    public String getScheduledBy() {
        return scheduledBy;
    }

    public void setScheduledBy(String scheduledBy) {
        this.scheduledBy = scheduledBy;
    }

    public Integer getScheduledDurationMinutes() {
        return scheduledDurationMinutes;
    }

    public void setScheduledDurationMinutes(Integer scheduledDurationMinutes) {
        this.scheduledDurationMinutes = scheduledDurationMinutes;
    }

    public String getTimeTableName() {
        return timeTableName;
    }

    public void setTimeTableName(String timeTableName) {
        this.timeTableName = timeTableName;
    }

    public String getWeekRotationTypeName() {
        return weekRotationTypeName;
    }

    public void setWeekRotationTypeName(String weekRotationTypeName) {
        this.weekRotationTypeName = weekRotationTypeName;
    }

    public String getWeekdayName() {
        return weekdayName;
    }

    public void setWeekdayName(String weekdayName) {
        this.weekdayName = weekdayName;
    }

}
