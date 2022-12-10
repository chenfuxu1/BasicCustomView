package com.example.basiccustomview.customview.customview1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
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
 * Canvas.drawXXX() 和 Paint 基础
 *      drawXXX() 系列方法和 Paint 的基础掌握了，就能够应付简单的绘制需求。它们主要包括：
 *      Canvas 类下的所有 draw- 打头的方法，例如 drawCircle() drawBitmap()。
 * Paint 类的几个最常用的方法。具体是：
 *      Paint.setStyle(Style style) 设置绘制模式
 *      Paint.setColor(int color) 设置颜色
 *      Paint.setStrokeWidth(float width) 设置线条宽度
 *      Paint.setTextSize(float textSize) 设置文字大小
 *      Paint.setAntiAlias(boolean aa) 设置抗锯齿开关
 **/
public class CustomView1 extends View {
    private Paint mPaint = new Paint();
    private Path mPath = new Path();

    public CustomView1(Context context) {
        this(context, null);
    }

    public CustomView1(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomView1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStrokeWidth(20);

        // 绘制一个圆
        // canvas.drawCircle(300, 300, 200, mPaint);
        // canvas.drawColor(Color.parseColor("#88880000")); // 半透明红色
        /**
         * 类似的方法还有
         * drawRGB(int r, int g, int b) 和
         * drawARGB(int a, int r, int g, int b)
         * 它们和 drawColor(color) 只是使用方式不同，作用都是一样的
         * canvas.drawRGB(100, 200, 100);
         * canvas.drawARGB(100, 100, 200, 100);
         * 这类颜色填充方法一般用于在绘制之前设置底色，或者在绘制之后为界面设置半透明蒙版
         */

        /**
         * drawCircle(float centerX, float centerY, float radius, Paint paint) 画圆
         * 前两个参数 centerX centerY 是圆心的坐标，
         * 第三个参数 radius 是圆的半径，单位都是像素，
         * 它们共同构成了这个圆的基本信息（即用这几个信息可以构建出一个确定的圆）；
         * 第四个参数 paint ，它提供基本信息之外的所有风格信息，例如颜色、线条粗细、阴影等。
         *
         * 插播一： Paint.setColor(int color)
         * Paint.setColor(int color) 是 Paint 最常用的方法之一，用来设置绘制内容的颜色。
         * 你不止可以用它画红色的圆，也可以用它来画红色的矩形、红色的五角星、红色的文字
         *
         * 插播二： Paint.setStyle(Paint.Style style)
         * 如果你想画的不是实心圆，而是空心圆（或者叫环形），也可以使用
         * paint.setStyle(Paint.Style.STROKE) 来把绘制模式改为画线模式。
         *
         * 插播三： Paint.setStrokeWidth(float width)
         * 在 STROKE 和 FILL_AND_STROKE 下，还可以使用 paint.setStrokeWidth(float width) 来设置线条的宽度：
         *
         * 插播四： 抗锯齿
         * 在绘制的时候，往往需要开启抗锯齿来让图形和文字的边缘更加平滑。开启抗锯齿很简单，
         * 只要在 new Paint() 的时候加上一个 ANTI_ALIAS_FLAG 参数就行
         * Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
         * 或者：你也可以使用 Paint.setAntiAlias(boolean aa) 来动态开关抗锯齿
         */
        // mPaint.setColor(Color.RED); // 设置为红色
        /**
         * setStyle(Style style) 这个方法设置的是绘制的 Style 。Style 具体来说有三种：
         * FILL, STROKE 和 FILL_AND_STROKE 。FILL 是填充模式，STROKE 是画线模式（即勾边模式），
         * FILL_AND_STROKE 是两种模式一并使用：既画线又填充。它的默认值是 FILL，填充模式。
         */
        // mPaint.setStyle(Paint.Style.STROKE); // Style 修改为画线模式
        // mPaint.setStrokeWidth(20); // 线条宽度为 20 像素
        // mPaint.setAntiAlias(true); // 打开抗锯齿
        // canvas.drawCircle(300, 300, 200, mPaint);

        /**
         * drawRect(float left, float top, float right, float bottom, Paint paint) 画矩形
         * left, top, right, bottom 是矩形四条边的坐标
         * 它还有两个重载方法 drawRect(RectF rect, Paint paint) 和 drawRect(Rect rect, Paint paint) ，
         * 让你可以直接填写 RectF 或 Rect 对象来绘制矩形
         */
        // mPaint.setStyle(Paint.Style.FILL);
        // canvas.drawRect(100, 100, 400, 400, mPaint);
        // mPaint.setStyle(Paint.Style.STROKE);
        // canvas.drawRect(600, 100, 900, 400, mPaint);

        /**
         * drawPoint(float x, float y, Paint paint) 画点
         * x 和 y 是点的坐标。点的大小可以通过 paint.setStrokeWidth(width) 来设置；点的形状可以通过
         * paint.setStrokeCap(cap) 来设置：ROUND 画出来是圆形的点，SQUARE 或 BUTT 画出来是方形的点。
         * （点还有形状？是的）
         * 注：Paint.setStrokeCap(cap) 可以设置点的形状，但这个方法并不是专门用来设置点的形状的，
         * 而是一个设置线条端点形状的方法。端点有圆头 (ROUND)、平头 (BUTT) 和方头 (SQUARE) 三种
         * 好像有点像 FILL 模式下的 drawCircle() 和 drawRect() ？事实上确实是这样的，
         * 它们和 drawPoint() 的绘制效果没有区别。各位在使用的时候按个人习惯和实际场景来吧，
         * 哪个方便和顺手用哪个
         */
        // mPaint.setStrokeWidth(20);
        // mPaint.setStrokeCap(Paint.Cap.ROUND); // 圆形点
        // canvas.drawPoint(50, 50, mPaint);
        // // 设置方形点
        // mPaint.setStrokeCap(Paint.Cap.SQUARE);
        // canvas.drawPoint(200, 50, mPaint);

        /**
         * drawPoints(float[] pts, int offset, int count, Paint paint) /
         * drawPoints(float[] pts, Paint paint) 画点（批量）
         * 同样是画点，它和 drawPoint() 的区别是可以画多个点。pts 这个数组是点的坐标，
         * 每两个成一对；offset 表示跳过数组的前几个数再开始记坐标；count 表示一共要绘制几个点
         */
        // mPaint.setStrokeWidth(20);
        // float[] points = {0, 0, 50, 50, 50, 100, 100, 50, 100, 100, 150, 50, 150, 100};
        // // 绘制四个点：(50, 50) (50, 100) (100, 50) (100, 100)
        // canvas.drawPoints(points, 2 /* 跳过两个数，即前两个 0 */,
        //         8 /* 一共绘制 8 个数（4 个点）*/, mPaint);

        /**
         * drawOval(float left, float top, float right, float bottom, Paint paint) 画椭圆
         * 只能绘制横着的或者竖着的椭圆，不能绘制斜的（斜的倒是也可以，但不是直接使用 drawOval()，
         * 而是配合几何变换，）。left, top, right, bottom 是这个椭圆的左、上、右、下四个边界点的坐标。
         * 另外，它还有一个重载方法 drawOval(RectF rect, Paint paint)，让你可以直接填写 RectF 来绘制椭圆
         */
        // mPaint.setStyle(Paint.Style.FILL);
        // canvas.drawOval(50, 50, 350, 200, mPaint);
        // mPaint.setStyle(Paint.Style.STROKE); // 空心椭圆
        // canvas.drawOval(400, 50, 700, 200, mPaint);

        /**
         * drawLine(float startX, float startY, float stopX, float stopY, Paint paint) 画线
         * startX, startY, stopX, stopY 分别是线的起点和终点坐标
         * 由于直线不是封闭图形，所以 setStyle(style) 对直线没有影响
         */
        // mPaint.setStrokeWidth(20);
        // canvas.drawLine(200, 200, 800, 500, mPaint);

        /**
         * drawLines(float[] pts, int offset, int count, Paint paint) /
         * drawLines(float[] pts, Paint paint) 画线（批量）
         * drawLines() 是 drawLine() 的复数版
         */
        // mPaint.setStrokeWidth(20);
        // float[] points = {20, 20, 120, 20, 70, 20, 70, 120, 20, 120, 120, 120, 150, 20, 250, 20,
        //         150, 20, 150, 120, 250, 20, 250, 120, 150, 120, 250, 120};
        // canvas.drawLines(points, mPaint);

        /**
         * drawRoundRect(float left, float top, float right, float bottom, float rx, float ry, Paint paint) 画圆角矩形
         * left, top, right, bottom 是四条边的坐标，rx 和 ry 是圆角的横向半径和纵向半径
         * 另外，它还有一个重载方法 drawRoundRect(RectF rect, float rx, float ry, Paint paint)，
         * 让你可以直接填写 RectF 来绘制圆角矩形
         */
        // canvas.drawRoundRect(100, 100, 500, 300, 50, 50, mPaint);

        /**
         * drawArc(float left, float top, float right, float bottom, float startAngle,
         * float sweepAngle, boolean useCenter, Paint paint) 绘制弧形或扇形
         * drawArc() 是使用一个椭圆来描述弧形的。left, top, right, bottom 描述的是这个弧形所在的椭圆；
         * startAngle 是弧形的起始角度（x 轴的正向，即正右的方向，是 0 度的位置；顺时针为正角度，
         * 逆时针为负角度），sweepAngle 是弧形划过的角度；useCenter 表示是否连接到圆心，
         * 如果不连接到圆心，就是弧形，如果连接到圆心，就是扇形
         */
        // mPaint.setStyle(Paint.Style.FILL); // 填充模式
        // canvas.drawArc(200, 100, 800, 500, -110, 100,
        //         true, mPaint); // 绘制扇形
        // canvas.drawArc(200, 100, 800, 500, 20, 140,
        //         false, mPaint); // 绘制弧形
        // mPaint.setStyle(Paint.Style.STROKE); // 画线模式
        // canvas.drawArc(200, 100, 800, 500, 180, 60,
        //         false, mPaint); // 绘制不封口的弧形

        /**
         * drawPath(Path path, Paint paint) 画自定义图形
         * 前面的这些方法，都是绘制某个给定的图形，而 drawPath() 可以绘制自定义图形。
         * 当你要绘制的图形比较特殊，使用前面的那些方法做不到的时候，就可以使用 drawPath() 来绘制
         * drawPath(path) 这个方法是通过描述路径的方式来绘制图形的，它的 path 参数就是用来描述图形路径
         * 的对象。path 的类型是 Path ，使用方法大概像下面这样
         * Path 可以描述直线、二次曲线、三次曲线、圆、椭圆、弧形、矩形、圆角矩形。把这些图形结合起来，
         * 就可以描述出很多复杂的图形
         * Path 有两类方法，一类是直接描述路径的，另一类是辅助的设置或计算
         */
        // 使用 path 对图形进行描述（这段描述代码不必看懂）
        // mPath.addArc(200, 200, 400, 400, -225, 225);
        // mPath.arcTo(400, 200, 600, 400, -180, 225, false);
        // mPath.lineTo(400, 542);
        // canvas.drawPath(mPath, mPaint); // 绘制出 path 描述的图形（心形）

        /**
         * Path 方法第一类：直接描述路径
         * 这一类方法还可以细分为两组：添加子图形和画线（直线或曲线）
         * 第一组： addXxx() ——添加子图形
         * addCircle(float x, float y, float radius, Direction dir) 添加圆
         * x, y, radius 这三个参数是圆的基本信息，最后一个参数 dir 是画圆的路径的方向
         * 路径方向有两种：顺时针 (CW clockwise) 和逆时针 (CCW counter-clockwise) 。对于普通情况，
         * 这个参数填 CW 还是填 CCW 没有影响。它只是在需要填充图形 (Paint.Style 为 FILL 或
         * FILL_AND_STROKE) ，并且图形出现自相交时，用于判断填充范围的
         *
         * path.AddCircle(x, y, radius, dir) + canvas.drawPath(path, paint) 这种写法，和直接使用
         * canvas.drawCircle(x, y, radius, paint) 的效果是一样的，区别只是它的写法更复杂。
         * 所以如果只画一个圆，没必要用 Path，直接用 drawCircle() 就行了。drawPath() 一般是在绘制组合
         * 图形时才会用到的。
         * 其他的 Path.add-() 方法和这类似，例如：
         * addOval(float left, float top, float right, float bottom, Direction dir)
         * addOval(RectF oval, Direction dir) 添加椭圆
         * addRect(float left, float top, float right, float bottom, Direction dir)
         * addRect(RectF rect, Direction dir) 添加矩形
         * addRoundRect(RectF rect, float rx, float ry, Direction dir)
         * addRoundRect(float left, float top, float right, float bottom, float rx, float ry, Direction dir)
         * addRoundRect(RectF rect, float[] radii, Direction dir)
         * addRoundRect(float left, float top, float right, float bottom, float[] radii, Direction dir) 添加圆角矩形
         * addPath(Path path) 添加另一个 Path
         */
        // mPath.addCircle(300, 300, 200, Path.Direction.CW);
        // canvas.drawPath(mPath, mPaint);

        /**
         * 第二组：xxxTo() ——画线（直线或曲线）
         * 这一组和第一组 addXxx() 方法的区别在于，第一组是添加的完整封闭图形（除了 addPath() ）
         * 而这一组添加的只是一条线
         * lineTo(float x, float y) / rLineTo(float x, float y) 画直线
         * 从当前位置向目标位置画一条直线， x 和 y 是目标位置的坐标。这两个方法的区别是，
         * lineTo(x, y) 的参数是绝对坐标，而
         * rLineTo(x, y) 的参数是相对当前位置的相对坐标 （前缀 r 指的就是 relatively 「相对地」)
         * 当前位置：所谓当前位置，即最后一次调用画 Path 的方法的终点位置。初始值为原点 (0, 0)
         *
         * quadTo(float x1, float y1, float x2, float y2) / rQuadTo(float dx1, float dy1, float dx2, float dy2) 画二次贝塞尔曲线
         * 这条二次贝塞尔曲线的起点就是当前位置，而参数中的 x1, y1 和 x2, y2
         * 则分别是控制点和终点的坐标。和 rLineTo(x, y) 同理，rQuadTo(dx1, dy1, dx2, dy2)
         * 的参数也是相对坐标
         *
         * cubicTo(float x1, float y1, float x2, float y2, float x3, float y3)
         * rCubicTo(float x1, float y1, float x2, float y2, float x3, float y3) 画三次贝塞尔曲线
         * 和上面这个 quadTo() rQuadTo() 的二次贝塞尔曲线同理，cubicTo() 和 rCubicTo() 是三次贝塞尔曲线
         *
         * moveTo(float x, float y) / rMoveTo(float x, float y) 移动到目标位置
         * 不论是直线还是贝塞尔曲线，都是以当前位置作为起点，而不能指定起点。但你可以通过 moveTo(x, y)
         * 或 rMoveTo() 来改变当前位置，从而间接地设置这些方法的起点
         *
         * moveTo(x, y) 虽然不添加图形，但它会设置图形的起点，所以它是非常重要的一个辅助方法。
         * 另外，第二组还有两个特殊的方法： arcTo() 和 addArc()。它们也是用来画线的
         * 但并不使用当前位置作为弧线的起点。
         * arcTo(RectF oval, float startAngle, float sweepAngle, boolean forceMoveTo)
         * arcTo(float left, float top, float right, float bottom, float startAngle,
         * float sweepAngle, boolean forceMoveTo)
         * arcTo(RectF oval, float startAngle, float sweepAngle) 画弧形
         * 这个方法和 Canvas.drawArc() 比起来，少了一个参数 useCenter，而多了一个参数 forceMoveTo
         * 少了 useCenter ，是因为 arcTo() 只用来画弧形而不画扇形，所以不再需要 useCenter 参数
         * 而多出来的这个 forceMoveTo 参数的意思是，绘制是要「抬一下笔移动过去」，还是「直接拖着笔过去」
         * 区别在于是否留下移动的痕迹
         *
         * addArc(float left, float top, float right, float bottom, float startAngle,
         * float sweepAngle)
         * addArc(RectF oval, float startAngle, float sweepAngle)
         * 又是一个弧形的方法。一个叫 arcTo ，一个叫 addArc()，都是弧形，区别在哪里？
         * addArc() 只是一个直接使用了 forceMoveTo = true 的简化版 arcTo()
         *
         */
        // mPaint.setStyle(Paint.Style.STROKE);
        // mPath.lineTo(100, 100); // 由当前位置 (0, 0) 向 (100, 100) 画一条直线
        // mPath.rLineTo(100, 0); // 由当前位置 (100, 100) 向正右方 100 像素的位置画一条直线
        // canvas.drawPath(mPath, mPaint);

        // 位移
        // mPaint.setStyle(Paint.Style.STROKE);
        // mPath.lineTo(100, 100); // 画斜线
        // mPath.moveTo(200, 100); // 位移
        // mPath.lineTo(200, 0); // 画竖线
        // canvas.drawPath(mPath, mPaint);

        // 添加弧形
        // mPaint.setStyle(Paint.Style.STROKE);
        // mPath.lineTo(100, 100);
        // // mPath.arcTo(100, 100, 300, 300, -90,
        // //         90, true); // 强制移动到弧形起点（无痕迹）
        // mPath.arcTo(100, 100, 300, 300, -90,
        //         90, false); // 直接连线连到弧形起点（有痕迹）
        // canvas.drawPath(mPath, mPaint);

        // mPaint.setStyle(Paint.Style.STROKE);
        // mPath.lineTo(100, 100);
        // // 等价于 forceMoveTo = true 的简化版 arcTo()
        // mPath.addArc(100, 100, 300, 300, -90, 90);
        // canvas.drawPath(mPath, mPaint);

        /**
         * close() 封闭当前子图形
         * 它的作用是把当前的子图形封闭，即由当前位置向当前子图形的起点绘制一条直线
         * close() 和 lineTo(起点坐标) 是完全等价的
         */
        // mPaint.setStyle(Paint.Style.STROKE);
        // mPath.moveTo(100, 100);
        // mPath.lineTo(200, 100);
        // mPath.lineTo(150, 150);
        // canvas.drawPath(mPath, mPaint);

        // mPaint.setStyle(Paint.Style.STROKE);
        // mPath.moveTo(100, 100);
        // mPath.lineTo(200, 100);
        // mPath.lineTo(150, 150);
        // mPath.close(); // 使用 close() 封闭子图形。等价于 path.lineTo(100, 100)
        // canvas.drawPath(mPath, mPaint);

        /**
         * 不是所有的子图形都需要使用 close() 来封闭。
         * 当需要填充图形时（即 Paint.Style 为 FILL 或 FILL_AND_STROKE），Path 会自动封闭子图形
         */
        // mPaint.setStyle(Paint.Style.FILL);
        // mPath.moveTo(100, 100);
        // mPath.lineTo(200, 100);
        // mPath.lineTo(150, 150);
        // // 这里只绘制了两条边，但由于 Style 是 FILL ，所以绘制时会自动封口
        // canvas.drawPath(mPath, mPaint);

        /**
         * Path 方法第二类：辅助的设置或计算
         * Path.setFillType(Path.FillType ft) 设置填充方式
         * 是用来设置图形自相交时的填充算法的
         * 方法中填入不同的 FillType 值，就会有不同的填充效果。FillType 的取值有四个：
         * EVEN_ODD 交叉填充
         * WINDING （默认值）全填充
         * INVERSE_EVEN_ODD
         * INVERSE_WINDING
         * 其中后面的两个带有 INVERSE_ 前缀的，只是前两个的反色版本，所以只要把前两个，
         * 即 EVEN_ODD 和 WINDING，搞明白就可以了。
         */

        /**
         * drawBitmap(Bitmap bitmap, float left, float top, Paint paint) 画 Bitmap
         * 绘制 Bitmap 对象，也就是把这个 Bitmap 中的像素内容贴过来。其中 left 和 top 是要把 bitmap
         * 绘制到的位置坐标。
         * 它的重载方法：
         * drawBitmap(Bitmap bitmap, Rect src, RectF dst, Paint paint)
         * drawBitmap(Bitmap bitmap, Rect src, Rect dst, Paint paint)
         * drawBitmap(Bitmap bitmap, Matrix matrix, Paint paint)
         * drawBitmap 还有一个兄弟方法 drawBitmapMesh()，可以绘制具有网格拉伸效果的 Bitmap
         * drawBitmapMesh() 的使用场景较少
         */
        // Bitmap bgBitmap = Bitmap.createBitmap(getWidth(),getHeight(),Bitmap.Config.ARGB_8888); // 创建一个新空白位图
        // canvas.drawBitmap(bgBitmap, 200, 100, mPaint);

        /**
         * drawText(String text, float x, float y, Paint paint) 绘制文字
         * 界面里所有的显示内容，都是绘制出来的，包括文字。 drawText() 这个方法就是用来绘制文字的。
         * 参数 text 是用来绘制的字符串，x 和 y 是绘制的起点坐标。
         * Paint.setTextSize(float textSize)
         * 通过 Paint.setTextSize(textSize)，可以设置文字的大小。
         */
        // mPaint.setTextSize(18);
        // canvas.drawText("海贼王", 100, 25, mPaint);
        // mPaint.setTextSize(36);
        // canvas.drawText("海贼王", 100, 70, mPaint);
        // mPaint.setTextSize(60);
        // canvas.drawText("海贼王", 100, 145, mPaint);
        // mPaint.setTextSize(84);
        // canvas.drawText("海贼王", 100, 240, mPaint);
    }
}
