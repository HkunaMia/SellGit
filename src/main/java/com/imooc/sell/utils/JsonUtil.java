package com.imooc.sell.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import sun.management.GcInfoBuilder;

/**
 * @program: sell
 * @description:
 * @author: ma ru
 * @create: 2019-09-05 16:59
 */
public class JsonUtil {
    public static String toJson(Object object){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}