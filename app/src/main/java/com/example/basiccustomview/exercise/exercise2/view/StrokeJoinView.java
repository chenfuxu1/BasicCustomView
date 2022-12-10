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
 * 使用 Paint.setStrokeJoin() 来设置不同的拐角形状
 * 有三个值可以选择：MITER 尖角、 BEVEL 平角和 ROUND 圆角。默认为 MITER
 *
 * canvas.translate(100, 100);
 * 第一种形状：MITER
 * canvas.drawPath(path, paint);
 *
 * canvas.translate(300, 0);
 * 第二种形状：BEVEL
 * canvas.drawPath(path, paint);
 *
 * canvas.translate(300, 0);
 * 第三种形状：ROUND
 * canvas.drawPath(path, paint);
 **/
public class StrokeJoinView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path mPath = new Path();

    public StrokeJoinView(Context context) {
        super(context);
    }

    public StrokeJoinView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public StrokeJoinView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStrokeWidth(40);
        mPaint.setStyle(Paint.Style.STROKE);
        mPath.rLineTo(200, 0);
        mPath.rLineTo(-160, 120);

        // 第一种形状：MITER（尖角）
        mPaint.setStrokeJoin(Paint.Join.MITER);
        canvas.translate(100, 100); // 图像向左平移 100，向下平移 100
        canvas.drawPath(mPath, mPaint);

        // 第二种形状：BEVEL（平角）
        mPaint.setStrokeJoin(Paint.Join.BEVEL);
        canvas.translate(300, 0); // 图像水平向右平移 300
        canvas.drawPath(mPath, mPaint);

        // 第三种形状：ROUND（圆角）
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        canvas.translate(300, 0);
        canvas.drawPath(mPath, mPaint);
    }
}
