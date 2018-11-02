package practice.lxn.cn.androidpractice.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Scroller;

/**
 * 描述：
 * @author Create by lxn on 2018/10/12
 */
public class BottomBar extends LinearLayout {
    private Scroller mScroller;
    private View bottomBar;
    private View bottomContent;
    private int downY;
    private int scrollOffset;
    private int mCurrentHeight;

    public BottomBar(Context context) {
        this(context,null);
    }

    public BottomBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initScroller(context);
    }

    public void initScroller(Context context) {
        mScroller = new Scroller(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (getChildCount() > 1) {
            bottomBar = getChildAt(0);
            bottomContent = getChildAt(1);
            // 初始化高度
            mCurrentHeight = bottomBar.getMeasuredHeight();
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        bottomBar.layout(0, getMeasuredHeight() - bottomBar.getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight());
        bottomContent.layout(0, getMeasuredHeight(), getMeasuredWidth(), bottomBar.getBottom() + bottomContent.getMeasuredHeight());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                downY = (int) event.getY();
                if (downY < getHeight() - mCurrentHeight) {
                    return false;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                int endY = (int) event.getY();
                if (scrollOffset > 0) {
                    mCurrentHeight = scrollOffset + bottomBar.getHeight();
                    if (endY < mCurrentHeight) {
                        return false;
                    }
                }
                int dy = endY - downY;
                int toScroll = getScrollY() - dy;
                if(toScroll < 0){
                    toScroll = 0;
                } else if(toScroll > bottomContent.getMeasuredHeight()){
                    toScroll = bottomContent.getMeasuredHeight();
                }
                scrollTo(0, toScroll);
                downY = (int) event.getY();
                break;
            case MotionEvent.ACTION_UP:
                scrollOffset = getScrollY();
                mCurrentHeight = scrollOffset + bottomBar.getHeight();
//                if(scrollOffset > bottomContent.getMeasuredHeight() / 2){
//                    showNavigation();
//                } else {
//                    closeNavigation();
//                }
                break;
        }
        return true;
    }

    private void showNavigation(){
        int dy = bottomContent.getMeasuredHeight() - scrollOffset;
        mScroller.startScroll(getScrollX(), getScrollY(), 0, dy, 500);
        invalidate();
    }

    private void closeNavigation(){
        int dy = 0 - scrollOffset;
        mScroller.startScroll(getScrollX(), getScrollY(), 0, dy, 500);
        invalidate();
    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) { // 计算新位置，并判断上一个滚动是否完成。
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            invalidate();// 再次调用computeScroll。
        }
    }
}
