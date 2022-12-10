package com.example.basiccustomview.customview.customview7;

import static android.graphics.Paint.Cap.ROUND;

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

import com.example.basiccustomview.Logit;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/12/1 23:36
 **/
public class SportsView extends View {
    private static final String TAG = "SportsView";
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

    /**
     * PropertyValuesHolders.ofKeyframe() 把同一个属性拆分
     * 除了合并多个属性和调配多个动画，你还可以在 PropertyValuesHolder 的基础上更进一步，通过设置
     * Keyframe （关键帧），把同一个动画属性拆分成多个阶段。例如，你可以让一个进度增加到 100% 后再
     * 「反弹」回来。
     */
    public void startAnimOfKeyframe() {
        /**
         * 参数1：时间完成度
         * 参数2：动画完成度
         * 表示时间经过 %0，动画完成度 %0
         */
        Keyframe keyframe1 = Keyframe.ofFloat(0, 0);
        // 表示时间经过 %50，动画完成度 %100
        Keyframe keyframe2 = Keyframe.ofFloat(0.5f, 100);
        // 表示时间经过 %100，动画完成度 %80
        Keyframe keyframe3 = Keyframe.ofFloat(1f, 80);
        PropertyValuesHolder holder = PropertyValuesHolder.ofKeyframe("progress", keyframe1, keyframe2, keyframe3);
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(this, holder);
        animator.setDuration(1000);
        animator.start();
    }


    public void resetAnim() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(this, "progress", 80, 0);
        objectAnimator.setDuration(1000);
        objectAnimator.setInterpolator(new FastOutSlowInInterpolator());
        objectAnimator.start();
    }


}
