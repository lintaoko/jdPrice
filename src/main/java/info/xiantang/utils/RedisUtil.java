package info.xiantang.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisUtil {

    @Autowired(required = true)
    private RedisTemplate redisTemplate;
    public boolean add(final String key, final String value) {
        redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection)
                    throws DataAccessException {
                connection.set(
                        redisTemplate.getStringSerializer().serialize(key),
                        redisTemplate.getStringSerializer().serialize(value));
                return true;
            }
        });
        return false;
    }
    /**
     * 添加对象
     */
    public boolean add(final String key, final Long expires, final String value) {
        redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection)
                    throws DataAccessException {
                connection.setEx(
                        redisTemplate.getStringSerializer().serialize(key),
                        expires,
                        redisTemplate.getStringSerializer().serialize(value)
                );
                return true;
            }
        });
        return false;
    }
}
