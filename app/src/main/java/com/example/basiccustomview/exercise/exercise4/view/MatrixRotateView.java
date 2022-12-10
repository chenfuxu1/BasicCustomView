package com.example.basiccustomview.exercise.exercise4.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.basiccustomview.R;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/11/26 17:05
 **/
public class MatrixRotateView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Bitmap mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.jinshang);
    private Point mPoint1 = new Point(200, 50);
    private Point mPoint2 = new Point(200, 1100);
    private Matrix mMatrix = new Matrix();

    public MatrixRotateView(Context context) {
        this(context, null);
    }

    public MatrixRotateView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MatrixRotateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public MatrixRotateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPoint1.set((getWidth() - mBitmap.getWidth()) / 2, 100);
        mPoint2.set((getWidth() - mBitmap.getWidth()) / 2, 1000);
        int width = mBitmap.getWidth();
        int height = mBitmap.getHeight();
        canvas.save();
        mMatrix.reset();
        // 旋转 60 度，找到图片的旋转中心
        mMatrix.postRotate(60, mPoint1.x + width / 2, mPoint1.y + height / 2);
        canvas.concat(mMatrix);
        canvas.drawBitmap(mBitmap, mPoint1.x, mPoint1.y, mPaint);
        canvas.restore();

        canvas.save();
        mMatrix.reset();
        // 旋转 -120 度，找到图片的旋转中心
        mMatrix.postRotate(-120, mPoint2.x + width / 2, mPoint2.y + height / 2);
        canvas.concat(mMatrix);
        canvas.drawBitmap(mBitmap, mPoint2.x, mPoint2.y, mPaint);
        canvas.restore();
    }
}
