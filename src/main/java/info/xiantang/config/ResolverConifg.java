package info.xiantang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Configuration
public class ResolverConifg  {

    @Bean
    public ViewResolver cnViewResolver(ContentNegotiationManager
                                               cnm) {
        ContentNegotiatingViewResolver cnvr =
                new ContentNegotiatingViewResolver();
        cnvr.setContentNegotiationManager(cnm);
        return cnvr;
    }

    @Bean
    public ViewResolver beanViewResolver() {
        // 以bean的名字来查找视图
        return new BeanNameViewResolver();
    }

    @Bean
    public View productId(){
        return new MappingJackson2JsonView();
    }

}
