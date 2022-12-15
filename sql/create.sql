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
create table id(
	id varchar(100) not null primary key,
    name varchar(40),
    price double,
    category varchar(40),
    pnum int(11),
    imgurl varchar(100),
    description varchar(255)
);
create table orders(
	id varchar(100) not null primary key,
    money double,
    receiverAddress varchar(255),
    receiverName varchar(20),
    receiverPhone varchar(20),
    paystate int(11) default 0,
    ordertime timestamp,
    user_id int(11)
);
create table orderitem(
	order_id varchar(100) not null,
    product_id varchar(100) not null,
    buynum int(11),
    primary key (order_id, product_id)
);
create table notice(
	n_id int not null primary key,
    title varchar(10),
    details varchar(255),
    n_time varchar(18)
)

select * from user;

delete from user where id=0