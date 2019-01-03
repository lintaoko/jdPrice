package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import({CachingConfig.class, MysqlConfig.class, RedisConfig.class})
public class RootConfig {
}
