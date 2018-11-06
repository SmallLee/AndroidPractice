package practice.lxn.cn.androidpractice.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import practice.lxn.cn.androidpractice.R;

/**
 * 描述：
 * @author Create by lxn on 2018/11/2
 */
public class DaiJiaView extends FrameLayout {
    public DaiJiaView(@NonNull Context context) {
        this(context, null);
    }

    public DaiJiaView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public void initView(Context context) {
        View daijiaView = LayoutInflater.from(context).inflate(R.layout.view_daijia, this);
        SlidingUpPanelLayout slidingLayout = daijiaView.findViewById(R.id.sliding_layout);
        slidingLayout.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {

            }

            @Override
            public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState, SlidingUpPanelLayout.PanelState newState) {

            }
        });
    }
}
