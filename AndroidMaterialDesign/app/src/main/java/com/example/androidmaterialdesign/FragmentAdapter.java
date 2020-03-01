package com.example.androidmaterialdesign;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class FragmentAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mFrangments;
    private List<String> mTitles;
    public FragmentAdapter(@NonNull FragmentManager fm,List<Fragment> mFrangments,List<String> mTitles) {
        super(fm);
        this.mFrangments = mFrangments;
        this.mTitles = mTitles;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFrangments.get(position);
    }

    @Override
    public int getCount() {
        return mFrangments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
