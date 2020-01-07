package css.mobile.carescheduling.Ui.Profile.bean;

public class EditProfileInfoBeanRetro {
    private String PersonId, BranchId, CustomerId, FirstName, MiddleName, SurName, MaidenName, GenderTypeName, DateOfBirth, PrefixTypeName,
            LanguageName, MaritialStatusName, EthnicityTypeName, DisabilityTypeName, ReligionTypeName, SexualityTypeName, Nationality;
    private boolean isDisability;

    public EditProfileInfoBeanRetro(String personId, String branchId, String customerId, String firstName, String middleName,
                                    String surName, String maidenName, String genderTypeName, String dateOfBirth,
                                    String prefixTypeName, String languageName, String maritialStatusName,
                                    String ethnicityTypeName, String disabilityTypeName, String religionTypeName,
                                    String sexualityTypeName, String nationality, boolean isDisability) {
        PersonId = personId;
        BranchId = branchId;
        CustomerId = customerId;
        FirstName = firstName;
        MiddleName = middleName;
        SurName = surName;
        MaidenName = maidenName;
        GenderTypeName = genderTypeName;
        DateOfBirth = dateOfBirth;
        PrefixTypeName = prefixTypeName;
        LanguageName = languageName;
        MaritialStatusName = maritialStatusName;
        EthnicityTypeName = ethnicityTypeName;
        DisabilityTypeName = disabilityTypeName;
        ReligionTypeName = religionTypeName;
        SexualityTypeName = sexualityTypeName;
        Nationality = nationality;
        this.isDisability = isDisability;
    }


    public String getPersonId() {
        return PersonId;
    }

    public void setPersonId(String personId) {
        PersonId = personId;
    }

    public String getBranchId() {
        return BranchId;
    }

    public void setBranchId(String branchId) {
        BranchId = branchId;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public String getSurName() {
        return SurName;
    }

    public void setSurName(String surName) {
        SurName = surName;
    }

    public String getMaidenName() {
        return MaidenName;
    }

    public void setMaidenName(String maidenName) {
        MaidenName = maidenName;
    }

    public String getGenderTypeName() {
        return GenderTypeName;
    }

    public void setGenderTypeName(String genderTypeName) {
        GenderTypeName = genderTypeName;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getPrefixTypeName() {
        return PrefixTypeName;
    }

    public void setPrefixTypeName(String prefixTypeName) {
        PrefixTypeName = prefixTypeName;
    }

    public String getLanguageName() {
        return LanguageName;
    }

    public void setLanguageName(String languageName) {
        LanguageName = languageName;
    }

    public String getMaritialStatusName() {
        return MaritialStatusName;
    }

    public void setMaritialStatusName(String maritialStatusName) {
        MaritialStatusName = maritialStatusName;
    }

    public String getEthnicityTypeName() {
        return EthnicityTypeName;
    }

    public void setEthnicityTypeName(String ethnicityTypeName) {
        EthnicityTypeName = ethnicityTypeName;
    }

    public String getDisabilityTypeName() {
        return DisabilityTypeName;
    }

    public void setDisabilityTypeName(String disabilityTypeName) {
        DisabilityTypeName = disabilityTypeName;
    }

    public String getReligionTypeName() {
        return ReligionTypeName;
    }

    public void setReligionTypeName(String religionTypeName) {
        ReligionTypeName = religionTypeName;
    }

    public String getSexualityTypeName() {
        return SexualityTypeName;
    }

    public void setSexualityTypeName(String sexualityTypeName) {
        SexualityTypeName = sexualityTypeName;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
    }

    public boolean isDisability() {
        return isDisability;
    }

    public void setDisability(boolean disability) {
        isDisability = disability;
    }
}
