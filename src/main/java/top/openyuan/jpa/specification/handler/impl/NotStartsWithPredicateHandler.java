package top.openyuan.jpa.specification.handler.impl;

import top.openyuan.jpa.specification.annotation.NotStartsWith;
import top.openyuan.jpa.specification.handler.AbstractPredicateHandler;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;
import java.lang.annotation.Annotation;

/**
 * 构建“按前缀模糊不匹配”({@code AND field NOT LIKE 'xx%'})场景的 {@link Predicate} 处理器.
 *
 * @author lzy
 * @since v1.0.0
 */
public class NotStartsWithPredicateHandler extends AbstractPredicateHandler {

    @Override
    public Class<NotStartsWith> getAnnotation() {
        return NotStartsWith.class;
    }

    @Override
    public <Z, X> Predicate buildPredicate(
            CriteriaBuilder criteriaBuilder, From<Z, X> from, String fieldName, Object value, Annotation annotation) {
        return criteriaBuilder.and(super.buildNotStartsWithPredicate(criteriaBuilder, from, fieldName, value));
    }

}
