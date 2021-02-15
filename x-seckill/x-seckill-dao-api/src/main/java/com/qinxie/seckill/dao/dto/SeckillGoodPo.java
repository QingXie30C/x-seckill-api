package com.qinxie.seckill.dao.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @auther qinxie30c
 * @date 2021/2/10 10:02 上午
 * @desc:
 *   秒杀的物品表
 */
@Data
public class SeckillGoodPo {
    /**
     * 商品ID
     **/
   private long id;


    /**
     * 商品标题
     */
   private String goodTitle;

    /**
     * 商品描述
     */
   private String goodDesc;

    /**
     * 商品价格
     */
   private BigDecimal goodPrice;


    /**
     * 商品秒杀价
     */
   private BigDecimal goodDiscountPrice;

    /**
     * 商品创建时间
     */
   private Date createTime;

    /**
     * 开始秒杀时间
     */
   private Date startSeckillTime;

    /**
     * 秒杀结束时间
     */
   private Date endSeckillTime;

    /**
     * 秒杀商品的剩余库存量
     */
   private Integer stockCount;

    /**
     * 原始商品的库存量
     */
   private Integer stockRawCount;


}
