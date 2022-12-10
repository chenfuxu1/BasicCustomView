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
 * 使用 canvas.drawOval() 方法画椭圆
 *
 **/
public class DrawOvalView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public DrawOvalView(Context context) {
        this(context, null);
    }

    public DrawOvalView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawOvalView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 1.实心椭圆
        canvas.drawOval(0, 0, 500, 300, mPaint);

        // 2.空心椭圆
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(10);
        canvas.drawOval(500, 600, 1000, 900, mPaint);
    }
}
