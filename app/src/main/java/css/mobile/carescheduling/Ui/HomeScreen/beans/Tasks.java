package css.mobile.carescheduling.Ui.HomeScreen.beans;

import java.io.Serializable;

public class Tasks implements Serializable {
    private String instruction, taskId, taskName, visitShiftName, visitTiming, note;
    private boolean isCompleted;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
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

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
