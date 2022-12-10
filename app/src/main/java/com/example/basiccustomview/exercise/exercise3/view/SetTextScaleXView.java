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
 * setTextScaleX(float scaleX)
 * 设置文字横向放缩。也就是文字变胖变瘦
 **/
public class SetTextScaleXView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private String mText = "光怪陆离的人间";

    {
        mPaint.setTextSize(100);
        mPaint.setColor(Color.BLUE);
    }

    public SetTextScaleXView(Context context) {
        this(context, null);
    }

    public SetTextScaleXView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SetTextScaleXView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public SetTextScaleXView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setTextScaleX(0.2f);
        canvas.drawText(mText, 100, 100, mPaint);

        mPaint.setTextScaleX(0.6f);
        canvas.drawText(mText, 100, 250, mPaint);

        mPaint.setTextScaleX(1f);
        canvas.drawText(mText, 100, 400, mPaint);

        mPaint.setTextScaleX(1.4f);
        canvas.drawText(mText, 100, 550, mPaint);

        mPaint.setTextScaleX(1.8f);
        canvas.drawText(mText, 100, 700, mPaint);

        mPaint.setTextScaleX(2.2f);
        canvas.drawText(mText, 100, 850, mPaint);

    }
}
