/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2016，所有权利保留。
 * <p>
 * 项目名：	spring-action
 * 文件名：	redisConfig.java
 * 模块说明：
 * 修改历史：
 * 2019/6/26 - seven - 创建。
 */
package com.spring.action.redis.config;

import com.spring.action.redis.pojo.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

/**
 * @author seven
 */
@Configuration
public class RedisConfig {

  /**
   * 连接池配置信息
   * spring5.0+ jdk8
   * @return
   */
  @Bean
  public JedisPoolConfig jedisPoolConfig() {
    JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
    //最大连接数
    jedisPoolConfig.setMaxTotal(100);
    // 最小空闲连接数
    jedisPoolConfig.setMinIdle(20);
    //当池内没有可用的连接时，最大等待时间
    jedisPoolConfig.setMaxWaitMillis(10000);
    //------其他属性根据需要自行添加-------------
    return jedisPoolConfig;
  }

  /**
   * 连接工厂
   * spring5.0+ jdk8
   * @param poolConfig
   * @return
   */
  @Bean
  public RedisConnectionFactory redisCF(JedisPoolConfig poolConfig) {
    //获得默认的连接池构造器
    JedisClientConfiguration clientConfig = JedisClientConfiguration.builder()
            .usePooling().poolConfig(poolConfig)
            .and()
            .readTimeout(Duration.ofMillis(30000))
            .build();

    // 单点redis
    RedisStandaloneConfiguration redisConfig =
            new RedisStandaloneConfiguration();
    // 哨兵redis
    // RedisSentinelConfiguration redisConfig = new RedisSentinelConfiguration();
    // 集群redis
    // RedisClusterConfiguration redisConfig = new RedisClusterConfiguration();
    redisConfig.setPassword(RedisPassword.of("123456"));
    //设置默认使用的数据库
    redisConfig.setDatabase(0);
    return new JedisConnectionFactory(redisConfig, clientConfig);
  }

  @Bean
  public RedisTemplate<String, Product> redisTemplate(RedisConnectionFactory cf) {
    RedisTemplate<String, Product> redis = new RedisTemplate<>();
    redis.setConnectionFactory(cf);
    return redis;
  }

  //StringRedisTemplate扩展了RedisTemplate，key和value都是String类型
  @Bean
  public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory cf) {
    return new StringRedisTemplate(cf);
  }
}
