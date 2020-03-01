package com.example.androidrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter {

    List<T> mList;
    LayoutInflater inflater;

    public BaseRecyclerAdapter(Context context,List<T> mList) {
        this.mList = mList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return onCreateMyViewHolder(parent,viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        onBindMyViewHolder(holder,position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public abstract RecyclerView.ViewHolder onCreateMyViewHolder(ViewGroup parent, int viewType);
    public abstract void onBindMyViewHolder(RecyclerView.ViewHolder holder, int position);
}
