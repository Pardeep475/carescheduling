package com.example.carescheduling.Ui.Profile.bean;
import java.util.ArrayList;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EditAddressAllData {

    @SerializedName("Data")
    @Expose
    private Data data;
    @SerializedName("DataList")
    @Expose
    private Object dataList;
    @SerializedName("Exception")
    @Expose
    private Object exception;
    @SerializedName("ResponseMessage")
    @Expose
    private Object responseMessage;
    @SerializedName("Success")
    @Expose
    private Boolean success;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Object getDataList() {
        return dataList;
    }

    public void setDataList(Object dataList) {
        this.dataList = dataList;
    }

    public Object getException() {
        return exception;
    }

    public void setException(Object exception) {
        this.exception = exception;
    }

    public Object getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(Object responseMessage) {
        this.responseMessage = responseMessage;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public class Data {

        @SerializedName("BranchId")
        @Expose
        private String branchId;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("PersonAddressList")
        @Expose
        private ArrayList<PersonAddressList> personAddressList = null;
        @SerializedName("PersonEmailList")
        @Expose
        private ArrayList<PersonEmailList> personEmailList = null;
        @SerializedName("PersonId")
        @Expose
        private String personId;
        @SerializedName("PersonPhoneList")
        @Expose
        private ArrayList<PersonPhoneList> personPhoneList = null;

        public String getBranchId() {
            return branchId;
        }

        public void setBranchId(String branchId) {
            this.branchId = branchId;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public ArrayList<PersonAddressList> getPersonAddressList() {
            return personAddressList;
        }

        public void setPersonAddressList(ArrayList<PersonAddressList> personAddressList) {
            this.personAddressList = personAddressList;
        }

        public ArrayList<PersonEmailList> getPersonEmailList() {
            return personEmailList;
        }

        public void setPersonEmailList(ArrayList<PersonEmailList> personEmailList) {
            this.personEmailList = personEmailList;
        }

        public String getPersonId() {
            return personId;
        }

        public void setPersonId(String personId) {
            this.personId = personId;
        }

        public ArrayList<PersonPhoneList> getPersonPhoneList() {
            return personPhoneList;
        }

        public void setPersonPhoneList(ArrayList<PersonPhoneList> personPhoneList) {
            this.personPhoneList = personPhoneList;
        }

    }

}
