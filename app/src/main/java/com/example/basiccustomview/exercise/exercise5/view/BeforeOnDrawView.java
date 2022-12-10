package com.example.basiccustomview.exercise.exercise5.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.Layout;
import android.util.AttributeSet;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/11/28 23:21
 **/
public class BeforeOnDrawView extends AppCompatTextView {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private RectF mBounds = new RectF();

    {
        mPaint.setTextSize(80);
        mPaint.setColor(Color.RED);
    }

    public BeforeOnDrawView(Context context) {
        this(context, null);
    }

    public BeforeOnDrawView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BeforeOnDrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Layout layout = getLayout();
        mBounds.left = layout.getLineLeft(1);
        mBounds.right = layout.getLineRight(1);
        mBounds.top = layout.getLineTop(1);
        mBounds.bottom = layout.getLineBottom(1);
        canvas.drawRect(mBounds, mPaint);
        mBounds.left = layout.getLineLeft(layout.getLineCount() - 4);
        mBounds.right = layout.getLineRight(layout.getLineCount() - 4);
        mBounds.top = layout.getLineTop(layout.getLineCount() - 4);
        mBounds.bottom = layout.getLineBottom(layout.getLineCount() - 4);
        canvas.drawRect(mBounds, mPaint);

        super.onDraw(canvas);
    }
}
