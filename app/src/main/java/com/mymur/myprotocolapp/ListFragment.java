package com.mymur.myprotocolapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

  //  public ListFragment (ArrayList <String> mTextSet, ArrayList <Integer> mImageIdSet) {
           public ListFragment (ArrayList <String> mTextSet) {
        this.mTextSet = mTextSet;
     //   this.mImageIdSet = mImageIdSet;
        this.setRetainInstance(true);
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerForFragment);
        //recyclerView.setHasFixedSize(true);
       // MyAdapter myAdapter = new MyAdapter(mTextSet, mImageIdSet);
        MyAdapter myAdapter = new MyAdapter(mTextSet);
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

}
