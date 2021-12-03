package top.openyuan.jpa.repository.factory;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;

/**
 * 用来构造 {@link JpaRepositoryExtFactory} 的实例.
 *
 * @author lzy on 2021-09-16.
 * @see RepositoryFactorySupport
 * @since v1.0.0
 */
public class JpaRepositoryExtFactoryBean<T extends Repository<S, ID>, S, ID> extends JpaRepositoryFactoryBean<T, S, ID> {

    /**
     * 用来创建一个新的 {@link JpaRepositoryExtFactoryBean} 实例的构造方法.
     *
     * @param repositoryInterface must not be {@literal null}.
     */
    public JpaRepositoryExtFactoryBean(Class<? extends T> repositoryInterface) {
        super(repositoryInterface);
    }

    /**
     * 返回 {@link JpaRepositoryExtFactory}.
     *
     * @param entityManager EntityManager 实体管理器.
     * @return FastJpaRepositoryFactory 实例
     */
    @Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
        return new JpaRepositoryExtFactory(entityManager);
    }

}

