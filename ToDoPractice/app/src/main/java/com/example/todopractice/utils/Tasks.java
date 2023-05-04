package com.example.todopractice.utils;

public class Tasks {

    private String Title;
    private String Priority;
    private String Description;

    public Tasks(String title, String priority, String description) {
        Title = title;
        Priority = priority;
        Description = description;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getPriority() {
        return Priority;
    }

    public void setPriority(String priority) {
        Priority = priority;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
