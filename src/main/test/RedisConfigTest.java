
import config.MysqlConfig;
import config.RedisConfig;
import config.RootConfig;
import model.ProductId;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
    RedisTemplate<String, ProductId> redisTemplate;


    @Test
    public void redisConnectionFactoryShouldNotBeNull() {
        assertNotNull(redisConnectionFactory);

    }


    @Test
    public void redisTemplateShouldNotBeNull() {
        assertNotNull(redisTemplate);
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
        redisTemplate.opsForValue().set(productId.getProductId(), productId);
        ProductId s = redisTemplate.opsForValue().get(productId.getProductId());
        assertEquals("sad", s.getAssortment());
        redisTemplate.delete("1231");
    }

    //
    @Test
    public void redisOpsForSet() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        int i = redisTemplate.opsForSet().size("jdspider:dupefilter").intValue();
        int j = redisTemplate.opsForZSet().size("jdspider:requests").intValue();

    }


    @Test
    public void redisOpsForList() {
        ProductId productId = new ProductId("1231", "sad", "sad", "dasd", "dasd");
        redisTemplate.opsForList().leftPush("cart", productId);
        redisTemplate.opsForList().rightPush("cart", productId);
        ProductId first = redisTemplate.opsForList().leftPop("cart");
        ProductId second = redisTemplate.opsForList().rightPop("cart");
//        System.out.println(first.getProductType());
//        System.out.println(second.getProductType());
    }

    @Test
    public void redisOpsOnSet() {
        ProductId productId = new ProductId("1231", "sad", "sad", "dasd", "dasd");
        redisTemplate.opsForSet().add("cart1", productId);
        redisTemplate.opsForSet().add("cart2", productId);
//        redisTemplate.opsForSet().remove("card1", productId);
//        System.out.println(redisTemplate.opsForSet().randomMember("card1").getImgUrl());
//        redisTemplate.delete("card1");
//        redisTemplate.delete("card2");
        BoundListOperations<String, ProductId> cart = redisTemplate
                .boundListOps("cart");

        cart.rightPush(productId);
        ProductId productId2 = new ProductId("121", "sd", "sd", "dsd", "dsd");
        cart.rightPush(productId2);
        redisTemplate.delete("cart1");
        redisTemplate.delete("cart2");
        redisTemplate.delete("cart");

    }


}
