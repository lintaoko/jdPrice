
import config.MysqlConfig;
import config.RedisConfig;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RedisConfig.class)
public class RedisConfigTest {


    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Autowired
    RedisConnectionFactory redisConnectionFactory;


    @Test
    public void redisConnectionFactoryShouldNotBeNull() {
        assertNotNull(redisConnectionFactory);

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

    // ddd
}
