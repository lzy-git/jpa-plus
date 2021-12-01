package top.openyuan.jpa.specification.handler.impl;

import top.openyuan.jpa.specification.annotation.GreaterThan;
import top.openyuan.jpa.specification.handler.AbstractPredicateHandler;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;
import java.lang.annotation.Annotation;

/**
 * 构建“大于条件”({@code field > 'xxx'})场景的 {@link Predicate} 处理器.
 *
 * @author lzy
 * @since v1.0.0
 */
public class GreaterThanPredicateHandler extends AbstractPredicateHandler {

    @Override
    public Class<GreaterThan> getAnnotation() {
        return GreaterThan.class;
    }

    @Override
    public <Z, X> Predicate buildPredicate(
            CriteriaBuilder criteriaBuilder, From<Z, X> from, String fieldName, Object value, Annotation annotation) {
        return criteriaBuilder.and(super.buildGreaterThanPredicate(criteriaBuilder, from, fieldName, value));
    }

}
