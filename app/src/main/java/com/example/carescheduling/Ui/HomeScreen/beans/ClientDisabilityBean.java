package com.example.carescheduling.Ui.HomeScreen.beans;

import java.util.ArrayList;
import java.util.List;

import com.example.carescheduling.Ui.Dashboard.beans.ClientDisabilityList;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientDisabilityBean {

    @SerializedName("Data")
    @Expose
    private Object data;
    @SerializedName("DataList")
    @Expose
    private ArrayList<ClientDisabilityList> dataList = null;
    @SerializedName("Exception")
    @Expose
    private Object exception;
    @SerializedName("ResponseMessage")
    @Expose
    private Object responseMessage;
    @SerializedName("Success")
    @Expose
    private Boolean success;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ArrayList<ClientDisabilityList> getDataList() {
        return dataList;
    }

    public void setDataList(ArrayList<ClientDisabilityList> dataList) {
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

}