package top.openyuan.jpa.core.util;

import top.openyuan.jpa.core.constant.JpaConfigConstant;
import java.util.Collection;

/**
 * 集合操作相关的工具类.
 *
 * @author lzy
 * @since v1.0.0
 */
public class CollectionUtils {

    /**
     * 判断数组是否不为空.
     *
     * @param array 数组
     * @return 布尔值
     */
    public static boolean isNotEmpty(Object[] array) {
        return array != null && array.length > 0;
    }

    /**
     * 判断集合是否不为空.
     *
     * @param collections 集合
     * @return 布尔值
     */
    public static boolean isNotEmpty(Collection<?> collections) {
        return !isEmpty(collections);
    }

    /**
     * 判断集合是否为空.
     *
     * @param collections 集合
     * @return 布尔值
     */
    public static boolean isEmpty(Collection<?> collections) {
        return collections == null || collections.isEmpty();
    }

    /**
     * 将对象转成数组，如果对象类型是数组或集合，则直接转换，否则将对象用数组来包装.
     *
     * @param obj 对象
     * @param objType 对象类型
     * @return 数组
     */
    public static Object[] toArray(Object obj, int objType) {
        Object[] values;
        switch (objType) {
            case JpaConfigConstant.OBJTYPE_ARRAY:
                values = (Object[]) obj;
                break;
            case JpaConfigConstant.OBJTYPE_COLLECTION:
                values = ((Collection<?>) obj).toArray();
                break;
            default:
                values = new Object[] {obj};
        }
        return values;
    }
}
