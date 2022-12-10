package com.example.basiccustomview.customview.customview10;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.basiccustomview.R;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/11/19 11:16
 *
 * 自定义 View 2-2 全新定义 View 的尺寸
 **/
public class CustomViewActivity10 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_10);
    }

    /**
     * 1、全新定制尺寸和修改尺寸的最重要区别
     * 需要在计算的同时，保证计算结果满足父 View 给出的的尺寸限制
     */

    /**
     * 2、父 View 的尺寸限制
     * 由来：开发者的要求（布局文件中 layout_ 打头的属性）经过父 View 处理计算后的更精确的要求；
     * 限制的分类：
     * UNSPECIFIED：不限制
     * AT_MOST：限制上限
     * EXACTLY：限制固定值
     */

    /**
     * 3、全新定义自定义 View 尺寸的方式
     * 重新 onMeasure()，并计算出 View 的尺寸；
     * 使用 resolveSize() 来让子 View 的计算结果符合父 View 的限制（当然，如果你想用自己的方式来满足父 View 的限制也行）。
     */

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
