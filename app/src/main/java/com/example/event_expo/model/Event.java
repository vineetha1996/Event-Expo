package com.example.event_expo.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.Timestamp;

public class Event implements Parcelable {

    private String name;
    private Timestamp createdTime;
    private String date;
    private String time;
    private String price;
    private String description;

    public Event(){ }

    public Event(String name, Timestamp createdTime, String date, String time, String price, String description) {
        this.name = name;
        this.createdTime = createdTime;
        this.date = date;
        this.time = time;
        this.price = price;
        this.description = description;
    }

    protected Event(Parcel in) {
        name = in.readString();
        createdTime = in.readParcelable(Timestamp.class.getClassLoader());
        date = in.readString();
        time = in.readString();
        price = in.readString();
        description = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeParcelable(createdTime, flags);
        dest.writeString(date);
        dest.writeString(time);
        dest.writeString(price);
        dest.writeString(description);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Event> CREATOR = new Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

    public String getName() {
        return name;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
