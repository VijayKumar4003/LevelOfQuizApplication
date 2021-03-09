package com.infowithvijay.triviaquizapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CategoryActivity extends AppCompatActivity implements View.OnClickListener{

    Button btJava,btKotlin,btDart,btPython;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        btDart = findViewById(R.id.bt_Dart);
        btJava = findViewById(R.id.bt_Java);
        btKotlin = findViewById(R.id.bt_Kotlin);
        btPython = findViewById(R.id.bt_Python);



        btDart.setOnClickListener(this);
        btJava.setOnClickListener(this);
        btKotlin.setOnClickListener(this);
        btPython.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){


            case R.id.bt_Java:

                createLevelsForJava();
                Intent intentJava = new Intent(CategoryActivity.this,JavaLevelsActivity.class);
                intentJava.putExtra("Category",TriviaQuestion.CATEGORY_JAVA);
                startActivity(intentJava);
                finish();
                break;

            case R.id.bt_Kotlin:
                createLevelsForKotlin();
                Intent intentKotlin = new Intent(CategoryActivity.this,KoltinLevelsActivity.class);
                intentKotlin.putExtra("Category",TriviaQuestion.CATEGORY_KOTLIN);
                startActivity(intentKotlin);
                finish();
                break;


            case R.id.bt_Python:
                createLevelsForPython();
                Intent intentFlutter = new Intent(CategoryActivity.this,PythonLevelsActivity.class);
                intentFlutter.putExtra("Category",TriviaQuestion.CATEGORY_PYTHON);
                startActivity(intentFlutter);
                finish();
                break;


            case R.id.bt_Dart:

//                Intent intentDart = new Intent(CategoryActivity.this,JavaLevelsActivity.class);
//                intentDart.putExtra("Category",TriviaQuestion.CATEGORY_PYTHON);
//                startActivity(intentDart);
//                finish();
                break;
        }

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(CategoryActivity.this,PlayScreen.class);
        startActivity(intent);
        finish();
    }



    ///  1 -> unlocked   0 -> locked
    public void createLevelsForJava(){

        SharedPreferences sharedPreferences =
                getSharedPreferences(getPackageName() + Constants.MY_LEVEL_PREFFILE,
                        Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(Constants.KEY_JAVA_LEVEL_1,1);
        editor.putString(Constants.KEY_CAT_JAVA_LEVEL_1,"Unlock");
        editor.apply();

        if (sharedPreferences.getString(Constants.KEY_CAT_JAVA_LEVEL_1,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_JAVA_LEVEL_1,1);   ///  Unlock Level 1
            editor.putInt(Constants.KEY_JAVA_LEVEL_2,0);
            editor.putInt(Constants.KEY_JAVA_LEVEL_3,0);
            editor.putInt(Constants.KEY_JAVA_LEVEL_4,0);
            editor.putInt(Constants.KEY_JAVA_LEVEL_5,0);
            editor.putInt(Constants.KEY_JAVA_LEVEL_6,0);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_JAVA_LEVEL_2,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_JAVA_LEVEL_1,1);
            editor.putInt(Constants.KEY_JAVA_LEVEL_2,1);   ///  Unlock Level 2
            editor.putInt(Constants.KEY_JAVA_LEVEL_3,0);
            editor.putInt(Constants.KEY_JAVA_LEVEL_4,0);
            editor.putInt(Constants.KEY_JAVA_LEVEL_5,0);
            editor.putInt(Constants.KEY_JAVA_LEVEL_6,0);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_JAVA_LEVEL_3,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_JAVA_LEVEL_1,1);
            editor.putInt(Constants.KEY_JAVA_LEVEL_2,1);
            editor.putInt(Constants.KEY_JAVA_LEVEL_3,1);   ///  Unlock Level 3
            editor.putInt(Constants.KEY_JAVA_LEVEL_4,0);
            editor.putInt(Constants.KEY_JAVA_LEVEL_5,0);
            editor.putInt(Constants.KEY_JAVA_LEVEL_6,0);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_JAVA_LEVEL_4,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_JAVA_LEVEL_1,1);
            editor.putInt(Constants.KEY_JAVA_LEVEL_2,1);
            editor.putInt(Constants.KEY_JAVA_LEVEL_3,1);
            editor.putInt(Constants.KEY_JAVA_LEVEL_4,1);  ///  Unlock Level 4
            editor.putInt(Constants.KEY_JAVA_LEVEL_5,0);
            editor.putInt(Constants.KEY_JAVA_LEVEL_6,0);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_JAVA_LEVEL_5,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_JAVA_LEVEL_1,1);
            editor.putInt(Constants.KEY_JAVA_LEVEL_2,1);
            editor.putInt(Constants.KEY_JAVA_LEVEL_3,1);
            editor.putInt(Constants.KEY_JAVA_LEVEL_4,1);
            editor.putInt(Constants.KEY_JAVA_LEVEL_5,1);    ///  Unlock Level 5
            editor.putInt(Constants.KEY_JAVA_LEVEL_6,0);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_JAVA_LEVEL_6,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_JAVA_LEVEL_1,1);
            editor.putInt(Constants.KEY_JAVA_LEVEL_2,1);
            editor.putInt(Constants.KEY_JAVA_LEVEL_3,1);
            editor.putInt(Constants.KEY_JAVA_LEVEL_4,1);
            editor.putInt(Constants.KEY_JAVA_LEVEL_5,1);
            editor.putInt(Constants.KEY_JAVA_LEVEL_6,1);  ///  Unlock Level 6

        }
    }


    ///  1 -> unlocked   0 -> locked
    public void createLevelsForKotlin(){

        SharedPreferences sharedPreferences =
                getSharedPreferences(getPackageName() + Constants.MY_LEVEL_PREFFILE,
                        Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(Constants.KEY_KOTLIN_LEVEL_1,1);
        editor.putString(Constants.KEY_CAT_KOTLIN_LEVEL_1,"Unlock");
        editor.apply();

        if (sharedPreferences.getString(Constants.KEY_CAT_KOTLIN_LEVEL_1,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_KOTLIN_LEVEL_1,1);   ///  Unlock Level 1
            editor.putInt(Constants.KEY_KOTLIN_LEVEL_2,0);
            editor.putInt(Constants.KEY_KOTLIN_LEVEL_3,0);
            editor.putInt(Constants.KEY_KOTLIN_LEVEL_4,0);
            editor.putInt(Constants.KEY_KOTLIN_LEVEL_5,0);
            editor.putInt(Constants.KEY_KOTLIN_LEVEL_6,0);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_KOTLIN_LEVEL_2,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_KOTLIN_LEVEL_1,1);
            editor.putInt(Constants.KEY_KOTLIN_LEVEL_2,1);   ///  Unlock Level 2
            editor.putInt(Constants.KEY_KOTLIN_LEVEL_3,0);
            editor.putInt(Constants.KEY_KOTLIN_LEVEL_4,0);
            editor.putInt(Constants.KEY_KOTLIN_LEVEL_5,0);
            editor.putInt(Constants.KEY_KOTLIN_LEVEL_6,0);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_KOTLIN_LEVEL_3,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_KOTLIN_LEVEL_1,1);
            editor.putInt(Constants.KEY_KOTLIN_LEVEL_2,1);
            editor.putInt(Constants.KEY_KOTLIN_LEVEL_3,1);   ///  Unlock Level 3
            editor.putInt(Constants.KEY_KOTLIN_LEVEL_4,0);
            editor.putInt(Constants.KEY_KOTLIN_LEVEL_5,0);
            editor.putInt(Constants.KEY_KOTLIN_LEVEL_6,0);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_KOTLIN_LEVEL_4,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_KOTLIN_LEVEL_1,1);
            editor.putInt(Constants.KEY_KOTLIN_LEVEL_2,1);
            editor.putInt(Constants.KEY_KOTLIN_LEVEL_3,1);
            editor.putInt(Constants.KEY_KOTLIN_LEVEL_4,1);  ///  Unlock Level 4
            editor.putInt(Constants.KEY_KOTLIN_LEVEL_5,0);
            editor.putInt(Constants.KEY_KOTLIN_LEVEL_6,0);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_KOTLIN_LEVEL_5,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_KOTLIN_LEVEL_1,1);
            editor.putInt(Constants.KEY_KOTLIN_LEVEL_2,1);
            editor.putInt(Constants.KEY_KOTLIN_LEVEL_3,1);
            editor.putInt(Constants.KEY_KOTLIN_LEVEL_4,1);
            editor.putInt(Constants.KEY_KOTLIN_LEVEL_5,1);    ///  Unlock Level 5
            editor.putInt(Constants.KEY_KOTLIN_LEVEL_6,0);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_KOTLIN_LEVEL_6,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_KOTLIN_LEVEL_1,1);
            editor.putInt(Constants.KEY_KOTLIN_LEVEL_2,1);
            editor.putInt(Constants.KEY_KOTLIN_LEVEL_3,1);
            editor.putInt(Constants.KEY_KOTLIN_LEVEL_4,1);
            editor.putInt(Constants.KEY_KOTLIN_LEVEL_5,1);
            editor.putInt(Constants.KEY_KOTLIN_LEVEL_6,1);  ///  Unlock Level 6

        }
    }


    ///  1 -> unlocked   0 -> locked
    public void createLevelsForPython(){

        SharedPreferences sharedPreferences =
                getSharedPreferences(getPackageName() + Constants.MY_LEVEL_PREFFILE,
                        Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(Constants.KEY_PYTHON_LEVEL_1,1);
        editor.putString(Constants.KEY_CAT_PYTHON_LEVEL_1,"Unlock");
        editor.apply();

        if (sharedPreferences.getString(Constants.KEY_CAT_PYTHON_LEVEL_1,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_PYTHON_LEVEL_1,1);   ///  Unlock Level 1
            editor.putInt(Constants.KEY_PYTHON_LEVEL_2,0);
            editor.putInt(Constants.KEY_PYTHON_LEVEL_3,0);
            editor.putInt(Constants.KEY_PYTHON_LEVEL_4,0);
            editor.putInt(Constants.KEY_PYTHON_LEVEL_5,0);
            editor.putInt(Constants.KEY_PYTHON_LEVEL_6,0);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_PYTHON_LEVEL_2,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_PYTHON_LEVEL_1,1);
            editor.putInt(Constants.KEY_PYTHON_LEVEL_2,1);   ///  Unlock Level 2
            editor.putInt(Constants.KEY_PYTHON_LEVEL_3,0);
            editor.putInt(Constants.KEY_PYTHON_LEVEL_4,0);
            editor.putInt(Constants.KEY_PYTHON_LEVEL_5,0);
            editor.putInt(Constants.KEY_PYTHON_LEVEL_6,0);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_PYTHON_LEVEL_3,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_PYTHON_LEVEL_1,1);
            editor.putInt(Constants.KEY_PYTHON_LEVEL_2,1);
            editor.putInt(Constants.KEY_PYTHON_LEVEL_3,1);   ///  Unlock Level 3
            editor.putInt(Constants.KEY_PYTHON_LEVEL_4,0);
            editor.putInt(Constants.KEY_PYTHON_LEVEL_5,0);
            editor.putInt(Constants.KEY_PYTHON_LEVEL_6,0);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_PYTHON_LEVEL_4,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_PYTHON_LEVEL_1,1);
            editor.putInt(Constants.KEY_PYTHON_LEVEL_2,1);
            editor.putInt(Constants.KEY_PYTHON_LEVEL_3,1);
            editor.putInt(Constants.KEY_PYTHON_LEVEL_4,1);  ///  Unlock Level 4
            editor.putInt(Constants.KEY_PYTHON_LEVEL_5,0);
            editor.putInt(Constants.KEY_PYTHON_LEVEL_6,0);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_PYTHON_LEVEL_5,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_PYTHON_LEVEL_1,1);
            editor.putInt(Constants.KEY_PYTHON_LEVEL_2,1);
            editor.putInt(Constants.KEY_PYTHON_LEVEL_3,1);
            editor.putInt(Constants.KEY_PYTHON_LEVEL_4,1);
            editor.putInt(Constants.KEY_PYTHON_LEVEL_5,1);    ///  Unlock Level 5
            editor.putInt(Constants.KEY_PYTHON_LEVEL_6,0);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_PYTHON_LEVEL_6,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_PYTHON_LEVEL_1,1);
            editor.putInt(Constants.KEY_PYTHON_LEVEL_2,1);
            editor.putInt(Constants.KEY_PYTHON_LEVEL_3,1);
            editor.putInt(Constants.KEY_PYTHON_LEVEL_4,1);
            editor.putInt(Constants.KEY_PYTHON_LEVEL_5,1);
            editor.putInt(Constants.KEY_PYTHON_LEVEL_6,1);  ///  Unlock Level 6

        }
    }

}