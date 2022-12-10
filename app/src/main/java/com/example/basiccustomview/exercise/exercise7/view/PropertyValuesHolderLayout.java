package com.example.basiccustomview.exercise.exercise7.view;

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
public class PropertyValuesHolderLayout extends RelativeLayout {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private ImageView mMusic;
    private TextView mAnimTv;
    private boolean mIsAnimed;
    private PropertyValuesHolder mHolder1;
    private PropertyValuesHolder mHolder2;
    private PropertyValuesHolder mHolder3;
    private ObjectAnimator mObjectAnimator;

    public PropertyValuesHolderLayout(Context context) {
        this(context, null);
    }

    public PropertyValuesHolderLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PropertyValuesHolderLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public PropertyValuesHolderLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
        mMusic.setAlpha(0f);
        mMusic.setScaleX(0);
        mMusic.setScaleY(0);
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
        mHolder1 = PropertyValuesHolder.ofFloat("scaleX", 1, 0);
        mHolder2 = PropertyValuesHolder.ofFloat("scaleY", 1, 0);
        mHolder3 = PropertyValuesHolder.ofFloat("alpha", 1, 0);
        mObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(mMusic, mHolder1, mHolder2, mHolder3);
        mObjectAnimator.setDuration(1000);
        mObjectAnimator.start();
    }

    private void startAnim() {
        mHolder1 = PropertyValuesHolder.ofFloat("scaleX", 0, 1);
        mHolder2 = PropertyValuesHolder.ofFloat("scaleY", 0, 1);
        mHolder3 = PropertyValuesHolder.ofFloat("alpha", 0, 1);
        mObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(mMusic, mHolder1, mHolder2, mHolder3);
        mObjectAnimator.setDuration(1000);
        mObjectAnimator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
