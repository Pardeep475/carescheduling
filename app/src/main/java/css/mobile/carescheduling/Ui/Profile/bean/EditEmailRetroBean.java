package css.mobile.carescheduling.Ui.Profile.bean;

public class EditEmailRetroBean {
    private String PersonId, EmailTypeName, EmailAddress, CustomerId, OldEmailTypeName;
    private boolean IsDefaultEmail;


    public String getPersonId() {
        return PersonId;
    }

    public void setPersonId(String personId) {
        PersonId = personId;
    }

    public String getEmailTypeName() {
        return EmailTypeName;
    }

    public void setEmailTypeName(String emailTypeName) {
        EmailTypeName = emailTypeName;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }

    public String getOldEmailTypeName() {
        return OldEmailTypeName;
    }

    public void setOldEmailTypeName(String oldEmailTypeName) {
        OldEmailTypeName = oldEmailTypeName;
    }

    public boolean isDefaultEmail() {
        return IsDefaultEmail;
    }

    public void setDefaultEmail(boolean defaultEmail) {
        IsDefaultEmail = defaultEmail;
    }
}
