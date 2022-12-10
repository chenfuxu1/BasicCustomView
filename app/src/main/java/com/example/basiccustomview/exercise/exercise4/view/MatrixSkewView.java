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
public class MatrixSkewView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Bitmap mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.duck);
    private Point mPoint1 = new Point(200, 50);
    private Point mPoint2 = new Point(200, 1100);
    private Matrix mMatrix = new Matrix();

    public MatrixSkewView(Context context) {
        this(context, null);
    }

    public MatrixSkewView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MatrixSkewView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public MatrixSkewView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPoint1.set((getWidth() - mBitmap.getWidth()) / 2, 700);
        mPoint2.set(getWidth() / 2, 1100);

        canvas.save();
        mMatrix.reset();
        mMatrix.postSkew(-0.5f, 0);
        canvas.concat(mMatrix);
        canvas.drawBitmap(mBitmap, mBitmap.getWidth() / 2 + (getWidth() - mBitmap.getWidth()) / 2,
                100, mPaint);
        canvas.restore();

        canvas.save();
        mMatrix.reset();
        mMatrix.postSkew(0f, 0.5f);
        canvas.concat(mMatrix);
        canvas.drawBitmap(mBitmap, mPoint1.x, mPoint1.y, mPaint);
        canvas.restore();
    }
}
