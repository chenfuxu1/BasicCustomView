package com.example.basiccustomview.customview.customview6;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.basiccustomview.R;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/11/19 11:16
 *
 * 自定义 View 1-6：属性动画 Property Animation（上手篇）
 **/
public class CustomViewActivity6 extends AppCompatActivity {
    private TextView mTextView;
    private CustomView6 mCustomView6;
    private SportsView mSportsView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_6);
        initView();
        initListener();
    }

    private void initView() {
        mCustomView6 = findViewById(R.id.custom_view_6);
        mTextView = findViewById(R.id.text_view);
        mSportsView = findViewById(R.id.sport_view);
    }

    private void initListener() {
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                executeClickMethod();
            }
        });
    }

    private void executeClickMethod() {
        // if (mCustomView6 != null) {
        //     mCustomView6.startAnim();
        // }
        // if (mSportsView != null) {
        //     mSportsView.startAnim();
        // }

        // 1、设置执行时长
        // if (mCustomView6 != null) {
        //     mCustomView6.animSetDuration();
        // }
        // if (mSportsView != null) {
        //     mSportsView.animSetDuration();
        // }

        // 2、设置插值器
        if (mCustomView6 != null) {
            mCustomView6.animSetInterpolator();
        }
        if (mSportsView != null) {
            mSportsView.animSetInterpolator();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
