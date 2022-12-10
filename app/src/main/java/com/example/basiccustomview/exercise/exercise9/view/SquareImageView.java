package com.example.basiccustomview.exercise.exercise9.view;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

import com.example.basiccustomview.Logit;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/12/9 23:45
 **/
public class SquareImageView extends AppCompatImageView {
    private static final String TAG = "SquareImageView";

    public SquareImageView(Context context) {
        this(context, null);
    }

    public SquareImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SquareImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // 1、重写 onMeasure() 方法，并在里面调用 super.onMeasure()，触发原有的自我测量
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        /**
         * 2、在 super.onMeasure() 的下面用 getMeasuredWidth() 和 getMeasuredHeight() 来获取到之前的
         * 测量结果，并使用自己的算法，根据测量结果计算出新的结果
          */
        int measuredWidth = getMeasuredWidth();
        int measureHeight = getMeasuredHeight();
        Logit.d(TAG, "cfx 测量前 measuredWidth = " + measuredWidth + " measureHeight = " + measureHeight);
        int min = Math.min(measuredWidth, measureHeight);
        measuredWidth = min;
        measureHeight = min;
        Logit.d(TAG, "cfx 测量后 measuredWidth = " + measuredWidth + " measureHeight = " + measureHeight);
        // 3、调用 setMeasuredDimension() 来保存新的结果
        setMeasuredDimension(measuredWidth, measureHeight);
    }
}
