package com.mymur.myprotocolapp;

import android.app.Activity;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyDataClass implements Observable{


    private List <Observer> observers;
    private ArrayList <String> namesArray;
    private ArrayList <String> trialsArray;
    String newString;
    private MyDbSaver myDbSaver;


    public ArrayList<String> getNamesArray() {
        return namesArray;
    }

    public ArrayList<String> getTrialsArray() {
        return trialsArray;
    }

    public MyDbSaver getMyDbSaver() {
        return myDbSaver;
    }

    public MyDataClass(Activity activity) {
        namesArray = new ArrayList<>();
        trialsArray = new ArrayList<>();
        myDbSaver = new MyDbSaver(this, activity);
        observers = new LinkedList<>();
        namesArray = myDbSaver.getStudentsNames();
        trialsArray = myDbSaver.getTrialsNames();
        registerObserver(myDbSaver);
    }



    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(newString);
        }
        }


    public void setData(ArrayList <String> namesArray, String newString) {
        this.namesArray = namesArray;
        this.newString = newString;
        System.out.println("Список наблюдателей " + observers.toString());
        notifyObservers();
    }
}
