# 数据表结构的设计


## Mysql创建数据结构

````

CREATE SCHEMA `seckilldb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin ;

````

> 秒杀物品表 seckill_good

````
 create table if not exists `seckilldb`.`seckill_good`(
     `id` bigint(20) not null auto_increment comment '物品id主键',
     `good_title` varchar(100) not null comment '商品名称',
     `good_desc` varchar(2000) not null comment '商品描述',
     `good_price` decimal(10,2) not null default 99999.00 comment '商品价格',
     `good_discount_price` decimal(10,2) not null default 99999.00 comment '秒杀价格',
     `create_time` datetime not null comment '上架时间',
     `start_seckill_time` datetime not null comment '开始秒杀时间',
     `end_seckill_time` datetime  not null comment '结束秒杀时间',
     `stock_count` int not null  comment '库存剩余数量',
     `stock_raw_count` int not null  comment '库存原始数量',
     primary key (`id`)
 )ENGINE=InnoDB comment '秒杀物品表';

````
> 秒杀订单 seckill_order
```
   create table if not exists `seckilldb`.`seckill_order`(
      `order_id` varchar(64) not null  comment '订单id，使用snokeflow算法生成',
      `raw_pay_money` decimal(20,2) not null comment '支付的原始金额',
      `real_pay_money` decimal(20,2) not null comment '实际支付金额',
      `user_id` varchar(20) not null comment '参与秒杀的用户Id',
      `create_time` datetime  default current_timestamp,
      `pay_time` datetime comment '支付时间',
      `good_id`  bigint(20) not null comment '秒杀物品的时间',
      `good_count` int default 0 comment '秒杀的商品数据',
      `seckill_type` varchar(2) default '0' comment '活动类型：0: 表示只能抢购一个商品，1: 任意商品数量',
      `order_status` varchar(2) default '0' comment '0：下单成功 1: 支付成功 2:支付失败 3:已退款 4:失效',
      `update_time` datetime default current_timestamp on update current_timestamp comment '更新订单时间',
      primary key(`order_id`),
      index idx_user_id (`user_id`),
      index idx_good_user_id (`good_id`,`user_id`)
   )ENGINE=InnoDB comment '秒杀订单表';

```

## Redis 数据结构

>**tips：首先需要把需要秒杀的商品推到redis中缓存**

#### 商品信息表<appid>::x-seckill::seckill-good
   1.创建redis 表的一般逻辑位 appid + 服务明 + 具体表名.
   
  ````
      #物品表
     hash结构 1000::x-seckill::seckill-good   

  ````
   


