package css.mobile.carescheduling.Ui.Profile.bean;

public class EditNumberBeanRetro {
    private String PersonId, PhoneTypeName, CountryTelephonePrefix, PhoneNumber, CustomerId, OldPhoneNumber;
    private boolean IsDefaultPhone,CanNotCall;

    public boolean isCanNotCall() {
        return CanNotCall;
    }

    public void setCanNotCall(boolean canNotCall) {
        CanNotCall = canNotCall;
    }

    public String getPersonId() {
        return PersonId;
    }

    public void setPersonId(String personId) {
        PersonId = personId;
    }

    public String getPhoneTypeName() {
        return PhoneTypeName;
    }

    public void setPhoneTypeName(String phoneTypeName) {
        PhoneTypeName = phoneTypeName;
    }

    public String getCountryTelephonePrefix() {
        return CountryTelephonePrefix;
    }

    public void setCountryTelephonePrefix(String countryTelephonePrefix) {
        CountryTelephonePrefix = countryTelephonePrefix;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }

    public String getOldPhoneNumber() {
        return OldPhoneNumber;
    }

    public void setOldPhoneNumber(String oldPhoneNumber) {
        OldPhoneNumber = oldPhoneNumber;
    }

    public boolean isDefaultPhone() {
        return IsDefaultPhone;
    }

    public void setDefaultPhone(boolean defaultPhone) {
        IsDefaultPhone = defaultPhone;
    }
}
