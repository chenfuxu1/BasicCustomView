package com.example.basiccustomview.exercise.exercise6.view;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.basiccustomview.R;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/12/3 20:46
 **/
public class ObjectAnimatorViewAnim extends RelativeLayout {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private SportsView mSportsView;
    private TextView mAnimTv;
    private boolean mIsAnimed;

    public ObjectAnimatorViewAnim(Context context) {
        this(context, null);
    }

    public ObjectAnimatorViewAnim(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ObjectAnimatorViewAnim(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public ObjectAnimatorViewAnim(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        initView();
        initListener();
    }

    private void initView() {
        mSportsView = findViewById(R.id.sports_view);
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
            if (mSportsView != null) {
                mSportsView.startAnim();
            }
        } else {
            if (mSportsView != null) {
                mSportsView.resetAnim();
            }
        }
        mIsAnimed = !mIsAnimed;
    }
}
