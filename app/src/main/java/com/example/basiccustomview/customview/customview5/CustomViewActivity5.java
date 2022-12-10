package com.example.basiccustomview.customview.customview5;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.basiccustomview.R;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/11/19 11:16
 *
 * 自定义 View 1-5 绘制顺序
 **/
public class CustomViewActivity5 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_5);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
