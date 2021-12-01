package top.openyuan.ejpa.specification.handler.impl;

import top.openyuan.ejpa.specification.annotation.Equals;
import top.openyuan.ejpa.specification.handler.AbstractPredicateHandler;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;
import java.lang.annotation.Annotation;

/**
 * 构建“等值条件”({@code field = 'xxx'})场景的 {@link Predicate} 处理器.
 *
 * @author lzy
 * @since v1.0.0
 */
public class EqualsPredicateHandler extends AbstractPredicateHandler {

    /**
     * 获取 {@link Equals} 注解的 {@code Class} 类型的值.
     *
     * @return {@link Equals} 注解的 {@code Class} 类型的值
     */
    @Override
    public Class<Equals> getAnnotation() {
        return Equals.class;
    }

    @Override
    public <Z, X> Predicate buildPredicate(
            CriteriaBuilder criteriaBuilder, From<Z, X> from, String fieldName, Object value, Annotation annotation) {

        return criteriaBuilder.and(super.buildEqualsPredicate(criteriaBuilder, from, fieldName, value));
    }

}
