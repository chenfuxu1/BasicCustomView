package com.example.basiccustomview.exercise.exercise6.view;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.basiccustomview.R;
import com.example.basiccustomview.Utils;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/12/3 20:46
 **/
public class MultiPropertiesAnim extends RelativeLayout {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private ImageView mMusic;
    private TextView mMultiProperties;
    private boolean mIsAnimed;

    public MultiPropertiesAnim(Context context) {
        this(context, null);
    }

    public MultiPropertiesAnim(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MultiPropertiesAnim(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public MultiPropertiesAnim(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
        mMusic.setScaleX(0);
        mMusic.setScaleY(0);
        mMusic.setAlpha(0f);
        mMultiProperties = findViewById(R.id.multi_properties);
    }

    private void initListener() {
        mMultiProperties.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                executeAnim();
            }
        });
    }

    private void executeAnim() {
        if (!mIsAnimed) {
            mMusic.animate()
                    .translationX(Utils.dpToPixel(180))
                    .rotation(360)
                    .scaleX(1)
                    .scaleY(1)
                    .alpha(1);
        } else {
            mMusic.animate()
                    .translationX(0)
                    .rotation(0)
                    .scaleX(0)
                    .scaleY(0)
                    .alpha(0);
        }
        mIsAnimed = !mIsAnimed;
    }
}
