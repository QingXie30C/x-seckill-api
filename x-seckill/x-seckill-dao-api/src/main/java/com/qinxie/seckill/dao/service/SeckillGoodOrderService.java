package com.qinxie.seckill.dao.service;


import com.qinxie.seckill.dao.dto.SeckillOrderPo;

/**
 * @auther qinxie30c
 * @date 2021/2/10 10:18 上午
 * @desc:
 */
public interface SeckillGoodOrderService {
   int insert(SeckillOrderPo entity);
   SeckillOrderPo findOrderByGoodAndUserId(String goodId,String userId);
}
