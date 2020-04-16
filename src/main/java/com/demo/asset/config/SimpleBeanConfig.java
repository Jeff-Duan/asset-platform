package com.demo.asset.config;

import com.demo.asset.interceptor.AccessInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SimpleBeanConfig implements WebMvcConfigurer {

    private String[] getPathPatterns() {
        return new String[]{
                "/home/**",
                "/user/**",
                "/device/**",
        };
    }

    @Bean
    public AccessInterceptor accessInterceptor() {
        return new AccessInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(accessInterceptor()).addPathPatterns(getPathPatterns());
    }

}