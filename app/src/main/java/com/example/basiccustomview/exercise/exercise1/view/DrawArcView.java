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
 * 使用 canvas.drawArc() 方法画弧形和扇形
 *
 * drawArc(float left, float top, float right, float bottom, float startAngle,
 * float sweepAngle, boolean useCenter, Paint paint) 绘制弧形或扇形
 * drawArc() 是使用一个椭圆来描述弧形的。left, top, right, bottom 描述的是这个弧形所在的椭圆；
 * startAngle 是弧形的起始角度（x 轴的正向，即正右的方向，是 0 度的位置；顺时针为正角度，逆时针为负角度）
 * ，sweepAngle 是弧形划过的角度；useCenter 表示是否连接到圆心，如果不连接到圆心，就是弧形，
 * 如果连接到圆心，就是扇形。
 **/
public class DrawArcView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public DrawArcView(Context context) {
        this(context, null);
    }

    public DrawArcView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.FILL);
        // 1.画弧形
        canvas.drawArc(100, 100, 500, 400, 0, 60,
                false, mPaint);

        // 2.画扇形(useCenter 为 true，连接圆心)
        mPaint.setColor(Color.RED);
        canvas.drawArc(600, 100, 1000, 400, 0, 60,
                true, mPaint);

        // 3.画弧线
        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(20);
        canvas.drawArc(100, 600, 500, 900, 80, 170,
                false, mPaint);

        // 4.画弧线(连接圆心)
        mPaint.setColor(Color.RED);
        canvas.drawArc(600, 600, 1000, 900, 80, 170,
                true, mPaint);
    }
}
