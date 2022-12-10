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
 * 使用 canvas.drawLine() 方法画直线
 **/
public class DrawLineView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public DrawLineView(Context context) {
        this(context, null);
    }

    public DrawLineView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.GREEN);
        mPaint.setStrokeWidth(20);
        /**
         * 参数1：起始点 x
         * 参数2：起始点 y
         * 参数3：终点 x
         * 参数4：终点 y
         * 参数5：画笔
         */
        canvas.drawLine(150, 250, 900, 800, mPaint);

    }
}
