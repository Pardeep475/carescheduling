package css.mobile.carescheduling.Ui.HomeScreen.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EmployeeClientVisitForDepartureRetro {

    @SerializedName("VisitDepartureRegisteredBy")
    @Expose
    private String visitDepartureRegisteredBy;
    @SerializedName("CustomerId")
    @Expose
    private String customerId;
    @SerializedName("DepartureRegistrationTypeName")
    @Expose
    private String departureRegistrationTypeName;
    @SerializedName("VisitRegisteredDeparture")
    @Expose
    private String visitRegisteredDeparture;
    @SerializedName("ClientVisitId")
    @Expose
    private String clientVisitId;
    @SerializedName("ClientVisitTaskList")
    @Expose
    private List<ClientVisitTaskList> clientVisitTaskList = null;
    @SerializedName("VisitNoteText")
    @Expose
    private String VisitNoteText;

    @SerializedName("clientBookingId")
    @Expose
    private String clientBookingId;

    public String getClientBookingId() {
        return clientBookingId;
    }

    public void setClientBookingId(String clientBookingId) {
        this.clientBookingId = clientBookingId;
    }

    public String getVisitNoteText() {
        return VisitNoteText;
    }

    public void setVisitNoteText(String visitNoteText) {
        VisitNoteText = visitNoteText;
    }

    public String getVisitDepartureRegisteredBy() {
        return visitDepartureRegisteredBy;
    }

    public void setVisitDepartureRegisteredBy(String visitDepartureRegisteredBy) {
        this.visitDepartureRegisteredBy = visitDepartureRegisteredBy;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getDepartureRegistrationTypeName() {
        return departureRegistrationTypeName;
    }

    public void setDepartureRegistrationTypeName(String departureRegistrationTypeName) {
        this.departureRegistrationTypeName = departureRegistrationTypeName;
    }

    public String getVisitRegisteredDeparture() {
        return visitRegisteredDeparture;
    }

    public void setVisitRegisteredDeparture(String visitRegisteredDeparture) {
        this.visitRegisteredDeparture = visitRegisteredDeparture;
    }

    public String getClientVisitId() {
        return clientVisitId;
    }

    public void setClientVisitId(String clientVisitId) {
        this.clientVisitId = clientVisitId;
    }

    public List<ClientVisitTaskList> getClientVisitTaskList() {
        return clientVisitTaskList;
    }

    public void setClientVisitTaskList(List<ClientVisitTaskList> clientVisitTaskList) {
        this.clientVisitTaskList = clientVisitTaskList;
    }

}

