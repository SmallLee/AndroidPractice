package practice.lxn.cn.androidpractice.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * 描述：
 * 作者：Create by lixiaoniu on 2018/5/4
 */
@SuppressLint("AppCompatCustomView")
public class CustomButton extends Button {
    private static final String TAG = "TouchActivity";
    public CustomButton(Context context) {
        this(context,null);
    }

    public CustomButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d(TAG, "CustomButton dispatchTouchEvent: ");
        return super.dispatchTouchEvent(event);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "CustomButton onTouchEvent: ");
        performClick();
        return super.onTouchEvent(event);
    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }
}
