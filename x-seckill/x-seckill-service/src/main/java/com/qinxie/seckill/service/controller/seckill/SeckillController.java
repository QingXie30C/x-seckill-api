package com.qinxie.seckill.service.controller.seckill;

import com.alibaba.fastjson.JSON;
import com.qinxie.seckill.common.consts.ResponseConst;
import com.qinxie.seckill.common.msg.ResponseMsg;
import com.qinxie.seckill.common.msg.ResponseMsgObj;
import com.qinxie.seckill.dao.dto.SeckillGoodPo;
import com.qinxie.seckill.dao.dto.SeckillOrderPo;
import com.qinxie.seckill.dao.service.SeckillGoodOrderService;
import com.qinxie.seckill.dao.service.SeckillGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @auther qinxie30c
 * @date 2021/2/10 10:38 上午
 * @desc:
 */
@RestController
@RequestMapping(path="/seckill/api")
public class SeckillController {

    @Autowired
    private SeckillGoodService seckillGoodService;

    @Autowired
    private SeckillGoodOrderService seckillGoodOrderService;


    @GetMapping("/hello")
    @ResponseBody
    public ResponseMsg getHello(){
        ResponseMsg responseMsg = new ResponseMsgObj();
        responseMsg.setData("hello");
        return responseMsg;
    }
    /**
     * 获取物品
     * @param goodId
     * @return
     */
    @GetMapping("/good")
    @ResponseBody
    public ResponseMsg getGood(long goodId){
        ResponseMsg responseMsg = new ResponseMsgObj();
        SeckillGoodPo seckillGoodPo = seckillGoodService.findGoodById(goodId);
        responseMsg.setData(JSON.toJSONString(seckillGoodPo));
        return responseMsg;
    }

    @PostMapping("/putOrder")
    @ResponseBody
    public ResponseMsg postOrder(@RequestBody SeckillOrderPo seckillOrderPo){
        ResponseMsg responseMsg = new ResponseMsgObj();
        int status = seckillGoodOrderService.insert(seckillOrderPo);
        if(status == 1){
            responseMsg.setErroCode(ResponseConst.SUCCESS_CODE);
            responseMsg.setErrorMsg(ResponseConst.SUCCESS_CODE_MSG);
            responseMsg.setData(JSON.toJSONString(seckillOrderPo));
        }else {
            responseMsg.setErroCode(ResponseConst.FAIL_CODE);
            responseMsg.setErrorMsg(ResponseConst.FAIL_CODE_MSG);
        }
        return responseMsg;
    }
}
