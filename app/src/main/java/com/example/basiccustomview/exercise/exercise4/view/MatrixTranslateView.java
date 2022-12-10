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
public class MatrixTranslateView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Bitmap mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.jinshang);
    private Point mPoint1 = new Point(200, 200);
    private Point mPoint2 = new Point(200, 800);
    private Matrix mMatrix = new Matrix();

    public MatrixTranslateView(Context context) {
        this(context, null);
    }

    public MatrixTranslateView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MatrixTranslateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public MatrixTranslateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        mMatrix.reset();
        mMatrix.postTranslate(-100, -100);
        canvas.concat(mMatrix);
        canvas.drawBitmap(mBitmap, mPoint1.x, mPoint1.y, mPaint);
        canvas.restore();

        canvas.save();
        mMatrix.reset();
        mMatrix.postTranslate(150, 0);
        canvas.concat(mMatrix);
        canvas.drawBitmap(mBitmap, mPoint2.x, mPoint2.y, mPaint);
        canvas.restore();
    }
}
