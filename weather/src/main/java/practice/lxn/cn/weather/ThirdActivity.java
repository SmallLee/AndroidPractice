package practice.lxn.cn.weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

public class ThirdActivity extends AppCompatActivity {
    private static final String TAG = "ThirdActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        SimpleDateFormat sdf = new SimpleDateFormat();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
        TextUtils.equals("","");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
        // 展示固定时长的Toast

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }


    public void finish(View view) {
        Intent intent = new Intent();
        intent.putExtra("age",20);
        setResult(200,intent);
        finish();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    public void test(View view) {
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
//        final ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
//
//        for (int i = 0; i < 10; i++) {
//            final int finalI = i;
//            new Thread(){
//                @Override
//                public void run() {
//                    super.run();
//                    threadLocal.set(finalI + 1);
//                    System.out.println("thread1: " + threadLocal.get());
//                }
//            }.start();
//        }
        Toast toast=Toast.makeText(this, "aaaaaa", Toast.LENGTH_LONG);
        showFixDurationToast(toast,5 * 1000);
    }
    public static void showFixDurationToast(final Toast toast, final int duration) {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                toast.show();
            }
        }, 0, 3500);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                toast.cancel();
                timer.cancel();
            }
        }, duration );
    }
}
