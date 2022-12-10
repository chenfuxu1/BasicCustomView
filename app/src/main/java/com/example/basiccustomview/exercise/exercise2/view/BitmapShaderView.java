package com.example.basiccustomview.exercise.exercise2.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.basiccustomview.R;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/11/20 16:24
 *
 * 用 Paint.setShader(shader) 设置一个 BitmapShader
 * Bitmap: R.mipmap.yihu
 *
 * 构造方法：
 * BitmapShader(Bitmap bitmap, Shader.TileMode tileX, Shader.TileMode tileY)
 * 参数：
 * bitmap：用来做模板的 Bitmap 对象
 * tileX：横向的 TileMode
 * tileY：纵向的 TileMode。
 * 如果你想绘制圆形的 Bitmap，就别用 drawBitmap() 了，改用 drawCircle() + BitmapShader
 * 就可以了（其他形状同理）
 **/
public class BitmapShaderView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public BitmapShaderView(Context context) {
        super(context);
    }

    public BitmapShaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BitmapShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.yihu);
        Shader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        mPaint.setShader(shader);
        canvas.drawCircle(500, 400, 300, mPaint);
    }
}
