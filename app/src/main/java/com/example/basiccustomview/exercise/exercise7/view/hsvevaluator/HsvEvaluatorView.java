package com.example.basiccustomview.exercise.exercise7.view.hsvevaluator;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/12/7 19:58
 **/
public class HsvEvaluatorView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final float mRadius = 450f;
    private int mColor = Color.parseColor("#FF0000FF");
    // 自定义估值器
    private HsvEvaluator mHsvEvaluator = new HsvEvaluator();

    public HsvEvaluatorView(Context context) {
        this(context, null);
    }

    public HsvEvaluatorView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HsvEvaluatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public HsvEvaluatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        mPaint.setColor(mColor);
        canvas.drawCircle(centerX, centerY, mRadius, mPaint);
    }

    public void setColor(int color) {
        this.mColor = color;
        invalidate();
    }

    public void startAnim() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(this, "color", 0xFF0000FF, 0xFFFFFF00);
        objectAnimator.setEvaluator(mHsvEvaluator);
        objectAnimator.setDuration(1000);
        objectAnimator.start();
    }

    public void resetAnim() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(this, "color", 0xFFFFFF00, 0xFF0000FF);
        objectAnimator.setEvaluator(mHsvEvaluator);
        objectAnimator.setDuration(1000);
        objectAnimator.start();
    }

    private static class HsvEvaluator implements TypeEvaluator<Integer> {
        float[] startHsv = new float[3];
        float[] endHsv = new float[3];
        float[] outHsv = new float[3];

        @Override
        public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
            // 把 ARGB 转换成 HSV
            Color.colorToHSV(startValue, startHsv);
            Color.colorToHSV(endValue, endHsv);

            // 计算当前动画完成度（fraction）所对应的颜色值
            if (endHsv[0] - startHsv[0] > 180) {
                endHsv[0] -= 360;
            } else if (endHsv[0] - startHsv[0] < -180) {
                endHsv[0] += 360;
            }
            outHsv[0] = startHsv[0] + (endHsv[0] - startHsv[0]) * fraction;
            if (outHsv[0] > 360) {
                outHsv[0] -= 360;
            } else if (outHsv[0] < 0) {
                outHsv[0] += 360;
            }
            outHsv[1] = startHsv[1] + (endHsv[1] - startHsv[1]) * fraction;
            outHsv[2] = startHsv[2] + (endHsv[2] - startHsv[2]) * fraction;

            // 计算当前动画完成度（fraction）所对应的透明度
            int alpha = startValue >> 24 + (int) ((endValue >> 24 - startValue >> 24) * fraction);

            // 把 HSV 转换回 ARGB 返回
            return Color.HSVToColor(alpha, outHsv);
        }
    }
}
