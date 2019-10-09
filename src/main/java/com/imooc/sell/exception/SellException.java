package com.imooc.sell.exception;

import com.imooc.sell.enums.ResultEnum;
import lombok.Getter;

/**
 * @program: sell
 * @description:
 * @author: ma ru
 * @create: 2019-08-26 17:46
 */

@Getter
public class SellException extends RuntimeException {
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());

        this .code = resultEnum.getCode();
    }

    public SellException(Integer code,String msg){
        super(msg);
        this.code = code;
    }
}