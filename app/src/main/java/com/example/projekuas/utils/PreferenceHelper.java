package com.example.projekuas.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceHelper {

    private static final String PREF_NAME="projekuas";

    private SharedPreferences pref;

    public PreferenceHelper(Context context){

        pref=context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);

    }

    public void setDarkMode(boolean value){

        pref.edit().putBoolean("dark",value).apply();

    }

    public boolean isDarkMode(){

        return pref.getBoolean("dark",false);

    }

    public void setDownloaded(boolean value){

        pref.edit().putBoolean("downloaded",value).apply();

    }

    public boolean isDownloaded(){

        return pref.getBoolean("downloaded",false);

    }

}