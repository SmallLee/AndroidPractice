package practice.lxn.cn.androidpractice.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import practice.lxn.cn.androidpractice.R;
import practice.lxn.cn.androidpractice.fragment.RetainStateFragment;

public class RetainActivity extends AppCompatActivity {

    private LinearLayout fmContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retain);
        fmContainer = (LinearLayout) findViewById(R.id.ll_fm_container);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.ll_fm_container,new RetainStateFragment());
        transaction.commit();
    }
}
