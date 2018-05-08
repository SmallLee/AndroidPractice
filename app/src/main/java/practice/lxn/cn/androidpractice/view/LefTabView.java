package practice.lxn.cn.androidpractice.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import practice.lxn.cn.androidpractice.R;

/**
 *
 */

public class LefTabView extends LinearLayout implements View.OnClickListener {
    public OnSubmitOrderListener mListener;
    public interface OnSubmitOrderListener{
        void onSubmitOrderItemClick(int position);
    }

    public void setOnSubmitOrderItemClick(OnSubmitOrderListener listener){
        this.mListener = listener;
    }
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
        TextView tvMenuOne = leftTabLayout.findViewById(R.id.tv_menu_one);
        TextView tvMenuTwo = leftTabLayout.findViewById(R.id.tv_menu_two);
        linearLayout = leftTabLayout.findViewById(R.id.ll_left);
        btn.setOnClickListener(this);
        tvMenuOne.setOnClickListener(this);
        tvMenuTwo.setOnClickListener(this);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        addView(leftTabLayout,params);
        showAnim = ValueAnimator.ofInt(-360, 0);
        hideAnim = ValueAnimator.ofInt(0, -360);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                doAnimation();
                break;
            case R.id.tv_menu_one:
                mListener.onSubmitOrderItemClick(0);
                break;
            case R.id.tv_menu_two:
                mListener.onSubmitOrderItemClick(1);
                break;
        }

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

    public void setMarginBottom(int bottomMargin) {
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        params.bottomMargin = bottomMargin;
        setLayoutParams(params);
    }
}
