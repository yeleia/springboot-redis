springboot+redis整合简单操作

添加redis 依赖

    		<dependency>
    			<groupId>org.springframework.boot</groupId>
    			<artifactId>spring-boot-starter-data-redis</artifactId>
    		</dependency>

application.yml

    spring:
      redis:
        host: 10.2.130.94
        port: 6379

redis.properties

    host=10.2.130.94
    port=6379
    connectionTimeout=5000
    soTimeout=5000
    database=0

RedisConfig.class

    @Configuration
    public class RedisConfig {
        @Autowired
        RedisConnectionFactory redisConnectionFactory;
    
        /**
         * 实例化redisTemplate对象
         * @return
         */
        @Bean
        public RedisTemplate<String,Object> functionDomainRedisTemplate(){
            RedisTemplate<String,Object> redisTemplate=new RedisTemplate<>();
            initDomainRedisTemplate(redisTemplate,redisConnectionFactory);
            return redisTemplate;
        }
        private void initDomainRedisTemplate(RedisTemplate<String,Object> redisTemplate,RedisConnectionFactory factory){
            RedisSerializer stringSerializer = new StringRedisSerializer();
      //序列化,一定要进行序列化      redisTemplate.setKeySerializer(stringSerializer);
            redisTemplate.setHashKeySerializer(stringSerializer);
            redisTemplate.setHashValueSerializer(stringSerializer);
            redisTemplate.setValueSerializer(stringSerializer);
            redisTemplate.setConnectionFactory(factory);
        }
    
        /**
         * 实例化hashOperations对象,可以使用hash类型操作
         * @param redisTemplate
         * @return
         */
        @Bean
        public HashOperations<String,String,Object> hashOperations(RedisTemplate<String,Object> redisTemplate){
            return redisTemplate.opsForHash();
        }
    
        /**
         * 初始化valueOperation对象,可以使用String操作
         * @param redisTemplate
         * @return
         */
        @Bean
        public ValueOperations<String,Object> valueOperations(RedisTemplate<String,Object> redisTemplate){
            return redisTemplate.opsForValue();
        }
    
        /**
         * 实例化ListOperations对象,可以使用List操作
         * @param redisTemplate
         * @return
         */
        @Bean
        public ListOperations<String,Object> listOperations(RedisTemplate<String,Object> redisTemplate){
            return redisTemplate.opsForList();
        }
    
        /**
         * 实例化setOperations对象,可以使用set操作
         * @param redisTemplate
         * @return
         */
        @Bean
        public SetOperations<String,Object> setOperations(RedisTemplate<String,Object> redisTemplate){
            return redisTemplate.opsForSet();
        }
    
        /**
         * 实例化zsetOprations对象,可以使用zest操作
         * @param redisTemplate
         * @return
         */
        @Bean
        public ZSetOperations<String ,Object> zSetOperations(RedisTemplate<String,Object> redisTemplate){
            return redisTemplate.opsForZSet();
        }
    }

此类主要是配置redis,实例化redisTemplate并实例化操作对象,如hash,String,set,list,zset类型的操作

具体目录如下



运行时,确保redis是开启的,如果插入时会插入中文,连接时添加 --raw,即 redis-cli --raw








