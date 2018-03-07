package practice.lxn.cn.androidpractice.common;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 */


public class ActionType {
    private static final int DEFAULT_TYPE = ActionType.ONE;
    private @Type int type;
    @Retention(RetentionPolicy.SOURCE)
    //定义可以接收的常量列表
    @IntDef({ONE, TWO, THREE})
    @interface Type {
    }

    static final int ONE = 1;
    static final int TWO = 2;
    static final int THREE = 3;

    @Type
    public int getType(){
        return DEFAULT_TYPE;
    }

    public void setType(@Type int type){
        this.type = type;
    }
    //================测试带标记的
    @Retention(RetentionPolicy.RUNTIME)
    //flag标记代表是否可以把常量作为一个标记，也就是是否可以设置多个，默认false
    @IntDef(flag = true,value = {ONE, TWO, THREE})
    @interface TYPE2 {
    }

    @TYPE2
    public int getType2(){
        return DEFAULT_TYPE;
    }

    public void setType2(@TYPE2 int type){

    }
}
