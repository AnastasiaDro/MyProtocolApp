package com.mymur.myprotocolapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private String[] namesArr;
    private ArrayList <String> namesArray;
    private SharedPreferences myPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //сохранение массива с именами
        myPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);


        setContentView(R.layout.activity_main1);
        namesArr = getResources().getStringArray(R.array.myStudents);
        namesArray = new ArrayList<>();

        for (int i = 0; i < namesArr.length; i++) {
            namesArray.add(namesArr[i]);
        }


        Bundle bundle = new Bundle();
        bundle.putInt("CurrentChildPosition", 0);
//        bundle.putIntegerArrayList("mTextSet", facesArr);

      //  ListFragment fragment = new ListFragment(namesArray, facesArr);
        ListFragment fragment = new ListFragment(namesArray,  Constants.MAIN_ACTIVITY_TITLE);
        fragment.setArguments(bundle);
        fragment.postFragment(R.id.placeholder, this);

        }


}

