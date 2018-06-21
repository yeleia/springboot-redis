package org.yeleia.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author yelei
 * @date 18-6-20
 */
public abstract class IRedisService implements Serializable {
    @Autowired
    protected RedisTemplate<String, Object> redisTemplate;
    @Resource
    protected HashOperations<String, String, Object> hashOperations;


    /**
     * 获得redis中的key
     * @return
     */
    protected abstract String getRedisKey();

    /**
     * 添加
     * @param key
     * @param domain
     * @param expire
     */
    public void put(String key, Object domain,long expire){
        hashOperations.put(getRedisKey(),key,domain);
        if (expire!=-1){
            redisTemplate.expire(getRedisKey(),expire, TimeUnit.SECONDS);
        }
    }

    /**
     * 删除
     * @param key
     */
    public void remove(String key){
        hashOperations.delete(getRedisKey(),key);
    }

    /**
     * 查询
     * @param key
     * @return
     */
    public Object get(String key){
        return hashOperations.get(getRedisKey(),key);
    }

    /**
     * 获取当前redis库下所有对象
     * @return
     */
    public List<Object> getAll(){
        return hashOperations.values(getRedisKey());
    }

    /**
     * 查询当前redis库下面所有的key
     * @return
     */
    public Set<String> getKeys(){
        return hashOperations.keys(getRedisKey());
    }

    /**
     * 判断该key是否存在在redis中
     * @param key
     * @return
     */
    public boolean isKeyExists(String key){
        return hashOperations.hasKey(getRedisKey(),key);
    }

    /**
     * 查询当前key下缓存数量
     * @return
     */
    public long count(){
        return hashOperations.size(getRedisKey());
    }

    /**
     *清空redis
     */
    public void empty(){
        Set<String> set=hashOperations.keys(getRedisKey());
        set.stream().forEach(key->hashOperations.delete(getRedisKey(),key));
    }

}

