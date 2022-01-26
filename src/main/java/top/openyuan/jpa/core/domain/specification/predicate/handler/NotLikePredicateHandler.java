package top.openyuan.jpa.core.domain.specification.predicate.handler;

import top.openyuan.jpa.core.domain.specification.annotation.NotLike;
import top.openyuan.jpa.core.domain.specification.handler.AbstractPredicateHandler;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;
import java.lang.annotation.Annotation;

/**
 * 构建“模糊不匹配条件”({@code field NOT LIKE '%xx%'})场景的 {@link Predicate} 处理器.
 *
 * @author lzy
 * @since v1.0.0
 */
public class NotLikePredicateHandler extends AbstractPredicateHandler {

    @Override
    public Class<NotLike> getAnnotation() {
        return NotLike.class;
    }

    @Override
    public <Z, X> Predicate buildPredicate(
            CriteriaBuilder criteriaBuilder, From<Z, X> from, String fieldName, Object value, Annotation annotation) {
        return criteriaBuilder.and(super.buildNotLikePredicate(criteriaBuilder, from, fieldName, value));
    }

}
