package top.openyuan.jpa.id;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentityGenerator;
import top.openyuan.jpa.id.handler.SnowflakeHandler;

import java.io.Serializable;

/**
 * 默认生成器
 *
 * @author lzy
 * @since v1.0.0
 */
public class SnowflakeIdGenerator extends IdentityGenerator {

    private final SnowflakeHandler snowflakeHandler = new SnowflakeHandler(1L);

    /**
     * 用于生成雪花算法 10 进制 {@code long} 型 ID 的生成方法.
     *
     * @param s {@link SharedSessionContractImplementor} 实体
     * @param obj 对象
     * @return ID 结果
     */
    @Override
    public Serializable generate(SharedSessionContractImplementor s, Object obj) {
        return snowflakeHandler.nextId();
    }
}
