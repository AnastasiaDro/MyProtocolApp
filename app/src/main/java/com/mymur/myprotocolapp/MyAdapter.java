package com.mymur.myprotocolapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    ArrayList <TextView> mTextSet;

    ArrayList <ImageView> mImageArray;
    TextView textView;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;


        public MyViewHolder(CardView v) {
            super(v);
            cardView = v;

        }



    }


    public MyAdapter (ArrayList <TextView> myTextSet, ArrayList <ImageView> myImageArray){
        TextView textView = this.textView;
        mTextSet = myTextSet;
        mImageArray = myImageArray;
    }


    //Создаём новые виды
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }
    //заменяем контент в виде
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        System.out.println(mTextSet.get(position));
        holder.cardView.addView(mImageArray.get(position));

        holder.cardView.addView(mTextSet.get(position));
    }
    //возвращает размер dataset
    @Override
    public int getItemCount(){
        return mTextSet.size();
    }




}
