package com.example.basiccustomview.exercise.exercise1.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/11/16 23:13
 *
 * 练习内容：
 * 使用 canvas.drawColor() 方法把 View 涂成黄色
 * 黄色： Color.YELLOW
 *
 **/
public class DrawColorView extends View {
    public DrawColorView(Context context) {
        this(context, null);
    }

    public DrawColorView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawColorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.YELLOW);
    }
}
