package com.qinxie.seckill.dao.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @auther qinxie30c
 * @date 2021/2/10 10:02 上午
 * @desc:
 *   秒杀的订单表
 */

@Data
public class SeckillOrderPo {

    /**
     * 下单ID
     */
    private String orderId;

    /**
     * 应支付金额
     */
    private BigDecimal rawPayMoney;

    /**
     * 实际支付金额
     */
    private BigDecimal realPayMoney;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 支付时间
     */
    private Date payTime;

    /**
     * 商品ID
     */
    private long goodId;

    /**
     * 物品数量
     */
    private Integer goodCount;

    /**
     * 活动类型
     * 0： 只能抢购一个商品
     * 1： 任意数量的商品
     */
    private String seckilType;

    /**
     * 订单壮体
     */
    private String orderStatus;

    /**
     * 更新时间
     */
    private Date updateTime;

}
