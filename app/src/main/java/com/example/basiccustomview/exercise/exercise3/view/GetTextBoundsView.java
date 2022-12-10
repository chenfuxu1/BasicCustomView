package com.example.basiccustomview.exercise.exercise3.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/11/23 23:38
 *
 * getTextBounds(String text, int start, int end, Rect bounds)
 * 获取文字的显示范围。
 * 参数里，text 是要测量的文字，start 和 end 分别是文字的起始和结束位置，bounds 是存储文字显示范围的对象，
 * 方法在测算完成之后会把结果写进 bounds
 *
 * 使用 Paint.getTextBounds() 计算出文字的显示区域
 * 然后计算出文字的绘制位置，从而让文字上下居中
 * 这种居中算法的优点是，可以让文字精准地居中，分毫不差
 **/
public class GetTextBoundsView extends View {
    private Paint mPaint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint mPaint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
    private String mText1 = "A";
    private String mText2 = "a";
    private String mText3 = "J";
    private String mText4 = "j";
    private String mText5 = "Â";
    private String mText6 = "â";
    private int mTop = 200;
    private int mBottom = 400;

    {
        mPaint1.setStyle(Paint.Style.STROKE);
        mPaint1.setStrokeWidth(20);
        mPaint2.setColor(Color.parseColor("#E91E63"));
        mPaint2.setTextSize(160);
    }

    public GetTextBoundsView(Context context) {
        this(context, null);
    }

    public GetTextBoundsView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GetTextBoundsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public GetTextBoundsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int middle = (mTop + mBottom) / 2;
        Rect bound = new Rect();

        // 1.画出显示的区域矩形
        canvas.drawRect(50, mTop, getWidth() - 50, mBottom, mPaint1);

        // 2.计算中间的位置坐标
        mPaint2.getTextBounds(mText1, 0, 1, bound);
        int middle1 = (bound.top + bound.bottom) / 2; // 绝对坐标，相对于坐标原点
        middle1 = middle - middle1; // 计算出文字需要在矩形区域内中心坐标
        canvas.drawText(mText1, 100, middle1, mPaint2);

        mPaint2.getTextBounds(mText2, 0, 1, bound);
        int middle2 = (bound.top + bound.bottom) / 2; // 绝对坐标，相对于坐标原点
        middle2 = middle - middle2; // 计算出文字需要在矩形区域内中心坐标
        canvas.drawText(mText2, 200, middle2, mPaint2);

        mPaint2.getTextBounds(mText3, 0, 1, bound);
        int middle3 = (bound.top + bound.bottom) / 2; // 绝对坐标，相对于坐标原点
        middle3 = middle - middle3; // 计算出文字需要在矩形区域内中心坐标
        canvas.drawText(mText3, 300, middle3, mPaint2);

        mPaint2.getTextBounds(mText4, 0, 1, bound);
        int middle4 = (bound.top + bound.bottom) / 2; // 绝对坐标，相对于坐标原点
        middle4 = middle - middle4; // 计算出文字需要在矩形区域内中心坐标
        canvas.drawText(mText4, 400, middle4, mPaint2);

        mPaint2.getTextBounds(mText5, 0, 1, bound);
        int middle5 = (bound.top + bound.bottom) / 2; // 绝对坐标，相对于坐标原点
        middle5 = middle - middle5; // 计算出文字需要在矩形区域内中心坐标
        canvas.drawText(mText5, 500, middle5, mPaint2);

        mPaint2.getTextBounds(mText6, 0, 1, bound);
        int middle6 = (bound.top + bound.bottom) / 2; // 绝对坐标，相对于坐标原点
        middle6 = middle - middle6; // 计算出文字需要在矩形区域内中心坐标
        canvas.drawText(mText6, 600, middle6, mPaint2);

    }
}
