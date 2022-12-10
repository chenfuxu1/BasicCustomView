package com.example.basiccustomview.customview.customview11;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/12/10 22:05
 **/
public class ChildView extends ParentView {
    public ChildView(Context context) {
        this(context, null);
    }

    public ChildView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ChildView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public ChildView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
