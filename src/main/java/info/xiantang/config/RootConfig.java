package info.xiantang.config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "info.xiantang")
@ImportResource("classpath:myAop.xml")
public class RootConfig {




}
