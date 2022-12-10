package com.example.basiccustomview.exercise.exercise2.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/11/20 16:24
 *
 * 使用 Paint.getTextPath() 来获取文字的 Path
 * getTextPath(String text, int start, int end, float x, float y, Path path)
 * getTextPath(char[] text, int index, int count, float x, float y, Path path)
 *
 * 文字的绘制，虽然是使用 Canvas.drawText() 方法，但其实在下层，文字信息全是被转化成图形，
 * 对图形进行绘制的。 getTextPath() 方法，获取的就是目标文字所对应的 Path 。这个就是所谓「文字的 Path」
 **/
public class TextPathView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint mPathPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path mPath = new Path();
    private String mText = "人世间，如梦如幻";

    {
        mPaint.setTextSize(120);
        mPaint.setColor(Color.RED);
        mPathPaint.setStyle(Paint.Style.STROKE);
    }

    public TextPathView(Context context) {
        super(context);
    }

    public TextPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TextPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText(mText, 50, 200, mPaint);

        /**
         * 获取文字的 path
         * 参数1：字符串
         * 参数2：字符开始位置
         * 参数3：字符结束位置
         * 参数4：x 方向坐标偏移量
         * 参数5：y 方向坐标偏移量
         * 参数6：路径 path
         */
        mPaint.getTextPath(mText, 0, mText.length(), 50, 500, mPath);
        canvas.drawPath(mPath, mPathPaint);
    }
}
