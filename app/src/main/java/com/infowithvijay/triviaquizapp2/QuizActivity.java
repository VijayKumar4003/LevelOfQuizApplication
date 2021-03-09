package com.infowithvijay.triviaquizapp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class QuizActivity extends AppCompatActivity {


    Button buttonA,buttonB,buttonC,buttonD;
    TextView questionText,txtTotalQuesText,timeText,txtLevelIndicator;


    TriviaQuizHelper triviaQuizHelper;

    TriviaQuestion currentQuestion;

    List<TriviaQuestion> list;

    int qid = 1;

    int sizeofQuiz = 5; // total size of Quiz

    private final Handler handler = new Handler();
    private final Handler handler2 = new Handler();

    AnimationDrawable anim;



    private static final long COUNTDOWN_IN_MILLIS = 32000;

    private CountDownTimer countDownTimer;

    private long timeLeftMillis;

    long savedTime =0;


    private TimerDialog timerDialog;

    int correct=0;
    int wrong = 0;
    int coins = 0;

    Animation correctAnsAnimation;
    Animation wrongAnsAnimation;

    int FLAG = -1;
    PlayAudio playAudio;

    String categoryValue;
    int levelsId;

    long backPressedTime = 0;
    
    int UNLOCK_JL2 = 0,UNLOCK_JL3 = 0,UNLOCK_JL4 = 0,UNLOCK_JL5 = 0,UNLOCK_JL6 = 0;
    int UNLOCK_KL2 = 0,UNLOCK_KL3 = 0,UNLOCK_KL4 = 0,UNLOCK_KL5 = 0,UNLOCK_KL6 = 0;
    int UNLOCK_PL2 = 0,UNLOCK_PL3 = 0,UNLOCK_PL4 = 0,UNLOCK_PL5 = 0,UNLOCK_PL6 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questionText = findViewById(R.id.txtTriviaQuestion);
        txtTotalQuesText = findViewById(R.id.txtTotalQuestion);
        buttonA = findViewById(R.id.buttonA);
        buttonB = findViewById(R.id.buttonB);
        buttonC = findViewById(R.id.buttonC);
        buttonD = findViewById(R.id.buttonD);
        timeText = findViewById(R.id.txtTimer);
        txtLevelIndicator = findViewById(R.id.txtLevel);


        Intent intentCategoryAndLevels = getIntent();
        categoryValue = intentCategoryAndLevels.getStringExtra("Category");
        levelsId = intentCategoryAndLevels.getIntExtra("Level",0);

        timerDialog = new TimerDialog(this);

        correctAnsAnimation = AnimationUtils.loadAnimation(this,R.anim.correct_ans_animation);
        correctAnsAnimation.setRepeatCount(3);

        wrongAnsAnimation = AnimationUtils.loadAnimation(this,R.anim.wrong_ans_animation);
        wrongAnsAnimation.setRepeatCount(3);

        playAudio = new PlayAudio(this);
        triviaQuizHelper = new TriviaQuizHelper(this);
        triviaQuizHelper.getReadableDatabase();




        list = triviaQuizHelper.getQuestionsByLevelsAndCategory(categoryValue,levelsId);





        Collections.shuffle(list);
        currentQuestion = list.get(qid);
        txtTotalQuesText.setText(qid + "/" + sizeofQuiz);

        txtLevelIndicator.setText("Level "+ levelsId);



        updateQueAnsOptions();


    }

    private void updateQueAnsOptions() {

        buttonA.setBackgroundResource(R.drawable.default_button_bg);
        buttonB.setBackgroundResource(R.drawable.default_button_bg);
        buttonC.setBackgroundResource(R.drawable.default_button_bg);
        buttonD.setBackgroundResource(R.drawable.default_button_bg);

        questionText.setText(currentQuestion.getQuestion());
        buttonA.setText(currentQuestion.getOption1());
        buttonB.setText(currentQuestion.getOption2());
        buttonC.setText(currentQuestion.getOption3());
        buttonD.setText(currentQuestion.getOption4());


        timeLeftMillis = COUNTDOWN_IN_MILLIS;
        startCountDown();

    }


    private void SetNewQuestion(){

        qid++;

        txtTotalQuesText.setText(qid + "/" + sizeofQuiz);

        currentQuestion = list.get(qid);

        enableOptions();

        updateQueAnsOptions();
    }


