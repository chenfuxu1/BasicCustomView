package com.example.basiccustomview.customview.customview3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.basiccustomview.R;

import java.util.Locale;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/11/12 19:50
 *
 * 自定义 View 1-3 drawText() 文字的绘制
 **/
public class CustomView3 extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path mPath = new Path();
    private String mText = "人世间，如梦如幻！";

    {
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setTextSize(80);
    }

    public CustomView3(Context context) {
        this(context, null);
    }

    public CustomView3(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomView3(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /**
         * 1 Canvas 绘制文字的方式
         * Canvas 的文字绘制方法有三个：drawText() drawTextRun() 和 drawTextOnPath()
         */

        /**
         * 1.1 drawText(String text, float x, float y, Paint paint)
         * drawText() 是 Canvas 最基本的绘制文字的方法：给出文字的内容和位置， Canvas 按要求去绘制文字
         * text 是文字内容，x 和 y 是文字的坐标。但需要注意：这个坐标并不是文字的左上角，
         * 而是一个与左下角比较接近的位置
         */
        // String text = "Hello World";
        // mPaint.setTextSize(120);
        // canvas.drawText(text, 200, 100, mPaint);

        /**
         * 1.3 drawTextOnPath()
         * 沿着一条 Path 来绘制文字。这是一个耍杂技的方法
         * drawTextOnPath(String text, Path path, float hOffset, float vOffset, Paint paint)
         *
         * 参数里，需要解释的只有两个： hOffset 和 vOffset。它们是文字相对于 Path 的水平偏移量和
         * 竖直偏移量，利用它们可以调整文字的位置。例如你设置 hOffset 为 5， vOffset 为 10，文字
         * 就会右移 5 像素和下移 10 像素。
         */
        // mPath.moveTo(50, 100);
        // mPath.rLineTo(800, 300);
        // mPath.rLineTo(-400, 200);
        // canvas.drawPath(mPath, mPaint); // 把 Path 也绘制出来，理解起来更方便
        // canvas.drawTextOnPath("Hello World", mPath, 0, 0, mPaint);

        /**
         * 1.4 StaticLayout
         * 这个也是使用 Canvas 来进行文字的绘制，不过并不是使用 Canvas 的方法。
         * Canvas.drawText() 只能绘制单行的文字，而不能换行
         * 如果需要绘制多行的文字，你必须自行把文字切断后分多次使用 drawText() 来绘制，
         * 或者——使用 StaticLayout
         *
         * StaticLayout 并不是一个 View 或者 ViewGroup ，而是 android.text.Layout 的子类，它是纯粹用来
         * 绘制文字的。 StaticLayout 支持换行，它既可以为文字设置宽度上限来让文字自动换行，也会在 \n 处主
         * 动换行
         *
         * StaticLayout 的构造方法是 StaticLayout(CharSequence source, TextPaint paint, int width,
         * Layout.Alignment align, float spacingmult, float spacingadd, boolean includepad)，
         * 其中参数里：
         * width 是文字区域的宽度，文字到达这个宽度后就会自动换行；
         * align 是文字的对齐方向；
         * spacingmult 是行间距的倍数，通常情况下填 1 就好；
         * spacingadd 是行间距的额外增加值，通常情况下填 0 就好；
         * includepad 是指是否在文字上下添加额外的空间，来避免某些过高的字符的绘制出现越界。
         * 如果你需要进行多行文字的绘制，并且对文字的排列和样式没有太复杂的花式要求，那么使用 StaticLayout 就好。
         */
        // TextPaint paint = new TextPaint();
        // paint.setTextSize(80);
        // String text1 = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.";
        // StaticLayout staticLayout1 = new StaticLayout(text1, paint, 1000,
        //         Layout.Alignment.ALIGN_NORMAL, 1, 0, true);
        // String text2 = "a\nbc\ndefghi\njklm\nnopqrst\nuvwx\nyz";
        // StaticLayout staticLayout2 = new StaticLayout(text2, paint, 600,
        //         Layout.Alignment.ALIGN_NORMAL, 1, 0, true);
        // canvas.save();
        // canvas.translate(50, 100);
        // staticLayout1.draw(canvas);
        // canvas.translate(0, 500);
        // staticLayout2.draw(canvas);
        // canvas.restore();

        /**
         * 2 Paint 对文字绘制的辅助
         * Paint 对文字绘制的辅助，有两类方法：设置显示效果的和测量文字尺寸的。
         *
         * 2.1 设置显示效果类
         * 2.1.1 setTextSize(float textSize)
         * 设置文字大小。
         */
        // mPaint.setStyle(Paint.Style.FILL);
        // mPaint.setTextSize(18);
        // canvas.drawText(mText, 100, 25, mPaint);
        // mPaint.setTextSize(36);
        // canvas.drawText(mText, 100, 70, mPaint);
        // mPaint.setTextSize(60);
        // canvas.drawText(mText, 100, 145, mPaint);
        // mPaint.setTextSize(84);
        // canvas.drawText(mText, 100, 240, mPaint);

        /**
         * 2.1.2 setTypeface(Typeface typeface)
         * 设置字体
         */
        // mPaint.setStyle(Paint.Style.FILL);
        // mPaint.setTypeface(Typeface.DEFAULT);
        // canvas.drawText(mText, 100, 150, mPaint);
        // mPaint.setTypeface(Typeface.SERIF);
        // canvas.drawText(mText, 100, 300, mPaint);
        // mPaint.setTypeface(Typeface.SANS_SERIF);
        // canvas.drawText(mText, 100, 450, mPaint);

        /**
         * 2.1.3 setFakeBoldText(boolean fakeBoldText)
         * 是否使用伪粗体。
         * 之所以叫伪粗体（ fake bold ），因为它并不是通过选用更高 weight 的字体让文字变粗，而是通过程序
         * 在运行时把文字给「描粗」了
         */
        // mPaint.setStyle(Paint.Style.FILL);
        // mPaint.setFakeBoldText(false);
        // canvas.drawText(mText, 100, 150, mPaint);
        // mPaint.setFakeBoldText(true);
        // canvas.drawText(mText, 100, 430, mPaint);

        /**
         * 2.1.4 setStrikeThruText(boolean strikeThruText)
         * 是否加删除线。
         */
        // mPaint.setStyle(Paint.Style.FILL);
        // mPaint.setStrikeThruText(true);
        // canvas.drawText(mText, 100, 200, mPaint);

        /**
         * 2.1.5 setUnderlineText(boolean underlineText)
         * 是否加下划线。
         */
        // mPaint.setUnderlineText(true);
        // canvas.drawText(mText, 100, 200, mPaint);

        /**
         * 2.1.6 setTextSkewX(float skewX)
         * 设置文字横向错切角度。其实就是文字倾斜度
         */
        // mPaint.setTextSkewX(-0.5f);
        // canvas.drawText(mText, 100, 150, mPaint);

        /**
         * 2.1.7 setTextScaleX(float scaleX)
         * 设置文字横向放缩。也就是文字变胖变瘦
         */
        // mPaint.setTextScaleX(1);
        // canvas.drawText(mText, 100, 150, mPaint);
        // mPaint.setTextScaleX(0.8f);
        // canvas.drawText(mText, 100, 330, mPaint);
        // mPaint.setTextScaleX(1.2f);
        // canvas.drawText(mText, 100, 530, mPaint);

        /**
         * 2.1.8 setLetterSpacing(float letterSpacing)
         * 设置字符间距。默认值是 0
         */
        // mPaint.setLetterSpacing(0.2f);
        // canvas.drawText(mText, 100, 150, mPaint);

        /**
         * 2.1.9 setFontFeatureSettings(String settings)
         * 用 CSS 的 font-feature-settings 的方式来设置文字
         */
        // mPaint.setFontFeatureSettings("smcp"); // 设置 “small caps”
        // canvas.drawText("Hello World !", 100, 150, mPaint);

        /**
         * 2.1.10 setTextAlign(Paint.Align align)
         * 设置文字的对齐方式。一共有三个值：LEFT CETNER 和 RIGHT。默认值为 LEFT
         */
        // mPaint.setTextAlign(Paint.Align.LEFT);
        // canvas.drawText(mText, 500, 150, mPaint);
        //
        // mPaint.setTextAlign(Paint.Align.CENTER);
        // canvas.drawText(mText, 500, 550, mPaint);
        //
        // mPaint.setTextAlign(Paint.Align.RIGHT);
        // canvas.drawText(mText, 500, 850, mPaint);

        /**
         * 2.1.11 setTextLocale(Locale locale)
         * setTextLocales(LocaleList locales)
         * 设置绘制所使用的 Locale
         * Canvas 绘制的时候，默认使用的是系统设置里的 Locale。而通过
         * Paint.setTextLocale(Locale locale) 就可以在不改变系统设置的情况下，直接修改绘制时的 Locale
         */
        // mText = "雨骨底条今直沿微写";
        // mPaint.setTextLocale(Locale.CHINA); // 简体中文
        // canvas.drawText(mText, 100, 150, mPaint);
        // mPaint.setTextLocale(Locale.TAIWAN); // 繁体中文
        // canvas.drawText(mText, 100, 450, mPaint);
        // mPaint.setTextLocale(Locale.JAPAN); // 日语
        // canvas.drawText(mText, 100, 750, mPaint);

        /**
         * 2.2 测量文字尺寸类
         * 不论是文字，还是图形或 Bitmap，只有知道了尺寸，才能更好地确定应该摆放的位置
         *
         * 2.2.1 float getFontSpacing()
         * 获取推荐的行距。
         * 即推荐的两行文字的 baseline 的距离。这个值是系统根据文字的字体和字号自动计算的。它的作用是当你
         * 要手动绘制多行文字（而不是使用 StaticLayout）的时候，可以在换行的时候给 y 坐标加上这个值来下移
         * 文字
         */
        // canvas.drawText(mText, 100, 150, mPaint);
        // canvas.drawText(mText, 100, 150 + mPaint.getFontSpacing(), mPaint);
        // canvas.drawText(mText, 100, 150 + mPaint.getFontSpacing() * 2, mPaint);

        /**
         * 2.2.3 getTextBounds(String text, int start, int end, Rect bounds)
         * 获取文字的显示范围。
         * 参数里，text 是要测量的文字，start 和 end 分别是文字的起始和结束位置，bounds 是存储文字显示
         * 范围的对象，方法在测算完成之后会把结果写进 bounds
         * 它有一个重载方法 getTextBounds(char[] text, int index, int count, Rect bounds)
         */
        // int offsetX = 100;
        // int offsetY = 100;
        // Rect bounds = new Rect();
        // canvas.drawText(mText, offsetX, offsetX, mPaint);
        // mPaint.getTextBounds(mText, 0, mText.length(), bounds);
        // bounds.left += offsetX;
        // bounds.top += offsetY;
        // bounds.right += offsetX;
        // bounds.bottom += offsetY;
        // mPaint.setStyle(Paint.Style.STROKE);
        // canvas.drawRect(bounds, mPaint);

        /**
         * 2.2.4 float measureText(String text)
         * 测量文字的宽度并返回
         *
         * getTextBounds: 它测量的是文字的显示范围（关键词：显示）。形象点来说，你这段文字外放置一个可变
         * 的矩形，然后把矩形尽可能地缩小，一直小到这个矩形恰好紧紧包裹住文字，那么这个矩形的范围，就是这
         * 段文字的 bounds。
         * measureText(): 它测量的是文字绘制时所占用的宽度（关键词：占用）。前面已经讲过，一个文字在界面
         * 中，往往需要占用比他的实际显示宽度更多一点的宽度，以此来让文字和文字之间保留一些间距，不会显得
         * 过于拥挤。上面的这幅图，我并没有设置 setLetterSpacing() ，这里的 letter spacing 是默认值 0，
         * 但你可以看到，图中每两个字母之间都是有空隙的。另外，下方那条用于表示文字宽度的横线，在左边超出
         * 了第一个字母 H 一段距离的，在右边也超出了最后一个字母 r（虽然右边这里用肉眼不太容易分辨），而就
         * 是两边的这两个「超出」，导致了 measureText() 比 getTextBounds() 测量出的宽度要大一些。
         */
        // int offsetX = 100;
        // int offsetY = 150;
        // canvas.drawText(mText, offsetX, offsetY, mPaint);
        // float textWidth = mPaint.measureText(mText);
        // canvas.drawLine(offsetX, offsetY, offsetX + textWidth, offsetY, mPaint);

        /**
         * 2.2.6 int breakText(String text, boolean measureForwards, float maxWidth,
         * float[] measuredWidth)
         * 这个方法也是用来测量文字宽度的。但和 measureText() 的区别是， breakText() 是在给出宽度上限的
         * 前提下测量文字的宽度。如果文字的宽度超出了上限，那么在临近超限的位置截断文字
         * breakText() 的返回值是截取的文字个数（如果宽度没有超限，则是文字的总个数）。参数中， text 是要
         * 测量的文字；measureForwards 表示文字的测量方向，true 表示由左往右测量；maxWidth 是给出的宽度
         * 上限；measuredWidth 是用于接受数据，而不是用于提供数据的：方法测量完成后会把截取的文字宽度
         * （如果宽度没有超限，则为文字总宽度）赋值给 measuredWidth[0]。
         * 这个方法可以用于多行文字的折行计算。
         */
        // int measuredCount;
        // float[] measuredWidth = {0};
        // // 宽度上限 300 （不够用，截断）
        // measuredCount = mPaint.breakText(mText, 0, mText.length(), true,
        //         300, measuredWidth);
        // canvas.drawText(mText, 0, measuredCount, 50, 150, mPaint);
        // // 宽度上限 400 （不够用，截断）
        // measuredCount = mPaint.breakText(mText, 0, mText.length(), true,
        //         400, measuredWidth);
        // canvas.drawText(mText, 0, measuredCount, 50, 150 + mPaint.getFontSpacing(), mPaint);
        // // 宽度上限 500 （不够用）
        // measuredCount = mPaint.breakText(mText, 0, mText.length(), true,
        //         500, measuredWidth);
        // canvas.drawText(mText, 0, measuredCount, 50, 150 + mPaint.getFontSpacing() * 2,
        //         mPaint);
        // // 宽度上限 1300 （够用）
        // measuredCount = mPaint.breakText(mText, 0, mText.length(), true,
        //         1300, measuredWidth);
        // canvas.drawText(mText, 0, measuredCount, 50, 150 + mPaint.getFontSpacing() * 3,
        //         mPaint);

        /**
         * 2.2.7.1 getRunAdvance(CharSequence text, int start, int end, int contextStart,
         * int contextEnd, boolean isRtl, int offset)
         * 对于一段文字，计算出某个字符处光标的 x 坐标。 start end 是文字的起始和结束坐标；
         * contextStart contextEnd 是上下文的起始和结束坐标；isRtl 是文字的方向；offset 是字数的偏移，
         * 即计算第几个字符处的光标。
         * start 和 contextStart 都是 0， end contextEnd 和 offset 都等于 text.length()。在这种情况下，
         * 它是等价于 measureText(text) 的，即完整测量一段文字的宽度。而对于更复杂的需求，
         * getRunAdvance() 能做的事就比 measureText() 多了
         */
        // int length = mText.length();
        // int offsetX = 100;
        // int offsetY = 150;
        // float advance = mPaint.getRunAdvance(mText, 0, length, 0, length,
        //         false, length);
        // canvas.drawText(mText, offsetX, offsetY, mPaint);
        // mPaint.setColor(Color.RED);
        // canvas.drawLine(offsetX + advance, offsetY - 70, offsetX + advance,
        //         offsetY + 10, mPaint);

        // 包含特殊符号的绘制（如 emoji 表情）
        // 🇨🇳 虽然占了 4 个字符（\uD83C\uDDE8\uD83C\uDDF3），但当 offset 是表情中间处时， getRunAdvance()
        // 得出的结果并不会在表情的中间处。为什么？因为这是用来计算光标的方法啊，光标当然不能出现在符号中间
        // int offsetX = 100;
        // int offsetY = 150;
        // String text = "Hello HenCoder \uD83C\uDDE8\uD83C\uDDF3"; // "Hello HenCoder 🇨🇳"
        // int length = text.length();
        // float advance1 = mPaint.getRunAdvance(text, 0, length, 0, length, false,
        //         length);
        // canvas.drawText(text, offsetX, offsetY, mPaint);
        // canvas.drawLine(offsetX + advance1, offsetY - 70, offsetX + advance1,
        //         offsetY + 10, mPaint);
        //
        // offsetY += mPaint.getFontSpacing();
        // float advance2 = mPaint.getRunAdvance(text, 0, length, 0, length, false,
        //         length - 1);
        // canvas.drawText(text, offsetX, offsetY, mPaint);
        // canvas.drawLine(offsetX + advance2, offsetY - 70, offsetX + advance2,
        //         offsetY + 10, mPaint);
        //
        // offsetY += mPaint.getFontSpacing();
        // float advance3 = mPaint.getRunAdvance(text, 0, length, 0, length, false,
        //         length - 2);
        // canvas.drawText(text, offsetX, offsetY, mPaint);
        // canvas.drawLine(offsetX + advance3, offsetY - 70, offsetX + advance3,
        //         offsetY + 10, mPaint);
        //
        // offsetY += mPaint.getFontSpacing();
        // float advance4 = mPaint.getRunAdvance(text, 0, length, 0, length, false,
        //         length - 3);
        // canvas.drawText(text, offsetX, offsetY, mPaint);
        // canvas.drawLine(offsetX + advance4, offsetY - 70, offsetX + advance4,
        //         offsetY + 10, mPaint);
        //
        // offsetY += mPaint.getFontSpacing();
        // float advance5 = mPaint.getRunAdvance(text, 0, length, 0, length, false,
        //         length - 4);
        // canvas.drawText(text, offsetX, offsetY, mPaint);
        // canvas.drawLine(offsetX + advance5, offsetY - 70, offsetX + advance5,
        //         offsetY + 10, mPaint);
        //
        // offsetY += mPaint.getFontSpacing();
        // float advance6 = mPaint.getRunAdvance(text, 0, length, 0, length, false,
        //         length - 5);
        // canvas.drawText(text, offsetX, offsetY, mPaint);
        // canvas.drawLine(offsetX + advance6, offsetY - 70, offsetX + advance6,
        //         offsetY + 10, mPaint);

        /**
         * 2.2.7.2 getOffsetForAdvance(CharSequence text, int start, int end, int contextStart,
         * int contextEnd, boolean isRtl, float advance)
         * 给出一个位置的像素值，计算出文字中最接近这个位置的字符偏移量（即第几个字符最接近这个坐标）。
         *
         * 方法的参数很简单： text 是要测量的文字；start end 是文字的起始和结束坐标；contextStart
         * contextEnd 是上下文的起始和结束坐标；isRtl 是文字方向；advance 是给出的位置的像素值。
         * 填入参数，对应的字符偏移量将作为返回值返回。
         *
         * getOffsetForAdvance() 配合上 getRunAdvance() 一起使用，就可以实现「获取用户点击处的文字坐标」的需求。
         */

        /**
         * 2.2.8 hasGlyph(String string)
         * 检查指定的字符串中是否是一个单独的字形 (glyph）。最简单的情况是，string 只有一个字母（比如 a）
         */


    }
}
