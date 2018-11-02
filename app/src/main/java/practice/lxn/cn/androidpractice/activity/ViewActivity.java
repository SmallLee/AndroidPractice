package practice.lxn.cn.androidpractice.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import practice.lxn.cn.androidpractice.R;
import practice.lxn.cn.androidpractice.view.HorizontalScrollLayout;

public class ViewActivity extends AppCompatActivity {

    private HorizontalScrollLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        layout = (HorizontalScrollLayout) findViewById(R.id.layout);
    }
    public void daijia(View view) {
        layout.switchView(0);
    }

    public void carlife(View view) {
        layout.switchView(1);
    }
}
