package com.example.basiccustomview.exercise.exercise4.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.basiccustomview.R;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/11/26 17:05
 **/
public class ClipRectView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Bitmap mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.jinshang);

    public ClipRectView(Context context) {
        this(context, null);
    }

    public ClipRectView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ClipRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public ClipRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int left = (getWidth() - mBitmap.getWidth()) / 2;
        int top = (getHeight() - mBitmap.getHeight()) / 2;
        canvas.save();
        // 裁剪矩形
        canvas.clipRect(left + 50, top + 50, left + 300, top + 300);
        canvas.drawBitmap(mBitmap, left, top, mPaint);
        canvas.restore();
    }
}
