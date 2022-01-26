package top.openyuan.jpa.core.domain.specification.predicate.handler;

import top.openyuan.jpa.core.domain.specification.annotation.IsNotNull;
import top.openyuan.jpa.core.domain.specification.handler.AbstractPredicateHandler;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;
import java.lang.annotation.Annotation;

/**
 * 构建“不是 NULL 条件”({@code field IS NOT NULL})场景的 {@link Predicate} 处理器.
 *
 * @author lzy
 * @since v1.0.0
 */
public class IsNotNullPredicateHandler extends AbstractPredicateHandler {

    @Override
    public Class<IsNotNull> getAnnotation() {
        return IsNotNull.class;
    }

    @Override
    public <Z, X> Predicate buildPredicate(
            CriteriaBuilder criteriaBuilder, From<Z, X> from, String name, Object value, Annotation annotation) {
        return criteriaBuilder.and(super.buildIsNotNullPredicate(criteriaBuilder, from, value));
    }

}
