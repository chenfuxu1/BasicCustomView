package com.example.basiccustomview.exercise.exercise4.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.LinearInterpolator;

import androidx.annotation.Nullable;

import com.example.basiccustomview.R;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/11/26 17:05
 **/
public class CameraRotateHittingFaceView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Bitmap mBitmap1;
    private Bitmap mBitmap2;
    private Point mPoint1 = new Point(200, 50);
    private Point mPoint2 = new Point(0, 1000);
    private Camera mCamera = new Camera();
    private Matrix mMatrix = new Matrix();
    private int mDegree;
    private ObjectAnimator mAnimator = ObjectAnimator.ofInt(this, "degree", 0, 360);

    {
        mBitmap1 = BitmapFactory.decodeResource(getResources(), R.mipmap.yihu2);
        mBitmap2 = BitmapFactory.decodeResource(getResources(), R.mipmap.qixai);

        // 图片放大 2 倍
        // Bitmap scaledBitmap = Bitmap.createScaledBitmap(mBitmap, mBitmap.getWidth() * 2,
        //         mBitmap.getHeight() * 2, true);
        // mBitmap.recycle();
        // mBitmap = scaledBitmap;

        mAnimator.setDuration(5000);
        mAnimator.setInterpolator(new LinearInterpolator());
        mAnimator.setRepeatCount(ValueAnimator.INFINITE);

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float newZ = -displayMetrics.density * 8;
        mCamera.setLocation(0, 0, newZ);
    }


    public CameraRotateHittingFaceView(Context context) {
        this(context, null);
    }

    public CameraRotateHittingFaceView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CameraRotateHittingFaceView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public CameraRotateHittingFaceView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mAnimator.start();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mAnimator.end();
    }

    @SuppressWarnings("unused")
    public void setDegree(int degree) {
        this.mDegree = degree;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int bitmapWidth = mBitmap1.getWidth();
        int bitmapHeight = mBitmap1.getHeight();
        int centerX = mPoint1.x + bitmapWidth / 2;
        int centerY = mPoint1.y + bitmapHeight / 2;

        mCamera.save();
        mMatrix.reset();
        mCamera.rotateX(mDegree);
        mCamera.getMatrix(mMatrix);
        mCamera.restore();
        mMatrix.preTranslate(-centerX, -centerY);
        mMatrix.postTranslate(centerX, centerY);
        canvas.save();
        canvas.concat(mMatrix);
        canvas.drawBitmap(mBitmap1, mPoint1.x, mPoint1.y, mPaint);
        canvas.restore();

        int width = mBitmap2.getWidth();
        int height = mBitmap2.getHeight();
        mPoint2.set((getWidth() - mBitmap2.getWidth()) / 2, 1000);
        int center2X = mPoint2.x + width / 2;
        int center2Y = mPoint2.y + height / 2;
        mCamera.save();
        mMatrix.reset();
        mCamera.rotateY(mDegree);
        mCamera.getMatrix(mMatrix);
        mCamera.restore();
        mMatrix.preTranslate(-center2X, -center2Y);
        mMatrix.postTranslate(center2X, center2Y);
        canvas.save();
        canvas.concat(mMatrix);
        canvas.drawBitmap(mBitmap2, mPoint2.x, mPoint2.y, mPaint);
        canvas.restore();
    }
}
