package com.imooc.sell.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @program: sell
 * @description:
 * @author: ma ru
 * @create: 2019-10-08 10:03
 */

@Component
@Slf4j
public class RedisLock {

    @Autowired
    private StringRedisTemplate template;

    public boolean lock(String key,String value){
        if(template.opsForValue().setIfAbsent(key,value)){
            return true;
        }

        String currentValue = template.opsForValue().get(key);
        if (!StringUtils.isEmpty(currentValue)
                && Long.parseLong(currentValue)< System.currentTimeMillis()){
            String oldValue = template.opsForValue().getAndSet(key, value);
            if(!StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue)){
                return true;
            }
        }
        return false;
    }

    public void unlock(String key,String value){
        try {
            String currentValue = template.opsForValue().get(key);
            if(!StringUtils.isEmpty(currentValue)
                    && currentValue.equals(value)){
                template.opsForValue().getOperations().delete(key);
            }
        }catch (Exception e){
            log.error("【Redis分布式锁】解锁异常，{}",e);

        }
    }
}