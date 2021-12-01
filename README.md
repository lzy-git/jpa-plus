# JPA-PLUS文档

#### 介绍
这是 Spring Data JPA 复杂或动态 SQL 查询的扩展库。


#### 使用说明

1. 创建Spring Boot项目
2. 引入maven依赖
   ```  
    <dependency>
        <groupId>top.openyuan</groupId>
        <artifactId>jpa-plus</artifactId>
        <version>1.0.0</version>
    </dependency>
   ```
3. 在启动类加注解@EnableJpa，如：
    ```
   @EnableJpa
   @SpringBootApplication
   public class Application {}
    ```


