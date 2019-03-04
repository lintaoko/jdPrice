package info.xiantang.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
// 启用缓存
//@EnableCaching
@Import(RedisConfig.class)
public class CachingConfig {


//    @Bean(name = "cache")
//    public RedisTemplate<String, String> redisTemplate(
//            RedisConnectionFactory cf
//    ) {
//        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(cf);
//        redisTemplate.afterPropertiesSet();
//        return redisTemplate;
//    }
//
//    @Bean
//    public CacheManager cacheManager(@Qualifier("cache") RedisTemplate redisTemplate) {
//        return new RedisCacheManager(redisTemplate);
//    }
//
//    @Bean
//    public ProductService productIdService(){
//        return new ProductServiceImp();
//    }
}
