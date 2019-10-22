package com.mymur.myprotocolapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    ArrayList <String> mTextSet;
    ArrayList <String> mTrialsArray;
     int mActivityTitleKey;


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;

    public MyViewHolder(final View itemView, final int activityKey, final ArrayList <String> myTrialsArray) {
        super(itemView);
        textView = itemView.findViewById(R.id.textName);
        itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                System.out.println("нажали");
                //сюда код обработки события нажатия
    //если активность MainActivity, то
            switch (activityKey) {
                case (Constants.MAIN_ACTIVITY_TITLE):
                        Intent intent = new Intent(textView.getContext(), ProtocolActivity.class);
                        intent.putExtra("Child", textView.getText().toString());
                        intent.putExtra("TrialsArray", myTrialsArray);
                        itemView.getContext().startActivity(intent);
                    break;
                case (Constants.PROTOCOL_ACTIVITY_TITLE):
                    //Если активность protocolActivity, то при нажатии на пробу заполняется массив этой пробы и
                    //TODO

                    break;
            }
            }
        });
    }
    }

    //provide a suitable constructor (depends on the kind of dataset)
     public MyAdapter(ArrayList<String> myTextSet, int myActivityTitleKey, ArrayList <String> myTrialsArray) {
        mTextSet = myTextSet;
        mActivityTitleKey = myActivityTitleKey;
        mTrialsArray = myTrialsArray;
    }

    //Create new views
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        //create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.linear_card, parent, false);
        MyViewHolder vh = new MyViewHolder(v, mActivityTitleKey, mTrialsArray);
        return vh;
    }

    //Replace the contents of a view (invoked by layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        //get element from your dataset at this position
        //replace the contents of the view with that element
        holder.textView.setText(mTextSet.get(position));

    }

    //Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount(){
        return mTextSet.size();
    }





}

