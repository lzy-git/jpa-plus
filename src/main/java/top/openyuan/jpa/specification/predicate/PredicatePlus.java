package top.openyuan.jpa.specification.predicate;

import javax.persistence.criteria.Predicate;
import java.util.List;

/**
 * Jpa-plus 中使用 {@link PredicatePlusBuilder} 构建器来动态构造多个 {@link Predicate} 条件的函数式接口.
 *
 * @author lzy on 2021-11-15
 * @since v1.0.0
 */
@FunctionalInterface
public interface PredicatePlus {

    /**
     * 基于 {@link PredicatePlusBuilder} 对象来动态构造多个 {@link Predicate} 条件的接口方法.
     *
     * @param fenixPredicateBuilder {@link PredicatePlusBuilder} 对象
     * @return {@link Predicate} 集合
     */
    List<Predicate> toPredicate(PredicatePlusBuilder fenixPredicateBuilder);

}
