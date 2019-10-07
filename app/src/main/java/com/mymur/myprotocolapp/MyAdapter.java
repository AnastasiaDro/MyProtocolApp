package com.mymur.myprotocolapp;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    ArrayList <String> mTextSet;
    ArrayList <Integer> mImageIdSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public ImageView imageView;
    public MyViewHolder(View v) {
        super(v);
        textView = v.findViewById(R.id.textName);
        imageView = v.findViewById(R.id.cardImage);
    }
    }

    //provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<String> myTextSet, ArrayList <Integer> myImageIdSet) {
        mTextSet = myTextSet;
        mImageIdSet = myImageIdSet;
    }

    //Create new views
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        //create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.linear_card, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    //Replase the contents of a view (invoked by layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        //get element from your dataset at this position
        //replace the contents of the view with that element
        holder.textView.setText(mTextSet.get(position));
        holder.imageView.setImageResource(mImageIdSet.get(position));
    }

    //Return the siae of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount(){
        return mTextSet.size();
    }

}

