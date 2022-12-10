package com.example.basiccustomview.exercise.exercise2.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/11/20 16:24
 *
 * 用 Paint.setShader(shader) 设置一个 LinearGradient
 * LinearGradient 的参数：坐标：(100, 100) 到 (500, 500) ；颜色：#E91E63 到 #2196F3
 *
 * 构造方法：
 * LinearGradient(float x0, float y0, float x1, float y1, int color0, int color1,
 * Shader.TileMode tile) 。
 *
 * 参数：
 * x0 y0 x1 y1：渐变的两个端点的位置
 * color0 color1 是端点的颜色
 * tile：端点范围之外的着色规则，类型是 TileMode。TileMode 一共有 3 个值可选： CLAMP, MIRROR 和 REPEAT。
 * CLAMP 会在端点之外延续端点处的颜色；MIRROR 是镜像模式；REPEAT 是重复模式
 *
 **/
public class LinearGradientView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public LinearGradientView(Context context) {
        this(context, null);
    }

    public LinearGradientView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LinearGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Shader shader = new LinearGradient(100, 100, 500, 500,
                Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);
        mPaint.setShader(shader);
        canvas.drawCircle(300, 300, 200, mPaint);
    }
}
