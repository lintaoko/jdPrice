package config;

import model.ProductId;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {
    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory cf = new JedisConnectionFactory();
        cf.setHostName("111.231.255.225");
        cf.setPassword("123456zjd");
        cf.setPort(6379);
        return cf;
    }

    @Bean
    public RedisTemplate<String, ProductId> redisTemplate(RedisConnectionFactory cf) {
        RedisTemplate<String, ProductId> redis = new RedisTemplate<>();
        redis.setConnectionFactory(cf);
        return redis;
    }
}