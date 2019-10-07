package com.mymur.myprotocolapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

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
        setContentView(R.layout.activity_main);
        namesArr = getResources().getStringArray(R.array.myStudents);
        namesArray = new ArrayList<>();
        facesArr = new <Integer> ArrayList();
        for (int i = 0; i < namesArr.length; i++) {
            namesArray.add(namesArr[i]);
        }

        facesArr.add(R.drawable.picture_1);
        facesArr.add(R.drawable.picture_2);
        facesArr.add(R.drawable.picture_3);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerStudents);
        recyclerView.setScrollingTouchSlop(3);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new MyAdapter(namesArray, facesArr);
        recyclerView.setAdapter(mAdapter);


        addNewButton = findViewById(R.id.addNewButton);
    }

    //Обработчик нажатия кнопки Add New
    public void addNewClick(View view) {

    }

}
