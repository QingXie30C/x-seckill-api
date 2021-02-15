package com.qinxie.seckill.common.msg;

import com.qinxie.seckill.common.consts.ResponseConst;
import lombok.Data;

/**
 * @auther qinxie30c
 * @date 2021/2/10 3:36 下午
 * @desc:
 */
@Data
public class ResponseMsgObj implements ResponseMsg {
    private int code;
    private String msg;
    private Object data;

    public ResponseMsgObj() {
        this.code = ResponseConst.SUCCESS_CODE;
        this.msg = ResponseConst.SUCCESS_CODE_MSG;
        this.data = new Object();
    }

    @Override
    public void setErroCode(int code) {
      this.code = code;
    }

    @Override
    public void setErrorMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public void setData(Object obj){
       this.data = obj;
    }

}
