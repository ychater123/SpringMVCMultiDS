package org.o7planning.springmvcmultids.config;
 
import org.o7planning.springmvcmultids.interceptor.DataSourceIntercetor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
 
@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {
 
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
 
        // Default..
    }
 
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
 
    //
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
 
        registry.addInterceptor(new DataSourceIntercetor())//
                .addPathPatterns("/publisher/*", "/advertiser/*");
    }
 
}