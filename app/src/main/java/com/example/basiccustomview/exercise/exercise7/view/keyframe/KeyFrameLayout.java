package com.example.basiccustomview.exercise.exercise7.view.keyframe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.basiccustomview.R;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/12/8 22:42
 **/
public class KeyFrameLayout extends RelativeLayout {
    private KeyframeView mKeyframeView;
    private TextView mAnimTv;
    private boolean mIsAnimed;

    public KeyFrameLayout(Context context) {
        this(context, null);
    }

    public KeyFrameLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public KeyFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public KeyFrameLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        initView();
        initListener();
    }

    private void initView() {
        mKeyframeView = findViewById(R.id.key_frame_view);
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
        if (mKeyframeView != null) {
            if (!mIsAnimed) {
                mKeyframeView.startAnim();
            } else {
                mKeyframeView.resetAnim();
            }
            mIsAnimed = !mIsAnimed;
        }
    }
}
