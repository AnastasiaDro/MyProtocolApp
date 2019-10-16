package com.mymur.myprotocolapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class ProtocolActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private String[] trialsArr;
    private ArrayList<String> trialsArray;
    private ArrayList <Integer>  facesArr;
    private Button addNewButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protocol);

        trialsArr = getResources().getStringArray(R.array.trials);
        trialsArray = new ArrayList<>();
        facesArr = new <Integer> ArrayList();
        for (int i = 0; i < trialsArr.length; i++) {
            trialsArray.add(trialsArr[i]);
        }

        facesArr.add(R.drawable.picture_1);
        facesArr.add(R.drawable.picture_2);
        facesArr.add(R.drawable.picture_3);

        Bundle bundle = new Bundle();
        bundle.putInt("CurrentChildPosition", 0);
        bundle.putIntegerArrayList("mTextSet", facesArr);


        ListFragment fragment = new ListFragment(trialsArray, facesArr);
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(R.id.placeholderForList, fragment);
        ft.commit();


    }
}
