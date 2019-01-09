package config;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;

@Configuration
@Import({CachingConfig.class
        , MysqlConfig.class
        , MethodSecurityConfig.class
        , WebConfig.class})
@ComponentScan(basePackages = "controller")
public class RootConfig {

    @Bean
    public ViewResolver cnViewResolver(){
        // 确定请求媒体类型

        return new ContentNegotiatingViewResolver();
    }

}
