package com.example.basiccustomview.exercise.exercise7.view.ofobject;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.basiccustomview.R;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/12/7 22:20
 **/
public class OfObjectLayout extends RelativeLayout {
    private OfObjectView mOfObjectView;
    private TextView mAnimTV;
    private boolean mIsAnimed;

    public OfObjectLayout(Context context) {
        this(context, null);
    }

    public OfObjectLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OfObjectLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public OfObjectLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        initView();
        initListener();
    }

    private void initView() {
        mOfObjectView = findViewById(R.id.of_object_view);
        mAnimTV = findViewById(R.id.anim_tv);
    }

    private void initListener() {
        mAnimTV.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                executeAnim();
            }
        });
    }

    private void executeAnim() {
        if (mOfObjectView != null) {
            if (!mIsAnimed) {
                mOfObjectView.startAnim();
            } else {
                mOfObjectView.resetAnim();
            }
            mIsAnimed = !mIsAnimed;
        }
    }
}
