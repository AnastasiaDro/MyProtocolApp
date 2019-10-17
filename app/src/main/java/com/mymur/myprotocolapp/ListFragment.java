package com.mymur.myprotocolapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
    String mActivityName;

    public ListFragment (ArrayList <String> mTextSet, ArrayList <Integer> mImageIdSet, String mActivityName) {
        this.mTextSet = mTextSet;
        this.mImageIdSet = mImageIdSet;
        this.setRetainInstance(true);
        this.mActivityName = mActivityName;
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerForFragment);
        recyclerView.setHasFixedSize(true);
        MyAdapter myAdapter = new MyAdapter(mTextSet, mImageIdSet, mActivityName);
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


    //метод создания фрагмента сразу же с его отображением
    //должно указываться: ArrayList <String> mTextSet, ArrayList <Integer> mImageIdSet, String mActivityName
    //int id места, куда вставляется
    public void putListFragment(ListFragment fragment, int id, FragmentManager fragmentManager){
        //     fragment.setArguments(bundle);
        //FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(id, fragment);
        ft.commit();
    }

}
