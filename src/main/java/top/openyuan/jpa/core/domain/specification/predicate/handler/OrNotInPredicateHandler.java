package top.openyuan.jpa.core.domain.specification.predicate.handler;

import top.openyuan.jpa.core.domain.specification.annotation.OrNotIn;
import top.openyuan.jpa.core.domain.specification.handler.AbstractPredicateHandler;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;
import java.lang.annotation.Annotation;

/**
 * 构建“或者不匹配范围条件”({@code OR field NOT IN ('xxx', 'yyy')})场景的 {@link Predicate} 处理器.
 *
 * @author lzy
 * @since v1.0.0
 */
public class OrNotInPredicateHandler extends AbstractPredicateHandler {

    @Override
    public Class<OrNotIn> getAnnotation() {
        return OrNotIn.class;
    }

    @Override
    public <Z, X> Predicate buildPredicate(
            CriteriaBuilder criteriaBuilder, From<Z, X> from, String fieldName, Object value, Annotation annotation) {
        return criteriaBuilder.or(criteriaBuilder.not(
                super.buildInPredicate(criteriaBuilder, from, fieldName, value, super.isAllowNull(annotation))));
    }

    @Override
    public Predicate buildPredicate(
            CriteriaBuilder criteriaBuilder, From<?, ?> from, String fieldName, Object value) {
        return criteriaBuilder.or(criteriaBuilder.not(
                super.buildInPredicate(criteriaBuilder, from, fieldName, value, false)));
    }

}
