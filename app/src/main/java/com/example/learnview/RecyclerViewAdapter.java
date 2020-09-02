package com.example.learnview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.Holder> {
    private String[] array;
    private final LayoutInflater mLayoutInflater;
    private final Context mContext;

    public RecyclerViewAdapter( Context mContext){
        array = mContext.getResources().getStringArray(R.array.testArray);
        Log.d("adapter", array.toString());
        mLayoutInflater = LayoutInflater.from(mContext);
        this.mContext = mContext;
    }
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(mLayoutInflater.inflate(R.layout.rv_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.textView.setText(array[position]);
    }


    @Override
    public int getItemCount() {
        return array.length;
    }
    public static class Holder extends RecyclerView.ViewHolder{
        public TextView textView;
        public Holder(View itemView){
            super(itemView);
            textView = itemView.findViewById(R.id.item_tv);

        }
    }
}
