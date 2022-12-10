package com.example.basiccustomview.exercise.exercise3.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.SoundEffectConstants;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/11/23 23:38
 *
 * FontMetircs getFontMetrics()
 * 获取 Paint 的 FontMetrics。
 *
 * FontMetrics 是个相对专业的工具类，它提供了几个文字排印方面的数值：ascent, descent, top, bottom, leading。
 * FontMetrics 提供的就是 Paint 根据当前字体和字号，得出的这些值的推荐值。它把这些值以变量的形式存储，供开发者需要时使用。
 * FontMetrics.ascent：float 类型。
 * FontMetrics.descent：float 类型。
 * FontMetrics.top：float 类型。
 * FontMetrics.bottom：float 类型。
 * FontMetrics.leading：float 类型。
 *
 * baseline: 上图中黑色的线。前面已经讲过了，它的作用是作为文字显示的基准线。
 * ascent / descent: 上图中绿色和橙色的线，它们的作用是限制普通字符的顶部和底部范围。
 * 普通的字符，上不会高过 ascent ，下不会低过 descent
 * top / bottom: 上图中蓝色和红色的线，它们的作用是限制所有字形（ glyph ）的顶部和底部范围
 *
 * 使用 Paint.getFontMetrics() 计算出文字的显示区域
 * 然后计算出文字的绘制位置，从而让文字上下居中
 * 这种居中算法的优点是，可以让不同的文字的 baseline 对齐
 **/
public class GetFontMetricsView extends View {
    private Paint mPaint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint mPaint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
    private String[] mTexts = {"A", "a", "J", "j", "Â", "â"};
    private String mText = "AaJjÂâ";
    private int mTop = 200;
    private int mBottom = 400;

    {
        mPaint1.setStyle(Paint.Style.STROKE);
        mPaint1.setStrokeWidth(20);
        mPaint1.setColor(Color.parseColor("#E91E63"));
        mPaint2.setTextSize(160);
    }

    public GetFontMetricsView(Context context) {
        this(context, null);
    }

    public GetFontMetricsView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GetFontMetricsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public GetFontMetricsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int middle = (mTop + mBottom) / 2;

        // 1.画出显示的区域矩形
        canvas.drawRect(50, mTop, getWidth() - 50, mBottom, mPaint1);
        Paint.FontMetrics fontMetrics = new Paint.FontMetrics();
        mPaint2.getFontMetrics(fontMetrics); // 将文字的属性保存到 fontMetrics 中
        System.out.println("cfx fontMetrics.ascent = " + fontMetrics.ascent); // 顶部范围线
        System.out.println("cfx fontMetrics.descent = " + fontMetrics.descent); // 底部范围线
        System.out.println("cfx fontMetrics.top = " + fontMetrics.top); // 最顶端
        System.out.println("cfx fontMetrics.bottom = " + fontMetrics.bottom); // 最低端
        float offset = (fontMetrics.ascent + fontMetrics.descent) / 2; // 计算偏移量
        middle = (int) (middle - offset);
        canvas.drawText(mTexts[0], 100, middle, mPaint2);
        canvas.drawText(mTexts[1], 200, middle, mPaint2);
        canvas.drawText(mTexts[2], 300, middle, mPaint2);
        canvas.drawText(mTexts[3], 400, middle, mPaint2);
        canvas.drawText(mTexts[4], 500, middle, mPaint2);
        canvas.drawText(mTexts[5], 600, middle, mPaint2);

        // 画出五种线
        mPaint2.setTextSize(260);
        mPaint2.getFontMetrics(fontMetrics);
        float textWidth = mPaint2.measureText(mText); // 文字内容宽度
        float textHeight = fontMetrics.descent - fontMetrics.ascent; // 文字内容高度
        float baselineY = (fontMetrics.ascent + fontMetrics.descent) / 2; // 基线
        int baseline = (500 + 900) / 2;
        baseline = (int) (baseline - baselineY); // 矩形区域内基线
        float ascentY = 0f; // 顶部范围
        float descentY = 0f; // 底部范围
        float topY = 0f; // 最顶端
        float bottomY = 0f; // 最低端
        canvas.drawRect(50, 500, getWidth() - 50, 900, mPaint1);
        canvas.drawText(mText, 80, baseline, mPaint2);

        // 画基线
        mPaint1.setStyle(Paint.Style.STROKE);
        mPaint1.setStrokeWidth(5);
        mPaint1.setColor(Color.RED);
        canvas.drawLine(80, baseline, textWidth + 80 + 30, baseline, mPaint1);
        mPaint1.setStyle(Paint.Style.FILL);
        mPaint1.setTextSize(25);
        canvas.drawText("baseline", textWidth + 80 + 30, baseline, mPaint1);

        // 画 top 线
        topY = baseline + fontMetrics.top;
        mPaint1.setStyle(Paint.Style.STROKE);
        mPaint1.setStrokeWidth(5);
        mPaint1.setColor(Color.GREEN);
        canvas.drawLine(80, topY, textWidth + 80 + 30, topY, mPaint1);
        mPaint1.setStyle(Paint.Style.FILL);
        mPaint1.setTextSize(25);
        canvas.drawText("top", textWidth + 80 + 30, topY, mPaint1);

        // 画 bottom 线
        bottomY = baseline + fontMetrics.bottom;
        mPaint1.setStyle(Paint.Style.STROKE);
        mPaint1.setStrokeWidth(5);
        mPaint1.setColor(Color.CYAN);
        canvas.drawLine(80, bottomY, textWidth + 80 + 30, bottomY, mPaint1);
        mPaint1.setStyle(Paint.Style.FILL);
        mPaint1.setTextSize(25);
        canvas.drawText("bottom", textWidth + 80 + 30, bottomY, mPaint1);

        // 画 ascent 线
        ascentY = baseline + fontMetrics.ascent;
        mPaint1.setStyle(Paint.Style.STROKE);
        mPaint1.setStrokeWidth(5);
        mPaint1.setColor(Color.MAGENTA);
        canvas.drawLine(80, ascentY, textWidth + 80 + 30, ascentY, mPaint1);
        mPaint1.setStyle(Paint.Style.FILL);
        mPaint1.setTextSize(25);
        canvas.drawText("ascent", textWidth + 80 + 30, ascentY, mPaint1);

        // 画 descent 线
        descentY = baseline + fontMetrics.descent;
        mPaint1.setStyle(Paint.Style.STROKE);
        mPaint1.setStrokeWidth(5);
        mPaint1.setColor(Color.BLUE);
        canvas.drawLine(80, descentY, textWidth + 80 + 30, descentY, mPaint1);
        mPaint1.setStyle(Paint.Style.FILL);
        mPaint1.setTextSize(25);
        canvas.drawText("descent", textWidth + 80 + 30, descentY - 10, mPaint1);

    }
}
