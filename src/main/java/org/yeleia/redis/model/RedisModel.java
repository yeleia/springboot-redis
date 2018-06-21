package org.yeleia.redis.model;

import java.io.Serializable;

/**
 * @author yelei
 * @date 18-6-20
 */
public class RedisModel implements Serializable {
    private String redisKey;
    private String name;
    private String tel;
    private String address;

    public String getRedisKey() {
        return redisKey;
    }

    public void setRedisKey(String redisKey) {
        this.redisKey = redisKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
