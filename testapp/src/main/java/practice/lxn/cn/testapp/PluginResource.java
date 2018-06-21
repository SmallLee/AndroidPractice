package practice.lxn.cn.testapp;

import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 描述：
 *
 * @author Create by zxy on 2018/6/19
 */
public class PluginResource extends Resources {

    private PluginResource(AssetManager assets, DisplayMetrics metrics, Configuration config) {
        super(assets, metrics, config);
    }

    public static PluginResource getPluginResources(Resources resources, AssetManager assetManager) {
        return new PluginResource(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
    }

    public static AssetManager getPluginAssetManager(File apk) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> aClass = Class.forName("android.content.res.AssetManager");
        // getDeclaredMethods获取所有修饰符的方法，除去继承的方法
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            if (method.getName().equals("addAssetPath")) {
                // 通过addAssetPath方法把apk的路径添加进来
                AssetManager assetManager = AssetManager.class.newInstance();
                method.invoke(assetManager, apk.getAbsolutePath());
                return assetManager;
            }
        }
        return null;
    }
}
