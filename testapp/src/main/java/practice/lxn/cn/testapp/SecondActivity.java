package practice.lxn.cn.testapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private int mAge; // 非公有，静态
    int mSex;
    private static String sName; // 静态以s开头
    public int pAddress; // 公有非静态以p开头
    public static int gSize;//公有静态成员
    private String[] sAgeArr = {"1","2"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void test(int a){
        switch (a) {
            case 1:
                break;
            case 2:
                break;
            default:        //要加上
        }
    }
}

