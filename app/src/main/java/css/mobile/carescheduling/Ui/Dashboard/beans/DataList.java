package css.mobile.carescheduling.Ui.Dashboard.beans;
import css.mobile.carescheduling.Ui.Common.ClientBarcodeList;
import css.mobile.carescheduling.Ui.Common.ClientNFCList;
import css.mobile.carescheduling.Ui.HomeScreen.beans.ScheduleClients;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
/**
 * Awesome Pojo Generator
 * */
public class DataList{
  @SerializedName("BookingDate")
  @Expose
  private String BookingDate;
  @SerializedName("ClientDisabilityList")
  @Expose
  private List<ClientDisabilityList> ClientDisabilityList;
  @SerializedName("ClientBookingId")
  @Expose
  private String ClientBookingId;
  @SerializedName("ClientDocumentList")
  @Expose
  private List<ClientDocumentList> ClientDocumentList;
  @SerializedName("ClientPersonId")
  @Expose
  private String ClientPersonId;
  @SerializedName("PersonAddress")
  @Expose
  private String PersonAddress;
  @SerializedName("ClientImage")
  @Expose
  private String ClientImage;
  @SerializedName("BookingEndTime")
  @Expose
  private String BookingEndTime;
  @SerializedName("ScheduleClients")
  @Expose
  private List<ScheduleClients> ScheduleClients;
  @SerializedName("ClientSummary")
  @Expose
  private ClientSummary ClientSummary;
  @SerializedName("PersonDetail")
  @Expose
  private PersonDetail PersonDetail;
  @SerializedName("ClientContactList")
  @Expose
  private List<ClientContactList> ClientContactList;
  @SerializedName("EmailAddress")
  @Expose
  private String EmailAddress;
  @SerializedName("ClientTaskList")
  @Expose
  private List<ClientTaskList> ClientTaskList;
  @SerializedName("ClientName")
  @Expose
  private String ClientName;
  @SerializedName("Weekdayname")
  @Expose
  private String Weekdayname;
  @SerializedName("BookingStartTime")
  @Expose
  private String BookingStartTime;
  @SerializedName("ClientNoteList")
  @Expose
  private List<ClientNoteList> ClientNoteList;
  @SerializedName("ClientPhoneNumber")
  @Expose
  private String ClientPhoneNumber;
  @SerializedName("ClientBarcodeList")
  @Expose
  private List<css.mobile.carescheduling.Ui.Common.ClientBarcodeList> ClientBarcodeList;
  @SerializedName("ClientMedicalForMobileList")
  @Expose
  private List<ClientMedicalForMobileList> ClientMedicalForMobileList;
  @SerializedName("ClientNFCList")
  @Expose
  private List<css.mobile.carescheduling.Ui.Common.ClientNFCList> ClientNFCList;
  public void setBookingDate(String BookingDate){
   this.BookingDate=BookingDate;
  }
  public String getBookingDate(){
   return BookingDate;
  }
  public void setClientDisabilityList(List<ClientDisabilityList> ClientDisabilityList){
   this.ClientDisabilityList=ClientDisabilityList;
  }
  public List<ClientDisabilityList> getClientDisabilityList(){
   return ClientDisabilityList;
  }
  public void setClientBookingId(String ClientBookingId){
   this.ClientBookingId=ClientBookingId;
  }
  public String getClientBookingId(){
   return ClientBookingId;
  }
  public void setClientDocumentList(List<ClientDocumentList> ClientDocumentList){
   this.ClientDocumentList=ClientDocumentList;
  }
  public List<ClientDocumentList> getClientDocumentList(){
   return ClientDocumentList;
  }
  public void setClientPersonId(String ClientPersonId){
   this.ClientPersonId=ClientPersonId;
  }
  public String getClientPersonId(){
   return ClientPersonId;
  }
  public void setPersonAddress(String PersonAddress){
   this.PersonAddress=PersonAddress;
  }
  public String getPersonAddress(){
   return PersonAddress;
  }
  public void setClientImage(String ClientImage){
   this.ClientImage=ClientImage;
  }
  public String getClientImage(){
   return ClientImage;
  }
  public void setBookingEndTime(String BookingEndTime){
   this.BookingEndTime=BookingEndTime;
  }
  public String getBookingEndTime(){
   return BookingEndTime;
  }
  public void setScheduleClients(List<ScheduleClients> ScheduleClients){
   this.ScheduleClients=ScheduleClients;
  }
  public List<ScheduleClients> getScheduleClients(){
   return ScheduleClients;
  }
  public void setClientSummary(ClientSummary ClientSummary){
   this.ClientSummary=ClientSummary;
  }
  public ClientSummary getClientSummary(){
   return ClientSummary;
  }
  public void setPersonDetail(PersonDetail PersonDetail){
   this.PersonDetail=PersonDetail;
  }
  public PersonDetail getPersonDetail(){
   return PersonDetail;
  }
  public void setClientContactList(List<ClientContactList> ClientContactList){
   this.ClientContactList=ClientContactList;
  }
  public List<ClientContactList> getClientContactList(){
   return ClientContactList;
  }
  public void setEmailAddress(String EmailAddress){
   this.EmailAddress=EmailAddress;
  }
  public String getEmailAddress(){
   return EmailAddress;
  }
  public void setClientTaskList(List<ClientTaskList> ClientTaskList){
   this.ClientTaskList=ClientTaskList;
  }
  public List<ClientTaskList> getClientTaskList(){
   return ClientTaskList;
  }
  public void setClientName(String ClientName){
   this.ClientName=ClientName;
  }
  public String getClientName(){
   return ClientName;
  }
  public void setWeekdayname(String Weekdayname){
   this.Weekdayname=Weekdayname;
  }
  public String getWeekdayname(){
   return Weekdayname;
  }
  public void setBookingStartTime(String BookingStartTime){
   this.BookingStartTime=BookingStartTime;
  }
  public String getBookingStartTime(){
   return BookingStartTime;
  }
  public void setClientNoteList(List<ClientNoteList> ClientNoteList){
   this.ClientNoteList=ClientNoteList;
  }
  public List<ClientNoteList> getClientNoteList(){
   return ClientNoteList;
  }
  public void setClientPhoneNumber(String ClientPhoneNumber){
   this.ClientPhoneNumber=ClientPhoneNumber;
  }
  public String getClientPhoneNumber(){
   return ClientPhoneNumber;
  }
  public void setClientBarcodeList(List<ClientBarcodeList> ClientBarcodeList){
   this.ClientBarcodeList=ClientBarcodeList;
  }
  public List<ClientBarcodeList> getClientBarcodeList(){
   return ClientBarcodeList;
  }
  public void setClientMedicalForMobileList(List<ClientMedicalForMobileList> ClientMedicalForMobileList){
   this.ClientMedicalForMobileList=ClientMedicalForMobileList;
  }
  public List<ClientMedicalForMobileList> getClientMedicalForMobileList(){
   return ClientMedicalForMobileList;
  }
  public void setClientNFCList(List<ClientNFCList> ClientNFCList){
   this.ClientNFCList=ClientNFCList;
  }
  public List<ClientNFCList> getClientNFCList(){
   return ClientNFCList;
  }
}