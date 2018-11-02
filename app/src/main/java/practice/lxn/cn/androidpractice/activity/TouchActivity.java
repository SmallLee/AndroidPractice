package practice.lxn.cn.androidpractice.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import practice.lxn.cn.androidpractice.R;

public class TouchActivity extends Activity {

    private List<View> mViewList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);
//        ViewPager viewPager = findViewById(R.id.view_pager);
//        DemoPagerAdapter adapter = new DemoPagerAdapter();
//        viewPager.setAdapter(adapter);
//        initView();
//        adapter.updateData(mViewList);
    }

    public void initView() {
        View view1 = LayoutInflater.from(this).inflate(R.layout.viewpager_item1,null);
        View view2 = LayoutInflater.from(this).inflate(R.layout.viewpager_item2,null);
        mViewList.add(view1);
        mViewList.add(view2);
    }

    class DemoPagerAdapter extends PagerAdapter{
        List<View> viewList = new ArrayList<>();

        void updateData(List<View> list) {
            viewList.clear();
            viewList.addAll(list);
            notifyDataSetChanged();
        }
        @Override
        public int getCount() {
            return viewList.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = viewList.get(position);
            container.addView(view);
            return view;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(viewList.get(position));
        }
    }
}

