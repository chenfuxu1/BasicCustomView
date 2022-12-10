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
 * 综合练习
 * 练习内容：
 * 使用各种 Canvas.drawXXX() 方法画饼图
 **/
public class DrawPieChartView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public DrawPieChartView(Context context) {
        this(context, null);
    }

    public DrawPieChartView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawPieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setColor(Color.YELLOW);
        canvas.drawArc(100, 200, 900, 1000, -45, 35,
                true, mPaint);

        mPaint.setColor(Color.MAGENTA);
        canvas.drawArc(100, 200, 900, 1000, -15, 10,
                true, mPaint);

        mPaint.setColor(Color.GRAY);
        canvas.drawArc(100, 200, 900, 1000, -5, 10,
                true, mPaint);

        mPaint.setColor(Color.GREEN);
        canvas.drawArc(100, 200, 900, 1000, 5, 65,
                true, mPaint);

        mPaint.setColor(Color.BLUE);
        canvas.drawArc(100, 200, 900, 1000, 70, 120,
                true, mPaint);

        mPaint.setColor(Color.RED);
        canvas.drawArc(100, 200, 900, 1000, 190, 125,
                true, mPaint);
    }
}
