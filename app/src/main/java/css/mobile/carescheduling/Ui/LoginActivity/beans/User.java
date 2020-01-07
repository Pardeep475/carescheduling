package css.mobile.carescheduling.Ui.LoginActivity.beans;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("")
    private String personId;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }
}
