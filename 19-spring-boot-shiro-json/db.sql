
-- 权限表
DROP TABLE IF EXISTS sys_permission;
CREATE TABLE sys_permission (
  permission_id int(11) NOT NULL DEFAULT '0' COMMENT '自定id,主要供前端展示权限列表分类排序使用.',
  menu_code varchar(255) DEFAULT '' COMMENT '归属菜单,前端判断并展示菜单使用,',
  menu_name varchar(255) DEFAULT '' COMMENT '菜单的中文释义',
  permission_url varchar(255) DEFAULT '' COMMENT '权限的代码/通配符,对应代码中@RequiresPermissions 的value',
  permission_name varchar(255) DEFAULT '' COMMENT '本权限的中文释义',
  required_permission tinyint(1) DEFAULT '2' COMMENT '是否本菜单必选权限, 1.必选 2非必选 通常是"列表"权限是必选',
  PRIMARY KEY (permission_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='权限表';

INSERT INTO sys_permission VALUES
(601,'user','用户','user:list','列表',1),
(602,'user','用户','user:add','新增',2),
(603,'user','用户','user:update','修改',2),
(701,'role','角色权限','role:list','列表',1),
(702,'role','角色权限','role:add','新增',2),
(703,'role','角色权限','role:update','修改',2),
(704,'role','角色权限','role:delete','删除',2);

-- 角色表
DROP TABLE IF EXISTS sys_role;
CREATE TABLE sys_role (
  role_id int(11) NOT NULL AUTO_INCREMENT,
  role_name varchar(20) DEFAULT NULL COMMENT '角色名',
  status tinyint(4) default '1' not null COMMENT '是否有效  1有效  2无效',
	create_time datetime not null comment'创建时间',
	update_time datetime null default current_timestamp on update current_timestamp  comment '更新时间',
  PRIMARY KEY (role_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='角色表';

INSERT INTO sys_role VALUES
(1,'管理员','1','2019-06-22 16:24:34','2019-06-22 16:24:52'),
(2,'作家','1','2019-06-22 16:24:34','2019-06-22 16:24:52'),
(3,'程序员','1','2019-06-22 16:28:47','2019-06-22 16:28:47');

-- 角色-权限关联表
DROP TABLE IF EXISTS sys_role_permission;
CREATE TABLE sys_role_permission (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  role_id int(11) DEFAULT NULL COMMENT '角色id',
  permission_id int(11) DEFAULT NULL COMMENT '权限id',
  status tinyint(4) default '1' not null COMMENT '是否有效 1有效     2无效',
	create_time datetime not null comment'创建时间',
	update_time datetime null default current_timestamp on update current_timestamp  comment '更新时间',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色-权限关联表';

INSERT INTO sys_role_permission VALUES
(1,2,602,'1','2019-06-22 16:28:28','2019-06-22 16:28:28'),
(2,2,601,'1','2019-06-22 16:28:28','2019-06-22 16:28:28'),
(3,2,603,'1','2019-06-22 16:28:28','2019-06-22 16:28:28'),
(4,2,703,'1','2019-06-22 16:28:28','2019-06-22 16:28:28'),
(5,2,701,'1','2019-06-22 16:28:28','2019-06-22 16:28:28'),
(6,2,702,'1','2019-06-22 16:28:28','2019-06-22 16:28:28'),
(7,2,704,'1','2019-06-22 16:28:31','2019-06-22 16:28:31'),
(8,3,601,'1','2019-06-22 16:28:47','2019-06-22 16:28:47'),
(9,3,701,'1','2019-06-22 16:28:47','2019-06-22 16:28:47'),
(10,3,702,'1','2019-06-22 16:35:01','2019-06-22 16:35:01'),
(11,3,704,'1','2019-06-22 16:35:01','2019-06-22 16:35:01'),
(12,3,603,'1','2019-06-22 16:35:01','2019-06-22 16:35:01');

-- 用戶-角色关联表
DROP TABLE IF EXISTS sys_user_role;
CREATE TABLE sys_user_role (
  id int(11) NOT NULL AUTO_INCREMENT,
  user_id int(11) DEFAULT NULL COMMENT '角色id',
  role_id int(11) DEFAULT NULL COMMENT '角色id',
  status tinyint(4) default '1' not null COMMENT '是否有效 1有效     2无效',
	create_time datetime not null comment'创建时间',
	update_time datetime null default current_timestamp on update current_timestamp  comment '更新时间',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用戶-角色关联表';

INSERT INTO sys_user_role VALUES
(1,1,2,'1','2019-06-22 16:28:28','2019-06-22 16:28:28'),
(2,1,3,'1','2019-06-22 16:28:28','2019-06-22 16:28:28'),
(3,2,1,'1','2019-06-22 16:28:28','2019-06-22 16:28:28'),
(4,3,2,'1','2019-06-22 16:28:28','2019-06-22 16:28:28'),
(5,3,3,'1','2019-06-22 16:28:28','2019-06-22 16:28:28'),
(6,4,2,'1','2019-06-22 16:28:28','2019-06-22 16:28:28'),
(7,5,3,'1','2019-06-22 16:28:31','2019-06-22 16:28:31'),
(8,6,1,'1','2019-06-22 16:28:31','2019-06-22 16:28:31'),
(9,7,1,'1','2019-06-22 16:28:31','2019-06-22 16:28:31'),
(10,7,2,'1','2019-06-22 16:28:31','2019-06-22 16:28:31'),
(11,8,2,'1','2019-06-22 16:28:31','2019-06-22 16:28:31'),
(12,8,3,'1','2019-06-22 16:28:31','2019-06-22 16:28:31');


-- 用户基本信息表
DROP TABLE IF EXISTS sys_user;
CREATE TABLE sys_user (
  user_id int(11) not null auto_increment comment'用户id',
	name varchar(100) not null comment'用户名',
	password varchar(200) not null comment'密码',
	email varchar(200) comment '邮箱',
	gender tinyint(4) comment '性别 1:男 2：女',
	dept_id int(11) not null comment'部门id',
	account_status tinyint(4) default '1' not null comment '账号状态 1:可用，2：禁用',
	description varchar(200) comment'描述',
	create_time datetime not null comment'创建时间',
	update_time datetime null default current_timestamp on update current_timestamp  comment '更新时间',
  PRIMARY KEY (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户基本信息表';

INSERT INTO sys_user VALUES
  (1,'梁兆广','1dafce3d4760d5f90df23a8eb5328f8f','liangzhaoguang@yishouapp.com','1','1','1','我是一只小小鸟','2019-05-15','2019-06-22 16:28:28')
 ,(2,'测试账户','1dafce3d4760d5f90df23a8eb5328f8f','test@yishouapp.com','1','1','1','测试','2019-05-15 16:28:28','2019-06-22 16:28:28')
 ,(3,'开发测试','1dafce3d4760d5f90df23a8eb5328f8f','test@yishouapp.com','1','1','1','测试','2019-05-15 16:28:28','2019-06-22 16:28:28')
 ,(4,'曹南清','1dafce3d4760d5f90df23a8eb5328f8f','test@yishouapp.com','1','1','1','测试','2019-05-15 16:28:28','2019-06-22 16:28:28')
 ,(5,'余苑','1dafce3d4760d5f90df23a8eb5328f8f','test@yishouapp.com','1','1','1','测试','2019-05-15 16:28:28','2019-06-22 16:28:28')
 ,(6,'林俊行','1dafce3d4760d5f90df23a8eb5328f8f','test@yishouapp.com','1','1','1','测试','2019-05-15 16:28:28','2019-06-22 16:28:28')
 ,(7,'林叶','1dafce3d4760d5f90df23a8eb5328f8f','test@yishouapp.com','1','1','1','测试','2019-05-15 16:28:28','2019-06-22 16:28:28')
 ,(8,'李利婷','1dafce3d4760d5f90df23a8eb5328f8f','test@yishouapp.com','1','1','1','测试','2019-05-15 16:28:28','2019-06-22 16:28:28')
;
