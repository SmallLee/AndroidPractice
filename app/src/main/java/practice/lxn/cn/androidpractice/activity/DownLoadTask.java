package practice.lxn.cn.androidpractice.activity;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

/**
 *
 */

public class DownLoadTask extends AsyncTaskLoader<String> {
    private static final String TAG = "DownLoadTask";
    DownLoadTask(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        Log.d(TAG, "onStartLoading: ");
        super.onStartLoading();
        forceLoad();//必须调用此方法，loadINBackground方法才能执行
    }

    @Override
    public String loadInBackground() {
        Log.d(TAG, "loadInBackground: " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "finish";
    }
}
