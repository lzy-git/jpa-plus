package top.openyuan.jpa.specification.handler.impl;

import top.openyuan.jpa.specification.annotation.OrNotStartsWith;
import top.openyuan.jpa.specification.handler.AbstractPredicateHandler;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;
import java.lang.annotation.Annotation;

/**
 * 构建“或语句按前缀模糊不匹配”({@code OR field LIKE 'xx%'})场景的 {@link Predicate} 处理器.
 *
 * @author lzy
 * @since v1.0.0
 */
public class OrNotStartsWithPredicateHandler extends AbstractPredicateHandler {

    @Override
    public Class<OrNotStartsWith> getAnnotation() {
        return OrNotStartsWith.class;
    }

    @Override
    public <Z, X> Predicate buildPredicate(
            CriteriaBuilder criteriaBuilder, From<Z, X> from, String fieldName, Object value, Annotation annotation) {
        return criteriaBuilder.or(super.buildNotStartsWithPredicate(criteriaBuilder, from, fieldName, value));
    }

}
