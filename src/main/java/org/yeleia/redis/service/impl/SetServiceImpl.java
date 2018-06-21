package org.yeleia.redis.service.impl;

import org.springframework.stereotype.Service;
import org.yeleia.redis.service.SetService;

/**
 * @author yelei
 * @date 18-6-21
 */
@Service
public class SetServiceImpl extends SetService {
    private static final String REDIS_KEY="TEST_REDIS_KEY";
    @Override
    protected String getRedisKey() {
        return this.REDIS_KEY;
    }
}
