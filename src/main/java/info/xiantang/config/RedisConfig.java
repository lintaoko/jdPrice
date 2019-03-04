package info.xiantang.config;

import info.xiantang.model.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
//    @Bean
//    public RedisConnectionFactory redisConnectionFactory() {
//        JedisConnectionFactory cf = new JedisConnectionFactory();
//        cf.setHostName("111.231.255.225");
//        cf.setPassword("123456zjd");
//        cf.setPort(6379);
//        return cf;
//    }
//
//    @Bean(name = "data")
//    public RedisTemplate<String, Product> redisTemplate(RedisConnectionFactory cf) {
//        RedisTemplate<String, Product> redis = new RedisTemplate<>();
//        redis.setConnectionFactory(cf);
//        // 序列化String类型的Key
//        redis.setKeySerializer(new StringRedisSerializer());
//        // 序列化JSON类型的Value
//        redis.setValueSerializer(
//                new Jackson2JsonRedisSerializer<Product>(Product.class));
//        return redis;
//    }
}
