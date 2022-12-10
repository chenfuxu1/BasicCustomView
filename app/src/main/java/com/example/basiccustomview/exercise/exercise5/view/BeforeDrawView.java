package com.example.basiccustomview.exercise.exercise5.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.Layout;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/11/28 23:21
 *
 * 把下面的绘制代码移到 super.onDraw() 的上面，就可以让原主体内容盖住你的绘制代码了
 * （或者你也可以把 super.onDraw() 移到这段代码的下面）
 * Layout layout = getLayout();
 * bounds.left = layout.getLineLeft(1);
 * bounds.right = layout.getLineRight(1);
 * bounds.top = layout.getLineTop(1);
 * bounds.bottom = layout.getLineBottom(1);
 * canvas.drawRect(bounds, paint);
 * bounds.left = layout.getLineLeft(layout.getLineCount() - 3);
 * bounds.right = layout.getLineRight(layout.getLineCount() - 3);
 * bounds.top = layout.getLineTop(layout.getLineCount() - 3);
 * bounds.bottom = layout.getLineBottom(layout.getLineCount() - 3);
 * canvas.drawRect(bounds, paint);
 **/
public class BeforeDrawView extends AppCompatTextView {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);


    {
        mPaint.setColor(Color.parseColor("#FFC107"));
        mPaint.setTextSize(80);
    }

    public BeforeDrawView(@NonNull Context context) {
        this(context, null);
    }

    public BeforeDrawView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BeforeDrawView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void draw(Canvas canvas) {
        /**
         * 在 draw 方法之前执行
         * 可能会被：背景、onDraw、子 view 、前景色 遮挡住
         */
        mPaint.setColor(Color.parseColor("#F44336"));
        canvas.drawRect(0, 40, 200, 120, mPaint);
        mPaint.setColor(Color.WHITE);
        canvas.drawText("New", 20 , 100, mPaint);

        super.draw(canvas);
    }
}
