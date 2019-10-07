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



//public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
//    ArrayList <TextView> mTextSet;
//
//    ArrayList <ImageView> mImageArray;
//    TextView textView;
//    TextView mItemText;
//    ImageView mItemImage;
//
//    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//        //public CardView cardView;
////       public MyViewHolder(CardView v) {
////            super(v);
////            cardView = v;
////
////        }
//        private TextView mItemText;
//        private ImageView mItemImage;
//
//        public MyViewHolder(View itemView){
//            super(itemView);
//            mItemText = (TextView)itemView.findViewById(R.id.textName);
//            mItemImage = (ImageView) itemView.findViewById(R.id.cardImage);
//            itemView.setOnClickListener(this);
//        }
//
//        public void bindView (int position, ArrayList <TextView> mTextSet, ArrayList <ImageView> mImageArray){
//            mItemText = mTextSet.get(position);
//            System.out.println("Метод bindView. Выведем элемент текста" + mItemText.getText().toString());
//            mItemImage = mImageArray.get(position);
//        }
//
//        @Override
//        public void onClick(View v) {
//
//        }
//    }
//
//
//    public MyAdapter (ArrayList <TextView> myTextSet, ArrayList <ImageView> myImageArray){
//        mTextSet = myTextSet;
//        mImageArray = myImageArray;
//    }
//
//
//    //Создаём новые виды
////    @Override
////    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
////        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
////        MyViewHolder vh = new MyViewHolder(v);
////        return vh;
////    }
//
//        @Override
//    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.linear_card, parent, false);
//        MyViewHolder vh = new MyViewHolder(v);
//        return vh;
//    }
//
//
//    //заменяем контент в виде
//    @Override
//    public void onBindViewHolder(MyViewHolder holder, int position) {
//        holder.bindView(position, mTextSet, mImageArray);
////    {
////        System.out.println(mTextSet.get(position));
////        holder.cardView.addView(mImageArray.get(position));
////
////        holder.cardView.addView(mTextSet.get(position));
////    }
//
//
//    }
//
//
////        {
////        System.out.println(mTextSet.get(position));
////        holder.linearCard.addView(mImageArray.get(position));
////
////        holder.linearCard.addView(mTextSet.get(position));
////    }
//
//    //возвращает размер dataset
//    @Override
//    public int getItemCount(){
//        System.out.println(mTextSet.size());
//        System.out.println(mTextSet.get(1).getText().toString());
//        return mTextSet.size();
//    }
//
//
//
//
//}
