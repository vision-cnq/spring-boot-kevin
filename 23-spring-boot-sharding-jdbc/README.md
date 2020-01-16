#SpringBoot集成Sharding-Jdbc（分库分表）

> 面对的请求越来越多，数据库中的表越来越多，单个表的数据也会越来越大，导致我们的系统越来越慢，最终崩溃。
> 
> 原因：
>> 1. 用户请求量越来越大。（方案：将请求分散到多台服务器）。
>> 2. 单库太大。（方案：切分成多个小的库）。
>> 3. 单表太大。（方案：切分成多个小的表）。

## 分库分表：
> 1.垂直分库（纵切）
* 原理：表为依据，按照业务分类将不同的表拆分到不同的库。
* 单个库中结构与数据都不一致，全部库加起来就是全量数据。
> 2.垂直分表（纵切）
* 原理：字段为依据，根据字段活跃性，将字段拆分不同的表。
* 单个表结构与数据都不一致，但每个表之间最少都会有一个关联，一般是主键。
> 3.水平分库（横切）
* 原理：字段为依据，根据hash、range等，将一个库的数据拆分到多个库。
* 单个库结构一样，数据不一样，全部库加起来就是全量数据。
> 4.水平分表（横切）
* 原理：字段为依据，根据hash、range更，将一个表的数据拆分到多个表。
* 单个表结构一样，数据不一样，全部表加起来就是全量数据。
> 5.垂直切分的优点和缺点
* 优点：解决业务的耦合，能对不同业务的数据进行分级管理、维护、监控、扩展等，且能一定程度的提升IO、数据库连接数、单机硬件资源的瓶颈。
* 缺点：部分表无法join，只能聚合处理，分布式事务处理复杂，依旧存在单表数据量过大的问题。
> 6.水平切分的优点和缺点
* 优点：不存在单库数据量过大、高并发的性能瓶颈，提升系统稳定性和负载能力，不需要拆分业务模块。
* 缺点：跨分片事务一致性难以保证，跨库join性能差，数据多次扩展难度和维护量大。


## 分表案例
案例代码在com.kevin.submeter包

### `建表语句`
```sql
USE `sharding_db1`;
DROP TABLE IF EXISTS `tab_user0`;
CREATE TABLE `tab_user0` (
  `id` bigint(32) unsigned NOT NULL COMMENT '主键',
  `name` varchar(64) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(32) DEFAULT NULL COMMENT '性别',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分表测试_0';

USE `sharding_db1`;
DROP TABLE IF EXISTS `tab_user1`;
CREATE TABLE `tab_user1` (
  `id` bigint(32) unsigned NOT NULL COMMENT '主键',
  `name` varchar(64) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(32) DEFAULT NULL COMMENT '性别',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分表测试_1';

USE `sharding_db1`;
DROP TABLE IF EXISTS `tab_user2`;
CREATE TABLE `tab_user2` (
  `id` bigint(32) unsigned NOT NULL COMMENT '主键',
  `name` varchar(64) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(32) DEFAULT NULL COMMENT '性别',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分表测试_2';

```








