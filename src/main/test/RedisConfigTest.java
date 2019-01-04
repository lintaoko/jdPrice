
import config.*;
import model.ProductId;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class RedisConfigTest {


    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Autowired
    RedisConnectionFactory redisConnectionFactory;


    @Autowired
    @Qualifier("data")
    RedisTemplate<String, ProductId> redisDataTemplate;

    @Autowired
    @Qualifier("cache")
    RedisTemplate<String, String> redisCacheTemplate;

    @Autowired
    CacheManager cacheManager;

    @Test
    public void redisConnectionFactoryShouldNotBeNull() {
        assertNotNull(redisConnectionFactory);

    }


    @Test
    public void redisTemplateShouldNotBeNull() {
        assertNotNull(redisDataTemplate);
    }

    @Test
    public void cacheManagerShouldNotBeNull() {
        assertNotNull(cacheManager);

    }
    @Test
    public void redisGreeting() {
        RedisConnection rs = redisConnectionFactory.getConnection();
        rs.set("greeting".getBytes(), "Hello World".getBytes());
        byte[] greetingBytes = rs.get("greeting".getBytes());
        String greeting = new String(greetingBytes);
        System.out.println(greeting);
        rs.del("greeting".getBytes());
        assertEquals("Hello World\n", systemOutRule.getLog());
    }

    @Test
    public void redisOpsForSetValue() {

        ProductId productId = new ProductId("1231", "sad", "sad", "dasd", "dasd");
        // 操作具有简单值的条目
        redisDataTemplate.opsForValue().set(productId.getProductId(), productId);
        ProductId s = redisDataTemplate.opsForValue().get(productId.getProductId());
        assertEquals("sad", s.getAssortment());
        redisDataTemplate.delete("1231");
    }

    //
    @Test
    public void redisOpsForSet() {
        redisDataTemplate.setKeySerializer(new StringRedisSerializer());
        int i = redisDataTemplate.opsForSet().size("jdspider:dupefilter").intValue();
        int j = redisDataTemplate.opsForZSet().size("jdspider:requests").intValue();

    }


    @Test
    public void redisOpsForList() {
        ProductId productId = new ProductId("1231", "sad", "sad", "dasd", "dasd");
        redisDataTemplate.opsForList().leftPush("cart", productId);
        redisDataTemplate.opsForList().rightPush("cart", productId);
        ProductId first = redisDataTemplate.opsForList().leftPop("cart");
        ProductId second = redisDataTemplate.opsForList().rightPop("cart");
//        System.out.println(first.getProductType());
//        System.out.println(second.getProductType());
    }

    @Test
    public void redisOpsOnSet() {
        ProductId productId = new ProductId("1231", "sad", "sad", "dasd", "dasd");
        redisDataTemplate.opsForSet().add("cart1", productId);
        redisDataTemplate.opsForSet().add("cart2", productId);
//        redisTemplate.opsForSet().remove("card1", productId);
//        System.out.println(redisTemplate.opsForSet().randomMember("card1").getImgUrl());
//        redisTemplate.delete("card1");
//        redisTemplate.delete("card2");
        BoundListOperations<String, ProductId> cart = redisDataTemplate
                .boundListOps("cart");

        cart.rightPush(productId);
        ProductId productId2 = new ProductId("121", "sd", "sd", "dsd", "dsd");
        cart.rightPush(productId2);
        redisDataTemplate.delete("cart1");
        redisDataTemplate.delete("cart2");
        redisDataTemplate.delete("cart");

    }


}
