package com.example.basiccustomview.exercise.exercise4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.basiccustomview.R;

/**
 * 整个动画拆分成了三部分
 *
 */

public class MapView extends View {

    //Y轴方向旋转角度
    private float mDegreeY;
    //不变的那一半，Y轴方向旋转角度
    private float mFixDegreeY;
    //Z轴方向（平面内）旋转的角度
    private float mDegreeZ;

    private Paint mPaint;
    private Bitmap mBitmap;
    private Camera mCamera;

    public MapView(Context context) {
        this(context, null);
    }

    public MapView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MapView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.flip_board);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCamera = new Camera();

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float newZ = -displayMetrics.density * 10;
        mCamera.setLocation(0, 0, newZ);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int bitmapWidth = mBitmap.getWidth();
        int bitmapHeight = mBitmap.getHeight();
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int x = centerX - bitmapWidth / 2;
        int y = centerY - bitmapHeight / 2;

        //画变换的一半
        //先旋转，再裁切，再使用camera执行3D动效,**然后保存camera效果**,最后再旋转回来
        canvas.save();
        mCamera.save();
        canvas.translate(centerX, centerY);
        canvas.rotate(-mDegreeZ);
        mCamera.rotateY(mDegreeY);
        mCamera.applyToCanvas(canvas);
        //计算裁切参数时清注意，此时的canvas的坐标系已经移动
        canvas.clipRect(0, -centerY, centerX, centerY);
        canvas.rotate(mDegreeZ);
        canvas.translate(-centerX, -centerY);
        mCamera.restore();
        canvas.drawBitmap(mBitmap, x, y, mPaint);
        canvas.restore();

        //画不变换的另一半
        canvas.save();
        mCamera.save();
        canvas.translate(centerX, centerY);
        canvas.rotate(-mDegreeZ);
        //计算裁切参数时清注意，此时的canvas的坐标系已经移动
        canvas.clipRect(-centerX, -centerY, 0, centerY);
        //此时的canvas的坐标系已经旋转，所以这里是rotateY
        mCamera.rotateY(mFixDegreeY);
        mCamera.applyToCanvas(canvas);
        canvas.rotate(mDegreeZ);
        canvas.translate(-centerX, -centerY);
        mCamera.restore();
        canvas.drawBitmap(mBitmap, x, y, mPaint);
        canvas.restore();
    }

    /**
     * 启动动画之前调用，把参数reset到初始状态
     */
    public void reset() {
        mDegreeY = 0;
        mFixDegreeY = 0;
        mDegreeZ = 0;
    }


    public void setFixDegreeY(float fixDegreeY) {
        this.mFixDegreeY = fixDegreeY;
        invalidate();
    }

    public void setDegreeY(float degreeY) {
        this.mDegreeY = degreeY;
        invalidate();
    }

    public void setDegreeZ(float degreeZ) {
        this.mDegreeZ = degreeZ;
        invalidate();
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
        invalidate();
    }

}
