package top.openyuan.jpa.core.domain.specification.predicate.handler;

import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;
import top.openyuan.jpa.core.domain.specification.annotation.NotIn;
import top.openyuan.jpa.core.domain.specification.predicate.AbstractPredicateHandler;
import top.openyuan.jpa.core.domain.specification.predicate.AbstractSimplePredicateExt;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Collection;

/**
 * 构建“范围不匹配条件”({@code field NOT IN ('xxx', 'yyy')})场景的 {@link Predicate} 处理器.
 *
 * @author lzy
 * @since v1.0.0
 */
public class NotInPredicateHandler extends AbstractPredicateHandler {

    @Override
    public Class<NotIn> getAnnotation() {
        return NotIn.class;
    }

    @Override
    public <Z, X> Predicate buildPredicate(
            CriteriaBuilder criteriaBuilder, From<Z, X> from, String fieldName, Object value, Annotation annotation) {
        return this.buildPredicate(criteriaBuilder, from, fieldName, value);
    }

    @Override
    public Predicate buildPredicate(
            CriteriaBuilder criteriaBuilder, From<?, ?> from, String fieldName, Object value) {
        CriteriaBuilder.In<Object> in = criteriaBuilder.in(from.get(fieldName));
        value = value.getClass().isArray() ? Arrays.asList((Object[]) value) : value;

        if (value instanceof Collection) {
            Collection<?> list = (Collection<?>) value;
            if (list.isEmpty()) {
                return new AbstractSimplePredicateExt(
                        (CriteriaBuilderImpl) criteriaBuilder, true, Predicate.BooleanOperator.AND);
            } else {
                list.forEach(in::value);
            }
        } else {
            in.value(value);
        }
        return criteriaBuilder.and(criteriaBuilder.not(in));
    }

}
