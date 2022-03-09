package top.openyuan.jpa.core.config;

import lombok.Getter;
import top.openyuan.jpa.core.domain.specification.predicate.AbstractPredicateHandler;
import top.openyuan.jpa.core.domain.specification.predicate.handler.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Jpa-plus 的默认主配置类.
 *
 * @author lzy
 * @since v1.0.0
 */
public class JpaPlusConfig {
    /**
     * 初始化默认的注解 {@code Class} 和对应处理器实例到 HashMap 集合中，key 是注解 {@code Class}，value 是注解对应的处理器实例.
     */
    @Getter
    private static final Map<Class<?>, AbstractPredicateHandler> specificationHandlerMap = new HashMap<>(64);

    static {
        initDefaultSpecificationHandlers();
    }


    /**
     * 初始化添加默认的注解 {@code Class} 和对应处理器实例到 HashMap 集合中等.
     */
    private static void initDefaultSpecificationHandlers() {
        add(new EqualsPredicateHandler());
        add(new GreaterThanEqualPredicateHandler());
        add(new GreaterThanPredicateHandler());
        add(new InPredicateHandler());
        add(new IsNotNullPredicateHandler());
        add(new IsNullPredicateHandler());
        add(new JoinPredicateHandler());
        add(new LessThanEqualPredicateHandler());
        add(new LessThanPredicateHandler());
        add(new BetweenPredicateHandler());
        add(new NotBetweenPredicateHandler());
        add(new LikeInPredicateHandler());
        add(new LikeOrLikePredicateHandler());
        add(new LikePredicateHandler());
        add(new NotLikePredicateHandler());
        add(new StartsWithPredicateHandler());
        add(new NotStartsWithPredicateHandler());
        add(new EndsWithPredicateHandler());
        add(new NotEndsWithPredicateHandler());
        add(new LikePatternPredicateHandler());
        add(new NotLikePatternPredicateHandler());
        add(new NotEqualsPredicateHandler());
        add(new NotInPredicateHandler());
        add(new OrEqualsPredicateHandler());
        add(new OrGreaterThanEqualPredicateHandler());
        add(new OrGreaterThanPredicateHandler());
        add(new OrInPredicateHandler());
        add(new OrIsNotNullPredicateHandler());
        add(new OrIsNullPredicateHandler());
        add(new OrLessThanEqualPredicateHandler());
        add(new OrLessThanPredicateHandler());
        add(new OrBetweenPredicateHandler());
        add(new OrNotBetweenPredicateHandler());
        add(new OrLikeOrLikePredicateHandler());
        add(new OrLikePredicateHandler());
        add(new OrNotLikePredicateHandler());
        add(new OrNotEqualsPredicateHandler());
        add(new OrNotInPredicateHandler());
        add(new OrStartsWithPredicateHandler());
        add(new OrNotStartsWithPredicateHandler());
        add(new OrEndsWithPredicateHandler());
        add(new OrNotEndsWithPredicateHandler());
        add(new OrLikePatternPredicateHandler());
        add(new OrNotLikePatternPredicateHandler());
    }

    /**
     * 将注解的 {@code class} 作为 key，其对应的 {@link AbstractPredicateHandler} 处理器实例作为 value 存入到 Map 中.
     *
     * @param handler {@link AbstractPredicateHandler} 处理器实例
     */
    public static void add(AbstractPredicateHandler handler) {
        specificationHandlerMap.put(handler.getAnnotation(), handler);
    }
}
