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
public class ScaleAnim extends RelativeLayout {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private ImageView mMusic;
    private TextView mScaleX;
    private TextView mScaleY;
    private boolean mHasScaleX;
    private boolean mHasScaleY;

    public ScaleAnim(Context context) {
        this(context, null);
    }

    public ScaleAnim(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScaleAnim(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public ScaleAnim(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
        mScaleX = findViewById(R.id.scale_x);
        mScaleY = findViewById(R.id.scale_y);
    }

    private void initListener() {
        mScaleX.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                scaleBig();
            }
        });
        mScaleY.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                scaleSmall();
            }
        });
    }

    private void scaleBig() {
        if (!mHasScaleX) {
            mMusic.animate()
                    .scaleX(1.5f)
                    .setDuration(1000);
        } else {
            mMusic.animate()
                    .scaleX(1f)
                    .setDuration(1000);
        }
        mHasScaleX = !mHasScaleX;
    }

    private void scaleSmall() {
        if (!mHasScaleY) {
            mMusic.animate()
                    .scaleY(0.5f)
                    .setDuration(1000);
        } else {
            mMusic.animate()
                    .scaleY(1f)
                    .setDuration(1000);
        }
        mHasScaleY = !mHasScaleY;
    }
}
