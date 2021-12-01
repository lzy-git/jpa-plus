package top.openyuan.ejpa.specification.handler.impl;

import top.openyuan.ejpa.specification.annotation.NotLikePattern;
import top.openyuan.ejpa.specification.handler.AbstractPredicateHandler;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;
import java.lang.annotation.Annotation;

/**
 * 构建“按指定模式不匹配”({@code field LIKE '%xx%'})场景的 {@link Predicate} 处理器.
 *
 * @author lzy
 * @since v1.0.0
 */
public class NotLikePatternPredicateHandler extends AbstractPredicateHandler {

    @Override
    public Class<NotLikePattern> getAnnotation() {
        return NotLikePattern.class;
    }

    @Override
    public <Z, X> Predicate buildPredicate(
            CriteriaBuilder criteriaBuilder, From<Z, X> from, String fieldName, Object value, Annotation annotation) {
        return criteriaBuilder.and(super.buildNotLikePatternPredicate(criteriaBuilder, from, fieldName, value));
    }

}
