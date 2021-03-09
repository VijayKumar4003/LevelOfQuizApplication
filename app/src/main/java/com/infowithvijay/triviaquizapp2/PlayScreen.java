package com.infowithvijay.triviaquizapp2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static com.infowithvijay.triviaquizapp2.AppController.StopSound;

public class PlayScreen extends AppCompatActivity implements View.OnClickListener {

    Button btPlayQuiz,btSettings;

    public static Context context;

    long backPressedTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_screen);


        btPlayQuiz = findViewById(R.id.bt_playQuiz);
        btSettings = findViewById(R.id.bt_settings);

        btSettings.setOnClickListener(this);
        btPlayQuiz.setOnClickListener(this);

        context = getApplicationContext();
        AppController.currentActivity = this;
        if (SettingsPreferences.getMusicEnableDisable(context)){
            try {

                AppController.playMusic();

            }catch (IllegalStateException e){
                e.printStackTrace();
            }
        }

   }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.bt_playQuiz:

                Intent playIntent = new Intent(PlayScreen.this,CategoryActivity.class);
                startActivity(playIntent);
                finish();
                break;

            case R.id.bt_settings:
                Intent settingIntent = new Intent(PlayScreen.this,Settings.class);
                startActivity(settingIntent);
                finish();
                break;

        }

    }

    @Override
    public void onBackPressed() {

        StopSound();

        if (backPressedTime + 2000 > System.currentTimeMillis()){

            new AlertDialog.Builder(this)
                    .setTitle("Do you want to Exit")
                    .setNegativeButton("No",null)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            setResult(RESULT_OK,new Intent().putExtra("Exit",true));
                            finish();

                        }
                    }).create().show();

        }else {

            Toast.makeText(context, "Press Again to Exit", Toast.LENGTH_SHORT).show();
        }

        backPressedTime = System.currentTimeMillis();

    }
}
