/**
 *
 */
package com.springboot.config;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import java.nio.charset.Charset;


@Configuration
@Profile("redis-ms")
@SuppressWarnings({"rawtypes", "deprecation", "unchecked"})
public class RedisMasterConfig {
    @Value(value = "${spring.redis.sentinel.master}")
    private String master;
    @Value(value = "${spring.redis.sentinel.nodes}")
    private String redisNodes;
    @Value(value = "${spring.redis.host}")
    private String host;
    @Value(value = "${spring.redis.port}")
    private String port;
    @Value(value = "${spring.redis.timeout}")
    private String timeout;
    @Value(value = "${spring.redis.password}")
    private String password;
    @Value(value = "${spring.redis.database}")
    private String database;
    @Value(value = "${spring.redis.maxIdle}")
    private Integer maxIdle;
    @Value(value = "${spring.redis.minIdle}")
    private Integer minIdle;
    @Value(value = "${spring.redis.maxTotal}")
    private Integer maxTotal;
    @Value(value = "${spring.redis.maxWaitMillis}")
    private Long maxWaitMillis;
    @Value(value = "${spring.redis.minEvictableIdleTimeMillis}")
    private Integer minEvictableIdleTimeMillis;
    @Value(value = "${spring.redis.numTestsPerEvictionRun}")
    private Integer numTestsPerEvictionRun;
    @Value(value = "${spring.redis.timeBetweenEvictionRunsMillis}")
    private Long timeBetweenEvictionRunsMillis;
    @Value(value = "${spring.redis.testOnBorrow}")
    private Boolean testOnBorrow;
    @Value(value = "${spring.redis.testWhileIdle}")
    private Boolean testWhileIdle;

    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        if (maxIdle != null) jedisPoolConfig.setMaxIdle(maxIdle);
        if (minIdle != null) jedisPoolConfig.setMinIdle(minIdle);
        if (maxTotal != null) jedisPoolConfig.setMaxTotal(maxTotal);
        if (maxWaitMillis != null) jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        if (minEvictableIdleTimeMillis != null)
            jedisPoolConfig.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        if (numTestsPerEvictionRun != null) jedisPoolConfig.setNumTestsPerEvictionRun(numTestsPerEvictionRun);
        if (timeBetweenEvictionRunsMillis != null)
            jedisPoolConfig.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        if (testOnBorrow != null) jedisPoolConfig.setTestOnBorrow(testOnBorrow);
        if (testWhileIdle != null) jedisPoolConfig.setTestWhileIdle(testWhileIdle);
        return jedisPoolConfig;
    }

    /**
     * redis哨兵配置
     * @return
     */
    @Bean
    public RedisSentinelConfiguration redisSentinelConfiguration() {
        RedisSentinelConfiguration configuration = new RedisSentinelConfiguration();
        String[] host = redisNodes.split(",");
        for (String redisHost : host) {
            String[] item = redisHost.split(":");
            String ip = item[0];
            String port = item[1];
            configuration.addSentinel(new RedisNode(ip, Integer.parseInt(port)));
        }
        configuration.setMaster(master);
//        configuration.setPassword(password);
        return configuration;
    }

    /**
     * 连接redis的工厂类
     *
     * @return
     */
    @Bean
    public JedisConnectionFactory jedisConnectionFactory(
            @Qualifier("redisSentinelConfiguration") RedisSentinelConfiguration redisSentinelConfiguration,
            @Qualifier("jedisPoolConfig") JedisPoolConfig jedisPoolConfig) {
        // 构造方法中注入RedisSentinelConfiguration对象
        JedisConnectionFactory factory = new JedisConnectionFactory(redisSentinelConfiguration);
        factory.setPoolConfig(jedisPoolConfig);
//		factory.setHostName(host);
//		factory.setPort(Integer.parseInt(port));
        factory.setTimeout(Integer.parseInt(timeout));
        if (StringUtils.isNotEmpty(password))
            factory.setPassword(password);
        factory.setDatabase(Integer.parseInt(database));
        return factory;
    }

    /**
     * 配置RedisTemplate
     * 设置添加序列化器
     * key 使用string序列化器
     * value 使用Json序列化器
     * 还有一种简答的设置方式，改变defaultSerializer对象的实现。
     *
     * @return
     */
    @Bean
    public RedisTemplate<Object, Object> redisTemplate(@Qualifier("jedisConnectionFactory") RedisConnectionFactory redisConnectionFactory) {
        //StringRedisTemplate的构造方法中默认设置了stringSerializer
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        //设置开启事务
        redisTemplate.setEnableTransactionSupport(true);
      /*  //set key serializer
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        template.setKeySerializer(stringRedisSerializer);
        template.setHashKeySerializer(stringRedisSerializer);
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

        //set value serializer
//      template.setDefaultSerializer(jackson2JsonRedisSerializer);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.setHashValueSerializer(jackson2JsonRedisSerializer);

        template.setConnectionFactory(redisConnectionFactory);
        template.afterPropertiesSet();*/

        /* *//**
         * 使用Jackson2JsonRedisSerialize 替换默认序列化
         */
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
        /**
         * 设置value的序列化规则和 key的序列化规则
         */
        redisTemplate.setValueSerializer(new StringRedisSerializer(Charset.forName("UTF-8")));
        redisTemplate.setKeySerializer(new StringRedisSerializer(Charset.forName("UTF-8")));
        /*
         *   加入有关 HashValue的序列化配置
         */
        redisTemplate.setHashKeySerializer(new StringRedisSerializer(Charset.forName("UTF-8")));
        redisTemplate.setHashValueSerializer(new StringRedisSerializer(Charset.forName("UTF-8")));
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.afterPropertiesSet();

        return redisTemplate;
    }
}
