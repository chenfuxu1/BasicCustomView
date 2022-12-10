package com.example.basiccustomview.exercise.exercise5.view;

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
 * DateTime: 2022/11/28 23:21
 **/
public class AfterDrawView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    {
        mPaint.setTextSize(80);
        mPaint.setColor(Color.RED);
    }

    public AfterDrawView(Context context) {
        this(context, null);
    }

    public AfterDrawView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AfterDrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public AfterDrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        /**
         * 在 draw 方法后绘制，一定能显示
         */
        mPaint.setColor(Color.parseColor("#F44336"));
        canvas.drawRect(0, 40, 200, 120, mPaint);
        mPaint.setColor(Color.WHITE);
        canvas.drawText("New", 20 , 100, mPaint);
    }
}
