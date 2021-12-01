package top.openyuan.ejpa.specification.handler.impl;

import top.openyuan.ejpa.specification.annotation.OrGreaterThanEqual;
import top.openyuan.ejpa.specification.handler.AbstractPredicateHandler;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;
import java.lang.annotation.Annotation;

/**
 * 构建“或者大于等于条件”({@code OR field >= 'xxx'})场景的 {@link Predicate} 处理器.
 *
 * @author lzy
 * @since v1.0.0
 */
public class OrGreaterThanEqualPredicateHandler extends AbstractPredicateHandler {

    @Override
    public Class<OrGreaterThanEqual> getAnnotation() {
        return OrGreaterThanEqual.class;
    }

    @Override
    public <Z, X> Predicate buildPredicate(
            CriteriaBuilder criteriaBuilder, From<Z, X> from, String fieldName, Object value, Annotation annotation) {
        return criteriaBuilder.or(super.buildGreaterThanEqualPredicate(criteriaBuilder, from, fieldName, value));
    }

}
