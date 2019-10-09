package com.imooc.sell.utils;

import com.imooc.sell.enums.CodeEnum;

/**
 * @program: sell
 * @description:
 * @author: ma ru
 * @create: 2019-09-11 16:18
 */
public class EnumUtil {
    public static <T extends CodeEnum> T getByCode(Integer code,Class<T> enumClass){
        for (T t : enumClass.getEnumConstants()) {
            if(code.equals(t.getCode())){
                return t;
            }
        }
        return null;
    }
}