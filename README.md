# 极速接口文档

#### 介绍
支撑极速中台的基础二方库，是极速项目的基础架构


#### 使用说明

1. 创建Spring Boot项目
2. 引入maven依赖
   ```  
    <dependency>
        <groupId>top.openyuan</groupId>
        <artifactId>fast-data-ejpa</artifactId>
        <version>1.0.0</version>
    </dependency>
   ```
3. 在启动类加注解@EnableFastSwagger2，如：
    ```
   @EnableJpa
   @SpringBootApplication
   public class UserApplication {}
    ```
3. 在Spring Boot的项目配置文件application.yml中添加相应的配置，如：
   ```
    fast.swagger: 
        enable: true #swagger开启配置，true:开启，false:关闭。
        # 配置接口文档具体信息
        info: 
            title: "极速接口文档"
            description: "极速接口文档描述"
            service_url: "http://www.jisuframe.com"
            version: "1.0.0"
   ```

4. 在需要生成接口的contraller的方法上面使用@Api注解，方法上的关键字使用@ApiOperation，如:
   ```
    @Api(tags = {"喵喵用户中心:用户信息服务"})
    public class UserContraller {
        /**
        * 新增用户信息
        *
        * @param userReqDTO 请求对象
        */
        @PostMapping("/save")
        @ApiOperation(value = "新增用户信息", notes = "新增用户信息")
        R save(@RequestBody UserReqDTO userReqDTO){}
    }
   ```

5. 在需要在dto生成参数使用ApiModel注解，属性上的关键字使用@ApiModelProperty，如:
   ```
   @ApiModel(value = "UserReqDTO", description = "用户信息Eo对象")
   public class UserReqDTO {
           
       /**
        * 用户账号
        */
       @ApiModelProperty(name = "userAccount", value = "用户账号")
       private String userAccount;
           
       /**
        * 用户昵称
        */
       @ApiModelProperty(name = "nickName", value = "用户昵称")
       private String nickName;
   }
   ```
  
      
    
#### QQ交流群
    群号：728192592  
    加群链接：https://qm.qq.com/cgi-bin/qm/qr?k=at9Vz5OnLTKIMdPVhpWNj8_CU1I-KXRQ&authKey=L%2FLcDXaWT7SvhqLA4OhzdIplpGf07N%2FgSvbmwFagtGB5o3JYtsgqlLuIqjUQ6vLb&noverify=0&group_code=728192592

#### 参与贡献
1. Fork 本仓库
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request


