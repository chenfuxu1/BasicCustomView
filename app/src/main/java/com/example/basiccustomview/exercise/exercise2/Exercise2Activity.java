package com.example.basiccustomview.exercise.exercise2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.basiccustomview.R;
import com.example.basiccustomview.exercise.adapter.ViewPager2Adapter;
import com.example.basiccustomview.exercise.base.BaseFragment;
import com.example.basiccustomview.exercise.exercise2.fragment.BitmapShaderFg;
import com.example.basiccustomview.exercise.exercise2.fragment.ColorMatrixColorFilterFg;
import com.example.basiccustomview.exercise.exercise2.fragment.ComposeShaderFg;
import com.example.basiccustomview.exercise.exercise2.fragment.FillPathFg;
import com.example.basiccustomview.exercise.exercise2.fragment.LightingColorFilterFg;
import com.example.basiccustomview.exercise.exercise2.fragment.LinearGradientFg;
import com.example.basiccustomview.exercise.exercise2.fragment.MaskFilterFg;
import com.example.basiccustomview.exercise.exercise2.fragment.PathEffectFg;
import com.example.basiccustomview.exercise.exercise2.fragment.RadialGradientFg;
import com.example.basiccustomview.exercise.exercise2.fragment.ShadowLayerFg;
import com.example.basiccustomview.exercise.exercise2.fragment.StrokeCapFg;
import com.example.basiccustomview.exercise.exercise2.fragment.StrokeJoinFg;
import com.example.basiccustomview.exercise.exercise2.fragment.StrokeMiterFg;
import com.example.basiccustomview.exercise.exercise2.fragment.SweepGradientFg;
import com.example.basiccustomview.exercise.exercise2.fragment.TextPathFg;
import com.example.basiccustomview.exercise.exercise2.fragment.XfermodeFg;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/11/15 23:25
 **/
public class Exercise2Activity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager2 mViewPager2;
    // tabLayout 的标题
    private String[] mTabTitle = {"LinearGradientView", "RadialGradientView", "SweepGradientView", "BitmapShaderView", "ComposeShaderView",
        "LightingColorFilterView", "ColorMatrixColorFilterView", "XfermodeView", "StrokeCapView",
            "StrokeJoinView", "StrokeMiterView", "PathEffectView", "ShadowLayerView", "MaskFilterView",
            "FillPathView", "TextPathView"};
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
        LinearGradientFg linearGradientFg = new LinearGradientFg();
        RadialGradientFg radialGradientFg = new RadialGradientFg();
        SweepGradientFg sweepGradientFg = new SweepGradientFg();
        BitmapShaderFg bitmapShaderFg = new BitmapShaderFg();
        ComposeShaderFg composeShaderFg = new ComposeShaderFg();
        LightingColorFilterFg lightingColorFilterFg = new LightingColorFilterFg();
        ColorMatrixColorFilterFg colorMatrixColorFilterFg = new ColorMatrixColorFilterFg();
        XfermodeFg xfermodeFg = new XfermodeFg();
        StrokeCapFg strokeCapFg = new StrokeCapFg();
        StrokeJoinFg strokeJoinFg = new StrokeJoinFg();
        StrokeMiterFg strokeMiterFg = new StrokeMiterFg();
        PathEffectFg pathEffectFg = new PathEffectFg();
        ShadowLayerFg shadowLayerFg = new ShadowLayerFg();
        MaskFilterFg maskFilterFg = new MaskFilterFg();
        FillPathFg fillPathFg = new FillPathFg();
        TextPathFg textPathFg = new TextPathFg();
        mData.add(linearGradientFg);
        mData.add(radialGradientFg);
        mData.add(sweepGradientFg);
        mData.add(bitmapShaderFg);
        mData.add(composeShaderFg);
        mData.add(lightingColorFilterFg);
        mData.add(colorMatrixColorFilterFg);
        mData.add(xfermodeFg);
        mData.add(strokeCapFg);
        mData.add(strokeJoinFg);
        mData.add(strokeMiterFg);
        mData.add(pathEffectFg);
        mData.add(shadowLayerFg);
        mData.add(maskFilterFg);
        mData.add(fillPathFg);
        mData.add(textPathFg);
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
