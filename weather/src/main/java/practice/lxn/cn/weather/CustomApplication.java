package practice.lxn.cn.weather;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

/**
 * 描述：
 *
 * @author Create by zxy on 2018/6/21
 * @since
 */
public class CustomApplication extends MultiDexApplication {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

}
