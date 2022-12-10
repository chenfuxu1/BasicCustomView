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
 **/
public class GetFontSpacingView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private String mText = "光怪陆离的人间";

    {
        mPaint.setTextSize(100);
        mPaint.setColor(Color.MAGENTA);
    }

    public GetFontSpacingView(Context context) {
        this(context, null);
    }

    public GetFontSpacingView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GetFontSpacingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public GetFontSpacingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float spaceY = 100;

        canvas.drawText(mText, 100, spaceY, mPaint);

        canvas.drawText(mText, 100, spaceY + mPaint.getFontSpacing(), mPaint);

        canvas.drawText(mText, 100, spaceY+ mPaint.getFontSpacing() * 2, mPaint);

        canvas.drawText(mText, 100, spaceY + mPaint.getFontSpacing() * 3, mPaint);

        canvas.drawText(mText, 100, spaceY + mPaint.getFontSpacing() * 4, mPaint);


    }
}
