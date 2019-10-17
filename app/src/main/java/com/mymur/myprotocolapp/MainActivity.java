package com.mymur.myprotocolapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;
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
    private ArrayList <Integer>  facesArr;
    private Button addNewButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //имя активности
        final String activityName = "MainActivity";
        setContentView(R.layout.activity_main1);
        namesArr = getResources().getStringArray(R.array.myStudents);
        namesArray = new ArrayList<>();
        facesArr = new <Integer> ArrayList();
        for (int i = 0; i < namesArr.length; i++) {
            namesArray.add(namesArr[i]);
        }

        facesArr.add(R.drawable.picture_1);
        facesArr.add(R.drawable.picture_2);
        facesArr.add(R.drawable.picture_3);

//        Bundle bundle = new Bundle();
//        bundle.putInt("CurrentChildPosition", 0);
//        bundle.putIntegerArrayList("mTextSet", facesArr);

        //код, который уберем в ListFragment.createListFragment()
        ListFragment fragment = new ListFragment(namesArray, facesArr, activityName);
//   //     fragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction ft = fragmentManager.beginTransaction();
//        ft.add(R.id.placeholder, fragment);
//        ft.commit();
        fragment.putListFragment(fragment, R.id.placeholder, fragmentManager);

        }

    //    //Обработчик нажатия кнопки Add New
    public void addNewClick(View view) {

    }

}
//        recyclerView = (RecyclerView) findViewById(R.id.recyclerStudents);
//        recyclerView.setHasFixedSize(true);
//
//        layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
//
//        mAdapter = new MyAdapter(namesArray, facesArr);
//        recyclerView.setAdapter(mAdapter);
//
//
//        addNewButton = findViewById(R.id.addNewButton);



//}
