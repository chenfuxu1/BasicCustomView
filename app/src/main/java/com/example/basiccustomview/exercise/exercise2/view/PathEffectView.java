package com.example.basiccustomview.exercise.exercise2.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.SumPathEffect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/11/20 16:24
 *
 * 使用 Paint.setPathEffect() 来设置不同的 PathEffect
 * 使用 PathEffect 来给图形的轮廓设置效果。对 Canvas 所有的图形绘制有效，
 * 也就是 drawLine() drawCircle() drawPath() 这些方法
 **/
public class PathEffectView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path mPath = new Path();

    {
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);
        mPath.moveTo(50, 100);
        mPath.rLineTo(50, 100);
        mPath.rLineTo(80, -150);
        mPath.rLineTo(100, 100);
        mPath.rLineTo(70, -120);
        mPath.rLineTo(150, 80);
    }

    public PathEffectView(Context context) {
        super(context);
    }

    public PathEffectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PathEffectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /**
         * 第一处：CornerPathEffect
         * 它的构造方法 CornerPathEffect(float radius) 的参数 radius 是圆角的半径
         */
        PathEffect cornerPathEffect = new CornerPathEffect(20);
        mPaint.setPathEffect(cornerPathEffect);
        canvas.drawPath(mPath, mPaint);
        canvas.save();

        canvas.translate(500, 0);
        /**
         * 第二处：DiscretePathEffect
         * DiscretePathEffect 具体的做法是，把绘制改为使用定长的线段来拼接，并且在拼接的时候对路径进行
         * 随机偏离。它的构造方法 DiscretePathEffect(float segmentLength, float deviation) 的两个
         * 参数中， segmentLength 是用来拼接的每个线段的长度， deviation 是偏离量。这两个值设置得不一样，
         * 显示效果也会不一样
         */
        PathEffect discretePathEffect = new DiscretePathEffect(20, 5);
        mPaint.setPathEffect(discretePathEffect);
        canvas.drawPath(mPath, mPaint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 200);
        /**
         * 第三处：DashPathEffect
         * 它的构造方法 DashPathEffect(float[] intervals, float phase) 中， 第一个参数 intervals
         * 是一个数组，它指定了虚线的格式：数组中元素必须为偶数（最少是 2 个），按照「画线长度、空白长度、
         * 画线长度、空白长度」……的顺序排列，例如上面代码中的 20, 5, 10, 5 就表示虚线是按照「画 20 像素、
         * 空 5 像素、画 10 像素、空 5 像素」的模式来绘制；第二个参数 phase 是虚线的偏移量
         */
        PathEffect dashPathEffect = new DashPathEffect(new float[] {20, 10, 5, 10}, 0);
        mPaint.setPathEffect(dashPathEffect);
        canvas.drawPath(mPath, mPaint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 200);
        /**
         * 第四处：PathDashPathEffect
         * 这个方法比 DashPathEffect 多一个前缀 Path ，所以顾名思义，它是使用一个 Path 来绘制「虚线」
         * 它的构造方法 PathDashPathEffect(Path shape, float advance, float phase,
         * PathDashPathEffect.Style style) 中， shape 参数是用来绘制的 Path ； advance 是两个相邻的
         * shape 段之间的间隔，不过注意，这个间隔是两个 shape 段的起点的间隔，而不是前一个的终点和后一个
         * 的起点的距离； phase 和 DashPathEffect 中一样，是虚线的偏移；最后一个参数 style，是用来指定
         * 拐弯改变的时候 shape 的转换方式。style 的类型为 PathDashPathEffect.Style ，是一个 enum ，
         * 具体有三个值：
         * TRANSLATE：位移
         * ROTATE：旋转
         * MORPH：变体
         */
        Path dashPath = new Path(); // 使用一个三角形来做 dash
        dashPath.moveTo(15, 0);
        dashPath.lineTo(0, 15);
        dashPath.lineTo(30, 15);
        dashPath.lineTo(15, 0);
        PathEffect pathEffect = new PathDashPathEffect(dashPath, 40, 0,
                PathDashPathEffect.Style.TRANSLATE);
        mPaint.setPathEffect(pathEffect);
        canvas.drawPath(mPath, mPaint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 400);
        /**
         * 第五处：SumPathEffect
         * 这是一个组合效果类的 PathEffect 。它的行为特别简单，就是分别按照两种 PathEffect
         * 分别对目标进行绘制
         */
        PathEffect dashEffect = new DashPathEffect(new float[]{20, 10}, 0);
        PathEffect discreteEffect = new DiscretePathEffect(20, 5);
        pathEffect = new SumPathEffect(dashEffect, discreteEffect);
        mPaint.setPathEffect(pathEffect);
        canvas.drawPath(mPath, mPaint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 400);
        /**
         * 第六处：ComposePathEffect
         * 这也是一个组合效果类的 PathEffect 。不过它是先对目标 Path 使用一个 PathEffect，
         * 然后再对这个改变后的 Path 使用另一个 PathEffect
         * 它的构造方法 ComposePathEffect(PathEffect outerpe, PathEffect innerpe) 中的两个
         * PathEffect 参数， innerpe 是先应用的， outerpe 是后应用的。所以上面的代码就是「先偏离，
         * 再变虚线」。而如果把两个参数调换，就成了「先变虚线，再偏离」
         */
        PathEffect dashEffect2 = new DashPathEffect(new float[]{20, 10}, 0);
        PathEffect discreteEffect2 = new DiscretePathEffect(20, 5);
        pathEffect = new ComposePathEffect(dashEffect2, discreteEffect2);
        mPaint.setPathEffect(pathEffect);
        canvas.drawPath(mPath, mPaint);
        canvas.restore();
    }
}
