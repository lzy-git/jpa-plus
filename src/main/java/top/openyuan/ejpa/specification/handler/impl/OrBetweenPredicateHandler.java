package top.openyuan.ejpa.specification.handler.impl;

import top.openyuan.ejpa.specification.annotation.OrBetween;
import top.openyuan.ejpa.specification.handler.AbstractPredicateHandler;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;
import java.lang.annotation.Annotation;

/**
 * 构建“或语句区间匹配条件”({@code AND field BETWEEN ... AND ...})场景的 {@link Predicate} 处理器.
 * 若结束值为空，则退化生成为大于等于的条件，若开始值为空.则退化生成为小于等于的条件，若开始值或结束值都为空，则直接抛出异常.
 *
 * @author lzy
 * @since v1.0.0
 */
public class OrBetweenPredicateHandler extends AbstractPredicateHandler {

    @Override
    public Class<OrBetween> getAnnotation() {
        return OrBetween.class;
    }

    @Override
    public <Z, X> Predicate buildPredicate(
            CriteriaBuilder criteriaBuilder, From<Z, X> from, String fieldName, Object value, Annotation annotation) {
        return criteriaBuilder.or(super.buildBetweenPredicate(criteriaBuilder, from, fieldName, value));
    }

}
