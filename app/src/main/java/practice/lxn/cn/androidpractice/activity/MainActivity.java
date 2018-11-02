package practice.lxn.cn.androidpractice.activity;
// 空行
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import practice.lxn.cn.androidpractice.R;
// 空行
public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = getSharedPreferences("app", MODE_PRIVATE);
        sp.registerOnSharedPreferenceChangeListener(new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                String value = sharedPreferences.getString(key, "");
                Log.d(TAG, "onSharedPreferenceChanged: " + key + "--" + value);
            }
        });
        sp.edit().putString("name","lxn").apply();
    }

    public void save(View view) {
        sp.edit().putString("age","12").apply();
    }
}
