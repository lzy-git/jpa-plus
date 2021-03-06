# ð¥ JPA-PLUS
[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)
## ð ä¸ãç¹æ§

- ç®åãè½»éçº§ãæ å¯ä½ç¨çéæåä½¿ç¨ï¼jar åä» `192 KB`ï¼
- ä½ä¸º JPA çæ©å±åå¢å¼ºï¼å¼å®¹ Spring Data JPA åæåè½ååç§ç¹æ§ï¼
- å¯ä»¥éç¨ Java é¾å¼ `API` æ¥ä¹¦åå¨æ SQLï¼
- å¯ä»¥éç¨å¨ææ¡ä»¶æ³¨è§£åJava é¾å¼ `API` æ¥ä¹¦ååºå¨æç `Specification`ã
- å¢å¼ºäºæ´å¿«éé«æç JPA æ¹éâå¢å æ¹âçæ¯æï¼æ¯æé `null` å±æ§çå¢éæ´æ°ï¼
- æ¯æ**éªè±ç®æ³**çä¸»é® ID çæç­ç¥ï¼
- å·æå¨ææ§ãæè´çå¯å¤ç¨æ§çä¼ç¹ï¼

## ðï¸ï¸ äºãæ¯æåºæ¯

éç¨äº Java `Spring Data JPA` é¡¹ç®ï¼`JDK 1.8` åä»¥ä¸ï¼Spring Data JPA ççæ¬é¡»ä¿è¯ `2.1.8.RELEASE` åä»¥ä¸ï¼å¦æä½ æ¯ Spring Boot é¡¹ç®ï¼å Spring Boot ççæ¬é¡»ä¿è¯ `2.1.5.RELEASE` åä»¥ä¸ãå ä¸ºåç»­çæ¬ç Spring Data JPA å¯¹å¶ä¸­ `QueryLookupStrategy` çä»£ç æè¾å¤§æ¹å¨ã

## âï¸ ä¸ãSpring Boot é¡¹ç®éæ

å¦æä½ æ¯ Spring Boot é¡¹ç®ï¼é£ä¹ç´æ¥éæ `jpa-plus` åºï¼å¹¶ä½¿ç¨ `@EnableJpaPlus` æ¿æ´» Jpa-plus çç¸å³éç½®ä¿¡æ¯ã

