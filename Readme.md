# Java Web 网络商城——沃德商店

## 概览
本项目参考《Java Web 程序设计教程》，素材绝大部分来自该书资源。

导入的jar包如下；
- c3p0-0.9.5.5.jar
- c3p0-oracle-thin-extras-0.9.5.5.jar
- commons-beantils-1.9.1.jar
- commons-collections-3.2.2.jar
- commons-dbutils-1.7.jar
- commons-logging-1.2.jar
- jstl-1.2.jar
- mail.jar
- activation.jar
- mchange-commons-java-0.2.9.jar
- mysql-connector-java-8.0.30.jar

## 1. 过滤器设计
具体代码查看：cn.mysotre.web.filter.EncodingFilter.java

Filter有四种拦截方式：REQUEST, INCLUDE, FORWARD, ERROR;

使用Filter处理编码的思路：
- response直接使用setContentType()方法;
- 创建MyRequest类处理请求，重写getParameterMap(), getParameterValue(), getParameterValues()方法;
- 若请求使用get方法，确保重新编码只进行一次;
- 若请求使用post方法，直接调用setCharacterEncoding();

## 2. 首页
具体代码查看：
- /web/client/: head.jsp, foot.jsp, menu_search.jsp, menu_search.jsp
- /web/client/js/: autoplay.js, form.js

jsp运行原理：访问jsp文件->生成java源文件->生成字节码文件->调用Servlet->销毁。

生成的Servlet实例常驻内存，多个客户端请求则创建多个线程，提高并发量并缩短响应时间。

jsp参考：https://www.runoob.com/jsp/jsp-tutorial.html

为了了防止重复编写代码，将网页的顶部、底部以及搜索菜单单独抽取成head.jsp, foot.jsp, search_menu.jsp。

## 3. 账号管理模块
### 3.1. 用户注册
用户：src/src/domain.com.eshop.User.java

JDBC：一套用于执行sql的Java API。

JDBC使用流程：DriverManager(加载驱动&创建Connection)->Connection(获取Statement对象)->PreparedStatment(执行sql语句&获取ResultSet)->释放资源

用户注册界面：src/web/client/register.jsp

数据库相关配置：c3p0-config.xml

RegisterServlet用于处理用户注册请求，使用c3p0数据库连接池将表单信息提交到数据库，数据库中创建用户表如下：

```sqk
create table user(
    id int(11) not null primary key,  # 用户id
    username varchar(20) not null,  # 用户名
    password varchar(20) not null,  # 密码
    gender varchar(2),  # 性别
    email varchar(50),  # 邮箱
    telephone varchar(20),  # 电话号码
    introduce varchar(100),  # 简介
    activeCode varchar(50),  # 激活码
    state int(11) default 0,  # 激活状态
    role varchar(10) default "普通用户",  # 用户角色
    registTime timestamp not null  # 注册时间
);
```

邮件使用163邮箱，注意密码部分填写的是授权码。

### 3.2. 用户登录


## 4. 购物车模块

## 5. 查询模块

## 6. 商品管理模块

## 7. 订单管理模块

