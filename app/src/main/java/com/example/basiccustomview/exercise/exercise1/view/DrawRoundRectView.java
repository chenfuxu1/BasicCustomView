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
 * 使用 canvas.drawRoundRect() 方法画圆角矩形
 * drawRoundRect(float left, float top, float right,
 * float bottom, float rx, float ry, Paint paint) 画圆角矩形
 * left, top, right, bottom 是四条边的坐标，rx 和 ry 是圆角的横向半径和纵向半径。
 **/
public class DrawRoundRectView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public DrawRoundRectView(Context context) {
        this(context, null);
    }

    public DrawRoundRectView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawRoundRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 1.圆角矩形 1
        mPaint.setColor(Color.MAGENTA);
        canvas.drawRoundRect(100, 100, 600, 400, 80, 80, mPaint);

        // 2.空心圆角矩形 2
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(50);
        canvas.drawRoundRect(300, 600, 950, 1000, 80, 80, mPaint);
    }
}
