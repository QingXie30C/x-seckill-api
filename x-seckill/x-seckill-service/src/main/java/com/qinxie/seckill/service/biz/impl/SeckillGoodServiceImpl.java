package com.qinxie.seckill.service.biz.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qinxie.seckill.dao.dto.SeckillGoodPo;
import com.qinxie.seckill.dao.dto.SeckillOrderPo;
import com.qinxie.seckill.dao.mapper.SeckillGoodMapper;
import com.qinxie.seckill.dao.service.SeckillGoodService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther qinxie30c
 * @date 2021/2/10 11:25 上午
 * @desc:
 * 具体实现逻辑
 */
@Slf4j
@Service
public class SeckillGoodServiceImpl implements SeckillGoodService {

    private final static String REDIS_GOOD_TABLE_STR="1000::x-seckill::seckill-good";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private SeckillGoodMapper seckillGoodMapper;

    @Override
    public SeckillGoodPo findGoodById(long goodId) {
        SeckillGoodPo seckillGoodPo = null;
        try {
            Object goodObj = stringRedisTemplate.opsForHash().get(REDIS_GOOD_TABLE_STR, String.valueOf(goodId));
            if (ObjectUtils.equals(goodObj, null)) {
                //需要查询数据库
                seckillGoodPo = seckillGoodMapper.findGoodById(goodId);
                //需要加锁
                //写入redis
            } else {
                seckillGoodPo = JSON.parseObject(goodObj.toString(),SeckillGoodPo.class);
            }
        }catch (Exception ex){
            log.error(ex.getMessage(),ex);
        }
        return seckillGoodPo;
    }

    /**
     * 查询商品数据
     * 查询多个值时，这个需要进行分页查询
     * @return
     */
    @Override
    public List<SeckillGoodPo> findGoods() {

        return null;
    }
}
