package practice.lxn.cn.testapp;

import android.app.Activity;

import practice.lxn.cn.butterknife_annotation.ViewBinder;

/**
 * 描述：
 *
 * @author Create by zxy on 2018/5/10
 */
public class ButterKnife {
    public static void bind(Activity activity) {
        String activityName = activity.getClass().getName() + "_ViewBinder";
        try {
            Class viewBinderClass = Class.forName(activityName);
            ViewBinder viewBinder = (ViewBinder)viewBinderClass.newInstance();
            viewBinder.bind(activity);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
