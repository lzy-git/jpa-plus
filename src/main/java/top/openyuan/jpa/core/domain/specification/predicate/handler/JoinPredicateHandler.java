package top.openyuan.jpa.core.domain.specification.predicate.handler;

import top.openyuan.jpa.core.domain.specification.SpecificationPlus;
import top.openyuan.jpa.core.domain.specification.predicate.AbstractPredicateHandler;
import top.openyuan.jpa.core.exceptions.JpaPlusException;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import java.lang.annotation.Annotation;

/**
 * 构建“实体连接条件”({@code JOIN})场景的 {@link Predicate} 处理器.
 *
 * @author lzy
 * @since v1.0.0
 */
public class JoinPredicateHandler extends AbstractPredicateHandler {

    @Override
    public Class<top.openyuan.jpa.core.domain.specification.annotation.Join> getAnnotation() {
        return top.openyuan.jpa.core.domain.specification.annotation.Join.class;
    }

    @Override
    public <Z, X> Predicate buildPredicate(
            CriteriaBuilder criteriaBuilder, From<Z, X> from, String name, Object value, Annotation annotation) {
        if (!(annotation instanceof top.openyuan.jpa.core.domain.specification.annotation.Join)) {
            throw new JpaPlusException("【Jpa-plus 异常】使用【@Join】构建表连接时,【" + getClass().getName()
                    + ".getAnnotation()】获取到的值【" + this.getAnnotation().getName() + "】与字段使用的注解值【"
                    + annotation.getClass().getName() + "】不同");
        }

        Join<X, ?> subJoin = from.join(name,
                ((top.openyuan.jpa.core.domain.specification.annotation.Join) annotation).joinType());
        return criteriaBuilder.and(SpecificationPlus.beanParamToPredicate(subJoin, criteriaBuilder, value)
                .toArray(new Predicate[0]));
    }

    @Override
    public Predicate buildPredicate(
            CriteriaBuilder criteriaBuilder, From<?, ?> from, String fieldName, Object value) {
        throw new JpaPlusException("本方法暂不支持.");
    }

}