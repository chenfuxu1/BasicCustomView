package com.example.basiccustomview.customview.customview7;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/12/5 22:30
 **/
public class PointView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private PointF mCurrentPoint = new PointF();
    private float mRadius = 40f;

    {
        mPaint.setColor(Color.RED);
    }

    public PointView(Context context) {
        this(context, null);
    }

    public PointView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public PointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float centerX = mCurrentPoint.x;
        float centerY = mCurrentPoint.y;
        if (centerX > 20 && centerY > 20) {
            canvas.drawCircle(centerX, centerY, mRadius, mPaint);
        }
    }

    public void setPos(PointF pointF) {
        mCurrentPoint = pointF;
        invalidate();
    }

    private static class PointEvaluator implements TypeEvaluator<PointF> {
        PointF mNewPointF = new PointF();

        @Override
        public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
            // 计算动画执行过程中需要转换的 x, y 坐标( 一次函数)
            float x = startValue.x + (endValue.x - startValue.x) * fraction;
            float y = startValue.y + (endValue.y - startValue.y) * fraction;
            mNewPointF.set(x, y);
            return mNewPointF;
        }
    }

    public void startAnim() {
        float width = getWidth();
        float height = getHeight();
        PointEvaluator pointEvaluator = new PointEvaluator();
        ObjectAnimator objectAnimator = ObjectAnimator.ofObject(this, "pos", pointEvaluator
                , new PointF(0, 0), new PointF(width, height));
        objectAnimator.setDuration(2000);
        objectAnimator.start();
    }

    public void resetAnim() {
        float width = getWidth();
        float height = getHeight();
        PointEvaluator pointEvaluator = new PointEvaluator();
        ObjectAnimator objectAnimator = ObjectAnimator.ofObject(this, "pos", pointEvaluator
                , new PointF(width, height), new PointF(0, 0));
        objectAnimator.setDuration(1000);
        objectAnimator.start();
    }
}
