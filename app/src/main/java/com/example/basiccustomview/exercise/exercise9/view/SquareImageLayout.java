package com.example.basiccustomview.exercise.exercise9.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.example.basiccustomview.Logit;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/12/10 12:48
 **/
public class SquareImageLayout extends RelativeLayout {
    private static final String TAG = "SquareImageLayout";

    public SquareImageLayout(Context context) {
        this(context, null);
    }

    public SquareImageLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SquareImageLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public SquareImageLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Logit.d(TAG, "cfx 2222222222");
    }
}
