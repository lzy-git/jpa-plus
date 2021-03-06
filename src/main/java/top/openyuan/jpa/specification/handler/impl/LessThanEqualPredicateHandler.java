package top.openyuan.jpa.specification.handler.impl;

import top.openyuan.jpa.specification.annotation.LessThanEqual;
import top.openyuan.jpa.specification.handler.AbstractPredicateHandler;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;
import java.lang.annotation.Annotation;

/**
 * 构建“小于等于条件”({@code field <= 'xxx'})场景的 {@link Predicate} 处理器.
 *
 * @author lzy
 * @since v1.0.0
 */
public class LessThanEqualPredicateHandler extends AbstractPredicateHandler {

    @Override
    public Class<LessThanEqual> getAnnotation() {
        return LessThanEqual.class;
    }

    @Override
    public <Z, X> Predicate buildPredicate(
            CriteriaBuilder criteriaBuilder, From<Z, X> from, String fieldName, Object value, Annotation annotation) {
        return criteriaBuilder.and(super.buildLessThanEqualPredicate(criteriaBuilder, from, fieldName, value));
    }

}
