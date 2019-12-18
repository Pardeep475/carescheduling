package com.example.carescheduling.Ui.Profile.bean;

import java.util.List;

public class DataList
{
    private String BarcodeId;

    private String BranchId;

    private String CustomerId;

    private String HealthcareInstitudeId;

    private Image Image;

    private List<String> ImageFileTypes;

    private boolean IsDefault;

    private String PersonId;

    public void setBarcodeId(String BarcodeId){
        this.BarcodeId = BarcodeId;
    }
    public String getBarcodeId(){
        return this.BarcodeId;
    }
    public void setBranchId(String BranchId){
        this.BranchId = BranchId;
    }
    public String getBranchId(){
        return this.BranchId;
    }
    public void setCustomerId(String CustomerId){
        this.CustomerId = CustomerId;
    }
    public String getCustomerId(){
        return this.CustomerId;
    }
    public void setHealthcareInstitudeId(String HealthcareInstitudeId){
        this.HealthcareInstitudeId = HealthcareInstitudeId;
    }
    public String getHealthcareInstitudeId(){
        return this.HealthcareInstitudeId;
    }
    public void setImage(Image Image){
        this.Image = Image;
    }
    public Image getImage(){
        return this.Image;
    }
    public void setImageFileTypes(List<String> ImageFileTypes){
        this.ImageFileTypes = ImageFileTypes;
    }
    public List<String> getImageFileTypes(){
        return this.ImageFileTypes;
    }
    public void setIsDefault(boolean IsDefault){
        this.IsDefault = IsDefault;
    }
    public boolean getIsDefault(){
        return this.IsDefault;
    }
    public void setPersonId(String PersonId){
        this.PersonId = PersonId;
    }
    public String getPersonId(){
        return this.PersonId;
    }
}