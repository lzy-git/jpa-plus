package top.openyuan.jpa.core.domain.specification.predicate.handler;

import top.openyuan.jpa.core.domain.specification.annotation.OrStartsWith;
import top.openyuan.jpa.core.domain.specification.predicate.AbstractPredicateHandler;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;
import java.lang.annotation.Annotation;

/**
 * 构建“或语句按前缀模糊匹配”({@code OR field LIKE 'xx%'})场景的 {@link Predicate} 处理器.
 *
 * @author lzy on 2020-01-25
 * @since v1.0.0
 */
public class OrStartsWithPredicateHandler extends AbstractPredicateHandler {

    @Override
    public Class<OrStartsWith> getAnnotation() {
        return OrStartsWith.class;
    }

    @Override
    public <Z, X> Predicate buildPredicate(
            CriteriaBuilder criteriaBuilder, From<Z, X> from, String fieldName, Object value, Annotation annotation) {
        return criteriaBuilder.or(super.buildStartsWithPredicate(criteriaBuilder, from, fieldName, value));
    }

}
