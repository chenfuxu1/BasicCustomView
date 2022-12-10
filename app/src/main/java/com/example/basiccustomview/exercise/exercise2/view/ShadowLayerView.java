package com.example.basiccustomview.exercise.exercise2.view;

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
 * DateTime: 2022/11/20 16:24
 *
 * 使用 Paint.setShadowLayer() 设置阴影
 * 方法的参数里， radius 是阴影的模糊范围； dx dy 是阴影的偏移量； shadowColor 是阴影的颜色。
 * 如果要清除阴影层，使用 clearShadowLayer()
 * 注意：
 * 在硬件加速开启的情况下， setShadowLayer() 只支持文字的绘制，文字之外的绘制必须关闭硬件加速才能正常
 * 绘制阴影。
 * 如果 shadowColor 是半透明的，阴影的透明度就使用 shadowColor 自己的透明度；而如果 shadowColor 是不
 * 透明的，阴影的透明度就使用 paint 的透明度
 **/
public class ShadowLayerView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public ShadowLayerView(Context context) {
        super(context);
    }

    public ShadowLayerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ShadowLayerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setShadowLayer(10, 0, 0, Color.RED);
        mPaint.setTextSize(120);
        canvas.drawText("在这个光怪陆离", 80, 300, mPaint);
    }
}
