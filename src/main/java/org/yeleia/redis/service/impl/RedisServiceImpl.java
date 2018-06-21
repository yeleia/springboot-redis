package org.yeleia.redis.service.impl;

import org.springframework.stereotype.Service;
import org.yeleia.redis.service.IRedisService;

/**
 * @author yelei
 * @date 18-6-20
 */
@Service
public class RedisServiceImpl extends IRedisService {
    private static final String REDIS_KEY="TEST_REDIS_KEY";

    @Override
    protected String getRedisKey() {
        return this.REDIS_KEY;
    }
}
