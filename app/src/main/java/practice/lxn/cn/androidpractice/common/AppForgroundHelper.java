package practice.lxn.cn.androidpractice.common;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/**
 *
 */

public class AppForgroundHelper implements Application.ActivityLifecycleCallbacks {
    private OnAppStatusChangedListener mListener;
    private int mActivityStartCount = 0;

    public  void register(Application application, OnAppStatusChangedListener listener) {
        mListener = listener;
        application.registerActivityLifecycleCallbacks(this);
    }

    public void unRegister(Application application) {
        application.unregisterActivityLifecycleCallbacks(this);
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(Activity activity) {
        mActivityStartCount++;
        if (mActivityStartCount == 1) {
            if (mListener != null) {
                mListener.onForeground();
            }
        }
    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {
        mActivityStartCount--;
        if (mActivityStartCount == 0) {
            if (mListener != null) {
                mListener.onBackground();
            }
        }
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }

    public interface OnAppStatusChangedListener {
        void onForeground();

        void onBackground();
    }
}
