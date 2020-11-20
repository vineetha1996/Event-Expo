package com.example.event_expo.model;

import android.os.Parcel;
import android.os.Parcelable;

public class RequestedEvent implements Parcelable {

    private Event event;
    private String userName;
    private String userDocumentID;

    public RequestedEvent(Event event, String userName, String userDocumentID) {
        this.event = event;
        this.userName = userName;
        this.userDocumentID = userDocumentID;
    }

    public RequestedEvent(){}

    protected RequestedEvent(Parcel in) {
        event = in.readParcelable(Event.class.getClassLoader());
        userName = in.readString();
        userDocumentID = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(event, flags);
        dest.writeString(userName);
        dest.writeString(userDocumentID);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<RequestedEvent> CREATOR = new Creator<RequestedEvent>() {
        @Override
        public RequestedEvent createFromParcel(Parcel in) {
            return new RequestedEvent(in);
        }

        @Override
        public RequestedEvent[] newArray(int size) {
            return new RequestedEvent[size];
        }
    };

    public Event getEvent() {
        return event;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserDocumentID() {
        return userDocumentID;
    }
}
