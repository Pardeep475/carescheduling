package css.mobile.carescheduling.Ui.HomeScreen.beans;

import css.mobile.carescheduling.Ui.Dashboard.beans.ClientSummary;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientCareSummaryBean {

    @SerializedName("Data")
    @Expose
    private ClientSummary data;
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

    public ClientSummary getData() {
        return data;
    }

    public void setData(ClientSummary data) {
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
}