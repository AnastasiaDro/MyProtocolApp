package com.mymur.myprotocolapp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyDataClass implements Observable {


    private List <Observer> observers;
    private ArrayList <String> namesArray;
  //  private ArrayList <String> trialsArray;
    String newString;

    public MyDataClass() {
        namesArray = new ArrayList<>();
       // trialsArray = new ArrayList<>()
        observers = new LinkedList<>();
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
//        switch (ConstantsActivityTitle){
//            case (Constants.MAIN_ACTIVITY_TITLE):
//                for (Observer observer : observers) {
//                    observer.update(namesArray, newString);
//                }
//             break;
//            case (Constants.PROTOCOL_ACTIVITY_TITLE):
//                    for (Observer observer : observers) {
//                 observer.update(trialsArray, newString);
//             }
//             break;
//             }
        for (Observer observer : observers) {
            observer.update(namesArray, newString);
        }
        }


    public void setData(ArrayList <String> namesArray, String newString) {
        this.namesArray = namesArray;
        this.newString = newString;
        notifyObservers();
    }
}
