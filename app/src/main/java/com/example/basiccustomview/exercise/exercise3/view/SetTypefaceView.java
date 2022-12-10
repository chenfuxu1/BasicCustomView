package com.example.basiccustomview.exercise.exercise3.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/11/23 23:38
 *
 * 使用 Paint.setTypeface() 来设置不同的字体
 *
 **/
public class SetTypefaceView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private String mText = "在那不遥远的地方！";
    private Typeface mTypeface;

    {
        mPaint.setTextSize(60);
        mTypeface = Typeface.DEFAULT;
    }

    public SetTypefaceView(Context context) {
        this(context, null);
    }

    public SetTypefaceView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SetTypefaceView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public SetTypefaceView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 第一处：填入 null 来设置默认字体
        canvas.drawText(mText, 50, 100, mPaint);

        // 第二处：填入 Typeface.SERIF 来设置衬线字体（宋体）
        mTypeface = Typeface.SERIF;
        mPaint.setTypeface(mTypeface);
        canvas.drawText(mText, 50, 300, mPaint);

        // 第三处：填入 typeface 对象来使用 assets 目录下的 "Satisfy-Regular.ttf" 文件
        mTypeface = Typeface.createFromAsset(getContext().getAssets(), "Satisfy-Regular.ttf");
        mPaint.setTypeface(mTypeface);
        canvas.drawText(mText, 50, 500, mPaint);
    }
}
