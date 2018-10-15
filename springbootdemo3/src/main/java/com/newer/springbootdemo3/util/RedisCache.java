package com.newer.springbootdemo3.util;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class RedisCache implements Cache{
    //定义日志记录器
    private static Logger logger= LoggerFactory.getLogger(RedisCache.class);

    private final String id;

    //定义缓存数据失效时间为30分钟
    private static final long EXPIRED_CACHE_MINUT=30;

    //用于事务性缓存的读写锁
    private  ReadWriteLock readWriteLock=new ReentrantReadWriteLock();

    //使用redis记录mybatis缓存数据的对象
    private RedisTemplate redisTemplate;

    public RedisCache(String id){
        if(id==null){
            throw new IllegalArgumentException("缓存对象id不能为空!");
        }
        this.id=id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object key, Object value) {
        try {
            RedisTemplate redisTemplate=getRedisTemplate();
            ValueOperations valueOperations=redisTemplate.opsForValue();
            //将查询对象保存到redis
            valueOperations.set(key,value,EXPIRED_CACHE_MINUT, TimeUnit.MINUTES);
            logger.info("缓存对象保存成功!");
        }catch (Throwable t){
            logger.error("缓存对象保存失败!");
        }
    }

    @Override
    public Object getObject(Object key) {
        try {
            RedisTemplate redisTemplate=getRedisTemplate();
            ValueOperations valueOperations=redisTemplate.opsForValue();
            //从redis获取缓存对象
            Object object=valueOperations.get(key);
            logger.info("获取缓存对象成功!");
            return object;
        }catch (Throwable t){
            logger.error("获取缓存对象失败!");
            return null;
        }

    }

    @Override
    public Object removeObject(Object key) {
        try {
            RedisTemplate redisTemplate=getRedisTemplate();
            redisTemplate.delete(key);
            logger.info("删除缓存对象成功!");

        }catch (Throwable t){
            logger.error("删除缓存对象失败!");

        }
        return null;
    }

    @Override
    public void clear() {
        try {
            RedisTemplate redisTemplate=getRedisTemplate();
           redisTemplate.execute((RedisCallback)collections->{
               collections.flushDb();
               return null;
           });
            logger.info("清空缓存对象成功!");

        }catch (Throwable t){
            logger.error("清空缓存对象失败!");

        }

    }

    @Override
    public int getSize() {
        //未实现
        return 0;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return this.readWriteLock;
    }

    private  RedisTemplate getRedisTemplate(){
        //从应用上下文IOC容器获取非单例的redisTemplate实例
        if(redisTemplate==null){
            redisTemplate=ApplicationContextHolder.getBean("redisTemplate");
        }
        return redisTemplate;
    }


}
