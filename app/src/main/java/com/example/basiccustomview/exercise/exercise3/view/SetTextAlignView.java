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
 * 使用 Paint.setTextAlign() 来调整文字对齐方式
 * 一共有三个值：LEFT CETNER 和 RIGHT。默认值为 LEFT
 **/
public class SetTextAlignView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private String mText = "光怪陆离的人间";

    {
        mPaint.setTextSize(100);
        mPaint.setColor(Color.GRAY);
    }

    public SetTextAlignView(Context context) {
        this(context, null);
    }

    public SetTextAlignView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SetTextAlignView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public SetTextAlignView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 第一处：使用 Paint.Align.LEFT
        mPaint.setTextAlign(Paint.Align.LEFT);
        canvas.drawText(mText, getWidth() / 2, 100, mPaint);

        // 第二处：使用 Paint.Align.CENTER
        mPaint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(mText, getWidth() / 2, 400, mPaint);

        // 第三处：使用 Paint.Align.RIGHT
        mPaint.setTextAlign(Paint.Align.RIGHT);
        canvas.drawText(mText, getWidth() / 2, 700, mPaint);
    }
}
