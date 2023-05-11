package com.github.matheusgit11.NorthwindWithSpringBoot.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

//    public void addCorsMappings(CorsRegistry registry){
//        registry.addMapping("/**");
//    }

    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/customers/**").allowedOrigins("*").allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
