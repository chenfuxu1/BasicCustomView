package com.example.basiccustomview.exercise.exercise4.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
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
public class CameraRotateFixedView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Bitmap mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.duck);
    private Point mPoint1 = new Point(400, 100);
    private Point mPoint2 = new Point(100, 1000);
    private Point mPoint3 = new Point(620, 1000);
    private Camera mCamera = new Camera();
    private Matrix mMatrix = new Matrix();

    {
        mPaint.setTextSize(60);
    }

    public CameraRotateFixedView(Context context) {
        this(context, null);
    }

    public CameraRotateFixedView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CameraRotateFixedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public CameraRotateFixedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = mBitmap.getWidth();
        int height = mBitmap.getHeight();
        int center1X = mPoint1.x + width / 2;
        int center1Y = mPoint1.y + height / 2;
        int center2X = mPoint2.x + width / 2;
        int center2Y = mPoint2.y + height / 2;
        int center3X = mPoint3.x + width / 2;
        int center3Y = mPoint3.y + height / 2;

        /**
         * 方法1：使用 canvas
         * 注意：这里移动需要倒着写
         */
        canvas.save();
        mCamera.save(); // 保存 camera 的状态
        // x 轴旋转 30 度
        mCamera.rotateX(30); // 旋转 camera 的三维空间
        canvas.translate(center1X, center1Y); // 旋转后把投影移动回来
        mCamera.applyToCanvas(canvas); // 把旋转投影到 canvas
        canvas.translate(-center1X, -center1Y); // 旋转之前把绘制的内容中心移动到轴心(坐标原点)
        mCamera.restore(); // 恢复 camera 的状态
        canvas.drawBitmap(mBitmap, mPoint1.x, mPoint1.y, mPaint); // 绘制
        canvas.drawText("x轴旋转30度", mPoint1.x, 400, mPaint);
        canvas.restore(); // 恢复 canvas 的状态

        /**
         * 方法2：使用 Matrix
         */
        mCamera.save(); // 保存 camera 的状态
        mMatrix.reset();
        // y 轴旋转 30 度
        mCamera.rotateY(30);
        mCamera.getMatrix(mMatrix); // 把 camera 的状态保存到 matrix
        mCamera.restore();
        mMatrix.preTranslate(-center2X, -center2Y); // 旋转图像前移动绘制的内容中心移动到轴心(坐标原点)
        mMatrix.postTranslate(center2X, center2Y); // 旋转图像后移动回来
        canvas.save();
        canvas.concat(mMatrix);
        canvas.drawBitmap(mBitmap, mPoint2.x, mPoint2.y, mPaint);
        canvas.drawText("y轴旋转30度", mPoint2.x, 1300, mPaint);
        canvas.restore();

        mCamera.save(); // 保存 camera 的状态
        mMatrix.reset();
        // z 轴旋转 30 度
        mCamera.rotateZ(30);
        mCamera.getMatrix(mMatrix); // 把 camera 的状态保存到 matrix
        mCamera.restore();
        mMatrix.preTranslate(-center3X, -center3Y); // 旋转图像前移动绘制的内容中心移动到轴心(坐标原点)
        mMatrix.postTranslate(center3X, center3Y); // 旋转图像后移动回来
        canvas.save();
        canvas.concat(mMatrix);
        canvas.drawBitmap(mBitmap, mPoint3.x, mPoint3.y, mPaint);
        canvas.drawText("z轴旋转30度", mPoint3.x, 1300, mPaint);
        canvas.restore();
    }
}
