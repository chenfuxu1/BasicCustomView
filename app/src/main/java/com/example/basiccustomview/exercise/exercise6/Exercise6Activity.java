package com.example.basiccustomview.exercise.exercise6;

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
import com.example.basiccustomview.exercise.exercise6.fragment.AlphaAnimFg;
import com.example.basiccustomview.exercise.exercise6.fragment.DurationAnimFg;
import com.example.basiccustomview.exercise.exercise6.fragment.InterpolatorAnimFg;
import com.example.basiccustomview.exercise.exercise6.fragment.MultiPropertiesAnimFg;
import com.example.basiccustomview.exercise.exercise6.fragment.ObjectAnimatorViewAnimFg;
import com.example.basiccustomview.exercise.exercise6.fragment.RotationAnimFg;
import com.example.basiccustomview.exercise.exercise6.fragment.ScaleAnimFg;
import com.example.basiccustomview.exercise.exercise6.fragment.TranslationAnimFg;
import com.example.basiccustomview.exercise.exercise6.view.RotationAnim;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/11/15 23:25
 *
 * ????????? View 1-6??????????????? Property Animation???????????????
 **/
public class Exercise6Activity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager2 mViewPager2;
    // tabLayout ?????????
    private String[] mTabTitle = {"Translation", "Rotation", "Scale", "Alpha", "MultiProperties",
            "Duration", "Interpolator", "ObjectAnimatorView"};
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
        TranslationAnimFg translationAnimFg = new TranslationAnimFg();
        RotationAnimFg rotationAnimFg = new RotationAnimFg();
        ScaleAnimFg scaleAnimFg = new ScaleAnimFg();
        AlphaAnimFg alphaAnimFg = new AlphaAnimFg();
        MultiPropertiesAnimFg multiPropertiesAnimFg = new MultiPropertiesAnimFg();
        DurationAnimFg durationAnimFg = new DurationAnimFg();
        InterpolatorAnimFg interpolatorAnimFg = new InterpolatorAnimFg();
        ObjectAnimatorViewAnimFg objectAnimatorViewAnimFg = new ObjectAnimatorViewAnimFg();

        mData.add(translationAnimFg);
        mData.add(rotationAnimFg);
        mData.add(scaleAnimFg);
        mData.add(alphaAnimFg);
        mData.add(multiPropertiesAnimFg);
        mData.add(durationAnimFg);
        mData.add(interpolatorAnimFg);
        mData.add(objectAnimatorViewAnimFg);
    }

    private void initView() {
        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager2 = findViewById(R.id.view_pager);
        mAdapter = new ViewPager2Adapter(this);
        mAdapter.addDatas(mData);
        mViewPager2.setAdapter(mAdapter);
        // ??????????????????
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(mTabLayout, mViewPager2,
                new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                // ?????? tabLayout ?????????
                tab.setText(mTabTitle[position]);
            }
        });
        // ????????????
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
