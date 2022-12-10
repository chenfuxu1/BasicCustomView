package com.example.basiccustomview.exercise.exercise2.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/11/20 16:24
 *
 * setStrokeMiter(float miter)
 * 这个方法是对于 setStrokeJoin() 的一个补充，它用于设置 MITER 型拐角的延长线的最大值
 **/
public class StrokeMiterView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path mPath = new Path();

    public StrokeMiterView(Context context) {
        super(context);
    }

    public StrokeMiterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public StrokeMiterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStrokeWidth(40);
        mPaint.setStyle(Paint.Style.STROKE);
        mPath.rLineTo(200, 0);
        mPath.rLineTo(-160, 120);

        canvas.save();

        // MITER = 1
        mPaint.setStrokeMiter(1);
        canvas.translate(100, 100);
        canvas.drawPath(mPath, mPaint);

        // MITER = 2
        mPaint.setStrokeMiter(2);
        canvas.translate(300, 0);
        canvas.drawPath(mPath, mPaint);

        // MITER = 5
        mPaint.setStrokeMiter(5);
        canvas.translate(300, 0);
        canvas.drawPath(mPath, mPaint);

        canvas.restore();
    }
}
