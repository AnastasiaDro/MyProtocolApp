package com.mymur.myprotocolapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListFragment extends Fragment  {

    ArrayList<String> mTextSet;
    ArrayList <Integer> mImageIdSet;

    public ListFragment (ArrayList <String> mTextSet, ArrayList <Integer> mImageIdSet) {
        this.mTextSet = mTextSet;
        this.mImageIdSet = mImageIdSet;
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerForFragment);
        recyclerView.setHasFixedSize(true);
        MyAdapter myAdapter = new MyAdapter(mTextSet, mImageIdSet);
        recyclerView.setAdapter(myAdapter);
        RecyclerView.LayoutManager layoutManager  = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }

    //Обработчик нажатия кнопки Add New
    public void addNewClick(View v) {
        v = this.getView();
    }
}
