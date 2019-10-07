package com.mymur.myprotocolapp;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private String[] mDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public MyViewHolder(TextView v) {
            super(v);
            textView = v;
        }
    }

    public MyAdapter (String[] myDataset){
        mDataset = myDataset;
    }

    //Создаём новые виды
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //
        TextView v = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.my_text_view, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }
    //заменяем контент в виде
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        holder.textView.setText(mDataset[position]);
    }
    //возвращает размер dataset
    @Override
    public int getItemCount(){
        return mDataset.length;
    }

}
