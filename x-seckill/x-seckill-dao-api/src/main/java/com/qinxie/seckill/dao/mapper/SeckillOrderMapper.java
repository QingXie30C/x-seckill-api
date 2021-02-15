package com.qinxie.seckill.dao.mapper;

import com.qinxie.seckill.dao.dto.SeckillOrderPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @auther qinxie30c
 * @date 2021/2/10 10:16 上午
 * @desc:
 *  下单支付
 */
@Mapper
public interface SeckillOrderMapper {
    int insertEntity(@Param("entity")SeckillOrderPo entity);
}
