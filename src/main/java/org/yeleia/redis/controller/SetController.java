package org.yeleia.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.yeleia.redis.model.RedisModel;
import org.yeleia.redis.service.impl.SetServiceImpl;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yelei
 * @date 18-6-21
 */
@RestController

public class SetController {
    @Autowired
    private SetServiceImpl setService;

    /**
     * 添加
     * @return
     */
    @RequestMapping(value = "addSet",method = RequestMethod.GET)
    public String addSet(){
        RedisModel redisModel=new RedisModel();
        redisModel.setTel("111111");
        redisModel.setAddress("四川");
        redisModel.setName("yl");
        redisModel.setRedisKey("redis1");
        Set<String> set=new HashSet<>();
        set.add(redisModel.getAddress());
        set.add(redisModel.getName());
        set.add(redisModel.getTel());
        long i=setService.save(redisModel.getRedisKey(),set,-1);
        return String.valueOf(i);
    }

    /**
     * 根据key查询
     * @param key
     * @return
     */
    @RequestMapping(value = "getByKey/{key}",method = RequestMethod.GET)
    public Set<Object> getAll(@PathVariable(value = "key")String key){
        return setService.getAll(key);
    }

    /**
     * 该key集合中是否存在该成员
     * @param
     * @return
     */
    @RequestMapping(value = "ifExsit/{key}/{member}",method = RequestMethod.GET)
    public boolean isExsit(@PathVariable(value = "key")String key,@PathVariable(value = "member")String member){
        return setService.isExiset(key,member);
    }

    /**
     * 从该集合中移除该值
     * @param key
     * @param member
     * @return
     */
    @RequestMapping(value = "remove/{key}/{member}",method = RequestMethod.GET)
    public long remove(@PathVariable(value = "key")String key,@PathVariable(value = "member")String member){
        return setService.remove(key,member);
    }

}
