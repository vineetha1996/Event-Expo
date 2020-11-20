package com.example.event_expo.other;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import com.example.event_expo.model.User;
import com.google.gson.Gson;

public class SharedPref {

    private static SharedPref instance = null;

    private static final String sharedPreferencesName = "event_expo";

    private SharedPref() {
    }

    public static SharedPref getInstance() {
        if (instance == null) {
            instance = new SharedPref();
        }
        return instance;
    }

    public void clearSharedPref(@NonNull Context context) {
        SharedPreferences pref = context.getSharedPreferences(sharedPreferencesName, 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.apply();
    }

    public String isLoggedIn(Context context){
        SharedPreferences pref = context.getSharedPreferences(sharedPreferencesName, 0);
        return pref.getString(Constants.loginType, "");
    }

    public void setLoginType(@NonNull Context context, @NonNull String loginType) {
        SharedPreferences pref = context.getSharedPreferences(sharedPreferencesName, 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(Constants.loginType, loginType);
        editor.apply();
    }

    public String getUserDocumentID(Context context){
        SharedPreferences pref = context.getSharedPreferences(sharedPreferencesName, 0);
        return pref.getString(Constants.USER_DOCUMENT, "");
    }

    public void setUserDocumentID(@NonNull Context context, @NonNull String documentID) {
        SharedPreferences pref = context.getSharedPreferences(sharedPreferencesName, 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(Constants.USER_DOCUMENT, documentID);
        editor.apply();
    }

    public User getUser(Context context){
        SharedPreferences pref = context.getSharedPreferences(sharedPreferencesName, 0);
        return new Gson().fromJson(pref.getString(Constants.user, ""),User.class);
    }

    public void setUser(@NonNull Context context, @NonNull User user) {
        SharedPreferences pref = context.getSharedPreferences(sharedPreferencesName, 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(Constants.user, new Gson().toJson(user));
        editor.apply();
    }


}
