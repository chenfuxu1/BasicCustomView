package com.example.basiccustomview.exercise.exercise3.view;

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
 * DateTime: 2022/11/23 23:38
 *
 * 使用 paint.setTextSize() 来设置不同大小的文字
 **/
public class SetTextSizeView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private String mText = "在那不遥远的地方！";

    public SetTextSizeView(Context context) {
        this(context, null);
    }

    public SetTextSizeView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SetTextSizeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public SetTextSizeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int y = 200;
        mPaint.setColor(Color.GREEN);

        // 第一处：文字大小 16
        mPaint.setTextSize(16);
        canvas.drawText(mText, 50, y, mPaint);

        y += 30;
        // 第一处：文字大小 24
        mPaint.setTextSize(24);
        canvas.drawText(mText, 50, y, mPaint);

        y += 55;
        // 第一处：文字大小 48
        mPaint.setTextSize(48);
        canvas.drawText(mText, 50, y, mPaint);

        y += 80;
        // 第一处：文字大小 72
        mPaint.setTextSize(72);
        canvas.drawText(mText, 50, y, mPaint);
    }
}
