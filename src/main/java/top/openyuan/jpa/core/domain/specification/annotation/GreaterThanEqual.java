package top.openyuan.jpa.core.domain.specification.annotation;

import java.lang.annotation.*;

/**
 * 用于“大于等于”({@code >=})场景的注解.
 *
 * @author lzy on 2021-11-15
 * @since v1.0.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface GreaterThanEqual {

    /**
     * 注解的实体字段属性名称，默认为空或空字符串时将使用属性名称.
     *
     * @return 值
     */
    String value() default "";

}
