package top.openyuan.jpa.specification.handler.impl;

import top.openyuan.jpa.specification.annotation.Like;
import top.openyuan.jpa.specification.handler.AbstractPredicateHandler;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;
import java.lang.annotation.Annotation;

/**
 * 构建“模糊条件”({@code field LIKE '%xx%'})场景的 {@link Predicate} 处理器.
 *
 * @author lzy
 * @since v1.0.0
 */
public class LikePredicateHandler extends AbstractPredicateHandler {

    @Override
    public Class<Like> getAnnotation() {
        return Like.class;
    }

    @Override
    public <Z, X> Predicate buildPredicate(
            CriteriaBuilder criteriaBuilder, From<Z, X> from, String fieldName, Object value, Annotation annotation) {
        return criteriaBuilder.and(super.buildLikePredicate(criteriaBuilder, from, fieldName, value));
    }

}
