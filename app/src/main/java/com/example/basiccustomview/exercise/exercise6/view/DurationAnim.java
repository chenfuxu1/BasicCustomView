package com.example.basiccustomview.exercise.exercise6.view;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.basiccustomview.R;
import com.example.basiccustomview.Utils;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/12/3 20:46
 **/
public class DurationAnim extends RelativeLayout {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    SeekBar durationSb;
    TextView durationValueTv;
    Button animateBt;
    ImageView imageView;

    int duration = 300;
    int translationState = 0;

    public DurationAnim(Context context) {
        this(context, null);
    }

    public DurationAnim(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DurationAnim(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public DurationAnim(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        durationSb = (SeekBar) findViewById(R.id.durationSb);
        durationValueTv = (TextView) findViewById(R.id.durationValueTv);
        durationValueTv.setText(duration + "");
        durationSb.setMax(10);
        durationSb.setProgress(1);
        durationSb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                duration = progress * 300;
                durationValueTv.setText(duration + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        animateBt = (Button) findViewById(R.id.animateBt);
        imageView = (ImageView) findViewById(R.id.music);
        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (translationState) {
                    case 0:
                        imageView.animate().translationX(Utils.dpToPixel(100)).setDuration(duration);
                        break;
                    case 1:
                        imageView.animate().translationX(0).setDuration(duration);
                        break;
                }
                if (translationState < 1) {
                    translationState++;
                } else {
                    translationState = 0;
                }
            }
        });
    }
}
