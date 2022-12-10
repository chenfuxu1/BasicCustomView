package com.example.basiccustomview.customview.customview7;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

import com.example.basiccustomview.Logit;
import com.example.basiccustomview.R;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/11/12 19:50
 *
 * 自定义 View 1-7：属性动画 Property Animation（进阶篇）
 **/
public class CustomView7 extends RelativeLayout {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private CircleView mCircleView;
    private TextView mAnimTv;
    private boolean mIsAnimed;

    private PointView mPointView;
    private boolean mIsOfObjectAnim;

    private ImageView mMusic;

    private SportsView mSportsView;
    private boolean mIsSportsViewAnim = false;

    public CustomView7(Context context) {
        this(context, null);
    }

    public CustomView7(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomView7(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        initView();
        initListener();
    }


    private void initView() {
        mCircleView = findViewById(R.id.circle_view);
        mAnimTv = findViewById(R.id.anim_tv);
        mPointView = findViewById(R.id.point_view);
        mMusic = findViewById(R.id.music);
        // mMusic.setAlpha(0f);
        // mMusic.setScaleX(0);
        mMusic.setScaleY(0);

        mSportsView = findViewById(R.id.sport_view);
    }

    private void initListener() {
        mAnimTv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // startAnimSetEvaluator();

                customAnimSetEvaluator();

                startOfObjectAnim();

                // startAnimWithViewPropertyAnimator();

                // startAnimWithPropertyValuesHolder();

                // startAnimWithAnimSet();

                startAnimOfKeyframe();
            }
        });
    }

    /**
     * TypeEvaluator
     * 关于 ObjectAnimator，可以用 ofInt() 来做整数的属性动画和用 ofFloat() 来做小数的属性动画。
     * 这两种属性类型是属性动画最常用的两种，不过在实际的开发中，可以做属性动画的类型还是有其他的一些类型。
     * 当需要对其他类型来做属性动画的时候，就需要用到 TypeEvaluator 了。
     * 1、ArgbEvaluator
     */
    public void startAnimSetEvaluator() {
        if (!mIsAnimed) {
            if (mCircleView != null) {
                mCircleView.startAnimSetEvaluator();
            }
        } else {
            if (mCircleView != null) {
                mCircleView.resetAnimSetEvaluator();
            }
        }
        mIsAnimed = !mIsAnimed;
    }

    /**
     * 2、使用自定义的估值器
     */
    public void customAnimSetEvaluator() {
        if (!mIsAnimed) {
            if (mCircleView != null) {
                mCircleView.customEvaluator();
            }
        } else {
            if (mCircleView != null) {
                mCircleView.resetAnimSetEvaluator();
            }
        }
        mIsAnimed = !mIsAnimed;
    }

    /**
     * 3、ofObject()
     * 借助于 TypeEvaluator，属性动画就可以通过 ofObject() 来对不限定类型的属性做动画了。方式很简单：
     *
     * 为目标属性写一个自定义的 TypeEvaluator
     * 使用 ofObject() 来创建 Animator，并把自定义的 TypeEvaluator 作为参数填入
     */
    public void startOfObjectAnim() {
        if (mPointView != null) {
            if (!mIsOfObjectAnim) {
                mPointView.startAnim();
            } else {
                mPointView.resetAnim();
            }
            mIsOfObjectAnim = !mIsOfObjectAnim;
        }
    }

    /**
     * 4、PropertyValuesHolder 同一个动画中改变多个属性
     * 很多时候，你在同一个动画中会需要改变多个属性，例如在改变透明度的同时改变尺寸。如果使用
     * ViewPropertyAnimator，你可以直接用连写的方式来在一个动画中同时改变多个属性：
     */
    public void startAnimWithViewPropertyAnimator() {
        mMusic.animate()
                .scaleX(1)
                .scaleY(1)
                .alpha(1)
                .setDuration(1000);
    }

    /**
     * 5、而对于 ObjectAnimator，是不能这么用的。不过你可以使用 PropertyValuesHolder 来同时在一个动画
     * 改变多个属性。
     * PropertyValuesHolder 的意思从名字可以看出来，它是一个属性值的批量存放地。所以你如果有多个属性
     * 需要修改，可以把它们放在不同的 PropertyValuesHolder 中，然后使用 ofPropertyValuesHolder() 统一
     * 放进 Animator。这样你就不用为每个属性单独创建一个 Animator 分别执行了。
     */
    public void startAnimWithPropertyValuesHolder() {
        PropertyValuesHolder holder1 = PropertyValuesHolder.ofFloat("scaleX", 1);
        PropertyValuesHolder holder2 = PropertyValuesHolder.ofFloat("scaleY", 1);
        PropertyValuesHolder holder3 = PropertyValuesHolder.ofFloat("alpha", 1);
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(mMusic, holder1, holder2, holder3);
        objectAnimator.setDuration(1000);
        objectAnimator.start();
    }

    /**
     * 6、AnimatorSet 多个动画配合执行
     * 有的时候，你不止需要在一个动画中改变多个属性，还会需要多个动画配合工作，比如，在内容的大小从 0
     * 放大到 100% 大小后开始移动。这种情况使用 PropertyValuesHolder 是不行的，因为这些属性如果放在
     * 同一个动画中，需要共享动画的开始时间、结束时间、Interpolator 等等一系列的设定，这样就不能有先后
     * 次序地执行动画了。
     * 这就需要用到 AnimatorSet 了。
     */
    public void startAnimWithAnimSet() {
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(mMusic, "scaleY", 1);
        objectAnimator1.setInterpolator(new LinearInterpolator());
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(mMusic, "translationX", 300);
        objectAnimator2.setInterpolator(new DecelerateInterpolator());

        AnimatorSet animatorSet = new AnimatorSet();
        // 1、两个动画依次执行
        // animatorSet.playSequentially(objectAnimator1, objectAnimator2);

        // 2、两个动画同时执行
        animatorSet.playTogether(objectAnimator1, objectAnimator2);

        // 3、使用 AnimatorSet.play(animatorA).with/before/after(animatorB)的方式来精确配置各个
        // Animator 之间的关系
        // animatorSet.play(objectAnimator1).with(objectAnimator2);
        // animatorSet.play(objectAnimator1).before(objectAnimator2);
        // animatorSet.play(objectAnimator1).after(objectAnimator2);
        animatorSet.start();
    }

    /**
     * 7、PropertyValuesHolders.ofKeyframe() 把同一个属性拆分
     * 除了合并多个属性和调配多个动画，你还可以在 PropertyValuesHolder 的基础上更进一步，通过设置 Keyframe （关键帧），把同一个动画属性拆分成多个阶段。例如，你可以让一个进度增加到 100% 后再「反弹」回来。
     */
    public void startAnimOfKeyframe() {
        if (mSportsView != null) {
            if (!mIsSportsViewAnim) {
                mSportsView.startAnimOfKeyframe();
            } else {
                mSportsView.resetAnim();
            }
            mIsSportsViewAnim = !mIsSportsViewAnim;
        }
    }

}
