package com.example.basiccustomview.exercise.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.basiccustomview.exercise.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/11/16 21:37
 **/
public class ViewPager2Adapter extends FragmentStateAdapter {
    private List<BaseFragment> mDatas = new ArrayList<>();

    public ViewPager2Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return mDatas.get(position);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void addDatas(List<BaseFragment> data) {
        mDatas.clear();
        mDatas.addAll(data);
        notifyDataSetChanged();
    }
}
