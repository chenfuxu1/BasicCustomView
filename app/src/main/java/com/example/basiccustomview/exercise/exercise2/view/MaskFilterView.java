package com.example.basiccustomview.exercise.exercise2.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
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
 * 用 Paint.setMaskFilter 来设置不同的 BlurMaskFilter
 * 为之后的绘制设置 MaskFilter。上一个方法 setShadowLayer() 是设置的在绘制层下方的附加效果；而这个
 * MaskFilter 和它相反，设置的是在绘制层上方的附加效果
 * MaskFilter 有两种： BlurMaskFilter 和 EmbossMaskFilter
 * 它的构造方法 BlurMaskFilter(float radius, BlurMaskFilter.Blur style) 中， radius
 * 参数是模糊的范围， style 是模糊的类型。一共有四种：
 * NORMAL: 内外都模糊绘制
 * SOLID: 内部正常绘制，外部模糊
 * INNER: 内部模糊，外部不绘制
 * OUTER: 内部不绘制，外部模糊
 **/
public class MaskFilterView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Bitmap mBitmap;

    {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.a);
    }

    public MaskFilterView(Context context) {
        super(context);
    }

    public MaskFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MaskFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 第一个：NORMAL
        mPaint.setMaskFilter(new BlurMaskFilter(50, BlurMaskFilter.Blur.NORMAL));
        canvas.drawBitmap(mBitmap, 100, 100, mPaint);

        // 第二个：INNER
        mPaint.setMaskFilter(new BlurMaskFilter(50, BlurMaskFilter.Blur.INNER));
        canvas.drawBitmap(mBitmap, 600, 100, mPaint);

        // 第三个：OUTER
        mPaint.setMaskFilter(new BlurMaskFilter(50, BlurMaskFilter.Blur.OUTER));
        canvas.drawBitmap(mBitmap, 100, 600, mPaint);

        // 第四个：SOLID
        mPaint.setMaskFilter(new BlurMaskFilter(50, BlurMaskFilter.Blur.SOLID));
        canvas.drawBitmap(mBitmap, 600, 600, mPaint);
    }
}
