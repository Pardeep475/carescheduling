package com.example.carescheduling.Ui.Dashboard.beans;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Awesome Pojo Generator
 * */
@Entity
public class PersonDetail{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @NonNull
    private int id;
  @SerializedName("DateOfBirth")
  @Expose
  private String DateOfBirth;
  @SerializedName("FirstName")
  @Expose
  private String FirstName;
  @SerializedName("Religion")
  @Expose
  private String Religion;
  @SerializedName("MiddleName")
  @Expose
  private String MiddleName;
  @SerializedName("Nationality")
  @Expose
  private String Nationality;
  @SerializedName("PrefixTypeName")
  @Expose
  private String PrefixTypeName;
  @SerializedName("Disability")
  @Expose
  private String Disability;
  @SerializedName("Ethnicity")
  @Expose
  private String Ethnicity;
  @SerializedName("IsDisability")
  @Expose
  private Boolean IsDisability;
  @SerializedName("Sexuality")
  @Expose
  private String Sexuality;
  @SerializedName("LanguageName")
  @Expose
  private String LanguageName;
  @SerializedName("GenderTypeName")
  @Expose
  private String GenderTypeName;
  @SerializedName("Surname")
  @Expose
  private String Surname;
  @SerializedName("MaidenName")
  @Expose
  private String MaidenName;
  @SerializedName("MaritialStatus")
  @Expose
  private String MaritialStatus;
    private String BookingId;

    public String getBookingId() {
        return BookingId;
    }

    public void setBookingId(String bookingId) {
        BookingId = bookingId;
    }
  public void setDateOfBirth(String DateOfBirth){
   this.DateOfBirth=DateOfBirth;
  }
  public String getDateOfBirth(){
   return DateOfBirth;
  }
  public void setFirstName(String FirstName){
   this.FirstName=FirstName;
  }
  public String getFirstName(){
   return FirstName;
  }
  public void setReligion(String Religion){
   this.Religion=Religion;
  }
  public String getReligion(){
   return Religion;
  }
  public void setMiddleName(String MiddleName){
   this.MiddleName=MiddleName;
  }
  public String getMiddleName(){
   return MiddleName;
  }
  public void setNationality(String Nationality){
   this.Nationality=Nationality;
  }
  public String getNationality(){
   return Nationality;
  }
  public void setPrefixTypeName(String PrefixTypeName){
   this.PrefixTypeName=PrefixTypeName;
  }
  public String getPrefixTypeName(){
   return PrefixTypeName;
  }
  public void setDisability(String Disability){
   this.Disability=Disability;
  }
  public String getDisability(){
   return Disability;
  }
  public void setEthnicity(String Ethnicity){
   this.Ethnicity=Ethnicity;
  }
  public String getEthnicity(){
   return Ethnicity;
  }
  public void setIsDisability(Boolean IsDisability){
   this.IsDisability=IsDisability;
  }
  public Boolean getIsDisability(){
   return IsDisability;
  }
  public void setSexuality(String Sexuality){
   this.Sexuality=Sexuality;
  }
  public String getSexuality(){
   return Sexuality;
  }
  public void setLanguageName(String LanguageName){
   this.LanguageName=LanguageName;
  }
  public String getLanguageName(){
   return LanguageName;
  }
  public void setGenderTypeName(String GenderTypeName){
   this.GenderTypeName=GenderTypeName;
  }
  public String getGenderTypeName(){
   return GenderTypeName;
  }
  public void setSurname(String Surname){
   this.Surname=Surname;
  }
  public String getSurname(){
   return Surname;
  }
  public void setMaidenName(String MaidenName){
   this.MaidenName=MaidenName;
  }
  public String getMaidenName(){
   return MaidenName;
  }
  public void setMaritialStatus(String MaritialStatus){
   this.MaritialStatus=MaritialStatus;
  }
  public String getMaritialStatus(){
   return MaritialStatus;
  }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}