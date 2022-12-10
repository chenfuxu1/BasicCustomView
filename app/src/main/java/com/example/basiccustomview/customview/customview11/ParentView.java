package com.example.basiccustomview.customview.customview11;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/12/10 22:04
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
         * 重写 onMeasure() 的三个步骤：
         * 调用每个子 View 的 measure() 来计算子 View 的尺寸
         * 计算子 View 的位置并保存子 View 的位置和尺寸
         * 计算自己的尺寸并用 setMeasuredDimension() 保存
         */
        for (int i = 0; i < getChildCount(); i++) {
            View childView = getChildAt(i);
            /**
             * 1、这两个子 view 的尺寸限制不是现成的，需要计算出来
             */
            int childWidthSpec = 0; // 获取子 view 的宽度限制
            int childHeightSpec = 0; // 获取子 view 的高度限制

            /**
             * 获取自身的限制类型以及限制的尺寸大小
             *
             * 对于 EXACTLY，因为自身是限定了固定尺寸，例如 500dp, 那么第一个子 view 的可用空间就是 500dp
             * 所以，可用空间是 MeasureSpec 中的 size
             *
             * 对于 AT_MOST，虽然自身是一个上限而不是固定的值，是一个动态的未确定的范围，但是测量子 view
             * 的时候，父 view 应该是一种，我这块自身的空间随便你用的原则，所以它的可用空间就是自己的尺寸
             * 上限，就是 MeasureSpec 中的 size
             *
             * 对于 UNSPECIFIED，表示的是自己的父 view，对自己没有尺寸限制，也就是自己的可用空间是无线的
             * 所以它的可用空间无限大
             *
             * mode         可用空间
             * EXACTLY      MeasureSpec 中的 size
             * AT_MOST      MeasureSpec 中的 size
             * UNSPECIFIED  无限大
             */
            int selfWidthSpecMode = MeasureSpec.getMode(widthMeasureSpec); // 限制类型
            int selfWidthSpecSize = MeasureSpec.getSize(widthMeasureSpec); // 限制的尺寸大小

            /**
             * 其中
             * layout_width：对应 layoutParams.width
             * layout_height：对应 layoutParams.height
             * wrap_content => WRAP_CONTENT
             * match_parent => MATCH_PARENT
             * xxdp / xxsp  => 具体的像素值
             * 2、获取子 view 的 layoutParams
             */
            LayoutParams layoutParams = childView.getLayoutParams();
            /**
             * 3、因此，子 view 的宽度 / 高度有三种类型
             */
            int usedWidth = 0; // 表示已经使用的空间
            switch (layoutParams.width) {
                case MATCH_PARENT:
                    /**
                     * 子 view 设置的为 match_parent，填充满父控件
                     * 因为是填满，所以原则上也是把子 view 设置为 EXACTLY
                     * childWidthSpec = MeasureSpec.makeMeasureSpec(可用宽度 / 高度, MeasureSpec.EXACTLY);
                     * 但是这里存在父 view 的可用空间问题需要计算
                     * 这两个可用空间是从本方法 onMeasure(int widthMeasureSpec, int heightMeasureSpec) 中
                     * 获得的 widthMeasureSpec / heightMeasureSpec 宽度高度限制，依据这个限制，可以得到
                     * 一份可用的空间
                     */
                    if (selfWidthSpecMode == MeasureSpec.EXACTLY || selfWidthSpecMode == MeasureSpec.AT_MOST) {
                        // 如果自身的限制类型是 EXACTLY / AT_MOST, 那么可用空间就是自身的限制尺寸 selfWidthSpecSize
                        childWidthSpec = MeasureSpec.makeMeasureSpec(selfWidthSpecSize - usedWidth, MeasureSpec.EXACTLY);
                    } else {
                        /**
                         * 这里 selfWidthSpecMode == UNSPECIFIED，表示不限制，可用空间无限大
                         * 而子 view 是 MATCH_PARENT，表示要填满父空间，这就矛盾了，无限大的空间如何填满呢
                         * 这个时候只需要将 UNSPECIFIED 往下传即可，size 填 0 即可，因为并不会用到这个 size
                         */
                        childWidthSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
                    }
                    break;
                case WRAP_CONTENT:
                    /**
                     * 子 view 设置的 wrap_content, 让子 view 自己测量，但是也不能超出父 view 的可用空间
                     * 所以这个时候也需要将可用空间分为有上限和无上限两种
                     */
                    if (selfWidthSpecMode == MeasureSpec.EXACTLY || selfWidthSpecMode == MeasureSpec.AT_MOST) {
                        /**
                         * 有上限，可用空间和上述一样
                         * wrap_content 和 match_parent 的 mode 却不一样了，match_parent 的是 EXACTLY
                         * 而 wrap_content 是需要子 view 自己测量，并且不超过父 view 的可用空间，所以 mode
                         * 应该是一个最大值，就是 AT_MOST
                         */
                        childWidthSpec = MeasureSpec.makeMeasureSpec(selfWidthSpecSize - usedWidth, MeasureSpec.AT_MOST);
                    } else {
                        /**
                         * 无上限, selfWidthSpecMode == UNSPECIFIED
                         * 可用空间无上限，对子 view 的大小又没有限制
                         * 那么直接给子 view 的 mode 设置为 UNSPECIFIED 即可
                         */
                        childWidthSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
                    }
                    break;
                default:
                    /**
                     * 默认值，表示的固定值大小，xxdp / xxsp
                     * 因为开发者已经固定了子 view 的尺寸大小，所以不存在尺寸空间的问题
                     * 因此，直接用 EXACTLY 把子 view 的尺寸限制为 layoutParams.width 即可
                     */
                    childWidthSpec = MeasureSpec.makeMeasureSpec(layoutParams.width, MeasureSpec.EXACTLY);
                    break;
            }
            // 调用每个子 View 的 measure() 来计算子 View 的尺寸
            childView.measure(childWidthSpec, childHeightSpec);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        for (int i = 0; i < getChildCount(); i++) {
            // 遍历子 view, 调用 layout 进行摆放
            View childView = getChildAt(i);
            childView.layout(l, t, r, b); // 这里传计算出来的子 view 的位置
        }
    }
}
