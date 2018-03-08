package practice.lxn.cn.androidpractice.common;

import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;

/**
 *
 */

public class CustomApplication extends Application {

    public CustomApplication(){
        System.out.println("==========CustomApplication");
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        System.out.println("==========attachBaseContext");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("==========onCreate");
        AppForgroundHelper helper = new AppForgroundHelper();
        helper.register(this, new AppForgroundHelper.OnAppStatusChangedListener() {
            @Override
            public void onForeground() {
                System.out.println("============onForeground");
            }

            @Override
            public void onBackground() {
                System.out.println("============onBackground");
            }
        });
    }
    //通知 应用程序 当前内存使用情况（以内存级别进行识别）
    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        if (level > ComponentCallbacks2.TRIM_MEMORY_COMPLETE) {

        }

    }

    @Override
    public void onLowMemory() {//API14,4.0之前
        super.onLowMemory();
    }

    //应用程序结束时调用,但该方法只用于Android仿真机测试，在Android产品机是不会调用的
    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    //监听配置变化
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
    /*
    * 特别注意：OnTrimMemory（） &  OnLowMemory（） 关系
        OnTrimMemory（）是 OnLowMemory（） Android 4.0后的替代 API
        OnLowMemory（） =  OnTrimMemory（）中的TRIM_MEMORY_COMPLETE级别
        若想兼容Android 4.0前，请使用OnLowMemory（）；否则直接使用OnTrimMemory（）即可
    *
    * */
}
