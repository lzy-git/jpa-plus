package top.openyuan.ejpa.specification.annotation;

import java.lang.annotation.*;

/**
 * 用于“范围条件”({@code field IN ('xxx', 'yyy')})场景的注解.
 *
 * @author lzy on 2021-11-15
 * @since v1.0.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface In {

    /**
     * 注解的实体字段属性名称，默认为空或空字符串时将使用属性名称.
     *
     * @return 值
     */
    String value() default "";

    /**
     * 是否允许为 {@code null} 值，默认为 {@code false}.
     *
     * @return 值
     */
    boolean allowNull() default false;

}
