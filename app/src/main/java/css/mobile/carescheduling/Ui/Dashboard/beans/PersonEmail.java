package css.mobile.carescheduling.Ui.Dashboard.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PersonEmail implements Serializable {

    @SerializedName("CustomerId")
    @Expose
    private String customerId;
    @SerializedName("EmailAddress")
    @Expose
    private String emailAddress;
    @SerializedName("EmailTypeName")
    @Expose
    private String emailTypeName;
    @SerializedName("IsDefaultEmail")
    @Expose
    private Boolean isDefaultEmail;
    @SerializedName("PersonId")
    @Expose
    private String personId;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailTypeName() {
        return emailTypeName;
    }

    public void setEmailTypeName(String emailTypeName) {
        this.emailTypeName = emailTypeName;
    }

    public Boolean getIsDefaultEmail() {
        return isDefaultEmail;
    }

    public void setIsDefaultEmail(Boolean isDefaultEmail) {
        this.isDefaultEmail = isDefaultEmail;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

}