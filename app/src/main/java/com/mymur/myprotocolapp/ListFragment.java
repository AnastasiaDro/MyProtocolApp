package com.mymur.myprotocolapp;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class ListFragment extends Fragment implements Observer  {
    int position;
    ArrayList<String> mTextSet;
    int listTitleKey;
    TextView listTitleTextView;
    MaterialButton addNewBtn;
    int placeId;
    Fragment fragment;

    //Класс с данными
    private MyDataClass myDataClass;

  //  public ListFragment (ArrayList <String> mTextSet, ArrayList <Integer> mImageIdSet) {
           public ListFragment (ArrayList <String> mTextSet, int listTitleKey, MyDataClass myDataClass, int placeId) {
        this.mTextSet = mTextSet;
     //   this.mImageIdSet = mImageIdSet;
        this.setRetainInstance(true);
        this.listTitleKey = listTitleKey;
        this.myDataClass = myDataClass;
        this.placeId = placeId;
        myDataClass.registerObserver(this);
        fragment = this;
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View view = inflater.inflate(R.layout.fragment_list, container, false);
        final RecyclerView recyclerView = view.findViewById(R.id.recyclerForFragment);
        addNewBtn = view.findViewById(R.id.addNewBtn);
        addNewBtn.setOnClickListener(madeOnAddNewClickListener(recyclerView));
        makeListTitle(view);
        recyclerView.setHasFixedSize(true);
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


    public void postFragment(AppCompatActivity activity){
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(placeId, this);
        ft.commit();

    }

    //задает название списку
    public void makeListTitle(View view){
        listTitleTextView = view.findViewById(R.id.listTitleText);
        listTitleTextView.setText(listTitleKey);
    }


    //метод создания кликЛистенера для кнопки addNew
    public View.OnClickListener madeOnAddNewClickListener(final RecyclerView recyclerView) {
        View.OnClickListener addNewClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Context context = v.getContext();
                final EditText input = new EditText(context);
                createInputDialog(recyclerView, input, context);

            }
        };
        return addNewClickListener;
    }

    //делаем диалог с юзером
    private void createInputDialog(final RecyclerView recyclerView, final EditText input, Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.enter_name);
        builder.setView(input);
        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String myInputString = input.getText().toString();

               // MyDataClass.addToNamesArray(myInputString);
                myDataClass.setData(mTextSet, myInputString);
                reDrawFragment(fragment);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }

        @Override
    public void update(ArrayList <String> stringArrayList, String newString) {
               stringArrayList.add(newString);
        }

        public void reDrawFragment(Fragment fragment){
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.detach(fragment);
            ft.attach(fragment);
            ft.commit();
        }




}


