package practice.lxn.cn.weather;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {


    private float downX ;    //按下时 的X坐标
    private float downY ;    //按下时 的Y坐标

    private ViewPager viewPager;

    private ArrayList<View> aList;
    private MyPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        viewPager = (ViewPager) findViewById(R.id.ViewPager);
//        aList = new ArrayList<View>();
//        LayoutInflater li = getLayoutInflater();
//        aList.add(li.inflate(R.layout.test3,null,false));
//        aList.add(li.inflate(R.layout.test4,null,false));
//        aList.add(li.inflate(R.layout.test5,null,false));
//        aList.add(li.inflate(R.layout.test6,null,false));
//        View horizontalView = View.inflate(this,R.layout.horizontal,viewPager);
//        HorizontalPageView t1 = horizontalView.findViewById(R.id.horizontalPageVIew);
//        t1.setParentView(viewPager);
//        TextView textView1 = new TextView(this);
//        textView1.setText("11111111111111");
//        textView1.setBackgroundResource(R.color.colorPrimaryDark);
//        TextView textView2 = new TextView(this);
//        textView1.setBackgroundResource(R.color.colorAccent);
//        textView2.setText("222222222222");
//        t1.addPage(textView1);
//        t1.addPage(textView2);
//        horizontalView.requestFocus();
//        horizontalView.requestFocusFromTouch();
//        aList.add(t1);
//        mAdapter = new MyPagerAdapter(aList);
//        viewPager.setAdapter(mAdapter);
//        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });

    }






    /**
     * 触屏事件
     * @param event
     * @return
     */
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        String action = "";
//        //在触发时回去到起始坐标
//        float x= event.getX();
//        float y = event.getY();
//        switch (event.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                //将按下时的坐标存储
//                downX = x;
//                downY = y;
//                Log.e("Tag","=======按下时X："+x);
//                Log.e("Tag","=======按下时Y："+y);
//                break;
//            case MotionEvent.ACTION_UP:
//                Log.e("Tag","=======抬起时X："+x);
//                Log.e("Tag","=======抬起时Y："+y);
//                //获取到距离差
//                float dx= x-downX;
//                float dy = y-downY;
//                //防止是按下也判断
//                if (Math.abs(dx)>8&&Math.abs(dy)>8) {
//                    //通过距离差判断方向
//                    int orientation = getOrientation(dx, dy);
//                    switch (orientation) {
//                        case 'r':
//                            action = "右";
//                            break;
//                        case 'l':
//                            action = "左";
//                            break;
//                        case 't':
//                            action = "上";
//                            break;
//                        case 'b':
//                            action = "下";
//                            break;
//                    }
//                    Toast.makeText(MainActivity.this, "向" + action + "滑动", Toast.LENGTH_SHORT).show();
//                }
//                break;
//        }
//        return super.onTouchEvent(event);
//    }

    /**
     * 根据距离差判断 滑动方向
     * @param dx X轴的距离差
     * @param dy Y轴的距离差
     * @return 滑动的方向
     */
    private int getOrientation(float dx, float dy) {
        Log.e("Tag","========X轴距离差："+dx);
        Log.e("Tag","========Y轴距离差："+dy);
        if (Math.abs(dx)>Math.abs(dy)){
            //X轴移动
            return dx>0?'r':'l';
        }else{
            //Y轴移动
            return dy>0?'b':'t';
        }
    }


    public class MyPagerAdapter extends PagerAdapter {
        private ArrayList<View> viewLists;

        public MyPagerAdapter() {
        }

        public MyPagerAdapter(ArrayList<View> viewLists) {
            super();
            this.viewLists = viewLists;
        }

        @Override
        public int getCount() {
            return viewLists.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

//        @Override
//        public Object instantiateItem(ViewGroup container, int position) {
//            container.addView(viewLists.get(position));
//            return viewLists.get(position);
//        }

        public Object instantiateItem(ViewGroup container, int position) {
            // TODO Auto-generated method stub
            View v=viewLists.get(position);
            ViewGroup parent = (ViewGroup) v.getParent();
            //Log.i("ViewPaperAdapter", parent.toString());
            if (parent != null) {
                parent.removeAllViews();
            }
            container.addView(viewLists.get(position));
            return viewLists.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(viewLists.get(position));
        }
    }
}
