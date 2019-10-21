package com.mymur.myprotocolapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

//Класс для сохранения массива строковых данных
//Мы используем для сохранения имен учеников

public class MySaver {
    SharedPreferences myPreferences;
    SharedPreferences.Editor myEditor;

    Set<String> stringSet;

    public MySaver(Context context) {
        myPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }
    public void saveStringsArr( String strings_key, ArrayList <String> stringsArr) {
        myEditor = myPreferences.edit();
        stringSet.addAll(stringsArr);
        myEditor.putStringSet(strings_key, stringSet);
        myEditor.commit();
    }

    public ArrayList <String> getSavedStringArr(String strings_key) {
        ArrayList <String> myArr = new ArrayList<>();
        stringSet = myPreferences.getStringSet(strings_key, Collections.singleton("список пуст"));
        myArr.addAll(stringSet);
        return myArr;
    }
}
