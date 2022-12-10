package com.example.basiccustomview.customview.customview6;

import static android.graphics.Paint.Cap.ROUND;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.PathInterpolator;

import androidx.annotation.Nullable;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/12/1 23:36
 *
 *
 * ObjectAnimator
 * 使用方式：
 * 如果是自定义控件，需要添加 setter / getter 方法；
 * 用 ObjectAnimator.ofXXX() 创建 ObjectAnimator 对象；
 * 用 start() 方法执行动画。
 *
 * public class SportsView extends View {
 *     float progress = 0;
 *     ......
 *     // 创建 getter 方法
 *     public float getProgress() {
 *         return progress;
 *     }
 *
 *     // 创建 setter 方法
 *     public void setProgress(float progress) {
 *         this.progress = progress;
 *         invalidate();
 *     }
 *
 *     @Override
 *     public void onDraw(Canvas canvas) {
 *         super.onDraw(canvas);
 *         ......
 *         canvas.drawArc(arcRectF, 135, progress * 2.7f, false, paint);
 *         ......
 *     }
 * }
 * ......
 * 创建 ObjectAnimator 对象
 * ObjectAnimator animator = ObjectAnimator.ofFloat(view, "progress", 0, 65);
 * 执行动画
 * animator.start();
 *
 **/