//    private void correctTextUpdate(int correct){
//
//        txtCorrect.setText(String.valueOf(correct));
//
//    }
//
//    private void wrongTextUpdate(int wrong){
//
//        txtWrong.setText(String.valueOf(wrong));
//    }
//
//    private void coinsUpdateText(int coins){
//        coinText.setText(String.valueOf(coins));
//    }

    public void buttonA(View view) {

        countDownTimer.cancel();

        disableOptions();

        buttonA.setBackgroundResource(R.drawable.flash_background);
        anim = (AnimationDrawable) buttonA.getBackground();
        anim.start();


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (currentQuestion.getOption1().equals(currentQuestion.getAnswerNr())){

                    buttonA.setBackgroundResource(R.drawable.correct_button_bg);
                    buttonA.startAnimation(correctAnsAnimation);
                    correct++;
                    //correctTextUpdate(correct);

                    FLAG = 1;
                    playAudio.setAudioforEvent(FLAG);

                    coins = coins + 10;
                    //coinsUpdateText(coins);

                    Log.i("QuizInfo","Correct");

                    handler2.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            if (qid != sizeofQuiz){

                                SetNewQuestion();

                            }else {

                                finalResult();
                            }


                        }
                    },2000);
                }else {

                    buttonA.setBackgroundResource(R.drawable.wrong_button_bg);
                    buttonA.startAnimation(wrongAnsAnimation);
                    wrong++;
                    //wrongTextUpdate(wrong);
                    FLAG = 2;
                    playAudio.setAudioforEvent(FLAG);
                    Handler handler3 = new Handler();
                    handler3.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            if(currentQuestion.getOption2().equals(currentQuestion.getAnswerNr())){
                                buttonB.setBackgroundResource(R.drawable.correct_button_bg);
                            }else if (currentQuestion.getOption3().equals(currentQuestion.getAnswerNr())){
                                buttonC.setBackgroundResource(R.drawable.correct_button_bg);
                            }else {
                                buttonD.setBackgroundResource(R.drawable.correct_button_bg);
                            }
                        }
                    },2000);

                    Handler handler4 = new Handler();
                    handler4.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            if (qid != sizeofQuiz){

                                SetNewQuestion();

                            }else {
                                finalResult();
                            }
                        }
                    },3000);


                }


            }
        },5000);

    }

    public void buttonB(View view) {

      countDownTimer.cancel();

        disableOptions();
        buttonB.setBackgroundResource(R.drawable.flash_background);
        anim = (AnimationDrawable) buttonB.getBackground();
        anim.start();


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (currentQuestion.getOption2().equals(currentQuestion.getAnswerNr())){

                    buttonB.setBackgroundResource(R.drawable.correct_button_bg);
                    buttonB.startAnimation(correctAnsAnimation);
                    correct++;
                   // correctTextUpdate(correct);
                    FLAG = 1;
                    playAudio.setAudioforEvent(FLAG);
                    coins = coins + 10;
                    //coinsUpdateText(coins);

                    Log.i("QuizInfo","Correct");

                    handler2.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            if (qid != sizeofQuiz){

                                SetNewQuestion();

                            }else {
                                finalResult();
                            }


                        }
                    },2000);
                }else {

                    buttonB.setBackgroundResource(R.drawable.wrong_button_bg);
                    buttonB.startAnimation(wrongAnsAnimation);
                    wrong++;
                    //wrongTextUpdate(wrong);
                    FLAG = 2;
                    playAudio.setAudioforEvent(FLAG);
                    Handler handler3 = new Handler();
                    handler3.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            if(currentQuestion.getOption1().equals(currentQuestion.getAnswerNr())){
                                buttonA.setBackgroundResource(R.drawable.correct_button_bg);
                            }else if (currentQuestion.getOption3().equals(currentQuestion.getAnswerNr())){
                                buttonC.setBackgroundResource(R.drawable.correct_button_bg);
                            }else {
                                buttonD.setBackgroundResource(R.drawable.correct_button_bg);
                            }
                        }
                    },2000);

                    Handler handler4 = new Handler();
                    handler4.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            if (qid != sizeofQuiz){

                                SetNewQuestion();

                            }else {
                                finalResult();
                            }
                        }
                    },3000);


                }


            }
        },5000);


    }

    public void buttonC(View view) {

        countDownTimer.cancel();

        disableOptions();
        buttonC.setBackgroundResource(R.drawable.flash_background);
        anim = (AnimationDrawable) buttonC.getBackground();
        anim.start();


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (currentQuestion.getOption3().equals(currentQuestion.getAnswerNr())){

                    buttonC.setBackgroundResource(R.drawable.correct_button_bg);
                    buttonC.startAnimation(correctAnsAnimation);
                    correct++;
                   // correctTextUpdate(correct);
                    FLAG = 1;
                    playAudio.setAudioforEvent(FLAG);
                    coins = coins + 10;
                    //coinsUpdateText(coins);

                    Log.i("QuizInfo","Correct");

                    handler2.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            if (qid != sizeofQuiz){

                                SetNewQuestion();

                            }else {
                                finalResult();
                            }


                        }
                    },2000);
                }else {

                    buttonC.setBackgroundResource(R.drawable.wrong_button_bg);
                    buttonC.startAnimation(wrongAnsAnimation);
                    wrong++;
                    //wrongTextUpdate(wrong);
                    FLAG = 2;
                    playAudio.setAudioforEvent(FLAG);
                    Handler handler3 = new Handler();
                    handler3.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            if(currentQuestion.getOption2().equals(currentQuestion.getAnswerNr())){
                                buttonB.setBackgroundResource(R.drawable.correct_button_bg);
                            }else if (currentQuestion.getOption1().equals(currentQuestion.getAnswerNr())){
                                buttonA.setBackgroundResource(R.drawable.correct_button_bg);
                            }else {
                                buttonD.setBackgroundResource(R.drawable.correct_button_bg);
                            }
                        }
                    },2000);

                    Handler handler4 = new Handler();
                    handler4.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            if (qid != sizeofQuiz){

                                SetNewQuestion();

                            }else {
                               finalResult();
                            }
                        }
                    },3000);


                }


            }
        },5000);

    }

    public void buttonD(View view) {

        countDownTimer.cancel();
        disableOptions();
        buttonD.setBackgroundResource(R.drawable.flash_background);
        anim = (AnimationDrawable) buttonD.getBackground();
        anim.start();


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (currentQuestion.getOption4().equals(currentQuestion.getAnswerNr())){

                    buttonD.setBackgroundResource(R.drawable.correct_button_bg);
                    buttonD.startAnimation(correctAnsAnimation);
                    wrong++;
                    //wrongTextUpdate(wrong);
                    FLAG = 1;
                    playAudio.setAudioforEvent(FLAG);
                    correct++;
                    //correctTextUpdate(correct);

                    coins = coins + 10;
                   // coinsUpdateText(coins);

                    Log.i("QuizInfo","Correct");

                    handler2.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            if (qid != sizeofQuiz){

                                SetNewQuestion();

                            }else {
                                finalResult();
                            }


                        }
                    },2000);
                }else {

                    buttonD.setBackgroundResource(R.drawable.wrong_button_bg);
                    buttonD.startAnimation(wrongAnsAnimation);

                    FLAG = 2;
                    playAudio.setAudioforEvent(FLAG);

                    Handler handler3 = new Handler();
                    handler3.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            if(currentQuestion.getOption2().equals(currentQuestion.getAnswerNr())){
                                buttonB.setBackgroundResource(R.drawable.correct_button_bg);
                            }else if (currentQuestion.getOption3().equals(currentQuestion.getAnswerNr())){
                                buttonC.setBackgroundResource(R.drawable.correct_button_bg);
                            }else {
                                buttonA.setBackgroundResource(R.drawable.correct_button_bg);
                            }
                        }
                    },2000);

                    Handler handler4 = new Handler();
                    handler4.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            if (qid != sizeofQuiz){

                                SetNewQuestion();

                            }else {
                                finalResult();
                            }
                        }
                    },3000);


                }


            }
        },5000);

    }


    @Override
    protected void onResume() {
        super.onResume();
        countDownTimer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
       countDownTimer.cancel();
    }

    @Override
    protected void onStop() {
        super.onStop();
        countDownTimer.cancel();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        countDownTimer.cancel();
        finish();
    }

    @Override
    public void onBackPressed() {
        countDownTimer.cancel();

        if (backPressedTime + 2000 > System.currentTimeMillis()){
            Intent intent = new Intent(QuizActivity.this,CategoryActivity.class);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(this, "Press Again to Exit", Toast.LENGTH_SHORT).show();
        }

        backPressedTime = System.currentTimeMillis();


    }

   private void disableOptions(){
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

   }

   private void enableOptions(){
       buttonA.setEnabled(true);
       buttonB.setEnabled(true);
       buttonC.setEnabled(true);
       buttonD.setEnabled(true);

   }


   private void finalResult(){

        unLockTheLevels();
        
        Intent resultIntent = new Intent(QuizActivity.this,Result.class);
        resultIntent.putExtra(Constants.TOTAL_QUESTIONS,sizeofQuiz);
        resultIntent.putExtra(Constants.COINS,coins);
        resultIntent.putExtra(Constants.WRONG,wrong);
        resultIntent.putExtra(Constants.CORRECT,correct);
        resultIntent.putExtra("Category",categoryValue);
        resultIntent.putExtra("Level",levelsId);
        startActivity(resultIntent);
        finish();


   }

    private void unLockTheLevels() {
        
        unLockJavaLevels();
        unLockKotlinLevels();
        unLockPythonLevels();

    }




    private void unLockJavaLevels() {

        SharedPreferences sharedPreferences =
                getSharedPreferences(getPackageName() + Constants.MY_LEVEL_PREFFILE,
                        Context.MODE_PRIVATE);


        if (levelsId == 1 && categoryValue.equals("Java")){
            // The active level is 1, So we need to unlock the Level 2
            UNLOCK_JL2 = correct;
            if (UNLOCK_JL2 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_JAVA_LEVEL_2,1);    /// Unlock the level 2
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_JAVA_LEVEL_2,"Unlock");
                editor1.apply();
            }
        }else if (levelsId == 2 && categoryValue.equals("Java")){
            // The active level is 2, So we need to unlock the Level 3
            UNLOCK_JL3 = correct;
            if (UNLOCK_JL3 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_JAVA_LEVEL_3,1);    /// Unlock the level 3
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_JAVA_LEVEL_3,"Unlock");
                editor1.apply();
            }
        }else if (levelsId == 3 && categoryValue.equals("Java")){
            // The active level is 3, So we need to unlock the Level 4
            UNLOCK_JL4 = correct;
            if (UNLOCK_JL4 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_JAVA_LEVEL_4,1);    /// Unlock the level 4
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_JAVA_LEVEL_4,"Unlock");
                editor1.apply();
            }
        }else if (levelsId == 4 && categoryValue.equals("Java")){
            // The active level is 4, So we need to unlock the Level 5
            UNLOCK_JL5 = correct;
            if (UNLOCK_JL5 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_JAVA_LEVEL_5,1);    /// Unlock the level 5
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_JAVA_LEVEL_5,"Unlock");
                editor1.apply();
            }
        }else if (levelsId == 5 && categoryValue.equals("Java")){
            // The active level is 5, So we need to unlock the Level 6
            UNLOCK_JL6 = correct;
            if (UNLOCK_JL6 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_JAVA_LEVEL_6,1);    /// Unlock the level 6
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_JAVA_LEVEL_6,"Unlock");
                editor1.apply();
            }
        }
    }


    private void unLockPythonLevels() {

        SharedPreferences sharedPreferences =
                getSharedPreferences(getPackageName() + Constants.MY_LEVEL_PREFFILE,
                        Context.MODE_PRIVATE);


        if (levelsId == 1 && categoryValue.equals("Python")){
            // The active level is 1, So we need to unlock the Level 2
            UNLOCK_PL2 = correct;
            if (UNLOCK_PL2 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_PYTHON_LEVEL_2,1);    /// Unlock the level 2
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_PYTHON_LEVEL_2,"Unlock");
                editor1.apply();
            }
        }else if (levelsId == 2 && categoryValue.equals("Python")){
            // The active level is 2, So we need to unlock the Level 3
            UNLOCK_PL3 = correct;
            if (UNLOCK_PL3 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_PYTHON_LEVEL_3,1);    /// Unlock the level 3
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_PYTHON_LEVEL_3,"Unlock");
                editor1.apply();
            }
        }else if (levelsId == 3 && categoryValue.equals("Python")){
            // The active level is 3, So we need to unlock the Level 4
            UNLOCK_PL4 = correct;
            if (UNLOCK_PL4 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_PYTHON_LEVEL_4,1);    /// Unlock the level 4
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_PYTHON_LEVEL_4,"Unlock");
                editor1.apply();
            }
        }else if (levelsId == 4 && categoryValue.equals("Python")){
            // The active level is 4, So we need to unlock the Level 5
            UNLOCK_PL5 = correct;
            if (UNLOCK_PL5 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_PYTHON_LEVEL_5,1);    /// Unlock the level 5
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_PYTHON_LEVEL_5,"Unlock");
                editor1.apply();
            }
        }else if (levelsId == 5 && categoryValue.equals("Python")){
            // The active level is 5, So we need to unlock the Level 6
            UNLOCK_PL6 = correct;
            if (UNLOCK_PL6 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_PYTHON_LEVEL_6,1);    /// Unlock the level 6
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_PYTHON_LEVEL_6,"Unlock");
                editor1.apply();
            }
        }

    }


    private void unLockKotlinLevels() {

        SharedPreferences sharedPreferences =
                getSharedPreferences(getPackageName() + Constants.MY_LEVEL_PREFFILE,
                        Context.MODE_PRIVATE);


        if (levelsId == 1 && categoryValue.equals("Kotlin")){
            // The active level is 1, So we need to unlock the Level 2
            UNLOCK_KL2 = correct;
            if (UNLOCK_KL2 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_KOTLIN_LEVEL_2,1);    /// Unlock the level 2
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_KOTLIN_LEVEL_2,"Unlock");
                editor1.apply();
            }
        }else if (levelsId == 2 && categoryValue.equals("Kotlin")){
            // The active level is 2, So we need to unlock the Level 3
            UNLOCK_KL3 = correct;
            if (UNLOCK_KL3 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_KOTLIN_LEVEL_3,1);    /// Unlock the level 3
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_KOTLIN_LEVEL_3,"Unlock");
                editor1.apply();
            }
        }else if (levelsId == 3 && categoryValue.equals("Kotlin")){
            // The active level is 3, So we need to unlock the Level 4
            UNLOCK_KL4 = correct;
            if (UNLOCK_KL4 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_KOTLIN_LEVEL_4,1);    /// Unlock the level 4
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_KOTLIN_LEVEL_4,"Unlock");
                editor1.apply();
            }
        }else if (levelsId == 4 && categoryValue.equals("Kotlin")){
            // The active level is 4, So we need to unlock the Level 5
            UNLOCK_KL5 = correct;
            if (UNLOCK_KL5 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_KOTLIN_LEVEL_5,1);    /// Unlock the level 5
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_KOTLIN_LEVEL_5,"Unlock");
                editor1.apply();
            }
        }else if (levelsId == 5 && categoryValue.equals("Kotlin")){
            // The active level is 5, So we need to unlock the Level 6
            UNLOCK_KL6 = correct;
            if (UNLOCK_KL6 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_KOTLIN_LEVEL_6,1);    /// Unlock the level 6
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_KOTLIN_LEVEL_6,"Unlock");
                editor1.apply();
            }
        }

    }





    private void startCountDown(){

        countDownTimer = new CountDownTimer(timeLeftMillis,1000) {
            @Override
            public void onTick(long millsUnilFinished) {
                timeLeftMillis = millsUnilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {

                timeLeftMillis = 0;
                updateCountDownText();

            }
        }.start();


   }
   
    private void updateCountDownText(){


        int seconds = (int) (timeLeftMillis/1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(),"%02d",seconds);
        savedTime = Long.parseLong(timeFormatted);
        timeText.setText(timeFormatted);

        if (timeLeftMillis < 10000){

            timeText.setTextColor(ContextCompat.getColor(this,R.color.red));

        }else {

            timeText.setTextColor(ContextCompat.getColor(this,R.color.white));

        }

        if (timeLeftMillis == 0){

            Toast.makeText(this, "Times Up!", Toast.LENGTH_SHORT).show();

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    timerDialog.timerDialog();

                }
            },2000);

        }

    }
    
}
