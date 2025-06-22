package com.iitbombay.coursesbackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class GlobalCorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("https://course-sys.vercel.app")
                .allowedMethods("GET","POST","PUT","DELETE")
                .allowCredentials(true)
                .maxAge(3600);
    }
}
