package css.mobile.carescheduling.Ui.Profile.bean;

public class AddAddressBeanRetro {
    private String AddressTypeName,CustomerId,PersonId;
    private int AddressId;
    private boolean IsDefaultAddress;


    public String getAddressTypeName() {
        return AddressTypeName;
    }

    public void setAddressTypeName(String addressTypeName) {
        AddressTypeName = addressTypeName;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }

    public String getPersonId() {
        return PersonId;
    }

    public void setPersonId(String personId) {
        PersonId = personId;
    }

    public int getAddressId() {
        return AddressId;
    }

    public void setAddressId(int addressId) {
        AddressId = addressId;
    }

    public boolean isDefaultAddress() {
        return IsDefaultAddress;
    }

    public void setDefaultAddress(boolean defaultAddress) {
        IsDefaultAddress = defaultAddress;
    }
}
