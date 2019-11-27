package com.rwt.arknights.web.config;

import com.rwt.arknights.web.methodProcessor.SnakeToCamelModelAttributeMethodProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;
import java.util.Map;

@Configuration
//@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //指定了静态资源文件的位置
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
    }


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        Map<String, String> routeMap = RouteConfig.routeMap;
        for(Map.Entry<String, String> entry: routeMap.entrySet()) {
            registry.addViewController(entry.getKey()).setViewName(entry.getValue());
        }
        super.addViewControllers(registry);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(processor());
    }

    @Bean
    public SnakeToCamelModelAttributeMethodProcessor processor() {
        return new SnakeToCamelModelAttributeMethodProcessor(true);
    }



}