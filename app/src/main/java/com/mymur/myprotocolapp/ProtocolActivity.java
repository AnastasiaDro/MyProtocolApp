package com.mymur.myprotocolapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class ProtocolActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private String[] trialsArr;
    private ArrayList<String> trialsArray;
    private MyDataClass myDataClass;
//    private ArrayList <Integer>  imgArr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myDataClass = MainActivity.getMyDataClass();
        myDataClass.getMyDbSaver().setACTIVITY_TITLE(Constants.PROTOCOL_ACTIVITY_TITLE);

        setContentView(R.layout.activity_protocol);

        trialsArray = getIntent().getStringArrayListExtra("TrialsArray");

        Bundle bundle = new Bundle();
        bundle.putInt("CurrentChildPosition", 0);
        //  bundle.putIntegerArrayList("mTextSet", );


        ListFragment fragment = new ListFragment(trialsArray, Constants.PROTOCOL_ACTIVITY_TITLE, myDataClass, R.id.placeholderForList, trialsArray);
        fragment.setArguments(bundle);
        fragment.postFragment(this);


    }

//    @Override
//    protected void onStop() {
//        super.onStop();
//        myDataClass.getMyDbSaver().saveTrialsToDb();
//    }

    @Override
    protected void onPause() {
        super.onPause();
        myDataClass.getMyDbSaver().saveTrialsToDb();
    }
}


