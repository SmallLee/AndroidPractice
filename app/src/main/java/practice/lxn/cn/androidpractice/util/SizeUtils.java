package practice.lxn.cn.androidpractice.util;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

public class SizeUtils {
    public static int dp2px(Context context, float dp) {
        if (context != null) {
            final float scale = context.getResources().getDisplayMetrics().density;
            return (int) (dp * scale + 0.5f);
        }
        return 0;
    }

    public static int px2dp(Context context, float px) {
        if (context != null) {
            final float scale = context.getResources().getDisplayMetrics().density;
            return (int) (px / scale + 0.5f);
        }
        return 0;
    }

    public static void printScreenInfo(Activity context) {
        DisplayMetrics metric = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(metric);
        int width = metric.widthPixels;  // 屏幕宽度（像素）
        int height = metric.heightPixels;  // 屏幕高度（像素）
        float density = metric.density;  // 屏幕密度（0.75 / 1.0 / 1.5）
        int densityDpi = metric.densityDpi;  // 屏幕密度DPI（120 / 160 / 240）
    }

}
