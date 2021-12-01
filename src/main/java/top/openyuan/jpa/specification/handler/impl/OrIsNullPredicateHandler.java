package top.openyuan.jpa.specification.handler.impl;

import top.openyuan.jpa.specification.annotation.OrIsNull;
import top.openyuan.jpa.specification.handler.AbstractPredicateHandler;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;
import java.lang.annotation.Annotation;

/**
 * 构建“或者是 NULL 条件”({@code OR field IS NULL})场景的 {@link Predicate} 处理器.
 *
 * @author lzy
 * @since v1.0.0
 */
public class OrIsNullPredicateHandler extends AbstractPredicateHandler {

    @Override
    public Class<OrIsNull> getAnnotation() {
        return OrIsNull.class;
    }

    @Override
    public <Z, X> Predicate buildPredicate(
            CriteriaBuilder criteriaBuilder, From<Z, X> from, String fieldName, Object value, Annotation annotation) {
        return criteriaBuilder.or(super.buildIsNullPredicate(criteriaBuilder, from, value));
    }

}
