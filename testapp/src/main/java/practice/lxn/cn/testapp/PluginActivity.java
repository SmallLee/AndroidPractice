package practice.lxn.cn.testapp;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;

import dalvik.system.DexClassLoader;

public class PluginActivity extends AppCompatActivity {

    private ImageView imageView;
    public static final String PLUGIN_NAME = "plugin.apk";
    public static final String PLUGIN_PATH = Environment.getExternalStorageDirectory().getAbsolutePath();
    public static final String PACKAGE_NAME = "practice.lxn.cn.weather";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plugin);
        imageView = findViewById(R.id.imageview);
        PackageManager packageManager = getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(getPackageName(), 0);
            String sourceDir = applicationInfo.sourceDir; // /data/app/practice.lxn.cn.testapp-2/base.apk
            System.out.println("sourcedir " + sourceDir);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void click(View view) {
        // 文件的完成路径
        String fileName = PLUGIN_PATH + File.separator + PLUGIN_NAME;
        File apkFile = new File(fileName);
        if (apkFile.exists()) {
            try {
                AssetManager assetManager = PluginResource.getPluginAssetManager(apkFile);
                PluginResource pluginResources = PluginResource.getPluginResources(getResources(), assetManager);
                DexClassLoader loader = new DexClassLoader(apkFile.getAbsolutePath(),getDir(PLUGIN_NAME,MODE_PRIVATE).getAbsolutePath(),null,getClassLoader());
                Class<?> loadClass = loader.loadClass(PACKAGE_NAME + ".R$drawable");
                Field[] declaredFields = loadClass.getDeclaredFields();
                for (Field field : declaredFields) {
                    if (field.getName().equals("cat")) {
                        int anInt = field.getInt(R.drawable.class);
                        Drawable drawable = pluginResources.getDrawable(anInt);
                        imageView.setImageDrawable(drawable);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // 将文件从assets目录复制到应用目录中，模拟从服务器下载apk
            try {
                InputStream stream = getAssets().open(PLUGIN_NAME);
                FileOutputStream fos = new FileOutputStream(fileName);
                int len = 0;
                byte[] bytes = new byte[1024];
                while ((len = stream.read(bytes)) != -1) {
                    fos.write(bytes,0,len);
                }
                fos.close();
                stream.close();
                Toast.makeText(this, "成功", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
/*
* getDir获取的路径为data/data/包名/
*如何获取到插件的getResource(),通过AssetManager加载插件的apk,然后通过这个AssetManager初始化一个Resource对象
*
* */