package com.example.basiccustomview.exercise.exercise4.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
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
 *
 * 此处旋转有问题，下个 view 页修复
 **/
public class CameraRotateView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Bitmap mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.duck);
    private Point mPoint1 = new Point(200, 100);
    private Point mPoint2 = new Point(400, 1000);
    private Camera mCamera = new Camera();

    public CameraRotateView(Context context) {
        this(context, null);
    }

    public CameraRotateView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CameraRotateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public CameraRotateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        mCamera.save();
        // x 轴旋转 30 度
        mCamera.rotateX(30);
        mCamera.applyToCanvas(canvas);
        mCamera.restore();
        canvas.drawBitmap(mBitmap, mPoint1.x, mPoint1.y, mPaint);
        canvas.restore();

        canvas.save();
        mCamera.save();
        // y 轴旋转 30 度
        mCamera.rotateY(30);
        mCamera.applyToCanvas(canvas);
        mCamera.restore();
        canvas.drawBitmap(mBitmap, mPoint2.x, mPoint2.y, mPaint);
        canvas.restore();
    }
}
