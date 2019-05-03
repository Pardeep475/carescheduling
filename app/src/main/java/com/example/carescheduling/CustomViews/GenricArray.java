package com.example.carescheduling.CustomViews;

public class GenricArray<T> {
    protected T value;

    public void setValue (T value) {
        this.value = value;
    }

    public T getValue () {
        return value;
    }
}
