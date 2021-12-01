package top.openyuan.jpa.specification.annotation;

import java.lang.annotation.*;

/**
 * 用于“或者范围”({@code OR field IN ?})条件场景的注解.
 * 条件中传入了大小为0的集合会出现永真和永假条件。建议使用者在调用框架之前对空集合进行过滤。
 *
 * @author lzy on 2021-11-15
 * @since v1.0.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface OrIn {

    /**
     * 注解的实体字段属性名称，默认为空或空字符串时将使用属性名称.
     *
     * @return 字符串值
     */
    String value() default "";

    /**
     * 是否允许为 {@code null} 值，默认为 {@code false}.
     *
     * @return 值
     */
    boolean allowNull() default false;

}
