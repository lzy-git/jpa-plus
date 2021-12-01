package top.openyuan.jpa;

import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.data.repository.config.RepositoryBeanDefinitionRegistrarSupport;
import org.springframework.data.repository.config.RepositoryConfigurationExtension;

import java.lang.annotation.Annotation;

/**
 * {@link EnableJpa} 启用的注册器.
 *
 * @author lzy on 2021/09/22
 * @since v1.0.0
 */
public class JpaRepositoriesRegistrarExt extends RepositoryBeanDefinitionRegistrarSupport {

    @Override
    protected Class<? extends Annotation> getAnnotation() {
        return EnableJpa.class;
    }

    @Override
    protected RepositoryConfigurationExtension getExtension() {
        return new JpaRepositoryConfigExtension();
    }

}

