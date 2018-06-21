package practice.lxn.cn.androidpractice.activity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import practice.lxn.cn.androidpractice.R;
import practice.lxn.cn.androidpractice.common.SQOrderManager;

public class OrderActivity extends AppCompatActivity {
    private static final String TAG = "OrderActivity";

    private LinearLayout llTabContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        llTabContainer = (LinearLayout) findViewById(R.id.ll_tab_container);
        int orderId = getIntent().getIntExtra("orderId", 0);
        Log.d(TAG, "onCreate: " + orderId);
        SQOrderManager.getInstance().addOrder(orderId);
        ArrayList<Integer> allOrders = SQOrderManager.getInstance().getAllOrders();
        createTabs(allOrders);
    }

    public void createTabs(ArrayList<Integer> mItems){
        if (mItems.size() < 2) {
            llTabContainer.setVisibility(View.GONE);
            return;
        }
        for (Integer order : mItems) {
            View itemView = View.inflate(this,R.layout.view_order_tab,null);
            TextView tvOrderName = itemView.findViewById(R.id.tv_order_name);
            tvOrderName.setText(String.valueOf(order));
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lp.weight = 1;
            itemView.setLayoutParams(lp);
            llTabContainer.addView(itemView);
        }
    }

    public void testAlarmManager() {
        // 第一步，构造一个PendingIntent
        Intent intent = new Intent("ACTION_CLOCK");
        intent.putExtra("msg","该起床了");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
        // 第二步，获取并设置AlarmManager
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        if (alarmManager != null) {
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 60000, pendingIntent);
        }
    }
}
