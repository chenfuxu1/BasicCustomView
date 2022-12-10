package com.example.basiccustomview.exercise.exercise7.view.argbevaluator;

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
public class ArgbEvaluatorView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final float mRadius = 450f;
    private int mColor = Color.parseColor("#FFFF0000");
    // 设置估值器
    private TypeEvaluator mTypeEvaluator = new ArgbEvaluator();

    public ArgbEvaluatorView(Context context) {
        this(context, null);
    }

    public ArgbEvaluatorView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ArgbEvaluatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public ArgbEvaluatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(this, "color", 0xffff0000, 0xff00ff00);
        objectAnimator.setEvaluator(mTypeEvaluator);
        objectAnimator.setDuration(1000);
        objectAnimator.start();
    }

    public void resetAnim() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(this, "color", 0xff00ff00, 0xffff0000);
        objectAnimator.setEvaluator(mTypeEvaluator);
        objectAnimator.setDuration(1000);
        objectAnimator.start();
    }
}
