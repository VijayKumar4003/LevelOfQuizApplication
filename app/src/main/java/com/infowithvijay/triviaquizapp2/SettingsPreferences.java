package com.infowithvijay.triviaquizapp2;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;


public class SettingsPreferences {


    private static final String SHOW_MUSIC_ONOFF =  "show_music_enable_disable";


    public static void setMusicEnableDisable(Context context,Boolean result){

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putBoolean(SHOW_MUSIC_ONOFF,result);
        prefsEditor.commit();

    }


    public static boolean getMusicEnableDisable(Context context){

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getBoolean(SHOW_MUSIC_ONOFF,
                Constants.DEFAULT_MUSIC_SETTING);

    }


}
