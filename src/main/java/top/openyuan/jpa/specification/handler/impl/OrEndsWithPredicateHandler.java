package top.openyuan.jpa.specification.handler.impl;

import top.openyuan.jpa.specification.annotation.OrEndsWith;
import top.openyuan.jpa.specification.handler.AbstractPredicateHandler;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;
import java.lang.annotation.Annotation;

/**
 * 构建“或语句按后缀模糊匹配”({@code OR field LIKE '%xx'})场景的 {@link Predicate} 处理器.
 *
 * @author lzy
 * @since v1.0.0
 */
public class OrEndsWithPredicateHandler extends AbstractPredicateHandler {

    @Override
    public Class<OrEndsWith> getAnnotation() {
        return OrEndsWith.class;
    }

    @Override
    public <Z, X> Predicate buildPredicate(
            CriteriaBuilder criteriaBuilder, From<Z, X> from, String fieldName, Object value, Annotation annotation) {
        return criteriaBuilder.or(super.buildEndsWithPredicate(criteriaBuilder, from, fieldName, value));
    }

}
