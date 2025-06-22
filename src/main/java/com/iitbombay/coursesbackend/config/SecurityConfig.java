package com.iitbombay.coursesbackend.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
          .cors()               // ↪ use your WebMvcConfigurer’s CORS mapping
          .and()
          .csrf().disable()     // optional, if you’re using tokens or want to disable CSRF
          // … add any authorizeRequests() rules here …
          ;
        return http.build();
    }

    /**
     * (Optional) If you’d rather define CORS here than via WebMvcConfigurer,
     * Spring Security will pick this up automatically.
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration cfg = new CorsConfiguration();
        // allow your Vercel origin (and you could add more or patterns)
        cfg.setAllowedOriginPatterns(List.of("https://course-sys.vercel.app"));
        cfg.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
        cfg.setAllowCredentials(true);
        cfg.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", cfg);
        return source;
    }
}
