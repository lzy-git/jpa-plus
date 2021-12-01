package top.openyuan.ejpa.specification.handler.impl;

import top.openyuan.ejpa.specification.annotation.LessThan;
import top.openyuan.ejpa.specification.handler.AbstractPredicateHandler;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;
import java.lang.annotation.Annotation;

/**
 * 构建“小于条件”({@code field < 'xxx'})场景的 {@link Predicate} 处理器.
 *
 * @author lzy
 * @since v1.0.0
 */
public class LessThanPredicateHandler extends AbstractPredicateHandler {

    @Override
    public Class<LessThan> getAnnotation() {
        return LessThan.class;
    }

    @Override
    public <Z, X> Predicate buildPredicate(
            CriteriaBuilder criteriaBuilder, From<Z, X> from, String fieldName, Object value, Annotation annotation) {
        return criteriaBuilder.and(super.buildLessThanPredicate(criteriaBuilder, from, fieldName, value));
    }

}
