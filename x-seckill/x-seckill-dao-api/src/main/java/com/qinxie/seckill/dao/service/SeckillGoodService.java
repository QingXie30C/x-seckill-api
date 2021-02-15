package com.qinxie.seckill.dao.service;

import com.qinxie.seckill.dao.dto.SeckillGoodPo;

import java.util.List;

/**
 * @auther qinxie30c
 * @date 2021/2/10 10:18 上午
 * @desc:
 */
public interface SeckillGoodService {
    SeckillGoodPo findGoodById(long goodId);
    List<SeckillGoodPo> findGoods();
}
