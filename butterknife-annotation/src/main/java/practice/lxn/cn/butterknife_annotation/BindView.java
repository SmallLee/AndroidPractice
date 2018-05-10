package practice.lxn.cn.butterknife_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 描述：
 *
 * @author Create by zxy on 2018/5/10
 */
@Retention(RetentionPolicy.SOURCE) // 注解只在源码级别保留
@Target(ElementType.FIELD) // 注解用在字段上
public @interface BindView {
    int value();
}
