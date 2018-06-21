package org.yeleia.redis.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yeleia.redis.model.RedisModel;
import org.yeleia.redis.service.impl.RedisServiceImpl;

/**
 * @author yelei
 * @date 18-6-20
 */
@RestController
public class HashController {
    @Autowired
    private RedisServiceImpl service;

    /**
     * 添加数据
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String test(){
        RedisModel model=new RedisModel();
        model.setAddress("四川");
        model.setName("叶磊");
        model.setTel("9090900");
        model.setRedisKey("key01");
        service.put(model.getRedisKey(),model,-1);
        return "success";
    }

    /**
     * 获得所有的key
     * @return
     */
    @RequestMapping(value = "/getKeys",method = RequestMethod.GET)
    public Object getKeys(){
        return service.getKeys();
    }

    /**
     * 根据id查询
     * @param key
     * @return
     */
    @RequestMapping(value = "/get/{key}",method = RequestMethod.GET)
    public Object get(@PathVariable(value = "key")String key){
        return service.get(key);

    }

    /**
     * 根据id删除
     * @param key
     */
   @RequestMapping(value = "/remove/{key}",method = RequestMethod.GET)
    public void remove(@PathVariable(value = "key")String key){
        service.remove(key);
   }

    /**
     * 判断key是否存在
     * @param key
     * @return
     */
   @RequestMapping(value = "/isKeyExists/{key}",method = RequestMethod.GET)
    public String isKeyExist(@PathVariable(value = "key")String key){
        boolean flag=service.isKeyExists(key);
        if (flag){
            return "存在";
        }else {
            return "不存在";
        }
   }

    /**
     * 获取当前缓存的数量
     * @return
     */
   @RequestMapping(value = "/count",method = RequestMethod.GET)
    public Object count(){
        return service.count();
   }

    /**
     * 情况所有key
     */
   @RequestMapping(value = "/empty",method = RequestMethod.GET)
    public void empty(){
        service.empty();
   }
}
