package com.example.basiccustomview.exercise.exercise4.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
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
public class ClipPathView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Bitmap mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.jinshang);
    private Path mPath1 = new Path();
    private Path mPath2 = new Path();
    private Point mPoint1 = new Point(200, 200);
    private Point mPoint2 = new Point(600, 200);

    {
        mPath1.addCircle(mPoint1.x + 200, mPoint1.y + 200, 150, Path.Direction.CW);
        mPath2.setFillType(Path.FillType.INVERSE_WINDING);
        mPath2.addCircle(mPoint2.x + 200, mPoint2.y + 200, 150, Path.Direction.CW);
    }

    public ClipPathView(Context context) {
        this(context, null);
    }

    public ClipPathView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ClipPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public ClipPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.clipPath(mPath1);
        canvas.drawBitmap(mBitmap, mPoint1.x, mPoint1.y, mPaint);
        canvas.restore();

        canvas.save();
        canvas.clipPath(mPath2);
        canvas.drawBitmap(mBitmap, mPoint2.x, mPoint2.y, mPaint);
        canvas.restore();
    }
}
