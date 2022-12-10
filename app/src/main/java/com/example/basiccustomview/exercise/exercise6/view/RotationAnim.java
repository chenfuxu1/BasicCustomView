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
public class RotationAnim extends RelativeLayout {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private ImageView mMusic;
    private TextView mRotation;
    private TextView mRotationX;
    private TextView mRotationY;
    private Boolean mHasRotation = false;
    private Boolean mHasRotationX = false;
    private Boolean mHasRotationY = false;

    public RotationAnim(Context context) {
        this(context, null);
    }

    public RotationAnim(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RotationAnim(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public RotationAnim(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
        mRotation = findViewById(R.id.rotation);
        mRotationX = findViewById(R.id.rotation_x);
        mRotationY = findViewById(R.id.rotation_y);
    }

    private void initListener() {
        mRotation.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                rotation();
            }
        });
        mRotationX.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                rotationX();
            }
        });
        mRotationY.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                rotationY();
            }
        });
    }

    private void rotation() {
        if (!mHasRotation) {
            mMusic.animate()
                    .rotation(180)
                    .setDuration(1000);
        } else {
            mMusic.animate()
                    .rotation(0)
                    .setDuration(1000);
        }
        mHasRotation = !mHasRotation;
    }

    private void rotationX() {
        if (!mHasRotationX) {
            mMusic.animate()
                    .rotationX(180)
                    .setDuration(1000);
        } else {
            mMusic.animate()
                    .rotationX(0)
                    .setDuration(1000);
        }
        mHasRotationX = !mHasRotationX;
    }

    private void rotationY() {
        if (!mHasRotationY) {
            mMusic.animate()
                    .rotationY(180)
                    .setDuration(1000);
        } else {
            mMusic.animate()
                    .rotationY(0)
                    .setDuration(1000);
        }
        mHasRotationY = !mHasRotationY;
    }
}
