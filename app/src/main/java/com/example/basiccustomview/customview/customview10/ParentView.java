package com.example.basiccustomview.customview.customview10;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/12/10 20:23
 *
 * 重写 onMeasure() 来全新定制自定义 View 的尺寸；
 **/
public class ParentView extends ViewGroup {
    public ParentView(Context context) {
        this(context, null);
    }

    public ParentView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ParentView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public ParentView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        /**
         * 会遍历所有的子 view 进行测量
         * for (所有的子 view) {
         *     childWidthMeasureSpec = ...;
         *     childHeightMeasureSpec = ...;
         *     child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
         * }
         */

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
