package com.mymur.myprotocolapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;
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




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        namesArr = getResources().getStringArray(R.array.myStudents);
        namesArray = new ArrayList<>();
        facesArr = new ArrayList();
        for (int i = 0; i < namesArr.length; i++) {
            namesArray.add(namesArr[i]);
        }


        facesArr.add(R.drawable.picture_1);
        facesArr.add(R.drawable.picture_2);
        facesArr.add(R.drawable.picture_3);



        recyclerView = (RecyclerView) findViewById(R.id.recyclerStudents);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new MyAdapter(stringArrayToTextView(namesArray), imageIdArrayToImageView(facesArr));
        recyclerView.setAdapter(mAdapter);


    }

    //преобразует строковый массив в TextView
    public ArrayList<TextView> stringArrayToTextView(ArrayList <String> arr){
        ArrayList <TextView> textViewArr = new ArrayList<>(arr.size());

        for (int i = 0; i < arr.size(); i++) {
            TextView textView = new TextView(this);
            textViewArr.add(textView);
            textViewArr.get(i).setText(arr.get(i));
        }

        return textViewArr;
    }

    //преобразует ссылку на картинку в картинку
    public ArrayList <ImageView> imageIdArrayToImageView (ArrayList<Integer> arr) {
        ArrayList <ImageView> imageViewArrayList = new ArrayList<>(arr.size());

        for (int i = 0; i < arr.size(); i++) {
            ImageView imageView = new ImageView(this);
            imageViewArrayList.add(imageView);
            imageViewArrayList.get(i).setImageResource(facesArr.get(i));
        }
    return imageViewArrayList;
    }
}
