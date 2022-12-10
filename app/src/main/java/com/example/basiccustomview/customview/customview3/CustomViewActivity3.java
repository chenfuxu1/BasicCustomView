package com.example.basiccustomview.customview.customview3;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.basiccustomview.R;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/11/19 11:16
 *
 * 自定义 View 1-3 drawText() 文字的绘制
 **/
public class CustomViewActivity3 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_3);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
