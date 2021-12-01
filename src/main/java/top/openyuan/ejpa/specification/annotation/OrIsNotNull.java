package top.openyuan.ejpa.specification.annotation;

import java.lang.annotation.*;

/**
 * 用于“或者不是 NULL”({@code OR field IS NOT NULL})条件场景的注解.
 *
 * @author lzy on 2021-11-15
 * @since v1.0.0
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface OrIsNotNull {

    /**
     * 注解的实体字段属性名称，默认为空或空字符串时将使用属性名称.
     *
     * @return 值
     */
    String value() default "";

}
