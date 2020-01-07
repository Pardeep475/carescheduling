package css.mobile.carescheduling.Ui.Common;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class ClientNFCList{
  @SerializedName("IsDefault")
  @Expose
  private Boolean IsDefault;
  @SerializedName("ClientPersonId")
  @Expose
  private String ClientPersonId;
  @SerializedName("NfcSerialNumber")
  @Expose
  private String NfcSerialNumber;
  @SerializedName("NfcUpdated")
  @Expose
  private String NfcUpdated;
  @SerializedName("NfcInfoString")
  @Expose
  private String NfcInfoString;
  @SerializedName("NfcAdded")
  @Expose
  private String NfcAdded;
  public void setIsDefault(Boolean IsDefault){
   this.IsDefault=IsDefault;
  }
  public Boolean getIsDefault(){
   return IsDefault;
  }
  public void setClientPersonId(String ClientPersonId){
   this.ClientPersonId=ClientPersonId;
  }
  public String getClientPersonId(){
   return ClientPersonId;
  }
  public void setNfcSerialNumber(String NfcSerialNumber){
   this.NfcSerialNumber=NfcSerialNumber;
  }
  public String getNfcSerialNumber(){
   return NfcSerialNumber;
  }
  public void setNfcUpdated(String NfcUpdated){
   this.NfcUpdated=NfcUpdated;
  }
  public String getNfcUpdated(){
   return NfcUpdated;
  }
  public void setNfcInfoString(String NfcInfoString){
   this.NfcInfoString=NfcInfoString;
  }
  public String getNfcInfoString(){
   return NfcInfoString;
  }
  public void setNfcAdded(String NfcAdded){
   this.NfcAdded=NfcAdded;
  }
  public String getNfcAdded(){
   return NfcAdded;
  }
}