package com.example.basiccustomview.exercise.exercise4;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.basiccustomview.R;
import com.example.basiccustomview.exercise.adapter.ViewPager2Adapter;
import com.example.basiccustomview.exercise.base.BaseFragment;
import com.example.basiccustomview.exercise.exercise4.fragment.CameraRotateFixedViewFg;
import com.example.basiccustomview.exercise.exercise4.fragment.CameraRotateHittingFaceViewFg;
import com.example.basiccustomview.exercise.exercise4.fragment.CameraRotateViewFg;
import com.example.basiccustomview.exercise.exercise4.fragment.ClipPathViewFg;
import com.example.basiccustomview.exercise.exercise4.fragment.ClipRectViewFg;
import com.example.basiccustomview.exercise.exercise4.fragment.FlipboardViewFg;
import com.example.basiccustomview.exercise.exercise4.fragment.MatrixRotateViewFg;
import com.example.basiccustomview.exercise.exercise4.fragment.MatrixScaleViewFg;
import com.example.basiccustomview.exercise.exercise4.fragment.MatrixSkewViewFg;
import com.example.basiccustomview.exercise.exercise4.fragment.MatrixTranslateViewFg;
import com.example.basiccustomview.exercise.exercise4.fragment.RotateViewFg;
import com.example.basiccustomview.exercise.exercise4.fragment.ScaleViewFg;
import com.example.basiccustomview.exercise.exercise4.fragment.SkewViewFg;
import com.example.basiccustomview.exercise.exercise4.fragment.TranslateViewFg;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/11/15 23:25
 *
 * 自定义 View 1-4 Canvas 对绘制的辅助
 **/
public class Exercise4Activity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager2 mViewPager2;
    // tabLayout 的标题
    private String[] mTabTitle = {"ClipRectView", "ClipPathView", "TranslateView", "ScaleView", "RotateView",
        "SkewView", "MatrixTranslateView", "MatrixScaleView", "MatrixRotateView",
            "MatrixSkewView", "CameraRotateView", "CameraRotateFixedView", "CameraRotateHittingFaceView",
            "FlipboardView"};
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
        ClipRectViewFg clipRectViewFg = new ClipRectViewFg();
        ClipPathViewFg clipPathViewFg = new ClipPathViewFg();
        TranslateViewFg translateViewFg = new TranslateViewFg();
        ScaleViewFg scaleViewFg = new ScaleViewFg();
        RotateViewFg rotateViewFg = new RotateViewFg();
        SkewViewFg skewViewFg = new SkewViewFg();
        MatrixTranslateViewFg matrixTranslateViewFg = new MatrixTranslateViewFg();
        MatrixScaleViewFg matrixScaleViewFg = new MatrixScaleViewFg();
        MatrixRotateViewFg matrixRotateViewFg = new MatrixRotateViewFg();
        MatrixSkewViewFg matrixSkewViewFg = new MatrixSkewViewFg();
        CameraRotateViewFg cameraRotateViewFg = new CameraRotateViewFg();
        CameraRotateFixedViewFg cameraRotateFixedViewFg = new CameraRotateFixedViewFg();
        CameraRotateHittingFaceViewFg cameraRotateHittingFaceViewFg = new CameraRotateHittingFaceViewFg();
        FlipboardViewFg flipboardViewFg = new FlipboardViewFg();

        mData.add(clipRectViewFg);
        mData.add(clipPathViewFg);
        mData.add(translateViewFg);
        mData.add(scaleViewFg);
        mData.add(rotateViewFg);
        mData.add(skewViewFg);
        mData.add(matrixTranslateViewFg);
        mData.add(matrixScaleViewFg);
        mData.add(matrixRotateViewFg);
        mData.add(matrixSkewViewFg);
        mData.add(cameraRotateViewFg);
        mData.add(cameraRotateFixedViewFg);
        mData.add(cameraRotateHittingFaceViewFg);
        mData.add(flipboardViewFg);
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
