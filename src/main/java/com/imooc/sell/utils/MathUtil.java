package com.imooc.sell.utils;

import org.hibernate.loader.custom.Return;
import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * @program: sell
 * @description:
 * @author: ma ru
 * @create: 2019-09-10 15:54
 */
public class MathUtil {

    private static final Double MONEY_RANGE = 0.01;

    public static Boolean equals(Double d1,Double d2){
        Double abs = Math.abs(d1 - d2);
        if (abs < MONEY_RANGE){
            return true;
        }else {
            return false;
        }

    }
}