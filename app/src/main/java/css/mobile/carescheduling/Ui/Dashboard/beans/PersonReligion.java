package css.mobile.carescheduling.Ui.Dashboard.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PersonReligion implements Serializable {

    @SerializedName("CustomerId")
    @Expose
    private String customerId;
    @SerializedName("PersonId")
    @Expose
    private String personId;
    @SerializedName("ReligionTypeName")
    @Expose
    private String religionTypeName;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getReligionTypeName() {
        return religionTypeName;
    }

    public void setReligionTypeName(String religionTypeName) {
        this.religionTypeName = religionTypeName;
    }

}

