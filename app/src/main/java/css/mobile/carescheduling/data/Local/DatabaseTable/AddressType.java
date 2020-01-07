package css.mobile.carescheduling.data.Local.DatabaseTable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "AddressType")
public class AddressType {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "address_id")
    @NonNull
    private int addressID;
    @ColumnInfo(name = "address_name")
    @NonNull
    private String addressName;

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    @NonNull
    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(@NonNull String addressName) {
        this.addressName = addressName;
    }
}
