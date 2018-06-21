package org.yeleia.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;

import javax.annotation.Resource;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author yelei
 * @date 18-6-21
 */
public abstract class SetService {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Resource
    private SetOperations<String,String> setOperations;

    /**
     * 获取redis中的key
     * @return
     */
    protected abstract String getRedisKey();

    /**
     * 添加
     * @param key
     * @param set
     * @param expire
     */
    public  long  save(String key,Set<String> set,long expire){
        long i=setOperations.add(key, String.valueOf(set));
        if (expire!=-1){
            redisTemplate.expire(getRedisKey(),expire, TimeUnit.SECONDS);
        }
        return i;
    }

    /**
     * 根据key查询
     * @param key
     * @return
     */
    public Set<Object> getAll(String key){

        Set<Object> result=redisTemplate.opsForSet().members(key);
        return result;
    }

    /**
     * 该集合中是否存在该值
     * @param key
     * @param member
     * @return
     */
    public boolean isExiset(String key,String member){
        return redisTemplate.opsForSet().isMember(key,member);
    }

    /**
     * 从该集合中移除该值
     * @param key
     * @param member
     * @return
     */
    public long remove(String key,String member){
       return setOperations.remove(key,member);
    }
}
