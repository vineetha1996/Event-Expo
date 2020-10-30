package com.example.event_expo;

public class EventDetails {

    private String event_name, date, time, category, desc;

    public EventDetails() {
    }

    public EventDetails(String event_name, String date, String time, String category, String desc) {
        this.event_name = event_name;
        this.date = date;
        this.time = time;
        this.category = category;
        this.desc = desc;

    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
