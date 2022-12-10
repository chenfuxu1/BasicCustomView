package com.example.basiccustomview.exercise.exercise2.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/11/20 16:24
 *
 * 使用 Paint.setStrokeCap() 来设置端点形状
 * 第一个：BUTT
 * canvas.drawLine(50, 50, 400, 50, paint);
 *
 * 第二个：ROUND
 * canvas.drawLine(50, 150, 400, 150, paint);
 *
 * 第三个：SQUARE
 * canvas.drawLine(50, 250, 400, 250, paint);
 **/
public class StrokeCapView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public StrokeCapView(Context context) {
        super(context);
    }

    public StrokeCapView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public StrokeCapView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStrokeWidth(30);
        // 第一个：BUTT
        mPaint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawLine(50, 50, 400, 50, mPaint);

        // 第二个：ROUND
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawLine(50, 150, 400, 150, mPaint);

        // 第三个：SQUARE
        mPaint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawLine(50, 250, 400, 250, mPaint);

    }
}
