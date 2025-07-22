create table tech_manager
(
    id    bigint auto_increment comment '主键'
        primary key,
    name  varchar(255) not null comment '姓名',
    email varchar(255) null comment '邮件',
    major varchar(255) null comment '专业领域',
    area  varchar(255) null comment '擅长领域'
)
    comment '技术经理人(中介) 表格';