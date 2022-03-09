package top.openyuan.jpa.id;

/**
 * Defines the types of primary key generation strategies.
 *
 * @author lzy
 * @since v1.0.0
 */
public interface GenerationExtType {
    /**
     * Indicates that the persistence provider must assign
     * primary keys for the entity using an underlying
     * database table to ensure uniqueness.
     */
     String SNOWFLAKE = "snowflake";

    /**
     * (Optional) The primary key generation strategy
     * that the persistence provider must use to
     * generate the annotated entity primary key.
     */
     String SNOWFLAKE_STRATEGY = "top.openyuan.jpa.id.SnowflakeIdGenerator";
}
