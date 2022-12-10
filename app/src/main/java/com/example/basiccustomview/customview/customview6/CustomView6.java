package com.example.basiccustomview.customview.customview6;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

import com.example.basiccustomview.R;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/11/12 19:50
 *
 * 自定义 View 1-6：属性动画 Property Animation（上手篇）
 **/
public class CustomView6 extends LinearLayout {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private ImageView mYiHu;


    public CustomView6(Context context) {
        this(context, null);
    }

    public CustomView6(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomView6(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        initView();
    }

    private void initView() {
        mYiHu = findViewById(R.id.yi_hu);
    }

    /**
     * ViewPropertyAnimator
     * 使用方式：View.animate() 后跟 translationX() 等方法，动画会自动执行。
     * View 的每个方法都对应了 ViewPropertyAnimator 的两个方法，其中一个是带有 -By 后缀的，例如，
     * View.setTranslationX() 对应了 ViewPropertyAnimator.translationX() 和
     * ViewPropertyAnimator.translationXBy() 这两个方法。其中带有 -By() 后缀的是增量版本的方法，
     * 例如，translationX(100) 表示用动画把 View 的 translationX 值渐变为 100，而 translationXBy(100)
     * 则表示用动画把 View 的 translationX 值渐变地增加 100
     */
    public void startAnim() {
        // 沿 x 轴方向移动 600 个像素
        mYiHu.animate().translationX(500);
    }

    /**
     * 通用功能
     * 1. setDuration(int duration) 设置动画时长
     * 单位是毫秒。
     */
    public void animSetDuration() {
        // 沿 x 轴方向移动 600 个像素
        mYiHu.animate()
                .translationX(500)
                .setDuration(500); // 设置动画时长为 500 ms
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
        CycleInterpolator cycleInterpolator = new CycleInterpolator(2f);

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

        mYiHu.animate()
                .translationX(500)
                .setDuration(1000)
                .setInterpolator(linearOutSlowInInterpolator);
    }

    /**
     * 3. 设置监听器
     * 给动画设置监听器，可以在关键时刻得到反馈，从而及时做出合适的操作，例如在动画的属性更新时同步更新
     * 其他数据，或者在动画结束后回收资源等。
     *
     * 设置监听器的方法， ViewPropertyAnimator 和 ObjectAnimator 略微不一样： ViewPropertyAnimator
     * 用的是 setListener() 和 setUpdateListener() 方法，可以设置一个监听器，要移除监听器时通过
     * set[Update]Listener(null) 填 null 值来移除；而 ObjectAnimator 则是用 addListener() 和
     * addUpdateListener() 来添加一个或多个监听器，移除监听器则是通过 remove[Update]Listener()
     * 来指定移除对象。
     *
     * 另外，由于 ObjectAnimator 支持使用 pause() 方法暂停，所以它还多了一个
     * addPauseListener() / removePauseListener() 的支持；而 ViewPropertyAnimator 则独有
     * withStartAction() 和 withEndAction() 方法，可以设置一次性的动画开始或结束的监听。
     *
     * 3.1 ViewPropertyAnimator.setListener() / ObjectAnimator.addListener()
     * 这两个方法的名称不一样，可以设置的监听器数量也不一样，但它们的参数类型都是 AnimatorListener，
     * 所以本质上其实都是一样的。 AnimatorListener 共有 4 个回调方法：
     *
     * 3.1.1 onAnimationStart(Animator animation)
     * 当动画开始执行时，这个方法被调用。
     *
     * 3.1.2 onAnimationEnd(Animator animation)
     * 当动画结束时，这个方法被调用。
     *
     * 3.1.3 onAnimationCancel(Animator animation)
     * 当动画被通过 cancel() 方法取消时，这个方法被调用。
     *
     * 需要说明一下的是，就算动画被取消，onAnimationEnd() 也会被调用。所以当动画被取消时，如果设置了
     * AnimatorListener，那么 onAnimationCancel() 和 onAnimationEnd() 都会被调用。onAnimationCancel()
     * 会先于 onAnimationEnd() 被调用。
     *
     * 3.1.4 onAnimationRepeat(Animator animation)
     * 当动画通过 setRepeatMode() / setRepeatCount() 或 repeat() 方法重复执行时，这个方法被调用。
     *
     * 由于 ViewPropertyAnimator 不支持重复，所以这个方法对 ViewPropertyAnimator 相当于无效。
     *
     * 3.2 ViewPropertyAnimator.setUpdateListener() / ObjectAnimator.addUpdateListener()
     * 和上面 3.1 的两个方法一样，这两个方法虽然名称和可设置的监听器数量不一样，但本质其实都一样的，
     * 它们的参数都是 AnimatorUpdateListener。它只有一个回调方法：onAnimationUpdate(ValueAnimator animation)。
     *
     * 3.2.1 onAnimationUpdate(ValueAnimator animation)
     * 当动画的属性更新时（不严谨的说，即每过 10 毫秒，动画的完成度更新时），这个方法被调用。
     *
     * 方法的参数是一个 ValueAnimator，ValueAnimator 是 ObjectAnimator 的父类，也是
     * ViewPropertyAnimator 的内部实现，所以这个参数其实就是 ViewPropertyAnimator 内部的那个
     * ValueAnimator，或者对于 ObjectAnimator 来说就是它自己本身。
     *
     * ValueAnimator 有很多方法可以用，它可以查看当前的动画完成度、当前的属性值等等。
     *
     * 3.3 ObjectAnimator.addPauseListener()
     *
     * 3.3 ViewPropertyAnimator.withStartAction/EndAction()
     * 这两个方法是 ViewPropertyAnimator 的独有方法。它们和 set/addListener() 中回调的
     * onAnimationStart() / onAnimationEnd() 相比起来的不同主要有两点：
     *
     * withStartAction() / withEndAction() 是一次性的，在动画执行结束后就自动弃掉了，就算之后再重用
     * ViewPropertyAnimator 来做别的动画，用它们设置的回调也不会再被调用。而 set/addListener()
     * 所设置的 AnimatorListener 是持续有效的，当动画重复执行时，回调总会被调用。
     * withEndAction() 设置的回调只有在动画正常结束时才会被调用，而在动画被取消时不会被执行。这点和
     * AnimatorListener.onAnimationEnd() 的行为是不一致的。
     */
}
