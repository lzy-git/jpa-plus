package top.openyuan.jpa.id;

import org.junit.Test;
import top.openyuan.jpa.core.incrementer.DefaultIdentifierGenerator;

/**
 * {@link DefaultIdentifierGenerator} 的单元测试类.
 *
 * @author lzy
 * @since v1.0.0
 */
public class SnowflakeIdGeneratorTest {

    @Test
    public void generate() {
        Long id = (Long) new DefaultIdentifierGenerator().generate(null, null);
        System.out.println(id);
    }
}
