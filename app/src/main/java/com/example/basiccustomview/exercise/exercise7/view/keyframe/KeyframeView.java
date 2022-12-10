package com.example.basiccustomview.exercise.exercise7.view.keyframe;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/12/7 19:58
 **/
public class KeyframeView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private ObjectAnimator mObjectAnimator;
    private float mProgress = 0f;
    private float mCenterX;
    private float mCenterY;
    private final float mRadius = 400f;


    {
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(60);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public KeyframeView(Context context) {
        this(context, null);
    }

    public KeyframeView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public KeyframeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public KeyframeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mCenterX = getWidth() / 2;
        mCenterY = getHeight() / 2;
        // 1、绘制进度条
        RectF rectF = new RectF();
        rectF.left = mCenterX - mRadius;
        rectF.right = mCenterX + mRadius;
        rectF.top = mCenterY - mRadius;
        rectF.bottom = mCenterY + mRadius;
        canvas.drawArc(rectF, 135, (float) (mProgress * 2.7), false, mPaint);

        // 2、绘制中间的百分比文字
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setTextSize(150);
        Rect rectBounds = new Rect();
        String progressStr = (int) mProgress + " %";
        mPaint.getTextBounds(progressStr, 0, progressStr.length(), rectBounds);
        float strWidth = rectBounds.right - rectBounds.left;
        float strHeight = rectBounds.bottom - rectBounds.top;
        canvas.drawText(progressStr, mCenterX - strWidth / 2, mCenterY + strHeight / 2, mPaint);

        // 3、设置内外圈的圆
        mPaint.setStrokeWidth(30);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.GREEN);
        canvas.drawCircle(mCenterX, mCenterY, mRadius - 30 - 15, mPaint);
        canvas.drawCircle(mCenterX, mCenterY, mRadius + 30 + 15, mPaint);
        mPaint.setColor(Color.parseColor("#55ff0000"));
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(mCenterX, mCenterY, mRadius - 200, mPaint); // 绘制最中心圆

        // 4、重置状态
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(60);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    public void setProgress(float progress) {
        this.mProgress = progress;
        invalidate();
    }

    public float getProgress() {
        return mProgress;
    }

    public void startAnim() {
        /**
         * fraction: 时间完成度
         * value：动画值完成度
         */
        Keyframe keyframe1 = Keyframe.ofFloat(0, 0f); // 时间：0 progress: 0%
        Keyframe keyframe2 = Keyframe.ofFloat(0.5f, 100f); // 时间：50% progress: 100%
        Keyframe keyframe3 = Keyframe.ofFloat(1f, 80f); // 时间：100% progress: 80%
        PropertyValuesHolder holder = PropertyValuesHolder.ofKeyframe("progress",
                keyframe1, keyframe2, keyframe3);
        mObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(this, holder);
        mObjectAnimator.setDuration(3000);
        mObjectAnimator.setInterpolator(new FastOutSlowInInterpolator());
        mObjectAnimator.start();
    }

    public void resetAnim() {
        /**
         * fraction: 时间完成度
         * value：动画值完成度
         */
        Keyframe keyframe1 = Keyframe.ofFloat(0, 80f); // 时间：0 progress: 80%
        Keyframe keyframe2 = Keyframe.ofFloat(0.5f, -20f); // 时间：50% progress: -20%
        Keyframe keyframe3 = Keyframe.ofFloat(1f, 0f); // 时间：100% progress: 0%
        PropertyValuesHolder holder = PropertyValuesHolder.ofKeyframe("progress",
                keyframe1, keyframe2, keyframe3);
        mObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(this, holder);
        mObjectAnimator.setDuration(3000);
        mObjectAnimator.setInterpolator(new FastOutSlowInInterpolator());
        mObjectAnimator.start();
    }
}
