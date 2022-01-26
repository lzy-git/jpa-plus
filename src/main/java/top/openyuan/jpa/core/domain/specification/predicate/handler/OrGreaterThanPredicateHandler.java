package top.openyuan.jpa.core.domain.specification.predicate.handler;

import top.openyuan.jpa.core.domain.specification.annotation.OrGreaterThan;
import top.openyuan.jpa.core.domain.specification.handler.AbstractPredicateHandler;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;
import java.lang.annotation.Annotation;

/**
 * 构建“或者大于条件”({@code OR field > 'xxx'})场景的 {@link Predicate} 处理器.
 *
 * @author lzy
 * @since v1.0.0
 */
public class OrGreaterThanPredicateHandler extends AbstractPredicateHandler {

    @Override
    public Class<OrGreaterThan> getAnnotation() {
        return OrGreaterThan.class;
    }

    @Override
    public <Z, X> Predicate buildPredicate(
            CriteriaBuilder criteriaBuilder, From<Z, X> from, String fieldName, Object value, Annotation annotation) {
        return criteriaBuilder.or(super.buildGreaterThanPredicate(criteriaBuilder, from, fieldName, value));
    }

}
