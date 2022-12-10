package com.example.basiccustomview.customview.customview7;

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

import com.example.basiccustomview.Utils;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/12/4 23:02
 **/
public class CircleView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int mColor = Color.parseColor("#ffff0000");
    private float mRadius = Utils.dpToPixel(100);

    {
        mPaint.setColor(mColor);
    }

    public CircleView(Context context) {
        this(context, null);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public int getColor() {
        return mColor;
    }

    public void setColor(int color) {
        mColor = color;
        mPaint.setColor(mColor);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        canvas.drawCircle(centerX, centerY, mRadius, mPaint);
    }

    /**
     * 1、ArgbEvaluator
     * 如视频中的例子，TypeEvaluator 最经典的用法是使用 ArgbEvaluator 来做颜色渐变的动画。
     * ObjectAnimator animator = ObjectAnimator.ofInt(view, "color", 0xffff0000, 0xff00ff00);
     * animator.setEvaluator(new ArgbEvaluator());
     * animator.start();
     */
    public void startAnimSetEvaluator() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(this, "color", 0xffff0000, 0xff00ff00);
        // 设置估值器
        objectAnimator.setEvaluator(new ArgbEvaluator());
        objectAnimator.setDuration(800);
        objectAnimator.start();

        /**
         * 在 Android 5.0 （API 21） 加入了新的方法 ofArgb()，所以如果你的 minSdk 大于或者等于 21
         * 你可以直接用下面这种方式：
         * ObjectAnimator animator = ObjectAnimator.ofArgb(view, "color", 0xffff0000, 0xff00ff00);
         * animator.start();
         */
        // ObjectAnimator objectAnimator = ObjectAnimator.ofArgb(this, "color", 0xffff0000, 0xff00ff00);
        // objectAnimator.start();
    }

    public void resetAnimSetEvaluator() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(this, "color", 0xff00ff00, 0xffff0000);
        // 设置估值器
        objectAnimator.setEvaluator(new ArgbEvaluator());
        objectAnimator.start();

    }

    /**
     * 2、自定义 Evaluator
     * 如果你对 ArgbEvaluator 的效果不满意，或者你由于别的什么原因希望写一个自定义的 TypeEvaluator，
     * 你可以这样写：
     * 自定义 HslEvaluator
     */
    private class HsvEvaluator implements TypeEvaluator<Integer> {
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

    public void customEvaluator() {
        ObjectAnimator animator = ObjectAnimator.ofInt(this, "color", 0xffff0000, 0xff00ff00);
        // 使用自定义的 HslEvaluator
        animator.setEvaluator(new HsvEvaluator());
        animator.setDuration(800);
        animator.start();
    }
}
