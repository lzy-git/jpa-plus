package top.openyuan.ejpa.specification.annotation;

import java.lang.annotation.*;

/**
 * 用于“模糊匹配某些符合条件的元素”({@code LIKE})场景的注解.
 *
 * <p>示例：{@code field1 like 'xxx' or field2 like 'xxx'}.</p>
 *
 * @author lzy on 2021-11-15
 * @since v1.0.0
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LikeOrLike {

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
