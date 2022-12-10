package com.example.basiccustomview.exercise.exercise6.view;

import static android.graphics.Paint.Cap.ROUND;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.PathInterpolator;

import androidx.annotation.Nullable;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/12/1 23:36
 **/
public class SportsView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private float mProgress = 0f;
    private float mRadius = 200;
    private float mCenterX;
    private float mCenterY;

    {
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(40);
        mPaint.setTextSize(60);
        mPaint.setStrokeCap(ROUND);
    }

    public SportsView(Context context) {
        this(context, null);
    }

    public SportsView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SportsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public SportsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    // 给 ObjectAnimator 使用
    public float getProgress() {
        return mProgress;
    }

    /**
     * 给 ObjectAnimator 使用
     * ObjectAnimator 执行动画时，会不断不断改变 progress 的值
     * 进而赋值给 mProgress 进行重新绘制
     */
    public void setProgress(float progress) {
        mProgress = progress;
        // 这里重新绘制
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mCenterX = getWidth() / 2;
        mCenterY = getHeight() / 2;

        // 1、弧形范围计算
        RectF rectF = new RectF(mCenterX - mRadius, mCenterY - mRadius,
                mCenterX + mRadius, mCenterY + mRadius);
        /**
         * rectF: 绘制的区域
         * startAngle：开始角度
         * sweepAngle：扫过的角度(顺时针为正，逆时针为负)，此处 mProgress 表示扫过的百分比
         * useCenter：是否连接圆心
         * paint：使用的画笔
         */
        canvas.drawArc(rectF, 120, mProgress * 360 / 100, false, mPaint);

        // 2、绘制中心的百分比
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.FILL);
        String text = (int) mProgress + " %";
        Rect rect = new Rect();
        mPaint.getTextBounds(text, 0, text.length(), rect);
        float textWidth = rect.right - rect.left;
        float textHeight = rect.bottom - rect.top;
        canvas.drawText(text, 0, text.length(), mCenterX - textWidth / 2,
                mCenterY + textHeight / 2, mPaint);

        // 3、圆弧内外加圆圈
        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(6);
        canvas.drawCircle(mCenterX, mCenterY, mRadius + 20, mPaint);
        canvas.drawCircle(mCenterX, mCenterY, mRadius - 20, mPaint);

        // 复位画笔
        mPaint.setStrokeWidth(40);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.RED);
    }

    public void startAnim() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(this, "progress", 0, 65);
        objectAnimator.setDuration(1000);
        objectAnimator.setInterpolator(new FastOutSlowInInterpolator());
        objectAnimator.start();
    }

    public void resetAnim() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(this, "progress", 65, 0);
        objectAnimator.setDuration(1000);
        objectAnimator.setInterpolator(new FastOutSlowInInterpolator());
        objectAnimator.start();
    }
}
