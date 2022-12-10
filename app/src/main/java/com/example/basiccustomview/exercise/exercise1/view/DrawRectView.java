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
 * 使用 canvas.drawRect() 方法画矩形
 **/
public class DrawRectView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public DrawRectView(Context context) {
        this(context, null);
    }

    public DrawRectView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 1. 实心矩形
        mPaint.setColor(Color.GREEN);
        canvas.drawRect(100, 100, 500, 500, mPaint);

        // 2.空心矩形
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(20);
        canvas.drawRect(100, 700, 500, 1100, mPaint);
    }
}
