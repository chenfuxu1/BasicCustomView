package com.example.basiccustomview.exercise.exercise2.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/11/20 16:24
 *
 * 用 Paint.setShader(shader) 设置一个 RadialGradient
 * RadialGradient 的参数：圆心坐标：(300, 300)；半径：200；颜色：#E91E63 到 #2196F3
 *
 * 构造方法：
 * RadialGradient(float centerX, float centerY, float radius, int centerColor,
 * int edgeColor, TileMode tileMode)。
 * 参数：
 * centerX centerY：辐射中心的坐标
 * radius：辐射半径
 * centerColor：辐射中心的颜色
 * edgeColor：辐射边缘的颜色
 * tileMode：辐射范围之外的着色模式
 **/
public class RadialGradView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public RadialGradView(Context context) {
        this(context, null);
    }

    public RadialGradView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RadialGradView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Shader shader = new RadialGradient(300, 300, 200,
                Color.parseColor("#FFFF00"),
                Color.parseColor("#FF00FF"), Shader.TileMode.CLAMP);
        mPaint.setShader(shader);
        canvas.drawCircle(300, 300, 200, mPaint);
    }
}
