package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import({CachingConfig.class
        , MysqlConfig.class
        , MethodSecurityConfig.class})
@ComponentScan(basePackages = "controller")
public class RootConfig {
}
