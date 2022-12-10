package com.example.basiccustomview.exercise.exercise9.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

import com.example.basiccustomview.Logit;
import com.example.basiccustomview.R;
import com.example.basiccustomview.Utils;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/12/10 12:58
 **/
public class ParentView extends RelativeLayout {
    private static final String TAG = "ParentView";
    private SquareImageLayout mSquareImageLayout;
    private SeekBar mSeekBarWidth;
    private SeekBar mSeekBarHeight;

    private SquareImageLayout2 mSquareImageLayout2;
    private SeekBar mSeekBarWidth2;
    private SeekBar mSeekBarHeight2;

    private float mMinWidth = Utils.dpToPixel(120);
    private float mMinHeight = Utils.dpToPixel(150);

    public ParentView(Context context) {
        this(context, null);
    }

    public ParentView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ParentView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public ParentView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        initView();
        initListener();
        Logit.d(TAG, "cfx 11111111111111");
    }

    private void initView() {
        mSquareImageLayout = findViewById(R.id.square_image_layout);
        mSeekBarWidth = findViewById(R.id.seek_bar_width);
        mSeekBarHeight = findViewById(R.id.seek_bar_height);

        mSquareImageLayout2 = findViewById(R.id.square_image_layout_2);
        mSeekBarWidth2 = findViewById(R.id.seek_bar_width_2);
        mSeekBarHeight2 = findViewById(R.id.seek_bar_height_2);
    }

    private void initListener() {
        mSeekBarWidth.setOnSeekBarChangeListener(mSeekBarChangeListener);
        mSeekBarHeight.setOnSeekBarChangeListener(mSeekBarChangeListener);

        mSeekBarWidth2.setOnSeekBarChangeListener(mSeekBarChangeListener2);
        mSeekBarHeight2.setOnSeekBarChangeListener(mSeekBarChangeListener2);
    }

    SeekBar.OnSeekBarChangeListener mSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if (mSquareImageLayout != null) {
                ViewGroup.LayoutParams layoutParams = mSquareImageLayout.getLayoutParams();
                layoutParams.width = (int) (mMinWidth + mSeekBarWidth.getProgress() * 3);
                layoutParams.height = (int) (mMinHeight + mSeekBarHeight.getProgress() * 3);
                mSquareImageLayout.setLayoutParams(layoutParams);
            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    SeekBar.OnSeekBarChangeListener mSeekBarChangeListener2 = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if (mSquareImageLayout != null) {
                ViewGroup.LayoutParams layoutParams = mSquareImageLayout2.getLayoutParams();
                layoutParams.width = (int) (mMinWidth + mSeekBarWidth2.getProgress() * 4);
                layoutParams.height = (int) (mMinHeight + mSeekBarHeight2.getProgress() * 3);
                mSquareImageLayout2.setLayoutParams(layoutParams);
            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
}
