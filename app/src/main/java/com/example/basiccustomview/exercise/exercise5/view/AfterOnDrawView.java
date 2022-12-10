package com.example.basiccustomview.exercise.exercise5.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.basiccustomview.R;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/11/28 23:21
 *
 * 在 super.onDraw() 的下方插入绘制代码，让绘制内容盖住原主体内容
 * 由于这期的重点是绘制代码的位置而不是绘制代码本身，所以直接给出绘制代码，你只要解除注释就好
 * 爽吧？
 *
 * Drawable drawable = getDrawable();
 * if (drawable != null) {
 *     canvas.save();
 *     canvas.concat(getImageMatrix());
 *     Rect bounds = drawable.getBounds();
 *     canvas.drawText(getResources().getString(R.string.image_size, bounds.width(), bounds.height()), 20, 40, paint);
 *     canvas.restore();
 * }
 **/
public class AfterOnDrawView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Bitmap mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.yihu);

    {
        mPaint.setTextSize(80);
        mPaint.setColor(Color.RED);
    }

    public AfterOnDrawView(Context context) {
        this(context, null);
    }

    public AfterOnDrawView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AfterOnDrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public AfterOnDrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mBitmap, 0, 0, mPaint);

        if (mBitmap != null) {
            canvas.save();
            canvas.drawText("hello world", 50, 200, mPaint);
            canvas.restore();
        }
    }
}
