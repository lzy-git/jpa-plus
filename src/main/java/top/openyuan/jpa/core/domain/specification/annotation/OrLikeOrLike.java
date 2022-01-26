package top.openyuan.jpa.core.domain.specification.annotation;

import java.lang.annotation.*;

/**
 * 用于“或者模糊匹配某些元素”({@code OR ( field1 LIKE 'xxx' OR field2 LIKE 'yyy')})场景的注解.
 *
 * @author lzy on 2021-11-15
 * @since v1.0.0
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface OrLikeOrLike {

    /**
     * 默认为空即可，不需要额外设置.
     *
     * @return 字符串字段的数组
     */
    String value() default "";

    /**
     * 匹配的多个字段名.
     *
     * @return 字段数组
     */
    String[] fields();

}
