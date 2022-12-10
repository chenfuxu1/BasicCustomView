package com.example.basiccustomview.exercise.exercise6.view;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

import com.example.basiccustomview.R;
import com.example.basiccustomview.Utils;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/12/3 20:46
 **/
public class InterpolatorAnim extends LinearLayout {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Spinner mSpinner;
    private ImageView mMusic;
    private TextView mAnimTv;

    private final Interpolator[] mInterpolator = new Interpolator[13];
    private Path mInterpolatorPath;

    {
        mInterpolatorPath = new Path();
        mInterpolatorPath.lineTo(0.25f, 0.25f);
        mInterpolatorPath.moveTo(0.25f, 1.5f);
        mInterpolatorPath.lineTo(1, 1);
        mInterpolator[0] = new AccelerateDecelerateInterpolator();
        mInterpolator[1] = new LinearInterpolator();
        mInterpolator[2] = new AccelerateInterpolator();
        mInterpolator[3] = new DecelerateInterpolator();
        mInterpolator[4] = new AnticipateInterpolator();
        mInterpolator[5] = new OvershootInterpolator();
        mInterpolator[6] = new AnticipateOvershootInterpolator();
        mInterpolator[7] = new BounceInterpolator();
        mInterpolator[8] = new CycleInterpolator(0.5f);
        mInterpolator[9] = PathInterpolatorCompat.create(mInterpolatorPath);
        mInterpolator[10] = new FastOutLinearInInterpolator();
        mInterpolator[11] = new FastOutSlowInInterpolator();
        mInterpolator[12] = new LinearOutSlowInInterpolator();
    }

    public InterpolatorAnim(Context context) {
        this(context, null);
    }

    public InterpolatorAnim(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public InterpolatorAnim(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public InterpolatorAnim(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        initView();
        initListener();
    }

    private void initView() {
        mSpinner = (Spinner) findViewById(R.id.interpolator_spinner);
        mAnimTv = (TextView) findViewById(R.id.anim_tv);
        mMusic = (ImageView) findViewById(R.id.music);
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
        mMusic.animate()
                .translationX(Utils.dpToPixel(180))
                .setDuration(1000)
                .setInterpolator(mInterpolator[mSpinner.getSelectedItemPosition()])
                .withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        mMusic.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                mMusic.setTranslationX(0);
                            }
                        }, 1000);
                    }
                });
    }
}
