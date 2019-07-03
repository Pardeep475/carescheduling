package com.example.carescheduling.Ui.Common;

import com.example.carescheduling.R;

public class CommonBean {
    private boolean isRightImageVisible = false;
    private boolean isLeftImageVisible = false;
    private int rightImageDrawable = R.drawable.ic_logout;
    private int leftImageDrawable = R.drawable.ic_left_back;
    private boolean isRightTextVisible = false;
    private String title = "Home";

    public boolean isRightImageVisible() {
        return isRightImageVisible;
    }

    public void setRightImageVisible(boolean rightImageVisible) {
        isRightImageVisible = rightImageVisible;
    }

    public boolean isLeftImageVisible() {
        return isLeftImageVisible;
    }

    public void setLeftImageVisible(boolean leftImageVisible) {
        isLeftImageVisible = leftImageVisible;
    }

    public int getRightImageDrawable() {
        return rightImageDrawable;
    }

    public void setRightImageDrawable(int rightImageDrawable) {
        this.rightImageDrawable = rightImageDrawable;
    }

    public int getLeftImageDrawable() {
        return leftImageDrawable;
    }

    public void setLeftImageDrawable(int leftImageDrawable) {
        this.leftImageDrawable = leftImageDrawable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isRightTextVisible() {
        return isRightTextVisible;
    }

    public void setRightTextVisible(boolean rightTextVisible) {
        isRightTextVisible = rightTextVisible;
    }
}
