package com.qinxie.seckill.service.biz.impl;

import com.alibaba.fastjson.JSON;
import com.qinxie.seckill.common.exception.BizException;
import com.qinxie.seckill.dao.dto.SeckillGoodPo;
import com.qinxie.seckill.dao.dto.SeckillOrderPo;
import com.qinxie.seckill.dao.mapper.SeckillOrderMapper;
import com.qinxie.seckill.dao.service.SeckillGoodOrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @auther qinxie30c
 * @date 2021/2/10 11:26 上午
 * @desc:
 */

@Slf4j
@Service
public class SeckillGoodOrderServiceImpl implements SeckillGoodOrderService {

    private final String REDIS_SECKILL_GOOD_LOCK_STR="1000::x-seckill::seckill-good::lock";
    private final static String REDIS_GOOD_TABLE_STR="1000::x-seckill::seckill-good";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private SeckillOrderMapper seckillOrderMapper;


    /**
     *  //查询是否有足够的数量的商品
     *  //存在则下单
     *  //库存不足则不允许下单
     *  思考： 如何解决由于异常导致的商品少卖的问题。
     * @param entity
     * @return
     */
    @Override
    public int insert(SeckillOrderPo entity) {
       int inserStatus=-1;
       try{

           Object goodObj = stringRedisTemplate.opsForHash().get(REDIS_GOOD_TABLE_STR,entity.getGoodId());
           if(ObjectUtils.equals(goodObj,null)){
               throw new BizException("1","业务异常");
           }
           SeckillGoodPo seckillGoodPo = JSON.parseObject(goodObj.toString(), SeckillGoodPo.class);
           if(seckillGoodPo.getStockCount()>entity.getGoodCount()){
               seckillGoodPo.setStockCount(seckillGoodPo.getStockCount()-entity.getGoodCount());
           }else{
               throw new BizException("1","业务异常");
           }
           //更新redis
           stringRedisTemplate.opsForHash().put(REDIS_GOOD_TABLE_STR,entity.getGoodId(),JSON.toJSONString(entity));

           inserStatus = seckillOrderMapper.insertEntity(entity);
           if(inserStatus<1){
               //redis 商品减成功了，但是下单失败了
           }
       }catch (BizException biz){
           log.error(biz.getMsg(),biz);
       }
       catch (Exception ex){
          log.error(ex.getMessage(),ex);
          //需要补偿机制
       }
       return inserStatus;
    }

    @Override
    public SeckillOrderPo findOrderByGoodAndUserId(String goodId, String userId) {
        return null;
    }
}
