package css.mobile.carescheduling.data.Local.DatabaseTable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Ethnicity")
public class Ethnicity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ethnicity_id")
    @NonNull
    private int ethnicityID;
    @ColumnInfo(name = "ethnicity_name")
    @NonNull
    private String ethnicityName;

    public int getEthnicityID() {
        return ethnicityID;
    }

    public void setEthnicityID(int ethnicityID) {
        this.ethnicityID = ethnicityID;
    }

    @NonNull
    public String getEthnicityName() {
        return ethnicityName;
    }

    public void setEthnicityName(@NonNull String ethnicityName) {
        this.ethnicityName = ethnicityName;
    }
}