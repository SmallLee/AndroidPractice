package practice.lxn.cn.androidpractice.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import practice.lxn.cn.androidpractice.R;

/**
 * 描述：
 *
 * @author Create by lxn on 2018/11/6
 */
public class CarPoolView extends FrameLayout {
    public CarPoolView(@NonNull Context context) {
        this(context, null);
    }

    public CarPoolView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_car_pool,this);
    }
}
