package com.springboot.redis.RedisUtil;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * redis 的一些工具类
 * 包括分布式锁
 */
@Slf4j
public class RedisUtils {
    @Resource(name = "stringRedisTemplate")
    private StringRedisTemplate stringRedisTemplate;



   public boolean lock(String key,long timeout,long time){

       String value= String.valueOf(time+timeout);

       if (stringRedisTemplate.opsForValue().setIfAbsent(key,value)){
           return true;
       }

       String currentValue=stringRedisTemplate.opsForValue().get(key);

       //是否超时
       if (!StringUtils.isEmpty(currentValue)&&Long.parseLong(currentValue)<System.currentTimeMillis()){
           String oldValue=stringRedisTemplate.opsForValue().getAndSet(key,value);

           //防止并发
           if (!StringUtils.isEmpty(oldValue)&&oldValue.equals(currentValue)){

               return true;
           }
       }

       return false;

   }

   public void unlock(String key,String timeout,long time){
       String value= String.valueOf(time+timeout);
       try {
           String currentValue =  (String) stringRedisTemplate.opsForValue().get(key);
           if(!StringUtils.isEmpty(currentValue) && currentValue.equals(value) ){
               stringRedisTemplate.opsForValue().getOperations().delete(key);//删除key
           }
       } catch (Exception e) {
           log.error("[Redis分布式锁] 解锁出现异常了，{}",e);
       }

   }


}
