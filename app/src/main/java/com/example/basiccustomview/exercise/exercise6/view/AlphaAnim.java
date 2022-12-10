package com.example.basiccustomview.exercise.exercise6.view;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.basiccustomview.R;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/12/3 20:46
 **/
public class AlphaAnim extends RelativeLayout {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private ImageView mMusic;
    private TextView mAlphaToZero;
    private TextView mAlphaToOne;
    private boolean mHasAlphaToZero;
    private boolean mHasAlphaToOne;

    public AlphaAnim(Context context) {
        this(context, null);
    }

    public AlphaAnim(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AlphaAnim(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public AlphaAnim(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
        mAlphaToZero = findViewById(R.id.alpha_0);
        mAlphaToOne = findViewById(R.id.alpha_1);
    }

    private void initListener() {
        mAlphaToZero.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                alphaToZero();
            }
        });
        mAlphaToOne.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                alphaToOne();
            }
        });
    }

    private void alphaToZero() {
        if (!mHasAlphaToZero) {
            mMusic.animate()
                    .alpha(0)
                    .setDuration(1000);
        } else {
            mMusic.animate()
                    .alpha(1)
                    .setDuration(1000);
        }
        mHasAlphaToZero = !mHasAlphaToZero;
    }

    private void alphaToOne() {
        if (!mHasAlphaToOne) {
            mMusic.animate()
                    .alpha(1)
                    .setDuration(1000);
        } else {
            mMusic.animate()
                    .alpha(0)
                    .setDuration(1000);
        }
        mHasAlphaToOne = !mHasAlphaToOne;
    }
}
