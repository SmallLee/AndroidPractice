package practice.lxn.cn.androidpractice.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import practice.lxn.cn.androidpractice.R;

/**
 * 描述：
 * 作者：Create by lixiaoniu on 2018/4/11
 */

public class HomeTabView extends LinearLayout implements OnTabSelectListener {
//    private CommonTabLayout mTabLayout;
    private SlidingTabLayout tabLayout;

    public HomeTabView(Context context) {
        super(context);
    }

    public HomeTabView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View tabView = LayoutInflater.from(context).inflate(R.layout.view_home_tab,this);
        tabLayout = tabView.findViewById(R.id.tablayout);
    }

    public void setViewePager(ViewPager viewePager){
        tabLayout.setViewPager(viewePager);
    }

    public void setTabSpaceEquals(boolean equal) {
        tabLayout.setTabSpaceEqual(equal);
    }

    @Override
    public void onTabSelect(int position) {

    }

    @Override
    public void onTabReselect(int position) {

    }
}
