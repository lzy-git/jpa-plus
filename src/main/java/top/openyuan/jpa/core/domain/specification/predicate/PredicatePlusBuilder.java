package top.openyuan.jpa.core.domain.specification.predicate;

import org.springframework.data.jpa.convert.QueryByExamplePredicateBuilder;
import top.openyuan.jpa.core.domain.specification.handler.AbstractPredicateHandler;
import top.openyuan.jpa.core.domain.specification.handler.PredicateHandler;
import top.openyuan.jpa.core.domain.specification.handler.impl.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Jpa-plus 中用来动态链式构造 {@link Predicate} 实例的构造器.
 *
 * @author lzy on 2021-11-15
 * @since v1.0.0
 */
public class PredicatePlusBuilder {

    /**
     * 动态构建 {@link Predicate} 所需的 {@link CriteriaBuilder} 实例.
     */
    private final CriteriaBuilder criteriaBuilder;

    /**
     * 动态构建 {@link Predicate} 所需的 {@link From} 实例.
     */
    private final From<?, ?> from;

    /**
     * {@link CriteriaQuery} 的查询器实例.
     */
    private final CriteriaQuery<?> criteriaQuery;

    /**
     * 动态条件列表集合，作为构造的最终结果返回.
     */
    private final List<Predicate> predicates;

    /**
     * 构造方法.
     *
     * @param from {@link From} 实例
     * @param criteriaQuery {@code Criteria} 查询器
     * @param criteriaBuilder {@link CriteriaBuilder} 实例
     */
    public PredicatePlusBuilder(From<?, ?> from, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        this.from = from;
        this.criteriaBuilder = criteriaBuilder;
        this.criteriaQuery = criteriaQuery;
        this.predicates = new ArrayList<>();
    }

    /**
     * 结束 {@link Predicate} 的拼接，返回 {@link Predicate} 的 {@code List} 集合.
     *
     * @return {@link Predicate} 实例
     */
    public List<Predicate> build() {
        return this.predicates;
    }

