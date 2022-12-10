package com.example.basiccustomview.exercise.exercise2.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.basiccustomview.R;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/11/20 16:24
 *
 * 使用 paint.setXfermode() 设置不同的结合绘制效果
 * 别忘了用 canvas.saveLayer() 开启 off-screen buffer
 * canvas.drawBitmap(bitmap1, 0, 0, paint);
 * 第一个：PorterDuff.Mode.SRC
 * canvas.drawBitmap(bitmap2, 0, 0, paint);
 *
 * canvas.drawBitmap(bitmap1, bitmap1.getWidth() + 100, 0, paint);
 * 第二个：PorterDuff.Mode.DST_IN
 * canvas.drawBitmap(bitmap2, bitmap1.getWidth() + 100, 0, paint);
 *
 * canvas.drawBitmap(bitmap1, 0, bitmap1.getHeight() + 20, paint);
 * 第三个：PorterDuff.Mode.DST_OUT
 * canvas.drawBitmap(bitmap2, 0, bitmap1.getHeight() + 20, paint);
 *
 * 用完之后使用 canvas.restore() 恢复 off-screen buffer
 **/
public class XfermodeView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Bitmap mBitmap1;
    private Bitmap mBitmap2;

    {
        mBitmap1 = BitmapFactory.decodeResource(getResources(), R.mipmap.rect);
        mBitmap2 = BitmapFactory.decodeResource(getResources(), R.mipmap.circle);
    }

    public XfermodeView(Context context) {
        super(context);
    }

    public XfermodeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public XfermodeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 使用离屏缓冲（Off-screen Buffer）
        // 第一个：PorterDuff.Mode.SRC
        int saved = canvas.saveLayer(null, null, Canvas.ALL_SAVE_FLAG);
        canvas.drawBitmap(mBitmap1, 0, 0, mPaint);
        Xfermode xFermode1 = new PorterDuffXfermode(PorterDuff.Mode.SRC);
        mPaint.setXfermode(xFermode1);
        canvas.drawBitmap(mBitmap2, 0, 0, mPaint);
        mPaint.setXfermode(null); // 用完及时清除 Xfermode

        // 第二个：PorterDuff.Mode.DST_IN
        canvas.drawBitmap(mBitmap1, 0, 500, mPaint);
        Xfermode xFermode2 = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        mPaint.setXfermode(xFermode2);
        canvas.drawBitmap(mBitmap2, 0, 500, mPaint);
        mPaint.setXfermode(null); // 用完及时清除 Xfermode

        // 第三个：PorterDuff.Mode.DST_OUT
        canvas.drawBitmap(mBitmap1, 0, 1000, mPaint);
        Xfermode xFermode3 = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        mPaint.setXfermode(xFermode3);
        canvas.drawBitmap(mBitmap2, 0, 1000, mPaint);
        mPaint.setXfermode(null); // 用完及时清除 Xfermode

        canvas.restoreToCount(saved);
    }
}
