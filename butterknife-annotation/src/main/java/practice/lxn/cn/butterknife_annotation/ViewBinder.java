package practice.lxn.cn.butterknife_annotation;

/**
 * 描述：提供bind方法供生成的类调用
 *
 * @author Create by zxy on 2018/5/10
 */
public interface ViewBinder<T> {
    void bind(T target);
}
