package com.infowithvijay.triviaquizapp2;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;

public class AppController extends Application {

    private static Context mContext;
    public static MediaPlayer player;
    public static Activity currentActivity;


    @Override
    public void onCreate() {
        super.onCreate();
        setmContext(getApplicationContext());

        player = new MediaPlayer();

        mediaPlayerIntilizer();

    }

    public static Context getmContext() {
        return mContext;
    }

    public static void setmContext(Context context) {
        mContext = context;
    }

    public static void mediaPlayerIntilizer(){

        try {

            player = MediaPlayer.create(getmContext(),R.raw.background);
            player.setAudioStreamType(AudioManager.STREAM_MUSIC);
            player.setLooping(true);
            player.setVolume(1f,1f);

        }catch (IllegalStateException e){
            e.printStackTrace();
        }
    }

    public static void playMusic(){

        try {
            if (SettingsPreferences.getMusicEnableDisable(mContext)&&!player.isPlaying()){
                player.start();
            }

        }catch (IllegalStateException e){}

    }


    public static void StopSound(){

        if (player.isPlaying()){
            player.pause();
        }
    }

}
