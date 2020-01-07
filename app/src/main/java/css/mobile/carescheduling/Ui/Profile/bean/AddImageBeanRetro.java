package css.mobile.carescheduling.Ui.Profile.bean;

public class AddImageBeanRetro {

    private String PersonId,ImageHexString,CustomerId;
    private boolean IsDefault;

    public String getPersonId() {
        return PersonId;
    }

    public void setPersonId(String personId) {
        PersonId = personId;
    }

    public String getImageHexString() {
        return ImageHexString;
    }

    public void setImageHexString(String imageHexString) {
        ImageHexString = imageHexString;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }

    public boolean isDefault() {
        return IsDefault;
    }

    public void setDefault(boolean aDefault) {
        IsDefault = aDefault;
    }
}
