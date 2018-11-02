package practice.lxn.cn.androidpractice.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Scroller;

/**
 * 描述：
 */
public class HorizontalScrollLayout extends ViewGroup{
    public static final int DURATION = 800;
    // 屏幕高度
    private Scroller mScroller;
    private int mScreenWidth;

    public HorizontalScrollLayout(Context context) {
        super(context);
        initView(context);
    }

    public HorizontalScrollLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public HorizontalScrollLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    /**
     */
    private void initView(Context context) {
        // 获取窗口管理器
        WindowManager mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        // 新建一个DisplayMetrics
        DisplayMetrics mDisplayMetrics = new DisplayMetrics();
        // 将度量标准设置为窗口管理器的默认显示
        if (mWindowManager != null) {
            mWindowManager.getDefaultDisplay().getMetrics(mDisplayMetrics);
        }
        // 获取屏幕的宽度并赋值给mScreenHeight
        mScreenWidth = mDisplayMetrics.widthPixels;
        // 实例化一个滚动类Scroller
        mScroller = new Scroller(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            // 遍历查找所有的子view
            View childView = getChildAt(i);
            // 测量所有子view的宽、高
            measureChild(childView, widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        // 设置ViewGroup的高度
        MarginLayoutParams mlp = (MarginLayoutParams) getLayoutParams();
        mlp.width = mScreenWidth * childCount;
        setLayoutParams(mlp);
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != View.GONE) {
                child.layout(i * mScreenWidth, 0, (i +1) * mScreenWidth, child.getMeasuredHeight());
            }
        }
    }


    @Override
    public void computeScroll(){
        super.computeScroll();
        if(mScroller.computeScrollOffset()){
            scrollTo(mScroller.getCurrX(), 0);
            postInvalidate();
        }
    }
    public void switchView(int position) {
        switch (position) {
            case 0:
                mScroller.startScroll(
                        getScrollX(), 0,
                        -mScreenWidth, 0,DURATION);
                break;
            case 1:
                mScroller.startScroll(
                        0, 0,
                        mScreenWidth, 0,DURATION);
                break;
        }
        postInvalidate();
    }
}
