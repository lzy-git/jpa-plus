package top.openyuan.jpa.exception;

/**
 * ejpa 构造 JPA 中的 {@code Specification} 不正确时抛出的异常.
 *
 * @author lzy
 * @since v1.0.0
 */
public class BuildSpecificationException extends RuntimeException {

    private static final long serialVersionUID = -7791731344371081795L;

    /**
     * 附带日志消息组成的构造方法.
     *
     * @param msg 日志消息
     */
    public BuildSpecificationException(String msg) {
        super(msg);
    }

    /**
     * 附带日志消息和可抛出实例信息组成的构造方法.
     *
     * @param message 日志消息
     * @param e 可抛出实例
     */
    public BuildSpecificationException(String message, Throwable e) {
        super(message, e);
    }

}