public class SportsView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private float mProgress = 0f;
    private float mRadius = 200;
    private float mCenterX;
    private float mCenterY;

    {
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(40);
        mPaint.setTextSize(60);
        mPaint.setStrokeCap(ROUND);
    }

    public SportsView(Context context) {
        this(context, null);
    }

    public SportsView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SportsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public SportsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    // 给 ObjectAnimator 使用
    public float getProgress() {
        return mProgress;
    }

    /**
     * 给 ObjectAnimator 使用
     * ObjectAnimator 执行动画时，会不断不断改变 progress 的值
     * 进而赋值给 mProgress 进行重新绘制
     */
    public void setProgress(float progress) {
        mProgress = progress;
        // 这里重新绘制
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mCenterX = getWidth() / 2;
        mCenterY = getHeight() / 2;

        // 1、弧形范围计算
        RectF rectF = new RectF(mCenterX - mRadius, mCenterY - mRadius,
                mCenterX + mRadius, mCenterY + mRadius);
        /**
         * rectF: 绘制的区域
         * startAngle：开始角度
         * sweepAngle：扫过的角度(顺时针为正，逆时针为负)，此处 mProgress 表示扫过的百分比
         * useCenter：是否连接圆心
         * paint：使用的画笔
         */
        canvas.drawArc(rectF, 120, mProgress * 360 / 100, false, mPaint);

        // 2、绘制中心的百分比
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);
        String text = (int) mProgress + " %";
        Rect rect = new Rect();
        mPaint.getTextBounds(text, 0, text.length(), rect);
        float textWidth = rect.right - rect.left;
        float textHeight = rect.bottom - rect.top;
        canvas.drawText(text, 0, text.length(), mCenterX - textWidth / 2,
                mCenterY + textHeight / 2, mPaint);

        // 3、圆弧内外加圆圈
        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(6);
        canvas.drawCircle(mCenterX, mCenterY, mRadius + 20, mPaint);
        canvas.drawCircle(mCenterX, mCenterY, mRadius - 20, mPaint);

        // 复位画笔
        mPaint.setStrokeWidth(40);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.RED);
    }

    public void startAnim() {
        // 创建 ObjectAnimator 对象
        ObjectAnimator animator = ObjectAnimator.ofFloat(this, "progress", 0, 65);
        // 执行动画
        animator.start();
    }

    /**
     * 1. setDuration(int duration) 设置动画时长
     * 单位是毫秒。
     */
    public void animSetDuration() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(this, "progress", 0, 65);
        // 设置动画的执行时长为 1 s
        animator.setDuration(1000);
        animator.start();
    }

    /**
     * 2. setInterpolator(Interpolator interpolator) 设置 Interpolator
     * Interpolator 其实就是速度设置器。你在参数里填入不同的 Interpolator ，动画就会以不同的速度
     * 模型来执行。
     */
    public void animSetInterpolator() {
        /**
         * 1、AccelerateDecelerateInterpolator
         * 先加速再减速。这是默认的 Interpolator，也就是说如果你不设置的话，那么动画将会使用这个
         * Interpolator
         */

        /**
         * 2、线性插值器(匀速)
         */
        LinearInterpolator linearInterpolator = new LinearInterpolator();

        /**
         * 3、AccelerateInterpolator
         * 持续加速。在整个动画过程中，一直在加速，直到动画结束的一瞬间，直接停止。
         * 它主要用在离场效果中，比如某个物体从界面中飞离，就可以用这种效果。它给人的感觉就会是
         * 「这货从零起步，加速飞走了」。到了最后动画骤停的时候，物体已经飞出用户视野，看不到了，
         * 所以他们是并不会察觉到这个骤停的。
         */
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();

        /**
         * 4、DecelerateInterpolator
         * 持续减速直到 0。
         * 动画开始的时候是最高速度，然后在动画过程中逐渐减速，直到动画结束的时候恰好减速到 0。
         * 它的效果和上面这个 AccelerateInterpolator 相反，适用场景也和它相反：它主要用于入场效果，
         * 比如某个物体从界面的外部飞入界面后停在某处。它给人的感觉会是「咦飞进来个东西，让我仔细看看，
         * 哦原来是 XXX」。
         */
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();

        /**
         * 5、AnticipateInterpolator
         * 先回拉一下再进行正常动画轨迹。效果看起来有点像投掷物体或跳跃等动作前的蓄力。
         * 如果是图中这样的平移动画，那么就是位置上的回拉；如果是放大动画，那么就是先缩小一下再放大；
         * 其他类型的动画同理。
         * 这个 Interpolator 就有点耍花样了。没有通用的适用场景，根据具体需求和设计师的偏好而定。
         */
        AnticipateInterpolator anticipateInterpolator = new AnticipateInterpolator();

        /**
         * 6、OvershootInterpolator
         * 动画会超过目标值一些，然后再弹回来。效果看起来有点像你一屁股坐在沙发上后又被弹起来一点的感觉。
         * 和 AnticipateInterpolator 一样，这是个耍花样的 Interpolator，没有通用的适用场景
         */
        OvershootInterpolator overshootInterpolator = new OvershootInterpolator();

        /**
         * 7、AnticipateOvershootInterpolator
         * 上面这两个的结合版：开始前回拉，最后超过一些然后回弹。
         * 依然耍花样，不多解释。
         */
        AnticipateOvershootInterpolator anticipateOvershootInterpolator =
                new AnticipateOvershootInterpolator();

        /**
         * 8、BounceInterpolator
         * 在目标值处弹跳。有点像玻璃球掉在地板上的效果。
         */
        BounceInterpolator bounceInterpolator = new BounceInterpolator();

        /**
         * 9、CycleInterpolator
         * 这个也是一个正弦 / 余弦曲线，不过它和 AccelerateDecelerateInterpolator 的区别是，它可以
         * 自定义曲线的周期，所以动画可以不到终点就结束，也可以到达终点后回弹，回弹的次数由曲线的周期决定
         * 曲线的周期由 CycleInterpolator() 构造方法的参数决定。
         */
        CycleInterpolator cycleInterpolator = new CycleInterpolator(0.5f);

        /**
         * 10、PathInterpolator
         * 自定义动画完成度 / 时间完成度曲线。
         * 用这个 Interpolator 你可以定制出任何你想要的速度模型。定制的方式是使用一个 Path 对象来绘制出
         * 你要的动画完成度 / 时间完成度曲线。例如：
         * Path interpolatorPath = new Path();
         * // 匀速
         * interpolatorPath.lineTo(1, 1);
         *
         * 你根据需求，绘制出自己需要的 Path，就能定制出你要的速度模型。
         * 不过要注意，这条 Path 描述的其实是一个 y = f(x) (0 ≤ x ≤ 1) （y 为动画完成度，x 为时间完成度）
         * 的曲线，所以同一段时间完成度上不能有两段不同的动画完成度（这个好理解吧？因为内容不能出现分身术呀）
         * ，而且每一个时间完成度的点上都必须要有对应的动画完成度（因为内容不能在某段时间段内消失呀）。
         * 所以，下面这样的 Path 是非法的，会导致程序 FC：
         * 出现重复的动画完成度，即动画内容出现「分身」——程序 FC
         * 有一段时间完成度没有对应的动画完成度，即动画出现「中断」——程序 FC
         */
        Path path = new Path();

        // 1、匀速
        // path.lineTo(1, 1);

        // 2、先以「动画完成度 : 时间完成度 = 1 : 1」的速度匀速运行 25%
        path.lineTo(0.25f, 0.25f);
        // 然后瞬间跳跃到 150% 的动画完成度
        path.moveTo(0.25f, 1.5f);
        // 再匀速倒车，返回到目标点
        path.lineTo(1, 1);
        PathInterpolator pathInterpolator = new PathInterpolator(path);

        /**
         * 11、FastOutLinearInInterpolator
         * 加速运动。
         * 这个 Interpolator 的作用你不能看它的名字，一会儿 fast 一会儿 linear 的，完全看不懂。其实它
         * 和 AccelerateInterpolator 一样，都是一个持续加速的运动路线。只不过
         * FastOutLinearInInterpolator 的曲线公式是用的贝塞尔曲线，而 AccelerateInterpolator 用的是
         * 指数曲线。具体来说，它俩最主要的区别是 FastOutLinearInInterpolator 的初始阶段加速度比
         * AccelerateInterpolator 要快一些。
         * 在初始阶段，FastOutLinearInInterpolator 的加速度比 AccelerateInterpolator 更高
         */
        FastOutLinearInInterpolator fastOutLinearInInterpolator = new FastOutLinearInInterpolator();

        /**
         * 12、FastOutSlowInInterpolator
         * 先加速再减速。
         * 同样也是先加速再减速的还有前面说过的 AccelerateDecelerateInterpolator，不过它们的效果是明显
         * 不一样的。FastOutSlowInInterpolator 用的是贝塞尔曲线，AccelerateDecelerateInterpolator
         * 用的是正弦 / 余弦曲线。具体来讲， FastOutSlowInInterpolator 的前期加速度要快得多。
         * FastOutSlowInInterpolator 的前期加速更猛一些，后期的减速过程的也减得更迅速。用更直观一点的
         * 表达就是，AccelerateDecelerateInterpolator 像是物体的自我移动，而 FastOutSlowInInterpolator
         * 则看起来像有一股强大的外力「推」着它加速，在接近目标值之后又「拽」着它减速。
         * 总之，FastOutSlowInterpolator 看起来有一点「着急」的感觉
         */
        FastOutSlowInInterpolator fastOutSlowInInterpolator = new FastOutSlowInInterpolator();

        /**
         * 13、LinearOutSlowInInterpolator
         * 持续减速。
         * 它和 DecelerateInterpolator 比起来，同为减速曲线，主要区别在于 LinearOutSlowInInterpolator
         * 的初始速度更高。对于人眼的实际感觉，区别其实也不大，不过还是能看出来一些的。
         */
        LinearOutSlowInInterpolator linearOutSlowInInterpolator = new LinearOutSlowInInterpolator();

        ObjectAnimator animator = ObjectAnimator.ofFloat(this, "progress", 0, 65);
        // 设置动画的执行时长为 1 s
        animator.setDuration(1000);
        // 设置插值器
        animator.setInterpolator(linearOutSlowInInterpolator);
        animator.start();
    }
}
