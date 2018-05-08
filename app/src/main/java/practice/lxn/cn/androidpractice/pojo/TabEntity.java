package practice.lxn.cn.androidpractice.pojo;

import com.flyco.tablayout.listener.CustomTabEntity;

/**
 * 描述：
 * 作者：Create by lixiaoniu on 2018/4/11
 */

public class TabEntity implements CustomTabEntity {
    private String mTitle;
    public TabEntity(String title) {
        this.mTitle = title;
    }

    @Override
    public String getTabTitle() {
        return mTitle;
    }

    @Override
    public int getTabSelectedIcon() {
        return 0;
    }

    @Override
    public int getTabUnselectedIcon() {
        return 0;
    }
}
