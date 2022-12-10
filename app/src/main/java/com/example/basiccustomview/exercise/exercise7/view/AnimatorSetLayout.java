package com.example.basiccustomview.exercise.exercise7.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.basiccustomview.R;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/12/7 19:58
 **/
public class AnimatorSetLayout extends RelativeLayout {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private ImageView mMusic;
    private TextView mAnimTv;
    private boolean mIsAnimed;
    private AnimatorSet mAnimatorSet = new AnimatorSet();

    public AnimatorSetLayout(Context context) {
        this(context, null);
    }

    public AnimatorSetLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AnimatorSetLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public AnimatorSetLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        initView();
        initListener();
    }

    private void initView() {
        mMusic = findViewById(R.id.music);
        mMusic.setTranslationX(0);
        mMusic.setAlpha(0f);
        mAnimTv = findViewById(R.id.anim_tv);
    }

    private void initListener() {
        mAnimTv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                executeAnim();
            }
        });

    }

    private void executeAnim() {
        if (!mIsAnimed) {
            startAnim();
        } else {
            resetAnim();
        }
        mIsAnimed = !mIsAnimed;
    }

    private void resetAnim() {
        if (mMusic != null) {
            if (mAnimatorSet != null) {
                mAnimatorSet.cancel();
                mAnimatorSet = null;
            }
            ObjectAnimator animator1 = ObjectAnimator.ofFloat(mMusic, "alpha", 1, 0);
            ObjectAnimator animator2 = ObjectAnimator.ofFloat(mMusic, "translationX", 0);
            ObjectAnimator animator3 = ObjectAnimator.ofFloat(mMusic, "rotation", 1080, 0);

            mAnimatorSet = new AnimatorSet();
            mAnimatorSet.play(animator2).before(animator1); // 先执行 2 再执行 1
            // mAnimatorSet.playTogether(animator2, animator3); // 2 和 3 同时开始

            mAnimatorSet.setDuration(1000);
            mAnimatorSet.start();
        }
    }

    private void startAnim() {
        if (mMusic != null) {
            if (mAnimatorSet != null) {
                mAnimatorSet.cancel();
                mAnimatorSet = null;
            }
            ObjectAnimator animator1 = ObjectAnimator.ofFloat(mMusic, "alpha", 0, 1);
            ObjectAnimator animator2 = ObjectAnimator.ofFloat(mMusic, "translationX", 0, 500);
            ObjectAnimator animator3 = ObjectAnimator.ofFloat(mMusic, "rotation", 0, 1080);
            animator3.setDuration(1000);

            mAnimatorSet = new AnimatorSet();
            mAnimatorSet.play(animator1).before(animator2); // 先执行 1 再执行 2
            // mAnimatorSet.playTogether(animator2, animator3); // 2 和 3 同时开始

            mAnimatorSet.setDuration(1000);
            mAnimatorSet.start();
        }

    }
}
