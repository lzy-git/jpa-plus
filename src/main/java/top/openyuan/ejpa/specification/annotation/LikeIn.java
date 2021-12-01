package top.openyuan.ejpa.specification.annotation;

import java.lang.annotation.*;

/**
 * 用于“模糊匹配数组”({@code field1 LIKE '%xx%' OR field2 LIKE '%yyy%'})场景的注解.
 *
 * @author lzy on 2021-11-15
 * @since v1.0.0
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LikeIn {

    /**
     * 注解的实体字段属性名称，默认为空或空字符串时将使用属性名称.
     *
     * @return 字符串值
     */
    String value() default "";

}
