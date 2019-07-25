package com.example.carescheduling.Ui.Profile.bean;

public class AddEmailBeanRetro {
    private String PersonId,EmailTypeName,EmailAddress,CustomerId;
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

    public boolean isDefaultEmail() {
        return IsDefaultEmail;
    }

    public void setDefaultEmail(boolean defaultEmail) {
        IsDefaultEmail = defaultEmail;
    }
}
