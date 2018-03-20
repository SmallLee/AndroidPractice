package practice.lxn.cn.androidpractice.pojo;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 */
public class SQOrderStatus {
    final static int BOOKING = 10;
    final static int ACCEPTED = 13;

    @IntDef({BOOKING,ACCEPTED})
    @Retention(RetentionPolicy.SOURCE)
    public @interface CODE{}
}
