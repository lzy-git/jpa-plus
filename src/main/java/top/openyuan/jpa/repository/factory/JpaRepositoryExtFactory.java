package top.openyuan.jpa.repository.factory;

import top.openyuan.jpa.repository.SimpleJpaRepositoryExt;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.core.RepositoryMetadata;

import javax.persistence.EntityManager;

/**
 * 扩展了 {@link JpaRepositoryFactory} JPA 规范类的 的 Repository 工厂类.
 * <p>该类主要重写了 {@link #getQueryLookupStrategy} 方法，
 *
 * @author lzy
 * @since v1.0.0
 */
public class JpaRepositoryExtFactory extends JpaRepositoryFactory {
    /**
     * 创建 {@link JpaRepositoryFactory} 实例.
     *
     * @param entityManager must not be {@literal null}
     */
    public JpaRepositoryExtFactory(EntityManager entityManager) { super(entityManager); }

    /**
     * 获取 Repository 的实现基类，这里使用 FastJpa 中的 {@link SimpleJpaRepositoryExt} 类.
     *
     * @param metadata 元数据
     * @return {@link SimpleJpaRepositoryExt} 类
     */
    @Override
    protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
        return SimpleJpaRepositoryExt.class;
    }
}

