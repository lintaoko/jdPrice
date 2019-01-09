package config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class JdPriceWebAppInitializter
        extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        //return new Class[0];
        return new Class<?>[]{
                WebConfig.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        //return new Class[0];
        return new Class<?>[]{
                RootConfig.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        //return new String[0];
        return new String[]{"/"};
    }
}
