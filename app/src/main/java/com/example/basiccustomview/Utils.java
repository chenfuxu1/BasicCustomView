package com.example.basiccustomview;

import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/12/3 23:09
 **/
public class Utils {
    public static float dpToPixel(float dp) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        return dp * metrics.density;
    }
}

