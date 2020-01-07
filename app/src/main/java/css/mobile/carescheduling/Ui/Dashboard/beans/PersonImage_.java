package css.mobile.carescheduling.Ui.Dashboard.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PersonImage_ implements Serializable {
    @SerializedName("ImageId")
    @Expose
    private String ImageId;
    @SerializedName("PersonId")
    @Expose
    private String PersonId;
    @SerializedName("IsDefault")
    @Expose
    private boolean IsDefault;

    public String getImageId() {
        return ImageId;
    }

    public void setImageId(String imageId) {
        ImageId = imageId;
    }

    public String getPersonId() {
        return PersonId;
    }

    public void setPersonId(String personId) {
        PersonId = personId;
    }

    public boolean isDefault() {
        return IsDefault;
    }

    public void setDefault(boolean aDefault) {
        IsDefault = aDefault;
    }
}