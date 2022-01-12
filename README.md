# SpringMVC

## 简介

### 什么是 MVC

 一种软件架构思想，将软件按照 **模型，视图，控制器** 来划分

M：Model，模型层，指的是工程中的 JavaBean，用来处理/存储数据，一般分为两种

1. 实体类 Bean：专门用来存储业务数据，如 Student，User 等
2. 业务处理类 Bean：指 Service / Dao 对象，专门用于处理业务逻辑和数据访问

V：View，视图层，指工程种的 html / jsp 等页面，作用是与用户进行交互，展示数据

C：Controller，控制层，指工程种的 servlet ，作用是接收和响应请求

> MVC 工作流程

用户通过 View(视图层) 发送请求到服务器，在服务器种请求被 Controller(控制层) 接收，Controller 调用相应的 Model 层处理请求，处理完毕后将结果返回给 Controller，Controller 再根据请求处理结果找到相应的 View 视图，渲染数据后最终响应给服务器

### 什么是 SpringMVC

SpringMVC 是 Spring 的一个后续产品，是 Spring 的一个子项目

SpringMVC 是 Spring 为**表述层**提供的一整套完备的解决方案，是目前业界的主流

> 注：三层架构分为表述层，业务逻辑层，数据访问层；其中表述层表示前台页面和后台 servlet

### SpringMVC 的特点

- Spring 家族原生产品，与 IOC 容器等基础设施无缝对接
- 基于**原生的 servlet**，通过功能强大的**前端控制器 DispatcherServlet**，对请求和响应进行统一处理
- 社区生态活跃度高，对于各细分领域需要解决的问题全方位覆盖，提供全面解决方案
- 代码清新简洁，大幅度提高开发效率
- 内部组件化程度高，可插拔式即插即用，想要什么功能配置添加相应组件即可
- **性能卓越**，适合现代大型，超大型互联网项目要求

## HelloWorld

### 创建 Maven 项目

1. 新建项目

   ![image-20220111151542289](README.assets/image-20220111151542289.png)

2. 导入依赖

   ```xml
   <!-- 修改打包方式 -->
   <packaging>war</packaging>
   
   <dependencies>
       <!-- SpringMVC -->
       <dependency>
           <groupId>org.springframework</groupId>
           <artifactId>spring-webmvc</artifactId>
           <version>5.3.14</version>
       </dependency>
   
       <!-- 日志 -->
       <dependency>
           <groupId>ch.qos.logback</groupId>
           <artifactId>logback-classic</artifactId>
           <version>1.2.10</version>
       </dependency>
   
       <!-- Servlet API -->
       <dependency>
           <groupId>javax.servlet</groupId>
           <artifactId>javax.servlet-api</artifactId>
           <version>3.1.0</version>
           <!-- provided：该依赖已被服务器提供给，不会参与打包 -->
           <scope>provided</scope>
       </dependency>
   
       <!-- Spring5 整合 Thymeleaf -->
       <dependency>
           <groupId>org.thymeleaf</groupId>
           <artifactId>thymeleaf-spring5</artifactId>
           <version>3.0.14.RELEASE</version>
       </dependency>
   </dependencies>
   ```

3. 在 `src/main`文件夹下创建 `webapps`目录，然后创建 `web.xml`文件

   ![image-20220111152916450](README.assets/image-20220111152916450.png)

### 配置 web.xml

> 通过 `web.xml` 配置核心控制器 DispatcherServlet 激活 SpringMVC

#### 默认配置方式

如果采用该配置方式，就需要在 `webapp` 下创建注册 DispatcherServlet 时使用的 `<servlet-name>` 加上 `-servlet.xml` 文件

```xml


<servlet>
    <servlet-name>SpringMVC</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
</servlet>

<servlet-mapping>
    <servlet-name>SpringMVC</servlet-name>
    <!--
    	/: 表示拦截除了 *.jsp 外的所有请求
        /*: 表示拦截所有请求
    -->
    <url-pattern>/</url-pattern>
</servlet-mapping>

```

以上述为例，就需要在 `webapp`下创建 **SpringMVC-servlet.xml** 作为 SpringMVC 的配置文件

#### 扩展配置方式

通过 `<init-param>`指定 SpringMVC 配置文件的位置和名称

```xml
<init-param>
    <param-name>contextConfigLocation</param-name>
    <!-- 指定在 main/resources 目录下 -->
    <param-value>classpath:spring-mvc.xml</param-value>
</init-param>

<!-- 将 Dispatcher 初始化时间修改到服务器启动时 -->
<load-on-startup>1</load-on-startup>
```

在 `main/resources`创建对应的配置文件即可

![image-20220111154725024](README.assets/image-20220111154725024.png)



### 访问首页

1. 创建控制器组件

   ```java
   @Controller
   public class HelloController {
   
       @RequestMapping("/")
       public String index(){
           return "index";
       }
   
   }
   ```

2. 在 `spring-mvc.xml`中配置组件扫描和 Thymeleaf 视图解析器

   ```xml
   <!-- 配置组件扫描 -->
   <context:component-scan base-package="pers.prover07.mvc"/>
   
   <!-- 配置视图解析器 -->
   <bean id="viewResolver"
   class="org.thymeleaf.spring5.view.ThymeleafViewResolver">
       <property name="order" value="1" />
       <property name="characterEncoding" value="UTF-8" />
       <property name="templateEngine">
           <bean class="org.thymeleaf.spring5.SpringTemplateEngine">
               <property name="templateResolver">
                   <bean class="org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver">
                       <!-- 视图前缀 -->
                       <property name="prefix" value="/WEB-INF/templates/" />
                       <!-- 视图后缀 -->
                       <property name="suffix" value=".html" />
                       <property name="templateMode" value="HTML5" />
                       <property name="characterEncoding" value="UTF-8" />
                   </bean>
               </property>
           </bean>
       </property>
   </bean>
   ```

3. 在 `/WEB-INF/templates/` 下创建 `index.html`文件

   注意：文件名应该为控制器中请求方法返回的字符串(也成为视图名)，该视图名最后会经过视图解析器得到 `/WEB-INF/templates/视图名.html`

4. 配置 Tomcat 进行启动

   ![image-20220111204216567](README.assets/image-20220111204216567.png)

5. 测试访问

   ![image-20220111204236824](README.assets/image-20220111204236824.png)

### 访问指定页面

1. 在页面中通过 thymeleaf 语法访问页面

   ```html
   <!-- 效果和 '/上下文路径/target' 一致，但由于上下文路径可能会改变，所以使用 th:href 即可 -->
   <a th:href="@{/target}">访问指定页面 target.html</a>
   ```

2. 配置控制器接口

   ```java
   @RequestMapping("/target")
   public String toTarget() {
       return "target";
   }
   ```

3. 别忘记在 `/WEB-INF/templates/` 下创建 `target.html`页面

   ![image-20220112144637739](README.assets/image-20220112144637739.png)

### 总结

![image-20220112145530712](README.assets/image-20220112145530712.png)

## Restful

## 执行流程

## 注解配置

## 扩展功能