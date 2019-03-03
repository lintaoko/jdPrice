package info.xiantang.config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import info.xiantang.service.ProductIdService;
import info.xiantang.service.ProductIdServiceImp;

@Configuration
// 启用缓存
@EnableCaching
@Import(RedisConfig.class)
public class CachingConfig {


    @Bean(name = "cache")
    public RedisTemplate<String, String> redisTemplate(
            RedisConnectionFactory cf
    ) {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(cf);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    @Bean
    public CacheManager cacheManager(@Qualifier("cache") RedisTemplate redisTemplate) {
        return new RedisCacheManager(redisTemplate);
    }

    @Bean
    public ProductIdService productIdService(){
        return new ProductIdServiceImp();
    }
}
