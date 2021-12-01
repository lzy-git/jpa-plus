package top.openyuan.jpa.specification.handler.impl;

import top.openyuan.jpa.specification.annotation.OrNotLike;
import top.openyuan.jpa.specification.handler.AbstractPredicateHandler;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;
import java.lang.annotation.Annotation;

/**
 * 构建“或者模糊不匹配条件”({@code OR field NOT LIKE '%xx%'})场景的 {@link Predicate} 处理器.
 *
 * @author lzy
 * @since v1.0.0
 */
public class OrNotLikePredicateHandler extends AbstractPredicateHandler {

    @Override
    public Class<OrNotLike> getAnnotation() {
        return OrNotLike.class;
    }

    @Override
    public <Z, X> Predicate buildPredicate(
            CriteriaBuilder criteriaBuilder, From<Z, X> from, String fieldName, Object value, Annotation annotation) {
        return criteriaBuilder.or(super.buildNotLikePredicate(criteriaBuilder, from, fieldName, value));
    }

}
