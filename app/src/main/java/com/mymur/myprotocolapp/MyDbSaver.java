package com.mymur.myprotocolapp;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;

import static android.content.Context.MODE_PRIVATE;

public class MyDbSaver implements Observer {
    private MyDataClass myDataClass;
    private SQLiteDatabase myDb;
    private Activity activity;

    public MyDbSaver(MyDataClass myDataClass, Activity activity) {
        this.myDataClass = myDataClass;
        this.activity = activity;

    }

    public void turnONdataBase() {
        myDb = activity.openOrCreateDatabase("my.db", MODE_PRIVATE, null);
    }

    public void turnOFFdataBase() {
        myDb.close();
    }

    public void createTablesForDb(){
        myDb.execSQL("CREATE TABLE IF NOT EXISTS Students (id_student INT, name VARCHAR(40))");
        myDb.execSQL("CREATE TABLE IF NOT EXISTS Trials (id_trial INT, name VARCHAR(20))");
        myDb.execSQL("CREATE TABLE IF NOT EXISTS practisingSet(id_practising INT, date TEXT, id_student INT, id_trial INT, trial_number_times, ideal_times, with_hit_times, bad_times)");
    }

    @Override
    public void update(ArrayList<String> stringsArray, String newString) {

    }
}
