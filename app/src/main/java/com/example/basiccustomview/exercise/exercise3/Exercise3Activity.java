package com.example.basiccustomview.exercise.exercise3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.basiccustomview.R;
import com.example.basiccustomview.exercise.adapter.ViewPager2Adapter;
import com.example.basiccustomview.exercise.base.BaseFragment;
import com.example.basiccustomview.exercise.exercise3.fragment.DrawTextFg;
import com.example.basiccustomview.exercise.exercise3.fragment.GetFontMetricsFg;
import com.example.basiccustomview.exercise.exercise3.fragment.GetFontSpacingFg;
import com.example.basiccustomview.exercise.exercise3.fragment.GetTextBoundsFg;
import com.example.basiccustomview.exercise.exercise3.fragment.MeasureTextFg;
import com.example.basiccustomview.exercise.exercise3.fragment.SetFakeBoldTextFg;
import com.example.basiccustomview.exercise.exercise3.fragment.SetStrikeThruTextFg;
import com.example.basiccustomview.exercise.exercise3.fragment.SetTextAlignFg;
import com.example.basiccustomview.exercise.exercise3.fragment.SetTextScaleXFg;
import com.example.basiccustomview.exercise.exercise3.fragment.SetTextSizeFg;
import com.example.basiccustomview.exercise.exercise3.fragment.SetTextSkewXFg;
import com.example.basiccustomview.exercise.exercise3.fragment.SetTypefaceViewFg;
import com.example.basiccustomview.exercise.exercise3.fragment.SetUnderlineTextFg;
import com.example.basiccustomview.exercise.exercise3.fragment.StaticLayoutFg;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/11/15 23:25
 *
 * 自定义 View 1-3 drawText() 文字的绘制
 **/
public class Exercise3Activity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager2 mViewPager2;
    // tabLayout 的标题
    private String[] mTabTitle = {"DrawTextView", "StaticLayoutView", "SetTextSizeView", "SetTypefaceView", "SetFakeBoldTextView",
        "SetStrikeThruTextView", "SetUnderlineTextView", "SetTextSkewXView", "SetTextScaleXView",
            "SetTextAlignView", "GetFontSpacingView", "MeasureTextView", "GetTextBoundsView", "GetFontMetricsView"};
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
        DrawTextFg drawTextFg = new DrawTextFg();
        StaticLayoutFg staticLayoutFg = new StaticLayoutFg();
        SetTextSizeFg setTextSizeFg = new SetTextSizeFg();
        SetTypefaceViewFg setTypefaceViewFg = new SetTypefaceViewFg();
        SetFakeBoldTextFg setFakeBoldTextFg = new SetFakeBoldTextFg();
        SetStrikeThruTextFg setStrikeThruTextFg = new SetStrikeThruTextFg();
        SetUnderlineTextFg setUnderlineTextFg = new SetUnderlineTextFg();
        SetTextSkewXFg setTextSkewXFg = new SetTextSkewXFg();
        SetTextScaleXFg setTextScaleXFg = new SetTextScaleXFg();
        SetTextAlignFg setTextAlignFg = new SetTextAlignFg();
        GetFontSpacingFg getFontSpacingFg = new GetFontSpacingFg();
        MeasureTextFg measureTextFg = new MeasureTextFg();
        GetTextBoundsFg getTextBoundsFg = new GetTextBoundsFg();
        GetFontMetricsFg getFontMetricsFg = new GetFontMetricsFg();
        mData.add(drawTextFg);
        mData.add(staticLayoutFg);
        mData.add(setTextSizeFg);
        mData.add(setTypefaceViewFg);
        mData.add(setFakeBoldTextFg);
        mData.add(setStrikeThruTextFg);
        mData.add(setUnderlineTextFg);
        mData.add(setTextSkewXFg);
        mData.add(setTextScaleXFg);
        mData.add(setTextAlignFg);
        mData.add(getFontSpacingFg);
        mData.add(measureTextFg);
        mData.add(getTextBoundsFg);
        mData.add(getFontMetricsFg);
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
