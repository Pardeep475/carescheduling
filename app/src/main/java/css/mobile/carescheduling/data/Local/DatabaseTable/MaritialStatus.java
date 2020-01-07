package css.mobile.carescheduling.data.Local.DatabaseTable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "maritial_status")
public class MaritialStatus {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "maritial_status_id")
    @NonNull
    private int maritialStatusID;
    @ColumnInfo(name = "maritial_status_name")
    @NonNull
    private String maritialStatusName;

    public int getMaritialStatusID() {
        return maritialStatusID;
    }

    public void setMaritialStatusID(int maritialStatusID) {
        this.maritialStatusID = maritialStatusID;
    }

    @NonNull
    public String getMaritialStatusName() {
        return maritialStatusName;
    }

    public void setMaritialStatusName(@NonNull String maritialStatusName) {
        this.maritialStatusName = maritialStatusName;
    }
}
