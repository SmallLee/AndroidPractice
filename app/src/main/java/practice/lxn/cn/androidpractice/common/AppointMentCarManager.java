package practice.lxn.cn.androidpractice.common;

import java.util.LinkedHashMap;

/**
 *
 */

public class AppointMentCarManager {
    private LinkedHashMap<Integer,String> mOrderList = new LinkedHashMap<>();

    public void addOrder(int orderId,String name){
        if (mOrderList.containsKey(orderId)) {
            mOrderList.put(orderId,name);
        }
    }
}
