package practice.lxn.cn.androidpractice.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import practice.lxn.cn.androidpractice.R;

/**
 * 描述：
 * 作者：Create by lixiaoniu on 2018/4/11
 */

public class HomeTabView extends LinearLayout implements OnTabSelectListener {
    private CommonTabLayout mTabLayout;

    public HomeTabView(Context context) {
        super(context);
    }

    public HomeTabView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.view_home_tab,this);
    }

    @Override
    public void onTabSelect(int position) {

    }

    @Override
    public void onTabReselect(int position) {

    }
}
