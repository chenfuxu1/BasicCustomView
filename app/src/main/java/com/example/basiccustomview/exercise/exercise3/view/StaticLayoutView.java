package com.example.basiccustomview.exercise.exercise3.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/11/23 23:38
 *
 * 使用 StaticLayout 代替 Canvas.drawText() 来绘制文字，
 * 以绘制出带有换行的文字
 *
 * StaticLayout 的构造方法是 StaticLayout(CharSequence source, TextPaint paint, int width,
 * Layout.Alignment align, float spacingmult, float spacingadd, boolean includepad)，其中参数里：
 *
 * width 是文字区域的宽度，文字到达这个宽度后就会自动换行；
 * align 是文字的对齐方向；
 * spacingmult 是行间距的倍数，通常情况下填 1 就好；
 * spacingadd 是行间距的额外增加值，通常情况下填 0 就好；
 * includepad 是指是否在文字上下添加额外的空间，来避免某些过高的字符的绘制出现越界。
 *
 * 如果你需要进行多行文字的绘制，并且对文字的排列和样式没有太复杂的花式要求，那么使用 StaticLayout 就好。
 **/
public class StaticLayoutView extends View {
    private TextPaint mPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
    private String mText = "在那不遥远的地方，\n有我为你";

    public StaticLayoutView(Context context) {
        this(context, null);
    }

    public StaticLayoutView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StaticLayoutView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public StaticLayoutView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setTextSize(100);
        mPaint.setColor(Color.CYAN);
        canvas.translate(100, 300);
        StaticLayout staticLayout = new StaticLayout(mText, mPaint, 1000, Layout.Alignment.ALIGN_NORMAL,
                1, 0, true);
        staticLayout.draw(canvas);
    }
}
