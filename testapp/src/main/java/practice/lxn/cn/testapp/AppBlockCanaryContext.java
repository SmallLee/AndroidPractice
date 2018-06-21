package practice.lxn.cn.testapp;

import android.os.Environment;

import com.github.moduth.blockcanary.BlockCanaryContext;

/**
 * 描述：
 *
 * @author Create by zxy on 2018/6/13
 */
public class AppBlockCanaryContext extends BlockCanaryContext {

    // Block时间阈值
    @Override
    public int getConfigBlockThreshold() {
        return 5000;
    }

    // 何时展示
    @Override
    public boolean isNeedDisplay() {
        return BuildConfig.DEBUG;
    }

    // log文件路径
    @Override
    public String getLogPath() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }
}
