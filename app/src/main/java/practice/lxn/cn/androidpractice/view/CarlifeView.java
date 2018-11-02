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
 * @author Create by lxn on 2018/11/2
 */
public class CarlifeView extends FrameLayout {
    public CarlifeView(@NonNull Context context) {
        this(context, null);
    }

    public CarlifeView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_carlife, this);
    }
}
