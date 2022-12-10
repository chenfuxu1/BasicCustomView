package com.example.basiccustomview.exercise.exercise2.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ComposeShader;
import android.graphics.Paint;
import android.graphics.PorterDuff;
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
 * 构造方法：ComposeShader(Shader shaderA, Shader shaderB, PorterDuff.Mode mode)
 * 参数：
 * shaderA, shaderB：两个相继使用的 Shader
 * mode: 两个 Shader 的叠加模式，即 shaderA 和 shaderB 应该怎样共同绘制。它的类型是 PorterDuff.Mode
 **/
public class ComposeShaderView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public ComposeShaderView(Context context) {
        super(context);
    }

    public ComposeShaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ComposeShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.mipmap.yihu2);
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.mipmap.cup);
        Shader shader1 = new BitmapShader(bitmap1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Shader shader2 = new BitmapShader(bitmap2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        // ComposeShader：结合两个 Shader
        Shader shader = new ComposeShader(shader1, shader2, PorterDuff.Mode.SRC_OVER);
        mPaint.setShader(shader);
        canvas.drawCircle(300, 300, 300, mPaint);
    }
}
