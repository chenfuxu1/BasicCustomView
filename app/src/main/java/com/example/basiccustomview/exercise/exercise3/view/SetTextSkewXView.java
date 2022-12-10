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
 * setTextSkewX(float skewX)
 * 设置文字横向错切角度。其实就是文字倾斜度
 **/
public class SetTextSkewXView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private String mText = "光怪陆离的人间";

    {
        mPaint.setTextSize(100);
        mPaint.setColor(Color.CYAN);
    }

    public SetTextSkewXView(Context context) {
        this(context, null);
    }

    public SetTextSkewXView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SetTextSkewXView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public SetTextSkewXView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setTextSkewX(-1f);
        canvas.drawText(mText, 100, 100, mPaint);

        mPaint.setTextSkewX(-0.6f);
        canvas.drawText(mText, 100, 250, mPaint);

        mPaint.setTextSkewX(-0.2f);
        canvas.drawText(mText, 100, 400, mPaint);

        mPaint.setTextSkewX(0f);
        canvas.drawText(mText, 100, 550, mPaint);

        mPaint.setTextSkewX(0.2f);
        canvas.drawText(mText, 100, 700, mPaint);

        mPaint.setTextSkewX(0.6f);
        canvas.drawText(mText, 100, 850, mPaint);

        mPaint.setTextSkewX(1f);
        canvas.drawText(mText, 100, 1000, mPaint);

    }
}
