package top.openyuan.jpa.specification.handler.impl;

import top.openyuan.jpa.specification.annotation.OrIn;
import top.openyuan.jpa.specification.handler.AbstractPredicateHandler;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;
import java.lang.annotation.Annotation;

/**
 * 构建“或者范围匹配条件”({@code OR field IN ('xxx', 'yyy')})场景的 {@link Predicate} 处理器.
 *
 * @author lzy
 * @since v1.0.0
 */
public class OrInPredicateHandler extends AbstractPredicateHandler {

    @Override
    public Class<OrIn> getAnnotation() {
        return OrIn.class;
    }

    @Override
    public <Z, X> Predicate buildPredicate(
            CriteriaBuilder criteriaBuilder, From<Z, X> from, String fieldName, Object value, Annotation annotation) {
        return criteriaBuilder.or(
                super.buildInPredicate(criteriaBuilder, from, fieldName, value, super.isAllowNull(annotation)));
    }

    @Override
    public Predicate buildPredicate(
            CriteriaBuilder criteriaBuilder, From<?, ?> from, String fieldName, Object value) {
        return criteriaBuilder.or(super.buildInPredicate(criteriaBuilder, from, fieldName, value, false));
    }

}
