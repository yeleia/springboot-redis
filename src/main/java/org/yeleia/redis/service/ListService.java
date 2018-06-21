package org.yeleia.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author yelei
 * @date 18-6-21
 */
public class ListService {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    private ListOperations<String,Object> listOperations;
}
