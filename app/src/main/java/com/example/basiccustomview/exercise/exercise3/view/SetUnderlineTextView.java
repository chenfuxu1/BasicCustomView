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
 * setUnderlineText(boolean underlineText)
 * 是否加下划线
 **/
public class SetUnderlineTextView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private String mText = "光怪陆离的人间";

    {
        mPaint.setTextSize(100);
        mPaint.setColor(Color.GREEN);
    }

    public SetUnderlineTextView(Context context) {
        this(context, null);
    }

    public SetUnderlineTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SetUnderlineTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public SetUnderlineTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText(mText, 100, 200, mPaint);

        // 设置下划线
        mPaint.setUnderlineText(true);
        mPaint.setFakeBoldText(true); // 设置伪粗体
        canvas.drawText(mText, 100, 500, mPaint);
    }
}
