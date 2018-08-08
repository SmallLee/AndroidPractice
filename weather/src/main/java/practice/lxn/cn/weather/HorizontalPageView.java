package practice.lxn.cn.weather;

import android.content.Context;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;


public class HorizontalPageView extends HorizontalScrollView {
    private static final String TAG = "HorizontalPageView";
    private int mBaseScrollX;//滑动基线。也就是点击并滑动之前的x值，以此值计算相对滑动距离。
    private int mScreenWidth;
    private int mScreenHeight;

    private LinearLayout mContainer;
    private boolean flag;
    private int mPageCount;//页面数量
    private boolean prePicTag = true;//预览图片
    private int mCurrentPagePosition = 0;//当前页面索引
    GestureDetector mygesture;

    public HorizontalPageView(Context context) {
        this(context, (AttributeSet) null);
    }


    public HorizontalPageView(Context context, AttributeSet attrs) {
        super(context, attrs);

        DisplayMetrics dm = context.getApplicationContext().getResources()
                .getDisplayMetrics();
        mScreenWidth = dm.widthPixels;
        mScreenHeight = dm.heightPixels;
    }


    /**
     * 添加一个页面到最后。
     *
     * @param page
     */
    public void addPage(View page) {
        addPage(page, -1);
    }

    /**
     * 添加一个页面。
     *
     * @param page
     */
    public void addPage(View page, int index) {
        if (!flag) {
            mContainer = (LinearLayout) getChildAt(0);
            flag = true;
        }
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(mScreenWidth, mScreenHeight);
        if (index == -1) {
            mContainer.addView(page, params);
        } else {
            mContainer.addView(page, index, params);
        }
        mPageCount++;
    }


    /**
     * 获取当前页面的子view
     *
     * @param position
     * @return
     */
    public View getCurrentPageView(int position) {
        View view = null;
        if (position < mPageCount) {
            view = mContainer.getChildAt(position);
        }
        return view;

    }

    /**
     * 移除一个页面。
     *
     * @param index
     */
    public void removePage(int index) {
        if (mPageCount < 1) {
            return;
        }
        if (index < 0 || index > mPageCount - 1) {
            return;
        }
        mContainer.removeViewAt(index);
        mPageCount--;
    }

    /**
     * 移除所有的页面
     */
    public void removeAllPages() {
        if (mPageCount > 0) {
            mContainer.removeAllViews();
        }
    }

    /**
     * 获取页面数量
     *
     * @return
     */
    public int getPageCount() {
        return mPageCount;
    }

    /**
     * 获取相对滑动位置。由右向左滑动，返回正值；由左向右滑动，返回负值。
     *
     * @return
     */
    private int getBaseScrollX() {
        if (mBaseScrollX == -mScreenWidth) {
            mBaseScrollX = 0;
        }
        Log.e("danni", "getScrollX：" + getScrollX() + "===" + mBaseScrollX + "====" + (getScrollX() - mBaseScrollX));
        return getScrollX() - mBaseScrollX;
    }

    /**
     * 使相对于基线移动x距离。
     *
     * @param x x为正值时右移；为负值时左移。
     */
    private void baseSmoothScrollTo(int x) {
        invalidate();
        smoothScrollTo(x + mBaseScrollX, 0);

//        if (mOnScrollPageChange != null) {
        int position = Math.abs((x + mBaseScrollX) / mScreenWidth);
        mCurrentPagePosition = position;
//            mOnScrollPageChange.onScrollPageChange(position);
//        }
    }


    /**
     * 设置预览图片的tag
     *
     * @param
     * @return
     */
    public void setPrePicTag(boolean tag) {
        this.prePicTag = tag;
    }


    float x1 = 0;
    float y1 = 0;
    float mLastX;
    float mDownX;
    float startRawX;
    boolean mCanScroll;

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        int minScrollDistance = 10;//滑动多长距离翻页
        int action = ev.getAction();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Log.d("danni", "view onTouchEvent, ev : " + MotionEvent.actionToString(ev.getAction()));
        }
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                x1 = ev.getX();
//                getParent().requestDisallowInterceptTouchEvent(true);
                Log.d(TAG, "onTouchEvent: action down");
                break;
            case MotionEvent.ACTION_UP:
                float lastX = ev.getX() - x1;
                int scrollX = getBaseScrollX();
                // 防止滑动到最后一页还出现滑动
                if (scrollX == 0 && mCurrentPagePosition == 1) {
                    Log.d(TAG, "onTouchEvent: ----------");
                    return false;
                }
                Log.d(TAG, "onTouchEvent: lastx" + lastX);
                if (lastX > 0 && getParent()instanceof ViewPager && mCurrentPagePosition == 0 && mBaseScrollX == 0) {
                    ViewPager viewPager = (ViewPager) getParent();
                    viewPager.setCurrentItem(viewPager.getChildCount());
                }
                // 左滑
                if (scrollX > minScrollDistance) {
                    baseSmoothScrollTo(mScreenWidth);
                    mBaseScrollX += mScreenWidth;
                }
//                //左滑，不到一半，返回原位
//                else if (scrollX > 0) {
//                    baseSmoothScrollTo(0);
//                }
                //右滑，不到一半，返回原位
//                else if (scrollX > -mScrollX) {
//                    baseSmoothScrollTo(0);
//                }
                //右滑，大于一半，移到下一页
                else {
                    Log.d(TAG, "onTouchEvent: 右滑" + scrollX);
                    baseSmoothScrollTo(-mScreenWidth);
                    mBaseScrollX -= mScreenWidth;
                }
                return true;
//            case MotionEvent.ACTION_MOVE:
//                float lastX = ev.getX() - x1;
//                if (mCurrentPagePosition == 0 && lastX > 0) {
//                    getParent().requestDisallowInterceptTouchEvent(false);
//                    return false;
//                }
//                break;
        }
        return super.onTouchEvent(ev);
    }

    public interface OnScrollPageChange {
        void onScrollPageChange(int position);
    }

    private OnScrollPageChange mOnScrollPageChange;

    public void setOnScrollPageChange(OnScrollPageChange onScrollPageChange) {
        this.mOnScrollPageChange = onScrollPageChange;
    }


    public void onPageSelected(int position) {

    }

    private ViewParent parentView;
    public void setParentView(ViewParent view){
        this.parentView = view;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
       switch (ev.getAction()) {
           case MotionEvent.ACTION_DOWN:
               Log.d(TAG, "dispatchTouchEvent: ");
               break;
       }
        return super.dispatchTouchEvent(ev);
    }
}
