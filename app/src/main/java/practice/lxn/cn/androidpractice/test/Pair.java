package practice.lxn.cn.androidpractice.test;

/**
 * 描述：
 * 作者：Create by lixiaoniu on 2018/5/4
 */
public class Pair<T> {
    private T t;

    public void setValue(T t) {
        this.t = t;
    }

    public T getValue() {
        return t;
    }
}
