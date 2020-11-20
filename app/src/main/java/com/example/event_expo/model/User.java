package com.example.event_expo.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.Timestamp;

public class User implements Parcelable {

    private String username;
    private Timestamp id;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private String password;

    public User(String username, Timestamp id, String firstName, String lastName, String email, String mobileNumber, String password) {
        this.username = username;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.password = password;
    }

    public User(){ }

    protected User(Parcel in) {
        username = in.readString();
        id = in.readParcelable(Timestamp.class.getClassLoader());
        firstName = in.readString();
        lastName = in.readString();
        email = in.readString();
        mobileNumber = in.readString();
        password = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeParcelable(id, flags);
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(email);
        dest.writeString(mobileNumber);
        dest.writeString(password);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getUsername() {
        return username;
    }

    public Timestamp getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getPassword() {
        return password;
    }
}
