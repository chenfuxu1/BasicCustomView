package com.example.basiccustomview.exercise.exercise1.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/11/16 23:13
 *
 * 练习内容：
 * 使用 canvas.drawCircle() 方法画圆
 * 一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆
 **/
public class DrawCircleView extends View {
    private Paint mPaint = new Paint();

    public DrawCircleView(Context context) {
        this(context, null);
    }

    public DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 1.画黑色实心圆
        mPaint.setAntiAlias(true); // 打开抗锯齿
        canvas.drawCircle(300, 200, 150, mPaint);

        // 2.空心圆
        mPaint.setStyle(Paint.Style.STROKE); // 设置画笔为画线模式，画出的为空心圆，FILL 是实心圆
        canvas.drawCircle(750, 200, 150, mPaint);

        // 3.蓝色的实心圆
        mPaint.setStyle(Paint.Style.FILL); // 设置为填充模式
        mPaint.setColor(Color.BLUE); // 设置画笔颜色
        canvas.drawCircle(300, 700, 150, mPaint);

        // 4.线宽为 20 的空心圆
        mPaint.setStrokeWidth(20); // 设置线宽为 20 像素
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(750, 700, 150, mPaint);
    }
}
