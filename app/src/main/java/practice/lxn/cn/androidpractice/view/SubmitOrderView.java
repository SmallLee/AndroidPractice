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
 */
public class SubmitOrderView extends FrameLayout{

    private View submitView;

    public SubmitOrderView(@NonNull Context context) {
        this(context,null);
    }

    public SubmitOrderView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        submitView = LayoutInflater.from(context).inflate(R.layout.view_submit_layout,this);
//        Button btn = submitView.findViewById(R.id.btn);
//        final ScrollView scrollView = submitView.findViewById(R.id.scrollview);
//        btn.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                post(new Runnable() {
//                    @Override
//                    public void run() {
//                        scrollView.smoothScrollTo(0,400);
//                    }
//                });
//            }
//        });
    }
}
