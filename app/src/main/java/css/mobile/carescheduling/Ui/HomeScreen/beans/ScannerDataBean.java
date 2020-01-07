package css.mobile.carescheduling.Ui.HomeScreen.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ScannerDataBean implements Serializable {

    @SerializedName("BarcodeId")
    @Expose
    private String barcodeId;
    @SerializedName("ClientName")
    @Expose
    private String clientName;
    @SerializedName("ClientReferenceId")
    @Expose
    private String clientReferenceId;
    @SerializedName("ClientVisitId")
    @Expose
    private String clientVisitId;
    @SerializedName("RegistrationType")
    @Expose
    private String registrationType;
    @SerializedName("NfcSerialNumber")
    @Expose
    private String nfcSerialNumber;
    @SerializedName("RegisterredDateAndTime")
    @Expose
    private String registerredDateAndTime;
    @SerializedName("VisitArrivalDate")
    @Expose
    private String visitArrivalDate;
    @SerializedName("VisitArrivalTime")
    @Expose
    private String visitArrivalTime;
    @SerializedName("VisitDepartureDate")
    @Expose
    private String visitDepartureDate;
    @SerializedName("VisitDepartureTime")
    @Expose
    private String visitDepartureTime;
    @SerializedName("WeekdayName")
    @Expose
    private String weekdayName;


    public String getBarcodeId() {
        return barcodeId;
    }

    public void setBarcodeId(String barcodeId) {
        this.barcodeId = barcodeId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientReferenceId() {
        return clientReferenceId;
    }

    public void setClientReferenceId(String clientReferenceId) {
        this.clientReferenceId = clientReferenceId;
    }

    public String getClientVisitId() {
        return clientVisitId;
    }

    public void setClientVisitId(String clientVisitId) {
        this.clientVisitId = clientVisitId;
    }

    public String getRegistrationType() {
        return registrationType;
    }

    public void setRegistrationType(String registrationType) {
        this.registrationType = registrationType;
    }

    public String getNfcSerialNumber() {
        return nfcSerialNumber;
    }

    public void setNfcSerialNumber(String nfcSerialNumber) {
        this.nfcSerialNumber = nfcSerialNumber;
    }

    public String getRegisterredDateAndTime() {
        return registerredDateAndTime;
    }

    public void setRegisterredDateAndTime(String registerredDateAndTime) {
        this.registerredDateAndTime = registerredDateAndTime;
    }

    public String getVisitArrivalDate() {
        return visitArrivalDate;
    }

    public void setVisitArrivalDate(String visitArrivalDate) {
        this.visitArrivalDate = visitArrivalDate;
    }

    public String getVisitArrivalTime() {
        return visitArrivalTime;
    }

    public void setVisitArrivalTime(String visitArrivalTime) {
        this.visitArrivalTime = visitArrivalTime;
    }

    public String getVisitDepartureDate() {
        return visitDepartureDate;
    }

    public void setVisitDepartureDate(String visitDepartureDate) {
        this.visitDepartureDate = visitDepartureDate;
    }

    public String getVisitDepartureTime() {
        return visitDepartureTime;
    }

    public void setVisitDepartureTime(String visitDepartureTime) {
        this.visitDepartureTime = visitDepartureTime;
    }

    public String getWeekdayName() {
        return weekdayName;
    }

    public void setWeekdayName(String weekdayName) {
        this.weekdayName = weekdayName;
    }


}
