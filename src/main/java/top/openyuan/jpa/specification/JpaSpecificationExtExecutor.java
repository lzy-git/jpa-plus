package top.openyuan.jpa.specification;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import top.openyuan.jpa.specification.predicate.FastPredicate;

import java.util.List;
import java.util.Optional;

/**
 * Fenix 中继承自 Spring Data JPA 中 {@link JpaSpecificationExecutor} 接口，
 * 允许基于 JPA {@code criteria} API 执行 {@link Specification} 的接口，用于扩展其中的一些 API.
 *
 * @author lzy on 2021-11-15
 * @since v1.0.0
 */
public interface JpaSpecificationExtExecutor<T> extends JpaSpecificationExecutor<T> {

    /**
     * 基于 {@link FastPredicate} 返回与之匹配的单个对象的 {@link Optional} 实例.
     *
     * @param fastPredicate Fenix 中用于动态构造 {@link javax.persistence.criteria.Predicate} 条件的接口
     * @return 不可能是 {@literal null}.
     * @throws org.springframework.dao.IncorrectResultSizeDataAccessException 如果找到多个实例时抛出此异常.
     */
    default Optional<T> findOne(FastPredicate fastPredicate) {
        return this.findOne(FastSpecification.of(fastPredicate));
    }

    /**
     * 基于有注解的实体 Bean 返回与之匹配的单个对象的 {@link Optional} 实例.
     *
     * @param beanParam 有 Fenix 注解的实体 Bean
     * @return 不可能是 {@literal null}.
     * @throws org.springframework.dao.IncorrectResultSizeDataAccessException 如果找到多个实例时抛出此异常.
     */
    default Optional<T> findOneOfBean(Object beanParam) {
        return this.findOne(FastSpecification.ofBean(beanParam));
    }

    /**
     * 基于 {@link FastPredicate} 返回与之匹配的所有对象实例的集合.
     *
     * @param fastPredicate Fenix 中用于动态构造 {@link javax.persistence.criteria.Predicate} 条件的接口
     * @return 不可能是 {@literal null}.
     */
    default List<T> findAll(FastPredicate fastPredicate) {
        return this.findAll(FastSpecification.of(fastPredicate));
    }

    /**
     * 基于 {@link FastPredicate} 和 {@link Pageable} 分页信息返回与之匹配的分页对象实例.
     *
     * @param fastPredicate Fenix 中用于动态构造 {@link javax.persistence.criteria.Predicate} 条件的接口
     * @param pageable 分页信息，不能为 {@literal null}.
     * @return 分页结果，不可能是 {@literal null}.
     */
    default Page<T> findAll(FastPredicate fastPredicate, Pageable pageable) {
        return this.findAll(FastSpecification.of(fastPredicate), pageable);
    }

    /**
     * 基于 {@link FastPredicate} 和 {@link Sort} 排序信息返回所有与之匹配的对象实例.
     *
     * @param fastPredicate Fenix 中用于动态构造 {@link javax.persistence.criteria.Predicate} 条件的接口
     * @param sort 排序信息，不能为 {@literal null}.
     * @return 排序结果，不可能是 {@literal null}.
     */
    default List<T> findAll(FastPredicate fastPredicate, Sort sort) {
        return this.findAll(FastSpecification.of(fastPredicate), sort);
    }

    /**
     * 基于有注解的实体 Bean 返回与之匹配的所有对象实例的集合.
     *
     * @param beanParam 有 Fenix 注解的实体 Bean
     * @return 不可能是 {@literal null}.
     */
    default List<T> findAllOfBean(Object beanParam) {
        return this.findAll(FastSpecification.ofBean(beanParam));
    }

    /**
     * 基于有注解的实体 Bean 和 {@link Pageable} 分页信息返回与之匹配的分页对象实例.
     *
     * @param beanParam 有 Fenix 注解的实体 Bean
     * @param pageable 分页信息，不能为 {@literal null}.
     * @return 分页结果，不可能是 {@literal null}.
     */
    default Page<T> findAllOfBean(Object beanParam, Pageable pageable) {
        return this.findAll(FastSpecification.ofBean(beanParam), pageable);
    }

    /**
     * 基于有注解的实体 Bean 和 {@link Sort} 排序信息返回所有与之匹配的对象实例.
     *
     * @param beanParam 有 Fenix 注解的实体 Bean
     * @param sort 排序信息，不能为 {@literal null}.
     * @return 排序结果，不可能是 {@literal null}.
     */
    default List<T> findAllOfBean(Object beanParam, Sort sort) {
        return this.findAll(FastSpecification.ofBean(beanParam), sort);
    }

    /**
     * 基于 {@link FastPredicate} 返回与之匹配的所有对象实例的总数量.
     *
     * @param fastPredicate Fenix 中用于动态构造 {@link javax.persistence.criteria.Predicate} 条件的接口
     * @return 实例数量.
     */
    default long count(FastPredicate fastPredicate) {
        return this.count(FastSpecification.of(fastPredicate));
    }

    /**
     * 基于有注解的实体 Bean 返回与之匹配的所有对象实例的总数量.
     *
     * @param beanParam 有 Fenix 注解的实体 Bean
     * @return 实例数量.
     */
    default long countOfBean(Object beanParam) {
        return this.count(FastSpecification.ofBean(beanParam));
    }

}
