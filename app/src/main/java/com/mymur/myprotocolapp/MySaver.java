package com.mymur.myprotocolapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

//Класс для сохранения массива строковых данных
//Мы используем для сохранения имен учеников

public class MySaver implements Observer {
    SharedPreferences myPreferences;
    SharedPreferences.Editor myEditor;
    HashSet<String> stringSet;
    private MyDataClass myDataClass;


    public MySaver(Context context, MyDataClass myDataClass) {
        myPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        stringSet = new HashSet<>();
        this.myDataClass = myDataClass;
        myDataClass.registerObserver(this);
    }

    public void saveStringsArr( String strings_key, ArrayList <String> stringsArr) {
        myEditor = myPreferences.edit();
        stringSet = new HashSet<>();
        stringSet.addAll(stringsArr);
        myEditor.putStringSet(strings_key, stringSet);
        myEditor.commit();
    }

    public ArrayList <String> getSavedStringArr(String strings_key) {
        ArrayList <String> myArr = new ArrayList<>();
        stringSet = (HashSet)myPreferences.getStringSet(strings_key, null);
        try {
            myArr.addAll(stringSet);
        } catch (NullPointerException e) {
            return myArr;
        }
        return myArr;
    }

    @Override
    public void update(String newString) {
        ///????? WTF?!?!?!?!
//        ArrayList myArr= new ArrayList();
//        myArr.addAll(stringsArray);
//        myArr.add(newString);
//        stringSet.addAll(myArr);

    }
}
