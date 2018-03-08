package practice.lxn.cn.androidpractice.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;
import practice.lxn.cn.androidpractice.R;


public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        CustomHandler handler = new CustomHandler(this);
        handler.sendEmptyMessage(0);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        },3000);
    }

    static class CustomHandler extends Handler {
        private WeakReference<Activity> reference;

        CustomHandler(Activity activity) {
            reference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            Activity activity = reference.get();
            if (activity == null || activity.isFinishing()) {
                return;
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                //isDestroyed4.2引入，用于判断Activity是否被销毁了
                if (activity.isDestroyed()) {
                    return;
                }
                refreshUI(msg);
            } else {
                refreshUI(msg);
            }
        }
        private void refreshUI(Message message) {
            /*
            * Message的几个属性：
            * what:message是何种类型的，也就是什么操作
            * obj:自定义的参数
            * arg1和arg2:两个int参数，相对于setData，花销更小
            * getTarget:获取处理此message的Handler对象,在Handler的enqueueMessage方法中关联
            *  private boolean enqueueMessage(MessageQueue queue, Message msg, long uptimeMillis) {
                msg.target = this;
                if (mAsynchronous) {
                    msg.setAsynchronous(true);
                }
                return queue.enqueueMessage(msg, uptimeMillis);
            * */
            System.out.println("message=====" + message.what);
        }
    }
}
