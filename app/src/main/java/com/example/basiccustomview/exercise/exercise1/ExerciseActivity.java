package com.example.basiccustomview.exercise.exercise1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.basiccustomview.R;
import com.example.basiccustomview.exercise.adapter.ViewPager2Adapter;
import com.example.basiccustomview.exercise.base.BaseFragment;
import com.example.basiccustomview.exercise.exercise1.fragment.DrawArcViewFg;
import com.example.basiccustomview.exercise.exercise1.fragment.DrawColorViewFg;
import com.example.basiccustomview.exercise.exercise1.fragment.DrawCircleViewFg;
import com.example.basiccustomview.exercise.exercise1.fragment.DrawHistogramViewFg;
import com.example.basiccustomview.exercise.exercise1.fragment.DrawLineViewFg;
import com.example.basiccustomview.exercise.exercise1.fragment.DrawOvalViewFg;
import com.example.basiccustomview.exercise.exercise1.fragment.DrawPathViewFg;
import com.example.basiccustomview.exercise.exercise1.fragment.DrawPieChartViewFg;
import com.example.basiccustomview.exercise.exercise1.fragment.DrawPointViewFg;
import com.example.basiccustomview.exercise.exercise1.fragment.DrawRectViewFg;
import com.example.basiccustomview.exercise.exercise1.fragment.DrawRoundRectViewFg;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/11/15 23:25
 **/
public class ExerciseActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager2 mViewPager2;
    // tabLayout 的标题
    private String[] mTabTitle = {"DrawColorView", "DrawCircleView", "DrawRectView", "DrawPointView", "DrawOvalView",
        "DrawLineView", "DrawRoundRectView", "DrawArcView", "DrawPathView", "HistogramView", "PieChartView"};
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
        DrawColorViewFg drawColorViewFg = new DrawColorViewFg();
        DrawCircleViewFg drawCircleViewFg = new DrawCircleViewFg();
        DrawRectViewFg drawRectViewFg = new DrawRectViewFg();
        DrawPointViewFg drawPointViewFg = new DrawPointViewFg();
        DrawOvalViewFg drawOvalViewFg = new DrawOvalViewFg();
        DrawLineViewFg drawLineViewFg = new DrawLineViewFg();
        DrawRoundRectViewFg drawRoundRectViewFg = new DrawRoundRectViewFg();
        DrawArcViewFg drawArcViewFg = new DrawArcViewFg();
        DrawPathViewFg drawPathViewFg = new DrawPathViewFg();
        DrawHistogramViewFg drawHistogramViewFg = new DrawHistogramViewFg();
        DrawPieChartViewFg drawPieChartViewFg = new DrawPieChartViewFg();
        mData.add(drawColorViewFg);
        mData.add(drawCircleViewFg);
        mData.add(drawRectViewFg);
        mData.add(drawPointViewFg);
        mData.add(drawOvalViewFg);
        mData.add(drawLineViewFg);
        mData.add(drawRoundRectViewFg);
        mData.add(drawArcViewFg);
        mData.add(drawPathViewFg);
        mData.add(drawHistogramViewFg);
        mData.add(drawPieChartViewFg);
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
