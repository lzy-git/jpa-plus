package top.openyuan.jpa.id;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentityGenerator;
import top.openyuan.jpa.id.snowflake.SnowflakeGenerationStrategy;

import java.io.Serializable;
/**
 * 扩展雪花id生成器，用于扩展 {@link IdentityGenerator} 接口功能.
 *
 * @author lzy
 * @since v1.0.0
 */
public class SnowflakeIdGenerator extends IdentityGenerator {
    /**
     * 用于生成雪花算法 10 进制 {@code long} 型 ID 的生成方法.
     *
     * @param session {@link SharedSessionContractImplementor} 实体
     * @param object 对象
     * @return ID 结果
     */
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        return SnowflakeGenerationStrategy.getInstance(1L).nextId();
    }
}
