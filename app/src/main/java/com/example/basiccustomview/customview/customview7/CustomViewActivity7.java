package com.example.basiccustomview.customview.customview7;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.basiccustomview.R;
import com.example.basiccustomview.customview.customview6.SportsView;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/11/19 11:16
 *
 * 自定义 View 1-7：属性动画 Property Animation（进阶篇）
 **/
public class CustomViewActivity7 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_7);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