    /**
     * 生成等值查询的 {@link Predicate} 条件.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder andEquals(String fieldName, Object value) {
        this.predicates.add(new EqualsPredicateHandler().buildPredicate(criteriaBuilder, from, fieldName, value));
        return this;
    }

    /**
     * 生成等值查询的 {@link Predicate} 条件，如果 {@code match} 值为 {@code true} 时则生成该条件，否则不生成.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder andEquals(String fieldName, Object value, boolean match) {
        return match ? this.andEquals(fieldName, value) : this;
    }

    /**
     * 生成或语句等值查询的 {@link Predicate} 条件.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder orEquals(String fieldName, Object value) {
        this.predicates.add(new OrEqualsPredicateHandler().buildPredicate(criteriaBuilder, from, fieldName, value));
        return this;
    }

    /**
     * 生成或语句等值查询的 {@link Predicate} 条件，如果 {@code match} 值为 {@code true} 时则生成该条件，否则不生成.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder orEquals(String fieldName, Object value, boolean match) {
        return match ? this.orEquals(fieldName, value) : this;
    }

    /**
     * 生成或语句不等值查询的 {@link Predicate} 条件.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder andNotEquals(String fieldName, Object value) {
        this.predicates.add(new NotEqualsPredicateHandler().buildPredicate(criteriaBuilder, from, fieldName, value));
        return this;
    }

    /**
     * 生成不等值查询的 {@link Predicate} 条件，如果 {@code match} 值为 {@code true} 时则生成该条件，否则不生成.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder andNotEquals(String fieldName, Object value, boolean match) {
        return match ? this.andNotEquals(fieldName, value) : this;
    }

    /**
     * 生成或语句不等值查询的 {@link Predicate} 条件.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder orNotEquals(String fieldName, Object value) {
        this.predicates.add(new OrNotEqualsPredicateHandler().buildPredicate(criteriaBuilder, from, fieldName, value));
        return this;
    }

    /**
     * 生成或语句不等值查询的 {@link Predicate} 条件，如果 {@code match} 值为 {@code true} 时则生成该条件，否则不生成.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder orNotEquals(String fieldName, Object value, boolean match) {
        return match ? this.orNotEquals(fieldName, value) : this;
    }

    /**
     * 生成大于查询的 {@link Predicate} 条件.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder andGreaterThan(String fieldName, Object value) {
        this.predicates.add(new GreaterThanPredicateHandler()
                .buildPredicate(criteriaBuilder, from, fieldName, value));
        return this;
    }

    /**
     * 生成大于查询的 {@link Predicate} 条件，如果 {@code match} 值为 {@code true} 时则生成该条件，否则不生成.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder andGreaterThan(String fieldName, Object value, boolean match) {
        return match ? this.andGreaterThan(fieldName, value) : this;
    }

    /**
     * 生成或语句大于查询的 {@link Predicate} 条件.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder orGreaterThan(String fieldName, Object value) {
        this.predicates.add(new OrGreaterThanPredicateHandler()
                .buildPredicate(criteriaBuilder, from, fieldName, value));
        return this;
    }

    /**
     * 生成或语句大于查询的 {@link Predicate} 条件，如果 {@code match} 值为 {@code true} 时则生成该条件，否则不生成.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder orGreaterThan(String fieldName, Object value, boolean match) {
        return match ? this.orGreaterThan(fieldName, value) : this;
    }

    /**
     * 生成大于等于查询的 {@link Predicate} 条件.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder andGreaterThanEqual(String fieldName, Object value) {
        this.predicates.add(new GreaterThanEqualPredicateHandler()
                .buildPredicate(criteriaBuilder, from, fieldName, value));
        return this;
    }

    /**
     * 生成大于等于查询的 {@link Predicate} 条件，如果 {@code match} 值为 {@code true} 时则生成该条件，否则不生成.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder andGreaterThanEqual(String fieldName, Object value, boolean match) {
        return match ? this.andGreaterThanEqual(fieldName, value) : this;
    }

    /**
     * 生成或语句大于等于查询的 {@link Predicate} 条件.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder orGreaterThanEqual(String fieldName, Object value) {
        this.predicates.add(new OrGreaterThanEqualPredicateHandler()
                .buildPredicate(criteriaBuilder, from, fieldName, value));
        return this;
    }

    /**
     * 生成或语句大于等于查询的 {@link Predicate} 条件，如果 {@code match} 值为 {@code true} 时则生成该条件，否则不生成.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder orGreaterThanEqual(String fieldName, Object value, boolean match) {
        return match ? this.orGreaterThanEqual(fieldName, value) : this;
    }

    /**
     * 生成小于查询的 {@link Predicate} 条件.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder andLessThan(String fieldName, Object value) {
        this.predicates.add(new LessThanPredicateHandler().buildPredicate(criteriaBuilder, from, fieldName, value));
        return this;
    }

    /**
     * 生成小于查询的 {@link Predicate} 条件，如果 {@code match} 值为 {@code true} 时则生成该条件，否则不生成.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder andLessThan(String fieldName, Object value, boolean match) {
        return match ? this.andLessThan(fieldName, value) : this;
    }

    /**
     * 生成或语句小于查询的 {@link Predicate} 条件.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder orLessThan(String fieldName, Object value) {
        this.predicates.add(new OrLessThanPredicateHandler()
                .buildPredicate(criteriaBuilder, from, fieldName, value));
        return this;
    }

    /**
     * 生成或语句小于查询的 {@link Predicate} 条件，如果 {@code match} 值为 {@code true} 时则生成该条件，否则不生成.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder orLessThan(String fieldName, Object value, boolean match) {
        return match ? this.orLessThan(fieldName, value) : this;
    }

    /**
     * 生成小于等于查询的 {@link Predicate} 条件.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder andLessThanEqual(String fieldName, Object value) {
        this.predicates.add(new LessThanEqualPredicateHandler()
                .buildPredicate(criteriaBuilder, from, fieldName, value));
        return this;
    }

    /**
     * 生成小于等于查询的 {@link Predicate} 条件，如果 {@code match} 值为 {@code true} 时则生成该条件，否则不生成.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder andLessThanEqual(String fieldName, Object value, boolean match) {
        return match ? this.andLessThanEqual(fieldName, value) : this;
    }

    /**
     * 生成或语句小于等于查询的 {@link Predicate} 条件.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder orLessThanEqual(String fieldName, Object value) {
        this.predicates.add(new OrLessThanEqualPredicateHandler()
                .buildPredicate(criteriaBuilder, from, fieldName, value));
        return this;
    }

    /**
     * 生成或语句小于等于查询的 {@link Predicate} 条件，如果 {@code match} 值为 {@code true} 时则生成该条件，否则不生成.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder orLessThanEqual(String fieldName, Object value, boolean match) {
        return match ? this.orLessThanEqual(fieldName, value) : this;
    }

    /**
     * 生成区间匹配时的 {@link Predicate} 条件.
     * 若结束值为空，则退化生成为大于等于的条件，若开始值为空.则退化生成为小于等于的条件，若开始值或结束值都为空，则直接抛出异常.
     *
     * @param fieldName 实体属性或数据库字段
     * @param startValue 区间开始值
     * @param endValue 区间结束值
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder andBetween(String fieldName, Object startValue, Object endValue) {
        this.predicates.add(new BetweenPredicateHandler()
                .buildPredicate(criteriaBuilder, from, fieldName, new Object[] {startValue, endValue}));
        return this;
    }

    /**
     * 生成区间匹配时的 {@link Predicate} 条件，如果 {@code match} 值为 {@code true} 时则生成该条件，否则不生成.
     * 若结束值为空，则退化生成为大于等于的条件，若开始值为空.则退化生成为小于等于的条件，若开始值或结束值都为空，则直接抛出异常.
     *
     * @param fieldName 实体属性或数据库字段
     * @param startValue 区间开始值
     * @param endValue 区间结束值
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder andBetween(String fieldName, Object startValue, Object endValue, boolean match) {
        return match ? this.andBetween(fieldName, startValue, endValue) : this;
    }

    /**
     * 生成或语句区间匹配时的 {@link Predicate} 条件.
     * 若结束值为空，则退化生成为大于等于的条件，若开始值为空.则退化生成为小于等于的条件，若开始值或结束值都为空，则直接抛出异常.
     *
     * @param fieldName 实体属性或数据库字段
     * @param startValue 区间开始值
     * @param endValue 区间结束值
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder orBetween(String fieldName, Object startValue, Object endValue) {
        this.predicates.add(new OrBetweenPredicateHandler()
                .buildPredicate(criteriaBuilder, from, fieldName, new Object[] {startValue, endValue}));
        return this;
    }

    /**
     * 生成或语句区间匹配时的 {@link Predicate} 条件，如果 {@code match} 值为 {@code true} 时则生成该条件，否则不生成.
     * 若结束值为空，则退化生成为大于等于的条件，若开始值为空.则退化生成为小于等于的条件，若开始值或结束值都为空，则直接抛出异常.
     *
     * @param fieldName 实体属性或数据库字段
     * @param startValue 区间开始值
     * @param endValue 区间结束值
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder orBetween(String fieldName, Object startValue, Object endValue, boolean match) {
        return match ? this.orBetween(fieldName, startValue, endValue) : this;
    }

    /**
     * 生成区间不匹配时的 {@link Predicate} 条件.
     * 若结束值为空，则退化生成为大于等于的条件，若开始值为空.则退化生成为小于等于的条件，若开始值或结束值都为空，则直接抛出异常.
     *
     * @param fieldName 实体属性或数据库字段
     * @param startValue 区间开始值
     * @param endValue 区间结束值
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder andNotBetween(String fieldName, Object startValue, Object endValue) {
        this.predicates.add(new NotBetweenPredicateHandler()
                .buildPredicate(criteriaBuilder, from, fieldName, new Object[] {startValue, endValue}));
        return this;
    }

    /**
     * 生成区间不匹配时的 {@link Predicate} 条件，如果 {@code match} 值为 {@code true} 时则生成该条件，否则不生成.
     * 若结束值为空，则退化生成为大于等于的条件，若开始值为空.则退化生成为小于等于的条件，若开始值或结束值都为空，则直接抛出异常.
     *
     * @param fieldName 实体属性或数据库字段
     * @param startValue 区间开始值
     * @param endValue 区间结束值
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder andNotBetween(String fieldName, Object startValue, Object endValue, boolean match) {
        return match ? this.andNotBetween(fieldName, startValue, endValue) : this;
    }

    /**
     * 生成或语句区间不匹配时的 {@link Predicate} 条件.
     * 若结束值为空，则退化生成为大于等于的条件，若开始值为空.则退化生成为小于等于的条件，若开始值或结束值都为空，则直接抛出异常.
     *
     * @param fieldName 实体属性或数据库字段
     * @param startValue 区间开始值
     * @param endValue 区间结束值
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder orNotBetween(String fieldName, Object startValue, Object endValue) {
        this.predicates.add(new OrNotBetweenPredicateHandler()
                .buildPredicate(criteriaBuilder, from, fieldName, new Object[] {startValue, endValue}));
        return this;
    }

    /**
     * 生成或语句区间不匹配时的 {@link Predicate} 条件，如果 {@code match} 值为 {@code true} 时则生成该条件，否则不生成.
     * 若结束值为空，则退化生成为大于等于的条件，若开始值为空.则退化生成为小于等于的条件，若开始值或结束值都为空，则直接抛出异常.
     *
     * @param fieldName 实体属性或数据库字段
     * @param startValue 区间开始值
     * @param endValue 区间结束值
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder orNotBetween(String fieldName, Object startValue, Object endValue, boolean match) {
        return match ? this.orNotBetween(fieldName, startValue, endValue) : this;
    }

    /**
     * 生成 {@code LIKE} 模糊查询的 {@link Predicate} 条件.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder andLike(String fieldName, Object value) {
        this.predicates.add(new LikePredicateHandler().buildPredicate(criteriaBuilder, from, fieldName, value));
        return this;
    }

    /**
     * 生成 {@code LIKE} 模糊查询的 {@link Predicate} 条件，如果 {@code match} 值为 {@code true} 时则生成该条件，否则不生成.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder andLike(String fieldName, Object value, boolean match) {
        return match ? this.andLike(fieldName, value) : this;
    }

    /**
     * 生成或语句 {@code LIKE} 模糊查询的 {@link Predicate} 条件.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder orLike(String fieldName, Object value) {
        this.predicates.add(new OrLikePredicateHandler().buildPredicate(criteriaBuilder, from, fieldName, value));
        return this;
    }

    /**
     * 生成或语句 {@code LIKE} 模糊查询的 {@link Predicate} 条件，如果 {@code match} 值为 {@code true} 时则生成该条件，否则不生成.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder orLike(String fieldName, Object value, boolean match) {
        return match ? this.orLike(fieldName, value) : this;
    }

    /**
     * 生成 {@code NOT LIKE} 模糊不匹配查询的 {@link Predicate} 条件.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder andNotLike(String fieldName, Object value) {
        this.predicates.add(new NotLikePredicateHandler().buildPredicate(criteriaBuilder, from, fieldName, value));
        return this;
    }

    /**
     * 生成 {@code NOT LIKE} 模糊不匹配查询的 {@link Predicate} 条件，如果 {@code match} 值为 {@code true} 时则生成该条件，否则不生成.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder andNotLike(String fieldName, Object value, boolean match) {
        return match ? this.andNotLike(fieldName, value) : this;
    }

    /**
     * 生成或语句 {@code OR NOT LIKE} 模糊不匹配查询的 {@link Predicate} 条件.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder orNotLike(String fieldName, Object value) {
        this.predicates.add(new OrNotLikePredicateHandler().buildPredicate(criteriaBuilder, from, fieldName, value));
        return this;
    }

    /**
     * 生成或语句 {@code OR NOT LIKE} 模糊不匹配查询的 {@link Predicate} 条件，如果 {@code match} 值为 {@code true} 时则生成该条件，否则不生成.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder orNotLike(String fieldName, Object value, boolean match) {
        return match ? this.orNotLike(fieldName, value) : this;
    }

    /**
     * 生成 {@code LIKE} 按前缀模糊匹配查询的 {@link Predicate} 条件.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder andStartsWith(String fieldName, Object value) {
        this.predicates.add(new StartsWithPredicateHandler().buildPredicate(criteriaBuilder, from, fieldName, value));
        return this;
    }

    /**
     * 生成 {@code LIKE} 按前缀模糊匹配查询的 {@link Predicate} 条件，如果 {@code match} 值为 {@code true} 时则生成该条件，否则不生成.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder andStartsWith(String fieldName, Object value, boolean match) {
        return match ? this.andStartsWith(fieldName, value) : this;
    }

    /**
     * 生成或语句 {@code LIKE} 按前缀模糊匹配查询的 {@link Predicate} 条件.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder orStartsWith(String fieldName, Object value) {
        this.predicates.add(new OrStartsWithPredicateHandler()
                .buildPredicate(criteriaBuilder, from, fieldName, value));
        return this;
    }

    /**
     * 生成或语句 {@code LIKE} 按前缀模糊匹配查询的 {@link Predicate} 条件，如果 {@code match} 值为 {@code true} 时则生成该条件，否则不生成.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder orStartsWith(String fieldName, Object value, boolean match) {
        return match ? this.orStartsWith(fieldName, value) : this;
    }

    /**
     * 生成 {@code LIKE} 按前缀模糊不匹配查询的 {@link Predicate} 条件.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder andNotStartsWith(String fieldName, Object value) {
        this.predicates.add(new NotStartsWithPredicateHandler()
                .buildPredicate(criteriaBuilder, from, fieldName, value));
        return this;
    }

    /**
     * 生成 {@code LIKE} 按前缀模糊不匹配查询的 {@link Predicate} 条件，如果 {@code match} 值为 {@code true} 时则生成该条件，否则不生成.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder andNotStartsWith(String fieldName, Object value, boolean match) {
        return match ? this.andNotStartsWith(fieldName, value) : this;
    }

    /**
     * 生成或语句 {@code LIKE} 按前缀模糊不匹配查询的 {@link Predicate} 条件.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder orNotStartsWith(String fieldName, Object value) {
        this.predicates.add(new OrNotStartsWithPredicateHandler()
                .buildPredicate(criteriaBuilder, from, fieldName, value));
        return this;
    }

    /**
     * 生成或语句 {@code LIKE} 按前缀模糊不匹配查询的 {@link Predicate} 条件，如果 {@code match} 值为 {@code true} 时则生成该条件，否则不生成.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder orNotStartsWith(String fieldName, Object value, boolean match) {
        return match ? this.orNotStartsWith(fieldName, value) : this;
    }

    /**
     * 生成 {@code LIKE} 按后缀模糊匹配查询的 {@link Predicate} 条件.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder andEndsWith(String fieldName, Object value) {
        this.predicates.add(new EndsWithPredicateHandler().buildPredicate(criteriaBuilder, from, fieldName, value));
        return this;
    }

    /**
     * 生成 {@code LIKE} 按后缀模糊匹配查询的 {@link Predicate} 条件，如果 {@code match} 值为 {@code true} 时则生成该条件，否则不生成.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder andEndsWith(String fieldName, Object value, boolean match) {
        return match ? this.andEndsWith(fieldName, value) : this;
    }

    /**
     * 生成或语句 {@code LIKE} 按后缀模糊匹配查询的 {@link Predicate} 条件.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder orEndsWith(String fieldName, Object value) {
        this.predicates.add(new OrEndsWithPredicateHandler()
                .buildPredicate(criteriaBuilder, from, fieldName, value));
        return this;
    }

    /**
     * 生成或语句 {@code LIKE} 按后缀模糊匹配查询的 {@link Predicate} 条件，如果 {@code match} 值为 {@code true} 时则生成该条件，否则不生成.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder orEndsWith(String fieldName, Object value, boolean match) {
        return match ? this.orEndsWith(fieldName, value) : this;
    }

    /**
     * 生成 {@code LIKE} 按后缀模糊不匹配查询的 {@link Predicate} 条件.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder andNotEndsWith(String fieldName, Object value) {
        this.predicates.add(new NotEndsWithPredicateHandler().buildPredicate(criteriaBuilder, from, fieldName, value));
        return this;
    }

    /**
     * 生成 {@code LIKE} 按后缀模糊不匹配查询的 {@link Predicate} 条件，如果 {@code match} 值为 {@code true} 时则生成该条件，否则不生成.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder andNotEndsWith(String fieldName, Object value, boolean match) {
        return match ? this.andNotEndsWith(fieldName, value) : this;
    }

    /**
     * 生成或语句 {@code LIKE} 按后缀模糊不匹配查询的 {@link Predicate} 条件.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder orNotEndsWith(String fieldName, Object value) {
        this.predicates.add(new OrNotEndsWithPredicateHandler()
                .buildPredicate(criteriaBuilder, from, fieldName, value));
        return this;
    }

    /**
     * 生成或语句 {@code LIKE} 按后缀模糊不匹配查询的 {@link Predicate} 条件，如果 {@code match} 值为 {@code true} 时则生成该条件，否则不生成.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 值
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder orNotEndsWith(String fieldName, Object value, boolean match) {
        return match ? this.orNotEndsWith(fieldName, value) : this;
    }

    /**
     * 生成 {@code LIKE} 按指定模式模糊匹配的 {@link Predicate} 条件.
     *
     * @param fieldName 实体属性或数据库字段
     * @param pattern 匹配的模式字符串
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder andLikePattern(String fieldName, String pattern) {
        this.predicates.add(new LikePatternPredicateHandler()
                .buildPredicate(criteriaBuilder, from, fieldName, pattern));
        return this;
    }

    /**
     * 生成 {@code LIKE} 按指定模式模糊匹配的 {@link Predicate} 条件，如果 {@code match} 值为 {@code true} 时则生成该条件，否则不生成.
     *
     * @param fieldName 实体属性或数据库字段
     * @param pattern 匹配的模式字符串
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder andLikePattern(String fieldName, String pattern, boolean match) {
        return match ? this.andLikePattern(fieldName, pattern) : this;
    }

    /**
     * 生成或语句 {@code LIKE} 按指定模式模糊匹配的 {@link Predicate} 条件.
     *
     * @param fieldName 实体属性或数据库字段
     * @param pattern 匹配的模式字符串
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder orLikePattern(String fieldName, String pattern) {
        this.predicates.add(new OrLikePatternPredicateHandler()
                .buildPredicate(criteriaBuilder, from, fieldName, pattern));
        return this;
    }

    /**
     * 生成或语句 {@code LIKE} 按指定模式模糊匹配的 {@link Predicate} 条件，如果 {@code match} 值为 {@code true} 时则生成该条件，否则不生成.
     *
     * @param fieldName 实体属性或数据库字段
     * @param pattern 匹配的模式字符串
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder orLikePattern(String fieldName, String pattern, boolean match) {
        return match ? this.orLikePattern(fieldName, pattern) : this;
    }

    /**
     * 生成 {@code LIKE} 按指定模式模糊不匹配的 {@link Predicate} 条件.
     *
     * @param fieldName 实体属性或数据库字段
     * @param pattern 匹配的模式字符串
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder andNotLikePattern(String fieldName, String pattern) {
        this.predicates.add(new NotLikePatternPredicateHandler()
                .buildPredicate(criteriaBuilder, from, fieldName, pattern));
        return this;
    }

    /**
     * 生成 {@code LIKE} 按指定模式模糊不匹配的 {@link Predicate} 条件，如果 {@code match} 值为 {@code true} 时则生成该条件，否则不生成.
     *
     * @param fieldName 实体属性或数据库字段
     * @param pattern 匹配的模式字符串
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder andNotLikePattern(String fieldName, String pattern, boolean match) {
        return match ? this.andNotLikePattern(fieldName, pattern) : this;
    }

    /**
     * 生成或语句 {@code LIKE} 按指定模式模糊不匹配的 {@link Predicate} 条件.
     *
     * @param fieldName 实体属性或数据库字段
     * @param pattern 匹配的模式字符串
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder orNotLikePattern(String fieldName, String pattern) {
        this.predicates.add(new OrNotLikePatternPredicateHandler()
                .buildPredicate(criteriaBuilder, from, fieldName, pattern));
        return this;
    }

    /**
     * 生成或语句 {@code LIKE} 按指定模式模糊不匹配的 {@link Predicate} 条件，如果 {@code match} 值为 {@code true} 时则生成该条件，否则不生成.
     *
     * @param fieldName 实体属性或数据库字段
     * @param pattern 匹配的模式字符串
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder orNotLikePattern(String fieldName, String pattern, boolean match) {
        return match ? this.orNotLikePattern(fieldName, pattern) : this;
    }

    /**
     * 生成 {@code IN} 范围匹配的 {@link Predicate} 条件.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 集合
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder andIn(String fieldName, Collection<?> value) {
        this.predicates.add(new InPredicateHandler().buildPredicate(criteriaBuilder, from, fieldName, value));
        return this;
    }

    /**
     * 生成 {@code IN} 范围匹配的 {@link Predicate} 条件，如果 {@code match} 值为 {@code true} 时则生成该条件，否则不生成.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 集合
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder andIn(String fieldName, Collection<?> value, boolean match) {
        return match ? this.andIn(fieldName, value) : this;
    }

    /**
     * 生成 {@code IN} 范围匹配的 {@link Predicate} 条件.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 数组
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder andIn(String fieldName, Object[] value) {
        this.predicates.add(new InPredicateHandler().buildPredicate(criteriaBuilder, from, fieldName, value));
        return this;
    }

    /**
     * 生成 {@code IN} 范围匹配的 {@link Predicate} 条件，如果 {@code match} 值为 {@code true} 时则生成该条件，否则不生成.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 数组
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder andIn(String fieldName, Object[] value, boolean match) {
        return match ? this.andIn(fieldName, value) : this;
    }

    /**
     * 生成或语句 {@code IN} 范围匹配的 {@link Predicate} 条件.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 集合
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder orIn(String fieldName, Collection<?> value) {
        this.predicates.add(new OrInPredicateHandler().buildPredicate(criteriaBuilder, from, fieldName, value));
        return this;
    }

    /**
     * 生成或语句 {@code IN} 范围匹配的 {@link Predicate} 条件，如果 {@code match} 值为 {@code true} 时则生成该条件，否则不生成.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 集合
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder orIn(String fieldName, Collection<?> value, boolean match) {
        return match ? this.orIn(fieldName, value) : this;
    }

    /**
     * 生成或语句 {@code IN} 范围匹配的 {@link Predicate} 条件.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 数组
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder orIn(String fieldName, Object[] value) {
        this.predicates.add(new OrInPredicateHandler().buildPredicate(criteriaBuilder, from, fieldName, value));
        return this;
    }

    /**
     * 生成或语句 {@code IN} 范围匹配的 {@link Predicate} 条件，如果 {@code match} 值为 {@code true} 时则生成该条件，否则不生成.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 数组
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder orIn(String fieldName, Object[] value, boolean match) {
        return match ? this.orIn(fieldName, value) : this;
    }

    /**
     * 生成 {@code AND NOT IN} 范围不匹配的 {@link Predicate} 条件.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 集合
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder andNotIn(String fieldName, Collection<?> value) {
        this.predicates.add(new NotInPredicateHandler().buildPredicate(criteriaBuilder, from, fieldName, value));
        return this;
    }

    /**
     * 生成 {@code AND NOT IN} 范围不匹配的 {@link Predicate} 条件，如果 {@code match} 值为 {@code true} 时则生成该条件，否则不生成.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 集合
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder andNotIn(String fieldName, Collection<?> value, boolean match) {
        return match ? this.andNotIn(fieldName, value) : this;
    }

    /**
     * 生成 {@code AND NOT IN} 范围不匹配的 {@link Predicate} 条件.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 数组
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder andNotIn(String fieldName, Object[] value) {
        this.predicates.add(new NotInPredicateHandler().buildPredicate(criteriaBuilder, from, fieldName, value));
        return this;
    }

    /**
     * 生成 {@code AND NOT IN} 范围不匹配的 {@link Predicate} 条件，如果 {@code match} 值为 {@code true} 时则生成该条件，否则不生成.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 数组
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder andNotIn(String fieldName, Object[] value, boolean match) {
        return match ? this.andNotIn(fieldName, value) : this;
    }

    /**
     * 生成或语句 {@code OR NOT IN} 范围不匹配的 {@link Predicate} 条件.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 集合
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder orNotIn(String fieldName, Collection<?> value) {
        this.predicates.add(new OrNotInPredicateHandler().buildPredicate(criteriaBuilder, from, fieldName, value));
        return this;
    }

    /**
     * 生成或语句 {@code OR NOT IN} 范围不匹配的 {@link Predicate} 条件，如果 {@code match} 值为 {@code true} 时则生成该条件，否则不生成.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 集合
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder orNotIn(String fieldName, Collection<?> value, boolean match) {
        return match ? this.orNotIn(fieldName, value) : this;
    }

    /**
     * 生成或语句 {@code OR NOT IN} 范围不匹配的 {@link Predicate} 条件.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 数组
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder orNotIn(String fieldName, Object[] value) {
        this.predicates.add(new OrNotInPredicateHandler().buildPredicate(criteriaBuilder, from, fieldName, value));
        return this;
    }

    /**
     * 生成或语句 {@code OR NOT IN} 范围不匹配的 {@link Predicate} 条件，如果 {@code match} 值为 {@code true} 时则生成该条件，否则不生成.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 数组
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder orNotIn(String fieldName, Object[] value, boolean match) {
        return match ? this.orNotIn(fieldName, value) : this;
    }

    /**
     * 生成 {@code IS NULL} 是空的 {@link Predicate} 条件.
     *
     * @param fieldName 实体属性或数据库字段
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder andIsNull(String fieldName) {
        this.predicates.add(new IsNullPredicateHandler().buildPredicate(criteriaBuilder, from, fieldName, fieldName));
        return this;
    }

    /**
     * 生成 {@code IS NULL} 是空的 {@link Predicate} 条件，如果 {@code match} 值为 {@code true} 时则生成该条件，否则不生成.
     *
     * @param fieldName 实体属性或数据库字段
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder andIsNull(String fieldName, boolean match) {
        return match ? this.andIsNull(fieldName) : this;
    }

    /**
     * 生成或语句 {@code OR field IS NULL} 是空的 {@link Predicate} 条件.
     *
     * @param fieldName 实体属性或数据库字段
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder orIsNull(String fieldName) {
        this.predicates.add(new OrIsNullPredicateHandler()
                .buildPredicate(criteriaBuilder, from, fieldName, fieldName));
        return this;
    }

    /**
     * 生成或语句 {@code OR field IS NULL} 是空的 {@link Predicate} 条件，如果 {@code match} 值为 {@code true} 时则生成该条件，否则不生成.
     *
     * @param fieldName 实体属性或数据库字段
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder orIsNull(String fieldName, boolean match) {
        return match ? this.orIsNull(fieldName) : this;
    }

    /**
     * 生成 {@code AND field IS NOT NULL} 不是空的 {@link Predicate} 条件.
     *
     * @param fieldName 实体属性或数据库字段
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder andIsNotNull(String fieldName) {
        this.predicates.add(new IsNotNullPredicateHandler()
                .buildPredicate(criteriaBuilder, from, fieldName, fieldName));
        return this;
    }

    /**
     * 生成 {@code AND field IS NOT NULL} 不是空的 {@link Predicate} 条件，如果 {@code match} 值为 {@code true} 时则生成该条件，否则不生成.
     *
     * @param fieldName 实体属性或数据库字段
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder andIsNotNull(String fieldName, boolean match) {
        return match ? this.andIsNotNull(fieldName) : this;
    }

    /**
     * 生成或语句 {@code OR field IS NOT NULL} 不是空的 {@link Predicate} 条件.
     *
     * @param fieldName 实体属性或数据库字段
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder orIsNotNull(String fieldName) {
        this.predicates.add(new OrIsNotNullPredicateHandler()
                .buildPredicate(criteriaBuilder, from, fieldName, fieldName));
        return this;
    }

    /**
     * 生成或语句 {@code OR field IS NOT NULL} 不是空的 {@link Predicate} 条件，如果 {@code match} 值为 {@code true} 时则生成该条件，否则不生成.
     *
     * @param fieldName 实体属性或数据库字段
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder orIsNotNull(String fieldName, boolean match) {
        return match ? this.orIsNotNull(fieldName) : this;
    }

    /**
     * 根据字段、值和 {@link AbstractPredicateHandler} 的子类实例来自定义构造 {@link Predicate} 条件.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 字段条件对应的值
     * @param handler {@link AbstractPredicateHandler} 的子类实例
     * @return 当前的 {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder doAny(String fieldName, Object value, AbstractPredicateHandler handler) {
        this.predicates.add(handler.buildPredicate(criteriaBuilder, from, fieldName, value));
        return this;
    }

    /**
     * 根据字段、值和 {@link AbstractPredicateHandler} 的子类实例来自定义构造 {@link Predicate} 条件.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 字段条件对应的值
     * @param handler {@link AbstractPredicateHandler} 的子类实例
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return 当前的 {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder doAny(
            String fieldName, Object value, AbstractPredicateHandler handler, boolean match) {
        return match ? this.doAny(fieldName, value, handler) : this;
    }

    /**
     * 根据字段、值和 {@link PredicateHandler} 的实现类实例来自定义构造 {@link Predicate} 条件，可使用 {@code Lambda} 表达式.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 字段条件对应的值
     * @param handler {@link PredicateHandler} 的实现类实例，可使用 {@code Lambda} 表达式
     * @return 当前的 {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder doAny(String fieldName, Object value, PredicateHandler handler) {
        this.predicates.add(handler.buildPredicate(criteriaBuilder, from, fieldName, value));
        return this;
    }

    /**
     * 根据字段、值和 {@link PredicateHandler} 的实现类实例来自定义构造 {@link Predicate} 条件，可使用 {@code Lambda} 表达式.
     *
     * @param fieldName 实体属性或数据库字段
     * @param value 字段条件对应的值
     * @param handler {@link PredicateHandler} 的实现类实例，可使用 {@code Lambda} 表达式
     * @param match 是否匹配生成此 {@link Predicate} 条件
     * @return 当前的 {@link PredicatePlusBuilder} 实例
     */
    public PredicatePlusBuilder doAny(String fieldName, Object value, PredicateHandler handler, boolean match) {
        return match ? this.doAny(fieldName, value, handler) : this;
    }

}
