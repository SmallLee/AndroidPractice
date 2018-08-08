package practice.lxn.cn.weather;

import android.content.Context;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;


/**
 * ===============================
 * 作者：Lee
 * 日期：2017/9/19
 * 版本：1.0
 * 描述：
 * ===============================
 */

public class GroupViewPager extends ViewPager {
    private static final String TAG = "GroupViewPager";
    public GroupViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }


    public GroupViewPager(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "dispatchTouchEvent: ACTION_DOWN");
            case MotionEvent.ACTION_UP:
        }

        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Log.d("danni", "layout onTouchEvent, ev : " + MotionEvent.actionToString(event.getAction()));
        }
        boolean result = super.onTouchEvent(event);
        Log.d("danni","onTouchEvent:" + (result ? "1111" : "222"));
        return result;
    }


    @Override
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        Log.e("danni",disallowIntercept ? "requestDisallow 1111" : "requestDisallow 222");
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
    }
}
