package com.qinxie.seckill.dao.mapper;

import com.qinxie.seckill.dao.dto.SeckillGoodPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @auther qinxie30c
 * @date 2021/2/10 10:16 上午
 * @desc:
 *  查询物品的数量
 */
@Mapper
public interface SeckillGoodMapper {
    SeckillGoodPo findGoodById(@Param("id") long id);

    List<SeckillGoodPo> findGoodList();
}
