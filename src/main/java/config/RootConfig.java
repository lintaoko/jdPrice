package config;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;

@Configuration
@Import({CachingConfig.class
        , MysqlConfig.class
        , MethodSecurityConfig.class
        , WebConfig.class
        ,ResolverConifg.class})
@ComponentScan(basePackages = "controller")
public class RootConfig {




}
