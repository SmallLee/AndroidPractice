package practice.lxn.cn.androidpractice.common;

import java.util.ArrayList;

/**
 *
 */

public class SQOrderManager {
    private static SQOrderManager mInstance;

    private ArrayList<Integer> mItems = new ArrayList<>();

    public static SQOrderManager getInstance(){
        if (mInstance == null) {
            mInstance = new SQOrderManager();
        }
        return mInstance;
    }

    public void addOrder(int orderId){
        if (mItems.contains(orderId)) return;
        mItems.add(orderId);
    }

    public ArrayList<Integer> getAllOrders(){
        return mItems;
    }

    public int getSQOrderCount(){
        return mItems.size();
    }
}
