package practice.lxn.cn.androidpractice.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import practice.lxn.cn.androidpractice.R;

/**
 *
 */

public class LefTabView extends LinearLayout implements View.OnClickListener {

    private ValueAnimator showAnim;
    private ValueAnimator hideAnim;
    private LinearLayout linearLayout;
    private boolean mIsMenuOpen = false;

    public LefTabView(Context context) {
        this(context,null);
    }

    public LefTabView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initLeftTabView(context);
    }

    public void initLeftTabView(Context context){
        View leftTabLayout = View.inflate(context, R.layout.left_tab_layout2, null);
        final Button btn = leftTabLayout.findViewById(R.id.btn);
        linearLayout = leftTabLayout.findViewById(R.id.ll_left);
        btn.setOnClickListener(this);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        addView(leftTabLayout,params);
        showAnim = ValueAnimator.ofInt(-360, 0);
        hideAnim = ValueAnimator.ofInt(0, -360);
    }

    @Override
    public void onClick(View v) {
        doAnimation();
    }
    public void doAnimation(){
        if (!mIsMenuOpen) {
            mIsMenuOpen = true;
            doAnim(showAnim);
        } else {
            mIsMenuOpen = false;
           doAnim(hideAnim);
        }
    }

    public void doAnim(ValueAnimator animator) {
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                LayoutParams layoutParams = (LayoutParams) linearLayout.getLayoutParams();
                layoutParams.leftMargin = (int) animation.getAnimatedValue();
                linearLayout.requestLayout();
            }
        });
        animator.setDuration(200);
        animator.start();
    }
}
