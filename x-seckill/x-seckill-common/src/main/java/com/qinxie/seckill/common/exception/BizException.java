package com.qinxie.seckill.common.exception;

import lombok.Data;

/**
 * @auther qinxie30c
 * @date 2021/2/10 10:40 上午
 * @desc:
 */
@Data
public class BizException extends Exception {
    private String code;
    private String msg;

    public BizException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
