package practice.lxn.cn.androidpractice.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import practice.lxn.cn.androidpractice.R;
import practice.lxn.cn.androidpractice.util.SizeUtils;
import practice.lxn.cn.androidpractice.view.HorizontalScrollLayout;
import practice.lxn.cn.androidpractice.view.SlidingUpPanelLayout;

public class ViewActivity extends AppCompatActivity {

    private HorizontalScrollLayout layout;
    private SlidingUpPanelLayout slidingLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        layout = (HorizontalScrollLayout) findViewById(R.id.layout);
        slidingLayout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
    }
    public void daijia(View view) {
        layout.switchView(0);
        slidingLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
        slidingLayout.setPanelHeight(SizeUtils.dp2px(this,100));
    }

    public void carlife(View view) {
        layout.switchView(1);
//        slidingLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
//        slidingLayout.setPanelHeight(0);
    }
}
