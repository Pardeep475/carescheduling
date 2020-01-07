package css.mobile.carescheduling.Ui.Dashboard.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PersonDynamicProperty implements Serializable {

    @SerializedName("CustomerId")
    @Expose
    private String customerId;
    @SerializedName("DynamicPropertyName")
    @Expose
    private String dynamicPropertyName;
    @SerializedName("PersonDynamicPropertyValue")
    @Expose
    private String personDynamicPropertyValue;
    @SerializedName("PersonId")
    @Expose
    private String personId;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getDynamicPropertyName() {
        return dynamicPropertyName;
    }

    public void setDynamicPropertyName(String dynamicPropertyName) {
        this.dynamicPropertyName = dynamicPropertyName;
    }

    public String getPersonDynamicPropertyValue() {
        return personDynamicPropertyValue;
    }

    public void setPersonDynamicPropertyValue(String personDynamicPropertyValue) {
        this.personDynamicPropertyValue = personDynamicPropertyValue;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

}