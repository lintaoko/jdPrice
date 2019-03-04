package info.xiantang.config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "info.xiantang")
// 日志处理和报错处理AOP
@ImportResource("classpath:myAop.xml")
public class RootConfig {




}
