package com.example.androidrecyclerview;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

public class DataBean extends BaseObservable implements IBaseItemType {
    int number;

    public DataBean(int number) {
        this.number = number;
    }

    @Bindable
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
        notifyPropertyChanged(BR.number);
    }

    @Override
    public int getItemType() {
        return R.layout.recycler_item;
    }
}
