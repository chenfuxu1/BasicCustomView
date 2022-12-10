package com.example.basiccustomview.customview.customview4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.basiccustomview.R;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/11/12 19:50
 *
 * 自定义 View 1-4 Canvas 对绘制的辅助
 **/
public class CustomView4 extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path mPath = new Path();
    private String mText = "人世间，如梦如幻！";

    {
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setTextSize(80);
    }

    public CustomView4(Context context) {
        this(context, null);
    }

    public CustomView4(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomView4(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /**
         * 1 范围裁切
         * 范围裁切有两个方法： clipRect() 和 clipPath()。裁切方法之后的绘制代码，都会被限制在裁切范围内。
         * 记得要加上 Canvas.save() 和 Canvas.restore() 来及时恢复绘制范围
         */
        // canvas.save();
        // Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.jinshang);
        // // 开始裁切
        // canvas.clipRect(50, 50, 600, 400);
        // canvas.drawBitmap(bitmap, 20, 20, mPaint);
        // canvas.restore(); // 恢复裁切的设置

        /**
         * 1.2 clipPath()
         * 其实和 clipRect() 用法完全一样，只是把参数换成了 Path
         */
        // Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.yihu);
        // Path path1 = new Path();
        // path1.addOval(100, 50, 600, 600, Path.Direction.CW);
        // canvas.save();
        // canvas.clipPath(path1);
        // canvas.drawBitmap(bitmap, 20, 20, mPaint);
        // canvas.restore();
        //
        // Path path2 = new Path();
        // path2.addArc(100, 700, 900, 1200, 10, 100);
        // canvas.save();
        // canvas.clipPath(path2);
        // canvas.drawBitmap(bitmap, 20, 700, mPaint);
        // canvas.restore();

        /**
         * 2 几何变换
         * 几何变换的使用大概分为三类：
         *
         * 使用 Canvas 来做常见的二维变换；
         * 使用 Matrix 来做常见和不常见的二维变换；
         * 使用 Camera 来做三维变换。
         */

        /**
         * 2.1 使用 Canvas 来做常见的二维变换：
         * 2.1.1 Canvas.translate(float dx, float dy) 平移
         * 参数里的 dx 和 dy 表示横向和纵向的位移
         *
         * 注意：这里的变换指的是坐标系的变化
         */
        // Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.jinshang);
        // canvas.save();
        // canvas.translate(200, 0); // 坐标系向右平移了 200 个像素
        // canvas.drawBitmap(bitmap, 0, 0, mPaint);
        // canvas.restore();

        /**
         * 2.1.2 Canvas.rotate(float degrees, float px, float py) 旋转
         * 参数里的 degrees 是旋转角度，单位是度（也就是一周有 360° 的那个单位），方向是顺时针为正向；
         * px 和 py 是轴心的位置
         */
        // Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.jinshang);
        // canvas.save();
        // canvas.rotate(45, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
        // canvas.drawBitmap(bitmap, 0, 0, mPaint);
        // canvas.restore();

        /**
         * 2.1.3 Canvas.scale(float sx, float sy, float px, float py) 放缩
         * 参数里的 sx sy 是横向和纵向的放缩倍数； px py 是放缩的轴心
         */
        // int x = 0;
        // int y = 0;
        // Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.jinshang);
        // canvas.save();
        // canvas.scale(0.5f, 0.5f, x + bitmap.getWidth() / 2, y + bitmap.getHeight() / 2);
        // canvas.drawBitmap(bitmap, x, y, mPaint);
        // canvas.restore();

        /**
         * 2.1.4 skew(float sx, float sy) 错切
         * 参数里的 sx 和 sy 是 x 方向和 y 方向的错切系数
         */
        // Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.jinshang);
        // canvas.save();
        // canvas.skew(-0.5f, 0);
        // canvas.drawBitmap(bitmap, bitmap.getWidth() / 2, 0, mPaint);
        // canvas.restore();

        /**
         * 2.2 使用 Matrix 来做变换
         * 2.2.1 使用 Matrix 来做常见变换
         * Matrix 做常见变换的方式：
         * 1.创建 Matrix 对象；
         * 2.调用 Matrix 的 pre/postTranslate/Rotate/Scale/Skew() 方法来设置几何变换；
         * 3.使用 Canvas.setMatrix(matrix) 或 Canvas.concat(matrix) 来把几何变换应用到 Canvas
         *
         * 把 Matrix 应用到 Canvas 有两个方法： Canvas.setMatrix(matrix) 和 Canvas.concat(matrix)。
         * Canvas.setMatrix(matrix)：用 Matrix 直接替换 Canvas 当前的变换矩阵，即抛弃 Canvas 当前的变换，
         * 改用 Matrix 的变换（注：不同的系统中 setMatrix(matrix) 的行为可能不一致，
         * 所以还是尽量用 concat(matrix) 吧）；
         * Canvas.concat(matrix)：用 Canvas 当前的变换矩阵和 Matrix 相乘，即基于 Canvas 当前的变换，
         * 叠加上 Matrix 中的变换。
         */
        // Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.jinshang);
        // // 1.创建 Matrix 对象；
        // Matrix matrix = new Matrix();
        // // 2.调用 Matrix 的 pre/postTranslate/Rotate/Scale/Skew() 方法来设置几何变换；
        // matrix.reset();
        // matrix.postTranslate(300, 0);
        // // 3.使用 Canvas.setMatrix(matrix) 或 Canvas.concat(matrix) 来把几何变换应用到 Canvas
        // canvas.save();
        // canvas.concat(matrix);
        // canvas.drawBitmap(bitmap, 0, 0, mPaint);
        // canvas.restore();

        /**
         * 2.2.2 使用 Matrix 来做自定义变换
         * Matrix 的自定义变换使用的是 setPolyToPoly() 方法。
         * 2.2.2.1 Matrix.setPolyToPoly(float[] src, int srcIndex, float[] dst, int dstIndex,
         * int pointCount) 用点对点映射的方式设置变换
         * poly 就是「多」的意思。setPolyToPoly() 的作用是通过多点的映射的方式来直接设置变换。
         * 「多点映射」的意思就是把指定的点移动到给出的位置，从而发生形变。例如：(0, 0) -> (100, 100)
         * 表示把 (0, 0) 位置的像素移动到 (100, 100) 的位置，这个是单点的映射，单点映射可以实现平移。
         * 而多点的映射，就可以让绘制内容任意地扭曲
         * src 和 dst 是源点集合目标点集；srcIndex 和 dstIndex 是第一个点的偏移；pointCount
         * 是采集的点的个数（个数不能大于 4，因为大于 4 个点就无法计算变换了）
         */
        // Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.jinshang);
        // float left = 0;
        // float top = 0;
        // float right = bitmap.getWidth();
        // float bottom = bitmap.getHeight();
        // float[] pointSrc = {left, top, right, top, left, bottom, right, bottom};
        // float[] pointDst = {left - 10, top + 50, right + 120, top - 90, left + 20, bottom + 30,
        //         right + 20, bottom + 60};
        // Matrix matrix = new Matrix();
        // matrix.reset();
        // matrix.setPolyToPoly(pointSrc, 0, pointDst, 0, 4);
        // canvas.save();
        // canvas.concat(matrix);
        // canvas.drawBitmap(bitmap, 50, 80, mPaint);
        // canvas.restore();

        /**
         * 2.3 使用 Camera 来做三维变换
         * Camera 的三维变换有三类：旋转、平移、移动相机。
         *
         * 2.3.1 Camera.rotate*() 三维旋转
         * Camera.rotate*() 一共有四个方法： rotateX(deg) rotateY(deg) rotateZ(deg) rotate(x, y, z)
         */
        // Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.jinshang);
        // Camera camera = new Camera();
        // canvas.save();
        //
        // camera.save(); // 保存 Camera 的状态
        // camera.rotateX(30); // 旋转 Camera 的三维空间
        // camera.applyToCanvas(canvas); // 把旋转投影到 Canvas
        // camera.restore(); // 恢复 Camera 的状态
        //
        // canvas.drawBitmap(bitmap, 0, 0, mPaint);
        // canvas.restore();

        /**
         * 如果你需要图形左右对称，需要配合上 Canvas.translate()，在三维旋转之前把绘制内容的中心点移动
         * 到原点，即旋转的轴心，然后在三维旋转后再把投影移动回来：
         * Canvas 的几何变换顺序是反的，所以要把移动到中心的代码写在下面，把从中心移动回来的代码写在上面
         */
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.jinshang);
        int x = 200;
        int y = 0;
        int centerX = bitmap.getWidth() / 2 + x;
        int centerY = bitmap.getHeight() / 2 + y;
        Camera camera = new Camera();
        canvas.save();

        camera.save(); // 保存 Camera 的状态
        camera.rotateX(30); // 旋转 Camera 的三维空间
        canvas.translate(centerX, centerY); // 旋转之后把投影移动回来
        camera.applyToCanvas(canvas); // 把旋转投影到 Canvas
        canvas.translate(-centerX, -centerY); // 旋转之前把绘制内容移动到轴心（原点）
        camera.restore(); // 恢复 Camera 的状态

        canvas.drawBitmap(bitmap, x, y, mPaint);
        canvas.restore();

        /**
         * 2.3.2 Camera.translate(float x, float y, float z) 移动
         */

        /**
         * 2.3.3 Camera.setLocation(x, y, z) 设置虚拟相机的位置
         * 注意！它的参数的单位不是像素，而是 inch，英寸
         * 在 Camera 中，相机的默认位置是 (0, 0, -8)（英寸）。8 x 72 = 576，所以它的默认位置是
         * (0, 0, -576)（像素）。
         *
         * 如果绘制的内容过大，当它翻转起来的时候，就有可能出现图像投影过大的「糊脸」效果。而且由于换算
         * 单位被写死成了 72 像素，而不是和设备 dpi 相关的，所以在像素越大的手机上，这种「糊脸」效果会越明显。
         * 而使用 setLocation() 方法来把相机往后移动，就可以修复这种问题。
         *
         * camera.setLocation(0, 0, newZ);
         * Camera.setLocation(x, y, z) 的 x 和 y 参数一般不会改变，直接填 0 就好
         */
    }
}
