package com.imooc.sell.utils;

import java.util.Random;

/**
 * @program: sell
 * @description:
 * @author: ma ru
 * @create: 2019-08-26 18:13
 */
public class KeyUtil {
//    生成唯一主键
//    时间+随机数
    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;//生成6位随机数
        return System.currentTimeMillis()+String.valueOf(number);
    }
}