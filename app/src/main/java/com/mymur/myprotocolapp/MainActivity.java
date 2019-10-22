package com.mymur.myprotocolapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ArrayList <String> namesArray;
    private ArrayList <String> trialsArray;
    public static final String NAMES_KEY = "NAMES_KEY";
    private static MyDataClass myDataClass;
    public static MyDataClass getMyDataClass() {
        return myDataClass;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDataClass = new MyDataClass(this);
        myDataClass.getMyDbSaver().setACTIVITY_TITLE(Constants.MAIN_ACTIVITY_TITLE);

        setContentView(R.layout.activity_main1);
//забираем массивы имен и проб из базы
        namesArray = myDataClass.getNamesArray();
        trialsArray = myDataClass.getTrialsArray();

        Bundle bundle = new Bundle();
        bundle.putInt("CurrentChildPosition", 0);


    //Создаём фрагмент со списком
        ListFragment fragment = new ListFragment(namesArray,  Constants.MAIN_ACTIVITY_TITLE, myDataClass, R.id.placeholder, trialsArray);
        fragment.setArguments(bundle);
        fragment.postFragment(this);

        }

    @Override
    protected void onPause() {
        super.onPause();
        myDataClass.getMyDbSaver().saveStudentsToDb();
    }
}

