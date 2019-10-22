package com.mymur.myprotocolapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
  //  private String[] namesArr;
    private ArrayList <String> namesArray;
    private ArrayList <String> trialsArray;
    private SharedPreferences myPreferences;
    private MySaver mySaver;

    //База данных
   MyDbSaver dbSaver;

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

     //  mySaver = new MySaver(MainActivity.this, myDataClass);

        //создаём базу данных



        setContentView(R.layout.activity_main1);
     //   namesArr = getResources().getStringArray(R.array.myStudents);
//        namesArray = new ArrayList<>();
//        trialsArray = new ArrayList<>();
        namesArray = myDataClass.getNamesArray();
        trialsArray = myDataClass.getTrialsArray();

//        for (int i = 0; i < namesArr.length; i++) {
//            namesArray.add(namesArr[i]);
//        }
       //namesArray = mySaver.getSavedStringArr(NAMES_KEY);

        //получим имена учеников и названия проб из  базы данных
//        namesArray = dbSaver.getStudentsNames();
//        trialsArray = dbSaver.getTrialsNames();

        Bundle bundle = new Bundle();
        bundle.putInt("CurrentChildPosition", 0);
//        bundle.putIntegerArrayList("mTextSet", facesArr);

      //  ListFragment fragment = new ListFragment(namesArray, facesArr);
        ListFragment fragment = new ListFragment(namesArray,  Constants.MAIN_ACTIVITY_TITLE, myDataClass, R.id.placeholder, trialsArray);
        //ListFragment fragment = new ListFragment(myDataClass.namesArray,  Constants.MAIN_ACTIVITY_TITLE);
        fragment.setArguments(bundle);
        fragment.postFragment(this);

        }

//        @Override
//    protected void onStop(){
//        super.onStop();
//      //  mySaver.saveStringsArr(NAMES_KEY, namesArray)
//            myDataClass.getMyDbSaver().saveStudentsToDb();
//
//        }
    @Override
    protected void onPause() {
        super.onPause();
        myDataClass.getMyDbSaver().saveStudentsToDb();
    }
}

