package com.example.moviehub.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrossOriginConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8080/", "https://comp30022-1g0z0um13f6fc2ab-1314940906.ap-shanghai.app.tcloudbase.com")
                .allowCredentials(true)
                .allowedHeaders("*")
                .exposedHeaders("Authorization")
                .allowedMethods(new String[]{"GET","POST","PUT","DELETE", "OPTIONS"});
    }
}
