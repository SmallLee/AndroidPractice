package practice.lxn.cn.testapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class AnrActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thrid);
    }

    public void click(final View view) {
       testANR();
    }

    public void testANR() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Toast.makeText(this, "点击", Toast.LENGTH_SHORT).show();
    }
}

/*
* 正常：
*06-14 11:17:10.592 1484-1484/cn.edaijia.android.client D/BookOrderManager: lastBookingStateCode = AppointmentCalling
    currentBookingStateCode = AppointmentTimeout
    female timeout AppointmentTimeout
    notifyOrderBookingTimeout : 8bd3d31741f3475eb929d5b0c3f51be1
*==============================================
*
*
* */
