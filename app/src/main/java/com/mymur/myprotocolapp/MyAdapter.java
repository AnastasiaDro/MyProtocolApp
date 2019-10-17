package com.mymur.myprotocolapp;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static androidx.core.content.ContextCompat.startActivity;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    ArrayList <String> mTextSet;
    ArrayList <Integer> mImageIdSet;
    String mActivityName;



    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public ImageView imageView;
        String activityName;

    public MyViewHolder(final View itemView, final String activityName) {
        super(itemView);
        textView = itemView.findViewById(R.id.textName);
        imageView = itemView.findViewById(R.id.cardImage);
        itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                System.out.println("нажали");
                Context context = textView.getContext();
                if (activityName == "MainActivity"){
                    Intent intent = new Intent(context, ProtocolActivity.class);
                    intent.putExtra("ChildName", textView.getText().toString());
                    System.out.println(textView.getText().toString());
                    context.startActivity(intent);
                }
            }
        });

    }
    }

    //provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<String> myTextSet, ArrayList <Integer> myImageIdSet, String myActivityName) {
        mTextSet = myTextSet;
        mImageIdSet = myImageIdSet;
       mActivityName= myActivityName;
    }

    //Create new views
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        //create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.linear_card, parent, false);
        MyViewHolder vh = new MyViewHolder(v, mActivityName);
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

