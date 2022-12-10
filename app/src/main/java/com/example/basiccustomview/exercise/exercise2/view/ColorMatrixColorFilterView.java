package com.example.basiccustomview.exercise.exercise2.view;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.basiccustomview.R;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/11/20 16:24
 *
 * 使用 setColorFilter() 设置一个 ColorMatrixColorFilter
 * 用 ColorMatrixColorFilter.setSaturation() 把饱和度去掉
 *
 * ColorMatrixColorFilter 使用一个 ColorMatrix 来对颜色进行处理。
 * ColorMatrix 这个类，内部是一个 4x5 的矩阵：
 * [ a, b, c, d, e,
 *   f, g, h, i, j,
 *   k, l, m, n, o,
 *   p, q, r, s, t ]
 * 通过计算， ColorMatrix 可以把要绘制的像素进行转换。对于颜色 [R, G, B, A] ，转换算法是这样的：
 * R’ = a*R + b*G + c*B + d*A + e;
 * G’ = f*R + g*G + h*B + i*A + j;
 * B’ = k*R + l*G + m*B + n*A + o;
 * A’ = p*R + q*G + r*B + s*A + t;
 **/
public class ColorMatrixColorFilterView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public ColorMatrixColorFilterView(Context context) {
        super(context);
    }

    public ColorMatrixColorFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ColorMatrixColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.yihu);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(new float[] {
                1, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 1, 0, 0,
                0, 0, 0, 0.8f, 0
        });
        ColorMatrixColorFilter colorFilter = new ColorMatrixColorFilter(colorMatrix);
        mPaint.setColorFilter(colorFilter);
        canvas.drawBitmap(bitmap, 0, 0, mPaint);
    }
}
