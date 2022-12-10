package com.example.basiccustomview.exercise.exercise5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.basiccustomview.R;
import com.example.basiccustomview.exercise.adapter.ViewPager2Adapter;
import com.example.basiccustomview.exercise.base.BaseFragment;
import com.example.basiccustomview.exercise.exercise5.fragment.AfterDrawViewFg;
import com.example.basiccustomview.exercise.exercise5.fragment.AfterOnDrawForegroundViewFg;
import com.example.basiccustomview.exercise.exercise5.fragment.AfterOnDrawViewFg;
import com.example.basiccustomview.exercise.exercise5.fragment.BeforeDrawViewFg;
import com.example.basiccustomview.exercise.exercise5.fragment.BeforeOnDrawForegroundViewFg;
import com.example.basiccustomview.exercise.exercise5.fragment.BeforeOnDrawViewFg;
import com.example.basiccustomview.exercise.exercise5.fragment.DispatchDrawLayoutFg;
import com.example.basiccustomview.exercise.exercise5.fragment.OnDrawLayoutFg;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/11/15 23:25
 *
 * 自定义 View 1-5 绘制顺序
 **/
public class Exercise5Activity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager2 mViewPager2;
    // tabLayout 的标题
    private String[] mTabTitle = {"AfterOnDrawView", "BeforeOnDrawView", "OnDrawLayout", "DispatchDrawLayout",
        "AfterOnDrawForegroundView", "BeforeOnDrawForegroundView", "AfterDrawView", "BeforeDrawView"};
    private ViewPager2Adapter mAdapter;
    private List<BaseFragment> mData = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise_activity);
        initData();
        initView();
        initListener();
    }

    private void initData() {
        AfterOnDrawViewFg afterOnDrawViewFg = new AfterOnDrawViewFg();
        BeforeOnDrawViewFg beforeOnDrawViewFg = new BeforeOnDrawViewFg();
        OnDrawLayoutFg onDrawLayoutFg = new OnDrawLayoutFg();
        DispatchDrawLayoutFg dispatchDrawLayoutFg = new DispatchDrawLayoutFg();
        AfterOnDrawForegroundViewFg afterOnDrawForegroundViewFg = new AfterOnDrawForegroundViewFg();
        BeforeOnDrawForegroundViewFg beforeOnDrawForegroundViewFg = new BeforeOnDrawForegroundViewFg();
        AfterDrawViewFg afterDrawViewFg = new AfterDrawViewFg();
        BeforeDrawViewFg beforeDrawViewFg = new BeforeDrawViewFg();

        mData.add(afterOnDrawViewFg);
        mData.add(beforeOnDrawViewFg);
        mData.add(onDrawLayoutFg);
        mData.add(dispatchDrawLayoutFg);
        mData.add(afterOnDrawForegroundViewFg);
        mData.add(beforeOnDrawForegroundViewFg);
        mData.add(afterDrawViewFg);
        mData.add(beforeDrawViewFg);
    }

    private void initView() {
        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager2 = findViewById(R.id.view_pager);
        mAdapter = new ViewPager2Adapter(this);
        mAdapter.addDatas(mData);
        mViewPager2.setAdapter(mAdapter);
        // 设置横向滑动
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(mTabLayout, mViewPager2,
                new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                // 设置 tabLayout 的标题
                tab.setText(mTabTitle[position]);
            }
        });
        // 应用生效
        tabLayoutMediator.attach();
    }

    private void initListener() {
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
