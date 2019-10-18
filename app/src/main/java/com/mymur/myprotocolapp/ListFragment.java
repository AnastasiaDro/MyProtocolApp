package com.mymur.myprotocolapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListFragment extends Fragment  {
    int position;
    ArrayList<String> mTextSet;
    ArrayList <Integer> mImageIdSet;

    int listTitleKey;
    TextView listTitleTextView;

  //  public ListFragment (ArrayList <String> mTextSet, ArrayList <Integer> mImageIdSet) {
           public ListFragment (ArrayList <String> mTextSet, int listTitleKey) {
        this.mTextSet = mTextSet;
     //   this.mImageIdSet = mImageIdSet;
        this.setRetainInstance(true);

        this.listTitleKey = listTitleKey;
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerForFragment);
        makeListTitle(view);
        //recyclerView.setHasFixedSize(true);
       // MyAdapter myAdapter = new MyAdapter(mTextSet, mImageIdSet);
        MyAdapter myAdapter = new MyAdapter(mTextSet, listTitleKey);
        recyclerView.setAdapter(myAdapter);
        RecyclerView.LayoutManager layoutManager  = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }




    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("CurrentChildPosition", position);
    }
    //Обработчик нажатия кнопки Add New
    public void addNewClick(View v) {
        v = this.getView();
    }


    public void postFragment(int idPlaceHolder, AppCompatActivity activity){
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(idPlaceHolder, this);
        ft.commit();

    }

    //задает название списку
    public void makeListTitle(View view){
        listTitleTextView = view.findViewById(R.id.listTitleText);
        listTitleTextView.setText(listTitleKey);
    }

}
