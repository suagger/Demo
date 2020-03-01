package com.example.androidrecyclerview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidrecyclerview.databinding.RecyclerItemBinding;

import java.util.List;

public class MyRecyclerViewAdapter extends BaseRecyclerAdapter<IBaseItemType> {
    onItemClickListener itemClickListener;
    public MyRecyclerViewAdapter(Context context, List mList) {
        super(context, mList);
    }

    public void removeData(int position){
        mList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,mList.size() - position);
    }

    @Override
    public int getItemViewType(int position) {
        return mList.get(position).getItemType();
    }

    @Override
    public RecyclerView.ViewHolder onCreateMyViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerItemBinding binding = DataBindingUtil.inflate(inflater,R.layout.recycler_item,parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindMyViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        DataBean bean = (DataBean) mList.get(position);
        final int pos = holder.getLayoutPosition();
        if(itemClickListener != null){
            ((MyViewHolder) holder).getBinding().textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onItemClick(((MyViewHolder) holder).getBinding().textView,pos);
                }
            });

            ((MyViewHolder) holder).getBinding().textView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();
                    itemClickListener.onItemLongClick(((MyViewHolder) holder).getBinding().textView,pos);
                    return false;
                }
            });
        }
        ((MyViewHolder) holder).getBinding().setItemNum(bean);
        ((MyViewHolder) holder).getBinding().executePendingBindings();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        RecyclerItemBinding binding ;

        public RecyclerItemBinding getBinding() {
            return binding;
        }

        public MyViewHolder(RecyclerItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
    public void setOnItemClickListenet(onItemClickListener onItemClickListenet){
        itemClickListener = onItemClickListenet;
    }
    public interface onItemClickListener{
        void onItemClick(View view,int position);
        void onItemLongClick(View view,int position);
    }
}
