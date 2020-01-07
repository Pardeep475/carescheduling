package css.mobile.carescheduling.Ui.Dashboard.beans;
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
public class ClientDocumentList{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @NonNull
    private int id;
  @SerializedName("DocumentTitle")
  @Expose
  private String DocumentTitle;
  @SerializedName("Date")
  @Expose
  private String Date;
  public void setDocumentTitle(String DocumentTitle){
   this.DocumentTitle=DocumentTitle;
  }
  public String getDocumentTitle(){
   return DocumentTitle;
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