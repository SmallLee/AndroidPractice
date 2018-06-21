package practice.lxn.cn.testapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Timer;
import java.util.TimerTask;

import practice.lxn.cn.butterknife_annotation.BindView;
import practice.lxn.cn.testapp.event.TokenEvent;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn)
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        EventBus eventBus = EventBus.builder()
                // 不接受父类的事件，可以提高效率
                .eventInheritance(false)
                // 没有订阅时发送一个NoSubscriberEvent事件
                .sendNoSubscriberEvent(true)
                .build();
    }

    public void click(View view) {
//        EventBus.getDefault().post(new TokenEvent(""));
//        Toast.makeText(this,btn.toString(),Toast.LENGTH_SHORT).show();
//        setBtn();
        Toast toast=Toast.makeText(this, "这是可以随意设置时间的Toast", Toast.LENGTH_LONG);
        showMyToast(toast, 4*1000);
    }

    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onEvent(TokenEvent event){

    }

    public void setBtn(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void showMyToast(final Toast toast, final int cnt) {
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
        }, cnt );
    }
}
