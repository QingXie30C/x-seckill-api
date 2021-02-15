package com.qinxie.seckill.common.msg;

/**
 * @auther qinxie30c
 * @date 2021/2/10 10:43 上午
 * @desc:
 * 响应消息
 */
public interface ResponseMsg {
   /**
    * 设置响应码
    * @param code
    */
   void setErroCode(int code);

   /**
    * 设置消息
    * @param msg
    */
   void setErrorMsg(String msg);

   /**
    * 设置对象
    * @param obj
    */
   void setData(Object obj);
}
