package com.example.basiccustomview.exercise.exercise1.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/11/16 23:13
 *
 * 练习内容：
 * 使用 canvas.drawPoint() 方法画点
 * 一个圆点，一个方点
 * 圆点和方点的切换使用 paint.setStrokeCap(cap)：`ROUND` 是圆点，`BUTT` 或 `SQUARE` 是方点
 **/
public class DrawPointView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public DrawPointView(Context context) {
        this(context, null);
    }

    public DrawPointView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 1.圆点
        mPaint.setStrokeWidth(50);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawPoint(250, 300, mPaint);

        // 2.方点
        mPaint.setColor(Color.GRAY);
        mPaint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawPoint(550, 300, mPaint);

        // 3.方点
        mPaint.setColor(Color.GREEN);
        mPaint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawPoint(850, 300, mPaint);
    }
}
