package com.infowithvijay.triviaquizapp2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.infowithvijay.triviaquizapp2.TriviaQuizContract.*;

import java.util.ArrayList;

public class TriviaQuizHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "TriviaQuiz.db";
    private static final int DATBASE_VERSION = 19;

    private SQLiteDatabase db;


    TriviaQuizHelper(Context context) {
        super(context, DATABASE_NAME,null, DATBASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionTable.TABLE_NAME + " ( " +
                QuestionTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionTable.COLUMN_QUESTION + " TEXT, " +
                QuestionTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionTable.COLUMN_ANSWER_NR + " TEXT, " +
                QuestionTable.COLUMN_CATEGORY + " TEXT, " +
                QuestionTable.COLUMN_LEVELS_ID + " INTEGER " +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + QuestionTable.TABLE_NAME);
        onCreate(db);

    }


    private void fillQuestionsTable()
    {

        TriviaQuestion q1 = new TriviaQuestion("Level 1 Category : Java Android is what ?","OS","Drivers","Software","Hardware","OS"
                ,TriviaQuestion.CATEGORY_JAVA,1);
        addQuestions(q1);

        TriviaQuestion q2 = new TriviaQuestion("Level 1 Category : Java Full form of PC is ?","Personal Computer","PIPO","TIPU","XXXIV","Personal Computer"
                ,TriviaQuestion.CATEGORY_JAVA,1);
        addQuestions(q2);

        TriviaQuestion q3= new TriviaQuestion("Level 1 Category : Java The father of computer is  ?","Charles Babbage","Oliver twist","Love lice","lice","Charles Babbage"
                ,TriviaQuestion.CATEGORY_JAVA,1);
        addQuestions(q3);

        TriviaQuestion q4= new TriviaQuestion("Level 1 Category : Java Which of the following is not a computer language?","BASIC","FORTRAN","LOUTS","COBOL","LOUTS"
                ,TriviaQuestion.CATEGORY_JAVA,1);
        addQuestions(q4);

        TriviaQuestion q5= new TriviaQuestion("Level 1 Category : Java The third generation computers were made with ?","Bio Chips ","Transistors","Integrated Circuits","Vacuum Tubes ","Integrated Circuits"
                ,TriviaQuestion.CATEGORY_JAVA,1);
        addQuestions(q5);

        TriviaQuestion q6= new TriviaQuestion("Level 1 Category : Java The first page displayed by Web browser after opening a Web site is called ?","Home page","Browser page","Search page  ","Bookmark","Home page"
                ,TriviaQuestion.CATEGORY_JAVA,1);
        addQuestions(q6);


        TriviaQuestion q11 = new TriviaQuestion("Level 2 Category : Java Android is what ?","OS","Drivers","Software","Hardware","OS"
                ,TriviaQuestion.CATEGORY_JAVA,2);
        addQuestions(q11);

        TriviaQuestion q12 = new TriviaQuestion("Level 2 Category : Java Full form of PC is ?","Personal Computer","PIPO","TIPU","XXXIV","Personal Computer"
                ,TriviaQuestion.CATEGORY_JAVA,2);
        addQuestions(q12);

        TriviaQuestion q13= new TriviaQuestion("Level 2 Category : Java The father of computer is  ?","Charles Babbage","Oliver twist","Love lice","lice","Charles Babbage"
                ,TriviaQuestion.CATEGORY_JAVA,2);
        addQuestions(q13);

        TriviaQuestion q14= new TriviaQuestion("Level 2 Category : Java Which of the following is not a computer language?","BASIC","FORTRAN","LOUTS","COBOL","LOUTS"
                ,TriviaQuestion.CATEGORY_JAVA,2);
        addQuestions(q14);

        TriviaQuestion q15= new TriviaQuestion("Level 2 Category : Java The third generation computers were made with ?","Bio Chips ","Transistors","Integrated Circuits","Vacuum Tubes ","Integrated Circuits"
                ,TriviaQuestion.CATEGORY_JAVA,2);
        addQuestions(q15);

        TriviaQuestion q16= new TriviaQuestion("Level 2 Category : Java The first page displayed by Web browser after opening a Web site is called ?","Home page","Browser page","Search page  ","Bookmark","Home page"
                ,TriviaQuestion.CATEGORY_JAVA,2);
        addQuestions(q16);


        TriviaQuestion q111 = new TriviaQuestion("Level 3 Category : Java Android is what ?","OS","Drivers","Software","Hardware","OS"
                ,TriviaQuestion.CATEGORY_JAVA,3);
        addQuestions(q111);

        TriviaQuestion q112 = new TriviaQuestion("Level 3 Category : Java Full form of PC is ?","Personal Computer","PIPO","TIPU","XXXIV","Personal Computer"
                ,TriviaQuestion.CATEGORY_JAVA,3);
        addQuestions(q112);

        TriviaQuestion q113= new TriviaQuestion("Level 3 Category : Java The father of computer is  ?","Charles Babbage","Oliver twist","Love lice","lice","Charles Babbage"
                ,TriviaQuestion.CATEGORY_JAVA,3);
        addQuestions(q113);

        TriviaQuestion q114= new TriviaQuestion("Level 3 Category : Java Which of the following is not a computer language?","BASIC","FORTRAN","LOUTS","COBOL","LOUTS"
                ,TriviaQuestion.CATEGORY_JAVA,3);
        addQuestions(q114);

        TriviaQuestion q115= new TriviaQuestion("Level 3 Category : Java The third generation computers were made with ?","Bio Chips ","Transistors","Integrated Circuits","Vacuum Tubes ","Integrated Circuits"
                ,TriviaQuestion.CATEGORY_JAVA,3);
        addQuestions(q115);

        TriviaQuestion q116= new TriviaQuestion("Level 3 Category : Java The first page displayed by Web browser after opening a Web site is called ?","Home page","Browser page","Search page  ","Bookmark","Home page"
                ,TriviaQuestion.CATEGORY_JAVA,3);
        addQuestions(q116);


        TriviaQuestion q45= new TriviaQuestion("Level 4 Category : Java The father of computer is  ?","Charles Babbage","Oliver twist","Love lice","lice","Charles Babbage"
                ,TriviaQuestion.CATEGORY_JAVA,4);
        addQuestions(q45);

        TriviaQuestion q46= new TriviaQuestion("Level 4 Category : Java Which of the following is not a computer language?","BASIC","FORTRAN","LOUTS","COBOL","LOUTS"
                ,TriviaQuestion.CATEGORY_JAVA,4);
        addQuestions(q46);

        TriviaQuestion q47 = new TriviaQuestion("Level 4 Category : Java The third generation computers were made with ?","Bio Chips ","Transistors","Integrated Circuits","Vacuum Tubes ","Integrated Circuits"
                ,TriviaQuestion.CATEGORY_JAVA,4);
        addQuestions(q47);

        TriviaQuestion q48= new TriviaQuestion("Level 4 Category : Java The first page displayed by Web browser after opening a Web site is called ?","Home page","Browser page","Search page  ","Bookmark","Home page"
                ,TriviaQuestion.CATEGORY_JAVA,4);
        addQuestions(q48);

        TriviaQuestion q4a7 = new TriviaQuestion("Level 4 Category : Java The third generation computers were made with ?","Bio Chips ","Transistors","Integrated Circuits","Vacuum Tubes ","Integrated Circuits"
                ,TriviaQuestion.CATEGORY_JAVA,4);
        addQuestions(q4a7);

        TriviaQuestion q4a8= new TriviaQuestion("Level 4 Category : Java The first page displayed by Web browser after opening a Web site is called ?","Home page","Browser page","Search page  ","Bookmark","Home page"
                ,TriviaQuestion.CATEGORY_JAVA,4);
        addQuestions(q4a8);


        TriviaQuestion q465= new TriviaQuestion("Level 5 Category : Java The father of computer is  ?","Charles Babbage","Oliver twist","Love lice","lice","Charles Babbage"
                ,TriviaQuestion.CATEGORY_JAVA,5);
        addQuestions(q465);

        TriviaQuestion q466= new TriviaQuestion("Level 5 Category : Java Which of the following is not a computer language?","BASIC","FORTRAN","LOUTS","COBOL","LOUTS"
                ,TriviaQuestion.CATEGORY_JAVA,5);
        addQuestions(q466);

        TriviaQuestion q467 = new TriviaQuestion("Level 5 Category : Java The third generation computers were made with ?","Bio Chips ","Transistors","Integrated Circuits","Vacuum Tubes ","Integrated Circuits"
                ,TriviaQuestion.CATEGORY_JAVA,5);
        addQuestions(q467);

        TriviaQuestion q468= new TriviaQuestion("Level 5 Category : Java The first page displayed by Web browser after opening a Web site is called ?","Home page","Browser page","Search page  ","Bookmark","Home page"
                ,TriviaQuestion.CATEGORY_JAVA,5);
        addQuestions(q468);
        TriviaQuestion q4607 = new TriviaQuestion("Level 5 Category : Java The third generation computers were made with ?","Bio Chips ","Transistors","Integrated Circuits","Vacuum Tubes ","Integrated Circuits"
                ,TriviaQuestion.CATEGORY_JAVA,5);
        addQuestions(q4607);

        TriviaQuestion q4608= new TriviaQuestion("Level 5 Category : Java The first page displayed by Web browser after opening a Web site is called ?","Home page","Browser page","Search page  ","Bookmark","Home page"
                ,TriviaQuestion.CATEGORY_JAVA,5);
        addQuestions(q4608);



        TriviaQuestion qa465= new TriviaQuestion("Level 6 Category : Java The father of computer is  ?","Charles Babbage","Oliver twist","Love lice","lice","Charles Babbage"
                ,TriviaQuestion.CATEGORY_JAVA,6);
        addQuestions(qa465);

        TriviaQuestion qa466= new TriviaQuestion("Level 6 Category : Java Which of the following is not a computer language?","BASIC","FORTRAN","LOUTS","COBOL","LOUTS"
                ,TriviaQuestion.CATEGORY_JAVA,6);
        addQuestions(qa466);

        TriviaQuestion qa467 = new TriviaQuestion("Level 6 Category : Java The third generation computers were made with ?","Bio Chips ","Transistors","Integrated Circuits","Vacuum Tubes ","Integrated Circuits"
                ,TriviaQuestion.CATEGORY_JAVA,6);
        addQuestions(qa467);

        TriviaQuestion qa468= new TriviaQuestion("Level 6 Category : Java The first page displayed by Web browser after opening a Web site is called ?","Home page","Browser page","Search page  ","Bookmark","Home page"
                ,TriviaQuestion.CATEGORY_JAVA,6);
        addQuestions(qa468);
        TriviaQuestion qa4607 = new TriviaQuestion("Level 6 Category : Java The third generation computers were made with ?","Bio Chips ","Transistors","Integrated Circuits","Vacuum Tubes ","Integrated Circuits"
                ,TriviaQuestion.CATEGORY_JAVA,6);
        addQuestions(qa4607);

        TriviaQuestion qa4608= new TriviaQuestion("Level 6 Category : Java The first page displayed by Web browser after opening a Web site is called ?","Home page","Browser page","Search page  ","Bookmark","Home page"
                ,TriviaQuestion.CATEGORY_JAVA,6);
        addQuestions(qa4608);



        TriviaQuestion q27= new TriviaQuestion(" Level 1 Category : Kotlin DuckDuck Go is what ?","Search Engine","Browser page","Search page  ","Bookmark","Search Engine"
                ,TriviaQuestion.CATEGORY_KOTLIN,1);
        addQuestions(q27);

        TriviaQuestion q28= new TriviaQuestion(" Level 1Category : Kotlin What is Norton?","Anitivirus","Browser page","Vaccine","Program","Anitivirus"
                ,TriviaQuestion.CATEGORY_KOTLIN,1);
        addQuestions(q28);

        TriviaQuestion q29= new TriviaQuestion("Level 1 Category : Kotlin Who is the inventor of www?","Bill Gates","Tim Berners-Lee","Timothy Bil","Ray Tomlinson","Tim Berners-Lee"
                ,TriviaQuestion.CATEGORY_KOTLIN,1);
        addQuestions(q29);

        TriviaQuestion q10= new TriviaQuestion(" Level 1 Category : Kotlin Ethernet is an example of ","MAN","LAN","WAN","Wi-Fi","LAN"
                ,TriviaQuestion.CATEGORY_KOTLIN,1);
        addQuestions(q10);

        TriviaQuestion q121= new TriviaQuestion("Level 1 Category : Kotlin HTML is used to create","Operating System","High Level Program","Web-Server","Web Page","Web Page"
                ,TriviaQuestion.CATEGORY_KOTLIN,1);
        addQuestions(q121);

        TriviaQuestion q122= new TriviaQuestion("Level 1 Category : Kotlin Speed of internet connection is measured in","GHz","dpi","ppm","Gbps","Gbps"
                ,TriviaQuestion.CATEGORY_KOTLIN,1);
        addQuestions(q122);




        TriviaQuestion q2b7= new TriviaQuestion("Level 2 Category : Kotlin DuckDuck Go is what ?","Search Engine","Browser page","Search page  ","Bookmark","Search Engine"
                ,TriviaQuestion.CATEGORY_KOTLIN,2);
        addQuestions(q2b7);

        TriviaQuestion q2b8= new TriviaQuestion("Level 2 Category : Kotlin What is Norton?","Anitivirus","Browser page","Vaccine","Program","Anitivirus"
                ,TriviaQuestion.CATEGORY_KOTLIN,2);
        addQuestions(q2b8);

        TriviaQuestion q2b9= new TriviaQuestion("Level 2 Category : Kotlin Who is the inventor of www?","Bill Gates","Tim Berners-Lee","Timothy Bil","Ray Tomlinson","Tim Berners-Lee"
                ,TriviaQuestion.CATEGORY_KOTLIN,2);
        addQuestions(q2b9);

        TriviaQuestion q1b0= new TriviaQuestion(" Level 2 Category : Kotlin Ethernet is an example of ","MAN","LAN","WAN","Wi-Fi","LAN"
                ,TriviaQuestion.CATEGORY_KOTLIN,2);
        addQuestions(q1b0);

        TriviaQuestion q12b1= new TriviaQuestion("Level 2 Category : Kotlin HTML is used to create","Operating System","High Level Program","Web-Server","Web Page","Web Page"
                ,TriviaQuestion.CATEGORY_KOTLIN,2);
        addQuestions(q12b1);

        TriviaQuestion q12b2= new TriviaQuestion("Level 2 Category : Kotlin Speed of internet connection is measured in","GHz","dpi","ppm","Gbps","Gbps"
                ,TriviaQuestion.CATEGORY_KOTLIN,2);
        addQuestions(q12b2);



        TriviaQuestion q2b17= new TriviaQuestion("Level 3 Category : Kotlin DuckDuck Go is what ?","Search Engine","Browser page","Search page  ","Bookmark","Search Engine"
                ,TriviaQuestion.CATEGORY_KOTLIN,3);
        addQuestions(q2b17);

        TriviaQuestion q2b18= new TriviaQuestion("Level 3 Category : Kotlin What is Norton?","Anitivirus","Browser page","Vaccine","Program","Anitivirus"
                ,TriviaQuestion.CATEGORY_KOTLIN,3);
        addQuestions(q2b18);

        TriviaQuestion q2b19= new TriviaQuestion("Level 3 Category : Kotlin Who is the inventor of www?","Bill Gates","Tim Berners-Lee","Timothy Bil","Ray Tomlinson","Tim Berners-Lee"
                ,TriviaQuestion.CATEGORY_KOTLIN,3);
        addQuestions(q2b19);

        TriviaQuestion q1b10= new TriviaQuestion("Level 3 Category : Kotlin Ethernet is an example of ","MAN","LAN","WAN","Wi-Fi","LAN"
                ,TriviaQuestion.CATEGORY_KOTLIN,3);
        addQuestions(q1b10);

        TriviaQuestion q12b11= new TriviaQuestion("Level 3 Category : Kotlin HTML is used to create","Operating System","High Level Program","Web-Server","Web Page","Web Page"
                ,TriviaQuestion.CATEGORY_KOTLIN,3);
        addQuestions(q12b11);

        TriviaQuestion q12b12= new TriviaQuestion("Level 3 Category : Kotlin Speed of internet connection is measured in","GHz","dpi","ppm","Gbps","Gbps"
                ,TriviaQuestion.CATEGORY_KOTLIN,3);
        addQuestions(q12b12);



        TriviaQuestion q21b17= new TriviaQuestion("Level 4 Category : Kotlin DuckDuck Go is what ?","Search Engine","Browser page","Search page  ","Bookmark","Search Engine"
                ,TriviaQuestion.CATEGORY_KOTLIN,4);
        addQuestions(q21b17);

        TriviaQuestion q21b18= new TriviaQuestion("Level 4 Category : Kotlin What is Norton?","Anitivirus","Browser page","Vaccine","Program","Anitivirus"
                ,TriviaQuestion.CATEGORY_KOTLIN,4);
        addQuestions(q21b18);

        TriviaQuestion q21b19= new TriviaQuestion("Level 4 Category : Kotlin Who is the inventor of www?","Bill Gates","Tim Berners-Lee","Timothy Bil","Ray Tomlinson","Tim Berners-Lee"
                ,TriviaQuestion.CATEGORY_KOTLIN,4);
        addQuestions(q21b19);

        TriviaQuestion q11b10= new TriviaQuestion("Level 4 Category : Kotlin Ethernet is an example of ","MAN","LAN","WAN","Wi-Fi","LAN"
                ,TriviaQuestion.CATEGORY_KOTLIN,4);
        addQuestions(q11b10);

        TriviaQuestion q121b11= new TriviaQuestion("Level 4 Category : Kotlin HTML is used to create","Operating System","High Level Program","Web-Server","Web Page","Web Page"
                ,TriviaQuestion.CATEGORY_KOTLIN,4);
        addQuestions(q121b11);

        TriviaQuestion q121b12= new TriviaQuestion("Level 4 Category : Kotlin Speed of internet connection is measured in","GHz","dpi","ppm","Gbps","Gbps"
                ,TriviaQuestion.CATEGORY_KOTLIN,4);
        addQuestions(q121b12);




        TriviaQuestion q21b17d= new TriviaQuestion("Level 5 Category : Kotlin DuckDuck Go is what ?","Search Engine","Browser page","Search page  ","Bookmark","Search Engine"
                ,TriviaQuestion.CATEGORY_KOTLIN,5);
        addQuestions(q21b17d);

        TriviaQuestion q21b18d= new TriviaQuestion("Level 5 Category : Kotlin What is Norton?","Anitivirus","Browser page","Vaccine","Program","Anitivirus"
                ,TriviaQuestion.CATEGORY_KOTLIN,5);
        addQuestions(q21b18d);

        TriviaQuestion q21b19d= new TriviaQuestion("Level 5 Category : Kotlin Who is the inventor of www?","Bill Gates","Tim Berners-Lee","Timothy Bil","Ray Tomlinson","Tim Berners-Lee"
                ,TriviaQuestion.CATEGORY_KOTLIN,5);
        addQuestions(q21b19d);

        TriviaQuestion q11b10d= new TriviaQuestion("Level 5 Category : Kotlin Ethernet is an example of ","MAN","LAN","WAN","Wi-Fi","LAN"
                ,TriviaQuestion.CATEGORY_KOTLIN,5);
        addQuestions(q11b10d);

        TriviaQuestion q121b11d= new TriviaQuestion("Level 5 Category : Kotlin HTML is used to create","Operating System","High Level Program","Web-Server","Web Page","Web Page"
                ,TriviaQuestion.CATEGORY_KOTLIN,5);
        addQuestions(q121b11d);

        TriviaQuestion q121b12d= new TriviaQuestion("Level 5 Category : Kotlin Speed of internet connection is measured in","GHz","dpi","ppm","Gbps","Gbps"
                ,TriviaQuestion.CATEGORY_KOTLIN,5);
        addQuestions(q121b12d);




        TriviaQuestion qa21b17d= new TriviaQuestion("Level 6 Category : Kotlin DuckDuck Go is what ?","Search Engine","Browser page","Search page  ","Bookmark","Search Engine"
                ,TriviaQuestion.CATEGORY_KOTLIN,6);
        addQuestions(qa21b17d);

        TriviaQuestion qa21b18d= new TriviaQuestion("Level 6 Category : Kotlin What is Norton?","Anitivirus","Browser page","Vaccine","Program","Anitivirus"
                ,TriviaQuestion.CATEGORY_KOTLIN,6);
        addQuestions(qa21b18d);

        TriviaQuestion qa21b19d= new TriviaQuestion("Level 6 Category : Kotlin Who is the inventor of www?","Bill Gates","Tim Berners-Lee","Timothy Bil","Ray Tomlinson","Tim Berners-Lee"
                ,TriviaQuestion.CATEGORY_KOTLIN,6);
        addQuestions(qa21b19d);

        TriviaQuestion qa11b10d= new TriviaQuestion("Level 6 Category : Kotlin Ethernet is an example of ","MAN","LAN","WAN","Wi-Fi","LAN"
                ,TriviaQuestion.CATEGORY_KOTLIN,6);
        addQuestions(qa11b10d);

        TriviaQuestion qa121b11d= new TriviaQuestion("Level 6 Category : Kotlin HTML is used to create","Operating System","High Level Program","Web-Server","Web Page","Web Page"
                ,TriviaQuestion.CATEGORY_KOTLIN,6);
        addQuestions(qa121b11d);

        TriviaQuestion qa121b12d= new TriviaQuestion("Level 6 Category : Kotlin Speed of internet connection is measured in","GHz","dpi","ppm","Gbps","Gbps"
                ,TriviaQuestion.CATEGORY_KOTLIN,6);
        addQuestions(qa121b12d);



        TriviaQuestion a = new TriviaQuestion("Level 6 Category : Python DuckDuck Go is what ?","Search Engine","Browser page","Search page  ","Bookmark","Search Engine"
                ,TriviaQuestion.CATEGORY_PYTHON,6);
        addQuestions(a);

        TriviaQuestion b = new TriviaQuestion("Level 6 Category : Python What is Norton?","Anitivirus","Browser page","Vaccine","Program","Anitivirus"
                ,TriviaQuestion.CATEGORY_PYTHON,6);
        addQuestions(b);

        TriviaQuestion c = new TriviaQuestion("Level 6 Category : Python Who is the inventor of www?","Bill Gates","Tim Berners-Lee","Timothy Bil","Ray Tomlinson","Tim Berners-Lee"
                ,TriviaQuestion.CATEGORY_PYTHON,6);
        addQuestions(c);

        TriviaQuestion d = new TriviaQuestion("Level 6 Category : Python Ethernet is an example of ","MAN","LAN","WAN","Wi-Fi","LAN"
                ,TriviaQuestion.CATEGORY_PYTHON,6);
        addQuestions(d);

        TriviaQuestion f = new TriviaQuestion("Level 6 Category : Python HTML is used to create","Operating System","High Level Program","Web-Server","Web Page","Web Page"
                ,TriviaQuestion.CATEGORY_PYTHON,6);
        addQuestions(f);

        TriviaQuestion g = new TriviaQuestion("Level 6 Category : Python Speed of internet connection is measured in","GHz","dpi","ppm","Gbps","Gbps"
                ,TriviaQuestion.CATEGORY_PYTHON,6);
        addQuestions(g);


        TriviaQuestion a1 = new TriviaQuestion("Level 5 Category : Python DuckDuck Go is what ?","Search Engine","Browser page","Search page  ","Bookmark","Search Engine"
                ,TriviaQuestion.CATEGORY_PYTHON,5);
        addQuestions(a1);

        TriviaQuestion b1 = new TriviaQuestion("Level 5 Category : Python What is Norton?","Anitivirus","Browser page","Vaccine","Program","Anitivirus"
                ,TriviaQuestion.CATEGORY_PYTHON,5);
        addQuestions(b1);

        TriviaQuestion c1 = new TriviaQuestion("Level 5 Category : Python Who is the inventor of www?","Bill Gates","Tim Berners-Lee","Timothy Bil","Ray Tomlinson","Tim Berners-Lee"
                ,TriviaQuestion.CATEGORY_PYTHON,5);
        addQuestions(c1);

        TriviaQuestion d1 = new TriviaQuestion("Level 5 Category : Python Ethernet is an example of ","MAN","LAN","WAN","Wi-Fi","LAN"
                ,TriviaQuestion.CATEGORY_PYTHON,5);
        addQuestions(d1);

        TriviaQuestion f1 = new TriviaQuestion("Level 5 Category : Python HTML is used to create","Operating System","High Level Program","Web-Server","Web Page","Web Page"
                ,TriviaQuestion.CATEGORY_PYTHON,5);
        addQuestions(f1);

        TriviaQuestion g1 = new TriviaQuestion("Level 5 Category : Python Speed of internet connection is measured in","GHz","dpi","ppm","Gbps","Gbps"
                ,TriviaQuestion.CATEGORY_PYTHON,5);
        addQuestions(g1);


        TriviaQuestion a11 = new TriviaQuestion("Level 4 Category : Python DuckDuck Go is what ?","Search Engine","Browser page","Search page  ","Bookmark","Search Engine"
                ,TriviaQuestion.CATEGORY_PYTHON,4);
        addQuestions(a11);

        TriviaQuestion b11 = new TriviaQuestion("Level 4 Category : Python What is Norton?","Anitivirus","Browser page","Vaccine","Program","Anitivirus"
                ,TriviaQuestion.CATEGORY_PYTHON,4);
        addQuestions(b11);

        TriviaQuestion c11 = new TriviaQuestion("Level 4 Category : Python Who is the inventor of www?","Bill Gates","Tim Berners-Lee","Timothy Bil","Ray Tomlinson","Tim Berners-Lee"
                ,TriviaQuestion.CATEGORY_PYTHON,4);
        addQuestions(c11);

        TriviaQuestion d11 = new TriviaQuestion("Level 4 Category : Python Ethernet is an example of ","MAN","LAN","WAN","Wi-Fi","LAN"
                ,TriviaQuestion.CATEGORY_PYTHON,4);
        addQuestions(d11);

        TriviaQuestion f11 = new TriviaQuestion("Level 4 Category : Python HTML is used to create","Operating System","High Level Program","Web-Server","Web Page","Web Page"
                ,TriviaQuestion.CATEGORY_PYTHON,4);
        addQuestions(f11);

        TriviaQuestion g11 = new TriviaQuestion("Level 4 Category : Python Speed of internet connection is measured in","GHz","dpi","ppm","Gbps","Gbps"
                ,TriviaQuestion.CATEGORY_PYTHON,4);
        addQuestions(g11);


        TriviaQuestion a21 = new TriviaQuestion("Level 3 Category : Python DuckDuck Go is what ?","Search Engine","Browser page","Search page  ","Bookmark","Search Engine"
                ,TriviaQuestion.CATEGORY_PYTHON,3);
        addQuestions(a21);

        TriviaQuestion b21 = new TriviaQuestion("Level 3 Category : Python What is Norton?","Anitivirus","Browser page","Vaccine","Program","Anitivirus"
                ,TriviaQuestion.CATEGORY_PYTHON,3);
        addQuestions(b21);

        TriviaQuestion c21 = new TriviaQuestion("Level 3 Category : Python Who is the inventor of www?","Bill Gates","Tim Berners-Lee","Timothy Bil","Ray Tomlinson","Tim Berners-Lee"
                ,TriviaQuestion.CATEGORY_PYTHON,3);
        addQuestions(c21);

        TriviaQuestion d21 = new TriviaQuestion("Level 3 Category : Python Ethernet is an example of ","MAN","LAN","WAN","Wi-Fi","LAN"
                ,TriviaQuestion.CATEGORY_PYTHON,3);
        addQuestions(d21);

        TriviaQuestion f21 = new TriviaQuestion("Level 3 Category : Python HTML is used to create","Operating System","High Level Program","Web-Server","Web Page","Web Page"
                ,TriviaQuestion.CATEGORY_PYTHON,3);
        addQuestions(f21);

        TriviaQuestion g21 = new TriviaQuestion("Level 3 Category : Python Speed of internet connection is measured in","GHz","dpi","ppm","Gbps","Gbps"
                ,TriviaQuestion.CATEGORY_PYTHON,3);
        addQuestions(g21);


        TriviaQuestion a211 = new TriviaQuestion("Level 2 Category : Python DuckDuck Go is what ?","Search Engine","Browser page","Search page  ","Bookmark","Search Engine"
                ,TriviaQuestion.CATEGORY_PYTHON,2);
        addQuestions(a211);

        TriviaQuestion b211 = new TriviaQuestion("Level 2 Category : Python What is Norton?","Anitivirus","Browser page","Vaccine","Program","Anitivirus"
                ,TriviaQuestion.CATEGORY_PYTHON,2);
        addQuestions(b211);

        TriviaQuestion c221 = new TriviaQuestion("Level 2 Category : Python Who is the inventor of www?","Bill Gates","Tim Berners-Lee","Timothy Bil","Ray Tomlinson","Tim Berners-Lee"
                ,TriviaQuestion.CATEGORY_PYTHON,2);
        addQuestions(c221);

        TriviaQuestion d221 = new TriviaQuestion("Level 2 Category : Python Ethernet is an example of ","MAN","LAN","WAN","Wi-Fi","LAN"
                ,TriviaQuestion.CATEGORY_PYTHON,2);
        addQuestions(d221);

        TriviaQuestion f221 = new TriviaQuestion("Level 2 Category : Python HTML is used to create","Operating System","High Level Program","Web-Server","Web Page","Web Page"
                ,TriviaQuestion.CATEGORY_PYTHON,2);
        addQuestions(f221);

        TriviaQuestion g221 = new TriviaQuestion("Level 2 Category : Python Speed of internet connection is measured in","GHz","dpi","ppm","Gbps","Gbps"
                ,TriviaQuestion.CATEGORY_PYTHON,2);
        addQuestions(g221);


        TriviaQuestion ba211 = new TriviaQuestion("Level 1 Category : Python DuckDuck Go is what ?","Search Engine","Browser page","Search page  ","Bookmark","Search Engine"
                ,TriviaQuestion.CATEGORY_PYTHON,1);
        addQuestions(ba211);

        TriviaQuestion bb211 = new TriviaQuestion("Level 1 Category : Python What is Norton?","Anitivirus","Browser page","Vaccine","Program","Anitivirus"
                ,TriviaQuestion.CATEGORY_PYTHON,1);
        addQuestions(bb211);

        TriviaQuestion bc221 = new TriviaQuestion("Level 1 Category : Python Who is the inventor of www?","Bill Gates","Tim Berners-Lee","Timothy Bil","Ray Tomlinson","Tim Berners-Lee"
                ,TriviaQuestion.CATEGORY_PYTHON,1);
        addQuestions(bc221);

        TriviaQuestion bd221 = new TriviaQuestion("Level 1 Category : Python Ethernet is an example of ","MAN","LAN","WAN","Wi-Fi","LAN"
                ,TriviaQuestion.CATEGORY_PYTHON,1);
        addQuestions(bd221);

        TriviaQuestion bf221 = new TriviaQuestion("Level 1 Category : Python HTML is used to create","Operating System","High Level Program","Web-Server","Web Page","Web Page"
                ,TriviaQuestion.CATEGORY_PYTHON,1);
        addQuestions(bf221);

        TriviaQuestion bg221 = new TriviaQuestion("Level 1 Category : Python Speed of internet connection is measured in","GHz","dpi","ppm","Gbps","Gbps"
                ,TriviaQuestion.CATEGORY_PYTHON,1);
        addQuestions(bg221);



    }

    private void addQuestions(TriviaQuestion question){

        ContentValues cv = new ContentValues();
        cv.put(QuestionTable.COLUMN_QUESTION,question.getQuestion());
        cv.put(QuestionTable.COLUMN_OPTION1,question.getOption1());
        cv.put(QuestionTable.COLUMN_OPTION2,question.getOption2());
        cv.put(QuestionTable.COLUMN_OPTION3,question.getOption3());
        cv.put(QuestionTable.COLUMN_OPTION4,question.getOption4());
        cv.put(QuestionTable.COLUMN_ANSWER_NR,question.getAnswerNr());
        cv.put(QuestionTable.COLUMN_CATEGORY,question.getCategory());
        cv.put(QuestionTable.COLUMN_LEVELS_ID,question.getLevels());
        db.insert(QuestionTable.TABLE_NAME,null,cv);

    }

    public ArrayList<TriviaQuestion> getAllQuestions() {

        ArrayList<TriviaQuestion> questionList = new ArrayList<>();
        db = getReadableDatabase();



        String Projection[] = {

                QuestionTable._ID,
                QuestionTable.COLUMN_QUESTION,
                QuestionTable.COLUMN_OPTION1,
                QuestionTable.COLUMN_OPTION2,
                QuestionTable.COLUMN_OPTION3,
                QuestionTable.COLUMN_OPTION4,
                QuestionTable.COLUMN_ANSWER_NR
        };



            Cursor c = db.query(QuestionTable.TABLE_NAME,
                    Projection,
                    null,
                    null,
                    null,
                    null,
                    null);


            if (c.moveToFirst()) {
                do {

                    TriviaQuestion question = new TriviaQuestion();
                    question.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                    question.setOption1(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                    question.setOption2(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                    question.setOption3(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                    question.setOption4(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION4)));
                    question.setAnswerNr(c.getString(c.getColumnIndex(QuestionTable.COLUMN_ANSWER_NR)));

                    questionList.add(question);

                } while (c.moveToNext());

            }
            c.close();
            return questionList;
        }

    public ArrayList<TriviaQuestion> getQuestionsWithCategory(String Category) {

        ArrayList<TriviaQuestion> questionList = new ArrayList<>();
        db = getReadableDatabase();



        String Projection[] = {

                QuestionTable._ID,
                QuestionTable.COLUMN_QUESTION,
                QuestionTable.COLUMN_OPTION1,
                QuestionTable.COLUMN_OPTION2,
                QuestionTable.COLUMN_OPTION3,
                QuestionTable.COLUMN_OPTION4,
                QuestionTable.COLUMN_ANSWER_NR,
                QuestionTable.COLUMN_CATEGORY
        };

        String selection = QuestionTable.COLUMN_CATEGORY + " = ? ";
        String selectionArgs[] = {Category};


        Cursor c = db.query(QuestionTable.TABLE_NAME,
                Projection,
                selection,
                selectionArgs,
                null,
                null,
                null);


        if (c.moveToFirst()) {
            do {

                TriviaQuestion question = new TriviaQuestion();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getString(c.getColumnIndex(QuestionTable.COLUMN_ANSWER_NR)));
                question.setCategory(c.getString(c.getColumnIndex(QuestionTable.COLUMN_CATEGORY)));

                questionList.add(question);

            } while (c.moveToNext());

        }
        c.close();
        return questionList;
    }


    public ArrayList<TriviaQuestion> getQuestionsByLevelsAndCategory(String Category, int LevelsID) {

        ArrayList<TriviaQuestion> questionList = new ArrayList<>();
        db = getReadableDatabase();



        String Projection[] = {

                QuestionTable._ID,
                QuestionTable.COLUMN_QUESTION,
                QuestionTable.COLUMN_OPTION1,
                QuestionTable.COLUMN_OPTION2,
                QuestionTable.COLUMN_OPTION3,
                QuestionTable.COLUMN_OPTION4,
                QuestionTable.COLUMN_ANSWER_NR,
                QuestionTable.COLUMN_CATEGORY,
                QuestionTable.COLUMN_LEVELS_ID
        };

        String selection = QuestionTable.COLUMN_LEVELS_ID + " = ? "
                + " AND " + QuestionTable.COLUMN_CATEGORY + " = ? ";

        String selectionArgs[] = new String[] {String.valueOf(LevelsID),Category};


        Cursor c = db.query(QuestionTable.TABLE_NAME,
                Projection,
                selection,
                selectionArgs,
                null,
                null,
                null);


        if (c.moveToFirst()) {
            do {

                TriviaQuestion question = new TriviaQuestion();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getString(c.getColumnIndex(QuestionTable.COLUMN_ANSWER_NR)));
                question.setCategory(c.getString(c.getColumnIndex(QuestionTable.COLUMN_CATEGORY)));
                question.setLevels(c.getInt(c.getColumnIndex(QuestionTable.COLUMN_LEVELS_ID)));
                questionList.add(question);

            } while (c.moveToNext());

        }
        c.close();
        return questionList;
    }

}


