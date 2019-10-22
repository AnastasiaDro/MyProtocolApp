package com.mymur.myprotocolapp;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class MyDbSaver implements Observer {
    private MyDataClass myDataClass;
    private SQLiteDatabase myDb;
    private Activity activity;
    int ACTIVITY_TITLE;
    ArrayList <String> studentsNamesArr;
    ArrayList <String> trialsNamesArr;
    ArrayList <String> newStudentsNamesArr;
    ArrayList <String> newTrialsArr;




    public void setACTIVITY_TITLE(int ACTIVITY_TITLE) {
        this.ACTIVITY_TITLE = ACTIVITY_TITLE;
    }

    public MyDbSaver(MyDataClass myDataClass, Activity activity) {
        this.activity = activity;
        this.myDataClass = myDataClass;
        makeNewDb();
        studentsNamesArr = new ArrayList<>();
        trialsNamesArr = new ArrayList<>();
        newStudentsNamesArr = new ArrayList<>();
        newTrialsArr = new ArrayList<>();

    }

    public void makeNewDb(){
        turnONdataBase();
        createTablesForDb();
        turnOFFdataBase();
    }

    public void turnONdataBase() {
        myDb = activity.openOrCreateDatabase("my.db", MODE_PRIVATE, null);
    }


    public void turnOFFdataBase() {
        myDb.close();
    }

    public void createTablesForDb(){
        //clearBd(myDb);
        myDb.execSQL("CREATE TABLE IF NOT EXISTS Students (id_student INT, name VARCHAR(40))");
        myDb.execSQL("CREATE TABLE IF NOT EXISTS Trials (id_trial INT, name VARCHAR(20))");
        myDb.execSQL("CREATE TABLE IF NOT EXISTS practisingSet(id_practising INT, date TEXT, id_student INT, id_trial INT, trial_number_times, ideal_times, with_hit_times, bad_times)");
    }

    @Override
    public void update(String newString) {
        if (ACTIVITY_TITLE == Constants.MAIN_ACTIVITY_TITLE) {
            newStudentsNamesArr.add(newString);
        } else if (ACTIVITY_TITLE == Constants.PROTOCOL_ACTIVITY_TITLE) {
            newTrialsArr.add(newString);
        }
    }


    //метод получения массива имен из БД
    public ArrayList<String> getStudentsNames() {
        turnONdataBase();
        Cursor myCursor = myDb.rawQuery("select name from Students", null);
        while (myCursor.moveToNext()) {
            studentsNamesArr.add(myCursor.getString(0));
        }
        return studentsNamesArr;
    }

    //метод получения массива проб из БД
    public ArrayList<String> getTrialsNames() {
        Cursor myCursor = myDb.rawQuery("select name from Trials", null);
        while (myCursor.moveToNext()) {
            trialsNamesArr.add(myCursor.getString(0));
        }
        turnOFFdataBase();
        return trialsNamesArr;
    }

    public void saveStudentsToDb() {
        if (ACTIVITY_TITLE == Constants.MAIN_ACTIVITY_TITLE) {
            ContentValues studentRow = new ContentValues();
            String studentName;
            turnONdataBase();
            for (int i = 0; i < newStudentsNamesArr.size(); i++) {
                studentName = newStudentsNamesArr.get(i);
                studentRow.put("id_student", i + 1);
                studentRow.put("name", studentName);
                myDb.insert("Students", null, studentRow);
            }
            turnOFFdataBase();
        }
    }
    public void saveTrialsToDb() {
       if (ACTIVITY_TITLE == Constants.PROTOCOL_ACTIVITY_TITLE) {
           ContentValues trialRow = new ContentValues();
           String trialName;
           turnONdataBase();
           for (int i = 0; i < newTrialsArr.size(); i++) {
               trialName = newTrialsArr.get(i);
               trialRow.put("id_trial", i + 1);
               trialRow.put("name", trialName);
               myDb.insert("Trials", null, trialRow);
           }
           turnOFFdataBase();
        }
    }

    private void clearBd(SQLiteDatabase myDb) {
        myDb.delete("Students", null, null);
        myDb.delete("Trials", null, null);
    }

}
