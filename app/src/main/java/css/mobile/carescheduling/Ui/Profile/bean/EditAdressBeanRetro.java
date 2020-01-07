package css.mobile.carescheduling.Ui.Profile.bean;

public class EditAdressBeanRetro {

    private String PersonId, AddressTypeName, AddressId, CustomerId, OldAddressId, OldAddressTypeName;
    private boolean IsDefaultAddress;


    public String getPersonId() {
        return PersonId;
    }

    public void setPersonId(String personId) {
        PersonId = personId;
    }

    public String getAddressTypeName() {
        return AddressTypeName;
    }

    public void setAddressTypeName(String addressTypeName) {
        AddressTypeName = addressTypeName;
    }

    public String getAddressId() {
        return AddressId;
    }

    public void setAddressId(String addressId) {
        AddressId = addressId;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }

    public String getOldAddressId() {
        return OldAddressId;
    }

    public void setOldAddressId(String oldAddressId) {
        OldAddressId = oldAddressId;
    }

    public String getOldAddressTypeName() {
        return OldAddressTypeName;
    }

    public void setOldAddressTypeName(String oldAddressTypeName) {
        OldAddressTypeName = oldAddressTypeName;
    }

    public boolean isDefaultAddress() {
        return IsDefaultAddress;
    }

    public void setDefaultAddress(boolean defaultAddress) {
        IsDefaultAddress = defaultAddress;
    }
}
