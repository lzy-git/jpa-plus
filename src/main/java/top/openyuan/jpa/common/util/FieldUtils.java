package top.openyuan.jpa.common.util;

import org.springframework.util.Assert;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 字段操作的相关工具类.
 *
 * @author lzy
 * @since v1.0.0
 */
public class FieldUtils {

    /**
     * 从一个类的 {@code Class} 类中获取所有的 {@link Field} 字段的数组.
     *
     * @param cls {@code Class} 类实例
     * @return 所有的 {@link Field} 字段的数组
     */
    public static Field[] getAllFields(final Class<?> cls) {
        final List<Field> allFieldsList = getAllFieldsList(cls);
        return allFieldsList.toArray(new Field[0]);
    }

    /**
     * 从一个类的 {@code Class} 类中获取所有的 {@link Field} 字段的集合.
     *
     * @param cls {@code Class} 类实例
     * @return 所有的 {@link Field} 字段的 List 集合
     */
    public static List<Field> getAllFieldsList(final Class<?> cls) {
        Assert.notNull(cls, "The class must not be null");
        final List<Field> allFields = new ArrayList<>();
        Class<?> currentClass = cls;
        while (currentClass != null) {
            final Field[] declaredFields = currentClass.getDeclaredFields();
            Collections.addAll(allFields, declaredFields);
            currentClass = currentClass.getSuperclass();
        }
        return allFields;
    }
}
