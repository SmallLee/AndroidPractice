package practice.lxn.cn.androidpractice.activity;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;

import practice.lxn.cn.androidpractice.R;

public class SubmitOrderActivity extends AppCompatActivity {

    private DrawerLayout drawerlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_order);
        drawerlayout = (DrawerLayout) findViewById(R.id.drawerlayout);
//        drawerlayout.setScrimColor(Color.TRANSPARENT);
//        drawerlayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }

    public void open(View view){
        drawerlayout.openDrawer(Gravity.LEFT);
    }
    public void close(View view){
        drawerlayout.closeDrawer(Gravity.LEFT);
    }
}
