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
//    private ArrayList <Integer>  imgArr;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protocol);

        trialsArr = getResources().getStringArray(R.array.trials);
        trialsArray = new ArrayList<>();
//        imgArr = new <Integer> ArrayList();
        for (int i = 0; i < trialsArr.length; i++) {
            trialsArray.add(trialsArr[i]);

        }

//        imgArr.add(R.drawable.picture_1);
//        imgArr.add(R.drawable.picture_2);
//        imgArr.add(R.drawable.picture_3);

        Bundle bundle = new Bundle();
        bundle.putInt("CurrentChildPosition", 0);
      //  bundle.putIntegerArrayList("mTextSet", );


        ListFragment fragment = new ListFragment(trialsArray, Constants.PROTOCOL_ACTIVITY_KEY, Constants.PROTOCOL_ACTIVITY_TITLE);
        fragment.setArguments(bundle);
        fragment.postFragment(R.id.placeholderForList, this);

    }
}
