package css.mobile.carescheduling.Ui.Dashboard.beans;

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
public class ClientDisabilityList {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @NonNull
    private int id;

    @SerializedName("DisabilitesName")
    @Expose
    private String DisabilitesName;
    @SerializedName("Description")
    @Expose
    private String Description;
    @SerializedName("Date")
    @Expose
    private String Date;
    private String BookingId;

    public String getBookingId() {
        return BookingId;
    }

    public void setBookingId(String bookingId) {
        BookingId = bookingId;
    }
    public void setDisabilitesName(String DisabilitesName) {
        this.DisabilitesName = DisabilitesName;
    }

    public String getDisabilitesName() {
        return DisabilitesName;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getDescription() {
        return Description;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getDate() {
        return Date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}