package practice.lxn.cn.testapp;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.github.moduth.blockcanary.BlockCanary;

/**
 * 描述：
 *
 * @author Create by zxy on 2018/6/19
 */
public class DemoApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        BlockCanary.install(this,new AppBlockCanaryContext()).start();
    }
}
