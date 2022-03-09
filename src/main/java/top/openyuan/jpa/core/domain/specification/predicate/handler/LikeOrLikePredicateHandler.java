package top.openyuan.jpa.core.domain.specification.predicate.handler;

import org.springframework.orm.jpa.JpaOptimisticLockingFailureException;
import top.openyuan.jpa.core.domain.specification.annotation.LikeOrLike;
import top.openyuan.jpa.core.domain.specification.predicate.AbstractPredicateHandler;
import top.openyuan.jpa.core.exceptions.JpaPlusException;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;

/**
 * 构建“多种模糊条件”({@code field1 LIKE '%xx%' OR field2 LIKE '%yyy%'})场景的 {@link Predicate} 处理器.
 *
 * @author lzy
 * @since v1.0.0
 */
public class LikeOrLikePredicateHandler extends AbstractPredicateHandler {

    @Override
    public Class<LikeOrLike> getAnnotation() {
        return LikeOrLike.class;
    }

    @Override
    public <Z, X> Predicate buildPredicate(
            CriteriaBuilder criteriaBuilder, From<Z, X> from, String name, Object value, Annotation annotation) {
        value = value.getClass().isArray() ? Arrays.asList((Object[]) value) : value;
        if (!(value instanceof List)) {
            throw new JpaPlusException(
                    "【Jpa-plus 异常】对【" + name + "】使用【@LikeOrLike】时，属性类型不是数组或者 List 集合！");
        }

        String[] fields = ((LikeOrLike) annotation).fields();
        List<?> values = (List<?>) value;
        if (fields.length != values.size()) {
            throw new JpaPlusException(
                    "【Jpa-plus 异常】对【" + name + "】使用【@LikeOrLike】时，注解上【fields】长度和字段值的大小不同，fileds 长为:【"
                            + fields.length + "】,字段值大小为：【" + values.size() + "】.");
        }

        return criteriaBuilder.and(criteriaBuilder.or(
                super.buildLikeOrLikePredicates(criteriaBuilder, from, fields, values).toArray(new Predicate[0])));
    }

    @Override
    public Predicate buildPredicate(
            CriteriaBuilder criteriaBuilder, From<?, ?> from, String fieldName, Object value) {
        throw new JpaPlusException("不支持本方法.");
    }

}
