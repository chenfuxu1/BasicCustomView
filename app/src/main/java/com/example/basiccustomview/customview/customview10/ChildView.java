package com.example.basiccustomview.customview.customview10;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/12/10 20:24
 *
 * 重写 onMeasure() 来全新定制自定义 View 的尺寸；
 **/
public class ChildView extends ParentView{
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

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        /**
         * 这两个参数 widthMeasureSpec，heightMeasureSpec 由父 view 测量时传递过来的
         * 包含了父 view 对于子 view 的宽度限制、高度限制
         *
         * 1、计算子 view 的宽度、高度
         * measuredWidth = ...;
         * measuredHeight = ...;
         *
         * 2、把计算得出的宽度、高度以及对应父 view 的限制一起使用 resolveSize 方法进行修正
         * 修正后的结果就是符合父 view 限制的尺寸
         * measuredWidth = resolveSize(measuredWidth, widthMeasureSpec);
         * measuredHeight = resolveSize(measuredHeight, heightMeasureSpec);
         *
         * 3、将修正后的尺寸保存下来即可
         * setMeasuredDimension(measuredWidth, measuredHeight);
         */
    }

    /**
     * resolveSize 方法到底做了什么？
     */
    public static int resolveSize(int size, int measureSpec) {
        /**
         * 1、其中，父 view 传递的 measureSpec 是一个压缩值，包含了限制的类型以及具体的尺寸
         */
        int specMode = MeasureSpec.getMode(measureSpec); // 获取父 view 限制的类型(EXACTLY, AT_MOST, UNSPECIFIED)
        int specSize = MeasureSpec.getSize(measureSpec); // 获取父 view 限制的尺寸

        /**
         * 2、父 view 的限制类型有三种
         * UNSPECIFIED：父 view 无限制，那么子 view 不需要进行修正了
         * AT_MOST: 父 view 限制上限，上限为 specSize
         * EXACTLY：父 view 限定了固定尺寸值
         */
        switch (specMode) {
            case MeasureSpec.UNSPECIFIED:
                // 父 view 无限制，那么子 view 不需要进行修正了，直接返回传入的 size 尺寸值
                return size;
            case MeasureSpec.AT_MOST:
                // 父 view 限制上限，上限为 specSize
                if (size <= specSize) {
                    return size; // 没超过上限，返回 size
                } else {
                    return specSize; // 超过了上限，返回上限值
                }
            case MeasureSpec.EXACTLY:
                // 父 view 限定了固定尺寸值，直接返回固定尺寸值即可
                return specSize;
        }

        return 0;
    }
}
