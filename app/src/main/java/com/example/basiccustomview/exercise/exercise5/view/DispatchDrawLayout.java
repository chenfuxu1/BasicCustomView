package com.example.basiccustomview.exercise.exercise5.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/11/28 23:21
 **/
public class DispatchDrawLayout extends LinearLayout {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Pattern mPattern = new Pattern();

    {
        mPaint.setTextSize(80);
        mPaint.setColor(Color.RED);
        // ViewGroup 需要主动开启 dispatchDraw() 以外的绘制
        setWillNotDraw(false);
    }

    public DispatchDrawLayout(Context context) {
        this(context, null);
    }

    public DispatchDrawLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DispatchDrawLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public DispatchDrawLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        /**
         * 如果 OnDrawLayout 有子 view，在 linearLayout 的 onDraw 方法执行完，会向下分发
         * 执行 dispatchDraw() 方法，进而调用子 view 的 onDraw 方法绘制子 view
         * 这里 mPattern.draw(canvas) 方法在 super.dispatchDraw(canvas) 位置之下
         * 所以不会被 linearLayout 的子 view 遮挡住
         */
        mPattern.draw(canvas);
    }

    private class Pattern {
        private static final float PATTERN_RATIO = 5f / 6;

        Paint patternPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        Pattern.Spot[] spots;

        private Pattern() {
            spots = new Pattern.Spot[4];
            spots[0] = new Pattern.Spot(0.24f, 0.3f, 0.026f);
            spots[1] = new Pattern.Spot(0.69f, 0.25f, 0.067f);
            spots[2] = new Pattern.Spot(0.32f, 0.6f, 0.067f);
            spots[3] = new Pattern.Spot(0.62f, 0.78f, 0.083f);
        }

        private Pattern(Pattern.Spot[] spots) {
            this.spots = spots;
        }

        {
            patternPaint.setColor(Color.parseColor("#A0E91E63"));
        }

        private void draw(Canvas canvas) {
            int repitition = (int) Math.ceil((float) getWidth() / getHeight());
            for (int i = 0; i < spots.length * repitition; i++) {
                Pattern.Spot spot = spots[i % spots.length];
                canvas.drawCircle(i / spots.length * getHeight() * PATTERN_RATIO + spot.relativeX * getHeight(), spot.relativeY * getHeight(), spot.relativeSize * getHeight(), patternPaint);
            }
        }

        private class Spot {
            private float relativeX;
            private float relativeY;
            private float relativeSize;

            private Spot(float relativeX, float relativeY, float relativeSize) {
                this.relativeX = relativeX;
                this.relativeY = relativeY;
                this.relativeSize = relativeSize;
            }
        }
    }
}
