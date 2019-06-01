package com.example.carescheduling.Ui.HomeScreen.beans;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientCareNoteBean {

    @SerializedName("Data")
    @Expose
    private List<Datum> data = null;
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

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
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


    public class Datum {

        @SerializedName("Note")
        @Expose
        private Note note;
        @SerializedName("updateEmployeePersonId")
        @Expose
        private String updateEmployeePersonId;

        public Note getNote() {
            return note;
        }

        public void setNote(Note note) {
            this.note = note;
        }

        public String getUpdateEmployeePersonId() {
            return updateEmployeePersonId;
        }

        public void setUpdateEmployeePersonId(String updateEmployeePersonId) {
            this.updateEmployeePersonId = updateEmployeePersonId;
        }

    }

    public class Note {

        @SerializedName("AddedByPersonId")
        @Expose
        private String addedByPersonId;
        @SerializedName("CustomerId")
        @Expose
        private String customerId;
        @SerializedName("NoteAdded")
        @Expose
        private String noteAdded;
        @SerializedName("NoteCategoryName")
        @Expose
        private String noteCategoryName;
        @SerializedName("NoteId")
        @Expose
        private String noteId;
        @SerializedName("NoteSubject")
        @Expose
        private String noteSubject;
        @SerializedName("NoteText")
        @Expose
        private String noteText;
        @SerializedName("NoteTypeName")
        @Expose
        private String noteTypeName;
        @SerializedName("NoteUpdated")
        @Expose
        private String noteUpdated;
        @SerializedName("UpdatedByPersonId")
        @Expose
        private String updatedByPersonId;

        public String getAddedByPersonId() {
            return addedByPersonId;
        }

        public void setAddedByPersonId(String addedByPersonId) {
            this.addedByPersonId = addedByPersonId;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getNoteAdded() {
            return noteAdded;
        }

        public void setNoteAdded(String noteAdded) {
            this.noteAdded = noteAdded;
        }

        public String getNoteCategoryName() {
            return noteCategoryName;
        }

        public void setNoteCategoryName(String noteCategoryName) {
            this.noteCategoryName = noteCategoryName;
        }

        public String getNoteId() {
            return noteId;
        }

        public void setNoteId(String noteId) {
            this.noteId = noteId;
        }

        public String getNoteSubject() {
            return noteSubject;
        }

        public void setNoteSubject(String noteSubject) {
            this.noteSubject = noteSubject;
        }

        public String getNoteText() {
            return noteText;
        }

        public void setNoteText(String noteText) {
            this.noteText = noteText;
        }

        public String getNoteTypeName() {
            return noteTypeName;
        }

        public void setNoteTypeName(String noteTypeName) {
            this.noteTypeName = noteTypeName;
        }

        public String getNoteUpdated() {
            return noteUpdated;
        }

        public void setNoteUpdated(String noteUpdated) {
            this.noteUpdated = noteUpdated;
        }

        public String getUpdatedByPersonId() {
            return updatedByPersonId;
        }

        public void setUpdatedByPersonId(String updatedByPersonId) {
            this.updatedByPersonId = updatedByPersonId;
        }

    }
}