å¦æä½ **ä¸æ¯ Spring Boot é¡¹ç®**ï¼è¯·åç[è¿é](https://blinkfox.github.io/jpa-plus/#/quick-install?id=not-spring-boot-project) çéç½®æ¹å¼ã

> **æ³¨**ï¼è¯·ç¡®ä¿ä½ ä½¿ç¨ç Spring Boot çæ¬æ¯ **`v2.1.5.RELEASE` åä»¥ä¸**ï¼å¦æ Spring Boot çæ¬æ¯ `v2.2.x.RELEASE` åä»¥ä¸ï¼å Jpa-plus çæ¬å¿é¡»æ¯ `v2.0.0` çæ¬åä»¥ä¸ã

### ð¾ 1. Maven

```xml
<dependency>
    <groupId>top.openyuan</groupId>
    <artifactId>jpa-plus</artifactId>
    <version>1.0.4</version>
</dependency>
```

### ðµ 2. Gradle

```bash
implementation 'top.openyuan:jpa-plus:1.0.2'
```

### ðï¸ 3. æ¿æ´» Jpa-plus (@EnableJpaPlus)

ç¶åéè¦å¨ä½ ç Spring Boot åºç¨ä¸­ä½¿ç¨ `@EnableJpaPlus` æ¿æ´» Jpa-plus çç¸å³éç½®ä¿¡æ¯ã

```java
/**
 * è¯·å¨ Spring Boot åºç¨ä¸­æ æ³¨ {code @EnableJpaPlus} æ³¨è§£.
 *
 * @author lzy on 2020-02-01.
 */
@EnableJpaPlus
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
```

> **ð¡ æ³¨**ï¼ 
> 1. `@EnableJpaPlus` æ³¨è§£ä¸­å®è´¨ä¸æ¯ä½¿ç¨çæ¯ `JpaRepositoryExtFactoryBean`ãè `JpaRepositoryExtFactoryBean` ç»§æ¿èª Spring Data JPA é»è®¤ç `JpaRepositoryFactoryBean`ãæä»¥ï¼Jpa-plus ä¸ JPA çåç§æ³¨è§£åç¹æ§å®å¨å¼å®¹ï¼å¹¶æä¾äºæ´å å¼ºå¤§ç `@QueryJpa-plus` æ³¨è§£åå¶ä»æ´å¤å¨æçè½åã
> 2. å¦æä½ æ¯å¤æ°æ®æºï¼åä½ å¯ä»¥æ ¹æ®èªèº«æåµï¼å¨éè¦çæ°æ®æºä¸­ç `@EnableJpaRepositories` æ³¨è§£ä¸­åç¬è®¾ç½® `repositoryFactoryBeanClass` çå¼ä¸ºï¼`Jpa-plusJpaRepositoryFactoryBean.class`ãç¤ºä¾å¦ï¼`@EnableJpaRepositories(repositoryFactoryBeanClass = Jpa-plusJpaRepositoryFactoryBean.class)`ã

### ðï¸ 4. application.yml éç½®ï¼å¯éçï¼

> **æ³¨**ï¼Jpa-plus éç¨äº**çº¦å®ä¼äºéç½®**çæ¹å¼ï¼æä»¥éå¸¸æåµä¸ï¼ä½ å¯ä»¥ä¸ç¨åä»»ä½ç Jpa-plus éç½®ã

å¦æä½ è¦ä¿®æ¹ Jpa-plus çéç½®ä¿¡æ¯ï¼ä½ éè¦å¨ä½ ç Spring Boot é¡¹ç®ä¸­ï¼å¨ `application.yml` æè `application.properties` ä¸­å»ä¿®æ¹éç½®ä¿¡æ¯ã

ä»¥ä¸éè¿ `application.yml` æä»¶æ¥å±ç¤º Jpa-plus ä¸­çå ä¸ªéç½®é¡¹ãé»è®¤å¼åè¯´æä¿¡æ¯ï¼ä¾ä½ åèã

```yaml
# JpaPlus çå ä¸ªéç½®é¡¹ãé»è®¤å¼åè¯¦ç»è¯´æï¼éå¸¸æåµä¸ä½ ä¸éè¦å¡«åè¿äºéç½®ä¿¡æ¯ï¼ä¸é¢çéç½®ä»£ç ä¹é½å¯ä»¥å æï¼.
jpa:

```

## ð åãç¤ºä¾æ¦è§

Jpa-plus ä¸­æ¯æåç§æ¹å¼ä¹¦åå¨æ SQLï¼åå«æ¯ï¼

- åºäº JPQL (æ SQL) ç Java API æ¹å¼
- åºäº `Specification` ç Java API æ¹å¼
- åºäº `Specification` ç Java Bean æ³¨è§£æ¹å¼

ä»¥ä¸çåç§æ¹å¼çç¤ºä¾åä»¥åå®¢ä¿¡æ¯æ°æ®ä½ä¸ºç¤ºä¾ï¼ä½ å¯ä»¥æ ¹æ®èªå·±çåºæ¯æåæ¬¢çæ¹å¼æ¥éæ©å¨ææ¥è¯¢çæ¹å¼ãå³äºè¯¦ç»çä½¿ç¨ææ¡£å¯ä»¥[åçææ¡£](https://blinkfox.github.io/jpa-plus/#/)ã

### 3. ð­ åºäº Specification ç Java API æ¹å¼

åºäº `Specification` çæ¹å¼ï¼åªé¡»è¦ `BlogRepository` æ¥å£ç»§æ¿ `Jpa-plusJpaSpecificationExecutor` æ¥å£å³å¯ã

```java
// JpaRepository<Blog, String> å Jpa-plusJpaSpecificationExecutor<Blog> å¯ä»¥æ··ç¨ï¼ä¹å¯ä»¥åªä½¿ç¨æä¸ä¸ª.
public interface BlogRepository extends JpaRepository<Blog, String>, JpaSpecificationExecutor<Blog> {

}
```

åºäº `Specification` çæ¹å¼ï¼ä¸éè¦å®ä¹é¢å¤çæ¥è¯¢æ¹æ³ï¼ä¹ä¸éè¦å `JPQL` (æ SQL) è¯­å¥ï¼ç®åç´æ¥ãä¸é¢æ¯éè¿ Java é¾å¼ç API æ¹å¼æ¥åååæµè¯çä½¿ç¨æ¹å¼ç¤ºä¾ï¼

```java
/**
 * æµè¯ä½¿ç¨ Jpa-plus ä¸­ç  {@link JpaPlusSpecification} çé¾å¼ Java API æ¥å¨ææ¥è¯¢åå®¢ä¿¡æ¯.
 */
@Test
public void queryBlogsWithSpecifition() {
    // è¿ä¸æ®µä»£ç æ¯å¨æ¨¡ææé åå°ä¼ éæ¥è¯¢çç¸å³ map ååæ°ï¼å½ç¶ä¹å¯ä»¥ä½¿ç¨å¶ä» Java å¯¹è±¡ï¼ä½ä¸ºæ¥è¯¢åæ°.
    Map<String, Object> params = new HashMap<>();
    params.put("ids", new String[]{"1", "2", "3", "4", "5", "6", "7", "8"});
    params.put("author", "ZhangSan");
    params.put("startTime", Date.from(LocalDateTime.of(2019, Month.APRIL, 8, 0, 0, 0)
            .atZone(ZoneId.systemDefault()).toInstant()));
    params.put("endTime", Date.from(LocalDateTime.of(2019, Month.OCTOBER, 8, 0, 0, 0)
            .atZone(ZoneId.systemDefault()).toInstant()));

    // å¼å§çæ­£çæ¥è¯¢ï¼ä½¿ç¨.
    Object[] ids = (Object[]) params.get("ids");
    List<Blog> blogs = blogRepository.findAll(builder ->
            builder.andIn("id", ids, ids != null && ids.length > 0)
                    .andLike("title", params.get("title"), params.get("title") != null)
                    .andLike("author", params.get("author"))
                    .andBetween("createTime", params.get("startTime"), params.get("endTime"))
            .build());

    // ååæµè¯æ­è¨æ¥è¯¢ç»æçæ­£ç¡®æ§.
    Assert.assertEquals(3, blogs.size());
    blogs.forEach(blog -> Assert.assertTrue(blog.getAuthor().endsWith("ZhangSan")));
}
```

### 4. ð¥¯ åºäº Specification ç Java Bean æ³¨è§£æ¹å¼

æ¬æ¹å¼æ¯æéè¿å° Java Bean ä½ä¸ºåæ°ä¼ éï¼å¨ Java Bean å¯¹è±¡çå±æ§ä¸­éè¿æ¥è¯¢çæ¡ä»¶æ³¨è§£æ¥è¡¨ææ¯ä½ç§æ¥è¯¢å¹éæ¹å¼ãå½ç¶ï¼åç¬¬ä¸ç§æ¹å¼ä¸æ ·ï¼`BlogRepository` æ¥å£ä¹é¡»è¦ç»§æ¿ `Jpa-plusJpaSpecificationExecutor` æ¥å£ã

```java
// JpaRepository<Blog, String> å Jpa-plusJpaSpecificationExecutor<Blog> å¯ä»¥æ··ç¨ï¼ä¹å¯ä»¥åªä½¿ç¨æä¸ä¸ª.
public interface BlogRepository extends JpaRepository<Blog, String>, JpaSpecificationExecutor<Blog> {

}
```

ç¶åï¼å®ä¹ä¸ä¸ªç¨äºè¡¨ç¤ºåç§æ¥è¯¢æ¡ä»¶çæ®é Java Bean ç±» `BlogParam`ï¼å½ç¶è¯¥ç±»ä¹å¯ä»¥æ¯åå°ä¼ éè¿æ¥çå¯¹è±¡åæ°ï¼ä¹å¯ä»¥åç¬å®ä¹ãè¯¥ç±»çåä¸ªå±æ§å¯¹åºæä¸ªæ¥è¯¢å­æ®µï¼å±æ§ä¸çæ³¨è§£å¯¹åºæ¥è¯¢çå¹éæ¹å¼ï¼æä¸ªå­æ®µæ¯å¦çææ¥è¯¢æ¡ä»¶çé»è®¤å¤æ­ä¾æ®æ¯è¯¥å±æ§å¼æ¯å¦ä¸ºç©ºã

```java
/**
 * ç¨äºæµè¯ {@code SpecificationPlus} æ³¨è§£å¨ææ¥è¯¢çåå®¢ VO ç±».
 *
 * @author blinkfox on 2020-01-28.
 */
@Getter
@Setter
@Accessors(chain = true)
public class BlogParam {

    /**
     * ç¨äº IN èå´æ¥è¯¢ç ID éåï¼{@link In} æ³¨è§£çå±æ§å¼å¯ä»¥æ¯æ°ç»ï¼ä¹å¯ä»¥æ¯ {@link java.util.Collection} éåæ°æ®.
     */
    @In("id")
    private List<String> ids;

    /**
     * æ¨¡ç³æ¥è¯¢åå®¢ä¿¡æ¯çä½èåç§°å³é®å­åå®¹çå­ç¬¦ä¸².
     */
    @Like
    private String author;

    /**
     * ç¨äºæ ¹æ®åå®¢åå»ºæ¶é´ {@link Between} åºé´æ¥è¯¢åå®¢ä¿¡æ¯çå¼å§å¼åä»ç»å¼ï¼
     * åºé´æ¥è¯¢çå¼ç±»åå»ºè®®æ¯ {@link BetweenValue} ç±»åç.
     * å½ç¶å¼ç±»åä¹å¯ä»¥æ¯äºåæ°ç»ï¼ä¹å¯ä»¥æ¯ {@link List} éåï¼å¦ææ¯è¿ä¸¤ç§ç±»åçå¼ï¼åç´ çé¡ºåºå¿é¡»æ¯å¼å§å¼åç»æå¼æè¡.
     */
    @Between("createTime")
    private BetweenValue<Date> createTime;

}
```

ä¸é¢æ¯ååæµè¯çä½¿ç¨æ¹å¼ç¤ºä¾ï¼

```java
/**
 * æµè¯ä½¿ç¨ Jpa-plus ä¸­ç  {@link SpecificationPlus} ç Java Bean æ¡ä»¶æ³¨è§£çæ¹å¼æ¥å¨ææ¥è¯¢åå®¢ä¿¡æ¯.
 */
@Test
public void queryBlogsWithAnnotaion() {
    // è¿ä¸æ®µä»£ç æ¯å¨æ¨¡ææé åå°ä¼ éçæåç¬å®ä¹ç Java Bean å¯¹è±¡åæ°.
    Date startTime = Date.from(LocalDateTime.of(2019, Month.APRIL, 8, 0, 0, 0)
            .atZone(ZoneId.systemDefault()).toInstant());
    Date endTime = Date.from(LocalDateTime.of(2019, Month.OCTOBER, 8, 0, 0, 0)
            .atZone(ZoneId.systemDefault()).toInstant());
    BlogParam blogParam = new BlogParam()
            .setIds(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8"))
            .setAuthor("ZhangSan")
            .setCreateTime(BetweenValue.of(startTime, endTime));

    // å¼å§çæ­£çæ¥è¯¢.
    List<Blog> blogs = blogRepository.findAllOfBean(blogParam);

    // ååæµè¯æ­è¨æ¥è¯¢ç»æçæ­£ç¡®æ§.
    Assert.assertEquals(3, blogs.size());
    blogs.forEach(blog -> Assert.assertTrue(blog.getAuthor().endsWith("ZhangSan")));
}
```

## ð äºãå¼æºè®¸å¯è¯

æ¬ `Jpa-plus` ç Spring Data JPA æ©å±åºéµå® [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0) è®¸å¯è¯ã

## ð å­ãé¸£è°¢
æè°¢ [Fenix é¡¹ç®](https://github.com/blinkfox/fenix)