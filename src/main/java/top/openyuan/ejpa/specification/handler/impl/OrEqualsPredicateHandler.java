package top.openyuan.ejpa.specification.handler.impl;

import top.openyuan.ejpa.specification.annotation.OrEquals;
import top.openyuan.ejpa.specification.handler.AbstractPredicateHandler;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;
import java.lang.annotation.Annotation;

/**
 * 构建“或者等于条件”({@code OR field = 'xxx'})场景的 {@link Predicate} 处理器.
 *
 * @author lzy
 * @since v1.0.0
 */
public class OrEqualsPredicateHandler extends AbstractPredicateHandler {

    @Override
    public Class<OrEquals> getAnnotation() { return OrEquals.class; }

    @Override
    public <Z, X> Predicate buildPredicate(
            CriteriaBuilder criteriaBuilder, From<Z, X> from, String fieldName, Object value, Annotation annotation) {
        return criteriaBuilder.or(super.buildEqualsPredicate(criteriaBuilder, from, fieldName, value));
    }

}
