package com.example.carescheduling.Ui.HomeScreen.beans;

import java.util.List;

import com.example.carescheduling.Ui.Dashboard.beans.ClientNoteList;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientCareNoteBean {

    @SerializedName("Data")
    @Expose
    private Object data;
    @SerializedName("DataList")
    @Expose
    private List<ClientNoteList> dataList = null;
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

    public List<ClientNoteList> getDataList() {
        return dataList;
    }

    public void setDataList(List<ClientNoteList> dataList) {
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
    public class DataList {

        @SerializedName("Date")
        @Expose
        private String date;
        @SerializedName("FullNote")
        @Expose
        private String fullNote;
        @SerializedName("Title")
        @Expose
        private String title;
        @SerializedName("WrittenBy")
        @Expose
        private String writtenBy;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getFullNote() {
            return fullNote;
        }

        public void setFullNote(String fullNote) {
            this.fullNote = fullNote;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getWrittenBy() {
            return writtenBy;
        }

        public void setWrittenBy(String writtenBy) {
            this.writtenBy = writtenBy;
        }

    }
}
