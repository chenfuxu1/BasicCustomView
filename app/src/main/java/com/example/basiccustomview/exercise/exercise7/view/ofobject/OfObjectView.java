package com.example.basiccustomview.exercise.exercise7.view.ofobject;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import androidx.annotation.Nullable;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/12/7 19:58
 **/
public class OfObjectView extends View {
    private static final int DURATION = 2000;
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private PointF mPosition = new PointF();
    private CircleEvaluator mCircleEvaluator;
    private PointF mStart;
    private PointF mEnd;
    private final float mRadius = 80f;
    private float mPointX;
    private float mPointY;

    {
        mPaint.setColor(Color.parseColor("#FF0000"));
        mCircleEvaluator = new CircleEvaluator();
        mStart = new PointF(mRadius, mRadius);
        mPosition.set(mRadius, mRadius);
    }

    public OfObjectView(Context context) {
        this(context, null);
    }

    public OfObjectView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OfObjectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public OfObjectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 1、获取当前动画执行的坐标
        mPointX = mPosition.x;
        mPointY = mPosition.y;

        // 2、在显示范围内画出圆形
        canvas.drawCircle(mPointX, mPointY, mRadius, mPaint);
    }

    public PointF getPosition() {
        return mPosition;
    }

    public void setPosition(PointF position) {
        if (mPosition != null) {
            mPosition.set(position);
            invalidate();
        }
    }

    public void startAnim() {
        // 结束点坐标
        mEnd = new PointF(getWidth() - mRadius, getHeight() - mRadius);
        ObjectAnimator objectAnimator = ObjectAnimator.ofObject(this, "position",
                mCircleEvaluator, mStart, mEnd);
        objectAnimator.setInterpolator(new LinearInterpolator());
        objectAnimator.setDuration(DURATION);
        objectAnimator.setEvaluator(mCircleEvaluator);
        objectAnimator.start();
    }

    public void resetAnim() {
        // 结束点坐标
        mEnd = new PointF(getWidth() - mRadius, getHeight() - mRadius);
        ObjectAnimator objectAnimator = ObjectAnimator.ofObject(this, "position",
                mCircleEvaluator, mEnd, mStart);
        objectAnimator.setInterpolator(new LinearInterpolator());
        objectAnimator.setDuration(DURATION);
        objectAnimator.setEvaluator(mCircleEvaluator);
        objectAnimator.start();
    }

    private static class CircleEvaluator implements TypeEvaluator<PointF> {
        private PointF newPoint = new PointF();

        /**
         * @param fraction   动画执行的比例：0 - 1 范围
         * @param startValue 开始点的坐标值
         * @param endValue   结束点的坐标值
         * @return
         */
        @Override
        public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
            // 1、运动轨迹为一次函数
            // float x = startValue.x + (fraction * (endValue.x - startValue.x));
            // float y = startValue.y + (fraction * (endValue.y - startValue.y));

            // 2、运动轨迹为二次函数
            // float x = startValue.x + (fraction * fraction * (endValue.x - startValue.x));
            // float y = startValue.y + (fraction * (endValue.y - startValue.y));

            // 3、运动轨迹为三次函数
            float x = startValue.x + (fraction * fraction * fraction * (endValue.x - startValue.x));
            float y = startValue.y + (fraction * (endValue.y - startValue.y));
            newPoint.set(x, y);
            return newPoint;
        }
    }
}
