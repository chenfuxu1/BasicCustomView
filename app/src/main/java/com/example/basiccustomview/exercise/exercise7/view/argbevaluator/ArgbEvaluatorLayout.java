package com.example.basiccustomview.exercise.exercise7.view.argbevaluator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.basiccustomview.R;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/12/7 20:14
 **/
public class ArgbEvaluatorLayout extends RelativeLayout {
    private ArgbEvaluatorView mArgbEvaluatorView;
    private TextView mAnimTv;
    private boolean mIsAnimed;

    public ArgbEvaluatorLayout(Context context) {
        this(context, null);
    }

    public ArgbEvaluatorLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ArgbEvaluatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public ArgbEvaluatorLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        initView();
        initListener();
    }

    private void initView() {
        mArgbEvaluatorView = findViewById(R.id.argb_evaluator_view);
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
        if (mArgbEvaluatorView != null) {
            if (!mIsAnimed) {
                mArgbEvaluatorView.startAnim();
            } else {
                mArgbEvaluatorView.resetAnim();
            }
            mIsAnimed = !mIsAnimed;
        }
    }
}
