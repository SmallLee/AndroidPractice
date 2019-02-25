package practice.lxn.cn.androidpractice.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import practice.lxn.cn.androidpractice.R;
import practice.lxn.cn.androidpractice.view.HomeTabView;
import practice.lxn.cn.androidpractice.view.HomeViewPager;
import practice.lxn.cn.androidpractice.view.HorizontalScrollLayout;
import practice.lxn.cn.androidpractice.view.SlidingUpPanelLayout;

public class ViewActivity extends AppCompatActivity {

    private HorizontalScrollLayout layout;
    private SlidingUpPanelLayout slidingLayout;
    private HomeTabView tabView;
    private HomeViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        viewPager = (HomeViewPager) findViewById(R.id.viewpager);
        tabView = (HomeTabView) findViewById(R.id.tabview);
        viewPager.setTabView(tabView);
        tabView.setViewePager(viewPager);
    }
}
