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
 * Paint.measureText 测量出文字宽度，让文字可以相邻绘制
 * float measureText(String text)
 * 测量文字的宽度并返回
 **/
public class MeasureTextView extends View {
    private Paint mPaint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint mPaint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
    private String mText1 = "三个月内你胖了";
    private String mText2 = "4.5";
    private String mText3 = "公斤";

    {
        mPaint1.setTextSize(80);
        mPaint2.setTextSize(100);
        mPaint1.setColor(Color.RED);
        mPaint2.setColor(Color.CYAN);
        mPaint1.setFakeBoldText(true);
        mPaint2.setFakeBoldText(true);
    }

    public MeasureTextView(Context context) {
        this(context, null);
    }

    public MeasureTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MeasureTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public MeasureTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 第一段文字
        canvas.drawText(mText1, 50, 500, mPaint1);

        // 第二段文字
        float length1 = mPaint1.measureText(mText1);
        canvas.drawText(mText2, 50  + length1, 500, mPaint2);

        // 第三段文字
        float length2 = mPaint2.measureText(mText2);
        canvas.drawText(mText3, 50 + length1 + length2, 500, mPaint1);
    }
}
