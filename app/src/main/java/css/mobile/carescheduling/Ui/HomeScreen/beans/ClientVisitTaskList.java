package css.mobile.carescheduling.Ui.HomeScreen.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientVisitTaskList {

    @SerializedName("NoteText")
    @Expose
    private String noteText;
    @SerializedName("NoteTypeName")
    @Expose
    private String noteTypeName;
    @SerializedName("TaskId")
    @Expose
    private String taskId;
    @SerializedName("TaskIsCompleted")
    @Expose
    private Boolean taskIsCompleted;

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

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Boolean getTaskIsCompleted() {
        return taskIsCompleted;
    }

    public void setTaskIsCompleted(Boolean taskIsCompleted) {
        this.taskIsCompleted = taskIsCompleted;
    }

}
