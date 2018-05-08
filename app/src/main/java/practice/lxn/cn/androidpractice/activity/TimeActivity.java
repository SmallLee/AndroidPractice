package practice.lxn.cn.androidpractice.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import practice.lxn.cn.androidpractice.R;
import practice.lxn.cn.androidpractice.TimeUtil;

public class TimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        TextView textView = (TextView) findViewById(R.id.textview);
        textView.setText(getTime());
    }

    //将小数分钟转化为xx小时和xx分,比如10.00分钟
    public String getTime(){
        return TimeUtil.getHHmm(1524142753000L + 2 * 60 * 1000);
    }

    public void getTime2(String text){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(text);
            format.setLenient(false);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        Date upcarTime = new Date(date.getTime() + 60 *  10000);
        calendar.setTime(upcarTime);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        String str = String.valueOf(minute);
        if (minute >=0 && minute <= 9) {
            str = "0" + str;
        }
        System.out.println(String.format(Locale.getDefault(),getString(R.string.arrive_time),hour,str));
    }
}
