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
 * setFakeBoldText(boolean fakeBoldText)
 * 是否使用伪粗体
 * 因为它并不是通过选用更高 weight 的字体让文字变粗，而是通过程序在运行时把文字给「描粗」了
 **/
public class SetFakeBoldTextView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private String mText = "人人都是灵动岛";

    {
        mPaint.setTextSize(100);
        mPaint.setColor(Color.RED);
    }

    public SetFakeBoldTextView(Context context) {
        this(context, null);
    }

    public SetFakeBoldTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SetFakeBoldTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public SetFakeBoldTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText(mText, 100, 300, mPaint);

        // 设置伪粗体
        mPaint.setFakeBoldText(true);
        canvas.drawText(mText, 100, 699, mPaint);

    }
}
