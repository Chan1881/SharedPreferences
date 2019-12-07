package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class UserDataManager {
    private static final String PREF_NAME = "USER_DATA", KEY_IS_LOGIN="isLogin", KEY_USERNAME="username";

    public static UserData getUserData(Context context){
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        UserData userData = new UserData();
        userData.setLogin(preferences.getBoolean("isLogin",false));
        userData.setUsername(preferences.getString(KEY_USERNAME,"null"));
        return userData;
    }

    public static void saveUserData(Context context, UserData userData){
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putBoolean(KEY_IS_LOGIN, userData.isLogin());
        editor.putString(KEY_USERNAME,userData.getUsername());
        editor.apply();
    }

    public static void clearUserData(Context context){
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.clear();
    }
}
