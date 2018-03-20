package practice.lxn.cn.androidpractice.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import practice.lxn.cn.androidpractice.R;
import practice.lxn.cn.androidpractice.pojo.Response;

public class ThirdActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        int flags = getIntent().getFlags();//268435456
        System.out.println("=========flag " + flags);
        /*
         * 正常 1000 0001 000000000000000000000
         *异常：1000 0011 000000000000000000000
         * FLAG_ACTIVITY_BROUGHT_TO_FRONT:10000000000000000000000
         * 避免从安装界面打开应用，退出后台后，再点击桌面icon启动两个任务栈
         */
        System.out.println("============ binary "+Integer.toBinaryString(flags));
        if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) {
            Toast.makeText(this,"front",Toast.LENGTH_SHORT).show();
            finish();
        }
        String json = getJson();
        Response response = new Gson().fromJson(json,Response.class);
        String page = response.page;
        System.out.println("============" + page + "length " + page.length());
    }

    public String getJson(){
        StringBuilder stringBuilder = new StringBuilder();
        AssetManager manager = getAssets();
        try {
            InputStream open = manager.open("hello.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(open));
            String line;
            while((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

}
