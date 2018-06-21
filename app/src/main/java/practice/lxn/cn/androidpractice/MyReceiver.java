package practice.lxn.cn.androidpractice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * 描述：
 * @author Create by zxy on 2018/6/12
 */
public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        intent.getStringExtra("msg");
    }
}
