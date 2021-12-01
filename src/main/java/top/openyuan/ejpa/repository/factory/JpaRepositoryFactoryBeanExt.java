package top.openyuan.ejpa.repository.factory;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;

/**
 * 用来构造 {@link JpaRepositoryFactoryExt} 的实例.
 *
 * @author lzy on 2021-09-16.
 * @see RepositoryFactorySupport
 * @since v1.0.0
 */
public class JpaRepositoryFactoryBeanExt<T extends Repository<S, ID>, S, ID> extends JpaRepositoryFactoryBean<T, S, ID> {

    /**
     * 用来创建一个新的 {@link JpaRepositoryFactoryBeanExt} 实例的构造方法.
     *
     * @param repositoryInterface must not be {@literal null}.
     */
    public JpaRepositoryFactoryBeanExt(Class<? extends T> repositoryInterface) {
        super(repositoryInterface);
    }

    /**
     * 返回 {@link JpaRepositoryFactoryExt}.
     *
     * @param entityManager EntityManager 实体管理器.
     * @return FastJpaRepositoryFactory 实例
     */
    @Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
        return new JpaRepositoryFactoryExt(entityManager);
    }

}

