# JavaWeb电商网站课程设计eshop
202030445442 丁志国
项目部署地址 http://43.139.144.10/
测试用账号：用户名text，密码123456（也可在顶部入口自行注册）；管理员名admin，密码1234

# 数据库管理
本项目使用MySQL数据库储存和管理数据，通过C3p0数据源连接数据库，详细配置在/src目录下的c3p0-config.xml文件。表中字段的具体类型等属性可在sql文件查阅。

# 项目页面
项目使用jsp文件来创建动态网页，前台和后台的jsp分开存放在(/web/client)和(web/admin)中已方便区分和实现存取控制。jsp所使用的图片、脚本等资源也存放在对应目录下。本项目使用的部分素材来源于《JavaWeb程序设计任务教程》。

# 项目代码
项目的源码都在(/src)目录下，根据不同的功能和层次将类封装在不同的包中。
实体类封装在com.eshop.domain包中，包括User、Order、Product等类。类包含实体的属性，以及实现返回实体属性的方法。
与数据库交互的类封装在com.eshop.dao包中，包括UserDao、ProductDao等类。这些类负责实现对数据库的增删改查。
服务层的类封装在com.eshop.service包中，包含UserService等类，负责处理请求后再调用dao包中的操作，实现指定的服务。
自定义的异常类封装在com.eshop.exception中，包含使用时常见的错误。
实现存取控制的类封装在com.eshop.tag包中，负责判断对资源的请求是否合法。
实现发送邮件、验证码等功能性的类封装在com.eshop.util包中。
过滤器类封装在com.eshop.web.fliter包中，负责统一全站编码、判断管理员是否有权操作。
网站前台的servlet封装在com.eshop.web.client包中，负责实现用户的操作请求。
管理系统的servlet封装在com.eshop.web.manager包中，负责实现管理员的操作请求。
具体实现请自行查阅
