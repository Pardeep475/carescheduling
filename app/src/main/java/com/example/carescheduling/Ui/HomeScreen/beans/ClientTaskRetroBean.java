package com.example.carescheduling.Ui.HomeScreen.beans;


import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientTaskRetroBean {

    @SerializedName("Data")
    @Expose
    private Object data;
    @SerializedName("DataList")
    @Expose
    private ArrayList<DataList> dataList = null;
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

    public ArrayList<DataList> getDataList() {
        return dataList;
    }

    public void setDataList(ArrayList<DataList> dataList) {
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

        @SerializedName("Instructions")
        @Expose
        private String instructions;
        @SerializedName("TaskId")
        @Expose
        private String taskId;
        @SerializedName("TaskName")
        @Expose
        private String taskName;
        @SerializedName("VisitShiftName")
        @Expose
        private String visitShiftName;
        @SerializedName("VisitTiming")
        @Expose
        private String visitTiming;

        public String getInstructions() {
            return instructions;
        }

        public void setInstructions(String instructions) {
            this.instructions = instructions;
        }

        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }

        public String getTaskName() {
            return taskName;
        }

        public void setTaskName(String taskName) {
            this.taskName = taskName;
        }

        public String getVisitShiftName() {
            return visitShiftName;
        }

        public void setVisitShiftName(String visitShiftName) {
            this.visitShiftName = visitShiftName;
        }

        public String getVisitTiming() {
            return visitTiming;
        }

        public void setVisitTiming(String visitTiming) {
            this.visitTiming = visitTiming;
        }

    }
}
