package com.example.basiccustomview.customview.customview2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ComposeShader;
import android.graphics.DashPathEffect;
import android.graphics.EmbossMaskFilter;
import android.graphics.LightingColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.basiccustomview.R;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/11/12 19:50
 *
 *  Paint 的属性设置
 **/
public class CustomView2 extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path mPath = new Path();

    public CustomView2(Context context) {
        this(context, null);
    }

    public CustomView2(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 1 颜色
        // 1.1 基本颜色
        // 1.1.1 直接设置颜色
        // 1.1.1.1 setColor(int color)
        // mPaint.setColor(Color.parseColor("#009688"));
        // canvas.drawRect(30, 30, 230, 180, mPaint);
        //
        // mPaint.setColor(Color.parseColor("#FF9800"));
        // mPaint.setStrokeWidth(20);
        // canvas.drawLine(300, 30, 450, 180, mPaint);
        //
        // mPaint.setColor(Color.parseColor("#E91E63"));
        // mPaint.setTextSize(60);
        // canvas.drawText("海贼王", 500, 130, mPaint);

        /**
         * 1.1.1.2 setARGB(int a, int r, int g, int b)
         * 其实和 setColor(color) 都是一样一样儿的，只是它的参数用的是更直接的三原色与透明度的值
         */
        // mPaint.setARGB(100, 255, 0, 0);
        // canvas.drawRect(0, 0, 200, 200, mPaint);
        // mPaint.setARGB(100, 0, 0, 0);
        // canvas.drawLine(0, 0, 200, 200, mPaint);

        /**
         * 1.1.2 setShader(Shader shader) 设置 Shader
         * 除了直接设置颜色， Paint 还可以使用 Shader 。
         *
         * Shader 这个英文单词很多人没有见过，它的中文叫做「着色器」，也是用于设置绘制颜色的
         * 它和直接设置颜色的区别是，着色器设置的是一个颜色方案，或者说是一套着色规则。当设置了 Shader
         * 之后，Paint 在绘制图形和文字时就不使用 setColor/ARGB() 设置的颜色了，
         * 而是使用 Shader 的方案中的颜色。
         * 在 Android 的绘制里使用 Shader ，并不直接用 Shader 这个类，而是用它的几个子类。
         * 具体来讲有 LinearGradient RadialGradient SweepGradient BitmapShader ComposeShader 这么几个：
         */
        /**
         * 1.1.2.1 LinearGradient 线性渐变
         * 设置两个点和两种颜色，以这两个点作为端点，使用两种颜色的渐变来绘制颜色。
         * LinearGradient(float x0, float y0, float x1, float y1, int color0, int color1,
         * Shader.TileMode tile)
         * x0 y0 x1 y1：渐变的两个端点的位置
         * color0 color1 是端点的颜色
         * tile：端点范围之外的着色规则，类型是 TileMode。TileMode 一共有 3 个值可选：
         * CLAMP, MIRROR 和 REPEAT。CLAMP 会在端点之外延续端点处的颜色；
         * MIRROR 是镜像模式；REPEAT 是重复模式
         */
        // Shader shader = new LinearGradient(100, 100, 500, 500, Color.parseColor("#E91E63"),
        //         Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);
        // mPaint.setShader(shader);
        // canvas.drawCircle(300, 300, 200, mPaint);

        /**
         * 1.1.2.2 RadialGradient 辐射渐变
         * 辐射渐变很好理解，就是从中心向周围辐射状的渐变
         * 构造方法：
         * RadialGradient(float centerX, float centerY, float radius, int centerColor,
         * int edgeColor, TileMode tileMode)。
         * 参数：
         * centerX centerY：辐射中心的坐标
         * radius：辐射半径
         * centerColor：辐射中心的颜色
         * edgeColor：辐射边缘的颜色
         * tileMode：辐射范围之外的着色模式。
         */
        // Shader shader = new RadialGradient(300, 300, 200, Color.parseColor("#E91E63"),
        //         Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);
        // mPaint.setShader(shader);
        // canvas.drawCircle(300, 300, 200, mPaint);

        /**
         * 1.1.2.3 SweepGradient 扫描渐变
         * 构造方法：
         * SweepGradient(float cx, float cy, int color0, int color1)
         * 参数：
         * cx cy ：扫描的中心
         * color0：扫描的起始颜色
         * color1：扫描的终止颜色
         */
        // Shader shader = new SweepGradient(300, 300, Color.parseColor("#E91E63"),
        //         Color.parseColor("#2196F3"));
        // mPaint.setShader(shader);
        // canvas.drawCircle(300, 300, 200, mPaint);

        /**
         * 1.1.2.4 BitmapShader
         * 用 Bitmap 来着色。其实也就是用 Bitmap 的像素来作为图形或文字的填充
         * 如果你想绘制圆形的 Bitmap，就别用 drawBitmap() 了，改用 drawCircle() + BitmapShader 就可以了（其他形状同理）
         * 构造方法：
         * BitmapShader(Bitmap bitmap, Shader.TileMode tileX, Shader.TileMode tileY)
         * 参数：
         * bitmap：用来做模板的 Bitmap 对象
         * tileX：横向的 TileMode
         * tileY：纵向的 TileMode。
         */
        // Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.yihu);
        // Shader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        // mPaint.setShader(shader);
        // canvas.drawCircle(500, 300, 200, mPaint);

        /**
         * 1.1.2.5 ComposeShader 混合着色器
         * 所谓混合，就是把两个 Shader 一起使用
         * ComposeShader() 在硬件加速下是不支持两个相同类型的 Shader 的，
         * 所以这里也需要关闭硬件加速才能看到效果
         * 构造方法：ComposeShader(Shader shaderA, Shader shaderB, PorterDuff.Mode mode)
         * 参数：
         * shaderA, shaderB：两个相继使用的 Shader
         * mode: 两个 Shader 的叠加模式，即 shaderA 和 shaderB 应该怎样共同绘制。它的类型是 PorterDuff.Mode
         */
        // 第一个 Shader：头像的 Bitmap
        // Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.mipmap.yihu2);
        // Shader shader1 = new BitmapShader(bitmap1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

        // 第二个 Shader：从上到下的线性渐变（由透明到黑色）
        // Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.mipmap.cup);
        // Shader shader2 = new BitmapShader(bitmap2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

        // ComposeShader：结合两个 Shader
        // Shader shader = new ComposeShader(shader1, shader2, PorterDuff.Mode.SRC_OVER);
        // mPaint.setShader(shader);
        // canvas.drawCircle(300, 300, 300, mPaint);

        /**
         * 1.2 setColorFilter(ColorFilter colorFilter)
         * ColorFilter 这个类，：为绘制设置颜色过滤。颜色过滤的意思，就是为绘制的内容设置一个统一
         * 的过滤策略，然后 Canvas.drawXXX() 方法会对每个像素都进行过滤后再绘制出来
         * 在 Paint 里设置 ColorFilter ，使用的是 Paint.setColorFilter(ColorFilter filter) 方法。
         * ColorFilter 并不直接使用，而是使用它的子类。它共有三个子类：
         * LightingColorFilter PorterDuffColorFilter 和 ColorMatrixColorFilter
         * 这个 LightingColorFilter 是用来模拟简单的光照效果的。
         *
         * LightingColorFilter 的构造方法是
         * LightingColorFilter(int mul, int add) ，参数里的 mul 和 add 都是和颜色值格式相同的 int 值，
         * 其中 mul 用来和目标像素相乘，add 用来和目标像素相加：
         * R' = R * mul.R / 0xff + add.R
         * G' = G * mul.G / 0xff + add.G
         * B' = B * mul.B / 0xff + add.B
         *
         * 一个「保持原样」的「基本 LightingColorFilter 」，mul 为 0xffffff，
         * add 为 0x000000（也就是0），那么对于一个像素，它的计算过程就是：
         * R' = R * 0xff / 0xff + 0x0 = R // R' = R
         * G' = G * 0xff / 0xff + 0x0 = G // G' = G
         * B' = B * 0xff / 0xff + 0x0 = B // B' = B
         *
         * 基于这个「基本 LightingColorFilter 」，你就可以修改一下做出其他的 filter。
         * 比如，如果你想去掉原像素中的红色，可以把它的 mul 改为 0x00ffff （红色部分为 0 ） ，
         * 那么它的计算过程就是：
         * R' = R * 0x0 / 0xff + 0x0 = 0 // 红色被移除
         * G' = G * 0xff / 0xff + 0x0 = G
         * B' = B * 0xff / 0xff + 0x0 = B
         * 具体效果是这样的：
         */
        // 去除图片的红色部分(R)
        // ColorFilter lightingColorFilter = new LightingColorFilter(0x00ffff, 0x000000);
        // mPaint.setColorFilter(lightingColorFilter);
        // Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.jinshang);
        // canvas.drawBitmap(bitmap, 0, 0, mPaint);

        /**
         * 1.2.2 PorterDuffColorFilter
         * 这个 PorterDuffColorFilter 的作用是使用一个指定的颜色和一种指定的 PorterDuff.Mode
         * 来与绘制对象进行合成。它的构造方法是 PorterDuffColorFilter(int color, PorterDuff.
         * Mode mode) 其中的 color 参数是指定的颜色， mode 参数是指定的 Mode。
         * 同样也是 PorterDuff.Mode ，不过和 ComposeShader 不同的是，PorterDuffColorFilter
         * 作为一个 ColorFilter，只能指定一种颜色作为源，而不是一个 Bitmap
         */

        /**
         * 1.2.3 ColorMatrixColorFilter
         * ColorMatrixColorFilter 使用一个 ColorMatrix 来对颜色进行处理。 ColorMatrix 这个类，
         * 内部是一个 4x5 的矩阵
         * [ a, b, c, d, e,
         *   f, g, h, i, j,
         *   k, l, m, n, o,
         *   p, q, r, s, t ]
         * 通过计算， ColorMatrix 可以把要绘制的像素进行转换。对于颜色 [R, G, B, A] ，转换算法是这样的：
         * R’ = a*R + b*G + c*B + d*A + e;
         * G’ = f*R + g*G + h*B + i*A + j;
         * B’ = k*R + l*G + m*B + n*A + o;
         * A’ = p*R + q*G + r*B + s*A + t;
         * ColorMatrix 有一些自带的方法可以做简单的转换，例如可以使用 setSaturation(float sat)
         * 来设置饱和度；另外你也可以自己去设置它的每一个元素来对转换效果做精细调整
         * 有需求，可以试一下程大治同学做的这个库：StyleImageView
         */

        /**
         * 1.3 setXfermode(Xfermode xfermode)
         * Xfermode 指的是你要绘制的内容和 Canvas 的目标位置的内容应该怎样结合计算出最终的颜色。
         * 但通俗地说，其实就是要你以绘制的内容作为源图像，以 View 中已有的内容作为目标图像，
         * 选取一个 PorterDuff.Mode 作为绘制内容的颜色处理方案。就像这样：
         * Xfermode xfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
         * canvas.drawBitmap(rectBitmap, 0, 0, paint); // 画方
         * paint.setXfermode(xfermode); // 设置 Xfermode
         * canvas.drawBitmap(circleBitmap, 0, 0, paint); // 画圆
         * paint.setXfermode(null); // 用完及时清除 Xfermode
         * 创建 Xfermode 的时候其实是创建的它的子类 PorterDuffXfermode。而事实上，Xfermode
         * 也只有这一个子类。所以在设置 Xfermode 的时候不用多想，直接用 PorterDuffXfermode 吧
         *
         * Xfermode 注意事项
         * 1. 使用离屏缓冲（Off-screen Buffer）
         * 通过使用离屏缓冲，把要绘制的内容单独绘制在缓冲层， Xfermode 的使用就不会出现奇怪的结果了。
         * 使用离屏缓冲有两种方式：
         * Canvas.saveLayer()
         * saveLayer() 可以做短时的离屏缓冲。使用方法很简单，在绘制代码的前后各加一行代码，
         * 在绘制之前保存，绘制之后恢复：
         * int saved = canvas.saveLayer(null, null, Canvas.ALL_SAVE_FLAG);
         * canvas.drawBitmap(rectBitmap, 0, 0, paint); // 画方
         * paint.setXfermode(xfermode); // 设置 Xfermode
         * canvas.drawBitmap(circleBitmap, 0, 0, paint); // 画圆
         * paint.setXfermode(null); // 用完及时清除 Xfermode
         * canvas.restoreToCount(saved);
         */
        // int saved = canvas.saveLayer(null, null, Canvas.ALL_SAVE_FLAG);
        // Bitmap bitmapRect = BitmapFactory.decodeResource(getResources(), R.mipmap.rect);
        // Bitmap bitmapCircle = BitmapFactory.decodeResource(getResources(), R.mipmap.circle);
        // Xfermode xfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        // canvas.drawBitmap(bitmapRect, 0, 0, mPaint); // 画方
        // mPaint.setXfermode(xfermode); // 设置 Xfermode
        // canvas.drawBitmap(bitmapCircle, 0, 0, mPaint); // 画圆
        // mPaint.setXfermode(null); // 用完及时清除 Xfermode
        // canvas.restoreToCount(saved);

        /**
         * 2 效果
         * 效果类的 API ，指的就是抗锯齿、填充/轮廓、线条宽度等等这些。
         * 2.1 setAntiAlias (boolean aa) 设置抗锯齿
         * 抗锯齿默认是关闭的，如果需要抗锯齿，需要显式地打开。另外，除了 setAntiAlias(aa) 方法，
         * 打开抗锯齿还有一个更方便的方式：构造方法。创建 Paint 对象的时候，构造方法的参数里加一个
         * ANTI_ALIAS_FLAG 的 flag，就可以在初始化的时候就开启抗锯齿。
         * Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
         *
         * 2.2 setStyle(Paint.Style style)
         */

        /**
         * 2.3 线条形状
         * 设置线条形状的一共有 4 个方法：setStrokeWidth(float width), setStrokeCap(Paint.Cap cap),
         * setStrokeJoin(Paint.Join join), setStrokeMiter(float miter)
         */

        /**
         * 2.3.1 setStrokeWidth(float width)
         * 设置线条宽度。单位为像素，默认值是 0。
         * 当线条宽度被设置为 0 时，它的宽度就被固定为 1 像素，就算 Canvas 通过几何变换被放大，
         * 它也依然会被以 1 像素宽度来绘制
         */
        // mPaint.setStyle(Paint.Style.STROKE);
        // mPaint.setStrokeWidth(1);
        // canvas.drawCircle(150, 125, 100, mPaint);
        // mPaint.setStrokeWidth(5);
        // canvas.drawCircle(400, 125, 100, mPaint);
        // mPaint.setStrokeWidth(40);
        // canvas.drawCircle(650, 125, 100, mPaint);

        /**
         * 2.3.2 setStrokeCap(Paint.Cap cap)
         * 设置线头的形状。线头形状有三种：BUTT 平头、ROUND 圆头、SQUARE 方头。默认为 BUTT。
         * 当线条的宽度是 1 像素时，这三种线头的表现是完全一致的，全是 1 个像素的点；
         * 而当线条变粗的时候，它们就会表现出不同的样子：
         *
         * 2.3.3 setStrokeJoin(Paint.Join join)
         * 设置拐角的形状。有三个值可以选择：MITER 尖角、 BEVEL 平角和 ROUND 圆角。默认为 MITER
         *
         * 2.3.4 setStrokeMiter(float miter)
         * 这个方法是对于 setStrokeJoin() 的一个补充，它用于设置 MITER 型拐角的延长线的最大值
         *
         */

        /**
         * 2.4 色彩优化
         * Paint 的色彩优化有两个方法： setDither(boolean dither) 和 setFilterBitmap(boolean filter)
         * 它们的作用都是让画面颜色变得更加「顺眼」，但原理和使用场景是不同的
         *
         * 2.4.1 setDither(boolean dither)
         * 设置图像的抖动
         * paint.setDither(true);
         *
         * 2.4.2 setFilterBitmap(boolean filter)
         * 设置是否使用双线性过滤来绘制 Bitmap 。
         * 图像在放大绘制的时候，默认使用的是最近邻插值过滤，这种算法简单，但会出现马赛克现象；
         * 而如果开启了双线性过滤，就可以让结果图像显得更加平滑
         * paint.setFilterBitmap(true);
         * 加上这一行，在放大绘制 Bitmap 的时候就会使用双线性过滤了。
         */

        /**
         * 2.5 setPathEffect(PathEffect effect)
         * 使用 PathEffect 来给图形的轮廓设置效果。对 Canvas 所有的图形绘制有效，
         * 也就是 drawLine() drawCircle() drawPath() 这些方法
         */

        /**
         * 2.5.1 CornerPathEffect
         * 把所有拐角变成圆角
         */

        /**
         * 2.6 setShadowLayer(float radius, float dx, float dy, int shadowColor)
         * 在之后的绘制内容下面加一层阴影
         * 方法的参数里， radius 是阴影的模糊范围； dx dy 是阴影的偏移量； shadowColor 是阴影的颜色。
         * 如果要清除阴影层，使用 clearShadowLayer() 。
         *
         * 注意：
         * 在硬件加速开启的情况下， setShadowLayer() 只支持文字的绘制，
         * 文字之外的绘制必须关闭硬件加速才能正常绘制阴影。
         * 如果 shadowColor 是半透明的，阴影的透明度就使用 shadowColor 自己的透明度；
         * 而如果 shadowColor 是不透明的，阴影的透明度就使用 paint 的透明度。
         */
        // mPaint.setShadowLayer(10, 0, 0, Color.RED);
        // mPaint.setTextSize(100);
        // canvas.drawText("海贼王", 80, 300, mPaint);

        /**
         * 2.7 setMaskFilter(MaskFilter maskfilter)
         * 为之后的绘制设置 MaskFilter。上一个方法 setShadowLayer() 是设置的在绘制层下方的附加效果；
         * 而这个 MaskFilter 和它相反，设置的是在绘制层上方的附加效果
         * MaskFilter 有两种： BlurMaskFilter 和 EmbossMaskFilter
         */

        /**
         * 2.7.1 BlurMaskFilter
         * 模糊效果的 MaskFilter
         * 它的构造方法 BlurMaskFilter(float radius, BlurMaskFilter.Blur style) 中，
         * radius 参数是模糊的范围， style 是模糊的类型。一共有四种：
         * NORMAL: 内外都模糊绘制
         * SOLID: 内部正常绘制，外部模糊
         * INNER: 内部模糊，外部不绘制
         * OUTER: 内部不绘制，外部模糊
         */
        // Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.yihu2);
        // // 原图
        // canvas.drawBitmap(bitmap, 0, 0, mPaint);
        // mPaint.setMaskFilter(new BlurMaskFilter(150, BlurMaskFilter.Blur.INNER));
        // // 模糊后的图
        // canvas.drawBitmap(bitmap, 0, 900, mPaint);

        /**
         * 2.7.2 EmbossMaskFilter
         * 浮雕效果的 MaskFilter
         * 它的构造方法 EmbossMaskFilter(float[] direction, float ambient, float specular,
         * float blurRadius) 的参数里， direction 是一个 3 个元素的数组，指定了光源的方向；
         * ambient 是环境光的强度，数值范围是 0 到 1； specular 是炫光的系数；
         * blurRadius 是应用光线的范围
         */
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.yihu2);
        // 原图
        canvas.drawBitmap(bitmap, 0, 0, mPaint);
        mPaint.setMaskFilter(new EmbossMaskFilter(new float[]{0, 1, 1}, 0.2f, 8, 10));
        // 模糊后的图
        canvas.drawBitmap(bitmap, 0, 900, mPaint);

        /**
         * 2.8 获取绘制的 Path
         * 这是效果类的最后一组方法，也是效果类唯一的一组 get 方法。
         * 这组方法做的事是，根据 paint 的设置，计算出绘制 Path 或文字时的实际 Path。
         */

        /**
         * 2.8.1 getFillPath(Path src, Path dst)
         * 首先解答第一个问题：「实际 Path」。所谓实际 Path ，指的就是 drawPath() 的绘制内容的轮廓，
         * 要算上线条宽度和设置的 PathEffect。
         *
         * 默认情况下（线条宽度为 0、没有 PathEffect），原 Path 和实际 Path 是一样的；而在线条宽度不为
         * 0 （并且模式为 STROKE 模式或 FLL_AND_STROKE ），或者设置了 PathEffect 的时候，
         * 实际 Path 就和原 Path 不一样了：
         */

        /**
         * 2.8.2 getTextPath(String text, int start, int end, float x, float y, Path path)
         * getTextPath(char[] text, int index, int count, float x, float y, Path path)
         *
         * 「文字的 Path」。文字的绘制，虽然是使用 Canvas.drawText() 方法，但其实在下层，
         * 文字信息全是被转化成图形，对图形进行绘制的。 getTextPath() 方法，
         * 获取的就是目标文字所对应的 Path 。这个就是所谓「文字的 Path」。
         */

        /**
         * 4 初始化类
         *
         * 4.1 reset()
         * 重置 Paint 的所有属性为默认值。相当于重新 new 一个，不过性能当然高一些
         *
         * 4.2 set(Paint src)
         * 把 src 的所有属性全部复制过来。相当于调用 src 所有的 get 方法，然后调用这个 Paint
         * 的对应的 set 方法来设置它们
         *
         * 4.3 setFlags(int flags)
         * 批量设置 flags。相当于依次调用它们的 set 方法。例如
         * paint.setFlags(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
         * 这行代码，和下面这两行是等价的：
         * paint.setAntiAlias(true);
         * paint.setDither(true);
         */
    }
}
