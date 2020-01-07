package css.mobile.carescheduling.data.Local.DatabaseTable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "PhoneType")
public class PhoneType {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "prefix_id")
    @NonNull
    private int phoneID;
    @ColumnInfo(name = "prefix_name")
    @NonNull
    private String phoneName;

    public int getPhoneID() {
        return phoneID;
    }

    public void setPhoneID(int phoneID) {
        this.phoneID = phoneID;
    }

    @NonNull
    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(@NonNull String phoneName) {
        this.phoneName = phoneName;
    }
}
