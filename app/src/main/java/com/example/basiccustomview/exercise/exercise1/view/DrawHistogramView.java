package com.example.basiccustomview.exercise.exercise1.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/11/16 23:13
 *
 * 综合练习
 * 练习内容：
 * 使用各种 Canvas.drawXXX() 方法画直方图
 *
 **/
public class DrawHistogramView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path mPath = new Path();

    public DrawHistogramView(Context context) {
        this(context, null);
    }

    public DrawHistogramView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawHistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @SuppressLint("Range")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 1.画坐标系
        mPaint.setStrokeWidth(8);
        mPaint.setColor(Color.BLACK);
        @SuppressLint("DrawAllocation")
        float[] points = new float[] {20f, 50f, 20f, 800f, 20f, 800f, 1050f, 800f};
        canvas.drawLines(points, mPaint);

        // 2.画直方图
        mPaint.setColor(Color.GREEN);
        canvas.drawRect(70, 300, 120, 796, mPaint);

        mPaint.setColor(Color.RED);
        canvas.drawRect(170, 100, 220, 796, mPaint);

        mPaint.setColor(Color.BLUE);
        canvas.drawRect(270, 700, 320, 796, mPaint);

        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(370, 500, 420, 796, mPaint);

        mPaint.setColor(Color.GRAY);
        canvas.drawRect(470, 650, 520, 796, mPaint);

        mPaint.setColor(Color.MAGENTA);
        canvas.drawRect(570, 150, 620, 796, mPaint);

        mPaint.setColor(Color.CYAN);
        canvas.drawRect(670, 150, 720, 796, mPaint);

        mPaint.setColor(Color.BLACK);
        canvas.drawRect(770, 250, 820, 796, mPaint);

        mPaint.setColor(Color.LTGRAY);
        canvas.drawRect(870, 410, 920, 796, mPaint);
    }
}
