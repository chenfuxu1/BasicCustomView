package com.example.basiccustomview.exercise.exercise6.view;

import static com.example.basiccustomview.Utils.dpToPixel;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.basiccustomview.R;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/12/3 20:46
 **/
public class TranslationAnim extends RelativeLayout {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private ImageView mMusic;
    private TextView mTranslationX;
    private TextView mTranslationY;
    private TextView mTranslationZ;
    private Boolean mHasTranslationX = false;
    private Boolean mHasTranslationY = false;
    private Boolean mHasTranslationZ = false;

    public TranslationAnim(Context context) {
        this(context, null);
    }

    public TranslationAnim(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TranslationAnim(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public TranslationAnim(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
        // 给音乐图标加上阴影
        mMusic.setOutlineProvider(new MusicOutlineProvider());
        mTranslationX = findViewById(R.id.translation_x);
        mTranslationY = findViewById(R.id.translation_y);
        mTranslationZ = findViewById(R.id.translation_z);
    }

    private void initListener() {
        mTranslationX.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                translationX();
            }
        });

        mTranslationY.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                translationY();
            }
        });

        mTranslationZ.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                translationZ();
            }
        });
    }

    private void translationX() {
        if (!mHasTranslationX) {
            mMusic.animate().
                    translationX(500)
                    .setDuration(1000);
        } else {
            mMusic.animate().
                    translationX(0)
                    .setDuration(1000);
        }
        mHasTranslationX = !mHasTranslationX;
    }

    private void translationY() {
        if (!mHasTranslationY) {
            mMusic.animate().
                    translationY(500)
                    .setDuration(1000);
        } else {
            mMusic.animate().
                    translationY(0)
                    .setDuration(1000);
        }
        mHasTranslationY = !mHasTranslationY;
    }

    private void translationZ() {
        // 不生效
        if (!mHasTranslationZ) {
            mMusic.animate().
                    translationZ(500)
                    .setDuration(1000);
        } else {
            mMusic.animate().
                    translationZ(0)
                    .setDuration(1000);
        }
        mHasTranslationZ = !mHasTranslationZ;
    }

    /**
     * 为音乐图标设置三角形的 Outline。
     */
    class MusicOutlineProvider extends ViewOutlineProvider {
        Path path = new Path();

        {
            path.moveTo(0, dpToPixel(10));
            path.lineTo(dpToPixel(7), dpToPixel(2));
            path.lineTo(dpToPixel(116), dpToPixel(58));
            path.lineTo(dpToPixel(116), dpToPixel(70));
            path.lineTo(dpToPixel(7), dpToPixel(128));
            path.lineTo(0, dpToPixel(120));
            path.close();
        }

        @Override
        public void getOutline(View view, Outline outline) {
            outline.setConvexPath(path);
        }

    }
}
