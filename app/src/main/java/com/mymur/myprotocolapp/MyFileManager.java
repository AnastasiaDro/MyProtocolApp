package com.mymur.myprotocolapp;


//Класс для записи, загрузки и выгрузки данных из файла

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MyFileManager {
    FileInputStream fileArrNameStream;
    FileInputStream fileArrayTrialsForEachName;
    ArrayList <String> studentsNameArr;

    public MyFileManager() {


    }

    public ArrayList<String> getStudentsList() {
        studentsNameArr = new ArrayList();
        try {
            fileArrNameStream = new FileInputStream("list_of_students");
        } catch (FileNotFoundException e) {
            System.out.println("Невозможно открыть файл");
            File list_of_students = new File("");
        }

        //читаем данные из файла
        try {
            int i;
            String newName = null;
            String subString;
            do {
                i = fileArrNameStream.read();
                if (i != -1) {
                    subString = String.valueOf((char)i);
                    if (subString != "\n") {
                        newName = newName.concat(subString);
                    } else {
         //добавляем получившуюся строку с именем в массив имен
                        studentsNameArr.add(newName);
                        newName = null;
                    }
                }
            } while (i !=-1);
        } catch (IOException e) {
            System.out.println("Ошибка чтения из файла");
        }
        try {
            fileArrNameStream.close();
        } catch (IOException e){
            System.out.println("ошибка закрытия файла");
        }
        System.out.println(studentsNameArr.toString());
        return  studentsNameArr;
    }





}
