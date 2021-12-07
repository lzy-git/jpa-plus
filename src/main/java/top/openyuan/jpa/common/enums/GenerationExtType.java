package top.openyuan.jpa.common.enums;

import javax.persistence.GeneratedValue;

/**
 * Defines the types of primary key generation strategies.
 *
 * @see GeneratedValue
 * @author lzy
 * @since Java Persistence 1.0
 */
public enum GenerationExtType {
    /**
     * Indicates that the persistence provider must assign
     * primary keys for the entity using an underlying
     * database table to ensure uniqueness.
     */
    SNOWFLAKE("snowflake", "top.openyuan.jpa.id.handler.SnowflakeHandler");

    /**
     * (Optional) The primary key generation strategy
     * that the persistence provider must use to
     * generate the annotated entity primary key.
     */
    private String name;

    /**
     * (Optional) The primary key generation strategy
     * that the persistence provider must use to
     * generate the annotated entity primary key.
     */
    private String strategy;

    GenerationExtType(String name, String strategy){
        this.name = name;
        this.strategy = strategy;
    }
}
