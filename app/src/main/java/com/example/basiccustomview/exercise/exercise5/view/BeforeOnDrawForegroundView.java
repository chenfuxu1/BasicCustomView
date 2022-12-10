package com.example.basiccustomview.exercise.exercise5.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/11/28 23:21
 **/
public class BeforeOnDrawForegroundView extends AppCompatImageView {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    {
        mPaint.setTextSize(80);
        mPaint.setColor(Color.RED);
    }

    public BeforeOnDrawForegroundView(Context context) {
        this(context, null);
    }

    public BeforeOnDrawForegroundView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BeforeOnDrawForegroundView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onDrawForeground(Canvas canvas) {
        /**
         * 绘制在 onDrawForeground 方法前， onDraw 方法后
         * 可能会被绘制的前景色遮挡住
         */
        mPaint.setColor(Color.parseColor("#F44336"));
        canvas.drawRect(0, 40, 200, 120, mPaint);
        mPaint.setColor(Color.WHITE);
        canvas.drawText("New", 20 , 100, mPaint);

        super.onDrawForeground(canvas);
    }
}
