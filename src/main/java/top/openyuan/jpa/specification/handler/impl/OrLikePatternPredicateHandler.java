package top.openyuan.jpa.specification.handler.impl;

import top.openyuan.jpa.specification.annotation.OrLikePattern;
import top.openyuan.jpa.specification.handler.AbstractPredicateHandler;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;
import java.lang.annotation.Annotation;

/**
 * 构建“或语句按指定模式匹配”({@code field LIKE '%xx%'})场景的 {@link Predicate} 处理器.
 *
 * @author lzy
 * @since v1.0.0
 */
public class OrLikePatternPredicateHandler extends AbstractPredicateHandler {

    @Override
    public Class<OrLikePattern> getAnnotation() {
        return OrLikePattern.class;
    }

    @Override
    public <Z, X> Predicate buildPredicate(
            CriteriaBuilder criteriaBuilder, From<Z, X> from, String fieldName, Object value, Annotation annotation) {
        return criteriaBuilder.or(super.buildLikePatternPredicate(criteriaBuilder, from, fieldName, value));
    }

}
