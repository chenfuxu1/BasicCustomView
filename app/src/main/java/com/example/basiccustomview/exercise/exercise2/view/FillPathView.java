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
 * 使用 Paint.getFillPath() 获取实际绘制的 Path
 * 首先解答第一个问题：「实际 Path」。所谓实际 Path ，指的就是 drawPath() 的绘制内容的轮廓，要算上线条
 * 宽度和设置的 PathEffect。
 * 默认情况下（线条宽度为 0、没有 PathEffect），原 Path 和实际 Path 是一样的；而在线条宽度不为 0
 * （并且模式为 STROKE 模式或 FLL_AND_STROKE ），或者设置了 PathEffect 的时候，实际 Path 就和原
 * Path 不一样了
 **/
public class FillPathView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path mPath = new Path();
    private Paint mPathPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path mPath1 = new Path();
    private Path mPath2 = new Path();
    private Path mPath3 = new Path();

    {
        mPath.moveTo(50, 100);
        mPath.rLineTo(50, 100);
        mPath.rLineTo(80, -150);
        mPath.rLineTo(100, 100);
        mPath.rLineTo(70, -120);
        mPath.rLineTo(150, 80);

        mPathPaint.setStyle(Paint.Style.STROKE);
    }

    public FillPathView(Context context) {
        super(context);
    }

    public FillPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FillPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 1
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStrokeWidth(0);
        canvas.drawPath(mPath, mPaint);

        canvas.save();
        canvas.translate(500, 0);
        // 第一处：获取 Path
        mPaint.getFillPath(mPath, mPath1);
        canvas.drawPath(mPath1, mPathPaint);
        canvas.restore();

        // 2
        canvas.save();
        canvas.translate(0, 200);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(mPath, mPaint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 200);
        // 第二处：设置 Style 为 STROKE 后再获取 Path
        mPaint.getFillPath(mPath, mPath2);
        canvas.drawPath(mPath2, mPathPaint);
        canvas.restore();

        // 3
        canvas.save();
        canvas.translate(0, 400);
        mPaint.setStrokeWidth(40);
        canvas.drawPath(mPath, mPaint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 400);
        // 第三处：Style 为 STROKE 并且线条宽度为 40 时的 Path
        mPaint.getFillPath(mPath, mPath3);
        canvas.drawPath(mPath3, mPathPaint);
        canvas.restore();
    }
}
