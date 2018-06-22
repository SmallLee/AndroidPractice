package practice.lxn.cn.weather;

import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import practice.lxn.cn.weather.test.FixUtil;
import practice.lxn.cn.weather.test.TestCaculate;

public class MainActivity extends FragmentActivity {
    private static final String TAG = "MainActivity";
    public static final String DEX_PATH = Environment.getExternalStorageDirectory().getAbsolutePath();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void test(View view) {
        TestCaculate testCaculate = new TestCaculate();
        testCaculate.caculate(this);
    }

    public void fix(View view) {
        try {
            // 把dex文件从外部目录复制到应用程序所在目录，方便类加载器加载
            String fileName = "classes2.dex";
            File dir = new File(DEX_PATH + File.separator);
            File file = new File(dir + File.separator + fileName);
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream(getDir("dex",MODE_PRIVATE) + fileName);
            int len;
            byte[] bytes = new byte[1024];
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes,0,len);
            }
            fis.close();
            fos.close();
            FixUtil.patch(this,file.getAbsolutePath(),"practice.lxn.cn.weather.test.TestCaculate");
            Toast.makeText(this, "修复成功", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "修复失败" + e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}
