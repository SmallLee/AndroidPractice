package practice.lxn.cn.testapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import practice.lxn.cn.butterknife_annotation.BindView;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn)
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    public void click(View view) {
        Toast.makeText(this,btn.toString(),Toast.LENGTH_SHORT).show();
    }
}
