package com.example.basiccustomview.customview.customview9;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.basiccustomview.R;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/11/19 11:16
 *
 * 自定义 View 2-1 布局基础
 **/
public class CustomViewActivity9 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_9);
    }

    /**
     * 1、布局过程的含义
     * 布局过程，就是程序在运行时利用布局文件的代码来计算出实际尺寸的过程。
     */

    /**
     * 2、布局过程的工作内容
     * 两个阶段：测量阶段和布局阶段。
     *
     * 测量阶段：从上到下递归地调用每个 View 或者 ViewGroup 的 measure() 方法，测量他们的尺寸并计算它们的位置；
     * 布局阶段：从上到下递归地调用每个 View 或者 ViewGroup 的 layout() 方法，把测得的它们的尺寸和位置赋值给它们。
     */

    /**
     * 3、View 或 ViewGroup 的布局过程
     *
     * 1.测量阶段，measure() 方法被父 View 调用，在 measure() 中做一些准备和优化工作后，调用 onMeasure()
     * 来进行实际的自我测量。 onMeasure() 做的事，View 和 ViewGroup 不一样：
     * View：View 在 onMeasure() 中会计算出自己的尺寸然后保存；
     * ViewGroup：ViewGroup 在 onMeasure() 中会调用所有子 View 的 measure() 让它们进行自我测量，并根据
     * 子 View 计算出的期望尺寸来计算出它们的实际尺寸和位置（实际上 99.99% 的父 View 都会使用子 View
     * 给出的期望尺寸来作为实际尺寸，）然后保存。同时，它也会根据子 View 的尺寸和位置来计算出自己的尺寸
     * 然后保存；
     *
     * 2.布局阶段，layout() 方法被父 View 调用，在 layout() 中它会保存父 View 传进来的自己的位置和尺寸，
     * 并且调用 onLayout() 来进行实际的内部布局。onLayout() 做的事， View 和 ViewGroup 也不一样：
     * View：由于没有子 View，所以 View 的 onLayout() 什么也不做。
     * ViewGroup：ViewGroup 在 onLayout() 中会调用自己的所有子 View 的 layout() 方法，把它们的尺寸和
     * 位置传给它们，让它们完成自我的内部布局。
     */

    /**
     * 3、布局过程自定义的方式
     * 三类：
     * 重写 onMeasure() 来修改已有的 View 的尺寸；
     * 重写 onMeasure() 来全新定制自定义 View 的尺寸；
     * 重写 onMeasure() 和 onLayout() 来全新定制自定义 ViewGroup 的内部布局。
     */

    /**
     * 4、第一类自定义的具体做法
     * 也就是重写 onMeasure() 来修改已有的 View 的尺寸的具体做法：
     *
     * 重写 onMeasure() 方法，并在里面调用 super.onMeasure()，触发原有的自我测量；
     * 在 super.onMeasure() 的下面用 getMeasuredWidth() 和 getMeasuredHeight() 来获取到之前的测量结果，
     * 并使用自己的算法，根据测量结果计算出新的结果；
     * 调用 setMeasuredDimension() 来保存新的结果。
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
